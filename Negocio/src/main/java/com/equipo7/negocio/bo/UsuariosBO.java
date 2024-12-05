package com.equipo7.negocio.bo;

import com.equipo7.negocio.bo.interfaces.IUsuariosBO;
import com.equipo7.negocio.dtos.UsuarioDTO;
import com.equipo7.negocio.dtos.convertidor.UsuarioConverter;
import com.equipo7.negocio.excepciones.BOException;
import com.equipo7.persistencia.conexion.excepciones.ConexionException;
import com.equipo7.persistencia.dao.UsuariosDAO;
import com.equipo7.persistencia.entidades.Usuario;
import excepciones.DAOException;
import java.util.logging.Level;
import java.util.logging.Logger;


/**
 * Implementa los metodos de la interfaz IUsuariosBO
 */
public class UsuariosBO implements IUsuariosBO {

    private static UsuariosBO instance;
    private UsuariosDAO usuarios;
    private UsuarioConverter convertidor;

    /**
     * Constructor privado para la creacion de la instancia unica
     */
    private UsuariosBO() {
        try {
            usuarios = UsuariosDAO.getInstance();
        } catch (ConexionException e) {
            // TODO: Mostrar mensaje de error
            throw new RuntimeException(e);
        }

        convertidor = new UsuarioConverter();
    }

    /**
     * Obtiene la instancia unica del objeto de negocio de Usuarios
     * @return instancia UsuariosBO
     */
    public static UsuariosBO getInstance() {
        if (instance == null) {
            instance = new UsuariosBO();
        }

        return instance;
    }

    @Override
    public UsuarioDTO iniciarSesion(String correoElectronico, String contrasenha) throws BOException {
        try {
            Usuario usuario = this.usuarios.iniciarSesion(correoElectronico, contrasenha);
            return convertidor.convertFromEntity(usuario);
        } catch (DAOException e) {
            throw new BOException(e.getMessage());
        }
    }

    @Override
    public void registrarUsuario(UsuarioDTO usuario) throws BOException {
        try {
            
            this.usuarios.registrarUsuario(convertidor.convertFromDTO(usuario));
        } catch (DAOException e) {
            throw new BOException(e.getMessage());
        }
    }

    @Override
    public void actualizarNombreUsuario(String correoElectronico, String nuevoNombre) throws BOException {
        try {
            this.usuarios.actualizarNombreUsuario(correoElectronico, nuevoNombre);
        } catch (DAOException e) {
            throw new BOException(e.getMessage());
        }
    }

    @Override
    public void actualizarContrasenhaUsuario(String correoElectronico, String nuevaContrasena) throws BOException {
        try {
            this.usuarios.actualizarContrasenhaUsuario(correoElectronico, nuevaContrasena);
        } catch (DAOException e) {
            throw new BOException(e.getMessage());
        }
    }

    @Override
    public void actualizarFavoritos(UsuarioDTO usuario) throws BOException {
        try {
            this.usuarios.actualizarFavoritos(convertidor.convertFromDTO(usuario));
        } catch (DAOException ex) {
            throw new BOException(ex.getMessage());
        }
    }
}
