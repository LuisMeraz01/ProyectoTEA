package Interfaces;

import java.awt.Color;
import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.ByteArrayInputStream;
import java.sql.Blob;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Timer;
import javax.imageio.ImageIO;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import java.util.TimerTask;
import javax.swing.table.DefaultTableModel;

public class Ventas1 extends javax.swing.JFrame {

    DefaultTableModel modelo = new DefaultTableModel();

    public Ventas1() {
        initComponents();
        this.setLocationRelativeTo(null);
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.setExtendedState(MAXIMIZED_BOTH);
        cargarImagenes();
        mostrarInfoTabla();
        cargarTimer();
        JlbSalir.setBackground(Color.white);

        //TABLA
        JTableCuenta.setModel(modelo);
        modelo.addColumn("Producto");
        modelo.addColumn("Precio Unitario");

    }

    private void cargarImagenes() {

        ImageIcon log = new ImageIcon("src/Imagenes/buscar.png");
        Icon Logo = new ImageIcon(log.getImage().getScaledInstance(JlbImgBuscar.getWidth(), JlbImgBuscar.getHeight(), Image.SCALE_DEFAULT));
        JlbImgBuscar.setIcon(Logo);
        JlbImgBuscar.repaint();

        ImageIcon pie = new ImageIcon("src/Imagenes/piezas.png");
        Icon pieza = new ImageIcon(pie.getImage().getScaledInstance(JlbPiezasImg1.getWidth(), JlbPiezasImg1.getHeight(), Image.SCALE_DEFAULT));
        JlbPiezasImg1.setIcon(pieza);
        JlbPiezasImg1.repaint();

        ImageIcon salir = new ImageIcon("src/Imagenes/terminarHand.png");
        Icon terminar = new ImageIcon(salir.getImage().getScaledInstance(JlbSalir.getWidth(), JlbSalir.getHeight(), Image.SCALE_DEFAULT));
        JlbSalir.setIcon(terminar);
        JlbSalir.repaint();

    }

    private void mostrarInfoTabla() {

        String sql = "select foto_prod,nombre,precioUnitario from productos order by nombre ASC";
        Statement st;

        JTableProd.setDefaultRenderer(Object.class, new TablaImagen());// Establecer renderizado con clase Tabla Imagen

        DefaultTableModel model = new DefaultTableModel();
        model.addColumn("Foto");
        model.addColumn("Producto");
        model.addColumn("Precio");

        Object datos[] = new Object[3];

        try {

            Connection conexion = DriverManager.getConnection("jdbc:mysql://localhost/tiendatea", "root", "");
            st = conexion.createStatement();
            ResultSet rs = st.executeQuery(sql);

            JTableProd.setRowHeight(120);
            while (rs.next()) {

                datos[1] = rs.getString(2);
                datos[2] = rs.getString(3);

                Blob blob = rs.getBlob(1); // Leer tipo de dato binario para la foto

                if (blob != null) {

                    try {

                        byte[] data = blob.getBytes(1, (int) blob.length());
                        BufferedImage img = null;
                        try {
                            img = ImageIO.read(new ByteArrayInputStream(data));
                        } catch (Exception e) {
                            JOptionPane.showMessageDialog(null, "Error: " + e.getMessage());
                        }

                        // codigo original
                        /*ImageIcon icono = new ImageIcon(img);
                        datos[3] = new JLabel(icono); // mostrar la imagen a traves de un label en la tabla*/
                        JLabel imagePro = new JLabel();
                        ImageIcon rutaImg = new ImageIcon(img);
                        Icon imgProduct = new ImageIcon(rutaImg.getImage().getScaledInstance(120, JTableProd.getRowHeight(), Image.SCALE_DEFAULT));

                        imagePro.setIcon(imgProduct);
                        imagePro.repaint();
                        imagePro.setBackground(new Color(26, 91, 117));

                        datos[0] = imagePro;

                    } catch (Exception e) {
                        datos[0] = "No imagen";
                    }
                } else {
                    datos[0] = "No imagen";
                }

                model.addRow(datos);

            }
            JTableProd.setModel(model);

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Error: " + e.getMessage());
        }

    }

    private void cargarTimer() { // CARGAR TIMER

        Timer timer = new Timer();

        TimerTask tarea = new TimerTask() {
            @Override
            public void run() {
                mostrarRecordatorios();
            }
        };

        timer.schedule(tarea, 0, 3000); // Establecer que tarea se realizara, cuando iniciaria y cada cuanto se ejecutara
    }

