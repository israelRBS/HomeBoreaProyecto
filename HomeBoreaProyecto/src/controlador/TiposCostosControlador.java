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
import javax.swing.JOptionPane;
import modelo.TiposCosto;
import vistas.JFrmTipoCostos;

/**
 *
 * @author Admin
 */
public class TiposCostosControlador implements ActionListener, MouseListener{
    
    String mensaje;
    JFrmTipoCostos vista ;
    TiposCosto costo = new TiposCosto();
    TipoCostoDao dao = new TipoCostoDao();
    
    public TiposCostosControlador(JFrmTipoCostos vista){
        this.vista = vista;
        this.vista.jBtnBuscar.addActionListener(this);
        this.vista.jBtnModificar.addActionListener(this);
        this.vista.jBtnGuardar.addActionListener(this);
        this.vista.jBtnEliminar.addActionListener(this);
        this.vista.jBtnNuevo.addActionListener(this);
        
        this.vista.jTblTabla.addMouseListener(this);
        
    }
    public void guardarTipoCosto(){
        costo.setTipocosto_id(Byte.parseByte(this.vista.jTxtTipoCosto.getText()));
        costo.setDescripcion(this.vista.jTxtDescripcion.getText());
        mensaje = dao.insertarTipCosto(costo);
        JOptionPane.showMessageDialog(vista, mensaje);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
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
