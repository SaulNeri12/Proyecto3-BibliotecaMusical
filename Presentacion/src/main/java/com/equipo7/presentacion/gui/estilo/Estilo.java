/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

package com.equipo7.presentacion.gui.estilo;

import java.awt.Color;
import javax.swing.UIManager;

/**
 * Se encarga de calar el estilo predeterminado de la aplicacion y los componentes
 * graficos de Swing
 * @author Saul Neri
 */
public class Estilo {
    
    private static Color colorBaseFondo = new Color(0x10, 0x10, 0x10);
    private static Color colorPrimario = new Color(0x94, 0x00, 0xFF);
    
    public static void prepararEstilo() {
        UIManager.put("Panel.background", colorBaseFondo);
        
        UIManager.put("Button.background",  colorPrimario);
        UIManager.put("Button.arc", 999);
        
        UIManager.put("TextArea.background",  colorBaseFondo);
        
        UIManager.put("ComboBox.background",  colorBaseFondo);
        
        UIManager.put("Table.background",  colorBaseFondo);
        
        UIManager.put("ScrollPane.background",  colorBaseFondo);
        
        UIManager.put("TextComponent.arc", 10);
        
        UIManager.put("TextField.focusBackground", colorPrimario);
        UIManager.put("PasswordField.focusBackground", colorPrimario);
        
        UIManager.put("TextField.background",  colorBaseFondo);
        UIManager.put("PasswordField.background",  colorBaseFondo);
    }
}
