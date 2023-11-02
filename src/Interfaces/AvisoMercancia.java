
package Interfaces;

import java.awt.Color;
import java.awt.Image;
import javax.swing.Icon;
import javax.swing.ImageIcon;


public class AvisoMercancia extends javax.swing.JFrame {

    
    public AvisoMercancia() {
        initComponents();
        cargarImagenes();
        this.setLocationRelativeTo(null);
        this.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        
        
        //this.setTitle("Aviso!");
        JlbHechoImg.setBackground(Color.white);
        JlbAviso.setText("Aviso: "+LoginCafeteria.alu+" no olvides hacer tus actividades del dia :D");
    }

    private void cargarImagenes(){
        
        ImageIcon aviso=new ImageIcon("src/Imagenes/poner.png");
        Icon avisoMerca=new ImageIcon(aviso.getImage().getScaledInstance(JlbAcomodarImg.getWidth(),JlbAcomodarImg.getHeight(), Image.SCALE_DEFAULT));
        JlbAcomodarImg.setIcon(avisoMerca);
        JlbAcomodarImg.repaint();
        
        ImageIcon recoger=new ImageIcon("src/Imagenes/Recoger.png");
        Icon recogerBasura=new ImageIcon(recoger.getImage().getScaledInstance(JlbBasuraImg.getWidth(),JlbBasuraImg.getHeight(), Image.SCALE_DEFAULT));
        JlbBasuraImg.setIcon(recogerBasura);
        JlbBasuraImg.repaint();
        
        ImageIcon limp=new ImageIcon("src/Imagenes/limpiar.png");
        Icon limpiar=new ImageIcon(limp.getImage().getScaledInstance(JlbLimpiarImg.getWidth(),JlbLimpiarImg.getHeight(), Image.SCALE_DEFAULT));
        JlbLimpiarImg.setIcon(limpiar);
        JlbLimpiarImg.repaint();
        
        ImageIcon palomita=new ImageIcon("src/Imagenes/hecho.png");
        Icon hecho=new ImageIcon(palomita.getImage().getScaledInstance(JlbHechoImg.getWidth(),JlbHechoImg.getHeight(), Image.SCALE_DEFAULT));
        JlbHechoImg.setIcon(hecho);
        JlbHechoImg.repaint();
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        JlbAcomodarImg = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        JlbLimpiarImg = new javax.swing.JLabel();
        JlbBasuraImg = new javax.swing.JLabel();
        JlbFlecha = new javax.swing.JLabel();
        JlbAviso = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        JlbFlecha1 = new javax.swing.JLabel();
        JlbHechoImg = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        JlbFlecha2 = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        jLabel8 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setUndecorated(true);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel1.setBackground(new java.awt.Color(26, 91, 117));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        JlbAcomodarImg.setOpaque(true);
        jPanel1.add(JlbAcomodarImg, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 130, 210, 180));

        jLabel1.setFont(new java.awt.Font("Lucida Bright", 0, 15)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("Acomodar mercancía ");
        jPanel1.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 320, 190, 40));

        JlbLimpiarImg.setOpaque(true);
        jPanel1.add(JlbLimpiarImg, new org.netbeans.lib.awtextra.AbsoluteConstraints(360, 130, 210, 180));

        JlbBasuraImg.setOpaque(true);
        jPanel1.add(JlbBasuraImg, new org.netbeans.lib.awtextra.AbsoluteConstraints(690, 130, 210, 180));

        JlbFlecha.setFont(new java.awt.Font("Tahoma", 1, 80)); // NOI18N
        JlbFlecha.setText("→");
        jPanel1.add(JlbFlecha, new org.netbeans.lib.awtextra.AbsoluteConstraints(260, 170, 90, 60));

        JlbAviso.setFont(new java.awt.Font("Lucida Bright", 0, 20)); // NOI18N
        JlbAviso.setForeground(new java.awt.Color(255, 255, 255));
        JlbAviso.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jPanel1.add(JlbAviso, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 60, 610, 40));

        jLabel5.setFont(new java.awt.Font("Lucida Bright", 0, 12)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(255, 255, 255));
        jLabel5.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel5.setText("Pictogramas: https://arasaac.org/pictograms/search");
        jPanel1.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 420, 320, 40));

        jLabel6.setFont(new java.awt.Font("Lucida Bright", 0, 15)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(255, 255, 255));
        jLabel6.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel6.setText("Sacar basura");
        jPanel1.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(700, 320, 190, 40));

        JlbFlecha1.setFont(new java.awt.Font("Tahoma", 1, 80)); // NOI18N
        JlbFlecha1.setText("→");
        jPanel1.add(JlbFlecha1, new org.netbeans.lib.awtextra.AbsoluteConstraints(590, 170, 90, 60));

        JlbHechoImg.setOpaque(true);
        JlbHechoImg.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                JlbHechoImgMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                JlbHechoImgMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                JlbHechoImgMouseExited(evt);
            }
        });
        jPanel1.add(JlbHechoImg, new org.netbeans.lib.awtextra.AbsoluteConstraints(510, 370, 70, 60));

        jLabel7.setFont(new java.awt.Font("Lucida Bright", 0, 15)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(255, 255, 255));
        jLabel7.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel7.setText("Presiona aqui");
        jPanel1.add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(310, 370, 120, 50));

        JlbFlecha2.setFont(new java.awt.Font("Tahoma", 1, 48)); // NOI18N
        JlbFlecha2.setText("→");
        jPanel1.add(JlbFlecha2, new org.netbeans.lib.awtextra.AbsoluteConstraints(440, 360, 50, 60));

        jPanel2.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 960, 20));

        jLabel8.setFont(new java.awt.Font("Lucida Bright", 0, 15)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(255, 255, 255));
        jLabel8.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel8.setText("Limpiar");
        jPanel1.add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(370, 320, 190, 40));

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 960, 460));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void JlbHechoImgMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_JlbHechoImgMouseEntered
        // AL ENTRAR AL BOTON DE HECHO
        JlbHechoImg.setBackground(Color.yellow);
    }//GEN-LAST:event_JlbHechoImgMouseEntered

    private void JlbHechoImgMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_JlbHechoImgMouseExited
        // AL SALIR DEL BOTON DE HECHO
        JlbHechoImg.setBackground(Color.white);
    }//GEN-LAST:event_JlbHechoImgMouseExited

    private void JlbHechoImgMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_JlbHechoImgMouseClicked
        // AL HACER CLICK EN BOTON HECHO
        
        Ventas1 vent=new Ventas1();
        vent.setVisible(true);
        this.dispose();
        PrincipalTEA cerrar=new PrincipalTEA();
        cerrar.dispose();
        
    }//GEN-LAST:event_JlbHechoImgMouseClicked

    
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
            java.util.logging.Logger.getLogger(AvisoMercancia.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(AvisoMercancia.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(AvisoMercancia.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(AvisoMercancia.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new AvisoMercancia().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel JlbAcomodarImg;
    private javax.swing.JLabel JlbAviso;
    private javax.swing.JLabel JlbBasuraImg;
    private javax.swing.JLabel JlbFlecha;
    private javax.swing.JLabel JlbFlecha1;
    private javax.swing.JLabel JlbFlecha2;
    private javax.swing.JLabel JlbHechoImg;
    private javax.swing.JLabel JlbLimpiarImg;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    // End of variables declaration//GEN-END:variables

}
