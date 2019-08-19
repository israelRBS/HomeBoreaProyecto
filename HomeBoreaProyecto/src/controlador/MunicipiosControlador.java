/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador;

import dao.MunicipiosDao;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import modelo.Municipios;
import vistas.VistaMunicipios;

/**
 *
 * @EDWIN_ESTUARDO
 */
public class MunicipiosControlador implements ActionListener, MouseListener {

    /* INSTANCIA DE LA VISTA PARA USO DE LOS OBJETOS PUBLICOS */
    VistaMunicipios vista;
    /* INSTANCIA DEL MODELO DE LA TABLA */
    Municipios municipio = new Municipios();
    /* ISNTANCIA DEL DAO PARA CONSULTAS PREPARADAS */
    MunicipiosDao dao = new MunicipiosDao();
    /* PROPIEDADAD DE CLASE*/
    private String mensaje;

    /* CONSTRUCTOR PARA INICIALIZAR LOS OBJETOS */
    public MunicipiosControlador(VistaMunicipios vista) {
        this.vista = vista;
        this.vista.jBtnAgregar.addActionListener(this);
        this.vista.jBtnBuscar.addActionListener(this);
        this.vista.jBtnModificar.addActionListener(this);
        this.vista.jBtnEliminar.addActionListener(this);
        this.vista.jTblMunicipios.addMouseListener(this);
        cleanPictures();
        listarDatosTabla();
    }

    /* METODO PARA BUSCAR MUNICIPIO */
    public void buscarMunicipio() {
        municipio.setMunicipio_id(Short.parseShort(this.vista.jTxtMunipioId.getText()));
        municipio = dao.buscarMunicipios(municipio);
    }

    /* METODO PARA GUARDAR MUNICIPIO */
    public void guardarMunicipio() {
        municipio.setMunicipio_id(Short.parseShort(this.vista.jTxtMunipioId.getText()));
        municipio.setNombre(this.vista.jTxtNombre.getText());
        municipio.setDepa_id(Byte.parseByte(this.vista.jTxtDepartamentoId.getText()));
        mensaje = dao.agregarMunicipios(municipio);
        JOptionPane.showMessageDialog(vista, mensaje);
        cleanPictures();
        listarDatosTabla();
    }

    /* METODO PARA MODIFICAR MUNICIPIO */
    public void modificarMunicipio() {
        municipio.setMunicipio_id(Short.parseShort(this.vista.jTxtMunipioId.getText()));
        municipio.setNombre(this.vista.jTxtNombre.getText());
        municipio.setDepa_id(Byte.parseByte(this.vista.jTxtDepartamentoId.getText()));
        mensaje = dao.modificarMunicipio(municipio);
        JOptionPane.showMessageDialog(vista, mensaje);
        cleanPictures();
        listarDatosTabla();
    }

    /* METODO PARA ELIMINAR MUNICIPIO*/
    public void eliminarMunicipio() {
        municipio.setMunicipio_id(Short.parseShort(this.vista.jTxtMunipioId.getText()));
        mensaje = dao.eliminarMunicipios(municipio);
        JOptionPane.showMessageDialog(vista, mensaje);
        cleanPictures();
        listarDatosTabla();
    }

    /* METODO PARA MOSTRAR DATOS DE LA TABLA */
    public void mostrarDatos() {
        ArrayList<Municipios> lista = dao.listarMunicipios();
        DefaultTableModel modelo = (DefaultTableModel) vista.jTblMunicipios.getModel();
        Object[] fila = new Object[modelo.getColumnCount()];
        for (int i = 0; i < lista.size(); i++) {
            fila[0] = lista.get(i).getMunicipio_id();
            fila[1] = lista.get(i).getNombre();
            fila[2] = lista.get(i).getDepa_id();
            modelo.addRow(fila);
        }
    }

    /* METODO PARA OBTENER DATOS DE LA TABLA */
    public void obtenerDatosTabla() {
        this.vista.jTxtMunipioId.setText(String.valueOf(this.vista.jTblMunicipios.getValueAt(this.vista.jTblMunicipios.getSelectedRow(), 0)));
        this.vista.jTxtNombre.setText(String.valueOf(this.vista.jTblMunicipios.getValueAt(this.vista.jTblMunicipios.getSelectedRow(), 1)));
        this.vista.jTxtDepartamentoId.setText(String.valueOf(this.vista.jTblMunicipios.getValueAt(this.vista.jTblMunicipios.getSelectedRow(), 2)));
    }

    /* METODO PARA LISTAR DATOS DE LA TABLA */
    public void listarDatosTabla() {
        String[] cabecera = {"MUNICIPIO", "NOMBRE", "NO.DEPARTAMENTO"};
        DefaultTableModel model = new DefaultTableModel(cabecera, 0);
        Object[] columnas = new Object[3];
        for (Municipios muni : dao.listarMunicipios()) {
            columnas[0] = muni.getMunicipio_id();
            columnas[1] = muni.getNombre();
            columnas[2] = muni.getDepa_id();
            model.addRow(columnas);
        }
            this.vista.jTblMunicipios.setModel(model);
    }
    
    /* METODO PARA LIMPIAR LOS CUADROS DE TEXTO */
    public void cleanPictures(){
        this.vista.jTxtMunipioId.setText("");
        this.vista.jTxtNombre.setText("");
        this.vista.jTxtDepartamentoId.setText("");
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == this.vista.jBtnBuscar) {
            buscarMunicipio();
        }
        if (e.getSource() == this.vista.jBtnAgregar) {
            guardarMunicipio();
        }
        if (e.getSource() == this.vista.jBtnModificar) {
            modificarMunicipio();
        }
        if (e.getSource() == this.vista.jBtnEliminar) {
            eliminarMunicipio();
        }
    }

    @Override
    public void mouseClicked(MouseEvent e) {
        if (e.getSource() == this.vista.jTblMunicipios) {
            obtenerDatosTabla();
        }
    }

    @Override
    public void mousePressed(MouseEvent e) {
        // throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void mouseReleased(MouseEvent e) {
        // throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void mouseEntered(MouseEvent e) {
        //// throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void mouseExited(MouseEvent e) {
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}
