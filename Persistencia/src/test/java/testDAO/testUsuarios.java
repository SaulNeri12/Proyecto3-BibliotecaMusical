/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit5TestClass.java to edit this template
 */
package testDAO;

import com.equipo7.persistencia.conexion.Conexion;
import com.equipo7.persistencia.conexion.excepciones.ConexionException;
import com.equipo7.persistencia.dao.UsuariosDAO;
import com.equipo7.persistencia.entidades.Usuario;
import excepciones.DAOException;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Order;

/**
 *
 * @author gaspa
 */
public class testUsuarios {
    private static UsuariosDAO usuariosDAO;
    private static Conexion conexion;
    @BeforeAll
    static void setUp() throws ConexionException {
        // Configurar el DAO antes de todas las pruebas
        usuariosDAO = UsuariosDAO.getInstance();
    }

    @BeforeEach
    void limpiarBaseDeDatos() throws DAOException, ConexionException {
        // Limpiar todos los usuarios antes de cada prueba
        Conexion.getInstance().getBibliotecaMusicalBD()
                .getCollection("usuarios")
                .deleteMany(new org.bson.Document());
    }

    @Test
    @Order(1)
    void testRegistrarUsuario() throws DAOException {
        Usuario usuario = new Usuario();
        usuario.setNombreUsuario("TestUser");
        usuario.setCorreoElectronico("testuser@example.com");
        usuario.setContrasena("123456");

        assertDoesNotThrow(() -> usuariosDAO.registrarUsuario(usuario),
                "No debería lanzar excepciones al registrar un usuario válido");
    }

    @Test
    @Order(2)
    void testIniciarSesion() throws DAOException {
        // Primero, registrar un usuario
        Usuario usuario = new Usuario();
        usuario.setNombreUsuario("TestUser");
        usuario.setCorreoElectronico("testuser@example.com");
        usuario.setContrasena("123456");

        usuariosDAO.registrarUsuario(usuario);

        // Luego, intentar iniciar sesión con las credenciales correctas
        Usuario usuarioLogeado = usuariosDAO.iniciarSesion("testuser@example.com", "123456");
        assertNotNull(usuarioLogeado, "El usuario no debería ser nulo");
        assertEquals("TestUser", usuarioLogeado.getNombreUsuario(), "El nombre del usuario debería coincidir");
    }

    @Test
    @Order(3)
    void testActualizarUsuario() throws DAOException {
        // Registrar un usuario
        Usuario usuario = new Usuario();
        usuario.setNombreUsuario("TestUser");
        usuario.setCorreoElectronico("testuser@example.com");
        usuario.setContrasena("123456");

        usuariosDAO.registrarUsuario(usuario);

        // Obtener el usuario recién creado e intentar actualizarlo
        Usuario usuarioActualizado = usuariosDAO.iniciarSesion("testuser@example.com", "123456");
        usuarioActualizado.setNombreUsuario("UpdatedUser");
        usuariosDAO.actualizarUsuario(usuarioActualizado);

        // Verificar que el nombre se actualizó correctamente
        Usuario usuarioVerificado = usuariosDAO.iniciarSesion("testuser@example.com", "123456");
        assertEquals("UpdatedUser", usuarioVerificado.getNombreUsuario(),
                "El nombre del usuario debería haberse actualizado");
    }

    @Test
    @Order(4)
    void testActualizarNombreUsuario() throws DAOException {
        // Registrar un usuario
        Usuario usuario = new Usuario();
        usuario.setNombreUsuario("TestUser");
        usuario.setCorreoElectronico("testuser@example.com");
        usuario.setContrasena("123456");

        usuariosDAO.registrarUsuario(usuario);

        // Actualizar el nombre del usuario
        usuariosDAO.actualizarNombreUsuario("testuser@example.com", "NuevoNombre");

        // Verificar que el nombre se actualizó
        Usuario usuarioActualizado = usuariosDAO.iniciarSesion("testuser@example.com", "123456");
        assertEquals("NuevoNombre", usuarioActualizado.getNombreUsuario(),
                "El nombre del usuario debería haberse actualizado");
    }

    @Test
    @Order(5)
    void testActualizarContrasenhaUsuario() throws DAOException {
        // Registrar un usuario
        Usuario usuario = new Usuario();
        usuario.setNombreUsuario("TestUser");
        usuario.setCorreoElectronico("testuser@example.com");
        usuario.setContrasena("123456");

        usuariosDAO.registrarUsuario(usuario);

        // Actualizar la contraseña
        usuariosDAO.actualizarContrasenhaUsuario("testuser@example.com", "nuevaContrasena");

        // Verificar que la contraseña se actualizó
        Usuario usuarioActualizado = usuariosDAO.iniciarSesion("testuser@example.com", "nuevaContrasena");
        assertNotNull(usuarioActualizado, "El usuario debería iniciar sesión con la nueva contraseña");
    }
}
