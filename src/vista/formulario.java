/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package vista;

import javax.swing.ButtonGroup;
import javax.swing.JOptionPane;

/**
 *
 * @author Nicolas olivos
 */
public class formulario extends javax.swing.JFrame {
    /**
     * Creates new form formulario
     */
    public formulario() {
        setLocationRelativeTo(null);
        setResizable(false);
        initComponents();
        group.add(Clase1);
        group.add(Clase2);
        group.add(Clase3);
    } 
    ButtonGroup group = new ButtonGroup();
    int clase=0;
    

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        pnlArquero = new javax.swing.JPanel();
        lblArquero = new javax.swing.JLabel();
        pnlGuerrero = new javax.swing.JPanel();
        lblGuerrero = new javax.swing.JLabel();
        pnlMago = new javax.swing.JPanel();
        lblMago = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        txtNombre = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        Clase1 = new javax.swing.JRadioButton();
        Clase3 = new javax.swing.JRadioButton();
        Clase2 = new javax.swing.JRadioButton();
        btnIniciar = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        pnlArquero.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        lblArquero.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblArquero.setIcon(new javax.swing.ImageIcon(getClass().getResource("/texturas/arquero.jpg"))); // NOI18N
        lblArquero.setToolTipText("<html>\nRadio Vision:\t \t8.<br>\nRapidez:\t\t7.<br>\nFuerza:\t\t6.<br>\nDestreza: \t\t10.<br>\nResistencia:\t\t12.<br>\nResistencia Magica: \t8.<br>\nInteligencia: \t\t12.<br>\nStamina: \t\t15.<br>\nConstitucion: \t10.<br>\n</html>");
        lblArquero.setMaximumSize(new java.awt.Dimension(144, 24));
        lblArquero.setMinimumSize(new java.awt.Dimension(144, 24));
        lblArquero.setPreferredSize(new java.awt.Dimension(144, 24));
        lblArquero.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lblArqueroMouseClicked(evt);
            }
        });

        javax.swing.GroupLayout pnlArqueroLayout = new javax.swing.GroupLayout(pnlArquero);
        pnlArquero.setLayout(pnlArqueroLayout);
        pnlArqueroLayout.setHorizontalGroup(
            pnlArqueroLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(lblArquero, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        pnlArqueroLayout.setVerticalGroup(
            pnlArqueroLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(lblArquero, javax.swing.GroupLayout.DEFAULT_SIZE, 161, Short.MAX_VALUE)
        );

        pnlGuerrero.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        lblGuerrero.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblGuerrero.setIcon(new javax.swing.ImageIcon(getClass().getResource("/texturas/guerrero.jpg"))); // NOI18N
        lblGuerrero.setToolTipText("<html>\nRadio Vision:\t \t5.<br>\nRapidez:\t\t10.<br>\nFuerza:\t\t10.<br>\nDestreza: \t\t8.<br>\nResistencia:\t\t15.<br>\nResistencia Magica: \t10.<br>\nInteligencia: \t\t10.<br>\nStamina: \t\t13.<br>\nConstitucion: \t5.<br>\n</html>");
        lblGuerrero.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        lblGuerrero.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lblGuerreroMouseClicked(evt);
            }
        });

        javax.swing.GroupLayout pnlGuerreroLayout = new javax.swing.GroupLayout(pnlGuerrero);
        pnlGuerrero.setLayout(pnlGuerreroLayout);
        pnlGuerreroLayout.setHorizontalGroup(
            pnlGuerreroLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(lblGuerrero, javax.swing.GroupLayout.DEFAULT_SIZE, 144, Short.MAX_VALUE)
        );
        pnlGuerreroLayout.setVerticalGroup(
            pnlGuerreroLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(lblGuerrero, javax.swing.GroupLayout.DEFAULT_SIZE, 161, Short.MAX_VALUE)
        );

        pnlMago.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        lblMago.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblMago.setIcon(new javax.swing.ImageIcon(getClass().getResource("/texturas/mago.jpg"))); // NOI18N
        lblMago.setToolTipText("<html>\nRadio Vision:\t \t10.<br>\nRapidez:\t\t5.<br>\nFuerza:\t\t4.<br>\nDestreza: \t\t3.<br>\nResistencia:\t\t10.<br>\nResistencia Magica: \t15.<br>\nInteligencia: \t\t15.<br>\nStamina: \t\t10.<br>\nConstitucion: \t15.<br>\n</html>");
        lblMago.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lblMagoMouseClicked(evt);
            }
        });

        javax.swing.GroupLayout pnlMagoLayout = new javax.swing.GroupLayout(pnlMago);
        pnlMago.setLayout(pnlMagoLayout);
        pnlMagoLayout.setHorizontalGroup(
            pnlMagoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(lblMago, javax.swing.GroupLayout.DEFAULT_SIZE, 144, Short.MAX_VALUE)
        );
        pnlMagoLayout.setVerticalGroup(
            pnlMagoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(lblMago, javax.swing.GroupLayout.DEFAULT_SIZE, 161, Short.MAX_VALUE)
        );

        jLabel1.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel1.setText("Bienvenido a World of LP");

        jLabel2.setText("Ingrese su nombre: ");

        jLabel3.setText("Indique su clase:");

        Clase1.setText("Guerrero");
        Clase1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Clase1ActionPerformed(evt);
            }
        });

        Clase3.setText("Mago");
        Clase3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Clase3ActionPerformed(evt);
            }
        });

        Clase2.setText("Arquero");
        Clase2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Clase2ActionPerformed(evt);
            }
        });

        btnIniciar.setText("INICIAR");
        btnIniciar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnIniciarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                            .addComponent(pnlGuerrero, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(Clase1))
                        .addGap(46, 46, 46)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                            .addComponent(pnlArquero, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(Clase2)
                            .addComponent(jLabel3)
                            .addComponent(btnIniciar))
                        .addGap(45, 45, 45)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                            .addComponent(pnlMago, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(Clase3)))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(178, 178, 178)
                        .addComponent(jLabel1))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(108, 108, 108)
                        .addComponent(jLabel2)
                        .addGap(18, 18, 18)
                        .addComponent(txtNombre, javax.swing.GroupLayout.PREFERRED_SIZE, 111, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        layout.linkSize(javax.swing.SwingConstants.HORIZONTAL, new java.awt.Component[] {pnlArquero, pnlGuerrero, pnlMago});

        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(30, 30, 30)
                .addComponent(jLabel1)
                .addGap(44, 44, 44)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(txtNombre, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 26, Short.MAX_VALUE)
                .addComponent(jLabel3)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(Clase1)
                    .addComponent(Clase3)
                    .addComponent(Clase2))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                    .addComponent(pnlArquero, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(pnlGuerrero, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(pnlMago, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(btnIniciar)
                .addGap(18, 18, 18))
        );

        layout.linkSize(javax.swing.SwingConstants.VERTICAL, new java.awt.Component[] {pnlArquero, pnlGuerrero, pnlMago});

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnIniciarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnIniciarActionPerformed
        if(!"".equals(this.txtNombre.getText())){
            if(clase!=0){
                Juego juego = new Juego(this.txtNombre.getText(),clase);
                juego.iniciar();
                this.setVisible(false);
            }
            else{
                JOptionPane.showMessageDialog(this, "Debe Seleccionar una Clase", "World of LP", 0);
            }
        }
        else{
            JOptionPane.showMessageDialog(this, "Debe Ingresar Su Nombre", "World of LP", 0);
        }
    }//GEN-LAST:event_btnIniciarActionPerformed

    private void Clase1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Clase1ActionPerformed
        clase=1;
    }//GEN-LAST:event_Clase1ActionPerformed

    private void Clase2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Clase2ActionPerformed
        clase=2;
    }//GEN-LAST:event_Clase2ActionPerformed

    private void Clase3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Clase3ActionPerformed
        clase=3;
    }//GEN-LAST:event_Clase3ActionPerformed

    private void lblMagoMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblMagoMouseClicked
        Clase3.doClick();
    }//GEN-LAST:event_lblMagoMouseClicked

    private void lblArqueroMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblArqueroMouseClicked
        Clase2.doClick();
    }//GEN-LAST:event_lblArqueroMouseClicked

    private void lblGuerreroMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblGuerreroMouseClicked
        Clase1.doClick();
    }//GEN-LAST:event_lblGuerreroMouseClicked

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /*
         * Set the Nimbus look and feel
         */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /*
         * If Nimbus (introduced in Java SE 6) is not available, stay with the
         * default look and feel. For details see
         * http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        }
        catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(formulario.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(formulario.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(formulario.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(formulario.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /*
         * Create and display the form
         */
        
        
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new formulario().setVisible(true);
                
            }
        });
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JRadioButton Clase1;
    private javax.swing.JRadioButton Clase2;
    private javax.swing.JRadioButton Clase3;
    private javax.swing.JButton btnIniciar;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel lblArquero;
    private javax.swing.JLabel lblGuerrero;
    private javax.swing.JLabel lblMago;
    private javax.swing.JPanel pnlArquero;
    private javax.swing.JPanel pnlGuerrero;
    private javax.swing.JPanel pnlMago;
    private javax.swing.JTextField txtNombre;
    // End of variables declaration//GEN-END:variables
}
