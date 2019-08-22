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
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import javax.swing.JOptionPane;
import vistas.JFrmPrincipal;
import vistas.Login;

/**
 *
 * @author Admin
 */
public class LoginControlador implements ActionListener, KeyListener {

    Login login = new Login();
    EmpleadosDao empleadosDao = new EmpleadosDao();

    //Empleados empleados = new Empleados();
    public LoginControlador(Login login) {
        this.login = login;
        login.jBtnEntrar.addActionListener(this);
        login.jBtnEntrar.addKeyListener(this);
        login.jTxtContrasenia.addKeyListener(this);
        login.jTxtUsuario.addKeyListener(this);
    }

    @Override
    public void actionPerformed(ActionEvent ae) {
        if (ae.getSource() == this.login.jBtnEntrar) {
            buscarEmpleado();
        }
    }

    public void buscarEmpleado() {

        String usuario = this.login.jTxtUsuario.getText();
        String contrasenia = new String(this.login.jTxtContrasenia.getPassword());
        //JOptionPane.showMessageDialog(null, usuario + "," + contrasenia);
        ObjetosPublicos.empleado = empleadosDao.buscarEmpleados(usuario, contrasenia);

        if (ObjetosPublicos.empleado.getUsuario() == null && ObjetosPublicos.empleado.getContraseña() == null) {
            JOptionPane.showMessageDialog(null, "Datos Incorrectos");
            this.login.jTxtUsuario.setText(null);
            this.login.jTxtContrasenia.setText(null);
            this.login.jTxtUsuario.requestFocus();
        } else {
            JFrmPrincipal principal = new JFrmPrincipal();
            PrincipalControlador principalcontrolador = new PrincipalControlador(principal);
            principal.setExtendedState(6);
            this.login.setVisible(false);
            principal.setVisible(true);
        }

    }

    public void asignarFoco() {
        //
    }

    @Override
    public void keyTyped(KeyEvent e) {
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        
    }

    @Override
    public void keyPressed(KeyEvent e) {
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        if (e.getSource() == this.login.jTxtUsuario) {
            if (e.getKeyCode() == KeyEvent.VK_ENTER) {
                this.login.jTxtContrasenia.requestFocus();
            }
        }

        if (e.getSource() == this.login.jTxtContrasenia) {
            if (e.getKeyCode() == KeyEvent.VK_ENTER) {
                this.login.jBtnEntrar.doClick();
            }
        }
    }

    @Override
    public void keyReleased(KeyEvent e) {
        //
    }

}
