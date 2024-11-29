package com.equipo7.persistencia.dao;

import com.equipo7.persistencia.conexion.Conexion;
import com.equipo7.persistencia.conexion.excepciones.ConexionException;
import com.equipo7.persistencia.dao.interfaces.IUsuariosDAO;
import com.equipo7.persistencia.entidades.Usuario;
import com.mongodb.MongoException;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import com.mongodb.client.model.Filters;
import com.mongodb.client.result.InsertOneResult;
import com.mongodb.client.result.UpdateResult;
import excepciones.DAOException;
import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.File;
import org.bson.Document;

import org.bson.conversions.Bson;
import org.bson.types.ObjectId;

import java.util.*;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JFileChooser;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

/**
 * Implementa las operaciones de la interfaz IUsuariosDAO
 * @author Saul Neri
 */
public class UsuariosDAO implements IUsuariosDAO {

    private static UsuariosDAO instance;
    private MongoDatabase bibliotecaMusicalBD;
    private MongoCollection<Usuario> usuarios;

    /**
     * Constructor privado para generación de instancia única
     * @throws ConexionException Si ocurre un error al obtener la colección de usuarios
     */
    private UsuariosDAO() throws ConexionException {
        this.bibliotecaMusicalBD = Conexion.getInstance().getBibliotecaMusicalBD();
        usuarios = bibliotecaMusicalBD.getCollection(Usuario.NOMBRE_COLLECTION, Usuario.class);
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

    private boolean usuarioExiste(String nombre, String correoElectronico) {

        if (nombre == null || nombre.isEmpty() || nombre.isBlank()) {
            return false;
        }

        if (correoElectronico == null || correoElectronico.isEmpty() || correoElectronico.isBlank()) {
            return false;
        }

        Bson filtroNombre = Filters.eq("nombre", nombre);
        Bson filtroCorreo = Filters.eq("email", correoElectronico);

        Bson filtro = Filters.or(filtroNombre, filtroCorreo);

        return this.usuarios.find(filtro).first() != null;
    }

    @Override
    public Usuario iniciarSesion(String correoElectronico, String contrasenha) throws DAOException {

        Bson filtro = Filters.empty();

        Filters.and(filtro, Filters.eq("email", correoElectronico));
        Filters.and(filtro, Filters.eq("contrasena", contrasenha));

        Usuario usuario = this.usuarios.find(filtro).first();
        if (usuario == null) {
            throw new DAOException("El correo o la contrasena son incorrectos");
        }

        return usuario;
    }

    @Override
    public void registrarUsuario(Usuario usuario) throws DAOException {

        if (usuario == null) {
            throw new DAOException("No se pudo crear la cuenta debido a informacion faltante");
        }

        boolean existe = this.usuarioExiste(usuario.getNombreUsuario(), usuario.getCorreoElectronico());
        if (existe) {
            throw new DAOException("Ya existe una cuenta registrada con el nombre de usuario o correo electronico dado, porfavor, escriba un nombre o correo diferente");
        }

        // si tiene un ID debe de removerse para no causar conflicto en la insercion
        if (usuario.getId() != null) {
            usuario.setId(null);
        }

        try {
            InsertOneResult resultado = this.usuarios.insertOne(usuario);

            if (resultado.getInsertedId() == null) {
                throw new DAOException("No se pudo crear la cuenta debido a un error, porfavor, intente mas tarde...");
            }

        } catch (MongoException e) {
            throw new DAOException("No se pudo crear la cuenta debido a un error, porfavor, intente mas tarde...");
        }
    }

    @Override
    public void actualizarUsuario(Usuario usuario) throws DAOException {
        if (usuario == null || usuario.getId() == null) {
            throw new DAOException("Informacion incompleta, porfavor, llene los todos los campos");
        }
        
        // Crear el filtro por ID
        Bson filtro = Filters.empty();

        Filters.and(filtro, Filters.eq("_id", usuario.getId()));
        Filters.or(filtro, Filters.eq("nombre", usuario.getNombreUsuario()));

        Document actualizacion = new Document("$set", usuario);

        try {
            UpdateResult resultado = this.usuarios.updateOne(filtro, actualizacion);

            if (resultado.getMatchedCount() == 0) {
                throw new DAOException("No se encontro la cuenta en cuestion");
            }

            if (resultado.getModifiedCount() == 0) {
                throw new DAOException("No se pudo actualizar la informacion de la cuenta, porfavor, intente mas tarde...");
            }
        } catch (MongoException e) {
            throw new DAOException("Ocurrio un error al intentar actualizar la informacion de la cuenta, porfavor, intente mas tarde...");
        }
    }

    @Override
    public void actualizarNombreUsuario(String correoElectronico, String nuevoNombre) throws DAOException {
        if (correoElectronico == null || correoElectronico.isEmpty()) {
            throw new DAOException("El correo electrónico no puede estar vacío.");
        }
        if (nuevoNombre == null || nuevoNombre.isEmpty()) {
            throw new DAOException("El nuevo nombre de usuario no puede estar vacío.");
        }

        // Crear el filtro para buscar al usuario por correo electrónico
        Bson filtro = Filters.eq("email", correoElectronico);

        // Crear el documento de actualización
        Document actualizacion = new Document("$set", new Document("nombre", nuevoNombre));

        try {
            // Actualizar el usuario
            UpdateResult resultado = this.usuarios.updateOne(filtro, actualizacion);

            if (resultado.getMatchedCount() == 0) {
                throw new DAOException("No se encontró un usuario con el correo proporcionado.");
            }

            if (resultado.getModifiedCount() == 0) {
                throw new DAOException("No se pudo actualizar el nombre de usuario. Intente más tarde.");
            }
        } catch (MongoException e) {
            throw new DAOException("Ocurrió un error al actualizar el nombre de usuario.");
        }
    }

    @Override
    public void actualizarContrasenhaUsuario(String correoElectronico, String nuevaContrasena) throws DAOException {
        if (correoElectronico == null || correoElectronico.isEmpty()) {
            throw new DAOException("El correo electrónico no puede estar vacío.");
        }
        if (nuevaContrasena == null || nuevaContrasena.isEmpty()) {
            throw new DAOException("La nueva contraseña no puede estar vacía.");
        }

        // Crear el filtro para buscar al usuario por correo electrónico
        Bson filtro = Filters.eq("email", correoElectronico);

        // Crear el documento de actualización
        Document actualizacion = new Document("$set", new Document("contrasena", nuevaContrasena));

        try {
            // Actualizar la contraseña del usuario
            UpdateResult resultado = this.usuarios.updateOne(filtro, actualizacion);

            if (resultado.getMatchedCount() == 0) {
                throw new DAOException("No se encontró un usuario con el correo proporcionado.");
            }

            if (resultado.getModifiedCount() == 0) {
                throw new DAOException("No se pudo actualizar la contraseña. Intente más tarde.");
            }
        } catch (MongoException e) {
            throw new DAOException("Ocurrió un error al actualizar la contraseña.");
        }
    }
    
    /*
    private static void seleccionarImagen(JLabel imageLabel) {
        // Crear un JFileChooser para seleccionar el archivo
        JFileChooser fileChooser = new JFileChooser();
        fileChooser.setDialogTitle("Seleccionar una imagen");
        fileChooser.setFileFilter(new javax.swing.filechooser.FileNameExtensionFilter("Imágenes", "jpg", "png", "jpeg"));

        // Mostrar el diálogo de selección
        int result = fileChooser.showOpenDialog(null);
        if (result == JFileChooser.APPROVE_OPTION) {
            File selectedFile = fileChooser.getSelectedFile();
            try {
                // Cargar la imagen seleccionada
                BufferedImage img = ImageIO.read(selectedFile);

                // Escalar la imagen para ajustarla al JLabel
                Image scaledImage = img.getScaledInstance(imageLabel.getWidth(), imageLabel.getHeight(), Image.SCALE_SMOOTH);

                // Mostrar la imagen en el JLabel
                imageLabel.setIcon(new ImageIcon(scaledImage));
            } catch (Exception ex) {
                JOptionPane.showMessageDialog(null, "Error al cargar la imagen: " + ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
            }
        }
    }*/


}