
package com.equipo7.presentacion.gui;

import com.equipo7.negocio.bo.UsuariosBO;
import com.equipo7.negocio.bo.interfaces.IUsuariosBO;
import com.equipo7.negocio.dtos.UsuarioDTO;
import com.equipo7.negocio.excepciones.BOException;
import com.equipo7.presentacion.gui.estilo.Estilo;
import static com.equipo7.presentacion.gui.estilo.Estilo.colorPrimario;
import java.awt.Color;
import javax.swing.SwingUtilities;
import javax.swing.UIManager;

/**
 *
 * @author neri
 */
public class FrmPerfilUsuario extends javax.swing.JFrame {

    private UsuarioDTO usuario = PerfilUsuario.getUsuario();
    
    /**
     * Creates new form FrmPerfilUsuario
     * @param usuario
     */
    public FrmPerfilUsuario(){
        initComponents();
        
        
        this.fondoColorPanel.setBackground(new Color(153, 0, 204));
        this.setLocationRelativeTo(null);
        this.prepararEstilo();
        this.cargarInformacionUsuario();
        
    }
    
    /**
     * 
     */
    private void prepararEstilo() {
        UIManager.put("Button.background",  Estilo.colorBaseFondo);
        SwingUtilities.updateComponentTreeUI(this);
    }
    
