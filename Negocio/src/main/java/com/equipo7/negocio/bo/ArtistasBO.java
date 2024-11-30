/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.equipo7.negocio.bo;

/**
 *
 * @author caarl
 */
import com.equipo7.negocio.bo.interfaces.IArtistasBO;

import com.equipo7.negocio.dtos.ArtistaDTO;
import com.equipo7.negocio.dtos.convertidor.ArtistaConverter;

import com.equipo7.persistencia.dao.interfaces.IArtistasDAO;
import com.equipo7.persistencia.entidades.Artista;
import excepciones.DAOException;


import java.util.List;
import java.util.stream.Collectors;
import org.bson.types.ObjectId;

public class ArtistasBO implements IArtistasBO {

    private final IArtistasDAO artistasDAO;
    private final ArtistaConverter converter;

    public ArtistasBO(IArtistasDAO artistasDAO) {
        this.artistasDAO = artistasDAO;
        this.converter = new ArtistaConverter();
    }

    @Override
    public List<ArtistaDTO> obtenerTodos() throws DAOException {
        try {
            List<Artista> artistas = artistasDAO.obtenerTodos();
            return artistas.stream().map(converter::toDTO).collect(Collectors.toList());
        } catch (DAOException e) {
            throw new DAOException("Error al obtener todos los artistas");
        }
    }

    @Override
    public ArtistaDTO obtenerPorId(String id) throws DAOException {
        try {
            Artista artista = artistasDAO.obtenerPorId(new ObjectId(id));
            return converter.toDTO(artista);
        } catch (DAOException e) {
            throw new DAOException("Error al obtener el artista por ID");
        }
    }

    @Override
    public void insertar(ArtistaDTO artista) throws DAOException {
        try {
            Artista entity = converter.toEntity(artista);
            artistasDAO.insertar(entity);
        } catch (DAOException e) {
            throw new DAOException("Error al insertar el artista");
        }
    }

    @Override
    public void actualizar(ArtistaDTO artista) throws DAOException {
        try {
            Artista entity = converter.toEntity(artista);
            artistasDAO.actualizar(entity);
        } catch (DAOException e) {
            throw new DAOException("Error al actualizar el artista");
        }
    }

    @Override
    public void eliminar(String id) throws DAOException {
        try {
            artistasDAO.eliminar(new ObjectId(id));
        } catch (DAOException e) {
            throw new DAOException("Error al eliminar el artista");
        }
    }

    @Override
    public List<ArtistaDTO> buscarPorNombre(String nombre) throws DAOException {
        try {
            List<Artista> artistas = artistasDAO.obtenerTodosPorNombre(nombre);
            return artistas.stream().map(converter::toDTO).collect(Collectors.toList());
        } catch (DAOException e) {
            throw new DAOException("Error al buscar artistas por nombre");
        }
    }
}