/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package com.equipo7.presentacion.gui.paneles;

import com.equipo7.negocio.dtos.CancionDTO;
import com.equipo7.negocio.dtos.UsuarioDTO;
import com.equipo7.presentacion.gui.PerfilUsuario;
import com.equipo7.presentacion.gui.estilo.Estilo;
import com.equipo7.presentacion.gui.imageloader.AsyncImageLoader;
import com.equipo7.presentacion.gui.imageloader.ImageResizer;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import javax.swing.ImageIcon;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;

/**
 *
 * @author neri
 */
public class CancionPanel extends javax.swing.JPanel {

    private ImageIcon imagenMiniatura;
    private JPanel imagenPanel;
    
    private UsuarioDTO usuarioDTO = PerfilUsuario.getUsuario();
    private CancionDTO cancionDTO;
    
    private static final int MINIATURA_WIDTH = 64;
    private static final int MINIATURA_HEIGHT = 64;
    
    /**
     * Creates new form CancionPanel
     * @param cancion
     */
    public CancionPanel(CancionDTO cancion) {
        initComponents();
        
        this.cancionDTO = cancion;
        
        // se cargara con la url de la imagen de portada del album...
        AsyncImageLoader.loadImageAsync(this.cancionDTO.getImagenPortadaURL(), (ImageIcon image) -> {
            SwingUtilities.invokeLater(() -> {
                imagenMiniatura = image;
                imagenMiniatura = ImageResizer.resizeImageIcon(imagenMiniatura, MINIATURA_WIDTH, MINIATURA_HEIGHT);
                actualizaMiniaturaPortada();
            });
        });
        
        // Define el panel personalizado
        imagenPanel = new JPanel() {
            @Override
            protected void paintComponent(Graphics g) {
                super.paintComponent(g); // Dibuja el fondo del panel
                if (imagenMiniatura != null) {
                    // Dibuja la imagen en las dimensiones del panel
                    g.drawImage(imagenMiniatura.getImage(), 0, 0, getWidth(), getHeight(), this);
                }
            }
        };
        
        // cambia el color del boton segun si ya esta registrada la cancion en favoritos
        this.agregarFavoritosBtn.setBackground(new Color(16, 16, 16));
        
        // Asegúrate de que imagenContainerPanel esté correctamente inicializado
        this.miniaturaContainerPanel.setLayout(new BorderLayout());  // Configura un layout si no tiene uno
        this.miniaturaContainerPanel.setPreferredSize(new Dimension(MINIATURA_WIDTH, MINIATURA_HEIGHT));
        this.miniaturaContainerPanel.setMaximumSize(new Dimension(MINIATURA_WIDTH, MINIATURA_HEIGHT));
        this.miniaturaContainerPanel.setMinimumSize(new Dimension(MINIATURA_WIDTH, MINIATURA_HEIGHT));
        
        this.imagenPanel.setPreferredSize(new Dimension(MINIATURA_WIDTH, MINIATURA_HEIGHT));
        this.imagenPanel.setMaximumSize(new Dimension(MINIATURA_WIDTH, MINIATURA_HEIGHT));
        this.imagenPanel.setMinimumSize(new Dimension(MINIATURA_WIDTH, MINIATURA_HEIGHT));
        this.miniaturaContainerPanel.revalidate();
        this.miniaturaContainerPanel.repaint();
        
        // Agrega el panel personalizado a este contenedor
        this.miniaturaContainerPanel.add(this.imagenPanel, BorderLayout.CENTER);
        this.mostrarInformacionCancion();
    }

    private void mostrarInformacionCancion() {
        this.nombreCancionLbl.setText(this.cancionDTO.getNombre());
        // TODO: MOSTRAR DESPUES
        this.autorCancionLbl.setVisible(false);
        
        if (this.usuarioDTO.cancionEnFavoritos(cancionDTO)) {
            this.agregarFavoritosBtn.setBackground(Estilo.colorPrimario);
        } else {
            this.agregarFavoritosBtn.setBackground(Estilo.colorBaseFondo);
        }
    }
    
