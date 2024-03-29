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

    /* INSTANCIA DE LA VISTA PARA OBTENER LOS OBJETOS PUBLICOS */
    VistaAsociados vista = new VistaAsociados();
    /* INSTANCIA DE LA CLASE DAO ASOCIADOS QUE CONTIENE LAS CONSULTAS PREPARDAS */
    AsociadosDao dao = new AsociadosDao();
    /* ISNTANCIA DE LA CLASE MODELO ASOCIADOS QUE CONTIENE LOS ATRIBUTOS DE LA TABLA */
    Asociados modelo = new Asociados();
    /* PROPIEDAD DE CLASE */
    private String mensaje = null;

    /* CONSTRUCTOR QUE NOS PERMITRA INICIALIZAR LOS OBJETOS */
    public AsociadosControlador(VistaAsociados vistaAsociados) {
        this.vista = vistaAsociados;
        vista.jBtnAgregar.addActionListener(this);
        vista.jBtnBuscar.addActionListener(this);
        vista.jBtnEliminar.addActionListener(this);
        vista.jBtnModificar.addActionListener(this);
        vista.jTblAsociados.addMouseListener(this);
        repositorioAsociados();
        System.out.println("no importa lo que sea");
        vista.jBtnCancelar.addActionListener(this);
        //listarAsociados();
    }

    /* METODO QUE NOS PERMITIRA GUARDAR UN NUEVO ASOCIADO */
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
        limpiarImputs();
        repositorioAsociados();
    }

    /* METODO QUE NOS PERMITIRA ELIMINAR UN ASOCIADO A LA VEZ */
    public void eliminarAsociados() {
        modelo.setAsociado_id(Integer.parseInt(this.vista.jTxtAsociadosId.getText()));
        mensaje = dao.eliminarAsociados(modelo);
        JOptionPane.showMessageDialog(vista, mensaje);
        limpiarImputs();
        repositorioAsociados();
    }

    /* METODO QUE NOS PERMITIRA MODIFICAR DATOS DE ASOCIADOS */
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
        limpiarImputs();
        repositorioAsociados();
    }

    /* METODO QUE NOS PERMITRA BUSCAR ASOCIADOS EN LA BASE_DE_DATOS */
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

    /* METODO QUE NOS PERMITIRA HABILITAR LOS BOTONES Y CUADROS DE TEXTO SI EN CASO ESTAN DESACTIVADOS */
    public void cancelarAcciones() {
        this.vista.jTxtAntecedentesPena.setEnabled(true);
        this.vista.jTxtAntecedentesPoli.setEnabled(true);
        this.vista.jTxtDpiImg.setEnabled(true);
        this.vista.jTxtEspecialidad.setEnabled(true);
        this.vista.jTxtFoto.setEnabled(true);
        this.vista.jTxtNivAcad.setEnabled(true);
        this.vista.jTxtUsuario.setEnabled(true);
        this.vista.jTxtPassword.setEnabled(true);
        this.vista.jBtnEliminar.setEnabled(true);
        this.vista.jBtnModificar.setEnabled(true);
        this.vista.jBtnAgregar.setEnabled(true);
        this.vista.jBtnBuscar.setEnabled(true);
    }

    /* METODO PARA MOSTRAR TODOS LOS DATOS EXISTENTES EN LA TABLA */
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
        this.vista.jTblAsociados.setModel(tabla);
    }

    /* METODO PARA OBTENER LOS DATOS DE LA TABLA */
    public void obtenerDatosTabla() {
        this.vista.jTxtAsociadosId.setText(String.valueOf(this.vista.jTblAsociados.getValueAt(this.vista.jTblAsociados.getSelectedRow(), 0)));
        this.vista.jTxtAntecedentesPena.setText(String.valueOf(this.vista.jTblAsociados.getValueAt(this.vista.jTblAsociados.getSelectedRow(), 1)));
        this.vista.jTxtAntecedentesPoli.setText(String.valueOf(this.vista.jTblAsociados.getValueAt(this.vista.jTblAsociados.getSelectedRow(), 2)));
        this.vista.jTxtDpiImg.setText(String.valueOf(this.vista.jTblAsociados.getValueAt(this.vista.jTblAsociados.getSelectedRow(), 3)));
        this.vista.jTxtEspecialidad.setText(String.valueOf(this.vista.jTblAsociados.getValueAt(this.vista.jTblAsociados.getSelectedRow(), 4)));
        this.vista.jTxtFoto.setText(String.valueOf(this.vista.jTblAsociados.getValueAt(this.vista.jTblAsociados.getSelectedRow(), 5)));
        this.vista.jTxtNivAcad.setText(String.valueOf(this.vista.jTblAsociados.getValueAt(this.vista.jTblAsociados.getSelectedRow(), 6)));
        this.vista.jTxtUsuario.setText(String.valueOf(this.vista.jTblAsociados.getValueAt(this.vista.jTblAsociados.getSelectedRow(), 7)));
        this.vista.jTxtPassword.setText(String.valueOf(this.vista.jTblAsociados.getValueAt(this.vista.jTblAsociados.getSelectedRow(), 8)));
    }

    /* METODO PARA LISTAR TODOS LOS DATOS DE LA TABLA */
    public void repositorioAsociados() {
        String[] titulos = {"ASOCIADO", "PENALES", "POLICIACOS", "DPI", "FOTO", "NIVEL_ACADEMICO", "USUARIO", "CONTRASEÑA"};
        DefaultTableModel modelo = new DefaultTableModel(titulos, 0);
        Object[] columnas = new Object[9];
        for (Asociados aso : dao.listarAsociados()) {
            columnas[0] = aso.getAsociado_id();
            columnas[1] = aso.getAnte_penal();
            columnas[2] = aso.getAnte_poli();
            columnas[3] = aso.getDpiImagen();
            columnas[4] = aso.getEspecialidad();
            columnas[5] = aso.getFoto();
            columnas[6] = aso.getNivel_acad_id();
            columnas[7] = aso.getUsuario_aso();
            columnas[8] = aso.getUsuario_contra();

            System.out.println("carga datos"+ aso.toString());
            modelo.addRow(columnas);
        }
        this.vista.jTblAsociados.setModel(modelo);
    }

    /* METODO PARA LIMPIAR LOS CUADROS DE TEXTO */
    public void limpiarImputs() {
        this.vista.jTxtAsociadosId.setText("");
        this.vista.jTxtAntecedentesPena.setText("");
        this.vista.jTxtAntecedentesPoli.setText("");
        this.vista.jTxtDpiImg.setText("");
        this.vista.jTxtEspecialidad.setText("");
        this.vista.jTxtFoto.setText("");
        this.vista.jTxtNivAcad.setText("");
        this.vista.jTxtUsuario.setText("");
        this.vista.jTxtPassword.setText("");
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
        if (e.getSource() == this.vista.jBtnCancelar) {
            cancelarAcciones();
        }

    }

    @Override
    public void mouseClicked(MouseEvent e) {
        if (e.getSource() == this.vista.jTblAsociados) {
            obtenerDatosTabla();
        }
    }

    @Override
    public void mousePressed(MouseEvent e) {
        System.out.println("");
    }

    @Override
    public void mouseReleased(MouseEvent e) {
        System.out.println("");
    }

    @Override
    public void mouseEntered(MouseEvent e) {
        System.out.println("");
    }

    @Override
    public void mouseExited(MouseEvent e) {
        System.out.println("");
    }

}
