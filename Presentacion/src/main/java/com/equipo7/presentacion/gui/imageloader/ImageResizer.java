/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.equipo7.presentacion.gui.imageloader;

import java.awt.Image;
import javax.swing.ImageIcon;

/**
 * Tiene funcionalidades para redimensionar imagenes de manera suave, para que
 * su redimensionamiento haga que no se pierda la calidad de imagen.
 * @author Saul Neri
 */
public class ImageResizer {

    /**
     * Redimensiona la imagen especificada.
     * @param icon Imagen
     * @param width Ancho de la imagen redimensionada deseada.
     * @param height Alto de la imagen redimensionada deseada.
     * @return Imagen redimensionada
     */
    public static ImageIcon resizeImageIcon(ImageIcon icon, int width, int height) {
        Image resizedImage = icon.getImage().getScaledInstance(width, height, Image.SCALE_SMOOTH);
        return new ImageIcon(resizedImage);
    }
}
