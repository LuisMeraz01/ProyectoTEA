package Interfaces;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

public class AgregarAlumnos extends javax.swing.JFrame {

    DefaultTableModel modelo = new DefaultTableModel(); // Crear Modelo para tabla

    public AgregarAlumnos() {
        initComponents();
        this.setLocationRelativeTo(null);
        this.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        mostrarAlumTabla();
        JbtnElimAlu.setEnabled(false);

    }

    private void mostrarAlumTabla() {

        String sql = "select * from alumnos";
        Statement st;

        DefaultTableModel model = new DefaultTableModel();
        model.addColumn("Alumno");
        model.addColumn("Contraseña");

        JTableAlumnos.setModel(model);
        String datos[] = new String[2];

        try { // MOSTRAR TODOS LOS DATOS DE LA BD DE CATEGORIA EN LA TABLA

            Connection conexion = DriverManager.getConnection("jdbc:mysql://localhost/tiendatea", "root", "");
            st = conexion.createStatement();
            ResultSet rs = st.executeQuery(sql);

            while (rs.next()) {

                datos[0] = rs.getString(2);
                datos[1] = rs.getString(3);
                model.addRow(datos);

            }

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Error: " + e.getMessage());
        }

    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        JTableAlumnos = new javax.swing.JTable();
        jSeparator1 = new javax.swing.JSeparator();
        JlbNomAlumn = new javax.swing.JLabel();
        JlbNomAlumn1 = new javax.swing.JLabel();
        JtfNomAlumn = new javax.swing.JTextField();
        jSeparator2 = new javax.swing.JSeparator();
        JbtnAgregarAlu = new javax.swing.JButton();
        JbtnElimAlu = new javax.swing.JButton();
        jPanel2 = new javax.swing.JPanel();
        jLabel4 = new javax.swing.JLabel();
        JtfPassAlumno = new javax.swing.JTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel1.setBackground(new java.awt.Color(26, 91, 117));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        JTableAlumnos.setBackground(new java.awt.Color(26, 91, 117));
        JTableAlumnos.setFont(new java.awt.Font("Lucida Bright", 0, 13)); // NOI18N
        JTableAlumnos.setForeground(new java.awt.Color(255, 255, 255));
        JTableAlumnos.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {},
                {},
                {},
                {}
            },
            new String [] {

            }
        ));
        JTableAlumnos.setRowHeight(28);
        JTableAlumnos.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                JTableAlumnosMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(JTableAlumnos);

        jPanel1.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 70, 540, 280));
        jPanel1.add(jSeparator1, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 460, 250, 20));

        JlbNomAlumn.setFont(new java.awt.Font("Lucida Bright", 0, 15)); // NOI18N
        JlbNomAlumn.setForeground(new java.awt.Color(255, 255, 255));
        JlbNomAlumn.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        JlbNomAlumn.setText("Contraseña");
        jPanel1.add(JlbNomAlumn, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 430, 130, 40));

        JlbNomAlumn1.setFont(new java.awt.Font("Lucida Bright", 0, 15)); // NOI18N
        JlbNomAlumn1.setForeground(new java.awt.Color(255, 255, 255));
        JlbNomAlumn1.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        JlbNomAlumn1.setText("Nombre Alumno");
        jPanel1.add(JlbNomAlumn1, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 380, 130, 40));

        JtfNomAlumn.setBackground(new java.awt.Color(26, 91, 117));
        JtfNomAlumn.setFont(new java.awt.Font("Lucida Bright", 0, 13)); // NOI18N
        JtfNomAlumn.setForeground(new java.awt.Color(255, 255, 255));
        JtfNomAlumn.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        JtfNomAlumn.setBorder(null);
        jPanel1.add(JtfNomAlumn, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 390, 220, 20));
        jPanel1.add(jSeparator2, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 410, 220, 20));

        JbtnAgregarAlu.setText("Agregar Alumno");
        JbtnAgregarAlu.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                JbtnAgregarAluActionPerformed(evt);
            }
        });
        jPanel1.add(JbtnAgregarAlu, new org.netbeans.lib.awtextra.AbsoluteConstraints(449, 390, 120, -1));

        JbtnElimAlu.setText("Eliminar Alumno");
        JbtnElimAlu.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                JbtnElimAluActionPerformed(evt);
            }
        });
        jPanel1.add(JbtnElimAlu, new org.netbeans.lib.awtextra.AbsoluteConstraints(450, 440, 120, -1));

        jPanel2.setBackground(new java.awt.Color(128, 213, 247));
        jPanel2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel4.setBackground(new java.awt.Color(0, 0, 0));
        jLabel4.setFont(new java.awt.Font("Lucida Bright", 0, 18)); // NOI18N
        jLabel4.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel4.setText("Registro de alumnos");
        jPanel2.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 0, 230, 40));

        jPanel1.add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 820, 40));

        JtfPassAlumno.setBackground(new java.awt.Color(26, 91, 117));
        JtfPassAlumno.setFont(new java.awt.Font("Lucida Bright", 0, 13)); // NOI18N
        JtfPassAlumno.setForeground(new java.awt.Color(255, 255, 255));
        JtfPassAlumno.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        JtfPassAlumno.setBorder(null);
        jPanel1.add(JtfPassAlumno, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 440, 250, 20));

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 820, 500));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void JbtnAgregarAluActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_JbtnAgregarAluActionPerformed
        // BOTON MANDAR A LLAMAR METODO PARA AGREGAR ALUMNO
        agregarAlumno();
    }//GEN-LAST:event_JbtnAgregarAluActionPerformed

    private void JTableAlumnosMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_JTableAlumnosMouseClicked
        // CLICK SOBRE ALGUN REGISTRO PARA MANDAR A LLAMAR METODO SELECCIONAR REGISTROS
        seleccionRegistro(JTableAlumnos, JtfNomAlumn, JtfPassAlumno);
        JbtnElimAlu.setEnabled(true);
    }//GEN-LAST:event_JTableAlumnosMouseClicked

    private void JbtnElimAluActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_JbtnElimAluActionPerformed
        // BOTON MANDAR A LLAMAR METODO PARA ELIMINAR ALUMNO
        
        int res = JOptionPane.showConfirmDialog(this, "¿Borrar alumno?", "Confirm", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);

        if (res == JOptionPane.YES_OPTION) { // Confirmar eliminacion de registro
            eliminarAlumno();
        }
    }//GEN-LAST:event_JbtnElimAluActionPerformed

    private void eliminarAlumno() {

        try {

            Connection conexion = DriverManager.getConnection("jdbc:mysql://localhost/tiendatea", "root", "");
            PreparedStatement pst = conexion.prepareStatement("delete from alumnos where id_contraseña =" + ID);

            pst.executeUpdate();
            mostrarAlumTabla();
            limpiar();
            JOptionPane.showMessageDialog(null, "Registro eliminado");
            JbtnAgregarAlu.setEnabled(true);
            JbtnElimAlu.setEnabled(false);

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Error: " + e.getMessage());
        }

    }

    private void limpiar() {

        JtfNomAlumn.setText("");
        JtfPassAlumno.setText("");
    }

    public String ID;

    private void seleccionRegistro(JTable tablaAlumnos, JTextField alumno, JTextField contraseña) { // METODO SELECCIONAR Y MOSTRAR REGISTROS 

        try {

            int fila = tablaAlumnos.getSelectedRow();
            if (fila >= 0) {

                alumno.setText(tablaAlumnos.getValueAt(fila, 0).toString());
                contraseña.setText(tablaAlumnos.getValueAt(fila, 1).toString());

                String alum = JtfNomAlumn.getText().trim();
                Connection conexion = DriverManager.getConnection("jdbc:mysql://localhost/tiendatea", "root", "");

                PreparedStatement pst = conexion.prepareStatement("select id_contraseña from alumnos where nom_alumn=?");
                pst.setString(1, alum.trim());
                ResultSet rs = pst.executeQuery();

                if (rs.next()) {

                    ID = rs.getString("id_contraseña");
                    //JOptionPane.showMessageDialog(null, "ID: "+rs.getString("id_contraseña")); // DEBUG ID

                } else {
                    JOptionPane.showMessageDialog(null, "Contacto no registrado");
                }

            } else {
                JOptionPane.showMessageDialog(null, "Fila no seleccionada");
            }

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Error: " + e.getMessage());
        }
    }

    private void agregarAlumno() { // ------------ Agregar alumno (metodo) ---------------------

        if (JtfNomAlumn.getText().equals("") || JtfPassAlumno.getText().equals("")) {
            JOptionPane.showMessageDialog(null, "Campos vacios");
        } else {

            try {

                Connection conexion = DriverManager.getConnection("jdbc:mysql://localhost/tiendatea", "root", "");
                PreparedStatement pst = conexion.prepareStatement("insert into alumnos values(?,?,?)");

                pst.setString(1, "0");
                pst.setString(2, JtfNomAlumn.getText().trim());
                pst.setString(3, JtfPassAlumno.getText().trim());
                pst.executeUpdate();
                limpiar();
                mostrarAlumTabla();

                JOptionPane.showMessageDialog(null, "Alumno registrado");
                

            } catch (Exception e) {

                JOptionPane.showMessageDialog(null, "Error: " + e.getMessage());
            }
        }

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
            java.util.logging.Logger.getLogger(AgregarAlumnos.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(AgregarAlumnos.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(AgregarAlumnos.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(AgregarAlumnos.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new AgregarAlumnos().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTable JTableAlumnos;
    private javax.swing.JButton JbtnAgregarAlu;
    private javax.swing.JButton JbtnElimAlu;
    private javax.swing.JLabel JlbNomAlumn;
    private javax.swing.JLabel JlbNomAlumn1;
    private javax.swing.JTextField JtfNomAlumn;
    private javax.swing.JTextField JtfPassAlumno;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JSeparator jSeparator2;
    // End of variables declaration//GEN-END:variables
}
