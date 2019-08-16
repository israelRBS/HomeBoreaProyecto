/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador;

import com.sun.org.apache.bcel.internal.generic.AALOAD;
import dao.SubcategoriaDao;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.ArrayList;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import modelo.Subcategorias;
import vistas.VistaSubCategorias;

/**
 *
 * @author Admin
 */
public class SubCategoriaControlador implements ActionListener, MouseListener {

    VistaSubCategorias vista;
    //obtener todas las categorias existentes
    ArrayList<Subcategorias> listaCategoria = new ArrayList<Subcategorias>();
    SubcategoriaDao daoSubCategoria = new SubcategoriaDao();
    DefaultComboBoxModel cmbCategoriaModel = new DefaultComboBoxModel();
    Subcategorias subCategorasModelo = new Subcategorias();
    String mensaje;

    public SubCategoriaControlador(VistaSubCategorias vista) {
        this.vista = vista;
        this.vista.jBtnGuardarSub.addActionListener(this);
        this.vista.jBtnCancelar.addActionListener(this);
        this.vista.jBtnEliminarSub.addActionListener(this);
        this.vista.jBtnModificarSub.addActionListener(this);
        this.vista.jTblListarSubcate.addMouseListener(this);
        this.vista.jBtnCancelar.addActionListener(this);
        cargarCmbCategoria();
        listarSubCategorias();
        activadorCuadros();
    }

    /* METODO PARA GUARDAR SUBCATEGORIA EN LA BASE DE DATOS*/
    public void guardarSubCategoria() {
        subCategorasModelo.setSubcategoria_id(Byte.parseByte(this.vista.jTxtSubcategoria.getText()));
        subCategorasModelo.setNombre(this.vista.jTxtNombreSub.getText());
        subCategorasModelo.setCategoria_id(Byte.parseByte(this.vista.jTxtCategoria.getText()));
        subCategorasModelo.setEmpleado_id(Integer.parseInt(this.vista.jTxtEmpleado.getText()));
        mensaje = daoSubCategoria.insertSubcategia(subCategorasModelo);
        JOptionPane.showMessageDialog(vista, mensaje);
        limpiarCuadros();
        listarSubCategorias();
    }

    /* METODO PARA OBTENER LOS DATOS Y MODIFICAR SUBCATEGORIAS */
    public void modificarSubCategoria() {
        subCategorasModelo.setSubcategoria_id(Byte.parseByte(this.vista.jTxtSubcategoria.getText()));
        subCategorasModelo.setNombre(this.vista.jTxtNombreSub.getText());
        subCategorasModelo.setCategoria_id(Byte.parseByte(this.vista.jTxtCategoria.getText()));
        subCategorasModelo.setEmpleado_id(Integer.parseInt(this.vista.jTxtEmpleado.getText()));
        mensaje = daoSubCategoria.updateSubcategoria(subCategorasModelo);
        JOptionPane.showMessageDialog(vista, mensaje);
        limpiarCuadros();
        listarSubCategorias();
    }

    /* METODO PARA ELIMINAR SUBCATEGORIA */
    public void eliminarSubCategoria() {
        subCategorasModelo.setSubcategoria_id(Byte.parseByte(this.vista.jTxtSubcategoria.getText()));
        mensaje = daoSubCategoria.deleteSubcategoria(subCategorasModelo);
        JOptionPane.showMessageDialog(vista, mensaje);
        limpiarCuadros();
        listarSubCategorias();
    }

    /* METODO PARA BUSCAR SUBCATEGORIA */
    public void buscarSubCategoria() {
        int codigo = Integer.parseInt(this.vista.jTxtSubcategoria.getText());
        subCategorasModelo = daoSubCategoria.buscarSubcategoria(codigo);
        JOptionPane.showMessageDialog(vista, mensaje);
        limpiarCuadros();
        listarSubCategorias();
    }

    /* METODO PARA MOSTRAR DATOS DE LA TABLA SUBCATEGORIAS */
    public void mostrarSubCategorias() {
        ArrayList<Subcategorias> listar = daoSubCategoria.listarSubcategorias();
        DefaultTableModel modelo = (DefaultTableModel) vista.jTblListarSubcate.getModel();
        Object[] filas = new Object[modelo.getColumnCount()];
        for (int i = 0; i < listar.size(); i++) {
            filas[0] = listar.get(i).getSubcategoria_id();
            filas[1] = listar.get(i).getNombre();
            filas[2] = listar.get(i).getCategoria_id();
            filas[3] = listar.get(i).getEmpleado_id();
            modelo.addRow(filas);
        }
    }

