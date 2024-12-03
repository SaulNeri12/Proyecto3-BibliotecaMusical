/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package com.equipo7.presentacion.gui;

import com.equipo7.negocio.dtos.ArtistaDTO;
import com.equipo7.negocio.dtos.UsuarioDTO;
import com.equipo7.presentacion.gui.imageloader.AsyncImageLoader;
import com.equipo7.presentacion.gui.imageloader.ImageResizer;
import com.equipo7.presentacion.gui.paneles.AlbumPanel;
import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.Graphics;
import javax.swing.BoxLayout;
import javax.swing.ImageIcon;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.SwingUtilities;

/**
 *
 * @author neri
 */
public class FrmArtista extends javax.swing.JFrame {

    private UsuarioDTO usuario = PerfilUsuario.getUsuario();
    private ArtistaDTO artista;
    
    private ImageIcon imagenArtista;
    private JPanel imagenPanel;
    
    private static int MINIATURA_WIDTH = 200;
    private static int MINIATURA_HEIGHT = 200;
    
    /**
     * Creates new form FrmArtista
     * @param artista
     */
    public FrmArtista(ArtistaDTO artista) {
        initComponents();
        
        this.artista = artista;
        
         // se cargara con la url de la imagen de portada del album...
        AsyncImageLoader.loadImageAsync(this.artista.getImagenURL(), (ImageIcon image) -> {
            SwingUtilities.invokeLater(() -> {
                imagenArtista = image;
                imagenArtista = ImageResizer.resizeImageIcon(imagenArtista, MINIATURA_WIDTH, MINIATURA_HEIGHT);
                actualizaMiniaturaPortada();
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
        
        this.infoArtistaScrollPanel.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
        //this.descripcionArtistaLbl.setSize(this.getSize());
        
        this.resultadosAlbumsPanel.setLayout(new BoxLayout(this.resultadosAlbumsPanel, BoxLayout.X_AXIS));
        this.resultadosAlbumsScrollPane.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS);
        this.resultadosAlbumsScrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_NEVER);
        this.resultadosAlbumsScrollPane.setPreferredSize(new Dimension(1020, 250));
       
        // Asegúrate de que imagenContainerPanel esté correctamente inicializado
        this.imagenContainerPanel.setLayout(new BorderLayout());  // Configura un layout si no tiene uno
        this.imagenContainerPanel.setPreferredSize(new Dimension(MINIATURA_WIDTH, MINIATURA_HEIGHT));
        this.imagenContainerPanel.setMaximumSize(new Dimension(MINIATURA_WIDTH, MINIATURA_HEIGHT));
        this.imagenContainerPanel.setMinimumSize(new Dimension(MINIATURA_WIDTH, MINIATURA_HEIGHT));
        
        this.imagenPanel.setPreferredSize(new Dimension(MINIATURA_WIDTH, MINIATURA_HEIGHT));
        this.imagenPanel.setMaximumSize(new Dimension(MINIATURA_WIDTH, MINIATURA_HEIGHT));
        this.imagenPanel.setMinimumSize(new Dimension(MINIATURA_WIDTH, MINIATURA_HEIGHT));
        this.imagenContainerPanel.revalidate();
        this.imagenContainerPanel.repaint();
        
        // Agrega el panel personalizado a este contenedor
        this.imagenContainerPanel.add(this.imagenPanel, BorderLayout.CENTER);
        
        this.setLocationRelativeTo(null);
        this.setResizable(false);
        this.prepararEstilo();
        this.cargarResultados();
        this.cargarInfoArtista();
    }
    
    private void cargarInfoArtista() {
        this.nombreArtista.setText(artista.getNombreArtista());
        this.generoMusicalLbl.setText(artista.getGeneroMusical());
        // TODO: ARREGLAR ESTO, EL TEXTO SE SALE DE LA PANTALLA
        //this.descripcionArtistaLbl.setText(artista.getDescripcion());
    }
    
    private void cargarResultados() {
        /*
        TODO: CARGAR ALBUMES DESDE REFERENCIAS DE LOS ALBUMES DEL ARTISTA
        for (int i = 0; i < 20; i++) {
            AlbumPanel pnl = new AlbumPanel();
            this.resultadosAlbumsPanel.add(pnl);
        }*/
        
        
        this.revalidate();
        this.repaint();
    }

    /**
     * Carga los ultimos ajustes de estilo del sistema
     */
    private void prepararEstilo() {
        //UIManager.put("Button.arc", 999);
        SwingUtilities.updateComponentTreeUI(this);
    }
    
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        fondoColorPanel = new javax.swing.JPanel();
        imagenContainerPanel = new javax.swing.JPanel();
        nombreArtista = new javax.swing.JLabel();
        generoMusicalLbl = new javax.swing.JLabel();
        infoArtistaScrollPanel = new javax.swing.JScrollPane();
        infoArtistaPanel = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        resultadosAlbumsScrollPane = new javax.swing.JScrollPane();
        resultadosAlbumsPanel = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        volverMenuPrincipalBtn = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        javax.swing.GroupLayout imagenContainerPanelLayout = new javax.swing.GroupLayout(imagenContainerPanel);
        imagenContainerPanel.setLayout(imagenContainerPanelLayout);
        imagenContainerPanelLayout.setHorizontalGroup(
            imagenContainerPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 200, Short.MAX_VALUE)
        );
        imagenContainerPanelLayout.setVerticalGroup(
            imagenContainerPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 199, Short.MAX_VALUE)
        );

