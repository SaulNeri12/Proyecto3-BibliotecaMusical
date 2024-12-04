package com.equipo7.negocio.dtos;

import com.equipo7.persistencia.entidades.Cancion;
import java.time.Instant;
import java.util.ArrayList;
import java.util.List;
import org.bson.codecs.pojo.annotations.BsonProperty;
import org.bson.types.ObjectId;

/**
 * DTO para la entidad Usuario. Se utiliza para transferir datos del usuario
 * entre capas de la aplicación.
 */
public class UsuarioDTO {

    private String nombreUsuario;
    private String correoElectronico;
    private String imagenPerfil;
    private List<String> generosRestringidos;
    private String contrasena;
    private List<CancionDTO> cancionesFavoritas;
    private List<ObjectId> albumesFavoritos;
    private List<ObjectId> artistasFavoritos;

    /**
     * Constructor vacío. Permite crear una instancia sin inicializar los
     * campos.
     */
    public UsuarioDTO() {
        // Constructor vacío
        this.albumesFavoritos = new ArrayList<>();
        this.artistasFavoritos = new ArrayList<>();
        this.cancionesFavoritas = new ArrayList<>();
        this.generosRestringidos = new ArrayList<>();
    }

    /**
     * Constructor completo. Permite crear una instancia inicializando todos los
     * campos.
     *
     * @param nombreUsuario Nombre de usuario.
     * @param correoElectronico Correo electrónico del usuario.
     * @param contrasena Contrasena del usuario
     * @param imagenPerfil URL o representación en Base64 de la imagen de perfil
     * del usuario.
     * @param fechaRegistro Fecha y hora de registro del usuario.
     * @param generosRestringidos Lista de géneros restringidos para el usuario.
     */
    public UsuarioDTO(String nombreUsuario, String correoElectronico, String contrasena, String imagenPerfil, List<String> generosRestringidos) {
        super();
        this.nombreUsuario = nombreUsuario;
        this.correoElectronico = correoElectronico;
        this.contrasena = contrasena;
        this.imagenPerfil = imagenPerfil;

        this.generosRestringidos = generosRestringidos;
    }

    public UsuarioDTO(String nombreUsuario, String correoElectronico, String contrasena) {
        super();
        this.nombreUsuario = nombreUsuario;
        this.correoElectronico = correoElectronico;
        this.contrasena = contrasena;
    }

    public UsuarioDTO(String nombreUsuario, String correoElectronico, String imagenPerfil, String contrasena) {
        super();
        this.nombreUsuario = nombreUsuario;
        this.correoElectronico = correoElectronico;
        this.imagenPerfil = imagenPerfil;
        this.contrasena = contrasena;
    }

    /**
     * Obtiene el nombre del usuario.
     *
     * @return El nombre de usuario.
     */
    public String getNombreUsuario() {
        return nombreUsuario;
    }

    /**
     * Establece el nombre del usuario.
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
     * Obtiene la imagen de perfil del usuario.
     *
     * @return La imagen de perfil como URL o representación en Base64.
     */
    public String getImagenPerfil() {
        return imagenPerfil;
    }

    /**
     * Establece la imagen de perfil del usuario.
     *
     * @param imagenPerfil La imagen de perfil como URL o representación en
     * Base64.
     */
    public void setImagenPerfil(String imagenPerfil) {
        this.imagenPerfil = imagenPerfil;
    }

    /**
     * Obtiene la lista de géneros restringidos para el usuario.
     *
     * @return Una lista de cadenas que representan los géneros restringidos.
     */
    public List<String> getGenerosRestringidos() {
        return generosRestringidos;
    }

    /**
     * Establece la lista de géneros restringidos para el usuario.
     *
     * @param generosRestringidos Una lista de cadenas que representan los
     * géneros restringidos.
     */
    public void setGenerosRestringidos(List<String> generosRestringidos) {
        this.generosRestringidos = generosRestringidos;
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
     * Representa el objeto UsuarioDTO como una cadena. Proporciona una vista
     * legible de los datos del usuario.
     *
     * @return Una cadena que representa el objeto UsuarioDTO.
     */
    @Override
    public String toString() {
        return "UsuarioDTO{"
                + ", nombreUsuario='" + nombreUsuario + '\''
                + ", correoElectronico='" + correoElectronico + '\''
                + ", imagenPerfil='" + imagenPerfil + '\''
                + ", generosRestringidos=" + generosRestringidos
                + '}';
    }

    public void agregarCancionAFavoritos(CancionDTO cancion) {
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

    public void eliminarCancionDeFavoritos(CancionDTO cancion) {
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
    public List<CancionDTO> getCancionesFavoritas() {
        return cancionesFavoritas;
    }

    /**
     * @param cancionesFavoritas the cancionesFavoritas to set
     */
    public void setCancionesFavoritas(List<CancionDTO> cancionesFavoritas) {
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
