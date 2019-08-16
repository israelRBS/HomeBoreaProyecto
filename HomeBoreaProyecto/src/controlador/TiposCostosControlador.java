/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador;

import dao.TipoCostoDao;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import modelo.TiposCosto;
import vistas.JFrmTipoCostos;

/**
 *
 * @author Admin
 */
public class TiposCostosControlador implements ActionListener, MouseListener {

    /* VARIABLE QUE SE LE ASIGNARA EL DAO */
    String mensaje;
    /* INSTANCIANDO EL FORMULARIO */
    JFrmTipoCostos vista;
    /* INSTANCIANDO EL MODELO DE LA TABLA*/
    TiposCosto costo = new TiposCosto();
    /* INSTANCIANDO EL DAO DE LA TABLA */
    TipoCostoDao dao = new TipoCostoDao();

    /* CONSTRUCTOR PARA INICIALIZAR LOS BOTONES */
    public TiposCostosControlador(JFrmTipoCostos vista) {
        this.vista = vista;
        this.vista.jBtnBuscar.addActionListener(this);
        this.vista.jBtnModificar.addActionListener(this);
        this.vista.jBtnGuardar.addActionListener(this);
        this.vista.jBtnEliminar.addActionListener(this);
        this.vista.jBtnNuevo.addActionListener(this);
        this.vista.jTblTabla.addMouseListener(this);
        this.vista.jBtnCancelar.addActionListener(this);
        /*INSTANCIANDO METODO PARA QUE LA TABLA DE MANTENGA ACTUALIZADA CON CADA OPERACION
            QUE SE SELECCIONE */
        listarTiposCostos();
        /* INICIALIZAMOS EL METODO PARA QUE SE ACTIVEN LOS IMPUTS*/
        activador_y_Limpiador();

    }

    /* METODO PARA GUARDAR LOS VALORES */
    public void guardarTipoCosto() {
        costo.setTipocosto_id(Byte.parseByte(this.vista.jTxtTipoCosto.getText()));
        costo.setDescripcion(this.vista.jTxtDescripcion.getText());
        mensaje = dao.insertarTipCosto(costo);
        JOptionPane.showMessageDialog(vista, mensaje);
        limpiarCuadrosTextos();
        listarTiposCostos();
    }

    /* METODO PARA MODIFICAR LOS DATOS DE TIPOS_COSTOS */
    public void modificarTiposCostos() {
        costo.setTipocosto_id(Byte.parseByte(this.vista.jTxtTipoCosto.getText()));
        costo.setDescripcion(this.vista.jTxtDescripcion.getText());
        mensaje = dao.modificarTipoCosto(costo);
        JOptionPane.showMessageDialog(vista, mensaje);
        limpiarCuadrosTextos();
        listarTiposCostos();
    }

    /* METODO PARA ELIMINAR TIPOS_COSTOS*/
    public void eliminarTiposCostos() {
        costo.setTipocosto_id(Byte.parseByte(this.vista.jTxtTipoCosto.getText()));
        mensaje = dao.eliminarTipCosto(costo);
        JOptionPane.showMessageDialog(vista, mensaje);
        limpiarCuadrosTextos();
        listarTiposCostos();
    }

    /* METODO PARA BUSCAR TIPOS_COSTOS*/
    public void buscarTiposCostos() {
        byte tipocosto_id = Byte.parseByte(this.vista.jTxtTipoCosto.getText());
        costo = dao.buscarTipCosto(costo);
        JOptionPane.showMessageDialog(vista, mensaje);
        limpiarCuadrosTextos();
    }

    /* METODO PARA MOSTRAR LOS DATOS DE LA TIPOS_COSTOS*/
    public void mostrarDatosTiposCostos() {
        ArrayList<TiposCosto> listarDatos = dao.listarTipCosto();
        DefaultTableModel modelo = (DefaultTableModel) vista.jTblTabla.getModel();
        Object[] filas = new Object[modelo.getColumnCount()];
        for (int i = 0; i < listarDatos.size(); i++) {
            filas[0] = listarDatos.get(i).getTipocosto_id();
            filas[1] = listarDatos.get(i).getTipocosto_id();
            modelo.addRow(filas);
        }
    }

    /* METODO PRA OBTENER DATOS DE LA TABLA*/
    public void obtenerDatosTiposCostos() {
        this.vista.jTxtTipoCosto.setText(String.valueOf(this.vista.jTblTabla.getValueAt(this.vista.jTblTabla.getSelectedRow(), 0)));
        this.vista.jTxtDescripcion.setText(String.valueOf(this.vista.jTblTabla.getValueAt(this.vista.jTblTabla.getSelectedRow(), 1)));
    }

    /* METODO PARA LISTAR TODOS LOS DATOS EXISTENTES EN LA TABLA DE TIPOS_COSTOS */
    public void listarTiposCostos() {
        String[] titulos = {"TIPO_COSTO", "DESCRIPCION"};
        DefaultTableModel modelo = new DefaultTableModel(titulos, 0);
        Object[] columnas = new Object[3];
        for (TiposCosto costos : dao.listarTipCosto()) {
            columnas[0] = costos.getTipocosto_id();
            columnas[1] = costos.getTipocosto_id();
            modelo.addRow(columnas);
        }
        this.vista.jTblTabla.setModel(modelo);
    }

    /* METODO PARA LIMPIAR LOS CUADROS DE TEXTOS */
    public void limpiarCuadrosTextos() {
        this.vista.jTxtTipoCosto.setText("");
        this.vista.jTxtDescripcion.setText("");
    }
    /* METODO PARA ACTIVAR LOS BOTONES Y CUADROS DE TEXTO SI EN CASO ESTAN DESACTIVADOS */
    public void activador_y_Limpiador(){
        this.vista.jTxtTipoCosto.setText("");
        this.vista.jTxtDescripcion.setText("");
        this.vista.jTxtTipoCosto.setEnabled(true);
        this.vista.jTxtDescripcion.setEnabled(true);
    }
    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource()==this.vista.jBtnBuscar){
            buscarTiposCostos();
        }
        if(e.getSource()==this.vista.jBtnEliminar){
            eliminarTiposCostos();
        }
        if(e.getSource()==this.vista.jBtnModificar){
            modificarTiposCostos();
        }
        if(e.getSource()==this.vista.jBtnGuardar){
            guardarTipoCosto();
        }
        if(e.getSource()==this.vista.jBtnCancelar){
            activador_y_Limpiador();
        }
    }

    @Override
    public void mouseClicked(MouseEvent e) {
          if(e.getSource()==this.vista.jTblTabla){
              obtenerDatosTiposCostos();
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
