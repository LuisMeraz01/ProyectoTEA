
package Interfaces;

import java.awt.Color;
import java.awt.Image;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import javax.swing.Icon;
import javax.swing.ImageIcon;


public class PrincipalTEA extends javax.swing.JFrame implements Runnable{

    // Codigo del reloj
    String hora, min, seg, ampm;
    Calendar calendario;
    Thread h1;
    
    public PrincipalTEA() {
        initComponents();
        cargarImagenes();
        h1 = new Thread(this);
        h1.start();
        this.setExtendedState(MAXIMIZED_BOTH);
        this.setTitle("Cafeteria Manitas Azules");
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        JlbClickImg.setBackground(Color.white);
        JlbClickImg2.setBackground(Color.white);
        JlbVenderImg.setBackground(Color.white);
        JlbFinImg.setBackground(Color.white);
    }
    
    public void cargarImagenes(){
        
        DateFormat formato=new SimpleDateFormat("EEE, d MMM yyyy");
        String fecha = formato.format(new Date());
        JlbFecha.setText(fecha);
        
        ImageIcon fin=new ImageIcon("src/Imagenes/terminar.png");
        Icon terminar=new ImageIcon(fin.getImage().getScaledInstance(JlbFinImg.getWidth(),JlbFinImg.getHeight(), Image.SCALE_DEFAULT));
        JlbFinImg.setIcon(terminar);
        JlbFinImg.repaint();
                
        
        ImageIcon logo=new ImageIcon("src/Imagenes/LogoCentro.jpg");
        Icon logoCentr=new ImageIcon(logo.getImage().getScaledInstance(JlbLogoImg.getWidth(),JlbLogoImg.getHeight(), Image.SCALE_DEFAULT));
        JlbLogoImg.setIcon(logoCentr);
        JlbLogoImg.repaint();
        
        ImageIcon taza=new ImageIcon("src/Imagenes/taza.png");
        Icon tazaCafe=new ImageIcon(taza.getImage().getScaledInstance(JlbTazaImg.getWidth(),JlbTazaImg.getHeight(), Image.SCALE_DEFAULT));
        JlbTazaImg.setIcon(tazaCafe);
        JlbTazaImg.repaint();
        
        ImageIcon vender=new ImageIcon("src/Imagenes/compartir.png");
        Icon venta=new ImageIcon(vender.getImage().getScaledInstance(JlbVenderImg.getWidth(),JlbVenderImg.getHeight(), Image.SCALE_DEFAULT));
        JlbVenderImg.setIcon(venta);
        JlbVenderImg.repaint();
        
        ImageIcon clic=new ImageIcon("src/Imagenes/click.png");
        Icon click=new ImageIcon(clic.getImage().getScaledInstance(JlbClickImg.getWidth(),JlbClickImg.getHeight(), Image.SCALE_DEFAULT));
        JlbClickImg.setIcon(click);
        JlbClickImg.repaint();
    
        Icon click2=new ImageIcon(clic.getImage().getScaledInstance(JlbClickImg2.getWidth(),JlbClickImg2.getHeight(), Image.SCALE_DEFAULT));
        JlbClickImg2.setIcon(click2);
        JlbClickImg2.repaint();
    }

    // ================================================= RELOJ ============================================================
    
    
    public void run() {
        Thread ct = Thread.currentThread();
        while (ct == h1) {
            calcula();
            int hor=Integer.valueOf(hora);
            hor=hor-1;
            hora=String.valueOf(hor);
            JlbHora.setText(hora + ":" + min + ":" + seg + " " + ampm);
            try {
                Thread.sleep(1000);
            } catch (InterruptedException error) {

            }
        }
    }

    private void calcula() {
        Calendar calendario = new GregorianCalendar();
        Date fechaHoraactual = new Date();
        calendario.setTime(fechaHoraactual);
        ampm = calendario.get(Calendar.AM_PM) == Calendar.AM ? "AM" : "PM";
        if (ampm.equals("PM")) {
            int h = calendario.get(Calendar.HOUR_OF_DAY) - 12;
            hora = h > 9 ? "" + h : "0" + h;
            if (h == 00) {
                hora = "12";
            } else {
                hora = h > 9 ? "" + h : "0" + h;
            }
        } else {
            hora = calendario.get(Calendar.HOUR_OF_DAY) > 9 ? "" + calendario.get(Calendar.HOUR_OF_DAY) : "0" + calendario.get(Calendar.HOUR_OF_DAY);
        }
        
        min = calendario.get(Calendar.MINUTE) > 9 ? "" + calendario.get(Calendar.MINUTE) : "0" + calendario.get(Calendar.MINUTE);
        seg = calendario.get(Calendar.SECOND) > 9 ? "" + calendario.get(Calendar.SECOND) : "0" + calendario.get(Calendar.SECOND);
    }

