package Interfaces;

import java.awt.Color;
import java.awt.Image;
import java.awt.event.KeyEvent;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;

public class LoginCafeteria extends javax.swing.JFrame {

    public LoginCafeteria() {

        initComponents();
        this.setLocationRelativeTo(null);
        this.setTitle("Iniciar Sesion");
        cargarImagenes();
    }

    private void cargarImagenes() {

        ImageIcon logo = new ImageIcon("src/Imagenes/LogoCentro.jpg");
        Icon logoCentr = new ImageIcon(logo.getImage().getScaledInstance(JlbLogoImg.getWidth(), JlbLogoImg.getHeight(), Image.SCALE_DEFAULT));
        JlbLogoImg.setIcon(logoCentr);
        JlbLogoImg.repaint();

        ImageIcon piez = new ImageIcon("src/Imagenes/piezas.png");
        Icon piezas = new ImageIcon(piez.getImage().getScaledInstance(JlbPiezasImg.getWidth(), JlbPiezasImg.getHeight(), Image.SCALE_DEFAULT));
        JlbPiezasImg.setIcon(piezas);
        JlbPiezasImg.repaint();

        JlbPiezasImg1.setIcon(piezas);
        JlbPiezasImg1.repaint();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        JlbLogoImg = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        jPanel3 = new javax.swing.JPanel();
        JlbTitulo = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        jPanel4 = new javax.swing.JPanel();
        JlbAlumno = new javax.swing.JLabel();
        JlbAdmin = new javax.swing.JLabel();
        JPanelesLogin = new javax.swing.JTabbedPane();
        JPanelAdmin = new javax.swing.JPanel();
        JlbUsuarioAdmin = new javax.swing.JLabel();
        JtfAdmin = new javax.swing.JTextField();
        JlbContraAdmin = new javax.swing.JLabel();
        JtfContraseñaAdmin = new javax.swing.JPasswordField();
        jSeparator2 = new javax.swing.JSeparator();
        JbtnInicioAdmin = new javax.swing.JButton();
        JlbPiezasImg1 = new javax.swing.JLabel();
        JPanelAlumno = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        JtfContraseña = new javax.swing.JPasswordField();
        JtfAlumno = new javax.swing.JTextField();
        jSeparator1 = new javax.swing.JSeparator();
        JbtnInicio = new javax.swing.JButton();
        JlbPiezasImg = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        JlbLogoImg.setOpaque(true);
        jPanel1.add(JlbLogoImg, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 170, 370, 320));

