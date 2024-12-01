/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.equipo7.negocio.bo;

import com.equipo7.negocio.bo.interfaces.ICancionesBO;
import com.equipo7.negocio.dtos.CancionDTO;
import com.equipo7.negocio.dtos.convertidor.CancionConvertidor;
import com.equipo7.persistencia.dao.CancionesDAO;
import com.equipo7.persistencia.entidades.Cancion;
import excepciones.DAOException;
import java.util.List;
import java.util.stream.Collectors;
import org.bson.types.ObjectId;

/**
 *
 * @author caarl
 */
public class CancionesBO implements ICancionesBO {

    @Override
    public List<CancionDTO> obtenerTodas() throws DAOException {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public List<CancionDTO> obtenerPorNombre(String nombre) throws DAOException {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public CancionDTO obtenerPorId(String id) throws DAOException {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public void agregarCancion(CancionDTO cancionDTO) throws DAOException {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public List<CancionDTO> obtenerPorGenero(String genero) throws DAOException {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public List<CancionDTO> obtenerPorAlbum(String idAlbum) throws DAOException {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    /*
    private final CancionesDAO cancionesDAO;

    public CancionesBO(CancionesDAO cancionesDAO) {
        this.cancionesDAO = cancionesDAO;
    }

    @Override
    public List<CancionDTO> obtenerTodas() throws DAOException {
        return cancionesDAO.obtenerTodasCanciones().stream()
                .map(CancionConvertidor::aDTO)
                .collect(Collectors.toList());
    }

    @Override
    public List<CancionDTO> obtenerPorNombre(String nombre) throws DAOException {
        return cancionesDAO.obtenerTodasPorNombre(nombre).stream()
                .map(CancionConvertidor::aDTO)
                .collect(Collectors.toList());
    }

    @Override
    public CancionDTO obtenerPorId(String id) throws DAOException {
        Cancion cancion = cancionesDAO.obtenerCancionPorId(new ObjectId(id));
        return CancionConvertidor.aDTO(cancion);
    }

    @Override
    public void agregarCancion(CancionDTO cancionDTO) throws DAOException {
        Cancion cancion = CancionConvertidor.aEntidad(cancionDTO);
        cancionesDAO.crearCancion(cancion);
    }

    @Override
    public List<CancionDTO> obtenerPorGenero(String genero) throws DAOException {
        return cancionesDAO.obtenerCancionesPorGenero(genero).stream()
                .map(CancionConvertidor::aDTO)
                .collect(Collectors.toList());
    }

    @Override
    public List<CancionDTO> obtenerPorAlbum(String idAlbum) throws DAOException {
        return cancionesDAO.obtenerCancionesPorAlbum(new ObjectId(idAlbum)).stream()
                .map(CancionConvertidor::aDTO)
                .collect(Collectors.toList());
    }*/
}