package consejodepartamental.ui;

import consejodepartamental.entity.Sesion;
import consejodepartamental.logic.Controlador;
import consejodepartamental.entity.Usuario;
import java.awt.Image;
import javax.swing.ImageIcon;
import javax.swing.JDialog;
import javax.swing.JOptionPane;

/**
 *
 * @author Diego
 */
public class LoginForm extends javax.swing.JFrame {

    private Controlador controlador;

    public LoginForm() {
        initComponents();
        this.setLocationRelativeTo(null);
        this.controlador = new Controlador();
    }

    @Override
    public void dispose() {
        this.controlador.finalizar();
        super.dispose();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        abovePanel = new javax.swing.JPanel();
        loginTitleLabel = new javax.swing.JLabel();
        backgroundPanel = new javax.swing.JPanel();
        logoLabel = new javax.swing.JLabel();
        centerTitleLabel = new javax.swing.JLabel();
        userTextField = new javax.swing.JTextField();
        userLabel = new javax.swing.JLabel();
        passwordLabel = new javax.swing.JLabel();
        recordarCheckBox = new javax.swing.JCheckBox();
        recordarLabel = new javax.swing.JLabel();
        loginButton = new javax.swing.JButton();
        passwordTextField = new javax.swing.JPasswordField();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setBackground(new java.awt.Color(23, 35, 35));

        abovePanel.setBackground(new java.awt.Color(207, 60, 60));

        loginTitleLabel.setFont(new java.awt.Font("Corbel", 1, 18)); // NOI18N
        loginTitleLabel.setForeground(new java.awt.Color(253, 253, 251));
        loginTitleLabel.setText("Inicio de Sesión");

        javax.swing.GroupLayout abovePanelLayout = new javax.swing.GroupLayout(abovePanel);
        abovePanel.setLayout(abovePanelLayout);
        abovePanelLayout.setHorizontalGroup(
            abovePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(abovePanelLayout.createSequentialGroup()
                .addGap(14, 14, 14)
                .addComponent(loginTitleLabel)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        abovePanelLayout.setVerticalGroup(
            abovePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(abovePanelLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(loginTitleLabel)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        backgroundPanel.setBackground(new java.awt.Color(253, 253, 251));

        logoLabel.setIcon(new javax.swing.ImageIcon(getClass().getResource("/resources/colegio_ingenieros_logo.png"))); // NOI18N

        centerTitleLabel.setFont(new java.awt.Font("Corbel", 1, 21)); // NOI18N
        centerTitleLabel.setForeground(new java.awt.Color(0, 0, 0));
        centerTitleLabel.setText("Consejo Departamental de Lambayeque");

        userLabel.setFont(new java.awt.Font("Corbel", 1, 24)); // NOI18N
        userLabel.setForeground(new java.awt.Color(0, 0, 0));
        userLabel.setLabelFor(userTextField);
        userLabel.setText("Usuario");

        passwordLabel.setFont(new java.awt.Font("Corbel", 1, 24)); // NOI18N
        passwordLabel.setForeground(new java.awt.Color(0, 0, 0));
        passwordLabel.setText("Contraseña");

        recordarCheckBox.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                recordarCheckBoxActionPerformed(evt);
            }
        });

        recordarLabel.setFont(new java.awt.Font("Corbel Light", 1, 14)); // NOI18N
        recordarLabel.setForeground(new java.awt.Color(0, 0, 0));
        recordarLabel.setLabelFor(recordarCheckBox);
        recordarLabel.setText("Recordarme");

        loginButton.setBackground(new java.awt.Color(207, 60, 60));
        loginButton.setFont(new java.awt.Font("Corbel", 1, 18)); // NOI18N
        loginButton.setForeground(new java.awt.Color(253, 253, 251));
        loginButton.setText("Iniciar Sesión");
        loginButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                loginButtonActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout backgroundPanelLayout = new javax.swing.GroupLayout(backgroundPanel);
        backgroundPanel.setLayout(backgroundPanelLayout);
        backgroundPanelLayout.setHorizontalGroup(
            backgroundPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, backgroundPanelLayout.createSequentialGroup()
                .addContainerGap(26, Short.MAX_VALUE)
                .addGroup(backgroundPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(backgroundPanelLayout.createSequentialGroup()
                        .addComponent(recordarCheckBox)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(recordarLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 139, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(loginButton, javax.swing.GroupLayout.PREFERRED_SIZE, 386, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(20, 20, 20))
            .addGroup(backgroundPanelLayout.createSequentialGroup()
                .addGroup(backgroundPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(backgroundPanelLayout.createSequentialGroup()
                        .addGap(140, 140, 140)
                        .addComponent(logoLabel))
                    .addGroup(backgroundPanelLayout.createSequentialGroup()
                        .addGap(24, 24, 24)
                        .addGroup(backgroundPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(passwordLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 118, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(backgroundPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addComponent(userTextField, javax.swing.GroupLayout.DEFAULT_SIZE, 393, Short.MAX_VALUE)
                                .addComponent(passwordTextField))
                            .addComponent(userLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 84, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(backgroundPanelLayout.createSequentialGroup()
                        .addGap(38, 38, 38)
                        .addComponent(centerTitleLabel)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        backgroundPanelLayout.setVerticalGroup(
            backgroundPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(backgroundPanelLayout.createSequentialGroup()
                .addGap(27, 27, 27)
                .addComponent(logoLabel)
                .addGap(45, 45, 45)
                .addComponent(centerTitleLabel)
                .addGap(76, 76, 76)
                .addComponent(userLabel)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(userTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(25, 25, 25)
                .addComponent(passwordLabel)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(passwordTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(backgroundPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(recordarCheckBox)
                    .addComponent(recordarLabel))
                .addGap(43, 43, 43)
                .addComponent(loginButton, javax.swing.GroupLayout.PREFERRED_SIZE, 54, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(79, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(abovePanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(backgroundPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(abovePanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(backgroundPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void recordarCheckBoxActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_recordarCheckBoxActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_recordarCheckBoxActionPerformed

    private void loginButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_loginButtonActionPerformed

        String userName = userTextField.getText();
        userName = userName.trim();
        String password = new String(passwordTextField.getPassword());
        password = password.trim();
        boolean recordarUsuario = this.recordarCheckBox.isSelected();

        Usuario user = this.controlador.obtenerUsuarioPorCredenciales(userName, password);
        System.out.println(user);
        if (user != null) {
            Sesion sesion = this.controlador.crearSesion(user.getUserId(), recordarUsuario);
            HomeFrame homeFrame = new HomeFrame(user, sesion);
            homeFrame.setVisible(true);
            homeFrame.setLocationRelativeTo(null);

            this.setVisible(false);
            this.dispose();

        } else {
            JOptionPane joptionPane = new JOptionPane("Usuario y/o contraseña incorrecta");
            joptionPane.setMessageType(JOptionPane.PLAIN_MESSAGE);
            JDialog dialog = joptionPane.createDialog("Mensaje");
            dialog.setAlwaysOnTop(true);
            dialog.setVisible(true);
        }
    }//GEN-LAST:event_loginButtonActionPerformed

    /**
     * @param args the command line arguments
     */

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel abovePanel;
    private javax.swing.JPanel backgroundPanel;
    private javax.swing.JLabel centerTitleLabel;
    private javax.swing.JButton loginButton;
    private javax.swing.JLabel loginTitleLabel;
    private javax.swing.JLabel logoLabel;
    private javax.swing.JLabel passwordLabel;
    private javax.swing.JPasswordField passwordTextField;
    private javax.swing.JCheckBox recordarCheckBox;
    private javax.swing.JLabel recordarLabel;
    private javax.swing.JLabel userLabel;
    private javax.swing.JTextField userTextField;
    // End of variables declaration//GEN-END:variables
}
