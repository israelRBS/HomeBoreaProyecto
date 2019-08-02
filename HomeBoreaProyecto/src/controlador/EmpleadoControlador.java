package controlador;

import dao.AsociadosDao;
import modelo.Asociados;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import vistas.JFrmPrincipal;

public class EmpleadoControlador implements ActionListener{
    AsociadosDao dao=new AsociadosDao();
    Asociados asociado=new Asociados();
    JFrmPrincipal principal=new JFrmPrincipal();
    
    
    @Override
    public void actionPerformed(ActionEvent e) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
