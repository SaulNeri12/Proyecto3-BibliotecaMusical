/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

package com.equipo7.persistencia.entidades;

import org.bson.Document;

/**
 * Representa la informacion de una cancion de un Album en el sistema
 * @author Saul Neri
 */
public class Cancion implements IDocumentable {

    private String nombre;
    private int minutos;
    private int segundos;

    /**
     * Constructor vacio por defecto.
     */
    public Cancion() {
        this.nombre = "";
        this.minutos = 0;
        this.segundos = 0;
    }

    /**
     * Constructor con parámetros para crear una canción con los valores proporcionados.
     *
     * @param nombre El nombre de la canción.
     * @param minutos La duración de la canción en minutos.
     * @param segundos La duración de la canción en segundos.
     */
    public Cancion(String nombre, int minutos, int segundos) {
        this.nombre = nombre;
        this.minutos = minutos;
        this.segundos = segundos;
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

    /**
     * Obtiene la duración en minutos de la canción.
     *
     * @return La duración en minutos.
     */
    public int getMinutos() {
        return minutos;
    }

    /**
     * Establece la duración en minutos de la canción.
     *
     * @param minutos La nueva duración en minutos.
     */
    public void setMinutos(int minutos) {
        this.minutos = minutos;
    }

    /**
     * Obtiene la duración en segundos de la canción.
     *
     * @return La duración en segundos.
     */
    public int getSegundos() {
        return segundos;
    }

    /**
     * Establece la duración en segundos de la canción.
     *
     * @param segundos La nueva duración en segundos.
     */
    public void setSegundos(int segundos) {
        this.segundos = segundos;
    }

    @Override
    public Document toDocument() {
        return null;
    }
}
