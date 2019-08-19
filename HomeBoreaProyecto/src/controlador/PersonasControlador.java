package controlador;

import dao.ConexionBorea;
import dao.PersonaDao;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import modelo.Personas;
import vistas.JFrmPersonas;

public class PersonasControlador implements ActionListener, MouseListener {

    /* INSTANCIANDO LA CLASE PARA ESTABLECER LA CONEXION A LA BASE_DE_DATOS */
    ConexionBorea cnb = new ConexionBorea();
    /* INSTANCIANDO EL DAO PARA LAS CONSULTAS PREPARADAS DE MYSQL */
    PersonaDao dao = new PersonaDao();
    /* INSTANCIANDO EL MODELO DE LA TABLA */
    Personas modelo = new Personas();
    /* ISTANCIANDO LA VISTA PARA OBTENER LOS OBJETOS PUBLICOS */
    JFrmPersonas vista = new JFrmPersonas();
    /* ATRIBUTO DE CLASE S*/
    private String mensaje;

    /* CONSTRUCTOR PARA INICIALIZAR LOS OBJETOS */
    public PersonasControlador(JFrmPersonas vista) {
        this.vista = vista;
        this.vista.jBtnBuscar.addActionListener(this);
        this.vista.jBtnEliminar.addActionListener(this);
        this.vista.jBtnGuardar.addActionListener(this);
        this.vista.jBtnModificar.addActionListener(this);
        this.vista.jTbTabla.addMouseListener(this);
        cleanPictures();
        listarPersonas();
    }

    /* METODO PARA GUARDAR PERSONAS EN LA BASE_DE_DATOS */
    public void guardarPersonas() {
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
        cleanPictures();
        listarPersonas();
    }

    /* METODO PARA ELIMINAR PERSONAS EN LA BASE_DE_DATOS */
    public void eliminarPersonas() {
        modelo.setPersona_id(Integer.parseInt(this.vista.jTxtPersonaId.getText()));
        mensaje = dao.eliminarPersonas(0);
        JOptionPane.showMessageDialog(vista, mensaje);
        listarPersonas();
    }

    /* METODO PARA BUSCAR PERSONAS EN LA BASE_DE_DATOS */
    public void buscarPersona() {
        int codigo = Integer.parseInt(this.vista.jTxtPersonaId.getText());
        modelo = dao.buscarPersonas(codigo);
        cleanPictures();
        listarPersonas();
    }

    /* METODO PARA MODIFCAR  PERSONAS EN LA BASE_DE_DATOS */
    public void modificarPersona() {
        modelo.setPersona_id(Integer.parseInt(this.vista.jTxtPersonaId.getText()));
        modelo.setNombre(this.vista.jTxtNombre.getText());
        modelo.setApellido(this.vista.jTxtApellido.getText());
        modelo.setCorreo(this.vista.jTxtCorreo.getText());
        modelo.setDireccion(this.vista.jTxtDireccion.getText());
        modelo.setDpi(Long.parseLong(this.vista.jTxtDpi.getText()));
        modelo.setTelefono(Integer.parseInt(this.vista.jTxtTelefono.getText()));
        modelo.setEstado_id(Integer.parseInt(this.vista.jTxtEstado.getText()));
        modelo.setGenero_id(Integer.parseInt(this.vista.jTxtGenero.getText()));
        mensaje = dao.modificarPersonas(modelo);
        JOptionPane.showMessageDialog(vista, mensaje);
        cleanPictures();
        listarPersonas();
    }

    /* METODO PARA LIMPIAR LOS IMPUTS */
    public void cleanPictures() {
        this.vista.jTxtPersonaId.setText("");
        this.vista.jTxtNombre.setText("");
        this.vista.jTxtApellido.setText("");
        this.vista.jTxtCorreo.setText("");
        this.vista.jTxtDireccion.setText("");
        this.vista.jTxtDpi.setText("");
        this.vista.jTxtTelefono.setText("");
        this.vista.jTxtEstado.setText("");
        this.vista.jTxtGenero.setText("");
    }

