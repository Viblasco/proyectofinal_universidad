/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JInternalFrame.java to edit this template
 */
package vistas;

import controladores.MateriaData;
import java.util.ArrayList;
import javax.swing.table.DefaultTableModel;
import modelo.Materia;

/**
 *
 * @author Giulietta
 */
public class VistaListarMaterias extends javax.swing.JInternalFrame {
    private DefaultTableModel modeloTabla;
    private ArrayList<Materia> materias = new ArrayList();
    private MateriaData materiaD = new MateriaData();
    
    private void encabezado(){
        ArrayList<Object> columna = new ArrayList();
        columna.add("Código");
        columna.add("Nombre");
        columna.add("Año");
        columna.add("Estado");
        for(Object c: columna){
            modeloTabla.addColumn(c);
        }
        jTablaMaterias.setModel(modeloTabla);
    }
    /**
     * Creates new form VistaListarMaterias
     */
    public VistaListarMaterias() {
        initComponents();
        modeloTabla = new DefaultTableModel();
        encabezado();
        llenarTabla();
        
    }
    
    private void llenarTabla(){
        borrarFilas();
        materias = materiaD.listarMaterias();
        for(Materia a:materias){
            modeloTabla.addRow(new Object[]{a.getId_materia(),a.getNombre(),a.getAnio(),a.isEstado()});
        }
    }
    
    private void borrarFilas(){
        int fila = modeloTabla.getRowCount()-1;
        for(int i=fila; i>=0;i--){
            modeloTabla.removeRow(i);
        }
    }
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTablaMaterias = new javax.swing.JTable();

        jLabel1.setText("Materias");

        jTablaMaterias.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jScrollPane1.setViewportView(jTablaMaterias);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(100, 100, 100)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 356, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(257, 257, 257)
                        .addComponent(jLabel1)))
                .addContainerGap(168, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addGap(34, 34, 34)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 328, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(81, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTablaMaterias;
    // End of variables declaration//GEN-END:variables
}