        jPanel2.setBackground(new java.awt.Color(54, 191, 245));

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 460, Short.MAX_VALUE)
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 80, Short.MAX_VALUE)
        );

        jPanel1.add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 440, 460, 80));

        jPanel3.setBackground(new java.awt.Color(26, 91, 117));
        jPanel3.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        JlbTitulo.setFont(new java.awt.Font("Lucida Bright", 0, 24)); // NOI18N
        JlbTitulo.setForeground(new java.awt.Color(255, 255, 255));
        JlbTitulo.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        JlbTitulo.setText("CAFETERIA MANITAS AZULES");
        jPanel3.add(JlbTitulo, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 50, 380, 40));

        jLabel1.setFont(new java.awt.Font("Lucida Bright", 0, 18)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("Iniciar sesión");
        jPanel3.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 110, -1, -1));

        jPanel1.add(jPanel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 460, 440));

        jPanel4.setBackground(new java.awt.Color(54, 191, 245));
        jPanel4.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        JlbAlumno.setBackground(new java.awt.Color(54, 191, 245));
        JlbAlumno.setFont(new java.awt.Font("Lucida Bright", 0, 14)); // NOI18N
        JlbAlumno.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        JlbAlumno.setText("Alumno(a)");
        JlbAlumno.setOpaque(true);
        JlbAlumno.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                JlbAlumnoMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                JlbAlumnoMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                JlbAlumnoMouseExited(evt);
            }
        });
        jPanel4.add(JlbAlumno, new org.netbeans.lib.awtextra.AbsoluteConstraints(300, 10, 300, 50));

        JlbAdmin.setBackground(new java.awt.Color(54, 191, 245));
        JlbAdmin.setFont(new java.awt.Font("Lucida Bright", 0, 14)); // NOI18N
        JlbAdmin.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        JlbAdmin.setText("Adminstrador(a)");
        JlbAdmin.setOpaque(true);
        JlbAdmin.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                JlbAdminMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                JlbAdminMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                JlbAdminMouseExited(evt);
            }
        });
        jPanel4.add(JlbAdmin, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 10, 300, 50));

        jPanel1.add(jPanel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(460, 0, 600, 70));

        JPanelAdmin.setBackground(new java.awt.Color(255, 255, 255));
        JPanelAdmin.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        JlbUsuarioAdmin.setFont(new java.awt.Font("Lucida Bright", 0, 14)); // NOI18N
        JlbUsuarioAdmin.setText("Usuario Administrador");
        JPanelAdmin.add(JlbUsuarioAdmin, new org.netbeans.lib.awtextra.AbsoluteConstraints(220, 100, -1, -1));

        JtfAdmin.setFont(new java.awt.Font("Lucida Bright", 0, 12)); // NOI18N
        JtfAdmin.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        JPanelAdmin.add(JtfAdmin, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 140, 220, 30));

        JlbContraAdmin.setFont(new java.awt.Font("Lucida Bright", 0, 14)); // NOI18N
        JlbContraAdmin.setText("Contraseña");
        JPanelAdmin.add(JlbContraAdmin, new org.netbeans.lib.awtextra.AbsoluteConstraints(260, 190, -1, -1));

        JtfContraseñaAdmin.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        JtfContraseñaAdmin.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                JtfContraseñaAdminKeyReleased(evt);
            }
        });
        JPanelAdmin.add(JtfContraseñaAdmin, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 230, 220, 30));
        JPanelAdmin.add(jSeparator2, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 320, 370, 30));

        JbtnInicioAdmin.setFont(new java.awt.Font("Lucida Bright", 0, 12)); // NOI18N
        JbtnInicioAdmin.setText("Iniciar Sesion");
        JbtnInicioAdmin.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        JbtnInicioAdmin.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                JbtnInicioAdminActionPerformed(evt);
            }
        });
        JPanelAdmin.add(JbtnInicioAdmin, new org.netbeans.lib.awtextra.AbsoluteConstraints(250, 360, 120, 30));

        JlbPiezasImg1.setBackground(new java.awt.Color(255, 255, 255));
        JlbPiezasImg1.setOpaque(true);
        JPanelAdmin.add(JlbPiezasImg1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 330, 600, 140));

        JPanelesLogin.addTab("Admin", JPanelAdmin);

        JPanelAlumno.setBackground(new java.awt.Color(255, 255, 255));
        JPanelAlumno.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel2.setFont(new java.awt.Font("Lucida Bright", 0, 14)); // NOI18N
        jLabel2.setText("Usuario Alumno");
        JPanelAlumno.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(250, 100, -1, -1));

        jLabel3.setFont(new java.awt.Font("Lucida Bright", 0, 14)); // NOI18N
        jLabel3.setText("Contraseña");
        JPanelAlumno.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(260, 190, -1, -1));

        JtfContraseña.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        JtfContraseña.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                JtfContraseñaKeyReleased(evt);
            }
        });
        JPanelAlumno.add(JtfContraseña, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 230, 220, 30));

        JtfAlumno.setFont(new java.awt.Font("Lucida Bright", 0, 12)); // NOI18N
        JtfAlumno.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        JPanelAlumno.add(JtfAlumno, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 140, 220, 30));
        JPanelAlumno.add(jSeparator1, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 320, 370, 30));

        JbtnInicio.setFont(new java.awt.Font("Lucida Bright", 0, 12)); // NOI18N
        JbtnInicio.setText("Iniciar Sesion");
        JbtnInicio.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        JbtnInicio.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                JbtnInicioActionPerformed(evt);
            }
        });
        JPanelAlumno.add(JbtnInicio, new org.netbeans.lib.awtextra.AbsoluteConstraints(250, 360, 120, 30));

        JlbPiezasImg.setBackground(new java.awt.Color(255, 255, 255));
        JlbPiezasImg.setOpaque(true);
        JPanelAlumno.add(JlbPiezasImg, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 330, 600, 140));

        JPanelesLogin.addTab("Alumno", JPanelAlumno);

        jPanel1.add(JPanelesLogin, new org.netbeans.lib.awtextra.AbsoluteConstraints(460, 40, 600, 480));

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1060, 520));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void JlbAdminMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_JlbAdminMouseEntered
        // AL ENTRAR AL BOTON DE ADMIN
        JlbAdmin.setBackground(Color.white);
    }//GEN-LAST:event_JlbAdminMouseEntered

    Color col = new Color(54, 191, 245);

    private void JlbAdminMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_JlbAdminMouseExited
        // AL SALIR DEL BOTON DE ADMIN
        JlbAdmin.setBackground(col);
    }//GEN-LAST:event_JlbAdminMouseExited

    private void JlbAlumnoMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_JlbAlumnoMouseEntered
        // AL ENTRAR AL BOTON DE ALUMNO
        JlbAlumno.setBackground(Color.white);
    }//GEN-LAST:event_JlbAlumnoMouseEntered

    private void JlbAlumnoMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_JlbAlumnoMouseExited
        // AL SALIR DEL BOTON DE ALUMNO
        JlbAlumno.setBackground(col);
    }//GEN-LAST:event_JlbAlumnoMouseExited


    private void JbtnInicioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_JbtnInicioActionPerformed

        // BOTON INICIO SESION ALUMNO
        validarAlumno();
        /*if (JtfAlumno.getText().equals("") || JtfContraseña.getText().equals("")) {
            JOptionPane.showMessageDialog(null, "Campos vacios");
        } else if (JtfAlumno.getText().equals("Alfredo") && JtfContraseña.getText().equals("qwerty123")) {

            PrincipalTEA obj = new PrincipalTEA();
            obj.setVisible(true);
            this.dispose();
            JOptionPane.showMessageDialog(null, "Bienvenido(a) " + JtfAlumno.getText());

        }*/
    }//GEN-LAST:event_JbtnInicioActionPerformed

    public String guardarNombre(){
        
        String nombre=JtfAlumno.getText();
        
        return nombre;
    }
    
    static String alu;
    
    private void validarAlumno() {

        int resultado = 0;
        String pass = JtfContraseña.getText();
        alu = JtfAlumno.getText();
        String sql = "select * from alumnos where nom_alumn='" + alu + "' and pass_alumn='" + pass + "'";

        //CONEXION A BD PARA VALIDAR
        try {

            Connection conexion = DriverManager.getConnection("jdbc:mysql://localhost/tiendatea", "root", "");
            Statement st = conexion.createStatement();
            ResultSet rs = st.executeQuery(sql);

            if (rs.next()) {

                resultado = 1;
                if (resultado == 1) {
                    
                    guardarNombre();
                    PrincipalTEA obj = new PrincipalTEA();
                    obj.setVisible(true);
                    this.dispose();
                    JOptionPane.showMessageDialog(null, "Bienvenido(a) " + JtfAlumno.getText());

                }

            } else {
                JOptionPane.showMessageDialog(null, "Usuario o contraseña incorrecta");
            }

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Error: " + e.getMessage());
        }

    }


    private void JlbAlumnoMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_JlbAlumnoMouseClicked
        // CLICK EN PANEL DE ALUMNO
        cambiarPanel(1);
    }//GEN-LAST:event_JlbAlumnoMouseClicked

    private void JbtnInicioAdminActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_JbtnInicioAdminActionPerformed
        // BOTON INICIO SESION ADMIN
        validarAdmin();
    }//GEN-LAST:event_JbtnInicioAdminActionPerformed

    private void validarAdmin() {

        if (JtfAdmin.getText().equals("") || JtfContraseñaAdmin.getText().equals("")) {
            JOptionPane.showMessageDialog(null, "Campos vacios");
        } else if (JtfAdmin.getText().equals("Isela") && JtfContraseñaAdmin.getText().equals("qwerty")) {

            VentanaAdmin obj = new VentanaAdmin();
            obj.setVisible(true);
            this.dispose();
            //JOptionPane.showMessageDialog(null, "Bienvenido(a) "+JtfAdmin.getText());

        } else {
            JOptionPane.showMessageDialog(null, "Contraseña o Usuario incorrecto");
        }

    }

    private void JlbAdminMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_JlbAdminMouseClicked
        // CLICK EN PANEL DE ADMIN
        cambiarPanel(0);
    }//GEN-LAST:event_JlbAdminMouseClicked

    private void JtfContraseñaKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_JtfContraseñaKeyReleased
        // LISTENER DEL BOTON ENTER PARA ALUMNO
        if (evt.getKeyCode() == KeyEvent.VK_ENTER) { // Validar que la tecla presionada fue enter y mandar a llamar el metodo          
            validarAlumno();
        }
    }//GEN-LAST:event_JtfContraseñaKeyReleased

    private void JtfContraseñaAdminKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_JtfContraseñaAdminKeyReleased
        // LISTENER PARA BOTON ADMIN
        if (evt.getKeyCode() == KeyEvent.VK_ENTER) {
            validarAdmin();
        }

    }//GEN-LAST:event_JtfContraseñaAdminKeyReleased

    private void cambiarPanel(int panel) {
        JPanelesLogin.setSelectedIndex(panel);
    }

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
            java.util.logging.Logger.getLogger(LoginCafeteria.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(LoginCafeteria.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(LoginCafeteria.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(LoginCafeteria.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new LoginCafeteria().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel JPanelAdmin;
    private javax.swing.JPanel JPanelAlumno;
    private javax.swing.JTabbedPane JPanelesLogin;
    private javax.swing.JButton JbtnInicio;
    private javax.swing.JButton JbtnInicioAdmin;
    private javax.swing.JLabel JlbAdmin;
    private javax.swing.JLabel JlbAlumno;
    private javax.swing.JLabel JlbContraAdmin;
    private javax.swing.JLabel JlbLogoImg;
    private javax.swing.JLabel JlbPiezasImg;
    private javax.swing.JLabel JlbPiezasImg1;
    private javax.swing.JLabel JlbTitulo;
    private javax.swing.JLabel JlbUsuarioAdmin;
    private javax.swing.JTextField JtfAdmin;
    private javax.swing.JTextField JtfAlumno;
    private javax.swing.JPasswordField JtfContraseña;
    private javax.swing.JPasswordField JtfContraseñaAdmin;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JSeparator jSeparator2;
    // End of variables declaration//GEN-END:variables
}
