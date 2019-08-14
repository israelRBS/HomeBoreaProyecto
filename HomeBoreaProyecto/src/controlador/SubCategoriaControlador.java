/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador;

import dao.SubcategoriaDao;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.ArrayList;
import javax.swing.DefaultComboBoxModel;
import modelo.Subcategorias;
import vistas.VistaSubCategorias;

/**
 *
 * @author Admin
 */
public class SubCategoriaControlador implements ActionListener, MouseListener {
    VistaSubCategorias vista;
    //obtener todas las categorias existentes
    ArrayList<Subcategorias> listaCategoria = new ArrayList<Subcategorias>();
    SubcategoriaDao daoSubCategoria=new SubcategoriaDao();
    DefaultComboBoxModel cmbCategoriaModel = new DefaultComboBoxModel();
    
    public SubCategoriaControlador(VistaSubCategorias vista) {
        this.vista = vista;
        cargarCmbCategoria();
    }
    public void cargarCmbCategoria(){
        try {
            listaCategoria = daoSubCategoria.listarSubcategorias();
            for (Subcategorias subcategorias : listaCategoria) {
                cmbCategoriaModel.addElement(subcategorias.getNombre());
            }
            this.vista.jCmbCategoria.setModel(cmbCategoriaModel);
            cmbCategoriaModel.removeAllElements();
            
           
        } catch (Exception e) {
            System.out.println("Error: " + e);
        }
        
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        
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
    
}
