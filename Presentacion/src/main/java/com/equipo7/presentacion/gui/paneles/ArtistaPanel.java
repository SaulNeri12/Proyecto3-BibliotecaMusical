package com.equipo7.presentacion.gui.paneles;

//import com.equipo7.negocio.dtos.AlbumDTO;
import com.equipo7.presentacion.gui.imageloader.AsyncImageLoader;
import com.equipo7.presentacion.gui.imageloader.ImageResizer;
import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Image;
import javax.swing.ImageIcon;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;

/**
 * Muestra la miniatura del album, el nombre del album y el de su actor.
 *
 * @author neri
 */
public class ArtistaPanel extends javax.swing.JPanel {

    private ImageIcon imagen; // Atributo para almacenar la imagen
    private JPanel imagenPanel;
    
    //private ArtistaDTO artistaDTO;
    
    private static final int MINIATURA_WIDTH = 150;
    private static final int MINIATURA_HEIGHT = 150;
    
    public ArtistaPanel() {
        initComponents();

        // se cargara con la imagen del objeto interno de artista.
        AsyncImageLoader.loadImageAsync("https://acortar.link/yimUoJ", (ImageIcon image) -> {
            SwingUtilities.invokeLater(() -> {
                imagen = image;
                imagen = ImageResizer.resizeImageIcon(imagen, MINIATURA_WIDTH, MINIATURA_HEIGHT);
                actualizaMiniaturaPortada();
            });
        });
        
        // Define el panel personalizado
        imagenPanel = new JPanel() {
            @Override
            protected void paintComponent(Graphics g) {
                super.paintComponent(g); // Dibuja el fondo del panel
                if (imagen != null) {
                    // Dibuja la imagen en las dimensiones del panel
                    g.drawImage(imagen.getImage(), 0, 0, getWidth(), getHeight(), this);
                }
            }
        };

        
        // Asegúrate de que imagenContainerPanel esté correctamente inicializado
        this.imagenContainerPanel.setLayout(new BorderLayout());  // Configura un layout si no tiene uno
        this.imagenContainerPanel.setPreferredSize(new Dimension(145,150));
        this.imagenContainerPanel.setMaximumSize(new Dimension(145,150));
        this.imagenContainerPanel.setMinimumSize(new Dimension(145,150));
        
        this.imagenPanel.setPreferredSize(new Dimension(145,150));
        this.imagenPanel.setMaximumSize(new Dimension(145,150));
        this.imagenPanel.setMinimumSize(new Dimension(145,150));
        this.imagenContainerPanel.revalidate();
        this.imagenContainerPanel.repaint();
        
        // Agrega el panel personalizado a este contenedor
        this.imagenContainerPanel.add(this.imagenPanel, BorderLayout.CENTER);
        
        
    }

    private void actualizaMiniaturaPortada() {
        if (imagen != null) {
            imagenPanel.repaint(); // Fuerza el redibujo del panel
        }
    }
    
    /**
     * Establece una nueva imagen para dibujar en el panel.
     *
     * @param nuevaImagen La imagen a mostrar.
     */
    public void setImagen(ImageIcon nuevaImagen) {
        this.imagen = nuevaImagen;
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

        imagenContainerPanel = new javax.swing.JPanel();
        nombreArtistaLbl = new javax.swing.JLabel();
        generoLbl = new javax.swing.JLabel();

        setMaximumSize(new java.awt.Dimension(150, 220));
        setMinimumSize(new java.awt.Dimension(150, 220));
        setName(""); // NOI18N
        setPreferredSize(new java.awt.Dimension(150, 220));

        imagenContainerPanel.setMaximumSize(new java.awt.Dimension(186, 145));
        imagenContainerPanel.setMinimumSize(new java.awt.Dimension(186, 145));
        imagenContainerPanel.setPreferredSize(new java.awt.Dimension(186, 145));

        javax.swing.GroupLayout imagenContainerPanelLayout = new javax.swing.GroupLayout(imagenContainerPanel);
        imagenContainerPanel.setLayout(imagenContainerPanelLayout);
        imagenContainerPanelLayout.setHorizontalGroup(
            imagenContainerPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );
        imagenContainerPanelLayout.setVerticalGroup(
            imagenContainerPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 145, Short.MAX_VALUE)
        );

        nombreArtistaLbl.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        nombreArtistaLbl.setForeground(new java.awt.Color(255, 255, 255));
        nombreArtistaLbl.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        nombreArtistaLbl.setText("Nombre del Album");
        nombreArtistaLbl.setVerticalAlignment(javax.swing.SwingConstants.TOP);

        generoLbl.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        generoLbl.setForeground(new java.awt.Color(153, 153, 153));
        generoLbl.setText("Anio de publicacion");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(imagenContainerPanel, javax.swing.GroupLayout.PREFERRED_SIZE, 138, Short.MAX_VALUE)
                    .addComponent(nombreArtistaLbl, javax.swing.GroupLayout.DEFAULT_SIZE, 138, Short.MAX_VALUE)
                    .addComponent(generoLbl, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(imagenContainerPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(nombreArtistaLbl, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(generoLbl, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel generoLbl;
    private javax.swing.JPanel imagenContainerPanel;
    private javax.swing.JLabel nombreArtistaLbl;
    // End of variables declaration//GEN-END:variables
}
