/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador;

import dao.TiposEmpleadosDao;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import modelo.TiposEmpleado;
import vistas.JFrmTiposEmpleados;

/**
 *
 * @author Admin
 */
public class TiposEmpleadosControlador implements ActionListener, MouseListener {

    //INSTANCIANDO LA VISTA PARA TIPOS_EMPLEADOS
    JFrmTiposEmpleados vista;
    // INSTANCIANDO MODEL PARA TIPOS_EMPLEADOS
    TiposEmpleado tipos = new TiposEmpleado();
    // INSTANCIANDO DAO PARA TIPOS_EMPLEADOS
    TiposEmpleadosDao dao = new TiposEmpleadosDao();
    // VARIABLE DE INSTANCIA
    String mensaje;
    
    
    
    /*MODIFICACION DE PRUEBA*/

    public TiposEmpleadosControlador(JFrmTiposEmpleados vista) {
        this.vista = vista;
        this.vista.jBtnBuscar.addActionListener(this);
        this.vista.jBtnGuardar.addActionListener(this);
        this.vista.jBtnModificar.addActionListener(this);
        this.vista.jBtnNuevo.addActionListener(this);
        this.vista.jBtnEliminar.addActionListener(this);
        listarTiposEmpleados();
        this.vista.jTblTabla.addMouseListener(this);
        this.vista.jTxtNombre.setEnabled(false);
    }

    public void guardarTipoEmpleado() {
        tipos.setTipoempleado_id(Integer.parseInt(this.vista.jTxtTipoEmpleado.getText()));
        tipos.setNombre(this.vista.jTxtNombre.getText());
        mensaje = dao.insertarTipEmpleado(tipos);
        JOptionPane.showMessageDialog(vista, mensaje);
        listarTiposEmpleados();
        limpiarCuadrosTextos();

    }

    public void modificarTipoEmpleado() {
        tipos.setTipoempleado_id(Integer.parseInt(this.vista.jTxtTipoEmpleado.getText()));
        tipos.setNombre(this.vista.jTxtNombre.getText());
        mensaje = dao.modificarEmpleado(tipos);
        JOptionPane.showMessageDialog(vista, mensaje);
        listarTiposEmpleados();
        limpiarCuadrosTextos();
    }

    public void eliminarTipoEmpleado() {
        tipos.setTipoempleado_id(Integer.parseInt(this.vista.jTxtTipoEmpleado.getText()));
        mensaje = dao.eliminarTipEmpleado(tipos);
        JOptionPane.showMessageDialog(vista, mensaje);
        listarTiposEmpleados();
        limpiarCuadrosTextos();
    }

    public void buscarTipoEmpleado() {
        int codigo = Integer.parseInt(this.vista.jTxtTipoEmpleado.getText());
        tipos = dao.buscarTipEmpleado(codigo);
        this.vista.jTxtNombre.setEnabled(true);
        this.vista.jTxtNombre.setText(tipos.getNombre());
        

    }

    public void mostrar() {
        ArrayList<TiposEmpleado> lista = dao.listarTipEmpleado();

        DefaultTableModel modelo = (DefaultTableModel) vista.jTblTabla.getModel();
        Object[] filas = new Object[modelo.getColumnCount()];
        for (int i = 0; i < lista.size(); i++) {
            filas[0] = lista.get(i).getTipoempleado_id();
            filas[1] = lista.get(i).getNombre();
            modelo.addRow(filas);

        }
        listarTiposEmpleados();
    }

    public void obtenerDatosTabla() {
        this.vista.jTxtTipoEmpleado.setText(String.valueOf(this.vista.jTblTabla.getValueAt((this.vista.jTblTabla.getSelectedRow()), 0)));
        this.vista.jTxtNombre.setText(String.valueOf(this.vista.jTblTabla.getValueAt((this.vista.jTblTabla.getSelectedRow()), 1)));
        this.vista.jTxtTipoEmpleado.setEnabled(true);
        this.vista.jTxtNombre.setEnabled(true);
    }

    public void listarTiposEmpleados() {
        String[] cabecera = {"TIPO_EMPLEADO", "NOMBRE"};
        DefaultTableModel model = new DefaultTableModel(cabecera, 0);
        Object[] columnas = new Object[2];
        for (TiposEmpleado tipos : dao.listarTipEmpleado()) {
            columnas[0] = tipos.getTipoempleado_id();
            columnas[1] = tipos.getNombre();

            model.addRow(columnas);
        }
        this.vista.jTblTabla.setModel(model);
        
    }

    public void limpiarCuadrosTextos() {
        this.vista.jTxtTipoEmpleado.setText("");
        this.vista.jTxtNombre.setText("");
        
    }

    public void activar() {
        this.vista.jTxtTipoEmpleado.setEnabled(true);
        this.vista.jTxtNombre.setEnabled(true);
        limpiarCuadrosTextos();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == this.vista.jBtnBuscar) {
            buscarTipoEmpleado();  
        }
        if (e.getSource() == this.vista.jBtnModificar) {
            modificarTipoEmpleado();
        }
        if (e.getSource() == this.vista.jBtnEliminar) {
            eliminarTipoEmpleado();
            
        }
        if (e.getSource() == this.vista.jBtnGuardar) {
            guardarTipoEmpleado();
        }
        if(e.getSource() == this.vista.jBtnNuevo){
            activar();
        }
    }

    @Override
    public void mouseClicked(MouseEvent e) {
        if (e.getSource() == this.vista.jTblTabla) {
            obtenerDatosTabla();
        }
    }

    @Override
    public void mousePressed(MouseEvent e) {

    }

    @Override
    public void mouseReleased(MouseEvent e) {

    }

    @Override
    public void mouseEntered(MouseEvent e) {

    }

    @Override
    public void mouseExited(MouseEvent e) {

    }

}
