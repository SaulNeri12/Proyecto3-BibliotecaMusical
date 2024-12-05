/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.equipo7.presentacion;

import java.util.HashSet;
import java.util.Set;

/**
 *
 * @author caarl
 */
public class AppState {
    private static Set<String> generosNoDeseados = new HashSet<>();

    public static Set<String> getGenerosNoDeseados() {
        return generosNoDeseados;
    }

    public static void setGenerosNoDeseados(Set<String> generos) {
        generosNoDeseados = generos;
    }
}