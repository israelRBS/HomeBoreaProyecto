/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador;

import dao.ConexionBorea;
import dao.NivelesAcademicosDao;
import modelo.NivelesAcademicos;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import vistas.VistasNivelesAca;

/**
 *
 * @EDWIN ESTUARDO LEZANA RAXÓN
 */
public class NivelAcaControlador implements ActionListener, MouseListener {

    /* INSTANCIANDO MODELO DE LA TABAL*/
    NivelesAcademicos nivel = new NivelesAcademicos();
    /* INSTANCIANDO DAO PARA EJECUTAR LA CONSULTA PREPARADA */
    NivelesAcademicosDao dao = new NivelesAcademicosDao();
    /* INSTANCIANDO LA VISTA PARA OBTENER LOS OBJETOS PUBLICOS */
    VistasNivelesAca vista;
    /* PROIEDADES DE CLASE */
    String mensaje;

    /* CONSTRUCTOR PARA INICIALIZAR LOS OBJETOS */
    public NivelAcaControlador(VistasNivelesAca vista) {
        this.vista = vista;
        this.vista.jBtnBuscarNivel.addActionListener(this);
        this.vista.jBtnGuardarNivel.addActionListener(this);
        this.vista.jBtnEliminarNivel.addActionListener(this);
        this.vista.jBtnModificarNivel.addActionListener(this);
        this.vista.jTblTabla.addMouseListener(this);
        limpiarCampos();
        listarNiveles();
    }

    /* METODO PARA GUARDAR NIVVEL ACADEMICO EN LA BASE_DE_DATOS */
    public void guardarNivel() {
        nivel.setNivel_acad_id(Byte.parseByte(this.vista.jTxtNivelId.getText()));
        nivel.setNombre(this.vista.jTxtNombre.getText());
        mensaje = dao.agregarNiveles(nivel);
        JOptionPane.showMessageDialog(vista, mensaje);
        limpiarCampos();
        listarNiveles();
    }

    /* METODO PARA MODIFICAR NIVEL ACADEMICO DE LA BASE DE DATOS */
    public void modificarNivel() {
        nivel.setNivel_acad_id(Byte.parseByte(this.vista.jTxtNivelId.getText()));
        nivel.setNombre(this.vista.jTxtNombre.getText());
        mensaje = dao.modificarNiveles(nivel);
        JOptionPane.showMessageDialog(vista, mensaje);
        limpiarCampos();
        listarNiveles();

    }

    /* METODO PARA ELIMINAR NIVEL ACADEMICO */
    public void eliminarNivel() {
        nivel.setNivel_acad_id(Byte.parseByte(this.vista.jTxtNivelId.getText()));
        mensaje = dao.eliminarNiveles(nivel);
        JOptionPane.showMessageDialog(vista, mensaje);
        limpiarCampos();
        listarNiveles();

    }

    /* METODO PARA BUSCAR NIVEL_ACADEMICO */
    public void buscarNivel() {
        nivel.setNivel_acad_id(Byte.parseByte(this.vista.jTxtNivelId.getText()));
        nivel = dao.buscarNiveles(nivel);
        limpiarCampos();
    }

    /* METODO PARA MOSTRAR DATOS DE LA TABLA DE NIVELES ACADEMICOS */
    public void mostrarDatos() {
        ArrayList<NivelesAcademicos> lista = dao.listarNiveles();
        DefaultTableModel modelo = (DefaultTableModel) vista.jTblTabla.getModel();
        Object[] fila = new Object[modelo.getColumnCount()];
        for (int i = 0; i < lista.size(); i++) {
            fila[0] = lista.get(i).getNivel_acad_id();
            fila[1] = lista.get(i).getNombre();
            modelo.addRow(fila);
        }
    }
    
    /* METODO PARA OBTENER LOS DATOS DE LA TABLA */
    public void obtenerDatosTabla(){
        this.vista.jTxtNivelId.setText(String.valueOf(this.vista.jTblTabla.getValueAt(this.vista.jTblTabla.getSelectedRow(), 0)));
        this.vista.jTxtNombre.setText(String.valueOf(this.vista.jTblTabla.getValueAt(this.vista.jTblTabla.getSelectedRow(), 0)));
    }
    
    /* METODO PARA LISTAR_NIVELES_ACADEMICOS */
    public void listarNiveles(){
        String[] cabecera = {"NIVEL ACADEMICO","NOMBRE"};
        DefaultTableModel modelo = new DefaultTableModel(cabecera,0 );
        Object[] columnas = new Object[2];
        for (NivelesAcademicos nivel : dao.listarNiveles()) {
            columnas[0] = nivel.getNivel_acad_id();
            columnas[1] = nivel.getNombre();
            modelo.addRow(columnas);
        }
            this.vista.jTblTabla.setModel(modelo);
    
    }
    
    /* METODO PARA LIMPIAR LOS CAMPOS...... */
    public void limpiarCampos() {
        this.vista.jTxtNivelId.setText("");
        this.vista.jTxtNombre.setText("");
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == this.vista.jBtnGuardarNivel) {
            guardarNivel();
        }
        if (e.getSource() == this.vista.jBtnEliminarNivel) {
            eliminarNivel();
        }
        if (e.getSource() == this.vista.jBtnModificarNivel) {
            modificarNivel();
        }
        if (e.getSource() == this.vista.jBtnBuscarNivel) {
            buscarNivel();
        }
    }

    @Override
    public void mouseClicked(MouseEvent e) {
        if (e.getSource() == this.vista.jTblTabla){
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