    /* METODO PARA MOSTRAR DATOS */
    public void mostrarDatos() {
        ArrayList<Personas> lista = dao.listarPersonas();
        DefaultTableModel modelo = (DefaultTableModel) vista.jTbTabla.getModel();
        Object[] fila = new Object[modelo.getColumnCount()];
        for (int i = 0; i < lista.size(); i++) {
            fila[0] = lista.get(i).getPersona_id();
            fila[1] = lista.get(i).getNombre();
            fila[2] = lista.get(i).getApellido();
            fila[3] = lista.get(i).getCorreo();
            fila[4] = lista.get(i).getDireccion();
            fila[5] = lista.get(i).getDpi();
            fila[6] = lista.get(i).getTelefono();
            fila[7] = lista.get(i).getEstado_id();
            fila[8] = lista.get(i).getGenero_id();
            modelo.addRow(fila);
        }
    }

    /* METODO PARA OBTENER DATOS DE LA TABLA */
    public void obtenerDatosTabla() {
        this.vista.jTxtPersonaId.setText(String.valueOf(this.vista.jTbTabla.getValueAt(this.vista.jTbTabla.getSelectedRow(), 0)));
        this.vista.jTxtNombre.setText(String.valueOf(this.vista.jTbTabla.getValueAt(this.vista.jTbTabla.getSelectedRow(), 1)));
        this.vista.jTxtApellido.setText(String.valueOf(this.vista.jTbTabla.getValueAt(this.vista.jTbTabla.getSelectedRow(), 2)));
        this.vista.jTxtCorreo.setText(String.valueOf(this.vista.jTbTabla.getValueAt(this.vista.jTbTabla.getSelectedRow(), 3)));
        this.vista.jTxtDireccion.setText(String.valueOf(this.vista.jTbTabla.getValueAt(this.vista.jTbTabla.getSelectedRow(), 4)));
        this.vista.jTxtDpi.setText(String.valueOf(this.vista.jTbTabla.getValueAt(this.vista.jTbTabla.getSelectedRow(), 5)));
        this.vista.jTxtTelefono.setText(String.valueOf(this.vista.jTbTabla.getValueAt(this.vista.jTbTabla.getSelectedRow(), 6)));
        this.vista.jTxtEstado.setText(String.valueOf(this.vista.jTbTabla.getValueAt(this.vista.jTbTabla.getSelectedRow(), 7)));
        this.vista.jTxtGenero.setText(String.valueOf(this.vista.jTbTabla.getValueAt(this.vista.jTbTabla.getSelectedRow(), 8)));
    }

    /* METODO PARA LISTAR TODOS LOS  DATOS DE LA TABLA */
    public void listarPersonas() {
        String[] cabecera = {"NO.Pesona", "Nombre", "Apellido", "Correo", "Direccion", "DPI", "Telefono", "Estado", "Genero"};
        DefaultTableModel model = new DefaultTableModel(cabecera, 0);
        Object[] columnas = new Object[8];
        for (Personas persona : dao.listarPersonas()) {
            columnas[0] = persona.getPersona_id();
            columnas[1] = persona.getNombre();
            columnas[2] = persona.getApellido();
            columnas[3] = persona.getCorreo();
            columnas[4] = persona.getDireccion();
            columnas[5] = persona.getDpi();
            columnas[6] = persona.getTelefono();
            columnas[7] = persona.getEstado_id();
            columnas[8] = persona.getGenero_id();
            model.addRow(columnas);
        }
            this.vista.jTbTabla.setModel(model);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == this.vista.jBtnGuardar) {
            guardarPersonas();
        }
        if (e.getSource() == this.vista.jBtnEliminar) {
            eliminarPersonas();
        }
        if (e.getSource() == this.vista.jBtnBuscar) {
            buscarPersona();
        }
        if (e.getSource() == this.vista.jBtnModificar) {
            modificarPersona();
        }
    }

    @Override
    public void mouseClicked(MouseEvent e) {
         if (e.getSource() == this.vista.jTbTabla){
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
