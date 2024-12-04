package com.equipo7.negocio.bo.interfaces;

import com.equipo7.negocio.dtos.UsuarioDTO;
import com.equipo7.negocio.excepciones.BOException;

public interface IUsuariosBO {
    /**
     * Permite al usuario iniciar sesión en el sistema.
     * Este método verifica las credenciales del usuario (correo electrónico y contraseña)
     * y retorna el objeto `Usuario` correspondiente si las credenciales son válidas.
     *
     * @param correoElectronico El correo electrónico del usuario que intenta iniciar sesión.
     * @param contrasenha La contraseña del usuario encriptada para la autenticación.
     * @return El objeto `Usuario` correspondiente si las credenciales son válidas.
     * @throws BOException Si ocurre un error durante la operación (por ejemplo, si las credenciales son incorrectas).
     */
    public UsuarioDTO iniciarSesion(String correoElectronico, String contrasenha) throws BOException;

    /**
     * Registra un nuevo usuario en el sistema.
     * Este método recibe un objeto `Usuario` con los datos del usuario a registrar
     * y lo guarda en la base de datos.
     *
     * @param usuario El objeto `Usuario` que contiene los datos del nuevo usuario.
     * @throws BOException Si ocurre un error durante el proceso de registro (por ejemplo, si el usuario ya existe).
     */
    public void registrarUsuario(UsuarioDTO usuario) throws BOException;

    /**
     * Cambia el nombre de un usuario en el sistema con uno nuevo
     * @param correoElectronico Correo electronico del dueño de la cuenta
     * @param nuevoNombre Nuevo nombre de usuario
     * @throws BOException si ocurre un error al cambiar el nombre de usuario
     */
    public void actualizarNombreUsuario(String correoElectronico, String nuevoNombre) throws BOException;

    /**
     * Actualiza la contraseña asociada a una cuenta en el sistema.
     *
     * @param correoElectronico el correo electrónico que identifica la cuenta del usuario. No debe ser nulo ni vacío.
     * @param nuevaContrasena la nueva contraseña que se asignará a la cuenta.
     * Debe cumplir con los requisitos de seguridad (por ejemplo, longitud mínima).
     * @throws BOException si ocurre algún error durante el acceso a la base de datos
     * o si no se encuentra la cuenta asociada al correo electrónico.
     */
    public void actualizarContrasenhaUsuario(String correoElectronico, String nuevaContrasena) throws BOException;
    
    /**
     * Actualiza los datos guardados en la seccion de favoritos del usuario.
     * @param usuario Usuario a actualizar.
     * @throws BOException 
     */
    public void actualizarFavoritos(UsuarioDTO usuario) throws BOException;
    
}