    /* METODO PARA OBTENER DATOS DE LA TABLA */
    public void obtenerDatosTabla() {
        this.vista.jTxtSubcategoria.setText(String.valueOf(this.vista.jTblListarSubcate.getValueAt(this.vista.jTblListarSubcate.getSelectedRow(), 0)));
        this.vista.jTxtNombreSub.setText(String.valueOf(this.vista.jTblListarSubcate.getValueAt(this.vista.jTblListarSubcate.getSelectedRow(), 1)));
        this.vista.jTxtCategoria.setText(String.valueOf(this.vista.jTblListarSubcate.getValueAt(this.vista.jTblListarSubcate.getSelectedRow(), 2)));
        this.vista.jTxtEmpleado.setText(String.valueOf(this.vista.jTblListarSubcate.getValueAt(this.vista.jTblListarSubcate.getSelectedRow(), 3)));
    }

    /* METODO PARA LISTA SUBCATEGORIAS */
    public void listarSubCategorias() {
        String[] titulos = {"SUBCATEGORIA", "NOMBRE", "CATEGORIA", "EMPLEADO"};
        DefaultTableModel modelo = new DefaultTableModel(titulos, 0);
        Object[] columnas = new Object[4];
        for (Subcategorias subcate : daoSubCategoria.listarSubcategorias()) {
            columnas[0] = subcate.getSubcategoria_id();
            columnas[1] = subcate.getNombre();
            columnas[2] = subcate.getCategoria_id();
            columnas[3] = subcate.getEmpleado_id();
            modelo.addRow(columnas);
        }
        this.vista.jTblListarSubcate.setModel(modelo);
    }

    /* METODO PARA LIMPIAR LOS IMPUTS O CUADROS DE TEXTO */
    public void limpiarCuadros() {
        this.vista.jTxtSubcategoria.setText("");
        this.vista.jTxtNombreSub.setText("");
        this.vista.jTxtCategoria.setText("");
        this.vista.jTxtEmpleado.setText("");
    }

    /* METODO PARA ACTIVAR LOS CUADROS DE TEXTO SI EN CASO ESTAN DESACTIVADOS */
    public void activadorCuadros() {
        this.vista.jTxtSubcategoria.setEnabled(true);
        this.vista.jTxtNombreSub.setEnabled(true);
        this.vista.jTxtCategoria.setEnabled(true);
        this.vista.jTxtEmpleado.setEnabled(true);

    }

    /* METODO PARA MOSTRAR CADA CATEGORIA EXISTENTE */
    public void cargarCmbCategoria() {
        try {
            listaCategoria = daoSubCategoria.listarSubcategorias();
            for (Subcategorias subcategorias : listaCategoria) {
                cmbCategoriaModel.addElement(subcategorias.getNombre());
            }
            this.vista.jCmbCategoria.setModel(cmbCategoriaModel);
            cmbCategoriaModel.removeAllElements();

        } catch (Exception e) {
            System.out.println("Error: " + e);
        }

    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource()==this.vista.jBtnBuscarSub){
            buscarSubCategoria();
        }
        if(e.getSource()==this.vista.jBtnCancelar){
            activadorCuadros();
        }
        if(e.getSource()==this.vista.jBtnEliminarSub){
            eliminarSubCategoria();
        }
        if(e.getSource()==this.vista.jBtnModificarSub){
            modificarSubCategoria();
        }
        if(e.getSource()==this.vista.jBtnGuardarSub){
            guardarSubCategoria();
        }
    }

    @Override
    public void mouseClicked(MouseEvent e) {
       if(e.getSource()==this.vista.jTblListarSubcate){
            obtenerDatosTabla();
        }
    }

    @Override
    public void mousePressed(MouseEvent e) {
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void mouseReleased(MouseEvent e) {
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void mouseEntered(MouseEvent e) {
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void mouseExited(MouseEvent e) {
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}
