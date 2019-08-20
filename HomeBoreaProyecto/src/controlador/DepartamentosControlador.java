/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador;

import dao.DepartamentosDao;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import modelo.Departamentos;
import vistas.VistaDepartamento;

/**
 *
 * @author Admin
 */
public class DepartamentosControlador implements ActionListener, MouseListener {

    /* INSTANCIA DE LA VISTA PARA PODER UTILIZAR LOS OBJETOS PUBLICOS */
    VistaDepartamento vista;
    /* INSTANCIA DE LA CLASE DAO PARA PODER UTILIZAR LAS CONSULTAS PREPARADAS */
    DepartamentosDao dao = new DepartamentosDao();
    /* INSTANCIA DE LA CLASE MODELO QUE CONTIENE EL DISEÑOD DE LA TABLA */
    Departamentos departamento = new Departamentos();
    /* PROPIEDAD DE CLASE */
    private String mensaje;

    /* CONSTRUCTOR PARA INICIALIZAR LOS OBJETOS */
    public DepartamentosControlador(VistaDepartamento vista) {
        this.vista = vista;
        this.vista.jBtnBuscar.addActionListener(this);
        this.vista.jBtnEliminar.addActionListener(this);
        this.vista.jBtnGuardar.addActionListener(this);
        this.vista.jBtnModificar.addActionListener(this);
        this.vista.jTblDepartemento.addMouseListener(this);
        clean();
        listarDepartamentos();
    }

    /* METODO QUE NOS PERMITE GUARDAR DEPARTAMENTOS */
    public void guardarDepartemento() {
        departamento.setDepa_id(Byte.parseByte(this.vista.jTxtDepartamento.getText()));
        departamento.setNombre(this.vista.jTxtNombre.getText());
        departamento.setRegion_id(Byte.parseByte(this.vista.jTxtRegion.getText()));
        mensaje = dao.agregarDepartamentos(departamento);
        JOptionPane.showMessageDialog(vista, mensaje);
        clean();
        listarDepartamentos();
    }

    /* METODO QUE NOS PERMITRA MODIFICAR DEPARTAMENTOS */
    public void modificarDepartamento() {
        departamento.setDepa_id(Byte.parseByte(this.vista.jTxtDepartamento.getText()));
        departamento.setNombre(this.vista.jTxtNombre.getText());
        departamento.setRegion_id(Byte.parseByte(this.vista.jTxtRegion.getText()));
        mensaje = dao.modificarDepartamentos(departamento);
        JOptionPane.showMessageDialog(vista, mensaje);
        clean();
        listarDepartamentos();
    }

    /* METODO QUE NOS PERMITIRA ELIMINAR UN DEPARTAMENTO A LA VEZ */
    public void eliminarDepartamento() {
        departamento.setDepa_id(Byte.parseByte(this.vista.jTxtDepartamento.getText()));
        mensaje = dao.eliminarDepartamentos(departamento);
        JOptionPane.showMessageDialog(vista, mensaje);
        clean();
        listarDepartamentos();
    }

    /* METODO QUE NOS PERMITRA BUSCAR UN DEPARTAMENTO */
    public void buscarDepartamento() {
        departamento.setDepa_id(Byte.parseByte(this.vista.jTxtDepartamento.getText()));
        departamento = dao.buscarDepartamentos(departamento);
    }

    /* METODO QUE NOS PEMRITRA VER TODOS LOS DATOS DE LA TABLA */
    public void mostrarDatos() {
        ArrayList<Departamentos> lista = dao.listarDepartamentos();
        DefaultTableModel modelo = (DefaultTableModel) vista.jTblDepartemento.getModel();
        Object[] columnas = new Object[modelo.getColumnCount()];
        for (int i =0; i<lista.size(); i++) {
            columnas[0] = lista.get(i).getDepa_id();
            columnas[1] = lista.get(i).getNombre();
            columnas[2] = lista.get(i).getRegion_id();
            modelo.addRow(columnas);
        }
    }
    
    /* METODO QUE NOS PERMITRA OBTNER LOS DATOS DE LA TABLA */
    public void obtenerDatosTabla(){
        this.vista.jTxtDepartamento.setText(String.valueOf(this.vista.jTblDepartemento.getValueAt(this.vista.jTblDepartemento.getSelectedRow(), 0)));
        this.vista.jTxtNombre.setText(String.valueOf(this.vista.jTblDepartemento.getValueAt(this.vista.jTblDepartemento.getSelectedRow(), 1)));
        this.vista.jTxtRegion.setText(String.valueOf(this.vista.jTblDepartemento.getValueAt(this.vista.jTblDepartemento.getSelectedRow(), 2)));
    }

    /* METODO QUE NOS PERMITRA LISTAR TODOS LOS DATOS DE LA TABLA */
    public void listarDepartamentos(){
        String[] titulos={"NO.DEPARTAMENTO","NOMBRE","NO.REGION"};
        DefaultTableModel model = new DefaultTableModel(titulos, 0);
        Object[] columnas = new Object[3];
        for (Departamentos  cate : dao.listarDepartamentos()) {
            columnas[0] = cate.getDepa_id();
            columnas[1] = cate.getNombre();
            columnas[2] = cate.getRegion_id();
            
            model.addRow(columnas);
        }
        this.vista.jTblDepartemento.setModel(model);
    }
    
    /* METODO QUE LIMPIAR LOS CUADOR DE TEXTO */
    public void clean(){
        this.vista.jTxtDepartamento.setText("");
        this.vista.jTxtNombre.setText("");
        this.vista.jTxtRegion.setText("");
    }
    @Override
    public void actionPerformed(ActionEvent e) {

        if (e.getSource() == this.vista.jBtnGuardar) {
            guardarDepartemento();
        }
        if (e.getSource() == this.vista.jBtnModificar) {
            modificarDepartamento();
        }
        if (e.getSource() == this.vista.jBtnEliminar) {
            eliminarDepartamento();
        }
        if (e.getSource() == this.vista.jBtnBuscar) {
            buscarDepartamento();
        }

    }

    @Override
    public void mouseClicked(MouseEvent e) {
         
        if (e.getSource() == this.vista.jTblDepartemento){
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
