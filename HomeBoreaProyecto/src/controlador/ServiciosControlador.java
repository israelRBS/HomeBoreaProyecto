/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador;

import dao.ServiciosDao;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import modelo.Servicios;
import vistas.JFrmServicios;

/**
 *
 * @author Admin
 */
public class ServiciosControlador implements ActionListener, MouseListener {

    /* INSTANCIANDO LA VISTA PARA PODER UTILIZAR LOS OBJETOS PUBLICOS */
    JFrmServicios vista;
    /* INSTANCIANDO EL MODELO DE LA TABLA */
    Servicios servicio = new Servicios();
    /* INSTANCIANDO EL DAO PARA PODER UTILIZAR LAS CONSULTAS PREPARADAS */
    ServiciosDao dao = new ServiciosDao();
    /* VARIABLE DE CLASE */
    private String mensaje;

    /* CONSTRUCTOR PARA INICIALIZAR LOS OBJETOS */
    public ServiciosControlador(JFrmServicios vista) {
        this.vista = vista;
        this.vista.jBtnEliminar.addActionListener(this);
        this.vista.jBtnGuardar.addActionListener(this);
        this.vista.jBtnModificar.addActionListener(this);
        this.vista.jBtnNuevo.addActionListener(this);
        this.vista.jBtnBuscar.addActionListener(this);
        this.vista.jTblTabla.addMouseListener(this);
        listarServicios();
        limpiarCuadros();
    }

    /* METODO QUE NOS PERMETIRA GUARDAR LOS DATOS A TRAVES DE LOS IMPUTS */
    public void guardarServicio() {
        servicio.setServicio_id(Integer.parseInt(this.vista.jTxtServicio.getText()));
        servicio.setAsociado_id(Integer.parseInt(this.vista.jTxtAsociado.getText()));
        servicio.setSubcategoria_id(Integer.parseInt(this.vista.jTxtSubcategoria.getText()));
        servicio.setCosto(Short.parseShort(this.vista.jTxtCosto.getText()));
        servicio.setTipocosto_id(Byte.parseByte(this.vista.jTxtTipoCosto.getText()));
        mensaje = dao.insertServicios(servicio);
        JOptionPane.showMessageDialog(vista, mensaje);
        limpiarCuadros();
        listarServicios();
    }

    /* METODO QUE NOS PERMETIRA MODIFICAR LOS DATOS DE LA BASE_DE_DATOS */
    public void modificarServicio() {
        servicio.setServicio_id(Integer.parseInt(this.vista.jTxtServicio.getText()));
        servicio.setAsociado_id(Integer.parseInt(this.vista.jTxtAsociado.getText()));
        servicio.setSubcategoria_id(Integer.parseInt(this.vista.jTxtSubcategoria.getText()));
        servicio.setCosto(Short.parseShort(this.vista.jTxtCosto.getText()));
        servicio.setTipocosto_id(Byte.parseByte(this.vista.jTxtTipoCosto.getText()));
        mensaje = dao.updateServicios(servicio);
        JOptionPane.showMessageDialog(vista, mensaje);
        limpiarCuadros();
        listarServicios();
    }

    /* METODO QUE NOS PERMITIRA ELIMINAR UN REGISTRO DE LA BASE_DE_DATOS */
    public void eliminarServicio() {
        servicio.setServicio_id(Integer.parseInt(this.vista.jTxtServicio.getText()));
        mensaje = dao.deleteServicios(servicio);
        JOptionPane.showMessageDialog(vista, mensaje);
        limpiarCuadros();
        listarServicios();
    }

    /* METODO QUE NOS PERMITIRA BUSCAR UN REGISTRO */
    public void buscarServicio() {
        int codigo = Integer.parseInt(this.vista.jTxtServicio.getText());
        servicio = dao.buscarServicios(codigo);
        limpiarCuadros();
    }

    /* METODO PARA MOSTRAR TODOS LOS DATOS DE LA TABLA */
    public void mostrarServicios() {
        ArrayList<Servicios> lista = dao.listarServicios();
        DefaultTableModel modelo = (DefaultTableModel) vista.jTblTabla.getModel();
        Object[] fila = new Object[modelo.getColumnCount()];
        for (int i = 0; i < lista.size(); i++) {
            fila[0] = lista.get(i).getServicio_id();
            fila[1] = lista.get(i).getAsociado_id();
            fila[2] = lista.get(i).getSubcategoria_id();
            fila[3] = lista.get(i).getCosto();
            fila[4] = lista.get(i).getTipocosto_id();
            modelo.addRow(fila);
        }
    }

    /* METODO PARA OBTENER LOS DATOS DE LA TABLA */
    public void obtenerDatosServicios() {
        this.vista.jTxtServicio.setText(String.valueOf(this.vista.jTblTabla.getValueAt(this.vista.jTblTabla.getSelectedRow(), 0)));
        this.vista.jTxtAsociado.setText(String.valueOf(this.vista.jTblTabla.getValueAt(this.vista.jTblTabla.getSelectedRow(), 1)));
        this.vista.jTxtSubcategoria.setText(String.valueOf(this.vista.jTblTabla.getValueAt(this.vista.jTblTabla.getSelectedRow(), 2)));
        this.vista.jTxtCosto.setText(String.valueOf(this.vista.jTblTabla.getValueAt(this.vista.jTblTabla.getSelectedRow(), 3)));
        this.vista.jTxtTipoCosto.setText(String.valueOf(this.vista.jTblTabla.getValueAt(this.vista.jTblTabla.getSelectedRow(), 4)));
    }

    /* METODO PARA LISTAR TODOS LOS DATOS DE LA TABLA */
    public void listarServicios() {
        String[] titulos = {"ID_SERVICIO", "ID_ASOCIADO", "ID_SUBCATEGORIA", "COSTO", "TIPO_COSTO"};
        DefaultTableModel modelo = new DefaultTableModel(titulos, 0);
        Object[] columnas = new Object[5];
        for (Servicios servicios : dao.listarServicios()) {
            columnas[0] = servicios.getServicio_id();
            columnas[1] = servicios.getAsociado_id();
            columnas[2] = servicios.getSubcategoria_id();
            columnas[3] = servicios.getCosto();
            columnas[4] = servicios.getTipocosto_id();

            modelo.addRow(columnas);
        }
        this.vista.jTblTabla.setModel(modelo);
    }

    /* METODO QUE LIMPIARA LOS CUADROS DE TEXTO */
    public void limpiarCuadros() {
        this.vista.jTxtServicio.setText("");
        this.vista.jTxtAsociado.setText("");
        this.vista.jTxtSubcategoria.setText("");
        this.vista.jTxtCosto.setText("");
        this.vista.jTxtTipoCosto.setText("");
    }

    /* METODO PARA EJECUTAR LAS ACCIONES */
    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == this.vista.jBtnGuardar) {
            guardarServicio();
        }
        if (e.getSource() == this.vista.jBtnModificar) {
            modificarServicio();
        }
        if (e.getSource() == this.vista.jBtnEliminar) {
            eliminarServicio();
        }
        if (e.getSource() == this.vista.jBtnBuscar) {
            buscarServicio();
        }
    }

    @Override
    public void mouseClicked(MouseEvent e) {
        if (e.getSource() == this.vista.jTblTabla) {
            obtenerDatosServicios();
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
