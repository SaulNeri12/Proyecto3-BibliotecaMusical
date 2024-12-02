/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.equipo7.presentacion.gui.imageloader;

import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.URL;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.concurrent.ConcurrentHashMap;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;

/**
 * Carga imagenes con provenientes de links en internet. Las almacena en una
 * cache para que al solicitarlas de nuevo no se vuelva a realizar la carga de
 * esta desde internet, sino que la cache devuelve la imagen ya lista.
 *
 * @author Saul Neri
 */
public class ImageLoader {

    // Caché para almacenar imágenes previamente cargadas
    private static final ConcurrentHashMap<String, ImageIcon> cache = new ConcurrentHashMap<>();

    private static final HttpClient client = HttpClient.newBuilder()
            .followRedirects(HttpClient.Redirect.ALWAYS)  // Asegura que las redirecciones se sigan siempre
            .build();
    
    /**
     * Carga una imagen desde una URL y la devuelve como un ImageIcon. Si la
     * imagen ya fue cargada antes, la devuelve desde el caché.
     *
     * @param urlString La URL de la imagen.
     * @return Un ImageIcon con la imagen cargada, o null si ocurre un error.
     */
    public static ImageIcon loadImageFromURL(String urlString) {
        return cache.computeIfAbsent(urlString, (key) -> {
            try {
                // Crear la URI a partir del string
                URI uri = URI.create(urlString);

                // Crear la solicitud HTTP
                HttpRequest request = HttpRequest.newBuilder(uri)
                        .GET()
                        .build();

                // Realizar la solicitud HTTP y obtener la respuesta como un InputStream
                HttpResponse<InputStream> response = client.send(request, HttpResponse.BodyHandlers.ofInputStream());

                // Verificar que la respuesta es exitosa (código 2xx)
                if (response.statusCode() >= 200 && response.statusCode() < 300) {
                    // Leer la imagen desde el InputStream
                    Image image = ImageIO.read(response.body());

                    // Crear el ImageIcon y almacenarlo en el caché
                    return new ImageIcon(image);
                } else {
                    System.err.println("Error al cargar la imagen: Código de respuesta HTTP " + response.statusCode());
                    return null;
                }
            } catch (IOException | InterruptedException e) {
                // Manejo del error
                System.err.println("Error al cargar la imagen desde la URL: " + e.getMessage());
                return null;
            }
        });
    }

    /**
     * Limpia el caché de imágenes cargadas.
     */
    public static void clearCache() {
        cache.clear();
    }
}
