package controlador;

import dao.ConexionBorea;
import dao.PersonaDao;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JOptionPane;
import modelo.Personas;
import vistas.JFrmPersonas;

public class PersonasControlador implements ActionListener{
    ConexionBorea cnb = new ConexionBorea();
    PersonaDao dao = new PersonaDao();
    Personas modelo = new Personas();
    JFrmPersonas vista = new JFrmPersonas();
    private String mensaje;
    
    public PersonasControlador(JFrmPersonas vista) {
        this.vista = vista;
        this.vista.jBtnBuscar.addActionListener(this);
        this.vista.jBtnEliminar.addActionListener(this);
        this.vista.jBtnGuardar.addActionListener(this);
        this.vista.jBtnModificar.addActionListener(this);
    }
    
    public void guardarPersonas(){
        modelo.setPersona_id(Integer.parseInt(this.vista.jTxtPersonaId.getText()));
        modelo.setNombre(this.vista.jTxtNombre.getText());
        modelo.setApellido(this.vista.jTxtApellido.getText());
        modelo.setCorreo(this.vista.jTxtCorreo.getText());
        modelo.setDireccion(this.vista.jTxtDireccion.getText());
        modelo.setDpi(Long.parseLong(this.vista.jTxtDpi.getText()));
        modelo.setTelefono(Integer.parseInt(this.vista.jTxtTelefono.getText()));
        modelo.setEstado_id(Integer.parseInt(this.vista.jTxtEstado.getText()));
        modelo.setGenero_id(Integer.parseInt(this.vista.jTxtGenero.getText()));
        mensaje = dao.insertarPersonas(modelo);
        JOptionPane.showMessageDialog(vista, mensaje);
    }
    
    public void eliminarPersonas(){
        modelo.setPersona_id(Integer.parseInt(this.vista.jTxtPersonaId.getText()));
        mensaje = dao.eliminarPersonas(0);
        JOptionPane.showMessageDialog(vista, mensaje);
    }
    
    

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource()==this.vista.jBtnGuardar) {
            guardarPersonas();
        }
        if (e.getSource()== this.vista.jBtnEliminar) {
            eliminarPersonas();
        }
    }
    
}
