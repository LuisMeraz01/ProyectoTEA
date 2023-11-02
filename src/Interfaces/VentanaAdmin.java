package Interfaces;

import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.sql.Blob;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import javax.imageio.ImageIO;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JComboBox;
import javax.swing.JFileChooser;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.JTextField;
//import javax.swing.SwingConstants;
//import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;

public class VentanaAdmin extends javax.swing.JFrame {

    DefaultTableModel modelo = new DefaultTableModel(); // Crear Modelo para tabla

    public VentanaAdmin() {

        initComponents();

        // Configuracion de la tabla ------------------------------------
        String[] encabezado = new String[]{"Producto", "Categoria", "Precio"};
        modelo.setColumnIdentifiers(encabezado);
        JTableProductos.setModel(modelo);

        // --------------------------------------------------------------
        JbtnModificar.setEnabled(false);
        JbtnEliminar.setEnabled(false);

        this.setLocationRelativeTo(null);
        this.setTitle("Administracion");
        this.setExtendedState(MAXIMIZED_BOTH);
        cargarImagenes();
        cargarImgDefault();
        mostrar();
    }

    private void cargarImagenes() { // Mostrar Imagenes en el Frame

        ImageIcon log = new ImageIcon("src/Imagenes/LogoCentro.jpg");
        Icon Logo = new ImageIcon(log.getImage().getScaledInstance(JlbLogoImg.getWidth(), JlbLogoImg.getHeight(), Image.SCALE_DEFAULT));
        JlbLogoImg.setIcon(Logo);
        JlbLogoImg.repaint();

        ImageIcon pie = new ImageIcon("src/Imagenes/piezas.png");
        Icon pieza = new ImageIcon(pie.getImage().getScaledInstance(JlbPiezasImg1.getWidth(), JlbPiezasImg1.getHeight(), Image.SCALE_DEFAULT));
        JlbPiezasImg1.setIcon(pieza);
        JlbPiezasImg1.repaint();

    }

