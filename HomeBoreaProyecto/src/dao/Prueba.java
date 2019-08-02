/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

/**
 *
 * @author javam2019
 */
public class Prueba {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
    ConexionBorea conexion=new ConexionBorea();
    conexion.abrirConexion();
    conexion.cerrarConexion();
        System.out.println("hola a todos");
    }
    
    
}
