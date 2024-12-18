/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JDialog.java to edit this template
 */
package com.equipo7.presentacion.gui.filtro;

import javax.swing.DefaultListModel;
import javax.swing.SwingUtilities;

/**
 * Usado para realizar una busqueda filtrada.
 * @author neri
 */
public class FiltroAvanzadoDlg extends javax.swing.JDialog {

    private FiltroAvanzadoConfig configuracion = FiltroAvanzadoConfig.getInstance();
            
    /**
     * Creates new form FiltroAvanzadoDlg
     */
    public FiltroAvanzadoDlg(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();
        
        this.setLocationRelativeTo(null);
        
        this.prepararEstilo();
        this.cargarGenerosMusicales();
        this.cargarConfiguracionFiltro();
    }

    /**
     * Carga los ultimos ajustes de estilo del sistema
     */
    private void prepararEstilo() {
        //UIManager.put("Button.arc", 999);
        SwingUtilities.updateComponentTreeUI(this);
    }

    /**
     * Carga la configuracion del filtro de busqueda avanzado en el frame del filtro.
     */
    private void cargarConfiguracionFiltro() {
        this.mostrarAlbumesChkBox.setSelected(this.configuracion.mostrarAlbumes());
        this.mostrarArtistasChkBox.setSelected(this.configuracion.mostrarArtistas());
        this.mostrarCancionesChkBox.setSelected(this.configuracion.mostrarCanciones());
        this.busquedaTextField.setText(this.configuracion.getBusqueda());
        // TODO: Pendiente
        //this.listaGeneros.setSelectedIndex(this.listaGeneros.getModel());
    }
    
    /**
     * Guarda los cambios que se hicieron desde el filtro en el singleton de configuracion
     * del filtro avanzado.
     */
    private void guardarConfiguracionEnCierre() {
        this.configuracion.setBusqueda(this.busquedaTextField.getText());
        this.configuracion.setGenero(this.listaGeneros.getSelectedValue());
        this.configuracion.setMostrarAlbumes(this.mostrarAlbumesChkBox.isSelected());
        this.configuracion.setMostrarArtistas(this.mostrarArtistasChkBox.isSelected());
        this.configuracion.setMostrarCanciones(this.mostrarCancionesChkBox.isSelected());
    } 
    
    /**
     * Carga los generos musicales en el sistema dentro de la lista de generos del filtro.
     */
    private void cargarGenerosMusicales() {
        DefaultListModel<String> modelo = new DefaultListModel<>();
        
        // NOTE: debug, solo se mostraran las que esten en el sistema.
        modelo.addElement("Rap");
        modelo.addElement("Hip Hop");
        modelo.addElement("Regional Mexicano");
        modelo.addElement("Shoegaze");
        modelo.addElement("Pop");
        modelo.addElement("Trap");
        modelo.addElement("Electronica");
        modelo.addElement("Rock");
        modelo.addElement("Metal");
        
        this.listaGeneros.setModel(modelo);
        this.listaGeneros.repaint();
    }
    
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        nombreBusquedaLbl1 = new javax.swing.JLabel();
        jCheckBox2 = new javax.swing.JCheckBox();
        jButton2 = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();
        tituloFiltroLbl = new javax.swing.JLabel();
        nombreBusquedaLbl = new javax.swing.JLabel();
        busquedaTextField = new javax.swing.JTextField();
        generoTituloLbl = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        listaGeneros = new javax.swing.JList<>();
        visualizacionTituloLbl = new javax.swing.JLabel();
        mostrarAlbumesChkBox = new javax.swing.JCheckBox();
        mostrarArtistasChkBox = new javax.swing.JCheckBox();
        mostrarCancionesChkBox = new javax.swing.JCheckBox();
        aceptarBtn = new javax.swing.JButton();
        cancelarBtn = new javax.swing.JButton();

        nombreBusquedaLbl1.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        nombreBusquedaLbl1.setText("Nombre de la canción, album o artista");

