package controlador;

import dao.AsociadosDao;
import modelo.Asociados;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import vistas.VistaAsociados;

public class AsociadosControlador implements ActionListener, MouseListener {

    VistaAsociados vista = new VistaAsociados();
    AsociadosDao dao = new AsociadosDao();
    Asociados modelo = new Asociados();
    private String mensaje = null;

    public AsociadosControlador(VistaAsociados vistaAsociados) {
        this.vista = vista;
        vista.jBtnAgregar.addActionListener(this);
        vista.jBtnBuscar.addActionListener(this);
        vista.jBtnEliminar.addActionListener(this);
        vista.jBtnModificar.addActionListener(this);
    }

    public void insertarAsociados() {
        modelo.setAsociado_id(Integer.parseInt(this.vista.jTxtAsociadosId.getText()));
        modelo.setAnte_penal(this.vista.jTxtAntecedentesPena.getText());
        modelo.setAnte_poli(this.vista.jTxtAntecedentesPoli.getText());
        modelo.setDpiImagen(this.vista.jTxtDpiImg.getText());
        modelo.setEspecialidad(this.vista.jTxtEspecialidad.getText());
        modelo.setFoto(this.vista.jTxtFoto.getText());
        modelo.setNivel_acad_id(Byte.parseByte(this.vista.jTxtNivAcad.getText()));
        modelo.setUsuario_aso(this.vista.jTxtUsuario.getText());
        modelo.setUsuario_contra(this.vista.jTxtPassword.getText());
        mensaje = dao.insertarAsociados(modelo);
        JOptionPane.showMessageDialog(vista, mensaje);
        listarAsociados();
    }

    public void eliminarAsociados() {
        modelo.setAsociado_id(Integer.parseInt(this.vista.jTxtAsociadosId.getText()));
        mensaje = dao.eliminarAsociados(modelo);
        JOptionPane.showMessageDialog(vista, mensaje);
        listarAsociados();

    }

    public void modificarAsociados() {
        modelo.setAsociado_id(Integer.parseInt(this.vista.jTxtAsociadosId.getText()));
        modelo.setAnte_penal(this.vista.jTxtAntecedentesPena.getText());
        modelo.setAnte_poli(this.vista.jTxtAntecedentesPoli.getText());
        modelo.setDpiImagen(this.vista.jTxtDpiImg.getText());
        modelo.setEspecialidad(this.vista.jTxtEspecialidad.getText());
        modelo.setFoto(this.vista.jTxtFoto.getText());
        modelo.setNivel_acad_id(Byte.parseByte(this.vista.jTxtNivAcad.getText()));
        modelo.setUsuario_aso(this.vista.jTxtUsuario.getText());
        modelo.setUsuario_contra(this.vista.jTxtPassword.getText());
        mensaje = dao.modificarAsociados(modelo);
        JOptionPane.showMessageDialog(vista, mensaje);
        listarAsociados();
    }

    public void buscarAsociados() {
        int codigo = Integer.parseInt(this.vista.jTxtAsociadosId.getText());
        modelo = dao.buscarAsociados(codigo);
        this.vista.jTxtAntecedentesPena.setEnabled(false);
        this.vista.jTxtAntecedentesPoli.setEnabled(false);
        this.vista.jTxtDpiImg.setEnabled(false);
        this.vista.jTxtEspecialidad.setEnabled(false);
        this.vista.jTxtFoto.setEnabled(false);
        this.vista.jTxtNivAcad.setEnabled(false);
        this.vista.jTxtUsuario.setEnabled(false);
        this.vista.jTxtPassword.setEnabled(false);

    }

    public void listarAsociados() {
        ArrayList<Asociados> listar = dao.listarAsociados();

        DefaultTableModel tabla = (DefaultTableModel) vista.jTblAsociados.getModel();
        Object[] fila = new Object[tabla.getColumnCount()];
        for (int i = 0; i < listar.size(); i++) {
            fila[0] = listar.get(i).getAsociado_id();
            fila[1] = listar.get(i).getAnte_penal();
            fila[2] = listar.get(i).getAnte_poli();
            fila[3] = listar.get(i).getDpiImagen();
            fila[4] = listar.get(i).getEspecialidad();
            fila[5] = listar.get(i).getFoto();
            fila[6] = listar.get(i).getNivel_acad_id();
            fila[7] = listar.get(i).getUsuario_aso();
            fila[8] = listar.get(i).getUsuario_contra();
            tabla.addRow(fila);
        }

    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == this.vista.jBtnAgregar) {
            insertarAsociados();
        }
        if (e.getSource() == this.vista.jBtnBuscar) {
            buscarAsociados();
        }
        if (e.getSource() == this.vista.jBtnEliminar) {
            eliminarAsociados();
        }
        if (e.getSource() == this.vista.jBtnModificar) {
            modificarAsociados();
        }

    }

    @Override
    public void mouseClicked(MouseEvent e) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void mousePressed(MouseEvent e) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void mouseReleased(MouseEvent e) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void mouseEntered(MouseEvent e) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void mouseExited(MouseEvent e) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}
