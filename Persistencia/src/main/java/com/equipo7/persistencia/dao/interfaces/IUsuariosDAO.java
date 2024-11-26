/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.equipo7.persistencia.dao.interfaces;

import com.equipo7.persistencia.entidades.Usuario;
import excepciones.DAOException;

/**
 * Define las operaciones necesarias para manejar usuarios en el sistema
 * @author neri
 */
public interface IUsuariosDAO {

    /**
     * Permite al usuario iniciar sesión en el sistema.
     * Este método verifica las credenciales del usuario (correo electrónico y contraseña)
     * y retorna el objeto `Usuario` correspondiente si las credenciales son válidas.
     *
     * @param correoElectronico El correo electrónico del usuario que intenta iniciar sesión.
     * @param contrasenha La contraseña del usuario encriptada para la autenticación.
     * @return El objeto `Usuario` correspondiente si las credenciales son válidas.
     * @throws DAOException Si ocurre un error durante la operación (por ejemplo, si las credenciales son incorrectas).
     */
    public Usuario iniciarSesion(String correoElectronico, String contrasenha) throws DAOException;

    /**
     * Registra un nuevo usuario en el sistema.
     * Este método recibe un objeto `Usuario` con los datos del usuario a registrar
     * y lo guarda en la base de datos.
     *
     * @param usuario El objeto `Usuario` que contiene los datos del nuevo usuario.
     * @throws DAOException Si ocurre un error durante el proceso de registro (por ejemplo, si el usuario ya existe).
     */
    public void registrarUsuario(Usuario usuario) throws DAOException;

    /**
     * Actualiza la información de un usuario existente en el sistema.
     * Este método permite modificar los detalles de un usuario, como su nombre, correo electrónico,
     * contraseña u otros datos asociados.
     * Si el usuario no existe o si ocurre un error durante la actualización, se lanza una excepción.
     *
     * @deprecated
     * @param usuario El objeto `Usuario` que contiene los datos actualizados del usuario.
     * @throws DAOException Si ocurre un error durante la actualización (por ejemplo, si no se encuentra el usuario o hay un problema de conexión a la base de datos).
     */
    public void actualizarUsuario(Usuario usuario) throws DAOException;

    /**
     * Cambia el nombre de un usuario en el sistema con uno nuevo
     * @param correoElectronico Correo electronico del dueño de la cuenta
     * @param nuevoNombre Nuevo nombre de usuario
     * @throws DAOException si ocurre un error al cambiar el nombre de usuario
     */
    public void actualizarNombreUsuario(String correoElectronico, String nuevoNombre) throws DAOException;

    /**
     * Actualiza la contraseña asociada a una cuenta en el sistema.
     *
     * @param correoElectronico el correo electrónico que identifica la cuenta del usuario. No debe ser nulo ni vacío.
     * @param nuevaContrasena la nueva contraseña que se asignará a la cuenta.
     * Debe cumplir con los requisitos de seguridad (por ejemplo, longitud mínima).
     * @throws DAOException si ocurre algún error durante el acceso a la base de datos
     * o si no se encuentra la cuenta asociada al correo electrónico.
     */
    public void actualizarContrasenhaUsuario(String correoElectronico, String nuevaContrasena) throws DAOException;
}
