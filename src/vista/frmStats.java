/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package vista;

import controlador.Personaje;

/**
 *
 * @author Nicolas olivos
 */
public class frmStats extends javax.swing.JFrame {
    /**
     * Creates new form frmStats
     */
    Personaje p;
    public static int puntosStats=0;
    public frmStats(Personaje p,String mision) {
        this();
        this.p=p;
        this.setDefaultCloseOperation(javax.swing.WindowConstants.HIDE_ON_CLOSE);
        switch(this.p.getClass().toString()){
            case "class controlador.Arquero":
                lblPersonaje.setIcon(new javax.swing.ImageIcon(getClass().getResource("/texturas/arquero.jpg")));
                lblClase.setText("Clase: Arquero");
                break;
            case "class controlador.Guerrero":
                lblPersonaje.setIcon(new javax.swing.ImageIcon(getClass().getResource("/texturas/guerrero.jpg")));
                lblClase.setText("Clase: Guerrero");
                break;
            case "class controlador.Mago":
                lblPersonaje.setIcon(new javax.swing.ImageIcon(getClass().getResource("/texturas/mago.jpg")));
                lblClase.setText("Clase: Mago");
                break;
        }
        lblNombre.setText("Nombre: "+this.p.getNombre());
        this.setTitle("World of LP");
        this.lblMision.setText("Mision: "+mision);
        this.setEstado();
        
    }
    public frmStats() {
        initComponents();
    }
    
    public void aumentar(){
        this.p.aumentarExp(10);
    }
    
    public synchronized void setEstado(){
        lblNivel.setText("Nivel: "+this.p.getNivel());
        lblExp.setText("Experiencia: "+this.p.getEXP()+"/"+p.expSiguienteLvl(this.p.getNivel()));
        pgbExp.setMaximum(p.expSiguienteLvl(this.p.getNivel()));
        pgbExp.setValue(this.p.getEXP());
        lblConstitucion.setText("Constitucion: "+this.p.getStats().getConstitucion());
        lblDestreza.setText("Destreza: "+this.p.getStats().getDestreza());
        lblFuerza.setText("Fuerza: "+this.p.getStats().getFuerza());
        lblInteligencia.setText("Inteligencia: "+this.p.getStats().getInteligencia());
        lblRadioVision.setText("Radio Vision: "+this.p.getStats().getRadio_vision());
        lblRapidez.setText("Rapidez: "+this.p.getStats().getRapidez());
        lblResistencia.setText("Resistencia: "+this.p.getStats().getResistencia());
        lblResistenciaMagica.setText("Resistencia Magica: "+this.p.getStats().getResistencia_magica());
        lblStamina.setText("Stamina: "+this.p.getStats().getStamina());
        lblPuntos.setText("Puntos Stats disponible: "+puntosStats);
        lblVida.setText("Vida: "+this.p.getVida());
        pack();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        pnlArquero = new javax.swing.JPanel();
        lblPersonaje = new javax.swing.JLabel();
        lblNombre = new javax.swing.JLabel();
        lblClase = new javax.swing.JLabel();
        lblNivel = new javax.swing.JLabel();
        pgbExp = new javax.swing.JProgressBar();
        lblExp = new javax.swing.JLabel();
        lblRadioVision = new javax.swing.JLabel();
        lblResistenciaMagica = new javax.swing.JLabel();
        lblRapidez = new javax.swing.JLabel();
        lblInteligencia = new javax.swing.JLabel();
        lblFuerza = new javax.swing.JLabel();
        lblStamina = new javax.swing.JLabel();
        lblDestreza = new javax.swing.JLabel();
        lblConstitucion = new javax.swing.JLabel();
        lblResistencia = new javax.swing.JLabel();
        lblPuntos = new javax.swing.JLabel();
        lblVida = new javax.swing.JLabel();
        lblMision = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setUndecorated(true);

        pnlArquero.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        lblPersonaje.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblPersonaje.setMaximumSize(new java.awt.Dimension(144, 24));
        lblPersonaje.setMinimumSize(new java.awt.Dimension(144, 24));
        lblPersonaje.setPreferredSize(new java.awt.Dimension(144, 24));

        javax.swing.GroupLayout pnlArqueroLayout = new javax.swing.GroupLayout(pnlArquero);
        pnlArquero.setLayout(pnlArqueroLayout);
        pnlArqueroLayout.setHorizontalGroup(
            pnlArqueroLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(lblPersonaje, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        pnlArqueroLayout.setVerticalGroup(
            pnlArqueroLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(lblPersonaje, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 161, Short.MAX_VALUE)
        );

        lblNombre.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        lblNombre.setText("jLabel1");

        lblClase.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        lblClase.setText("jLabel1");

        lblNivel.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        lblNivel.setText("jLabel1");

        lblExp.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        lblExp.setText("jLabel1");

        lblRadioVision.setText("jLabel1");
        lblRadioVision.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lblRadioVisionMouseClicked(evt);
            }
        });

