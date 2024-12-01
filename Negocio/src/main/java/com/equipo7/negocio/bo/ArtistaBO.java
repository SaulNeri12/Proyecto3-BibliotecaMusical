/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.equipo7.negocio.bo;

/**
 *
 * @author caarl
 */
import com.equipo7.negocio.dtos.ArtistaDTO;
import com.equipo7.negocio.bo.interfaces.IArtistaBO;
import com.equipo7.negocio.dtos.convertidor.ArtistaConvertidor;

import com.equipo7.persistencia.dao.interfaces.IArtistasDAO;
import com.equipo7.persistencia.dao.ArtistasDAO;

import com.equipo7.negocio.excepciones.BOException;
import com.equipo7.persistencia.conexion.excepciones.ConexionException;
import com.equipo7.persistencia.entidades.FiltroBusqueda;
import com.equipo7.persistencia.entidades.Artista;

import excepciones.DAOException;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Implementación de la lógica de negocio para artistas.
 */
public class ArtistaBO implements IArtistaBO {

    private IArtistasDAO artistasDAO;
    private static ArtistaBO instance;

    private ArtistaBO() {
        try {
            this.artistasDAO = ArtistasDAO.getInstance();
        } catch (ConexionException e) {
            System.out.println("### %s".formatted(e.getMessage()));
        }
    }

    public static ArtistaBO getInstance() {
        if (instance == null) {
            instance = new ArtistaBO();
        }

        return instance;
    }

    @Override
    public void registrarArtista(ArtistaDTO artistaDTO) throws BOException {
        try {
            Artista artista = ArtistaConvertidor.dtoAEntidad(artistaDTO);
            artistasDAO.registrar(artista);
        } catch (DAOException e) {
            throw new BOException("Error registrando artista");
        }
    }

    @Override
    public List<ArtistaDTO> obtenerArtistasPorFiltro(String filtroBusqueda) throws BOException {
        try {
            // Usar el Builder de FiltroBusqueda para inicializar la instancia
            FiltroBusqueda filtro = new FiltroBusqueda.Builder()
                    .setCoincidenciaBusqueda(filtroBusqueda) // Configurar el filtro de coincidencia
                    .build();

            // Obtener los artistas que cumplen con el filtro
            List<Artista> artistas = artistasDAO.obtenerTodosPorFiltro(filtro);

            // Convertir las entidades Artista a ArtistaDTO
            return artistas.stream()
                    .map(ArtistaConvertidor::entidadADto)
                    .collect(Collectors.toList());
        } catch (DAOException e) {
            throw new BOException("Error obteniendo artistas por filtro");
        }
    }

    @Override
    public boolean existeArtista(String nombre) throws BOException {
        return artistasDAO.artistaExiste(nombre);
    }
}
