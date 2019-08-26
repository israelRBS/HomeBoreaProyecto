package dao;

import interfaces.RegionesInterface;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import modelo.Regiones;

public class RegionesDao implements RegionesInterface {

    ConexionRandal conex = new ConexionRandal();
    private String sql;
    private String mensaje;
    PreparedStatement ejecutar;
    ResultSet seleccionar;
    private int contarRegistros = 0;

    @Override
    public Regiones buscarRegiones(int regiones) {
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
        try {
            conex.abrirConexion();
            sql = "DELETE FROM regiones where region_id=?";
            ejecutar = conex.getMiConexion().prepareStatement(sql);

            ejecutar.setByte(1, regiones.getRegion_id());

            contarRegistros = ejecutar.executeUpdate();

            if (contarRegistros == 0) {
                mensaje = "NO SE ENCONTRO EL REGISTRO";
            } else {
                mensaje = "REGION ELIMINADA";
            }
        } catch (SQLException e) {
            mensaje = "ERROR EN ELIMINAR_REGION_DAO " + e;
        } finally {
            conex.cerrarConexion();
        }
        return mensaje;
    }

    @Override
    public String insertarRegiones(Regiones regiones) {
        try {
            conex.abrirConexion();
            sql = "INSERT INTO regiones values(?,?,?)";
            ejecutar = conex.getMiConexion().prepareStatement(sql);

            ejecutar.setByte(1, regiones.getRegion_id());
            ejecutar.setString(2, regiones.getNombre());
            ejecutar.setString(3, regiones.getDescripcion());

            contarRegistros = ejecutar.executeUpdate();

            if (contarRegistros == 0) {
                mensaje = "NO SE ENCONTRO LA BASE DE DATOS";
            } else {
                mensaje = "REGION GUARDADA";
            }

        } catch (SQLException e) {
            mensaje = "ERROR EN DAO_INSERTAR_REGION " + e;

        } finally {
            conex.cerrarConexion();
        }
        return mensaje;
    }

    @Override
    public String modificarRegiones(Regiones regiones) {
        try {
            conex.abrirConexion();
            sql = "update regiones set nombre=?, descripcion=? where region_id=?";
            ejecutar = conex.getMiConexion().prepareStatement(sql);

            ejecutar.setByte(3, regiones.getRegion_id());
            ejecutar.setString(1, regiones.getNombre());
            ejecutar.setString(2, regiones.getDescripcion());

            contarRegistros = ejecutar.executeUpdate();

            if (contarRegistros == 0) {
                mensaje = "NO SE ENCONTRO EL REGISTRO";
            } else {
                mensaje = "REGION MODIFICADA";
            }
        } catch (SQLException e) {
            mensaje="ERROR EN MOFICAR_REGION_DAO "+e;
        } finally {
            conex.cerrarConexion();
        }
        return mensaje;
    }

}
