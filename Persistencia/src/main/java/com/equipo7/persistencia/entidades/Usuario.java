/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.equipo7.persistencia.entidades;

import org.bson.Document;
import org.bson.types.ObjectId;

import java.time.Instant;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import org.bson.codecs.pojo.annotations.BsonProperty;

/**
 * Representa la informacion de un usuario en el sistema
 *
 * @author Saul Neri
 */
public class Usuario implements IDocumentable {

    public static final String NOMBRE_COLLECTION = "usuarios";

    private ObjectId _id;
    @BsonProperty(value = "nombre")
    private String nombreUsuario;
    @BsonProperty(value = "email")
    private String correoElectronico;
    @BsonProperty(value = "contrasena")
    private String contrasena;
    @BsonProperty(value = "imagenURL")
    private String imagenPerfil;
    @BsonProperty(value = "fechaRegistro")
    private Instant fechaRegistro;
    @BsonProperty(value = "generosRestringidos")
    private List<String> generosRestringidos;
    @BsonProperty(value = "canciones_favoritas")
    private List<Cancion> cancionesFavoritas;
    @BsonProperty(value = "albumes_favoritos")
    private List<ObjectId> albumesFavoritos;
    @BsonProperty(value = "artistas_favoritos")
    private List<ObjectId> artistasFavoritos;

    /**
     * Constructor por defecto.
     */
    public Usuario() {
        this.artistasFavoritos = new ArrayList<>();
        this.albumesFavoritos = new ArrayList<>();
        this.cancionesFavoritas = new ArrayList<>();
    }

    /**
     * Constructor para crear un usuario con su ID de MongoDB
     *
     * @param _id
     */
    public Usuario(ObjectId _id) {
        super();
        this._id = _id;
    }

    /**
     * Inicializa los atributos del usuario, incluyendo la encriptación de la
     * contraseña.
     *
     * @param _id ID del documento en MongoDB.
     * @param nombreUsuario Nombre del usuario.
     * @param correoElectronico Correo electrónico del usuario.
     * @param contrasena Contraseña del usuario (será encriptada).
     * @param imagenPerfil Imagen de perfil en formato Base64 (opcional).
     */
    public Usuario(ObjectId _id, String nombreUsuario, String correoElectronico, String contrasena, String imagenPerfil) {
        super();
        this.nombreUsuario = nombreUsuario;
        this.correoElectronico = correoElectronico;
        this.contrasena = contrasena;
        this.imagenPerfil = imagenPerfil;
    }

    /**
     * Obtiene el ID de MongoBD del objeto
     *
     * @return ID de MongoDB
     */
    public ObjectId getId() {
        return this._id;
    }

    /**
     * Asigna el ID de MongoDB al objeto
     *
     * @param _id ID de MongoBD
     */
    public void setId(ObjectId _id) {
        this._id = _id;
    }

    /**
     * Obtiene el nombre de usuario.
     *
     * @return El nombre de usuario.
     */
    public String getNombreUsuario() {
        return nombreUsuario;
    }

    /**
     * Establece el nombre de usuario.
     *
     * @param nombreUsuario El nombre de usuario.
     */
    public void setNombreUsuario(String nombreUsuario) {
        this.nombreUsuario = nombreUsuario;
    }

    /**
     * Obtiene el correo electrónico del usuario.
     *
     * @return El correo electrónico del usuario.
     */
    public String getCorreoElectronico() {
        return correoElectronico;
    }

    /**
     * Establece el correo electrónico del usuario.
     *
     * @param correoElectronico El correo electrónico del usuario.
     */
    public void setCorreoElectronico(String correoElectronico) {
        this.correoElectronico = correoElectronico;
    }

    /**
     * Obtiene la contraseña encriptada del usuario.
     *
     * @return La contraseña encriptada.
     */
    public String getContrasena() {
        return contrasena;
    }

    /**
     * Establece la contraseña del usuario. La contraseña será encriptada
     * utilizando Base64.
     *
     * @param contrasena La contraseña del usuario.
     */
    public void setContrasena(String contrasena) {
        // Aquí encriptamos la contraseña antes de almacenarla
        this.contrasena = contrasena;
    }

    /**
     * Obtiene la imagen de perfil del usuario.
     *
     * @return La imagen de perfil en formato Base64, o null si no se
     * proporcionó una imagen.
     */
    public String getImagenPerfil() {
        return imagenPerfil;
    }

    /**
     * Establece la imagen de perfil del usuario.
     *
     * @param imagenPerfil La imagen de perfil en formato Base64.
     */
    public void setImagenPerfil(String imagenPerfil) {
        this.imagenPerfil = imagenPerfil;
    }

    /**
     * Obtiene la fecha de registro del usuario.
     *
     * @return La fecha de registro del usuario en formato Instant.
     */
    public Instant getFechaRegistro() {
        return fechaRegistro;
    }

    /**
     * Establece la fecha de registro del usuario.
     *
     * @param fechaRegistro La fecha de registro del usuario en formato Instant.
     */
    public void setFechaRegistro(Instant fechaRegistro) {
        this.fechaRegistro = fechaRegistro;
    }

    /**
     * Obtiene la lista de géneros restringidos del usuario.
     *
     * @return La lista de géneros restringidos.
     */
    public List<String> getGenerosRestringidos() {
        return generosRestringidos;
    }

    /**
     * Establece la lista de géneros restringidos del usuario.
     *
     * @param generosRestringidos La lista de géneros restringidos.
     */
    public void setGenerosRestringidos(List<String> generosRestringidos) {
        this.generosRestringidos = generosRestringidos;
    }

