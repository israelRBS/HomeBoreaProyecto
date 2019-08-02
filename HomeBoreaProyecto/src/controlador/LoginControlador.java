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
import vistas.Login;

/**
 *
 * @author Admin
 */
public class LoginControlador implements ActionListener{
    Login login = new Login();
    EmpleadosDao empleadosDao = new EmpleadosDao();
    Empleados empleados = new Empleados();
    public LoginControlador(Login login) {
        this.login = login;
        login.jButton2.addActionListener(this);
    }

    @Override
    public void actionPerformed(ActionEvent ae) {
        if (ae.getSource() == this.login.jButton2) {
            
        }
    }
    public void buscarEmpleado(){
        String usuario = this.login.jTextField1.getText();
        String contraseña = this.login.jTextField2.getText();
        empleados = empleadosDao.buscarEmpleados(usuario, contraseña);
    }
    
}