    int val = 0; // valor inicial arreglo de recordatorios

    private void mostrarRecordatorios() { // TAREA QUE HARA EL TIMER CADA CIERTO TIEMPO

        String recordatorios[] = new String[10];
        String rutas[] = new String[10];
        // Llenar arreglo recordatorio 
        recordatorios[0] = "Recuerda siempre sonreir y tratar bien al cliente :)";
        recordatorios[1] = "No olvides decir buenos dias o buenas tardes :)";
        recordatorios[2] = "Dar gracias al cliente por su compra es importante";
        recordatorios[3] = "Manten tu area de trabajo limpia y ordenada";
        recordatorios[4] = "5";
        recordatorios[5] = "6";
        recordatorios[6] = "7";
        recordatorios[7] = "8";
        recordatorios[8] = "9";
        recordatorios[9] = "10";

        // Llenar arreglo rutas (imagenes)
        rutas[0] = "feliz";
        rutas[1] = "hola";
        rutas[2] = "agradecer";
        rutas[3] = "ordenanza";
        rutas[4] = "reir";
        rutas[5] = "reir";
        rutas[6] = "reir";
        rutas[7] = "reir";
        rutas[8] = "reir";
        rutas[9] = "reir";

        // Imprimir labels
        ImageIcon record = new ImageIcon("src/Imagenes/" + rutas[val] + ".png");
        Icon imgRecord = new ImageIcon(record.getImage().getScaledInstance(JlbImgRecor.getWidth(), JlbImgRecor.getHeight(), Image.SCALE_DEFAULT));
        JlbImgRecor.setIcon(imgRecord);
        JlbImgRecor.repaint();

        JlbRecordatorio.setText(recordatorios[val]);
        val++;
        if (val == 10) {
            val = 0;
        }
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        JlbSalir = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        jPanel3 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        JTableProd = new javax.swing.JTable();
        JlbImgBuscar = new javax.swing.JLabel();
        JlbProducto1 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jPanel4 = new javax.swing.JPanel();
        jScrollPane3 = new javax.swing.JScrollPane();
        JTableCuenta = new javax.swing.JTable();
        JlbProducto = new javax.swing.JLabel();
        JlbTotal = new javax.swing.JLabel();
        JlbCambio = new javax.swing.JLabel();
        JtfEfectivo = new javax.swing.JFormattedTextField();
        JlbRecordatorio = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        JlbImgRecor = new javax.swing.JLabel();
        JlbPiezasImg1 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setMinimumSize(new java.awt.Dimension(1370, 720));
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel1.setBackground(new java.awt.Color(128, 213, 247));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        JlbSalir.setBackground(new java.awt.Color(255, 255, 255));
        JlbSalir.setOpaque(true);
        JlbSalir.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                JlbSalirMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                JlbSalirMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                JlbSalirMouseExited(evt);
            }
        });
        jPanel1.add(JlbSalir, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 610, 100, 80));

        jPanel2.setBackground(new java.awt.Color(26, 91, 117));
        jPanel2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());
        jPanel1.add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 680, 1370, 40));

        jPanel3.setBackground(new java.awt.Color(255, 255, 255));
        jPanel3.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        JTableProd.setBackground(new java.awt.Color(26, 91, 117));
        JTableProd.setFont(new java.awt.Font("Lucida Bright", 0, 15)); // NOI18N
        JTableProd.setForeground(new java.awt.Color(255, 255, 255));
        JTableProd.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {},
                {},
                {},
                {}
            },
            new String [] {

            }
        ));
        JTableProd.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                JTableProdMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(JTableProd);

        jPanel3.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 60, 690, 500));

        JlbImgBuscar.setBackground(new java.awt.Color(255, 255, 255));
        JlbImgBuscar.setOpaque(true);
        jPanel3.add(JlbImgBuscar, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 150, 150, 140));

        JlbProducto1.setFont(new java.awt.Font("Lucida Bright", 0, 30)); // NOI18N
        JlbProducto1.setForeground(new java.awt.Color(26, 91, 117));
        JlbProducto1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        JlbProducto1.setText("Productos disponibles");
        jPanel3.add(JlbProducto1, new org.netbeans.lib.awtextra.AbsoluteConstraints(260, 10, 350, 40));

        jLabel3.setFont(new java.awt.Font("Lucida Bright", 0, 15)); // NOI18N
        jLabel3.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel3.setText("la cuenta");
        jPanel3.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 400, 130, 40));

        jLabel6.setFont(new java.awt.Font("Lucida Bright", 0, 15)); // NOI18N
        jLabel6.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel6.setText("Busca aqui el ");
        jPanel3.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 280, 130, 40));

        jLabel7.setFont(new java.awt.Font("Lucida Bright", 0, 15)); // NOI18N
        jLabel7.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel7.setText("producto a llevar");
        jPanel3.add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 310, 130, 40));

        jLabel8.setFont(new java.awt.Font("Lucida Bright", 0, 15)); // NOI18N
        jLabel8.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel8.setText("y dale click");
        jPanel3.add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 340, 130, 40));

        jLabel9.setFont(new java.awt.Font("Lucida Bright", 0, 15)); // NOI18N
        jLabel9.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel9.setText("para agregarlo a");
        jPanel3.add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 370, 130, 40));

        jPanel1.add(jPanel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 20, 880, 580));

        jPanel4.setBackground(new java.awt.Color(255, 255, 255));
        jPanel4.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        JTableCuenta.setFont(new java.awt.Font("Lucida Bright", 0, 14)); // NOI18N
        JTableCuenta.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {},
                {},
                {},
                {}
            },
            new String [] {

            }
        ));
        JTableCuenta.setRowHeight(22);
        JTableCuenta.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                JTableCuentaMouseClicked(evt);
            }
        });
        jScrollPane3.setViewportView(JTableCuenta);

        jPanel4.add(jScrollPane3, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 60, 390, 260));

        JlbProducto.setFont(new java.awt.Font("Lucida Bright", 0, 30)); // NOI18N
        JlbProducto.setForeground(new java.awt.Color(26, 91, 117));
        JlbProducto.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        JlbProducto.setText("Cuenta");
        jPanel4.add(JlbProducto, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 10, 350, 40));

        jPanel1.add(jPanel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(930, 20, 410, 330));

        JlbTotal.setBackground(new java.awt.Color(0, 0, 255));
        JlbTotal.setFont(new java.awt.Font("Lucida Bright", 0, 18)); // NOI18N
        JlbTotal.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        JlbTotal.setText("Total a pagar $");
        jPanel1.add(JlbTotal, new org.netbeans.lib.awtextra.AbsoluteConstraints(930, 370, 210, 40));

        JlbCambio.setFont(new java.awt.Font("Lucida Bright", 0, 18)); // NOI18N
        JlbCambio.setText("Devolver de cambio $0");
        jPanel1.add(JlbCambio, new org.netbeans.lib.awtextra.AbsoluteConstraints(930, 450, 240, 40));

        try {
            JtfEfectivo.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("####")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }
        JtfEfectivo.setFont(new java.awt.Font("Lucida Bright", 0, 18)); // NOI18N
        JtfEfectivo.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                JtfEfectivoKeyReleased(evt);
            }
        });
        jPanel1.add(JtfEfectivo, new org.netbeans.lib.awtextra.AbsoluteConstraints(1100, 410, 200, 30));

        JlbRecordatorio.setBackground(new java.awt.Color(128, 213, 247));
        JlbRecordatorio.setFont(new java.awt.Font("Lucida Bright", 0, 12)); // NOI18N
        JlbRecordatorio.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        JlbRecordatorio.setOpaque(true);
        jPanel1.add(JlbRecordatorio, new org.netbeans.lib.awtextra.AbsoluteConstraints(1050, 520, 300, 40));

        jLabel1.setFont(new java.awt.Font("Lucida Bright", 0, 60)); // NOI18N
        jLabel1.setText("←");
        jPanel1.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 630, 90, 40));

        jLabel4.setFont(new java.awt.Font("Lucida Bright", 0, 18)); // NOI18N
        jLabel4.setText("Efectivo recibido $");
        jPanel1.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(930, 410, 180, 40));

        JlbImgRecor.setBackground(new java.awt.Color(255, 255, 255));
        JlbImgRecor.setOpaque(true);
        jPanel1.add(JlbImgRecor, new org.netbeans.lib.awtextra.AbsoluteConstraints(930, 510, 100, 90));

        JlbPiezasImg1.setBackground(new java.awt.Color(128, 213, 247));
        JlbPiezasImg1.setOpaque(true);
        jPanel1.add(JlbPiezasImg1, new org.netbeans.lib.awtextra.AbsoluteConstraints(790, 480, 620, 250));

        jLabel5.setFont(new java.awt.Font("Lucida Bright", 0, 15)); // NOI18N
        jLabel5.setText("Se termino el dia? click aqui");
        jPanel1.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 610, 260, 40));

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1370, 720));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void JlbSalirMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_JlbSalirMouseClicked
        // TODO add your handling code here:
        PrincipalTEA volver = new PrincipalTEA();
        volver.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_JlbSalirMouseClicked

    private void JTableProdMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_JTableProdMouseClicked
        // EVENTO CLICK EN TABLA PRODUCTOS
        enviarProducto(JTableProd);
    }//GEN-LAST:event_JTableProdMouseClicked

    String ID;

    private void enviarProducto(JTable tabla) {

        try {

            int fila = tabla.getSelectedRow();
            if (fila >= 0) {

                String prod[] = new String[2];

                prod[0] = (tabla.getValueAt(fila, 1).toString());
                prod[1] = (tabla.getValueAt(fila, 2).toString());

                double precioUnit = Double.parseDouble(prod[1]);

                agregarATabla(prod, precioUnit);

                String product = tabla.getValueAt(fila, 1).toString().trim();
                Connection conexion = DriverManager.getConnection("jdbc:mysql://localhost/tiendatea", "root", "");

                PreparedStatement pst = conexion.prepareStatement("select id_producto from productos where nombre=?");
                pst.setString(1, product.trim());
                ResultSet rs = pst.executeQuery();

                if (rs.next()) {

                    ID = rs.getString("id_producto");
                    //JOptionPane.showMessageDialog(null, "ID: "+rs.getString("id_producto")+"\n"+prod[0]+"\n"+prod[1]);

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

    double total = 0;

    private void agregarATabla(String[] a, double precios) {

        total = total + precios;
        modelo.addRow(a);
        JlbTotal.setText("Total a pagar $ " + total);
        //JOptionPane.showMessageDialog(null, "Total: "+total);// DEBUG
    }


    private void JlbSalirMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_JlbSalirMouseEntered
        // TODO add your handling code here:
        JlbSalir.setBackground(Color.yellow);
    }//GEN-LAST:event_JlbSalirMouseEntered

    private void JlbSalirMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_JlbSalirMouseExited
        // TODO add your handling code here:
        JlbSalir.setBackground(Color.white);
    }//GEN-LAST:event_JlbSalirMouseExited

    double efe;
    
    private void JtfEfectivoKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_JtfEfectivoKeyReleased
        // TODO add your handling code here:
        efe = Double.parseDouble(JtfEfectivo.getText());
        if (efe < total) {
            JlbCambio.setText("Devolver de cambio $0");
        } else {

            calcularCambio(total, efe);
        }

    }//GEN-LAST:event_JtfEfectivoKeyReleased

    private void JTableCuentaMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_JTableCuentaMouseClicked
        // TODO add your handling code here:
        eliminarProd(JTableCuenta);
        JlbCambio.setText("Devolver de cambio $0");

    }//GEN-LAST:event_JTableCuentaMouseClicked

    private void eliminarProd(JTable tabla) {

        int fila = tabla.getSelectedRow();
        if (fila >= 0) {
                 
            
            String precio=(tabla.getValueAt(fila, 1).toString());
            double precUn=Double.parseDouble(precio);
            //JOptionPane.showMessageDialog(null, precUn);
            modelo.removeRow(fila);
            
            
            total=total-precUn;
            JlbTotal.setText("Total a pagar $ "+total);
            
        } else {
            JOptionPane.showMessageDialog(null, "Fila no seleccionada");
        }

    }

    private void calcularCambio(double total, double efectivo) {

        double cambio = efectivo - total;
        JlbCambio.setText("Devolver de cambio $" + cambio);

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
            java.util.logging.Logger.getLogger(Ventas1.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Ventas1.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Ventas1.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Ventas1.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Ventas1().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTable JTableCuenta;
    private javax.swing.JTable JTableProd;
    private javax.swing.JLabel JlbCambio;
    private javax.swing.JLabel JlbImgBuscar;
    private javax.swing.JLabel JlbImgRecor;
    private javax.swing.JLabel JlbPiezasImg1;
    private javax.swing.JLabel JlbProducto;
    private javax.swing.JLabel JlbProducto1;
    private javax.swing.JLabel JlbRecordatorio;
    private javax.swing.JLabel JlbSalir;
    private javax.swing.JLabel JlbTotal;
    private javax.swing.JFormattedTextField JtfEfectivo;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane3;
    // End of variables declaration//GEN-END:variables
}
