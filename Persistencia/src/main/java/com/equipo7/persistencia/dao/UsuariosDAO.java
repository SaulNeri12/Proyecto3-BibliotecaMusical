package com.equipo7.persistencia.dao;

import com.equipo7.persistencia.conexion.Conexion;
import com.equipo7.persistencia.conexion.excepciones.ConexionException;
import com.equipo7.persistencia.dao.interfaces.IUsuariosDAO;
import com.equipo7.persistencia.entidades.FiltroBusqueda;
import com.equipo7.persistencia.entidades.Usuario;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import com.mongodb.client.model.Filters;
import excepciones.DAOException;
import org.bson.Document;

import org.bson.conversions.Bson;
import org.bson.types.ObjectId;

import java.util.*;

/**
 * Implementa las operaciones de la interfaz IUsuariosDAO
 * @author Saul Neri
 */
public class UsuariosDAO implements IUsuariosDAO {

    private static UsuariosDAO instance;
    private MongoDatabase bibliotecaMusicalBD;
    private MongoCollection<Document> usuarios;

    /**
     * Constructor privado para generación de instancia única
     * @throws ConexionException Si ocurre un error al obtener la colección de usuarios
     */
    private UsuariosDAO() throws ConexionException {
        this.bibliotecaMusicalBD = Conexion.getInstance().getBibliotecaMusicalBD();
        usuarios = bibliotecaMusicalBD.getCollection(Usuario.NOMBRE_COLLECTION);
    }

    /**
     * Obtiene la instancia única del DAO de usuarios
     * @return Instancia única del DAO
     * @throws ConexionException Si ocurre un error al tratar de obtener la instancia
     */
    public static UsuariosDAO getInstance() throws ConexionException {
        if (instance == null) {
            instance = new UsuariosDAO();
        }

        return instance;
    }

    /**
     * Convierte un Document a objeto Usuario
     * @param document Documento de la DB
     * @return Usuario mapeado
     */
    private Usuario documentoAObjeto(Document document) {
        Usuario usuario = new Usuario();

        // Mapeo del campo _id
        if (document.containsKey("_id")) {
            usuario.setId((ObjectId) document.get("_id"));
        }

        // Mapeo del campo nombre
        if (document.containsKey("nombre")) {
            usuario.setNombreUsuario(document.getString("nombre"));
        }

        // Mapeo del campo correo
        if (document.containsKey("email")) {
            usuario.setCorreoElectronico(document.getString("email"));
        }

        // Mapeo del campo contrasena
        if (document.containsKey("contrasena")) {
            usuario.setContrasena(document.getString("contrasena"));
        }

        // Mapeo del campo imagenURL (opcional)
        if (document.containsKey("imagenURL")) {
            usuario.setImagenPerfil(document.getString("imagenURL"));
        }

        // Mapeo del campo generosRestringidos (opcional)
        if (document.containsKey("generosRestringidos")) {
            List<String> generosRestringidos = (List<String>) document.get("generosRestringidos");
            usuario.setGenerosRestringidos(generosRestringidos);
            // Puedes almacenar esta lista en algún campo de Usuario, si corresponde
        }

        // Mapeo del campo fechaRegistro
        if (document.containsKey("fechaRegistro")) {
            // Convertimos la fecha de MongoDB a Instant (ya que en MongoDB es un objeto Date)
            usuario.setFechaRegistro(((java.util.Date) document.get("fechaRegistro")).toInstant());
        }

        return usuario;
    }

    @Override
    public Usuario iniciarSesion(String correoElectronico, String contrasenha) throws DAOException {

        Bson filtro = Filters.empty();

        Filters.and(filtro, Filters.eq("email", correoElectronico));
        Filters.and(filtro, Filters.eq("contrasena", contrasenha));

        Document document = this.usuarios.find(filtro).first();
        if (document == null) {
            throw new DAOException("El correo o la contrasena son incorrectos");
        }

        Usuario usuario = this.documentoAObjeto(document);

        return usuario;
    }

    @Override
    public void registrarUsuario(Usuario usuario) throws DAOException {

    }

    @Override
    public void actualizarUsuario(Usuario usuario) throws DAOException {

    }
}
