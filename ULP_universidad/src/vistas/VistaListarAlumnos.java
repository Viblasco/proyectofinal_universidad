/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JInternalFrame.java to edit this template
 */
package vistas;

import controladores.AlumnoData;
import java.sql.Date;
import java.util.ArrayList;
import javax.swing.table.DefaultTableModel;
import modelo.Alumno;
import modelo.Materia;


/**
 *
 * @author Giulietta
 */
public class VistaListarAlumnos extends javax.swing.JInternalFrame {
    private DefaultTableModel modeloTabla;
    private ArrayList<Alumno> alumnos = new ArrayList();
    private AlumnoData alumnoD = new AlumnoData();
    
    /**
     * Creates new form VistaListarAlumnos
     */
    private void encabezado(){
        ArrayList<Object> columna = new ArrayList();
        columna.add("Código");
        columna.add("Nombre");
        columna.add("Apellido");
        columna.add("DNI");
        columna.add("Fecha Nacimiento");
        columna.add("Estado");
        for(Object c: columna){
            modeloTabla.addColumn(c);
        }
        jTablaAlumnos.setModel(modeloTabla);
    }
    
    public VistaListarAlumnos() {
        initComponents();
        modeloTabla = new DefaultTableModel();
        encabezado();
        llenarTabla();
    }
    
    private void llenarTabla(){
        borrarFilas();
        alumnos = alumnoD.listarAlumnos();
        for(Alumno a: alumnos){
            modeloTabla.addRow(new Object[]{a.getId(),a.getNombre(),a.getApellido(),a.getDni(),Date.valueOf(a.getFecha_nacimiento()),a.isEstado()});
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
        jTablaAlumnos = new javax.swing.JTable();

        jLabel1.setText("Materias");

        jTablaAlumnos.setModel(new javax.swing.table.DefaultTableModel(
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
        jScrollPane1.setViewportView(jTablaAlumnos);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap(86, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addGap(229, 229, 229))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 356, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(68, 68, 68))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 328, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(22, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTablaAlumnos;
    // End of variables declaration//GEN-END:variables
}