        jCheckBox2.setText("Mostrar Albumes");
        jCheckBox2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jCheckBox2ActionPerformed(evt);
            }
        });

        jButton2.setText("jButton1");

        jButton3.setText("jButton1");

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        tituloFiltroLbl.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        tituloFiltroLbl.setForeground(new java.awt.Color(255, 255, 255));
        tituloFiltroLbl.setText("Filtro Avanzado");

        nombreBusquedaLbl.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        nombreBusquedaLbl.setForeground(new java.awt.Color(255, 255, 255));
        nombreBusquedaLbl.setText("Nombre de la canción, album o artista");

        busquedaTextField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                busquedaTextFieldActionPerformed(evt);
            }
        });

        generoTituloLbl.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        generoTituloLbl.setForeground(new java.awt.Color(255, 255, 255));
        generoTituloLbl.setText("Género");

        listaGeneros.setBorder(null);
        listaGeneros.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        listaGeneros.setForeground(new java.awt.Color(255, 255, 255));
        listaGeneros.setModel(new javax.swing.AbstractListModel<String>() {
            String[] strings = { "Item 1", "Item 2", "Item 3", "Item 4", "Item 5" };
            public int getSize() { return strings.length; }
            public String getElementAt(int i) { return strings[i]; }
        });
        jScrollPane1.setViewportView(listaGeneros);

        visualizacionTituloLbl.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        visualizacionTituloLbl.setForeground(new java.awt.Color(255, 255, 255));
        visualizacionTituloLbl.setText("Visualización de elementos");

        mostrarAlbumesChkBox.setForeground(new java.awt.Color(255, 255, 255));
        mostrarAlbumesChkBox.setText("Mostrar Albumes");
        mostrarAlbumesChkBox.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mostrarAlbumesChkBoxActionPerformed(evt);
            }
        });

        mostrarArtistasChkBox.setForeground(new java.awt.Color(255, 255, 255));
        mostrarArtistasChkBox.setText("Mostrar Artistas");
        mostrarArtistasChkBox.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mostrarArtistasChkBoxActionPerformed(evt);
            }
        });

        mostrarCancionesChkBox.setForeground(new java.awt.Color(255, 255, 255));
        mostrarCancionesChkBox.setText("Mostrar Canciones");
        mostrarCancionesChkBox.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mostrarCancionesChkBoxActionPerformed(evt);
            }
        });

        aceptarBtn.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        aceptarBtn.setForeground(new java.awt.Color(255, 255, 255));
        aceptarBtn.setText("Aceptar");
        aceptarBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                aceptarBtnActionPerformed(evt);
            }
        });

        cancelarBtn.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        cancelarBtn.setForeground(new java.awt.Color(255, 255, 255));
        cancelarBtn.setText("Cancelar");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(28, 28, 28)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(8, 8, 8)
                                .addComponent(nombreBusquedaLbl, javax.swing.GroupLayout.PREFERRED_SIZE, 326, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(busquedaTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 348, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(19, 19, 19)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(generoTituloLbl, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(64, 64, 64)
                                .addComponent(visualizacionTituloLbl, javax.swing.GroupLayout.PREFERRED_SIZE, 207, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 153, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(mostrarAlbumesChkBox, javax.swing.GroupLayout.PREFERRED_SIZE, 168, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(mostrarArtistasChkBox, javax.swing.GroupLayout.PREFERRED_SIZE, 168, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(mostrarCancionesChkBox, javax.swing.GroupLayout.PREFERRED_SIZE, 168, javax.swing.GroupLayout.PREFERRED_SIZE))))))
                .addContainerGap(17, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(cancelarBtn)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(aceptarBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 94, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(10, 10, 10))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(tituloFiltroLbl)
                        .addGap(103, 103, 103))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(tituloFiltroLbl)
                .addGap(31, 31, 31)
                .addComponent(nombreBusquedaLbl)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(busquedaTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(generoTituloLbl)
                    .addComponent(visualizacionTituloLbl))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(mostrarAlbumesChkBox)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(mostrarArtistasChkBox)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(mostrarCancionesChkBox))
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 103, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 71, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(aceptarBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cancelarBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void busquedaTextFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_busquedaTextFieldActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_busquedaTextFieldActionPerformed

    private void mostrarAlbumesChkBoxActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mostrarAlbumesChkBoxActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_mostrarAlbumesChkBoxActionPerformed

    private void jCheckBox2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jCheckBox2ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jCheckBox2ActionPerformed

    private void mostrarArtistasChkBoxActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mostrarArtistasChkBoxActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_mostrarArtistasChkBoxActionPerformed

    private void mostrarCancionesChkBoxActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mostrarCancionesChkBoxActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_mostrarCancionesChkBoxActionPerformed

    private void aceptarBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_aceptarBtnActionPerformed
        
        this.guardarConfiguracionEnCierre();
    }//GEN-LAST:event_aceptarBtnActionPerformed

    
    
    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;

                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(FiltroAvanzadoDlg.class
                    .getName()).log(java.util.logging.Level.SEVERE, null, ex);

        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(FiltroAvanzadoDlg.class
                    .getName()).log(java.util.logging.Level.SEVERE, null, ex);

        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(FiltroAvanzadoDlg.class
                    .getName()).log(java.util.logging.Level.SEVERE, null, ex);

        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(FiltroAvanzadoDlg.class
                    .getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the dialog */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                FiltroAvanzadoDlg dialog = new FiltroAvanzadoDlg(new javax.swing.JFrame(), true);
                dialog.addWindowListener(new java.awt.event.WindowAdapter() {
                    @Override
                    public void windowClosing(java.awt.event.WindowEvent e) {
                        System.exit(0);
                    }
                });
                dialog.setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton aceptarBtn;
    private javax.swing.JTextField busquedaTextField;
    private javax.swing.JButton cancelarBtn;
    private javax.swing.JLabel generoTituloLbl;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JCheckBox jCheckBox2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JList<String> listaGeneros;
    private javax.swing.JCheckBox mostrarAlbumesChkBox;
    private javax.swing.JCheckBox mostrarArtistasChkBox;
    private javax.swing.JCheckBox mostrarCancionesChkBox;
    private javax.swing.JLabel nombreBusquedaLbl;
    private javax.swing.JLabel nombreBusquedaLbl1;
    private javax.swing.JLabel tituloFiltroLbl;
    private javax.swing.JLabel visualizacionTituloLbl;
    // End of variables declaration//GEN-END:variables
}
