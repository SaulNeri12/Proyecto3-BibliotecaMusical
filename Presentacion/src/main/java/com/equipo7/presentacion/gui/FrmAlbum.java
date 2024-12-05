/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package com.equipo7.presentacion.gui;

import com.equipo7.negocio.bo.AlbumBO;
import com.equipo7.negocio.bo.ArtistaBO;
import com.equipo7.negocio.bo.interfaces.IAlbumBO;
import com.equipo7.negocio.bo.interfaces.IArtistaBO;
import com.equipo7.negocio.dtos.AlbumDTO;
import com.equipo7.negocio.dtos.ArtistaDTO;
import com.equipo7.negocio.dtos.CancionDTO;
import com.equipo7.negocio.dtos.UsuarioDTO;
import com.equipo7.negocio.excepciones.BOException;
import com.equipo7.presentacion.gui.estilo.Estilo;
import com.equipo7.presentacion.gui.imageloader.AsyncImageLoader;
import com.equipo7.presentacion.gui.imageloader.ImageResizer;
import com.equipo7.presentacion.gui.paneles.CancionAlbumPanel;
import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.Graphics;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.BoxLayout;
import javax.swing.ImageIcon;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.SwingUtilities;
import org.bson.types.ObjectId;

/**
 *
 * @author nerix
 */
public class FrmAlbum extends javax.swing.JFrame {


    private UsuarioDTO usuario = PerfilUsuario.getUsuario();
    private IArtistaBO artistaBO = ArtistaBO.getInstance();
    
    private ArtistaDTO artista;
    private AlbumDTO album;
    
    private ImageIcon imagenArtista;
    private JPanel imagenPanel;
    
    private static int MINIATURA_WIDTH = 200;
    private static int MINIATURA_HEIGHT = 170;
    
    /**
     * Creates new form FrmArtista
     * @param album
     * @param artista
     */
    public FrmAlbum(AlbumDTO album) {
        initComponents();
        this.album = album;
        
        
         // se cargara con la url de la imagen de portada del album...
        AsyncImageLoader.loadImageAsync(this.album.getImagenPortadaUrl(), (ImageIcon image) -> {
            SwingUtilities.invokeLater(() -> {
                imagenArtista = image;
                imagenArtista = ImageResizer.resizeImageIcon(imagenArtista, MINIATURA_WIDTH, MINIATURA_HEIGHT);
                actualizarPortadaAlbum();
            });
        });
        
        // Define el panel personalizado
        imagenPanel = new JPanel() {
            @Override
            protected void paintComponent(Graphics g) {
                super.paintComponent(g); // Dibuja el fondo del panel
                if (imagenArtista != null) {
                    // Dibuja la imagen en las dimensiones del panel
                    g.drawImage(imagenArtista.getImage(), 0, 0, getWidth(), getHeight(), this);
                }
            }
        };
        
        this.resultadosCancionesScrollPane.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
        this.cancionesPanel.setLayout(new BoxLayout(this.cancionesPanel, BoxLayout.Y_AXIS));
       
        // Asegúrate de que imagenContainerPanel esté correctamente inicializado
        this.imagenAlbumContainerPanel.setLayout(new BorderLayout());  // Configura un layout si no tiene uno
        this.imagenAlbumContainerPanel.setPreferredSize(new Dimension(MINIATURA_WIDTH, MINIATURA_HEIGHT));
        this.imagenAlbumContainerPanel.setMaximumSize(new Dimension(MINIATURA_WIDTH, MINIATURA_HEIGHT));
        this.imagenAlbumContainerPanel.setMinimumSize(new Dimension(MINIATURA_WIDTH, MINIATURA_HEIGHT));
        
        this.imagenPanel.setPreferredSize(new Dimension(MINIATURA_WIDTH, MINIATURA_HEIGHT));
        this.imagenPanel.setMaximumSize(new Dimension(MINIATURA_WIDTH, MINIATURA_HEIGHT));
        this.imagenPanel.setMinimumSize(new Dimension(MINIATURA_WIDTH, MINIATURA_HEIGHT));
        this.imagenAlbumContainerPanel.revalidate();
        this.imagenAlbumContainerPanel.repaint();
        
        // Agrega el panel personalizado a este contenedor
        this.imagenAlbumContainerPanel.add(this.imagenPanel, BorderLayout.CENTER);
        
        
        this.setLocationRelativeTo(null);
        this.setResizable(false);
        this.prepararEstilo();
        this.cargarInfoAlbum();
        //this.cargarResultados();
        this.actualizarBotonFavoritos();
        
    }
    
