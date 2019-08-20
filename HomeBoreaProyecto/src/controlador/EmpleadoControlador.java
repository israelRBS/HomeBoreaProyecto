package controlador;

import dao.EmpleadosDao;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import modelo.Empleados;
import vistas.VistaEmpleados;

public class EmpleadoControlador implements ActionListener, MouseListener {

    /* INSTANCIA DE LA CLASE DAO PARA CONSULTAS PREPARDAS */
    Empleados empleado = new Empleados();
    /* INSTANCIA DE LA CLASE MODELO DE LA TABLA */
    EmpleadosDao dao = new EmpleadosDao();
    /* INSTANCIA DE LA VISTA PARA UTILIZAR LOS OBJETOS PUBLICOS */
    VistaEmpleados vista;
    /* PROPIEDADA DE CLASE */
    private String mensaje;

    /* CONSTRUCTOR PARA INICIALIZAR LOS OBJETOS */
    public EmpleadoControlador(VistaEmpleados vista) {
        this.vista = vista;
        this.vista.jBtnBuscar.addActionListener(this);
        this.vista.jBtnEliminar.addActionListener(this);
        this.vista.jBtnGuardar.addActionListener(this);
        this.vista.jBtnModificar.addActionListener(this);
        this.vista.jTblEmpleados.addMouseListener(this);
        cleanPictures();
        listarEmpleados();
    }

    /* METODO QUE NOS PERMETIRA GUARDAR LOS DATOS A TRAVES DE LOS IMPUTS*/
    public void guardarEmpleado() {
        empleado.setEmpleado_id(Integer.parseInt(this.vista.jTxtEmpleado.getText()));
        empleado.setUsuario(this.vista.jTxtUsuario.getText());
        empleado.setContraseña(String.valueOf(this.vista.jTxtContra.getPassword()));
        empleado.setTipoempleado_id(Integer.parseInt(this.vista.jTxtTipoEmpleado.getText()));
        mensaje = dao.insertarEmpleado(empleado);
        JOptionPane.showMessageDialog(vista, mensaje);
        cleanPictures();
        listarEmpleados();
    }

    /* METODO QUE NOS PERMITIRA MODIFICAR DATOS DE LA BASE DE DATOS A TRAVES DE LOS IMPUTS */
    public void modificarEmpleado() {
        empleado.setEmpleado_id(Integer.parseInt(this.vista.jTxtEmpleado.getText()));
        empleado.setUsuario(this.vista.jTxtUsuario.getText());
        empleado.setContraseña(String.valueOf(this.vista.jTxtContra.getPassword()));
        empleado.setTipoempleado_id(Integer.parseInt(this.vista.jTxtTipoEmpleado.getText()));
        mensaje = dao.modificarEmpleado(empleado);
        JOptionPane.showMessageDialog(vista, mensaje);
        cleanPictures();
        listarEmpleados();
    }

    /* METODO QUE NOS PERMITRA ELIMINAR REGISTROS */
    public void eliminarEmpleado() {
        empleado.setEmpleado_id(Integer.parseInt(this.vista.jTxtEmpleado.getText()));
        mensaje = dao.eliminarEmpleados(empleado);
        JOptionPane.showMessageDialog(vista, mensaje);
        cleanPictures();
        listarEmpleados();
    }

    /* METODO QUE NOS PERMITRA BUSCAR EMPLEADOS */
    public void buscarEmpleados() {
        String usuario  = this.vista.jTxtUsuario.getText();
        String contra = (String.valueOf(this.vista.jTxtContra.getPassword()));
        empleado = dao.buscarEmpleados(usuario, contra);
    }

    /* METODO PARA MOSTRAR LOS DATOS DE LA TABLA */
    public void mostrarDatos(){
        ArrayList<Empleados> listar = dao.listarEmpleados();
        DefaultTableModel modelo = (DefaultTableModel) vista.jTblEmpleados.getModel();
        Object[] fila = new Object[modelo.getColumnCount()];
        for (int i = 0; i < listar.size(); i++) {
            fila[0] = listar.get(i).getEmpleado_id();
            fila[1] = listar.get(i).getUsuario();
            fila[2] = listar.get(i).getContraseña();
            fila[3] = listar.get(i).getTipoempleado_id();
            modelo.addRow(fila);
        }     
    }
    
    /* METODO PARA OBTENER LOS DATOS DE LA TABLA */
    public void obtenerDatosTabla(){
        this.vista.jTxtEmpleado.setText(String.valueOf(this.vista.jTblEmpleados.getValueAt(this.vista.jTblEmpleados.getSelectedRow(), 0)));
        this.vista.jTxtUsuario.setText(String.valueOf(this.vista.jTblEmpleados.getValueAt(this.vista.jTblEmpleados.getSelectedRow(), 1)));
        this.vista.jTxtContra.setText(String.valueOf(this.vista.jTblEmpleados.getValueAt(this.vista.jTblEmpleados.getSelectedRow(), 2)));
        this.vista.jTxtTipoEmpleado.setText(String.valueOf(this.vista.jTblEmpleados.getValueAt(this.vista.jTblEmpleados.getSelectedRow(), 3)));
    }
    
    /* METODO PARA LISTAR TODOS LOS DATOS DE EMPLEADOS */
    public void listarEmpleados(){
        String[] titulos ={"NO.EMPLEADO","USUARIO","CONTRASEÑA","NO.TIPO_EMPLEADO",""};
        DefaultTableModel modelo = new DefaultTableModel(titulos, 0);
        Object[] columnas = new Object[4];
        for (Empleados trabajador : dao.listarEmpleados()) {
            columnas[0]=trabajador.getEmpleado_id();
            columnas[1]=trabajador.getUsuario();
            columnas[2]=trabajador.getContraseña();
            columnas[3]=trabajador.getTipoempleado_id(); 
            modelo.addRow(columnas);
        }
            this.vista.jTblEmpleados.setModel(modelo);
    }
    
    
    /* METODO QUE NOS PERMITIRA LIMPIAR LOS CUADROS DE TEXTO */
    public void cleanPictures(){
        this.vista.jTxtEmpleado.setText("");
        this.vista.jTxtUsuario.setText("");
        this.vista.jTxtContra.setText("");
        this.vista.jTxtTipoEmpleado.setText("");
    }
    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == this.vista.jBtnGuardar) {
            guardarEmpleado();
        }
        if (e.getSource() == this.vista.jBtnModificar) {
            modificarEmpleado();
        }
        if (e.getSource() == this.vista.jBtnEliminar) {
            eliminarEmpleado();
        }
        if (e.getSource() == this.vista.jBtnBuscar){
            buscarEmpleados();
        }
    }

    @Override
    public void mouseClicked(MouseEvent e) {
         if (e.getSource() == this.vista.jTblEmpleados){
             obtenerDatosTabla();
         }
    }

    @Override
    public void mousePressed(MouseEvent e) {
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void mouseReleased(MouseEvent e) {
       // throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void mouseEntered(MouseEvent e) {
       // throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void mouseExited(MouseEvent e) {
       // throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}
