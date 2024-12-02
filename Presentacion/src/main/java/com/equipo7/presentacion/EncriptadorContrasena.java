/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.equipo7.presentacion;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

/**
 *
 * @author Saul Neri
 */
public class EncriptadorContrasena {

    /**
     * Encripta un String usando el algoritmo SHA-512.
     *
     * @param input El texto que se desea encriptar.
     * @return El hash encriptado en formato hexadecimal.
     */
    public static String encriptar(String input) {
        try {
            // Crear una instancia de MessageDigest para SHA-256
            MessageDigest digest = MessageDigest.getInstance("SHA-512");

            // Obtener el hash como un arreglo de bytes
            byte[] hashBytes = digest.digest(input.getBytes());

            // Convertir el arreglo de bytes a un string hexadecimal
            StringBuilder hexString = new StringBuilder();
            for (byte b : hashBytes) {
                // Convertir cada byte a su representación hexadecimal
                hexString.append(String.format("%02x", b));
            }

            // Retornar el hash como string hexadecimal
            return hexString.toString();
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
            return null;
        }
    }

    public static void main(String[] args) {
        // Ejemplo de uso
        String contrasena = "miContrasena123";
        String contrasenaEncriptada = encriptar(contrasena);

        System.out.println("La contraseña encriptada es: " + contrasenaEncriptada);
    }
}
