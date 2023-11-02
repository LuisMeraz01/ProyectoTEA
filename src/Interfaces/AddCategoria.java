package Interfaces;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

public class AddCategoria extends javax.swing.JFrame {

    DefaultTableModel modelo = new DefaultTableModel(); // Crear Modelo para tabla

    public AddCategoria() {
        initComponents();

        // Configuracion de la tabla ------------------------------------
        String[] encabezado = new String[]{"Categoria"};
        modelo.setColumnIdentifiers(encabezado);
        JTableCategorias.setModel(modelo);
        // --------------------------------------------------------------
        mostrar();
        this.setLocationRelativeTo(null);
        this.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
    }

    private void mostrar() {

        String sql = "select * from categoria";
        Statement st;

        DefaultTableModel model = new DefaultTableModel();
        model.addColumn("Categoria");

        JTableCategorias.setModel(model);
        String datos[] = new String[1];

        try { // MOSTRAR TODOS LOS DATOS DE LA BD DE CATEGORIA EN LA TABLA

            Connection conexion = DriverManager.getConnection("jdbc:mysql://localhost/tiendatea", "root", "");
            st = conexion.createStatement();
            ResultSet rs = st.executeQuery(sql);

            while (rs.next()) {

                datos[0] = rs.getString(2);
                model.addRow(datos);

            }

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Error: " + e.getMessage());
        }

    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel2 = new javax.swing.JPanel();
        jPanel1 = new javax.swing.JPanel();
        JlbProducto1 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        JtfCategoria = new javax.swing.JTextField();
        JbtnAgregarCate = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        JTableCategorias = new javax.swing.JTable();
        jSeparator1 = new javax.swing.JSeparator();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel2.setBackground(new java.awt.Color(255, 255, 255));
        jPanel2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel1.setBackground(new java.awt.Color(26, 91, 117));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        JlbProducto1.setFont(new java.awt.Font("Lucida Bright", 0, 15)); // NOI18N
        JlbProducto1.setForeground(new java.awt.Color(255, 255, 255));
        JlbProducto1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        JlbProducto1.setText("Agregar categoria");
        jPanel1.add(JlbProducto1, new org.netbeans.lib.awtextra.AbsoluteConstraints(220, 0, 150, 40));

        jPanel2.add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 580, 40));

        jLabel1.setFont(new java.awt.Font("Lucida Bright", 0, 15)); // NOI18N
        jLabel1.setText("Categoria");
        jPanel2.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 110, -1, -1));

        JtfCategoria.setFont(new java.awt.Font("Lucida Bright", 0, 12)); // NOI18N
        JtfCategoria.setBorder(null);
        jPanel2.add(JtfCategoria, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 110, 190, 20));

        JbtnAgregarCate.setFont(new java.awt.Font("Lucida Bright", 0, 12)); // NOI18N
        JbtnAgregarCate.setText("Agregar");
        JbtnAgregarCate.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                JbtnAgregarCateActionPerformed(evt);
            }
        });
        jPanel2.add(JbtnAgregarCate, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 180, -1, -1));

        JTableCategorias.setBackground(new java.awt.Color(26, 91, 117));
        JTableCategorias.setFont(new java.awt.Font("Lucida Bright", 0, 12)); // NOI18N
        JTableCategorias.setForeground(new java.awt.Color(255, 255, 255));
        JTableCategorias.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {},
                {},
                {},
                {}
            },
            new String [] {

            }
        ));
        JTableCategorias.setRowHeight(25);
        jScrollPane1.setViewportView(JTableCategorias);

        jPanel2.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(320, 60, 230, 200));
        jPanel2.add(jSeparator1, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 130, 190, 20));

        getContentPane().add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 580, 290));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void JbtnAgregarCateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_JbtnAgregarCateActionPerformed
        // AGREGAR CATEGORIA A LA BD Y REFLEJARLA EN LA TABLA

        if (JtfCategoria.getText().equals("")) {
            JOptionPane.showMessageDialog(null, "Agrege una categoria");
        } else {

            try {

                Connection conexion = DriverManager.getConnection("jdbc:mysql://localhost/tiendatea", "root", "");
                PreparedStatement pst = conexion.prepareStatement("insert into categoria values(?,?)");

                pst.setString(1, "0");
                pst.setString(2, JtfCategoria.getText().trim());
                pst.executeUpdate();
                mostrar();
                VentanaAdmin obj = new VentanaAdmin();
                obj.mostrar();
                JOptionPane.showMessageDialog(null, "Categoria agregada correctamente");

                JtfCategoria.setText("");
                //this.dispose();

            } catch (Exception e) {

                JOptionPane.showMessageDialog(null, "Error: " + e.getMessage());
            }
        }
    }//GEN-LAST:event_JbtnAgregarCateActionPerformed

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
            java.util.logging.Logger.getLogger(AddCategoria.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(AddCategoria.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(AddCategoria.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(AddCategoria.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new AddCategoria().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTable JTableCategorias;
    private javax.swing.JButton JbtnAgregarCate;
    private javax.swing.JLabel JlbProducto1;
    private javax.swing.JTextField JtfCategoria;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JSeparator jSeparator1;
    // End of variables declaration//GEN-END:variables
}
