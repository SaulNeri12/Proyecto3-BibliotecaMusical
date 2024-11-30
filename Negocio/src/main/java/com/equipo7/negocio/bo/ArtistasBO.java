/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.equipo7.negocio.bo;

/**
 *
 * @author caarl
 */
import com.equipo7.negocio.converter.ArtistaConverter;
import com.equipo7.negocio.dto.ArtistaDTO;
import com.equipo7.negocio.ibo.IArtistasBO;
import com.equipo7.persistencia.dao.interfaces.IArtistasDAO;
import com.equipo7.persistencia.entidades.Artista;
import excepciones.DAOException;
import excepciones.NegocioException;

import java.util.List;
import java.util.stream.Collectors;

public class ArtistasBO implements IArtistasBO {

    private final IArtistasDAO artistasDAO;
    private final ArtistaConverter converter;

    public ArtistasBO(IArtistasDAO artistasDAO) {
        this.artistasDAO = artistasDAO;
        this.converter = new ArtistaConverter();
    }

    @Override
    public List<ArtistaDTO> obtenerTodos() throws NegocioException {
        try {
            List<Artista> artistas = artistasDAO.obtenerTodos();
            return artistas.stream().map(converter::toDTO).collect(Collectors.toList());
        } catch (DAOException e) {
            throw new NegocioException("Error al obtener todos los artistas", e);
        }
    }

    @Override
    public ArtistaDTO obtenerPorId(String id) throws NegocioException {
        try {
            Artista artista = artistasDAO.obtenerPorId(new ObjectId(id));
            return converter.toDTO(artista);
        } catch (DAOException e) {
            throw new NegocioException("Error al obtener el artista por ID", e);
        }
    }

    @Override
    public void insertar(ArtistaDTO artista) throws NegocioException {
        try {
            Artista entity = converter.toEntity(artista);
            artistasDAO.insertar(entity);
        } catch (DAOException e) {
            throw new NegocioException("Error al insertar el artista", e);
        }
    }

    @Override
    public void actualizar(ArtistaDTO artista) throws NegocioException {
        try {
            Artista entity = converter.toEntity(artista);
            artistasDAO.actualizar(entity);
        } catch (DAOException e) {
            throw new NegocioException("Error al actualizar el artista", e);
        }
    }

    @Override
    public void eliminar(String id) throws NegocioException {
        try {
            artistasDAO.eliminar(new ObjectId(id));
        } catch (DAOException e) {
            throw new NegocioException("Error al eliminar el artista", e);
        }
    }

    @Override
    public List<ArtistaDTO> buscarPorNombre(String nombre) throws NegocioException {
        try {
            List<Artista> artistas = artistasDAO.obtenerTodosPorNombre(nombre);
            return artistas.stream().map(converter::toDTO).collect(Collectors.toList());
        } catch (DAOException e) {
            throw new NegocioException("Error al buscar artistas por nombre", e);
        }
    }
}