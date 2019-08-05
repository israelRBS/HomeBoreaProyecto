/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vistas;

import controlador.LoginControlador;

/**
 *
 * @author javam2019
 */
public class ejecutable {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
       Login login=new Login();
       LoginControlador logincontrolador=new LoginControlador(login);
       login.setLocationRelativeTo(null);
       login.setVisible(true);
       
    }
    
}
