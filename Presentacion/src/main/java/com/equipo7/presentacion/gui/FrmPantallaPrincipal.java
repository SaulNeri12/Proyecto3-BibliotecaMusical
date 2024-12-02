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
import com.equipo7.negocio.dtos.UsuarioDTO;
import com.equipo7.negocio.excepciones.BOException;
import com.equipo7.presentacion.gui.estilo.Estilo;
import com.equipo7.presentacion.gui.filtro.FiltroAvanzadoDlg;
import com.equipo7.presentacion.gui.paneles.AlbumPanel;
import com.equipo7.presentacion.gui.paneles.ArtistaPanel;
import com.equipo7.presentacion.gui.paneles.CancionPanel;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.border.LineBorder;

/**
 *
 * @author neri
 */
public class FrmPantallaPrincipal extends javax.swing.JFrame {

    private UsuarioDTO usuario;
    private JFrame _this;
    
    private IAlbumBO albumBO = AlbumBO.getInstance();
    private IArtistaBO artistaBO = ArtistaBO.getInstance();
    
    /**
     * Creates new form FrmPantallaPrincipal
     */
    public FrmPantallaPrincipal(UsuarioDTO usuario)  {
        initComponents();
        
        _this = this; // ????
        
        this.usuario = usuario;
        
        this.setLocationRelativeTo(null);
        this.setTitle("Biblioteca Musical");
        
        this.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE); // Deshabilitar el cierre predeterminado

        // Añadir un WindowListener para gestionar el cierre
        this.addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                int confirm = JOptionPane.showConfirmDialog(
                        _this,
                        "¿Estás seguro de que quieres salir?",
                        "Confirmar salida",
                        JOptionPane.YES_NO_OPTION,
                        JOptionPane.QUESTION_MESSAGE
                );

