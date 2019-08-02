package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConexionBorea {

    //atributos
    private Connection miConexion;
    private static final String URL = "jdbc:mysql://10.12.48.157:3306/java19_borea";
    private static final String PASSWORD = "123456";
    private static final String USER = "adminborea";

    public Connection getMiConexion() {
        return miConexion;
    }

    public void setMiConexion(Connection miConexion) {
        this.miConexion = miConexion;
    }

    public void abrirConexion() {
        try {
            
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