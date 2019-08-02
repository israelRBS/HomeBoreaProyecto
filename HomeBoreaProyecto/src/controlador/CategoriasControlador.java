/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador;

import dao.CategoriasDao;
import modelo.Categorias;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import vistas.VistaCategorias;

/**
 *
 * @EDWIN ESTUARDO LEZANA RAXÓN     °°°°° (*_*) °°°°°
 */
public class CategoriasControlador implements ActionListener, MouseListener{
    
    VistaCategorias vista;
    CategoriasDao dao = new CategoriasDao();
    Categorias categoria = new Categorias();
    String mensaje;
    /*MODIFICICACION*/
    
    public CategoriasControlador(VistaCategorias vista){
        this.vista = vista;
        this.vista.jBtnBuscarCate.addActionListener(this);
        this.vista.jBtnModificarCate.addActionListener(this);
        this.vista.jBtnEliminarCate.addActionListener(this);
        listarCategorias();
        this.vista.jTblListaCategorias.addMouseListener(this);
        this.vista.jBtnGuardarCate.addActionListener(this);
        
    }
    public void guardarCategoria(){
        
        categoria.setCategoria_id((byte) Integer.parseInt(this.vista.jTxtCategoria.getText()));
        categoria.setNombre(this.vista.jTxtNombre.getText());
        categoria.setEmpleado_id(Integer.parseInt(this.vista.jTxtEmpleado.getText()));
        mensaje= dao.guardarCategoria(categoria);
        JOptionPane.showMessageDialog(vista, mensaje);
        limpiarImputs();
        listarCategorias();
    }
    public void eliminarCategoria(){
        
        categoria.setCategoria_id((byte) Integer.parseInt(this.vista.jTxtCategoria.getText()));
        mensaje = dao.eliminarCategoria(categoria);
        JOptionPane.showMessageDialog(vista, mensaje);
        limpiarImputs();
        listarCategorias();
        
    }
    public void modificarCategoria(){
        
        categoria.setCategoria_id((byte) Integer.parseInt(this.vista.jTxtCategoria.getText()));
        categoria.setNombre(this.vista.jTxtNombre.getText());
        categoria.setEmpleado_id(Integer.parseInt(this.vista.jTxtEmpleado.getText()));
        mensaje = dao.updateCategoria(categoria);
        JOptionPane.showMessageDialog(vista, mensaje);
        limpiarImputs(); 
        listarCategorias();
    }
    public void buscarCategoria(){
        
        int codigo = Byte.parseByte(this.vista.jTxtCategoria.getText());
        categoria = dao.buscarCategorias(codigo);
        this.vista.jTxtNombre.setEnabled(false);
        this.vista.jTxtEmpleado.setEnabled(false);
       
    }
    public void mostrar(){
        ArrayList<Categorias> lista = dao.listarCategorias();
        
        DefaultTableModel modelo = (DefaultTableModel) vista.jTblListaCategorias.getModel();
        Object[] fila = new Object[modelo.getColumnCount()];
        for (int i = 0; i <lista.size(); i++) {
            fila[0] = lista.get(i).getCategoria_id();
            fila[1] = lista.get(i).getNombre();
            fila[2] = lista.get(i).getEmpleado_id();
            modelo.addRow(fila);
        }
        
    }
    public void obtenerDatosTabla(){
        this.vista.jTxtCategoria.setText(String.valueOf(this.vista.jTblListaCategorias.getValueAt(this.vista.jTblListaCategorias.getSelectedRow(), 0)));
        this.vista.jTxtNombre.setText(String.valueOf(this.vista.jTblListaCategorias.getValueAt(this.vista.jTblListaCategorias.getSelectedRow(), 1)));
        this.vista.jTxtEmpleado.setText(String.valueOf(this.vista.jTblListaCategorias.getValueAt(this.vista.jTblListaCategorias.getSelectedRow(), 2)));
    }
    public void listarCategorias(){
        String[] cabecera={"CATEGORIA_ID","NOMBRE_CATEGORIA","EMPLEADO_ID"};
        DefaultTableModel model = new DefaultTableModel(cabecera, 0);
        Object[] columnas = new Object[3];
        for (Categorias  cate : dao.listarCategorias()) {
            columnas[0] = cate.getCategoria_id();
            columnas[1] = cate.getNombre();
            columnas[2] = cate.getEmpleado_id();
            
            model.addRow(columnas);
        }
        this.vista.jTblListaCategorias.setModel(model);
    }
    
    public void limpiarImputs(){
        this.vista.jTxtCategoria.setText("");
        this.vista.jTxtNombre.setText("");
        this.vista.jTxtEmpleado.setText("");
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource()==this.vista.jBtnGuardarCate){
            guardarCategoria();
        }
        if(e.getSource()==this.vista.jBtnModificarCate){
            modificarCategoria();
        }
        if(e.getSource()==this.vista.jBtnEliminarCate){
            eliminarCategoria();
        }
        if(e.getSource()==this.vista.jBtnBuscarCate){
            buscarCategoria();
        }
    }

    @Override
    public void mouseClicked(MouseEvent e) {
        if(e.getSource() == this.vista.jTblListaCategorias){
            obtenerDatosTabla();
        }
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
