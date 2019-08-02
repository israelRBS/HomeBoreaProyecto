/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vistas;

import controlador.CategoriasControlador;
import java.awt.Color;

/**
 *
 * @author Admin
 */
public class EjecutarCategoria {
    
    public static void main(String[] args) {
        
        VistaCategorias execute = new VistaCategorias();
        
        CategoriasControlador control = new CategoriasControlador(execute);
        
       execute.setVisible(true);
       execute.getContentPane().setBackground(Color.white);
       //execute.setLocationRelativeTo(null);
       execute.setSize(850, 800);
            
    
    }
    
}
