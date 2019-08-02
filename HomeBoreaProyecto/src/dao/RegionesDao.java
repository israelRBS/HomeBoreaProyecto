package dao;

import interfaces.RegionesInterface;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import modelo.Regiones;

public class RegionesDao implements RegionesInterface {

    ConexionBorea conex = new ConexionBorea();
    private String sql;
    private String mensaje;
    PreparedStatement ejecutar;
    ResultSet seleccionar;
    private int contarRegistros = 0;

    @Override
    public Regiones buscarRegiones(Regiones regiones) {
        Regiones region = new Regiones();

        try {
            conex.abrirConexion();
            sql = "SELECT * FROM regiones WHERE region_id=?";
            ejecutar = conex.getMiConexion().prepareStatement(sql);

            seleccionar = ejecutar.executeQuery();

            while (seleccionar.next()) {
                region.setRegion_id(seleccionar.getByte("region_id"));
                region.setNombre(seleccionar.getString("nombre"));
                region.setDescripcion(seleccionar.getString("descripcion"));
            }
            seleccionar.close();

        } catch (SQLException e) {
            System.out.println("ERROR EN BUSCAR_REGION_DAO :" + e);
        } finally {
            conex.cerrarConexion();
        }
        return region;
    }

    @Override
    public ArrayList<Regiones> listarRegiones() {
        Regiones reg;
        ArrayList<Regiones> listar = new ArrayList<>();

        try {
            conex.abrirConexion();
            sql = "select * from regiones";
            ejecutar = conex.getMiConexion().prepareStatement(sql);
            seleccionar = ejecutar.executeQuery();
            while (seleccionar.next()) {
                reg = new Regiones();
                reg.setRegion_id(seleccionar.getByte("region_id"));
                reg.setNombre(seleccionar.getString("nombre"));
                reg.setDescripcion(seleccionar.getString("descripcion"));

                listar.add(reg);
            }
        } catch (SQLException e) {
            System.out.println("ERROR EN LISTAR_REGIONES_DAO " + e);
        } finally {
            conex.cerrarConexion();
        }
        return listar;

    }

    @Override
    public String eliminarRegiones(Regiones regiones) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public String insertarRegiones(Regiones regiones) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public String modificarRegiones(Regiones regiones) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}
