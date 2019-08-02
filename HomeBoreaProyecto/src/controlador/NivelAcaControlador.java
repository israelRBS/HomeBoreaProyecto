/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador;

import dao.NivelesAcademicosDao;
import modelo.NivelesAcademicos;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import vistas.VistasNivelesAca;

/**
 *
 * @EDWIN ESTUARDO LEZANA RAXÓN
 */
public class NivelAcaControlador implements ActionListener, MouseListener{
    
    NivelesAcademicos nivel = new NivelesAcademicos();
    NivelesAcademicosDao dao = new NivelesAcademicosDao();
    VistasNivelesAca vista ;
    String mensaje;
    
    public NivelAcaControlador(VistasNivelesAca vista){
        this.vista = vista;
        this.vista.jBtnBuscarNivel.addActionListener(this);
        this.vista.jBtnGuardarNivel.addActionListener(this);
        this.vista.jBtnEliminarNivel.addActionListener(this);
        this.vista.jBtnModificarNivel.addActionListener(this);
        
        this.vista.jTblTabla.addMouseListener(this);
    }
    public void guardarNivel(){
        
        nivel.setNivel_acad_id(Byte.parseByte(this.vista.jTxtNivelId.getText()));
        nivel.setNombre(this.vista.jTxtNombre.getText());
        mensaje = dao.agregarNiveles(nivel);
        
        limpiarCampos();
        
    }
    public void modificarNivel(){
        nivel.setNivel_acad_id(Byte.parseByte(this.vista.jTxtNivelId.getText()));
        nivel.setNombre(this.vista.jTxtNombre.getText());
        mensaje = dao.modificarNiveles(nivel);
        
    }
    //METODO PARA LIMPIAR LOS CAMPOS......
    public void limpiarCampos(){
        this.vista.jTxtNivelId.setText("");
        this.vista.jTxtNombre.setText("");
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
