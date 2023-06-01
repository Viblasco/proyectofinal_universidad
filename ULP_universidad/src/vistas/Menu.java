
package vistas;

/**
 *
 * @author VIB
 */
public class Menu extends javax.swing.JFrame {

    /**
     * Creates new form Menu
     */
    public Menu() {
        initComponents();
    }

   
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jMenuItem1 = new javax.swing.JMenuItem();
        escritorio = new javax.swing.JDesktopPane();
        label2 = new java.awt.Label();
        jMenuBar2 = new javax.swing.JMenuBar();
        jMenu21 = new javax.swing.JMenu();
        jSalir = new javax.swing.JMenuItem();
        jMenu23 = new javax.swing.JMenu();
        jGuardarMateria = new javax.swing.JMenuItem();
        jEditarMateria = new javax.swing.JMenuItem();
        jListarMateria = new javax.swing.JMenuItem();
        jMenu25 = new javax.swing.JMenu();
        jGuardarAlumno = new javax.swing.JMenuItem();
        jEditarAlumno = new javax.swing.JMenuItem();
        jListaAlumnos = new javax.swing.JMenuItem();
        jMenu31 = new javax.swing.JMenu();
        jFormulario = new javax.swing.JMenuItem();
        jMenu27 = new javax.swing.JMenu();
        jManejoNotas = new javax.swing.JMenuItem();
        jMenu29 = new javax.swing.JMenu();
        jConsultas = new javax.swing.JMenu();

