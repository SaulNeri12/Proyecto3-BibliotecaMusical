/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Recursos;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import javax.swing.JFileChooser;

/**
 *
 * @author gaspa
 */
public class imageUploader {
    // Método para cargar la imagen usando JFileChooser y devolverla como arreglo de bytes
    public static byte[] loadImageWithFileChooser() {
        JFileChooser fileChooser = new JFileChooser();
        fileChooser.setDialogTitle("Selecciona una imagen");
        fileChooser.setAcceptAllFileFilterUsed(false);
        fileChooser.addChoosableFileFilter(new javax.swing.filechooser.FileNameExtensionFilter("Archivos de imagen", "jpg", "png", "gif"));

        // Mostrar el diálogo para seleccionar el archivo
        int result = fileChooser.showOpenDialog(null);
        
        if (result == JFileChooser.APPROVE_OPTION) {
            File selectedFile = fileChooser.getSelectedFile();
            System.out.println("Archivo seleccionado: " + selectedFile.getAbsolutePath());
            
            try {
                // Leer el archivo de imagen como bytes
                return Files.readAllBytes(selectedFile.toPath());
            } catch (IOException e) {
                System.out.println("Error al cargar la imagen: " + e.getMessage());
            }
        }
        return null;  // Si no se selecciona ningún archivo
    }
}