    // ================================================= RELOJ ============================================================
    
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        JlbTazaImg = new javax.swing.JLabel();
        JlbTitulo = new javax.swing.JLabel();
        JlbLogoImg = new javax.swing.JLabel();
        JlbInstruccion1 = new javax.swing.JLabel();
        JlbVenderImg = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        JlbClickImg = new javax.swing.JLabel();
        JlbInstruccion2 = new javax.swing.JLabel();
        jPanel3 = new javax.swing.JPanel();
        JlbFecha = new javax.swing.JLabel();
        jSeparator1 = new javax.swing.JSeparator();
        JlbHora = new javax.swing.JLabel();
        JlbHora1 = new javax.swing.JLabel();
        JlbHora2 = new javax.swing.JLabel();
        JlbHora3 = new javax.swing.JLabel();
        JlbFinImg = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        JlbInstruccion3 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        JlbClickImg2 = new javax.swing.JLabel();
        JlbInstruccion4 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel1.setBackground(new java.awt.Color(128, 213, 247));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel2.setBackground(new java.awt.Color(26, 91, 117));
        jPanel2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        JlbTazaImg.setOpaque(true);
        jPanel2.add(JlbTazaImg, new org.netbeans.lib.awtextra.AbsoluteConstraints(520, 20, 90, 70));