        jMenuItem1.setText("jMenuItem1");

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        escritorio.setBackground(new java.awt.Color(0, 102, 102));
        escritorio.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));

        label2.setAlignment(java.awt.Label.CENTER);
        label2.setFont(new java.awt.Font("Courier New", 0, 24)); // NOI18N
        label2.setForeground(new java.awt.Color(255, 255, 255));
        label2.setText("¡Bienvenid@s a la ULP!");

        escritorio.setLayer(label2, javax.swing.JLayeredPane.DEFAULT_LAYER);

        javax.swing.GroupLayout escritorioLayout = new javax.swing.GroupLayout(escritorio);
        escritorio.setLayout(escritorioLayout);
        escritorioLayout.setHorizontalGroup(
            escritorioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(escritorioLayout.createSequentialGroup()
                .addGap(169, 169, 169)
                .addComponent(label2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(193, 193, 193))
        );
        escritorioLayout.setVerticalGroup(
            escritorioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(escritorioLayout.createSequentialGroup()
                .addGap(170, 170, 170)
                .addComponent(label2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(194, Short.MAX_VALUE))
        );

        jMenu21.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/bandeja-de-entrada.png"))); // NOI18N
        jMenu21.setText("Archivo");

        jSalir.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/salida.png"))); // NOI18N
        jSalir.setText("Salir");
        jSalir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jSalirActionPerformed(evt);
            }
        });
        jMenu21.add(jSalir);

        jMenuBar2.add(jMenu21);

        jMenu23.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/libros.png"))); // NOI18N
        jMenu23.setText("Materias");

        jGuardarMateria.setText("Guardar Materia");
        jGuardarMateria.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jGuardarMateriaActionPerformed(evt);
            }
        });
        jMenu23.add(jGuardarMateria);

        jEditarMateria.setText("Editar Materia");
        jEditarMateria.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jEditarMateriaActionPerformed(evt);
            }
        });
        jMenu23.add(jEditarMateria);

        jListarMateria.setText("Listar Materias");
        jListarMateria.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jListarMateriaActionPerformed(evt);
            }
        });
        jMenu23.add(jListarMateria);

        jMenuBar2.add(jMenu23);

        jMenu25.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/graduado.png"))); // NOI18N
        jMenu25.setText("Alumnos");

        jGuardarAlumno.setText("Guardar Alumno");
        jGuardarAlumno.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jGuardarAlumnoActionPerformed(evt);
            }
        });
        jMenu25.add(jGuardarAlumno);

        jEditarAlumno.setText("Editar Alumno");
        jEditarAlumno.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jEditarAlumnoActionPerformed(evt);
            }
        });
        jMenu25.add(jEditarAlumno);

        jListaAlumnos.setText("Listar Alumnos");
        jListaAlumnos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jListaAlumnosActionPerformed(evt);
            }
        });
        jMenu25.add(jListaAlumnos);

        jMenuBar2.add(jMenu25);

        jMenu31.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/cuestionario.png"))); // NOI18N
        jMenu31.setText("Inscripciones");

        jFormulario.setText("Formulario");
        jFormulario.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jFormularioActionPerformed(evt);
            }
        });
        jMenu31.add(jFormulario);

        jMenuBar2.add(jMenu31);

        jMenu27.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/lista-de-verificacion.png"))); // NOI18N
        jMenu27.setText("Nota");

        jManejoNotas.setText("Manejo de Notas");
        jManejoNotas.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jManejoNotasActionPerformed(evt);
            }
        });
        jMenu27.add(jManejoNotas);

        jMenuBar2.add(jMenu27);

        jMenu29.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/documento.png"))); // NOI18N
        jMenu29.setText("Consultas");

        jConsultas.setText("Informes de alumno por materia");
        jMenu29.add(jConsultas);

        jMenuBar2.add(jMenu29);

        setJMenuBar(jMenuBar2);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(escritorio)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(escritorio, javax.swing.GroupLayout.Alignment.TRAILING)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jSalirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jSalirActionPerformed
        // TODO add your handling code here:
        System.exit(0);
    }//GEN-LAST:event_jSalirActionPerformed

    private void jGuardarMateriaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jGuardarMateriaActionPerformed
        // TODO add your handling code here:
        escritorio.removeAll();
        escritorio.repaint();
        VistasGuardarMateria vgm = new VistasGuardarMateria();
        vgm.setVisible(true);
        escritorio.add(vgm);
    }//GEN-LAST:event_jGuardarMateriaActionPerformed

    private void jEditarMateriaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jEditarMateriaActionPerformed
        // TODO add your handling code here:
        escritorio.removeAll();
        escritorio.repaint();
        VistasEditarMateria vem = new VistasEditarMateria();
        vem.setVisible(true);
        escritorio.add(vem);
    }//GEN-LAST:event_jEditarMateriaActionPerformed

    private void jGuardarAlumnoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jGuardarAlumnoActionPerformed
        // TODO add your handling code here:
        escritorio.removeAll();
        escritorio.repaint();
        VistasGuardarAlumno vga = new VistasGuardarAlumno();
        vga.setVisible(true);
        escritorio.add(vga);
    }//GEN-LAST:event_jGuardarAlumnoActionPerformed

    private void jEditarAlumnoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jEditarAlumnoActionPerformed
        // TODO add your handling code here:
        escritorio.removeAll();
        escritorio.repaint();
        VistasEditarAlumno vea = new VistasEditarAlumno();
        vea.setVisible(true);
        escritorio.add(vea);
    }//GEN-LAST:event_jEditarAlumnoActionPerformed

    private void jListarMateriaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jListarMateriaActionPerformed
        // TODO add your handling code here:
        escritorio.removeAll();
        escritorio.repaint();
        VistaListarMaterias vlm = new VistaListarMaterias();
        vlm.setVisible(true);
        escritorio.add(vlm);
    }//GEN-LAST:event_jListarMateriaActionPerformed

    private void jListaAlumnosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jListaAlumnosActionPerformed
        // TODO add your handling code here:
        escritorio.removeAll();
        escritorio.repaint();
        VistaListarAlumnos vla = new VistaListarAlumnos();
        vla.setVisible(true);
        escritorio.add(vla);
    }//GEN-LAST:event_jListaAlumnosActionPerformed

    private void jFormularioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jFormularioActionPerformed
        // TODO add your handling code here:
        escritorio.removeAll();
        escritorio.repaint();
        VistasInscripciones vi = new VistasInscripciones();
        vi.setVisible(true);
        escritorio.add(vi);
    }//GEN-LAST:event_jFormularioActionPerformed

    private void jManejoNotasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jManejoNotasActionPerformed
        // TODO add your handling code here:
        escritorio.removeAll();
        escritorio.repaint();
        VistaCargarNota vcn = new VistaCargarNota();
        vcn.setVisible(true);
        escritorio.add(vcn);
    }//GEN-LAST:event_jManejoNotasActionPerformed

    /**
     * @param args the command line arguments
     */
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
            java.util.logging.Logger.getLogger(Menu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Menu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Menu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Menu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Menu().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JDesktopPane escritorio;
    private javax.swing.JMenu jConsultas;
    private javax.swing.JMenuItem jEditarAlumno;
    private javax.swing.JMenuItem jEditarMateria;
    private javax.swing.JMenuItem jFormulario;
    private javax.swing.JMenuItem jGuardarAlumno;
    private javax.swing.JMenuItem jGuardarMateria;
    private javax.swing.JMenuItem jListaAlumnos;
    private javax.swing.JMenuItem jListarMateria;
    private javax.swing.JMenuItem jManejoNotas;
    private javax.swing.JMenu jMenu21;
    private javax.swing.JMenu jMenu23;
    private javax.swing.JMenu jMenu25;
    private javax.swing.JMenu jMenu27;
    private javax.swing.JMenu jMenu29;
    private javax.swing.JMenu jMenu31;
    private javax.swing.JMenuBar jMenuBar2;
    private javax.swing.JMenuItem jMenuItem1;
    private javax.swing.JMenuItem jSalir;
    private java.awt.Label label2;
    // End of variables declaration//GEN-END:variables
}
