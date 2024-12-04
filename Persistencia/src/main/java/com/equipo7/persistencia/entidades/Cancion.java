/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

package com.equipo7.persistencia.entidades;

import org.bson.Document;
import org.bson.codecs.pojo.annotations.BsonProperty;
import org.bson.types.ObjectId;

/**
 * Representa la informacion de una cancion de un Album en el sistema
 * @author Saul Neri
 */
public class Cancion {
    
    public static final String NOMBRE_COLLECTION = "canciones";
    
    //private ObjectId _id;
    //@BsonProperty(value = "nombre")
    private String nombre;
    //@BsonProperty(value = "idAlbum")
    private ObjectId idAlbum;
    //@BsonProperty(value = "imagen_portada_album_url")
    private String imagenPortadaURL;
    

    public Cancion() {
        
    }

    /**
     * Constructor vacio por defecto.
     
    public Cancion() {
        this.nombre = "";
    }

    public Cancion(ObjectId _id) {
        this._id = _id;
    }*/
    

    /**
     * Constructor con parámetros para crear una canción con los valores proporcionados.
     *
     * @param nombre El nombre de la canción.
     * @param minutos La duración de la canción en minutos.
     * @param segundos La duración de la canción en segundos.
     */
    public Cancion(String nombre) {
        this.nombre = nombre;
    }

    public Cancion(String nombre, ObjectId idAlbum) {
        this.nombre = nombre;
        this.idAlbum = idAlbum;
    }
/*
    public ObjectId getId() {
        return _id;
    }

    public void setId(ObjectId id) {
        this._id = id;
    }
*/
    public ObjectId getIdAlbum() {
        return idAlbum;
    }

    public void setIdAlbum(ObjectId idAlbum) {
        this.idAlbum = idAlbum;
    }
    
    

    /**
     * Obtiene el nombre de la canción.
     *
     * @return El nombre de la canción.
     */
    public String getNombre() {
        return nombre;
    }

    /**
     * Establece el nombre de la canción.
     *
     * @param nombre El nuevo nombre de la canción.
     */
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }



    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Cancion { ");

        //sb.append("_id=").append(_id != null ? _id.toHexString() : "No especificado").append(", ");
        sb.append("nombre='").append(nombre != null ? nombre : "No especificado").append("', ");
        sb.append("idAlbum='").append(idAlbum != null ? idAlbum : "No especificada").append("', ");
        sb.append("urlImage=").append(this.imagenPortadaURL);

        sb.append(" }");
        return sb.toString();
    }

    /**
     * @return the imagenPortadaURL
     */
    public String getImagenPortadaURL() {
        return imagenPortadaURL;
    }

    /**
     * @param imagenPortadaURL the imagenPortadaURL to set
     */
    public void setImagenPortadaURL(String imagenPortadaURL) {
        this.imagenPortadaURL = imagenPortadaURL;
    }
    
    
    
    

}