    public void mostrar() { // Metodo para mostrar la tabla actualizada cada vez que haya una modificacion

        String sql = "select * from productos order by categoria ASC";
        Statement st;

        JTableProductos.setDefaultRenderer(Object.class, new TablaImagen());// Establecer renderizado con clase Tabla Imagen

        DefaultTableModel model = new DefaultTableModel();
        model.addColumn("Producto");
        model.addColumn("Categoria");
        model.addColumn("Precio");
        model.addColumn("Foto");

        Object datos[] = new Object[4];

        try { // MOSTRAR TODOS LOS DATOS DE LA BD EN LA TABLA DE INFORMACION DE PRODUCTOS

            Connection conexion = DriverManager.getConnection("jdbc:mysql://localhost/tiendatea", "root", "");
            st = conexion.createStatement();
            ResultSet rs = st.executeQuery(sql);

            JTableProductos.setRowHeight(120);
            while (rs.next()) {

                datos[0] = rs.getString(2);
                datos[1] = rs.getString(3);
                datos[2] = rs.getString(4);

                Blob blob = rs.getBlob(5); // Leer tipo de dato binario para la foto

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
                        Icon imgProduct = new ImageIcon(rutaImg.getImage().getScaledInstance(150, JTableProductos.getRowHeight(), Image.SCALE_DEFAULT));

                        imagePro.setIcon(imgProduct);
                        imagePro.repaint();

                        datos[3] = imagePro;

                    } catch (Exception e) {
                        datos[3] = "No imagen";
                    }
                } else {
                    datos[3] = "No imagen";
                }

                model.addRow(datos);

            }
            JTableProductos.setModel(model);
            // establecer el alto de las filas

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Error: " + e.getMessage());
        }

        // CODIGO PARA MOSTRAR LAS CATEGORIAS EN EL COMBO BOX CADA VEZ QUE SE ACTUALIZE
        try {

            // Establecemos la conexion
            Connection conexion = DriverManager.getConnection("jdbc:mysql://localhost/tiendatea", "root", "");

            // Preparamos la consulta
            Statement stat = conexion.createStatement();

            // Se realiza la consulta
            ResultSet rs = stat.executeQuery("SELECT nombre_cat FROM categoria");

            // Bucle while para la consulta
            while (rs.next()) {
                // Comenzamos a rellenar el combobox a partir de la consulta
                JCbCategorias.addItem(String.valueOf(rs.getObject("nombre_cat")));
            }

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Error: " + e.getMessage());
        }

    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        JlbLogoImg = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        jLabel4 = new javax.swing.JLabel();
        JbtnSalirLogin = new javax.swing.JButton();
        JlbProducto = new javax.swing.JLabel();
        JlbProducto1 = new javax.swing.JLabel();
        JlbProducto2 = new javax.swing.JLabel();
        jSeparator1 = new javax.swing.JSeparator();
        JtfPrecio = new javax.swing.JTextField();
        jSeparator3 = new javax.swing.JSeparator();
        jPanel3 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        JTableProductos = new javax.swing.JTable();
        JbtnAgregar = new javax.swing.JButton();
        JbtnAgreCategoria = new javax.swing.JButton();
        JCbCategorias = new javax.swing.JComboBox<>();
        JlbProducto3 = new javax.swing.JLabel();
        JbtnModificar = new javax.swing.JButton();
        jButton1 = new javax.swing.JButton();
        JbtnEliminar = new javax.swing.JButton();
        JbtnLimpiar = new javax.swing.JButton();
        JlblImagen = new javax.swing.JLabel();
        jButton2 = new javax.swing.JButton();
        JlblURL = new javax.swing.JLabel();
        JlbPiezasImg1 = new javax.swing.JLabel();
        JtfProducto = new javax.swing.JTextField();
        jSeparator4 = new javax.swing.JSeparator();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel1.setBackground(new java.awt.Color(26, 91, 117));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        JlbLogoImg.setOpaque(true);
        jPanel1.add(JlbLogoImg, new org.netbeans.lib.awtextra.AbsoluteConstraints(1270, 20, 70, 60));

        jPanel2.setBackground(new java.awt.Color(128, 213, 247));
        jPanel2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel4.setBackground(new java.awt.Color(0, 0, 0));
        jLabel4.setFont(new java.awt.Font("Lucida Bright", 0, 20)); // NOI18N
        jLabel4.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel4.setText("Registro de productos");
        jPanel2.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 10, 500, 40));

        jPanel1.add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1370, 60));

        JbtnSalirLogin.setFont(new java.awt.Font("Lucida Bright", 0, 11)); // NOI18N
        JbtnSalirLogin.setText("Salir");
        JbtnSalirLogin.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        JbtnSalirLogin.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                JbtnSalirLoginActionPerformed(evt);
            }
        });
        jPanel1.add(JbtnSalirLogin, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 650, 90, 30));

        JlbProducto.setFont(new java.awt.Font("Lucida Bright", 0, 15)); // NOI18N
        JlbProducto.setForeground(new java.awt.Color(255, 255, 255));
        JlbProducto.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        JlbProducto.setText("Información de productos");
        jPanel1.add(JlbProducto, new org.netbeans.lib.awtextra.AbsoluteConstraints(760, 70, 250, 40));

        JlbProducto1.setFont(new java.awt.Font("Lucida Bright", 0, 15)); // NOI18N
        JlbProducto1.setForeground(new java.awt.Color(255, 255, 255));
        JlbProducto1.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        JlbProducto1.setText("Categoria");
        jPanel1.add(JlbProducto1, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 130, 80, 40));

        JlbProducto2.setFont(new java.awt.Font("Lucida Bright", 0, 15)); // NOI18N
        JlbProducto2.setForeground(new java.awt.Color(255, 255, 255));
        JlbProducto2.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        JlbProducto2.setText("Precio c/u $");
        jPanel1.add(JlbProducto2, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 230, 100, 40));
        jPanel1.add(jSeparator1, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 110, 220, 20));

        JtfPrecio.setBackground(new java.awt.Color(26, 91, 117));
        JtfPrecio.setFont(new java.awt.Font("Lucida Bright", 0, 12)); // NOI18N
        JtfPrecio.setForeground(new java.awt.Color(255, 255, 255));
        JtfPrecio.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        JtfPrecio.setBorder(null);
        jPanel1.add(JtfPrecio, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 240, 200, 20));
        jPanel1.add(jSeparator3, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 500, 300, 20));

        jPanel3.setBackground(new java.awt.Color(255, 255, 255));
        jPanel3.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        JTableProductos.setBackground(new java.awt.Color(26, 91, 117));
        JTableProductos.setFont(new java.awt.Font("Lucida Bright", 0, 14)); // NOI18N
        JTableProductos.setForeground(new java.awt.Color(255, 255, 255));
        JTableProductos.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {},
                {},
                {},
                {}
            },
            new String [] {

            }
        ));
        JTableProductos.setRowHeight(25);
        JTableProductos.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                JTableProductosMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(JTableProductos);

        jPanel3.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 30, 880, 480));

        jPanel1.add(jPanel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(370, 110, 970, 570));

        JbtnAgregar.setFont(new java.awt.Font("Lucida Bright", 0, 11)); // NOI18N
        JbtnAgregar.setText("Agregar Producto");
        JbtnAgregar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                JbtnAgregarActionPerformed(evt);
            }
        });
        jPanel1.add(JbtnAgregar, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 530, 130, 30));

        JbtnAgreCategoria.setFont(new java.awt.Font("Lucida Bright", 0, 11)); // NOI18N
        JbtnAgreCategoria.setText("Agregar Categoria");
        JbtnAgreCategoria.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                JbtnAgreCategoriaActionPerformed(evt);
            }
        });
        jPanel1.add(JbtnAgreCategoria, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 190, -1, -1));

        jPanel1.add(JCbCategorias, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 140, 220, -1));

        JlbProducto3.setFont(new java.awt.Font("Lucida Bright", 0, 15)); // NOI18N
        JlbProducto3.setForeground(new java.awt.Color(255, 255, 255));
        JlbProducto3.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        JlbProducto3.setText("Producto");
        jPanel1.add(JlbProducto3, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 80, 80, 40));

        JbtnModificar.setFont(new java.awt.Font("Lucida Bright", 0, 11)); // NOI18N
        JbtnModificar.setText("Modificar registro");
        JbtnModificar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                JbtnModificarActionPerformed(evt);
            }
        });
        jPanel1.add(JbtnModificar, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 580, 130, 40));

        jButton1.setFont(new java.awt.Font("Lucida Bright", 0, 11)); // NOI18N
        jButton1.setText("Agregar Alumno");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        jPanel1.add(jButton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 650, 130, 30));

        JbtnEliminar.setFont(new java.awt.Font("Lucida Bright", 0, 11)); // NOI18N
        JbtnEliminar.setText("Eliminar Registro");
        JbtnEliminar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                JbtnEliminarActionPerformed(evt);
            }
        });
        jPanel1.add(JbtnEliminar, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 580, 130, 40));

        JbtnLimpiar.setFont(new java.awt.Font("Lucida Bright", 0, 11)); // NOI18N
        JbtnLimpiar.setText("Limpiar campos");
        JbtnLimpiar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                JbtnLimpiarActionPerformed(evt);
            }
        });
        jPanel1.add(JbtnLimpiar, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 530, 130, 30));

        JlblImagen.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 255, 255)));
        jPanel1.add(JlblImagen, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 290, 160, 160));

        jButton2.setFont(new java.awt.Font("Lucida Bright", 0, 11)); // NOI18N
        jButton2.setText("Cargar Imagen");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });
        jPanel1.add(jButton2, new org.netbeans.lib.awtextra.AbsoluteConstraints(220, 350, -1, -1));

        JlblURL.setFont(new java.awt.Font("Lucida Bright", 0, 12)); // NOI18N
        JlblURL.setForeground(new java.awt.Color(255, 255, 255));
        jPanel1.add(JlblURL, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 480, 300, 20));

        JlbPiezasImg1.setBackground(new java.awt.Color(26, 91, 117));
        JlbPiezasImg1.setOpaque(true);
        jPanel1.add(JlbPiezasImg1, new org.netbeans.lib.awtextra.AbsoluteConstraints(-20, 430, 620, 250));

        JtfProducto.setBackground(new java.awt.Color(26, 91, 117));
        JtfProducto.setFont(new java.awt.Font("Lucida Bright", 0, 12)); // NOI18N
        JtfProducto.setForeground(new java.awt.Color(255, 255, 255));
        JtfProducto.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        JtfProducto.setBorder(null);
        jPanel1.add(JtfProducto, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 90, 220, 20));
        jPanel1.add(jSeparator4, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 260, 200, 20));

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1370, 720));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void JbtnSalirLoginActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_JbtnSalirLoginActionPerformed
        // CLICK SALIR AL LOGIN
        LoginCafeteria log = new LoginCafeteria();
        log.setVisible(true);
        this.dispose();

    }//GEN-LAST:event_JbtnSalirLoginActionPerformed


    private void JbtnAgregarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_JbtnAgregarActionPerformed
        // BOTON AGREGAR PRODUCTO

        String url = JlblURL.getText();
        String prod = JtfProducto.getText();
        String precio = JtfPrecio.getText();

        if (url.trim().length() != 0 || prod.trim().length() != 0 || precio.trim().length() != 0) {
            agregarRegistro(ruta);
        } else {
            JOptionPane.showMessageDialog(null, "Campos vacios");
        }

    }//GEN-LAST:event_JbtnAgregarActionPerformed

    private void agregarRegistro(String ruta) {

        try {

            //CONEXION A BD PARA AGREGAR
            Connection conexion = DriverManager.getConnection("jdbc:mysql://localhost/tiendatea", "root", "");
            // imagen
            FileInputStream fi = null;
            PreparedStatement pst = conexion.prepareStatement("insert into productos values(?,?,?,?,?)");

            File file = new File(ruta);
            fi = new FileInputStream(file);

            pst.setString(1, "0");
            pst.setString(2, JtfProducto.getText().trim());
            pst.setString(3, String.valueOf(JCbCategorias.getSelectedItem()));
            pst.setString(4, JtfPrecio.getText().trim());
            pst.setBinaryStream(5, fi);

            pst.executeUpdate();
            mostrar();
            JOptionPane.showMessageDialog(null, "Registro exitoso");

            //JtfCategoria.setText("");
            JtfProducto.setText("");
            JtfPrecio.setText("");

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Error: " + e.getMessage());
        }

    }


    private void JbtnAgreCategoriaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_JbtnAgreCategoriaActionPerformed
        // DESPLEGAR PANEL PARA AGREGAR CATEGORIA
        AddCategoria cat = new AddCategoria();
        cat.setVisible(true);
    }//GEN-LAST:event_JbtnAgreCategoriaActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // ABRIR PANEL AGREGAR ALUMNOS AL DAR CLICK
        AgregarAlumnos add = new AgregarAlumnos();
        add.setVisible(true);
    }//GEN-LAST:event_jButton1ActionPerformed

    private void JTableProductosMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_JTableProductosMouseClicked
        // TODO add your handling code here:
        seleccionarProducto(JTableProductos, JtfProducto, JCbCategorias, JtfPrecio);
        JbtnModificar.setEnabled(true);
        JbtnEliminar.setEnabled(true);
        JbtnAgregar.setEnabled(false);


    }//GEN-LAST:event_JTableProductosMouseClicked

    private void JbtnLimpiarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_JbtnLimpiarActionPerformed
        // TODO add your handling code here:
        limpiar();
        JbtnModificar.setEnabled(false);
        JbtnEliminar.setEnabled(false);
    }//GEN-LAST:event_JbtnLimpiarActionPerformed

    private void JbtnModificarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_JbtnModificarActionPerformed
        // BOTON PARA MODIFICAR REGISTRO
        modificarProducto();
    }//GEN-LAST:event_JbtnModificarActionPerformed

    private void JbtnEliminarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_JbtnEliminarActionPerformed
        // BOTON MANDAR A LLAMAR METODO PARA ELIMINAR
        int res = JOptionPane.showConfirmDialog(this, "¿Borrar producto?", "Confirm", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);

        if (res == JOptionPane.YES_OPTION) { // Confirmar eliminacion de registro
            eliminarRegistro();
        }

    }//GEN-LAST:event_JbtnEliminarActionPerformed

    String ruta = null;

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        // CARGAR IMAGEN
        JFileChooser j = new JFileChooser();

        int ap = j.showOpenDialog(this);
        if (ap == JFileChooser.APPROVE_OPTION) {

            ruta = j.getSelectedFile().getAbsolutePath();
            //JlblImagen.setIcon(new ImageIcon(ruta));

            ImageIcon rutaImg = new ImageIcon(ruta);
            Icon imgProduct = new ImageIcon(rutaImg.getImage().getScaledInstance(JlblImagen.getWidth(), JlblImagen.getHeight(), Image.SCALE_DEFAULT));
            JlblImagen.setIcon(imgProduct);
            JlblImagen.repaint();

            JlblURL.setText(ruta);
        }


    }//GEN-LAST:event_jButton2ActionPerformed

    private void eliminarRegistro() { // METODO PARA ELIMINAR REGISTRO

        try {

            Connection conexion = DriverManager.getConnection("jdbc:mysql://localhost/tiendatea", "root", "");
            PreparedStatement pst = conexion.prepareStatement("delete from productos where id_producto =" + ID);

            pst.executeUpdate();
            mostrar();
            limpiar();
            JOptionPane.showMessageDialog(null, "Registro eliminado");
            JbtnAgregar.setEnabled(true);

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Error: " + e.getMessage());
        }

    }

    private void modificarProducto() { // METODOO PARA MODIFICAR REGISTROS EN BD Y ACTUALIZAR TABLAS

        try {

            Connection conexion = DriverManager.getConnection("jdbc:mysql://localhost/tiendatea", "root", "");

            FileInputStream fi = null;
            File file = new File(ruta);
            fi = new FileInputStream(file);

            PreparedStatement pst = conexion.prepareStatement("update productos set nombre =? where id_producto =" + ID);
            pst.setString(1, JtfProducto.getText().trim());
            PreparedStatement pst1 = conexion.prepareStatement("update productos set categoria =? where id_producto =" + ID);
            pst1.setString(1, String.valueOf(JCbCategorias.getSelectedItem()));
            PreparedStatement pst2 = conexion.prepareStatement("update productos set precioUnitario =? where id_producto =" + ID);
            pst2.setString(1, JtfPrecio.getText().trim());
            PreparedStatement pst3 = conexion.prepareStatement("update productos set foto_prod =? where id_producto =" + ID);
            pst3.setBinaryStream(1, fi);

            pst.executeUpdate();
            pst1.executeUpdate();
            pst2.executeUpdate();
            pst3.executeUpdate();

            mostrar();
            JOptionPane.showMessageDialog(null, "Modificacion exitosa");

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Error " + e);
        }

    }

    private void limpiar() {
        JtfProducto.setText("");
        JCbCategorias.setSelectedIndex(0);
        JtfPrecio.setText("");
        JbtnAgregar.setEnabled(true);
        cargarImgDefault();
    }

    private void cargarImgDefault() {

        ImageIcon log = new ImageIcon("src/Imagenes/imagen.png");
        Icon Logo = new ImageIcon(log.getImage().getScaledInstance(JlblImagen.getWidth(), JlblImagen.getHeight(), Image.SCALE_DEFAULT));
        JlblImagen.setIcon(Logo);
        JlblImagen.repaint();
    }

    public String ID;

    // METODO PARA SELECCIONAR LA FILA PARA PODER MODIFICARLA EN LOS CAMPOS
    public void seleccionarProducto(JTable paraTablaProductos, JTextField producto, JComboBox categoria, JTextField precio) {

        try {

            int fila = paraTablaProductos.getSelectedRow();
            if (fila >= 0) {

                producto.setText(paraTablaProductos.getValueAt(fila, 0).toString());
                categoria.setSelectedItem(paraTablaProductos.getValueAt(fila, 1).toString());
                precio.setText(paraTablaProductos.getValueAt(fila, 2).toString());
                imprimirImagen();

                String product = JtfProducto.getText().trim();
                Connection conexion = DriverManager.getConnection("jdbc:mysql://localhost/tiendatea", "root", "");

                PreparedStatement pst = conexion.prepareStatement("select id_producto from productos where nombre=?");
                pst.setString(1, product.trim());
                ResultSet rs = pst.executeQuery();

                if (rs.next()) {

                    ID = rs.getString("id_producto");
                    //JOptionPane.showMessageDialog(null, "ID: "+rs.getString("id_producto"));

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

    public void imprimirImagen() {

        ResultSet rs = null;
        try {
            Connection conexion = DriverManager.getConnection("jdbc:mysql://localhost/tiendatea", "root", "");

            String sql = ("select foto_prod from productos where id_producto =" + ID);
            Statement st = conexion.createStatement();
            rs = st.executeQuery(sql);

            // Cargar imagen en label desde la BD
            while (rs.next()) {
                Blob blob = rs.getBlob(5); // Leer tipo de dato binario para la foto

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
                        ImageIcon rutaImg = new ImageIcon(img);
                        Icon imgProduct = new ImageIcon(rutaImg.getImage().getScaledInstance(JlblImagen.getWidth(), JlblImagen.getHeight(), Image.SCALE_DEFAULT));

                        JlblImagen.setIcon(imgProduct);
                        JlblImagen.repaint();
                        JOptionPane.showMessageDialog(null, "HEEEYYY");

                    } catch (Exception e) {
                        JOptionPane.showMessageDialog(null, "Error: " + e.getMessage());
                    }
                }
            }

        } catch (Exception e) {

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
            java.util.logging.Logger.getLogger(VentanaAdmin.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(VentanaAdmin.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(VentanaAdmin.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(VentanaAdmin.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new VentanaAdmin().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JComboBox<String> JCbCategorias;
    private javax.swing.JTable JTableProductos;
    private javax.swing.JButton JbtnAgreCategoria;
    private javax.swing.JButton JbtnAgregar;
    private javax.swing.JButton JbtnEliminar;
    private javax.swing.JButton JbtnLimpiar;
    private javax.swing.JButton JbtnModificar;
    private javax.swing.JButton JbtnSalirLogin;
    private javax.swing.JLabel JlbLogoImg;
    private javax.swing.JLabel JlbPiezasImg1;
    private javax.swing.JLabel JlbProducto;
    private javax.swing.JLabel JlbProducto1;
    private javax.swing.JLabel JlbProducto2;
    private javax.swing.JLabel JlbProducto3;
    private javax.swing.JLabel JlblImagen;
    private javax.swing.JLabel JlblURL;
    private javax.swing.JTextField JtfPrecio;
    private javax.swing.JTextField JtfProducto;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JSeparator jSeparator3;
    private javax.swing.JSeparator jSeparator4;
    // End of variables declaration//GEN-END:variables
}