                if (confirm == JOptionPane.YES_OPTION) {
                    _this.dispose(); // Cierra el frame si se confirma
                }
            }
        });
        
        // NOTE: NO MODIFICAR
        this.resultadosArtistasPanel.setLayout(new BoxLayout(this.resultadosArtistasPanel, BoxLayout.X_AXIS));
        this.resultadosArtistasScrollPane.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS);
        this.resultadosArtistasScrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_NEVER);
        this.resultadosArtistasScrollPane.setPreferredSize(new Dimension(1100, 250));
        
        // NOTE: NO MODIFICAR
        this.resultadosAlbumsPanel.setLayout(new BoxLayout(this.resultadosAlbumsPanel, BoxLayout.X_AXIS));
        this.resultadosAlbumsScrollPane.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS);
        this.resultadosAlbumsScrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_NEVER);
        this.resultadosAlbumsScrollPane.setPreferredSize(new Dimension(1100, 250));
        
        this.resultadosCancionesPanel.setLayout(new BoxLayout(this.resultadosCancionesPanel, BoxLayout.Y_AXIS));
        this.cancionesScrollPane.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
        this.cancionesScrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
        this.cancionesScrollPane.setPreferredSize(new Dimension(1100, 64));
        
        this.cargarResultados();
        
    }
    
    private void cargarResultados() {
        
        try {
            // cargar artistas:
            for (ArtistaDTO artista: this.artistaBO.obtenerTodos()) {
                ArtistaPanel panel = new ArtistaPanel(artista);
                this.resultadosArtistasPanel.add(panel);
            }
            
        } catch (BOException ex) {
            Logger.getLogger(FrmPantallaPrincipal.class.getName()).log(Level.SEVERE, null, ex);
        }
        
         try {
            // cargar artistas:
            for (AlbumDTO album: this.albumBO.obtenerTodos()) {
                AlbumPanel panel = new AlbumPanel(album);
                this.resultadosAlbumsPanel.add(panel);
            }
            
        } catch (BOException ex) {
            Logger.getLogger(FrmPantallaPrincipal.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        /*
        for (int i = 0; i < 20; i++) {
            ArtistaPanel pnl = new ArtistaPanel();
            this.resultadosArtistasPanel.add(pnl);
            this.resultadosArtistasPanel.add(Box.createRigidArea(new Dimension(10, 0))); // espacio
        }*/

        /*
        this.resultadosArtistasPanel.revalidate();
        this.resultadosArtistasPanel.repaint();
        this.resultadosArtistasScrollPane.revalidate();
        this.resultadosArtistasScrollPane.repaint();

        
        for (int i = 0; i < 20; i++) {
            AlbumPanel pnl = new AlbumPanel();
            this.resultadosAlbumsPanel.add(pnl);
        }
        
        for (int i = 0; i < 20; i++) {
            CancionPanel pnl = new CancionPanel();
            this.resultadosCancionesPanel.add(pnl);
        }
        
        
        
        this.resultadosAlbumsPanel.revalidate();
        this.resultadosAlbumsPanel.repaint();
        this.resultadosAlbumsScrollPane.revalidate();
        this.resultadosAlbumsScrollPane.repaint();*/
        
        this.revalidate();
        this.repaint();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        favoritosScrollPane = new javax.swing.JScrollPane();
        misFavoritosPanel = new javax.swing.JPanel();
        jPanel1 = new javax.swing.JPanel();
        barraBusquedaTextField = new javax.swing.JTextField();
        busquedaFiltradaBtn = new javax.swing.JButton();
        verPerfilBtn = new javax.swing.JButton();
        jPanel2 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        resultadosArtistasScrollPane = new javax.swing.JScrollPane();
        resultadosArtistasPanel = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        resultadosAlbumsScrollPane = new javax.swing.JScrollPane();
        resultadosAlbumsPanel = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
        cancionesScrollPane = new javax.swing.JScrollPane();
        resultadosCancionesPanel = new javax.swing.JPanel();
        jLabel4 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        favoritosScrollPane.setBorder(null);

        javax.swing.GroupLayout misFavoritosPanelLayout = new javax.swing.GroupLayout(misFavoritosPanel);
        misFavoritosPanel.setLayout(misFavoritosPanelLayout);
        misFavoritosPanelLayout.setHorizontalGroup(
            misFavoritosPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 255, Short.MAX_VALUE)
        );
        misFavoritosPanelLayout.setVerticalGroup(
            misFavoritosPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 911, Short.MAX_VALUE)
        );

        favoritosScrollPane.setViewportView(misFavoritosPanel);

        barraBusquedaTextField.setText("¿Que quieres buscar?");
        barraBusquedaTextField.setSelectionColor(new java.awt.Color(202, 91, 255));

        busquedaFiltradaBtn.setText("Busqueda Avanzada");
        busquedaFiltradaBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                busquedaFiltradaBtnActionPerformed(evt);
            }
        });

        verPerfilBtn.setText("Perfil");
        verPerfilBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                verPerfilBtnActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(493, Short.MAX_VALUE)
                .addComponent(barraBusquedaTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 334, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(busquedaFiltradaBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 154, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(221, 221, 221)
                .addComponent(verPerfilBtn)
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(barraBusquedaTextField, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 43, Short.MAX_VALUE)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(verPerfilBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addComponent(busquedaFiltradaBtn, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );

        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("Mis Favoritos");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(15, 15, 15)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 124, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addComponent(jLabel1)
                .addGap(0, 33, Short.MAX_VALUE))
        );

        resultadosArtistasScrollPane.setBorder(null);
        resultadosArtistasScrollPane.setMaximumSize(new java.awt.Dimension(400, 250));
        resultadosArtistasScrollPane.setMinimumSize(new java.awt.Dimension(400, 250));
        resultadosArtistasScrollPane.setPreferredSize(new java.awt.Dimension(400, 250));

        javax.swing.GroupLayout resultadosArtistasPanelLayout = new javax.swing.GroupLayout(resultadosArtistasPanel);
        resultadosArtistasPanel.setLayout(resultadosArtistasPanelLayout);
        resultadosArtistasPanelLayout.setHorizontalGroup(
            resultadosArtistasPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 1141, Short.MAX_VALUE)
        );
        resultadosArtistasPanelLayout.setVerticalGroup(
            resultadosArtistasPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 244, Short.MAX_VALUE)
        );

        resultadosArtistasScrollPane.setViewportView(resultadosArtistasPanel);

        jLabel2.setFont(new java.awt.Font("Segoe UI", 1, 21)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setText("Albums");

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

        jLabel3.setFont(new java.awt.Font("Segoe UI", 1, 21)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setText("Artistas");

        cancionesScrollPane.setBorder(null);

        javax.swing.GroupLayout resultadosCancionesPanelLayout = new javax.swing.GroupLayout(resultadosCancionesPanel);
        resultadosCancionesPanel.setLayout(resultadosCancionesPanelLayout);
        resultadosCancionesPanelLayout.setHorizontalGroup(
            resultadosCancionesPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 1023, Short.MAX_VALUE)
        );
        resultadosCancionesPanelLayout.setVerticalGroup(
            resultadosCancionesPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 307, Short.MAX_VALUE)
        );

        cancionesScrollPane.setViewportView(resultadosCancionesPanel);

        jLabel4.setFont(new java.awt.Font("Segoe UI", 1, 21)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(255, 255, 255));
        jLabel4.setText("Canciones");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(favoritosScrollPane))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(resultadosArtistasScrollPane, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(resultadosAlbumsScrollPane, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                            .addComponent(cancionesScrollPane, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 196, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 196, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 196, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(0, 0, Short.MAX_VALUE)))))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(favoritosScrollPane, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(resultadosArtistasScrollPane, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(12, 12, 12)
                        .addComponent(resultadosAlbumsScrollPane, javax.swing.GroupLayout.PREFERRED_SIZE, 250, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(12, 12, 12)
                        .addComponent(cancionesScrollPane)))
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void busquedaFiltradaBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_busquedaFiltradaBtnActionPerformed

        FiltroAvanzadoDlg dlg = new FiltroAvanzadoDlg(this, true);
        dlg.setVisible(true);
        // 1. mostrar frame de filtro
        // 2. ejecutar la busqueda por filtro
        // 3. anadir un panel al frame o panel de resultados para cada tipo de elemento (cancion, albumes, artistas)
        // 4. meter mini panels de coincidencias con la busqueda para ese frame de un elemento.
        // 5. refrescar el frame.
    }//GEN-LAST:event_busquedaFiltradaBtnActionPerformed

    private void verPerfilBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_verPerfilBtnActionPerformed
        FrmPerfilUsuario perfilUsuario = new FrmPerfilUsuario(this.usuario);
        this.dispose();
        perfilUsuario.setVisible(true);
    }//GEN-LAST:event_verPerfilBtnActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField barraBusquedaTextField;
    private javax.swing.JButton busquedaFiltradaBtn;
    private javax.swing.JScrollPane cancionesScrollPane;
    private javax.swing.JScrollPane favoritosScrollPane;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel misFavoritosPanel;
    private javax.swing.JPanel resultadosAlbumsPanel;
    private javax.swing.JScrollPane resultadosAlbumsScrollPane;
    private javax.swing.JPanel resultadosArtistasPanel;
    private javax.swing.JScrollPane resultadosArtistasScrollPane;
    private javax.swing.JPanel resultadosCancionesPanel;
    private javax.swing.JButton verPerfilBtn;
    // End of variables declaration//GEN-END:variables
}
