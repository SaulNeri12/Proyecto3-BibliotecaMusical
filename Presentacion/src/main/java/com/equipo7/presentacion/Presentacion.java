/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.equipo7.presentacion;

import com.equipo7.presentacion.gui.FrmPantallaPrincipal;
import com.equipo7.presentacion.gui.IniciarSesionDlg;
import com.equipo7.presentacion.gui.estilo.Estilo;
import com.equipo7.presentacion.gui.fuentes.FuentesLetra;
import com.sun.tools.javac.Main;
import java.net.URL;

/**
 *
 * @author neri
 */
public class Presentacion {

    public static void main(String[] args) {
        FuentesLetra.registrarFuentes();
        Estilo.prepararEstilo();
        
        IniciarSesionDlg form = new IniciarSesionDlg();
        form.setVisible(true);
    }
}