    @Override
    public Document toDocument() {

        Document doc = new Document();

        if (_id != null) {
            doc.append("_id", this._id);
        }

        // NOTE: DATOS OBLIGATORIOS, SIN ESTOS NO SE PUEDE DEVOLVER UN DOCUMENTO BSON EQUIVALENTE
        // PARA EVITAR PROBLEMAS DE INSERCION
        if (this.correoElectronico == null) {
            return null;
        } else if (this.contrasena == null) {
            return null;
        } else if (this.nombreUsuario == null) {
            return null;
        }

        doc.append("nombre", this.nombreUsuario);
        doc.append("contrasena", this.contrasena);
        doc.append("email", this.correoElectronico);
        doc.append("fechaRegistro", this.fechaRegistro);
        doc.append("generosRestringidos", this.generosRestringidos);
        doc.append("imagenURL", this.imagenPerfil);

        return doc;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Usuario { ");

        sb.append("_id=").append(_id != null ? _id.toHexString() : "No especificado").append(", ");
        sb.append("nombreUsuario='").append(nombreUsuario != null ? nombreUsuario : "No especificado").append("', ");
        sb.append("correoElectronico='").append(correoElectronico != null ? correoElectronico : "No especificado").append("', ");
        sb.append("contrasena='").append(contrasena != null ? contrasena : "No especificada").append("', ");
        sb.append("imagenPerfil='").append(imagenPerfil != null ? imagenPerfil : "No especificada").append("', ");
        sb.append("fechaRegistro=").append(fechaRegistro != null ? fechaRegistro.toString() : "No especificada");

        sb.append(" }");
        return sb.toString();
    }

    public boolean cancionEnFavoritos(Cancion cancion) {
        if (this.getCancionesFavoritas() != null) {
            boolean cancionRegistrada = this.getCancionesFavoritas()
                    .stream()
                    .filter(c -> c.getNombre().equals(cancion.getNombre()) && c.getIdAlbum().equals(cancion.getIdAlbum()))
                    .findFirst()
                    .orElse(null) != null;
            
            return cancionRegistrada;
        }
        
        return false;
    }
    
    public boolean artistaEnFavoritos(ObjectId idArtista) {
        if (this.getArtistasFavoritos() != null) {
            return this.getArtistasFavoritos().stream().allMatch(artista -> artista.equals(idArtista));
        }
        
        return false;
    } 
    
    public boolean albumEnFavoritos(ObjectId idAlbum) {
        if (this.getAlbumesFavoritos() != null) {
            return this.getAlbumesFavoritos().stream().allMatch(album -> album.equals(idAlbum));
        }
        
        return false;
    } 
    
    
    public void agregarCancionAFavoritos(Cancion cancion) {
        if (this.getCancionesFavoritas() != null) {
            boolean cancionRegistrada = this.getCancionesFavoritas()
                    .stream()
                    .filter(c -> c.getNombre().equals(cancion.getNombre()) && c.getIdAlbum().equals(cancion.getIdAlbum()))
                    .findFirst()
                    .orElse(null) != null;
            if (!cancionRegistrada) {
                this.getCancionesFavoritas().add(cancion);
            }
        }
    }

    public void agregarAlbumAFavoritos(ObjectId idAlbum) {
        if (this.getAlbumesFavoritos() != null) {
            if (!this.albumesFavoritos.contains(idAlbum)) {
                this.getAlbumesFavoritos().add(idAlbum);
            }
        }
    }

    public void agregarArtistaAFavoritos(ObjectId idArtista) {
        if (this.getArtistasFavoritos() != null) {
            if (!this.artistasFavoritos.contains(idArtista)) {
                this.getArtistasFavoritos().add(idArtista);
            }
        }
    }

    public void eliminarCancionDeFavoritos(Cancion cancion) {
        if (this.getCancionesFavoritas() != null) {
            this.getCancionesFavoritas().removeIf(c
                    -> c.getNombre().equals(cancion.getNombre())
                    && c.getIdAlbum().equals(cancion.getIdAlbum())
            );
        }
    }

    public void eliminarAlbumDeFavoritos(ObjectId idAlbum) {
        if (this.getAlbumesFavoritos() != null) {
            this.getAlbumesFavoritos().remove(idAlbum);
        }
    }

    public void eliminarArtistaDeFavoritos(ObjectId idArtista) {
        if (this.getArtistasFavoritos() != null) {
            this.getArtistasFavoritos().remove(idArtista);
        }
    }

    /**
     * @return the cancionesFavoritas
     */
    public List<Cancion> getCancionesFavoritas() {
        return cancionesFavoritas;
    }

    /**
     * @param cancionesFavoritas the cancionesFavoritas to set
     */
    public void setCancionesFavoritas(List<Cancion> cancionesFavoritas) {
        this.cancionesFavoritas = cancionesFavoritas;
    }

    /**
     * @return the albumesFavoritos
     */
    public List<ObjectId> getAlbumesFavoritos() {
        return albumesFavoritos;
    }

    /**
     * @param albumesFavoritos the albumesFavoritos to set
     */
    public void setAlbumesFavoritos(List<ObjectId> albumesFavoritos) {
        this.albumesFavoritos = albumesFavoritos;
    }

    /**
     * @return the artistasFavoritos
     */
    public List<ObjectId> getArtistasFavoritos() {
        return artistasFavoritos;
    }

    /**
     * @param artistasFavoritos the artistasFavoritos to set
     */
    public void setArtistasFavoritos(List<ObjectId> artistasFavoritos) {
        this.artistasFavoritos = artistasFavoritos;
    }

}
