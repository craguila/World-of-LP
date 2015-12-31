/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package vista;

import controlador.Habilidad;
import controlador.Monstruo;
import controlador.Personaje;
import javax.swing.table.DefaultTableModel;
import static vista.Juego.monstruos;
import static vista.Juego.ventanaHabilidades;
import static vista.Juego.ventanaInventario;
import static vista.Juego.ventanaMonstruos;
import static vista.Juego.ventanaStats;

/**
 *
 * @author Nicolas olivos
 */
public class frmHabilidades extends javax.swing.JFrame {
    /**
     * Creates new form NewJFrame
     */
    Personaje p;
    public frmHabilidades(Personaje p) {
        initComponents();
        this.p=p;
        setEstado();
    }
    
    public void setEstado() {
        DefaultTableModel mdl =(DefaultTableModel)this.tblHabilidades.getModel();
        mdl.setRowCount(0);
        for(Habilidad h:p.getHabilidades()){
            Object data[]={h.nombre,h.dano,h.estado.getNombre(),h.costo};
            mdl.addRow(data);
        }
        this.tblHabilidades.setModel(mdl);
    }

    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        tblHabilidades = new javax.swing.JTable();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setUndecorated(true);

        tblHabilidades.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Nombre", "Daño", "Estado", "Costo"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.Integer.class, java.lang.String.class, java.lang.Integer.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tblHabilidades.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblHabilidadesMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tblHabilidades);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 267, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 88, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents
public void despuesdeatacar(){
            ventanaStats.setEstado();
            ventanaHabilidades.setEstado();
            ventanaMonstruos.setEstado();
            ventanaInventario.setEstado();
            for(Monstruo m: monstruos){
                m.actualizar(); 
            }
        }
    private void tblHabilidadesMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblHabilidadesMouseClicked
        String habilidad=tblHabilidades.getValueAt(tblHabilidades.getSelectedRow(), 0).toString();
        Habilidad habilidadEfectuada = Habilidad.NINGUNA;
        for (Habilidad h:p.getHabilidades()){
            if (h.nombre.equals(habilidad)){
                habilidadEfectuada = h;
            }
        }
        if (Juego.jugador.getMana()>habilidadEfectuada.costo){
            for(Monstruo m:Juego.monstruos){
                if(p.getMonsruosVisibles().contains(m.getNombre())){
                    System.out.println("jugador uso "+habilidad+" sobre "+m.getNombre());

                    m.danar(habilidadEfectuada.dano);
                    m.addStatus(habilidadEfectuada.estado);
                    p.gastarMana(habilidadEfectuada.costo);
                }
            }
        }
        despuesdeatacar();
    }//GEN-LAST:event_tblHabilidadesMouseClicked

    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tblHabilidades;
    // End of variables declaration//GEN-END:variables

    
}
