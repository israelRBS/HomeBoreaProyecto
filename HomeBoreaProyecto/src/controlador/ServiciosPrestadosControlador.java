/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador;

import dao.ServiciosPrestadosDao;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import javax.swing.table.DefaultTableModel;
import modelo.Categorias;
import modelo.ServiciosPrestados;
import vistas.JFrmServiciosPrestados;

/**
 *
 * @author Admin
 */
public class ServiciosPrestadosControlador implements ActionListener, MouseListener {

    JFrmServiciosPrestados vista = new JFrmServiciosPrestados();
    ServiciosPrestadosDao dao = new ServiciosPrestadosDao();
    ServiciosPrestados serviciosprestados = new ServiciosPrestados();
    String[] cabecera = {"Servicio Prestado Id", "Cliente Id", "Servicio Id","Clasificacion Cliente", "Descripcion Cliente", "Clasificacion asociado","Descripcion asociado"};
    DefaultTableModel model = new DefaultTableModel(cabecera, 0);

    public ServiciosPrestadosControlador(JFrmServiciosPrestados vista) {
        this.vista = vista;
        vista.jBtnBuscar.addActionListener(this);
        vista.jTblTabla.addMouseListener(this);
        listarServiciosPrestados();

    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource()== this.vista.jBtnBuscar) {
            
        }
    }

    @Override
    public void mouseClicked(MouseEvent e) {
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
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

    public void listarServiciosPrestados() {

        Object[] columnas = new Object[7];
        for (ServiciosPrestados sp : dao.listarServiciosPrestados()) {
            columnas[0] = sp.getServicioprestado_id();
            columnas[1] = sp.getCliente_id();
            columnas[2] = sp.getServicio_id();
            columnas[3] = sp.getCalificacion_cliente();
            columnas[4] = sp.getDescripcion_cliente();
            columnas[5] = sp.getCalificacion_asociado();
            columnas[6] = sp.getDescripcion_asociado();

            model.addRow(columnas);
        }
        this.vista.jTblTabla.setModel(model);
    }

    public void limpiarTabla() {
        int a = model.getRowCount() - 1;
        for (int i = 0; i <= a; i++) {
            model.removeRow(0);
        }
    }

    public void buscarServicioPrestado() {
        
        int codigo = Integer.parseInt(this.vista.jTextField1.getText());
        
        limpiarTabla();
        serviciosprestados=dao.buscarServiciosPrestados(codigo);
        
        Object[] columnas = new Object[7];
        for (ServiciosPrestados sp : dao.listarServiciosPrestados()) {
            columnas[0] = sp.getServicioprestado_id();
            columnas[1] = sp.getCliente_id();
            columnas[2] = sp.getServicio_id();
            columnas[3] = sp.getCalificacion_cliente();
            columnas[4] = sp.getDescripcion_cliente();
            columnas[5] = sp.getCalificacion_asociado();
            columnas[6] = sp.getDescripcion_asociado();

            model.addRow(columnas);
        }
        this.vista.jTblTabla.setModel(model);
        
    }
}