    /**
     * 
     */
    public void toggleMarcaComoFavorito() {
        if (this.usuarioDTO.cancionEnFavoritos(cancionDTO)) {
            this.usuarioDTO.eliminarCancionDeFavoritos(cancionDTO);
            this.agregarFavoritosBtn.setBackground(Estilo.colorBaseFondo);
        } else {
            this.usuarioDTO.agregarCancionAFavoritos(cancionDTO);
            this.agregarFavoritosBtn.setBackground(Estilo.colorPrimario);
        }
    }
    
    private void actualizaMiniaturaPortada() {
        if (imagenMiniatura != null) {
            imagenPanel.repaint(); // Fuerza el redibujo del panel
        }
    }
    
    /**
     * Establece una nueva imagen para dibujar en el panel.
     *
     * @param nuevaImagen La imagen a mostrar.
     */
    public void setImagen(ImageIcon nuevaImagen) {
        this.imagenMiniatura = nuevaImagen;
        imagenPanel.repaint(); // Redibuja el panel con la nueva imagen
    }
    
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        miniaturaContainerPanel = new javax.swing.JPanel();
        nombreCancionLbl = new javax.swing.JLabel();
        autorCancionLbl = new javax.swing.JLabel();
        agregarFavoritosBtn = new javax.swing.JButton();

        addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                formMouseClicked(evt);
            }
        });

        javax.swing.GroupLayout miniaturaContainerPanelLayout = new javax.swing.GroupLayout(miniaturaContainerPanel);
        miniaturaContainerPanel.setLayout(miniaturaContainerPanelLayout);
        miniaturaContainerPanelLayout.setHorizontalGroup(
            miniaturaContainerPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 64, Short.MAX_VALUE)
        );
        miniaturaContainerPanelLayout.setVerticalGroup(
            miniaturaContainerPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 64, Short.MAX_VALUE)
        );

        nombreCancionLbl.setBackground(new java.awt.Color(255, 255, 255));
        nombreCancionLbl.setFont(new java.awt.Font("Segoe UI", 1, 15)); // NOI18N
        nombreCancionLbl.setForeground(new java.awt.Color(255, 255, 255));
        nombreCancionLbl.setText("Nombre de la cancion");

        autorCancionLbl.setText("Nombre Autor");
        autorCancionLbl.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                autorCancionLblMouseClicked(evt);
            }
        });

        agregarFavoritosBtn.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        agregarFavoritosBtn.setForeground(new java.awt.Color(255, 255, 255));
        agregarFavoritosBtn.setText("+");
        agregarFavoritosBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                agregarFavoritosBtnActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(miniaturaContainerPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(nombreCancionLbl, javax.swing.GroupLayout.PREFERRED_SIZE, 416, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(autorCancionLbl, javax.swing.GroupLayout.PREFERRED_SIZE, 306, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 137, Short.MAX_VALUE)
                .addComponent(agregarFavoritosBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 46, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(160, 160, 160))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(nombreCancionLbl, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(autorCancionLbl, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addComponent(miniaturaContainerPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
            .addGroup(layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addComponent(agregarFavoritosBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void formMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_formMouseClicked
        
    }//GEN-LAST:event_formMouseClicked

    private void autorCancionLblMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_autorCancionLblMouseClicked
       // TODO: QUE ABRA EL FRAME DE INFORMACION DE ALBUM
    }//GEN-LAST:event_autorCancionLblMouseClicked

    private void agregarFavoritosBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_agregarFavoritosBtnActionPerformed
        this.toggleMarcaComoFavorito();
    }//GEN-LAST:event_agregarFavoritosBtnActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton agregarFavoritosBtn;
    private javax.swing.JLabel autorCancionLbl;
    private javax.swing.JPanel miniaturaContainerPanel;
    private javax.swing.JLabel nombreCancionLbl;
    // End of variables declaration//GEN-END:variables
}
