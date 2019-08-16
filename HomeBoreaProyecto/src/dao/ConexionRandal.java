/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 *
 * @author javam2019
 */
public class ConexionRandal {
      //atributos
    private Connection miConexion;
    private static final String URL = "jdbc:mysql://localhost:3306/java19_borea";
    //jdbc:mysql://localhost:3306/java19_cuentahabientes
    private static final String PASSWORD = "";
    private static final String USER = "root";

    public Connection getMiConexion() {
        return miConexion;
    }

    public void setMiConexion(Connection miConexion) {
        this.miConexion = miConexion;
    }

    public void abrirConexion() {
        try {
            String mensaje="Si conecto";
            Class.forName("com.mysql.jdbc.Driver");
            miConexion = DriverManager.getConnection(URL, USER, PASSWORD);
        } catch (ClassNotFoundException | SQLException ex) {
            System.out.println("Error en conexion: " + ex);
        }
    }

    public void cerrarConexion() {
        if (miConexion != null) {
            try {
                if (miConexion.isClosed() == false) {
                    miConexion.close();
                    System.out.println("Conexion cerrada");
                }
            }catch (SQLException ex) {
                System.out.println("No se puede cerrar la conexion"+ex);
            }
            }
        }
}