    /**
     * 
     */
    private void cargarInformacionUsuario() {
        if (usuario == null) return;
        
        this.nombreUsuarioLbl.setText(usuario.getNombreUsuario());
        this.correoUsuarioLbl.setText(usuario.getCorreoElectronico());
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
        imagenPerfilUsuarioContainer = new javax.swing.JPanel();
        nombreUsuarioLbl = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        correoUsuarioLbl = new javax.swing.JLabel();
        btnEditarUsu = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        informacionUsuarioPanel = new javax.swing.JPanel();
        volverMenuPrincipalBtn = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        fondoColorPanel.setForeground(new java.awt.Color(153, 0, 204));

        imagenPerfilUsuarioContainer.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(204, 204, 204)));

        javax.swing.GroupLayout imagenPerfilUsuarioContainerLayout = new javax.swing.GroupLayout(imagenPerfilUsuarioContainer);
        imagenPerfilUsuarioContainer.setLayout(imagenPerfilUsuarioContainerLayout);
        imagenPerfilUsuarioContainerLayout.setHorizontalGroup(
            imagenPerfilUsuarioContainerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 150, Short.MAX_VALUE)
        );
        imagenPerfilUsuarioContainerLayout.setVerticalGroup(
            imagenPerfilUsuarioContainerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 150, Short.MAX_VALUE)
        );

        nombreUsuarioLbl.setFont(new java.awt.Font("Segoe UI", 1, 21)); // NOI18N
        nombreUsuarioLbl.setForeground(new java.awt.Color(255, 255, 255));
        nombreUsuarioLbl.setText("Nombre Usuario");

        jButton1.setText("X");

        correoUsuarioLbl.setForeground(new java.awt.Color(204, 204, 204));
        correoUsuarioLbl.setText("Correo Usuario");

        btnEditarUsu.setText("E");
        btnEditarUsu.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEditarUsuActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout fondoColorPanelLayout = new javax.swing.GroupLayout(fondoColorPanel);
        fondoColorPanel.setLayout(fondoColorPanelLayout);
        fondoColorPanelLayout.setHorizontalGroup(
            fondoColorPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(fondoColorPanelLayout.createSequentialGroup()
                .addGap(32, 32, 32)
                .addGroup(fondoColorPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(btnEditarUsu, javax.swing.GroupLayout.PREFERRED_SIZE, 49, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(imagenPerfilUsuarioContainer, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(fondoColorPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(fondoColorPanelLayout.createSequentialGroup()
                        .addComponent(nombreUsuarioLbl, javax.swing.GroupLayout.PREFERRED_SIZE, 240, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 49, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(correoUsuarioLbl, javax.swing.GroupLayout.PREFERRED_SIZE, 343, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        fondoColorPanelLayout.setVerticalGroup(
            fondoColorPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(fondoColorPanelLayout.createSequentialGroup()
                .addContainerGap(44, Short.MAX_VALUE)
                .addComponent(btnEditarUsu)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(fondoColorPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, fondoColorPanelLayout.createSequentialGroup()
                        .addComponent(imagenPerfilUsuarioContainer, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap())
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, fondoColorPanelLayout.createSequentialGroup()
                        .addGroup(fondoColorPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(nombreUsuarioLbl, javax.swing.GroupLayout.PREFERRED_SIZE, 55, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 55, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(correoUsuarioLbl, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(20, 20, 20))))
        );

        javax.swing.GroupLayout informacionUsuarioPanelLayout = new javax.swing.GroupLayout(informacionUsuarioPanel);
        informacionUsuarioPanel.setLayout(informacionUsuarioPanelLayout);
        informacionUsuarioPanelLayout.setHorizontalGroup(
            informacionUsuarioPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 957, Short.MAX_VALUE)
        );
        informacionUsuarioPanelLayout.setVerticalGroup(
            informacionUsuarioPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 363, Short.MAX_VALUE)
        );

        jScrollPane1.setViewportView(informacionUsuarioPanel);

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
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(fondoColorPanel, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(volverMenuPrincipalBtn)
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(volverMenuPrincipalBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(fondoColorPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 369, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void volverMenuPrincipalBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_volverMenuPrincipalBtnActionPerformed
        FrmPantallaPrincipal frm = new FrmPantallaPrincipal();
        this.dispose();
        frm.setVisible(true);
    }//GEN-LAST:event_volverMenuPrincipalBtnActionPerformed

    private void btnEditarUsuActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEditarUsuActionPerformed
       String[] opciones = {"Nombre", "Contraseña", "Cancelar"};
    int seleccion = javax.swing.JOptionPane.showOptionDialog(
        this,
        "Seleccione la opción que desea editar:",
        "Editar Perfil",
        javax.swing.JOptionPane.DEFAULT_OPTION,
        javax.swing.JOptionPane.QUESTION_MESSAGE,
        null,
        opciones,
        opciones[2] // Opción por defecto: Cancelar
    );

    switch (seleccion) {
        case 0: // Editar Nombre
            String nuevoNombre = javax.swing.JOptionPane.showInputDialog(this, "Ingrese el nuevo nombre de usuario:", "Editar Nombre", javax.swing.JOptionPane.PLAIN_MESSAGE);
            if (nuevoNombre != null && !nuevoNombre.trim().isEmpty()) {
                try {
                    IUsuariosBO usuariosBO = UsuariosBO.getInstance();
                    usuariosBO.actualizarNombreUsuario(usuario.getCorreoElectronico(), nuevoNombre);
                    usuario.setNombreUsuario(nuevoNombre);
                    this.nombreUsuarioLbl.setText(nuevoNombre);
                    javax.swing.JOptionPane.showMessageDialog(this, "Nombre de usuario actualizado con éxito.", "Éxito", javax.swing.JOptionPane.INFORMATION_MESSAGE);
                } catch (BOException e) {
                    javax.swing.JOptionPane.showMessageDialog(this, "Error al actualizar el nombre: " + e.getMessage(), "Error", javax.swing.JOptionPane.ERROR_MESSAGE);
                }
            }
            break;

        case 1: // Editar Contraseña
            javax.swing.JPanel panelContraseña = new javax.swing.JPanel(new java.awt.GridLayout(2, 2, 5, 5));
            javax.swing.JPasswordField nuevaContraseñaField = new javax.swing.JPasswordField();
            javax.swing.JPasswordField confirmarContraseñaField = new javax.swing.JPasswordField();
            panelContraseña.add(new javax.swing.JLabel("Nueva contraseña:"));
            panelContraseña.add(nuevaContraseñaField);
            panelContraseña.add(new javax.swing.JLabel("Confirmar contraseña:"));
            panelContraseña.add(confirmarContraseñaField);

            int resultado = javax.swing.JOptionPane.showConfirmDialog(
                this,
                panelContraseña,
                "Cambiar Contraseña",
                javax.swing.JOptionPane.OK_CANCEL_OPTION,
                javax.swing.JOptionPane.PLAIN_MESSAGE
            );

            if (resultado == javax.swing.JOptionPane.OK_OPTION) {
                String nuevaContraseña = new String(nuevaContraseñaField.getPassword());
                String confirmarContraseña = new String(confirmarContraseñaField.getPassword());

                if (nuevaContraseña.equals(confirmarContraseña) && !nuevaContraseña.isEmpty()) {
                    try {
                        IUsuariosBO usuariosBO = UsuariosBO.getInstance();
                        usuariosBO.actualizarContrasenhaUsuario(usuario.getCorreoElectronico(), nuevaContraseña);
                        usuario.setContrasena(nuevaContraseña);
                        javax.swing.JOptionPane.showMessageDialog(this, "Contraseña actualizada con éxito.\nDebe volver a iniciar sesión para continuar.", "Aviso", javax.swing.JOptionPane.INFORMATION_MESSAGE);
                        
                        // Cerrar la ventana actual y redirigir al inicio de sesión
                        this.dispose();
                        new IniciarSesionDlg().setVisible(true);
                    } catch (BOException e) {
                        javax.swing.JOptionPane.showMessageDialog(this, "Error al actualizar la contraseña: " + e.getMessage(), "Error", javax.swing.JOptionPane.ERROR_MESSAGE);
                    }
                } else {
                    javax.swing.JOptionPane.showMessageDialog(this, "Las contraseñas no coinciden o están vacías.", "Error", javax.swing.JOptionPane.ERROR_MESSAGE);
                }
            }
            break;

        case 2: // Cancelar
        default:
            // Opción de cancelar, no se hace nada.
            break;
    }
    }//GEN-LAST:event_btnEditarUsuActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnEditarUsu;
    private javax.swing.JLabel correoUsuarioLbl;
    private javax.swing.JPanel fondoColorPanel;
    private javax.swing.JPanel imagenPerfilUsuarioContainer;
    private javax.swing.JPanel informacionUsuarioPanel;
    private javax.swing.JButton jButton1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel nombreUsuarioLbl;
    private javax.swing.JButton volverMenuPrincipalBtn;
    // End of variables declaration//GEN-END:variables
}
