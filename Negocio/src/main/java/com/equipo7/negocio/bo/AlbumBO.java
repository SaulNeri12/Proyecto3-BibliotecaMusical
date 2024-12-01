/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.equipo7.negocio.bo;

import com.equipo7.negocio.bo.interfaces.IAlbumBO;
import com.equipo7.persistencia.dao.AlbumesDAO;
import com.equipo7.negocio.dtos.AlbumDTO;
import com.equipo7.negocio.dtos.FiltroBusquedaDTO;
import com.equipo7.negocio.dtos.convertidor.AlbumConvertidor;
import com.equipo7.negocio.dtos.convertidor.FiltroBusquedaConverter;
import com.equipo7.negocio.excepciones.BOException;
import com.equipo7.persistencia.entidades.Album;
import com.equipo7.persistencia.entidades.FiltroBusqueda;
import excepciones.DAOException;
import org.bson.types.ObjectId;

import java.util.List;
import java.util.stream.Collectors;

public class AlbumBO implements IAlbumBO {

    private static AlbumBO instancia; // Instancia única de la clase
    private final AlbumesDAO albumesDAO;

    // Constructor privado para evitar instanciación directa
    private AlbumBO() throws DAOException {
        this.albumesDAO = AlbumesDAO.getInstance();
    }

    // Método estático para obtener la instancia única
    public static synchronized AlbumBO getInstance() throws DAOException {
        if (instancia == null) {
            instancia = new AlbumBO();
        }
        return instancia;
    }

    @Override
    public List<AlbumDTO> obtenerTodos() throws BOException {
        try {
            return this.albumesDAO.obtenerTodos().stream().map(AlbumConvertidor::entidadADto).collect(Collectors.toList());
        } catch (DAOException ex) {
            throw new BOException("Error al obtener los albumes.");
        }
    }

    @Override
    public void registrar(AlbumDTO albumDTO) throws BOException {
        try {
            Album album = AlbumConvertidor.dtoAEntidad(albumDTO);
            albumesDAO.registrar(album);
        } catch (DAOException e) {
            throw new BOException("Error al registrar el álbum");
        }
    }

    // Método `actualizar` eliminado porque no existe implementación en AlbumesDAO
    @Override
    public List<AlbumDTO> obtenerTodosPorNombre(String nombreAlbum) throws BOException {
        try {
            List<Album> albumes = albumesDAO.obtenerTodos();
            return albumes.stream()
                    .map(AlbumConvertidor::entidadADto)
                    .collect(Collectors.toList());
        } catch (DAOException e) {
            throw new BOException("Error al obtener todos los álbumes");
        }
    }

    @Override
    public List<AlbumDTO> obtenerTodosPorFiltro(FiltroBusquedaDTO filtroBusquedaDTO) throws BOException {
        try {

            List<Album> albumes = albumesDAO.obtenerTodosPorFiltro(FiltroBusquedaConverter.convertToEntity(filtroBusquedaDTO));
            return albumes.stream()
                    .map(AlbumConvertidor::entidadADto)
                    .collect(Collectors.toList());
        } catch (DAOException e) {
            throw new BOException("Error al obtener álbumes por filtro: ");
        }
    }

    @Override
    public List<AlbumDTO> obtenerTodosPorArtista(String nombreArtista) throws BOException {
        try {
            List<Album> albumes = albumesDAO.obtenerTodosPorArtista(nombreArtista);
            return albumes.stream()
                    .map(AlbumConvertidor::entidadADto)
                    .collect(Collectors.toList());
        } catch (DAOException ex) {
            throw new BOException("Error al obtener álbumes por nombre de artista");
        }
    }

    @Override
    public void insercionMasiva(List<AlbumDTO> albumesLista) throws BOException {
        try {
            this.albumesDAO.insercionMasiva(
                    albumesLista.stream()
                            .map(AlbumConvertidor::dtoAEntidad) // Usando referencia a método para mayor claridad
                            .collect(Collectors.toList()) // Cerrando correctamente la llamada a collect
            );
        } catch (DAOException ex) {
            throw new BOException("Error al intentar la insercion masiva.");
        }
    }

}
