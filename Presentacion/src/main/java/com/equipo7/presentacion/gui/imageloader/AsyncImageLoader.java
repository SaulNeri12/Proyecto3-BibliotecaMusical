/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

package com.equipo7.presentacion.gui.imageloader;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.function.Consumer;
import javax.swing.ImageIcon;

/**
 * Carga imagenes en la UI de manera asincrona. Permite que la aplicacion no se
 * bloquee al consultar imagenes que estan en internet.
 * @author Saul Neri
 */
public class AsyncImageLoader {

    // Pool de hilos para manejar cargas asíncronas
    private static final ExecutorService executorService = Executors.newCachedThreadPool();

    /**
     * Carga una imagen de forma asíncrona y ejecuta una acción con el resultado.
     *
     * @param urlString La URL de la imagen.
     * @param callback  Acción a ejecutar con el ImageIcon resultante.
     */
    public static void loadImageAsync(String urlString, Consumer<ImageIcon> callback) {
        executorService.submit(() -> {
            ImageIcon icon = ImageLoader.loadImageFromURL(urlString);
            callback.accept(icon);
        });
    }

    /**
     * Apaga el pool de hilos.
     */
    public static void shutdown() {
        executorService.shutdown();
    }
}
