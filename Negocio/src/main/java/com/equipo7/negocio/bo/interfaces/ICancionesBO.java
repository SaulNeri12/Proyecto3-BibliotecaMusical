/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.equipo7.negocio.bo.interfaces;

import com.equipo7.negocio.dtos.CancionDTO;
import com.equipo7.negocio.excepciones.BOException;
import excepciones.DAOException;
import java.util.List;
import org.bson.types.ObjectId;

/**
 *
 * @author caarl
 */
public interface ICancionesBO {
    List<CancionDTO> obtenerCancionesPorArtista(ObjectId idArtista) throws BOException;
    List<CancionDTO> obtenerCancionesPorGenero(String generoMusical) throws BOException;
    List<CancionDTO> obtenerCancionesPorNombre(String nombreParcial) throws BOException;
}