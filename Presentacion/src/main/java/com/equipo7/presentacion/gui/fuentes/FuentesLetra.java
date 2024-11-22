/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.equipo7.presentacion.gui.fuentes;

import com.sun.tools.javac.Main;
import java.awt.Font;
import java.awt.GraphicsEnvironment;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.net.URL;

/**
 * Se encarga de cargar todas las fuentes de letra necesarias para el estilo de la
 * aplicacion
 * @author Saul Neri
 */
public class FuentesLetra {

    private static ClassLoader mainClassLoader = Main.class.getClassLoader();

    /**
     * Registra todas las fuentes de letra necesarias para la ejecucion del programa
     */
    public static void registrarFuentes() {
        // Lista de nombres de archivos de fuentes en el classpath
        String[] fontFiles = {
            "fonts/Gotham-Black.otf",
            "fonts/Gotham-Light.otf",
            "fonts/Gotham-BookItalic.otf",
            "fonts/Gotham-UltraItalic.otf"
        };

        try {
            GraphicsEnvironment ge = GraphicsEnvironment.getLocalGraphicsEnvironment();

            for (String fontFile : fontFiles) {
                InputStream fontStream = mainClassLoader.getResourceAsStream(fontFile);
                if (fontStream != null) {
                    Font customFont = Font.createFont(Font.TRUETYPE_FONT, fontStream);
                    ge.registerFont(customFont);
                    System.out.println("Fuente registrada: " + customFont.getFontName());
                } else {
                    System.out.println("No se encontró el recurso: " + fontFile);
                }
            }
        } catch (IOException | java.awt.FontFormatException e) {
            e.printStackTrace();
            System.out.println("Error al registrar las fuentes.");
        }
    }
}