        JlbTitulo.setFont(new java.awt.Font("Lucida Bright", 0, 30)); // NOI18N
        JlbTitulo.setForeground(new java.awt.Color(255, 255, 255));
        JlbTitulo.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        JlbTitulo.setText("CAFETERIA MANITAS AZULES");
        jPanel2.add(JlbTitulo, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 30, 470, 40));

        jPanel1.add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1110, 110));

        JlbLogoImg.setOpaque(true);
        jPanel1.add(JlbLogoImg, new org.netbeans.lib.awtextra.AbsoluteConstraints(1110, 0, 260, 230));

        JlbInstruccion1.setFont(new java.awt.Font("Lucida Bright", 0, 30)); // NOI18N
        JlbInstruccion1.setText("Comenzar a vender");
        jPanel1.add(JlbInstruccion1, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 340, 290, 40));

        JlbVenderImg.setOpaque(true);
        jPanel1.add(JlbVenderImg, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 160, 220, 170));

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 100)); // NOI18N
        jLabel1.setText("←");
        jPanel1.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(540, 500, 100, 60));

        JlbClickImg.setOpaque(true);
        JlbClickImg.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                JlbClickImgMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                JlbClickImgMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                JlbClickImgMouseExited(evt);
            }
        });
        jPanel1.add(JlbClickImg, new org.netbeans.lib.awtextra.AbsoluteConstraints(740, 160, 180, 160));

        JlbInstruccion2.setFont(new java.awt.Font("Lucida Bright", 0, 30)); // NOI18N
        JlbInstruccion2.setText("Da un click aqui");
        jPanel1.add(JlbInstruccion2, new org.netbeans.lib.awtextra.AbsoluteConstraints(220, 650, 240, 40));

        jPanel3.setBackground(new java.awt.Color(80, 114, 128));
        jPanel3.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        JlbFecha.setFont(new java.awt.Font("Lucida Bright", 0, 14)); // NOI18N
        JlbFecha.setForeground(new java.awt.Color(255, 255, 255));
        JlbFecha.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jPanel3.add(JlbFecha, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 350, 220, 40));
        jPanel3.add(jSeparator1, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 320, 220, 20));

        JlbHora.setFont(new java.awt.Font("Lucida Bright", 0, 14)); // NOI18N
        JlbHora.setForeground(new java.awt.Color(255, 255, 255));
        JlbHora.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jPanel3.add(JlbHora, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 380, 220, 40));

        JlbHora1.setFont(new java.awt.Font("Lucida Bright", 0, 18)); // NOI18N
        JlbHora1.setForeground(new java.awt.Color(255, 255, 255));
        JlbHora1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        JlbHora1.setText("“No hay nadie como tú, ");
        jPanel3.add(JlbHora1, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 40, 220, 50));

        JlbHora2.setFont(new java.awt.Font("Lucida Bright", 0, 18)); // NOI18N
        JlbHora2.setForeground(new java.awt.Color(255, 255, 255));
        JlbHora2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        JlbHora2.setText("y eso es tu poder”");
        jPanel3.add(JlbHora2, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 80, 220, 50));

        JlbHora3.setFont(new java.awt.Font("Lucida Bright", 0, 14)); // NOI18N
        JlbHora3.setForeground(new java.awt.Color(255, 255, 255));
        JlbHora3.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        JlbHora3.setText("Temple Grandin (2013)");
        jPanel3.add(JlbHora3, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 140, 220, 50));

        jPanel1.add(jPanel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(1110, 230, 260, 480));

        JlbFinImg.setOpaque(true);
        jPanel1.add(JlbFinImg, new org.netbeans.lib.awtextra.AbsoluteConstraints(760, 480, 140, 120));

        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 100)); // NOI18N
        jLabel2.setText("→");
        jPanel1.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(530, 210, 100, 60));

        JlbInstruccion3.setFont(new java.awt.Font("Lucida Bright", 0, 30)); // NOI18N
        JlbInstruccion3.setText("Es hora de salir?");
        jPanel1.add(JlbInstruccion3, new org.netbeans.lib.awtextra.AbsoluteConstraints(720, 610, 240, 40));

        jLabel3.setBackground(new java.awt.Color(255, 255, 255));
        jLabel3.setOpaque(true);
        jPanel1.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 410, 1060, 10));

        JlbClickImg2.setBackground(new java.awt.Color(255, 255, 255));
        JlbClickImg2.setOpaque(true);
        JlbClickImg2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                JlbClickImg2MouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                JlbClickImg2MouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                JlbClickImg2MouseExited(evt);
            }
        });
        jPanel1.add(JlbClickImg2, new org.netbeans.lib.awtextra.AbsoluteConstraints(240, 480, 180, 160));

        JlbInstruccion4.setFont(new java.awt.Font("Lucida Bright", 0, 30)); // NOI18N
        JlbInstruccion4.setText("Da un click aqui");
        jPanel1.add(JlbInstruccion4, new org.netbeans.lib.awtextra.AbsoluteConstraints(720, 330, 240, 40));

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1370, 720));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void JlbClickImgMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_JlbClickImgMouseClicked
        // CLICK PARA EMPEZAR
        AvisoMercancia aviso=new AvisoMercancia();
        aviso.setVisible(true);
        //this.dispose();
        
             
    }//GEN-LAST:event_JlbClickImgMouseClicked

    private void JlbClickImgMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_JlbClickImgMouseEntered
        // AL ENTRAR AL BOTON DE CLICK
        JlbClickImg.setBackground(Color.yellow);
        
    }//GEN-LAST:event_JlbClickImgMouseEntered

    private void JlbClickImgMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_JlbClickImgMouseExited
        // AL SALIR DEL BOTON DE CLICK
        JlbClickImg.setBackground(Color.white);
    }//GEN-LAST:event_JlbClickImgMouseExited

    private void JlbClickImg2MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_JlbClickImg2MouseEntered
        // TODO add your handling code here:
        JlbClickImg2.setBackground(Color.yellow);
    }//GEN-LAST:event_JlbClickImg2MouseEntered

    private void JlbClickImg2MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_JlbClickImg2MouseExited
        // TODO add your handling code here:
        JlbClickImg2.setBackground(Color.white);
    }//GEN-LAST:event_JlbClickImg2MouseExited

    private void JlbClickImg2MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_JlbClickImg2MouseClicked
        // CLICK EN BOTON CLICK PARA SALIR DE LA SESION
        LoginCafeteria salir=new LoginCafeteria();
        salir.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_JlbClickImg2MouseClicked

    
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
            java.util.logging.Logger.getLogger(PrincipalTEA.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(PrincipalTEA.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(PrincipalTEA.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(PrincipalTEA.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new PrincipalTEA().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel JlbClickImg;
    private javax.swing.JLabel JlbClickImg2;
    private javax.swing.JLabel JlbFecha;
    private javax.swing.JLabel JlbFinImg;
    private javax.swing.JLabel JlbHora;
    private javax.swing.JLabel JlbHora1;
    private javax.swing.JLabel JlbHora2;
    private javax.swing.JLabel JlbHora3;
    private javax.swing.JLabel JlbInstruccion1;
    private javax.swing.JLabel JlbInstruccion2;
    private javax.swing.JLabel JlbInstruccion3;
    private javax.swing.JLabel JlbInstruccion4;
    private javax.swing.JLabel JlbLogoImg;
    private javax.swing.JLabel JlbTazaImg;
    private javax.swing.JLabel JlbTitulo;
    private javax.swing.JLabel JlbVenderImg;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JSeparator jSeparator1;
    // End of variables declaration//GEN-END:variables
}
