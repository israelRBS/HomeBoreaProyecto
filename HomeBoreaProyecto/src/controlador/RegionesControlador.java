package controlador;

import dao.ConexionBorea;
import dao.RegionesDao;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import modelo.Regiones;
import vistas.VistaRegiones;

public class RegionesControlador implements ActionListener {

    ConexionBorea cnb = new ConexionBorea();
    Regiones modelo = new Regiones();
    RegionesDao dao = new RegionesDao();
    VistaRegiones vista = new VistaRegiones();
    private String mensaje;

    public RegionesControlador(VistaRegiones vista) {
        this.vista = vista;
        this.vista.jBtnBuscar.addActionListener(this);
        this.vista.jBtnEliminar.addActionListener(this);
        this.vista.jBtnGuardar.addActionListener(this);
        this.vista.jBtnModificar.addActionListener(this);
    }

    public void guardarRegiones() {
        modelo.setRegion_id(Byte.parseByte(this.vista.jTxtRegionId.getText()));
        modelo.setNombre(this.vista.jTxtNombre.getText());
        modelo.setDescripcion(this.vista.jTxtDescripcion.getText());
        mensaje = dao.insertarRegiones(modelo);
        JOptionPane.showMessageDialog(vista, mensaje);
        limpiarImputs();
        listarRegiones();
    }

    public void eliminarRegiones() {
        modelo.setRegion_id(Byte.parseByte(this.vista.jTxtRegionId.getText()));
        mensaje = dao.eliminarRegiones(modelo);
        JOptionPane.showMessageDialog(vista, mensaje);
        limpiarImputs();
        listarRegiones();

    }
    public void obtenerDatosTabla(){
        this.vista.jTxtRegionId.setText(String.valueOf(this.vista.jTblListaRegiones.getValueAt(this.vista.jTblListaRegiones.getSelectedRow(), 0)));
        this.vista.jTxtNombre.setText(String.valueOf(this.vista.jTblListaRegiones.getValueAt(this.vista.jTblListaRegiones.getSelectedRow(), 1)));
        this.vista.jTxtDescripcion.setText(String.valueOf(this.vista.jTblListaRegiones.getValueAt(this.vista.jTblListaRegiones.getSelectedRow(), 2)));
    }
    
    public void modificarRegiones(){
        modelo.setRegion_id(Byte.parseByte(this.vista.jTxtRegionId.getText()));
        modelo.setNombre(this.vista.jTxtNombre.getText());
        modelo.setDescripcion(this.vista.jTxtDescripcion.getText());
        mensaje = dao.modificarRegiones(modelo);
        JOptionPane.showMessageDialog(vista, mensaje);
        limpiarImputs();
        listarRegiones();
    }
    
    public void listarRegiones(){
        String [] cabecera = {"region_id","nombre","descripcion"};
        DefaultTableModel modelo = new DefaultTableModel(cabecera, 0);
        Object [] columnas = new Object[3];
        for (Regiones reg : dao.listarRegiones()){
            columnas[0] = reg.getRegion_id();
            columnas[1] = reg.getNombre();
            columnas[2] = reg.getDescripcion();
            
            modelo.addRow(columnas);
        }
        this.vista.jTblListaRegiones.setModel(modelo);
    }
    
    public void limpiarImputs(){
        this.vista.jTxtRegionId.setText("");
        this.vista.jTxtNombre.setText("");
        this.vista.jTxtDescripcion.setText("");
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == this.vista.jBtnGuardar) {
            guardarRegiones();
        }
        if (e.getSource()== this.vista.jBtnEliminar) {
            eliminarRegiones();
        }
    }

}