        lblResistenciaMagica.setText("jLabel2");
        lblResistenciaMagica.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lblResistenciaMagicaMouseClicked(evt);
            }
        });

        lblRapidez.setText("jLabel3");
        lblRapidez.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lblRapidezMouseClicked(evt);
            }
        });

        lblInteligencia.setText("jLabel4");
        lblInteligencia.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lblInteligenciaMouseClicked(evt);
            }
        });

        lblFuerza.setText("jLabel5");
        lblFuerza.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lblFuerzaMouseClicked(evt);
            }
        });

        lblStamina.setText("jLabel6");
        lblStamina.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lblStaminaMouseClicked(evt);
            }
        });

        lblDestreza.setText("jLabel7");
        lblDestreza.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lblDestrezaMouseClicked(evt);
            }
        });

        lblConstitucion.setText("jLabel8");
        lblConstitucion.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lblConstitucionMouseClicked(evt);
            }
        });

        lblResistencia.setText("jLabel9");
        lblResistencia.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lblResistenciaMouseClicked(evt);
            }
        });

        lblPuntos.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        lblPuntos.setText("jLabel1");

        lblVida.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        lblVida.setText("jLabel1");

        lblMision.setText("jLabel1");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(pnlArquero, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblNivel)
                    .addComponent(lblExp)
                    .addComponent(lblResistencia)
                    .addComponent(lblRadioVision)
                    .addComponent(lblRapidez)
                    .addComponent(lblFuerza)
                    .addComponent(lblDestreza)
                    .addComponent(lblConstitucion)
                    .addComponent(lblStamina)
                    .addComponent(lblInteligencia)
                    .addComponent(lblPuntos)
                    .addComponent(lblResistenciaMagica)
                    .addComponent(lblNombre)
                    .addComponent(lblClase)
                    .addComponent(pgbExp, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblVida)
                    .addComponent(lblMision))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(pnlArquero, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(lblVida)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(lblNombre)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(lblClase)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(lblNivel)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(pgbExp, javax.swing.GroupLayout.PREFERRED_SIZE, 15, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(lblExp)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(lblPuntos)
                .addGap(11, 11, 11)
                .addComponent(lblRadioVision)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(lblRapidez)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(lblFuerza)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(lblDestreza)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(lblResistencia)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(lblResistenciaMagica)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(lblInteligencia)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(lblStamina)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(lblConstitucion)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(lblMision)
                .addContainerGap(20, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void lblRadioVisionMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblRadioVisionMouseClicked
        if(puntosStats>0){
            p.getStats().setRadio_vision(p.getStats().getRadio_vision()+1);
            puntosStats--;
            setEstado();
        }
    }//GEN-LAST:event_lblRadioVisionMouseClicked

    private void lblRapidezMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblRapidezMouseClicked
        if(puntosStats>0){
            p.getStats().setRapidez(p.getStats().getRapidez()+1);
            puntosStats--;
            setEstado();
        }
    }//GEN-LAST:event_lblRapidezMouseClicked

    private void lblFuerzaMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblFuerzaMouseClicked
        if(puntosStats>0){
            p.getStats().setFuerza(p.getStats().getFuerza()+1);
            puntosStats--;
            setEstado();
        }
    }//GEN-LAST:event_lblFuerzaMouseClicked

    private void lblDestrezaMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblDestrezaMouseClicked
        if(puntosStats>0){
            p.getStats().setDestreza(p.getStats().getDestreza()+1);
            puntosStats--;
            setEstado();
        }
    }//GEN-LAST:event_lblDestrezaMouseClicked

    private void lblResistenciaMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblResistenciaMouseClicked
        if(puntosStats>0){
            p.getStats().setResistencia(p.getStats().getResistencia()+1);
            puntosStats--;
            setEstado();
        }
    }//GEN-LAST:event_lblResistenciaMouseClicked

    private void lblResistenciaMagicaMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblResistenciaMagicaMouseClicked
        if(puntosStats>0){
            p.getStats().setResistencia_magica(p.getStats().getResistencia_magica()+1);
            puntosStats--;
            setEstado();
        }
    }//GEN-LAST:event_lblResistenciaMagicaMouseClicked

    private void lblInteligenciaMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblInteligenciaMouseClicked
        if(puntosStats>0){
            p.getStats().setInteligencia(p.getStats().getInteligencia()+1);
            puntosStats--;
            setEstado();
        }
    }//GEN-LAST:event_lblInteligenciaMouseClicked

    private void lblStaminaMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblStaminaMouseClicked
        if(puntosStats>0){
            p.getStats().setStamina(p.getStats().getStamina()+1);
            puntosStats--;
            setEstado();
        }
    }//GEN-LAST:event_lblStaminaMouseClicked

    private void lblConstitucionMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblConstitucionMouseClicked
        if(puntosStats>0){
            p.getStats().setConstitucion(p.getStats().getConstitucion()+1);
            puntosStats--;
            setEstado();
        }
    }//GEN-LAST:event_lblConstitucionMouseClicked

   
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel lblClase;
    private javax.swing.JLabel lblConstitucion;
    private javax.swing.JLabel lblDestreza;
    private javax.swing.JLabel lblExp;
    private javax.swing.JLabel lblFuerza;
    private javax.swing.JLabel lblInteligencia;
    private javax.swing.JLabel lblMision;
    private javax.swing.JLabel lblNivel;
    private javax.swing.JLabel lblNombre;
    private javax.swing.JLabel lblPersonaje;
    private javax.swing.JLabel lblPuntos;
    private javax.swing.JLabel lblRadioVision;
    private javax.swing.JLabel lblRapidez;
    private javax.swing.JLabel lblResistencia;
    private javax.swing.JLabel lblResistenciaMagica;
    private javax.swing.JLabel lblStamina;
    private javax.swing.JLabel lblVida;
    private javax.swing.JProgressBar pgbExp;
    private javax.swing.JPanel pnlArquero;
    // End of variables declaration//GEN-END:variables
}
