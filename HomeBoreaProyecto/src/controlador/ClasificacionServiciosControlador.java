package controlador;

import dao.ClasServiciosDao;
import dao.ConexionBorea;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JOptionPane;
import modelo.ClasificacionesServicios;
import vistas.JFrmClasificacionServicios;

public class ClasificacionServiciosControlador implements ActionListener{
    ClasificacionesServicios modelo = new ClasificacionesServicios();
    ClasServiciosDao dao = new ClasServiciosDao();
    ConexionBorea conexion = new ConexionBorea();
    JFrmClasificacionServicios vista = new JFrmClasificacionServicios();
    private String mensaje = null;

    public ClasificacionServiciosControlador(JFrmClasificacionServicios vista) {
        this.vista = vista;
        this.vista.jBtnBuscar.addActionListener(this);
        this.vista.jBtnEliminar.addActionListener(this);
        this.vista.jBtnGuardar.addActionListener(this);
        this.vista.jBtnModificar.addActionListener(this);
    }
    
    public void guardarClaServicios(){
        modelo.setClasificacion_id(Byte.parseByte(this.vista.jTxtClasificacionId.getText()));
        modelo.setNombre(this.vista.jTxtNombre.getText());
        modelo.setDescripcion(this.vista.jTxtDescripcion.getText());
        mensaje = dao.agregarClasificaciones(modelo);
        JOptionPane.showMessageDialog(vista, mensaje);
        
        
    }
    
    
    
    

    @Override
    public void actionPerformed(ActionEvent ae) {
        if (ae.getSource()== this.vista.jBtnGuardar) {
            guardarClaServicios();
           
            
            
        }
    }
    
}
