/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador;

import dao.EmpleadosDao;
import modelo.Empleados;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JOptionPane;
import vistas.JFrmPrincipal;
import vistas.Login;

/**
 *
 * @author Admin
 */
public class LoginControlador implements ActionListener{
    Login login = new Login();
    EmpleadosDao empleadosDao = new EmpleadosDao();
    
    //Empleados empleados = new Empleados();
    public LoginControlador(Login login) {
        this.login = login;
        login.jBtnEntrar.addActionListener(this);
    }

    @Override
    public void actionPerformed(ActionEvent ae) {
        if (ae.getSource() == this.login.jBtnEntrar) {
            buscarEmpleado();
        }
    }
    public void buscarEmpleado(){
        
        String usuario = this.login.jTxtUsuario.getText();
        String contrasenia = new String( this.login.jTxtContrasenia.getPassword());
        JOptionPane.showMessageDialog(null,usuario+","+contrasenia);
        ObjetosPublicos.empleado = empleadosDao.buscarEmpleados(usuario, contrasenia);
        
        JFrmPrincipal principal=new JFrmPrincipal();
        PrincipalControlador principalcontrolador =new PrincipalControlador(principal);
        principal.setExtendedState(6);
        principal.setVisible(true);
    }
    
}
