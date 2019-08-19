package controlador;

import dao.ConexionBorea;
import dao.RegionesDao;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import modelo.Regiones;
import vistas.VistaRegiones;

public class RegionesControlador implements ActionListener, MouseListener {

    /* INSTANCIA LA CLASE CONEXION */
    ConexionBorea cnb = new ConexionBorea();
    /* INSTANCIANDO EL MODELO DE LA TABLAS */
    Regiones modelo = new Regiones();
    /* INSTANCIANDO EL DAO PARA EJECUTAR CODIGO MY_SQL*/
    RegionesDao dao = new RegionesDao();
    /* ISTANCIANDO LA VISTA PARA OBTENER LOS OBJETOS DE LA VISTA */
    VistaRegiones vista = new VistaRegiones();
    /* ISTANCIA DE CLASE */
    private String mensaje;

    /* CONSTRUCTOR PARA INICIALIZAR LOS OBJETOS */
    public RegionesControlador(VistaRegiones vista) {
        this.vista = vista;
        this.vista.jBtnBuscar.addActionListener(this);
        this.vista.jBtnEliminar.addActionListener(this);
        this.vista.jBtnGuardar.addActionListener(this);
        this.vista.jBtnModificar.addActionListener(this);
        this.vista.jTblListaRegiones.addMouseListener(this);
        listarRegiones();
        limpiarImputs();
    }

    /* METOD PARA GUARDAR LOS DATOS EN LA BASE_DE_DATOS */
    public void guardarRegiones() {
        modelo.setRegion_id(Byte.parseByte(this.vista.jTxtRegionId.getText()));
        modelo.setNombre(this.vista.jTxtNombre.getText());
        modelo.setDescripcion(this.vista.jTxtDescripcion.getText());
        mensaje = dao.insertarRegiones(modelo);
        JOptionPane.showMessageDialog(vista, mensaje);
        limpiarImputs();
        listarRegiones();

    }

    /* METOD PARA ELIMINAR DATOS DE LA BASE_DE_DATOS */
    public void eliminarRegiones() {
        modelo.setRegion_id(Byte.parseByte(this.vista.jTxtRegionId.getText()));
        mensaje = dao.eliminarRegiones(modelo);
        JOptionPane.showMessageDialog(vista, mensaje);
        limpiarImputs();
        listarRegiones();

    }

    /* METODO PARA OBTENER LOS DATOS DE LA TABLA */
    public void obtenerDatosTabla() {
        this.vista.jTxtRegionId.setText(String.valueOf(this.vista.jTblListaRegiones.getValueAt(this.vista.jTblListaRegiones.getSelectedRow(), 0)));
        this.vista.jTxtNombre.setText(String.valueOf(this.vista.jTblListaRegiones.getValueAt(this.vista.jTblListaRegiones.getSelectedRow(), 1)));
        this.vista.jTxtDescripcion.setText(String.valueOf(this.vista.jTblListaRegiones.getValueAt(this.vista.jTblListaRegiones.getSelectedRow(), 2)));
    }

    /* METODO PARA MODFICAR DATOS_DE_LA_BASE_DE_DATOS */
    public void modificarRegiones() {
        modelo.setRegion_id(Byte.parseByte(this.vista.jTxtRegionId.getText()));
        modelo.setNombre(this.vista.jTxtNombre.getText());
        modelo.setDescripcion(this.vista.jTxtDescripcion.getText());
        mensaje = dao.modificarRegiones(modelo);
        JOptionPane.showMessageDialog(vista, mensaje);
        limpiarImputs();
        listarRegiones();
    }

    /* METODO PARA BUSCAR REGION */
    public void buscarRegion() {
        int codigo = Integer.parseInt(this.vista.jTxtRegionId.getText());
        modelo = dao.buscarRegiones(codigo);
    }

    /* METODO PARA MOSTRAR LOS DATOS DE LA TABLA */
    public void mostraRegiones() {
        ArrayList<Regiones> lista = dao.listarRegiones();
        DefaultTableModel modelo = (DefaultTableModel) vista.jTblListaRegiones.getModel();
        Object[] fila = new Object[modelo.getColumnCount()];
        for (int i = 0; i < lista.size(); i++) {
            fila[0] = lista.get(i).getRegion_id();
            fila[1] = lista.get(i).getNombre();
            fila[2] = lista.get(i).getDescripcion();
            modelo.addRow(fila);
        }
    }

    /* METODO PARA LISTAR TODOS LOS DATOS DE LA TABLA DE REGIONES */
    public void listarRegiones() {
        String[] cabecera = {"No.Region", "Nombre", "Descripcion"};
        DefaultTableModel modelo = new DefaultTableModel(cabecera, 0);
        Object[] columnas = new Object[3];
        for (Regiones reg : dao.listarRegiones()) {
            columnas[0] = reg.getRegion_id();
            columnas[1] = reg.getNombre();
            columnas[2] = reg.getDescripcion();
            modelo.addRow(columnas);
        }
        this.vista.jTblListaRegiones.setModel(modelo);
    }

    /* METODO PARA LIMPIAR LOS IMPUTS */
    public void limpiarImputs() {
        this.vista.jTxtRegionId.setText("");
        this.vista.jTxtNombre.setText("");
        this.vista.jTxtDescripcion.setText("");
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == this.vista.jBtnGuardar) {
            guardarRegiones();
        }
        if (e.getSource() == this.vista.jBtnEliminar) {
            eliminarRegiones();
        }
        if (e.getSource() == this.vista.jBtnModificar){
            modificarRegiones();
        }
        if (e.getSource() == this.vista.jBtnBuscar){
            buscarRegion();
        }
    }

    @Override
    public void mouseClicked(MouseEvent e) {
        if (e.getSource() == this.vista.jTblListaRegiones){
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
