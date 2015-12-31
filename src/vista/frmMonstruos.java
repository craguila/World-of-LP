/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package vista;

import controlador.Monstruo;
import controlador.Personaje;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Nicolas olivos
 */
public class frmMonstruos extends javax.swing.JFrame {
    /**
     * Creates new form frmMonstruos
     */
    Personaje p;
    public frmMonstruos(Personaje p) {
        initComponents();
        this.p=p;
        setEstado();
    }
    
    public void setEstado() {
        DefaultTableModel mdl =(DefaultTableModel)this.tblMonstruos.getModel();
        mdl.setRowCount(0);
        int i=1;
        p.buscarmonstruos();
        for(String nombre:p.getMonsruosVisibles()){
            Object data[]={i,nombre};
            i++;
            mdl.addRow(data);
        }
        this.tblMonstruos.setModel(mdl);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jMenuItem1 = new javax.swing.JMenuItem();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblMonstruos = new javax.swing.JTable();

        jMenuItem1.setText("jMenuItem1");

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setUndecorated(true);

        tblMonstruos.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "ID", "Nombre"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Integer.class, java.lang.String.class
            };
            boolean[] canEdit = new boolean [] {
                false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tblMonstruos.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblMonstruosMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tblMonstruos);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 211, javax.swing.GroupLayout.PREFERRED_SIZE)
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

    private void tblMonstruosMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblMonstruosMouseClicked
        String objetivo=tblMonstruos.getValueAt(tblMonstruos.getSelectedRow(), 1).toString();
        for(Monstruo m:Juego.monstruos){
            if(m.getNombre().equals(objetivo)){
                System.out.println("Jugador ataco a "+objetivo);
                m.danar(Juego.jugador.getStats().getFuerza());
                break;
            }
        }
    }//GEN-LAST:event_tblMonstruosMouseClicked

    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JMenuItem jMenuItem1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tblMonstruos;
    // End of variables declaration//GEN-END:variables

    
}
