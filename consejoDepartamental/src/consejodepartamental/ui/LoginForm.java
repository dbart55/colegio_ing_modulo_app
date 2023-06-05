package consejodepartamental.ui;

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
        rememberCheckBox = new javax.swing.JCheckBox();
        passwordLabel1 = new javax.swing.JLabel();
        loginButton = new javax.swing.JButton();
        passwordTextField = new javax.swing.JPasswordField();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setBackground(new java.awt.Color(23, 35, 35));

        abovePanel.setBackground(new java.awt.Color(150, 137, 95));

        loginTitleLabel.setFont(new java.awt.Font("Corbel Light", 1, 18)); // NOI18N
        loginTitleLabel.setText("Inicio de Sesión");

        javax.swing.GroupLayout abovePanelLayout = new javax.swing.GroupLayout(abovePanel);
        abovePanel.setLayout(abovePanelLayout);
        abovePanelLayout.setHorizontalGroup(
            abovePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(abovePanelLayout.createSequentialGroup()
                .addGap(14, 14, 14)
                .addComponent(loginTitleLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 122, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        abovePanelLayout.setVerticalGroup(
            abovePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(abovePanelLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(loginTitleLabel)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        backgroundPanel.setBackground(new java.awt.Color(23, 33, 42));

        logoLabel.setIcon(new javax.swing.ImageIcon(getClass().getResource("/resources/colegio_ingenieros_logo.png"))); // NOI18N

        centerTitleLabel.setFont(new java.awt.Font("Lucida Bright", 0, 18)); // NOI18N
        centerTitleLabel.setForeground(new java.awt.Color(255, 255, 255));
        centerTitleLabel.setText("Consejo Departamental de Lambayeque");

        userLabel.setFont(new java.awt.Font("Corbel Light", 0, 24)); // NOI18N
        userLabel.setForeground(new java.awt.Color(255, 255, 255));
        userLabel.setLabelFor(userTextField);
        userLabel.setText("Usuario");

        passwordLabel.setFont(new java.awt.Font("Corbel Light", 0, 24)); // NOI18N
        passwordLabel.setForeground(new java.awt.Color(255, 255, 255));
        passwordLabel.setText("Contraseña");

        rememberCheckBox.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rememberCheckBoxActionPerformed(evt);
            }
        });

        passwordLabel1.setFont(new java.awt.Font("Corbel Light", 0, 14)); // NOI18N
        passwordLabel1.setForeground(new java.awt.Color(255, 255, 255));
        passwordLabel1.setLabelFor(rememberCheckBox);
        passwordLabel1.setText("Recordarme");

        loginButton.setBackground(new java.awt.Color(150, 140, 96));
        loginButton.setFont(new java.awt.Font("Corbel Light", 0, 18)); // NOI18N
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
            .addGroup(backgroundPanelLayout.createSequentialGroup()
                .addGap(140, 140, 140)
                .addComponent(logoLabel)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, backgroundPanelLayout.createSequentialGroup()
                .addContainerGap(38, Short.MAX_VALUE)
                .addGroup(backgroundPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(loginButton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(backgroundPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(backgroundPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(centerTitleLabel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(userTextField)
                            .addComponent(passwordLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 118, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addComponent(userLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 84, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGroup(backgroundPanelLayout.createSequentialGroup()
                            .addComponent(rememberCheckBox)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(passwordLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 139, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addComponent(passwordTextField))
                .addGap(36, 36, 36))
        );
        backgroundPanelLayout.setVerticalGroup(
            backgroundPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(backgroundPanelLayout.createSequentialGroup()
                .addGap(27, 27, 27)
                .addComponent(logoLabel)
                .addGap(32, 32, 32)
                .addComponent(centerTitleLabel)
                .addGap(91, 91, 91)
                .addComponent(userLabel)
                .addGap(0, 0, 0)
                .addComponent(userTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(30, 30, 30)
                .addComponent(passwordLabel)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(passwordTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(16, 16, 16)
                .addGroup(backgroundPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(rememberCheckBox)
                    .addComponent(passwordLabel1))
                .addGap(39, 39, 39)
                .addComponent(loginButton, javax.swing.GroupLayout.PREFERRED_SIZE, 54, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(83, Short.MAX_VALUE))
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

    private void rememberCheckBoxActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rememberCheckBoxActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_rememberCheckBoxActionPerformed

    private void loginButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_loginButtonActionPerformed

        String userName = userTextField.getText();
        userName = userName.trim();
        String password = new String(passwordTextField.getPassword());
        password = password.trim();

        System.out.println(userName);
        System.out.println(password);

        Usuario user = this.controlador.obtenerUsuario(userName, password);
        System.out.println(user.toString());
        if (user != null) {
            HomeFrame homeFrame = new HomeFrame();
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
    private javax.swing.JLabel passwordLabel1;
    private javax.swing.JPasswordField passwordTextField;
    private javax.swing.JCheckBox rememberCheckBox;
    private javax.swing.JLabel userLabel;
    private javax.swing.JTextField userTextField;
    // End of variables declaration//GEN-END:variables
}
