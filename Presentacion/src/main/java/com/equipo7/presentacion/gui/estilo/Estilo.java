/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.equipo7.presentacion.gui.estilo;

import java.awt.Color;
import javax.swing.UIManager;

/**
 * Se encarga de calar el estilo predeterminado de la aplicacion y los
 * componentes graficos de Swing
 *
 * @author Saul Neri
 */
public class Estilo {

    public static final Color colorBaseFondo = new Color(0x10, 0x10, 0x10);
    public static final Color colorPrimario = new Color(0x94, 0x00, 0xFF);

    public static void prepararEstilo() {
        UIManager.put("Panel.background", colorBaseFondo);
        UIManager.put("ScrollPane.background", colorBaseFondo);

        UIManager.put("Button.background", colorPrimario);
        UIManager.put("Button.arc", 999);

        UIManager.put("TextArea.background", colorBaseFondo);

        UIManager.put("ComboBox.background", colorBaseFondo);

        UIManager.put("Table.background", colorBaseFondo);

        UIManager.put("ScrollPane.background", colorBaseFondo);

        UIManager.put("TextComponent.arc", 10);

        UIManager.put("TextField.focus", colorPrimario);
        UIManager.put("PasswordField.focus", colorPrimario);

        UIManager.put("TextField.background", colorBaseFondo);
        UIManager.put("PasswordField.background", colorBaseFondo);

        UIManager.put("List.background", new Color(20, 20, 20)); // Fondo del JList
        UIManager.put("List.foreground", Color.WHITE);           // Texto del JList
        UIManager.put("List.selectionBackground", colorPrimario); // Fondo selección
        UIManager.put("List.selectionForeground", Color.WHITE);           // Texto selección

        UIManager.put("ScrollBar.thumb", new Color(60, 60, 60));  // Color del deslizador
        UIManager.put("ScrollBar.track", new Color(30, 30, 30));  // Fondo del ScrollBar
    }
}