    /**
     * Carga toda la informacion del album
     */
    private void cargarInfoAlbum() {
        
        this.cancionesPanel.removeAll();
        this.cancionesPanel.revalidate();
        this.cancionesPanel.repaint();
        
        try {
            this.artista = this.artistaBO.obtenerPorId(this.album.getReferenciaArtista());
            
            int i=1;
            
            for (String nombreCancion: this.album.getCanciones()) {
                CancionDTO cancion = new CancionDTO();
                cancion.setIdAlbum(this.album.getId());
                cancion.setImagenPortadaURL(this.album.getImagenPortadaUrl());
                cancion.setNombre(nombreCancion);
                
                CancionAlbumPanel pnl = new CancionAlbumPanel(i, cancion);
                this.cancionesPanel.add(pnl);
                i++;
            }
            
            
        } catch (BOException ex) {
            Logger.getLogger(FrmAlbum.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        LocalDateTime fechaLanzamiento = LocalDateTime.ofInstant(this.album.getFechaLanzamiento(),  ZoneId.systemDefault());
        
        // carga info general
        String info = String.format("%s, %s, %d Canciones - %s",
            this.artista.getNombreArtista(),
            String.format("%d/%d/%d", fechaLanzamiento.getDayOfMonth(), fechaLanzamiento.getMonthValue(), fechaLanzamiento.getYear()),
            this.album.getCanciones().size(),
            this.album.getGeneroMusical()
        );
        
        this.infoGeneralLbl.setText(info);
        this.nombreAlbumLbl.setText(this.album.getNombre());
    }
    

    /**
     * Carga los ultimos ajustes de estilo del sistema
     */
    private void prepararEstilo() {
        //UIManager.put("Button.arc", 999);
        SwingUtilities.updateComponentTreeUI(this);
    }
    public void actualizarBotonFavoritos() {
        
        if (usuario.getAlbumesFavoritos().contains(this.album.getId())) {
            this.agregarFavoritosBtn.setText("En Tus Favoritos");
            this.agregarFavoritosBtn.setBackground(Estilo.colorBaseFondo);
        } else {
            this.agregarFavoritosBtn.setText("Agregar a Favoritos");
            this.agregarFavoritosBtn.setBackground(Estilo.colorPrimario);
        }
        
        this.agregarFavoritosBtn.revalidate();
        this.agregarFavoritosBtn.repaint();
        this.agregarFavoritosBtn.revalidate();
        this.agregarFavoritosBtn.repaint();
        
    }
    
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        volverMenuPrincipalBtn = new javax.swing.JButton();
        jPanel1 = new javax.swing.JPanel();
        imagenAlbumContainerPanel = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        infoGeneralLbl = new javax.swing.JLabel();
        nombreAlbumLbl = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        agregarFavoritosBtn = new javax.swing.JButton();
        resultadosCancionesScrollPane = new javax.swing.JScrollPane();
        cancionesPanel = new javax.swing.JPanel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        volverMenuPrincipalBtn.setBackground(new java.awt.Color(30, 30, 30));
        volverMenuPrincipalBtn.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        volverMenuPrincipalBtn.setForeground(new java.awt.Color(255, 255, 255));
        volverMenuPrincipalBtn.setText("<-");
        volverMenuPrincipalBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                volverMenuPrincipalBtnActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout imagenAlbumContainerPanelLayout = new javax.swing.GroupLayout(imagenAlbumContainerPanel);
        imagenAlbumContainerPanel.setLayout(imagenAlbumContainerPanelLayout);
        imagenAlbumContainerPanelLayout.setHorizontalGroup(
            imagenAlbumContainerPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 200, Short.MAX_VALUE)
        );
        imagenAlbumContainerPanelLayout.setVerticalGroup(
            imagenAlbumContainerPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 170, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(26, Short.MAX_VALUE)
                .addComponent(imagenAlbumContainerPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(24, 24, 24))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(29, 29, 29)
                .addComponent(imagenAlbumContainerPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        infoGeneralLbl.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        infoGeneralLbl.setForeground(new java.awt.Color(204, 204, 204));
        infoGeneralLbl.setText("Informacion general del album");

        nombreAlbumLbl.setFont(new java.awt.Font("Segoe UI", 1, 27)); // NOI18N
        nombreAlbumLbl.setForeground(new java.awt.Color(255, 255, 255));
        nombreAlbumLbl.setText("Nombre del Album");

        jLabel5.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(204, 204, 204));
        jLabel5.setText("Album");

        agregarFavoritosBtn.setText("Agregar a Favoritos");
        agregarFavoritosBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                agregarFavoritosBtnActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(nombreAlbumLbl, javax.swing.GroupLayout.PREFERRED_SIZE, 576, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(infoGeneralLbl, javax.swing.GroupLayout.PREFERRED_SIZE, 769, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(agregarFavoritosBtn)))
                .addGap(0, 0, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(19, 19, 19)
                .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(nombreAlbumLbl, javax.swing.GroupLayout.PREFERRED_SIZE, 85, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(infoGeneralLbl, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(agregarFavoritosBtn))
                .addContainerGap(25, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout cancionesPanelLayout = new javax.swing.GroupLayout(cancionesPanel);
        cancionesPanel.setLayout(cancionesPanelLayout);
        cancionesPanelLayout.setHorizontalGroup(
            cancionesPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 905, Short.MAX_VALUE)
        );
        cancionesPanelLayout.setVerticalGroup(
            cancionesPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 439, Short.MAX_VALUE)
        );

        resultadosCancionesScrollPane.setViewportView(cancionesPanel);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(resultadosCancionesScrollPane)))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(volverMenuPrincipalBtn)
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(volverMenuPrincipalBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(resultadosCancionesScrollPane)))
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void volverMenuPrincipalBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_volverMenuPrincipalBtnActionPerformed
        this.dispose();
    }//GEN-LAST:event_volverMenuPrincipalBtnActionPerformed

    private void agregarFavoritosBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_agregarFavoritosBtnActionPerformed
        if(usuario.getAlbumesFavoritos().contains(this.album.getId())){
            this.usuario.eliminarAlbumDeFavoritos(this.album.getId());
        }else{
            this.usuario.agregarAlbumAFavoritos(this.album.getId());
        }
        this.actualizarBotonFavoritos();
        
        
    }//GEN-LAST:event_agregarFavoritosBtnActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton agregarFavoritosBtn;
    private javax.swing.JPanel cancionesPanel;
    private javax.swing.JPanel imagenAlbumContainerPanel;
    private javax.swing.JLabel infoGeneralLbl;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JLabel nombreAlbumLbl;
    private javax.swing.JScrollPane resultadosCancionesScrollPane;
    private javax.swing.JButton volverMenuPrincipalBtn;
    // End of variables declaration//GEN-END:variables

    private void actualizarPortadaAlbum() {
       if (this.imagenArtista != null) {
           this.imagenPanel.repaint();
       }
    }
}