        nombreArtista.setFont(new java.awt.Font("Segoe UI", 1, 26)); // NOI18N
        nombreArtista.setForeground(new java.awt.Color(255, 255, 255));
        nombreArtista.setText("Nombre artista");

        generoMusicalLbl.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        generoMusicalLbl.setForeground(new java.awt.Color(204, 204, 204));
        generoMusicalLbl.setText("Genero musical");

        javax.swing.GroupLayout fondoColorPanelLayout = new javax.swing.GroupLayout(fondoColorPanel);
        fondoColorPanel.setLayout(fondoColorPanelLayout);
        fondoColorPanelLayout.setHorizontalGroup(
            fondoColorPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(fondoColorPanelLayout.createSequentialGroup()
                .addGap(41, 41, 41)
                .addComponent(imagenContainerPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(fondoColorPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(nombreArtista, javax.swing.GroupLayout.DEFAULT_SIZE, 318, Short.MAX_VALUE)
                    .addComponent(generoMusicalLbl, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        fondoColorPanelLayout.setVerticalGroup(
            fondoColorPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, fondoColorPanelLayout.createSequentialGroup()
                .addGap(0, 22, Short.MAX_VALUE)
                .addComponent(imagenContainerPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addGroup(fondoColorPanelLayout.createSequentialGroup()
                .addGap(76, 76, 76)
                .addComponent(nombreArtista, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(generoMusicalLbl, javax.swing.GroupLayout.PREFERRED_SIZE, 46, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        infoArtistaScrollPanel.setBorder(null);

        jLabel2.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setText("Descripción");

        jButton1.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jButton1.setForeground(new java.awt.Color(255, 255, 255));
        jButton1.setText("Agregar a Favoritos");

        resultadosAlbumsScrollPane.setBorder(null);

        javax.swing.GroupLayout resultadosAlbumsPanelLayout = new javax.swing.GroupLayout(resultadosAlbumsPanel);
        resultadosAlbumsPanel.setLayout(resultadosAlbumsPanelLayout);
        resultadosAlbumsPanelLayout.setHorizontalGroup(
            resultadosAlbumsPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 1137, Short.MAX_VALUE)
        );
        resultadosAlbumsPanelLayout.setVerticalGroup(
            resultadosAlbumsPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 244, Short.MAX_VALUE)
        );

        resultadosAlbumsScrollPane.setViewportView(resultadosAlbumsPanel);

        jLabel3.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setText("Discografía");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 1008, Short.MAX_VALUE)
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 214, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout infoArtistaPanelLayout = new javax.swing.GroupLayout(infoArtistaPanel);
        infoArtistaPanel.setLayout(infoArtistaPanelLayout);
        infoArtistaPanelLayout.setHorizontalGroup(
            infoArtistaPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, infoArtistaPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(infoArtistaPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(infoArtistaPanelLayout.createSequentialGroup()
                        .addGroup(infoArtistaPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(resultadosAlbumsScrollPane, javax.swing.GroupLayout.DEFAULT_SIZE, 1008, Short.MAX_VALUE)
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, infoArtistaPanelLayout.createSequentialGroup()
                                .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 193, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(0, 0, Short.MAX_VALUE)))
                        .addContainerGap())
                    .addGroup(infoArtistaPanelLayout.createSequentialGroup()
                        .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 193, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 179, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(27, 27, 27))))
        );
        infoArtistaPanelLayout.setVerticalGroup(
            infoArtistaPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(infoArtistaPanelLayout.createSequentialGroup()
                .addGap(12, 12, 12)
                .addGroup(infoArtistaPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(resultadosAlbumsScrollPane, javax.swing.GroupLayout.PREFERRED_SIZE, 250, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        infoArtistaScrollPanel.setViewportView(infoArtistaPanel);

        volverMenuPrincipalBtn.setBackground(new java.awt.Color(30, 30, 30));
        volverMenuPrincipalBtn.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        volverMenuPrincipalBtn.setForeground(new java.awt.Color(255, 255, 255));
        volverMenuPrincipalBtn.setText("<-");
        volverMenuPrincipalBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                volverMenuPrincipalBtnActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(infoArtistaScrollPanel, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(fondoColorPanel, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(volverMenuPrincipalBtn)
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(14, 14, 14)
                .addComponent(volverMenuPrincipalBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(fondoColorPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(infoArtistaScrollPanel, javax.swing.GroupLayout.DEFAULT_SIZE, 584, Short.MAX_VALUE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void volverMenuPrincipalBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_volverMenuPrincipalBtnActionPerformed
        this.dispose();
    }//GEN-LAST:event_volverMenuPrincipalBtnActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel fondoColorPanel;
    private javax.swing.JLabel generoMusicalLbl;
    private javax.swing.JPanel imagenContainerPanel;
    private javax.swing.JPanel infoArtistaPanel;
    private javax.swing.JScrollPane infoArtistaScrollPanel;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JLabel nombreArtista;
    private javax.swing.JPanel resultadosAlbumsPanel;
    private javax.swing.JScrollPane resultadosAlbumsScrollPane;
    private javax.swing.JButton volverMenuPrincipalBtn;
    // End of variables declaration//GEN-END:variables

    private void actualizaMiniaturaPortada() {
        if (this.imagenArtista != null) 
            this.imagenPanel.repaint();
    }
}
