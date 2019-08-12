/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vistas;

import java.awt.Color;
import java.io.File;
import javax.swing.ImageIcon;

/**
 *
 * @author Admin
 */
public class VistaCategorias extends javax.swing.JInternalFrame {

    /**
     * Creates new form VistaCategorias
     */
    public VistaCategorias() {
        initComponents();
        String ruta = new File ("").getAbsolutePath () + "\\src\\imagenes\\categoria.png";
        jLblImagen.setIcon(new ImageIcon(ruta)); 
        setSize(800, 600);
        //JOptionPane.showMessageDialog(null, System.getProperty("user.dir"));
        this.getContentPane().setBackground(Color.LIGHT_GRAY);
        //setLocationRelativeTo(null);
        setVisible(true);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLblImagen = new javax.swing.JLabel();
        jLblCate = new javax.swing.JLabel();
        jLblNombre = new javax.swing.JLabel();
        jLblEmpleado = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTblListaCategorias = new javax.swing.JTable();
        jBtnBuscarCate = new javax.swing.JButton();
        jLblSubtitulo = new javax.swing.JLabel();
        jBtnGuardarCate = new javax.swing.JButton();
        jBtnModificarCate = new javax.swing.JButton();
        jBtnEliminarCate = new javax.swing.JButton();
        jLblTitulo = new javax.swing.JLabel();
        jTxtCategoria = new javax.swing.JTextField();
        jTxtNombre = new javax.swing.JTextField();
        jTxtEmpleado = new javax.swing.JTextField();

        setClosable(true);
        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setVisible(true);

        jLblImagen.setFont(new java.awt.Font("Times New Roman", 3, 36)); // NOI18N

        jLblCate.setFont(new java.awt.Font("Times New Roman", 3, 18)); // NOI18N
        jLblCate.setForeground(new java.awt.Color(255, 0, 51));
        jLblCate.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLblCate.setText("CATEGORIA_ID");

        jLblNombre.setFont(new java.awt.Font("Times New Roman", 3, 18)); // NOI18N
        jLblNombre.setForeground(new java.awt.Color(255, 0, 51));
        jLblNombre.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLblNombre.setText("CATEGORIA_NOMBRE");

        jLblEmpleado.setFont(new java.awt.Font("Times New Roman", 3, 18)); // NOI18N
        jLblEmpleado.setForeground(new java.awt.Color(255, 0, 51));
        jLblEmpleado.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLblEmpleado.setText("EMPLEADO_ID");

        jTblListaCategorias.setModel(new javax.swing.table.DefaultTableModel(
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
        jScrollPane1.setViewportView(jTblListaCategorias);

        jBtnBuscarCate.setForeground(new java.awt.Color(255, 51, 255));
        jBtnBuscarCate.setText("BUSCAR");

        jLblSubtitulo.setFont(new java.awt.Font("Times New Roman", 2, 18)); // NOI18N
        jLblSubtitulo.setForeground(new java.awt.Color(255, 255, 51));
        jLblSubtitulo.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLblSubtitulo.setText("LISTA CATEGORIAS");

        jBtnGuardarCate.setForeground(new java.awt.Color(255, 51, 255));
        jBtnGuardarCate.setText("GUARDAR");

        jBtnModificarCate.setForeground(new java.awt.Color(255, 51, 255));
        jBtnModificarCate.setText("MODIFICAR");

        jBtnEliminarCate.setForeground(new java.awt.Color(255, 51, 255));
        jBtnEliminarCate.setText("ELIMINAR");

        jLblTitulo.setFont(new java.awt.Font("Times New Roman", 3, 36)); // NOI18N
        jLblTitulo.setForeground(new java.awt.Color(0, 255, 153));
        jLblTitulo.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLblTitulo.setText("CATEGORIAS");

        jTxtEmpleado.setEditable(false);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(45, 45, 45)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jBtnBuscarCate)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jLblSubtitulo, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(jLblCate, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(jLblNombre, javax.swing.GroupLayout.DEFAULT_SIZE, 228, Short.MAX_VALUE)
                                    .addComponent(jLblEmpleado, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                .addGap(18, 18, 18)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(jBtnGuardarCate)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addComponent(jBtnModificarCate))
                                    .addComponent(jTxtCategoria, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(jTxtNombre)
                                        .addGap(42, 42, 42))
                                    .addComponent(jTxtEmpleado, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addComponent(jLblTitulo, javax.swing.GroupLayout.PREFERRED_SIZE, 386, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jBtnEliminarCate)
                                .addGap(189, 189, 189))
                            .addComponent(jLblImagen, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 195, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addComponent(jScrollPane1))
                .addContainerGap(53, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(35, 35, 35)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLblTitulo)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLblCate)
                            .addComponent(jTxtCategoria, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(39, 39, 39)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLblNombre)
                            .addComponent(jTxtNombre, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLblImagen, javax.swing.GroupLayout.PREFERRED_SIZE, 185, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(1, 1, 1)))
                .addGap(40, 40, 40)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLblEmpleado)
                    .addComponent(jTxtEmpleado, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(30, 30, 30)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jBtnGuardarCate)
                    .addComponent(jBtnModificarCate)
                    .addComponent(jBtnEliminarCate))
                .addGap(39, 39, 39)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jBtnBuscarCate)
                    .addComponent(jLblSubtitulo))
                .addGap(29, 29, 29)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 94, Short.MAX_VALUE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

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
            java.util.logging.Logger.getLogger(VistaCategorias.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(VistaCategorias.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(VistaCategorias.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(VistaCategorias.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new VistaCategorias().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    public javax.swing.JButton jBtnBuscarCate;
    public javax.swing.JButton jBtnEliminarCate;
    public javax.swing.JButton jBtnGuardarCate;
    public javax.swing.JButton jBtnModificarCate;
    public javax.swing.JLabel jLblCate;
    public javax.swing.JLabel jLblEmpleado;
    public javax.swing.JLabel jLblImagen;
    public javax.swing.JLabel jLblNombre;
    private javax.swing.JLabel jLblSubtitulo;
    public javax.swing.JLabel jLblTitulo;
    private javax.swing.JScrollPane jScrollPane1;
    public javax.swing.JTable jTblListaCategorias;
    public javax.swing.JTextField jTxtCategoria;
    public javax.swing.JTextField jTxtEmpleado;
    public javax.swing.JTextField jTxtNombre;
    // End of variables declaration//GEN-END:variables
}
