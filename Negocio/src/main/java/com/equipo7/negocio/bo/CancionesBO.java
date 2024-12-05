/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.equipo7.negocio.bo;

import com.equipo7.negocio.bo.interfaces.ICancionesBO;
import com.equipo7.negocio.dtos.CancionDTO;
import com.equipo7.negocio.dtos.convertidor.CancionConvertidor;
import com.equipo7.negocio.excepciones.BOException;
import com.equipo7.persistencia.conexion.excepciones.ConexionException;
import com.equipo7.persistencia.dao.CancionesDAO;
import com.equipo7.persistencia.entidades.Cancion;
import excepciones.DAOException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.stream.Collectors;
import org.bson.types.ObjectId;

/**
 *
 * @author caarl
 */
public class CancionesBO implements ICancionesBO {
    
   
    private static CancionesBO instancia; // Instancia única de la clase
    private CancionesDAO cancionesDAO;

    // Constructor privado para evitar instanciación directa
    private CancionesBO() {
        try {
            this.cancionesDAO = CancionesDAO.getInstance();
        } catch (ConexionException ex) {
            Logger.getLogger(CancionesBO.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    // Método estático para obtener la instancia única
    public static synchronized CancionesBO getInstance() {
        if (instancia == null) {
            instancia = new CancionesBO();
        }
        return instancia;
    }
    
    @Override
    public List<CancionDTO> obtenerCancionesPorArtista(ObjectId idArtista) throws BOException {
        try {
            return this.cancionesDAO.obtenerCancionesPorArtista(idArtista).stream().map(CancionConvertidor::entidadADto).collect(Collectors.toList());
        } catch (DAOException ex) {
            throw new BOException(ex.getMessage());
        }
    }

    @Override
    public List<CancionDTO> obtenerCancionesPorGenero(String generoMusical) throws BOException {
        try {
            return this.cancionesDAO.obtenerCancionesPorGenero(generoMusical).stream().map(CancionConvertidor::entidadADto).collect(Collectors.toList());
        } catch (DAOException ex) {
            throw new BOException(ex.getMessage());
        }
    }

    @Override
    public List<CancionDTO> obtenerCancionesPorNombre(String nombreParcial) throws BOException {
        try {
            return this.cancionesDAO.obtenerCancionesPorNombre(nombreParcial).stream().map(CancionConvertidor::entidadADto).collect(Collectors.toList());
        } catch (DAOException ex) {
            throw new BOException(ex.getMessage());
        }
    }
    @Override
public List<String> obtenerGenerosMusicales() throws BOException {
    try {
        return this.cancionesDAO.obtenerGenerosMusicales();
    } catch (DAOException ex) {
        throw new BOException("Error al obtener géneros musicales");
    }
}
    

}