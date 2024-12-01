/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.equipo7.negocio.bo;

import com.equipo7.negocio.bo.interfaces.IAlbumBO;
import com.equipo7.persistencia.dao.AlbumesDAO;
import com.equipo7.negocio.dtos.AlbumDTO;
import com.equipo7.negocio.dtos.convertidor.AlbumConvertidor;
import com.equipo7.persistencia.entidades.Album;
import com.equipo7.persistencia.entidades.FiltroBusqueda;
import excepciones.DAOException;
import org.bson.types.ObjectId;

import java.util.List;
import java.util.stream.Collectors;

public class AlbumBO implements IAlbumBO {

    private final AlbumesDAO albumesDAO;

    public AlbumBO() throws DAOException {
        this.albumesDAO = new AlbumesDAO();
    }

    

    @Override
    public List<AlbumDTO> obtenerTodos() throws DAOException {
        try {
            List<Album> albumes = albumesDAO.obtenerTodos();
            return albumes.stream()
                    .map(AlbumConvertidor::entidadADto)
                    .collect(Collectors.toList());
        } catch (Exception e) {
            throw new DAOException("Error al obtener todos los álbumes");
        }
    }

    @Override
    public List<AlbumDTO> obtenerPorFiltro(FiltroBusqueda filtro) throws DAOException {
        try {
            
            List<Album> albumes = albumesDAO.obtenerTodosPorFiltro(filtro);
            return albumes.stream()
                    .map(AlbumConvertidor::entidadADto)
                    .collect(Collectors.toList());
        } catch (Exception e) {
            throw new DAOException("Error al obtener álbumes por filtro: " );
        }
    }

    @Override
    public void registrar(AlbumDTO albumDTO) throws DAOException {
        try {
            Album album = AlbumConvertidor.dtoAEntidad(albumDTO);
            albumesDAO.registrar(album);
        } catch (Exception e) {
            throw new DAOException("Error al registrar el álbum");
        }
    }

    // Método `actualizar` eliminado porque no existe implementación en AlbumesDAO
}
