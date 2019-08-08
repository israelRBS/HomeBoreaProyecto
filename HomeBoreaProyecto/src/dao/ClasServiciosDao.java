 package dao;

import modelo.ClasificacionesServicios;
import interfaces.ClasificacionesServiciosInterfaces;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class ClasServiciosDao implements ClasificacionesServiciosInterfaces {

    ConexionBorea cnb = new ConexionBorea();
    ClasificacionesServicios cs = new ClasificacionesServicios();
    private String mensaje;
    private String sql;
    private PreparedStatement ejecutar;
    ResultSet rs;

    @Override
    public ClasificacionesServicios buscarClasificacionesServicios(ClasificacionesServicios clasificacionesServicios) {
        try {
            cnb.abrirConexion();
            sql = "select * from  clasificaciones_servicios where clasificiacion_id=?";
            ejecutar = cnb.getMiConexion().prepareStatement(sql);
            rs = ejecutar.executeQuery();
            while (rs.next()) {
                cs = new ClasificacionesServicios();
                cs.setClasificacion_id(rs.getByte("clasificacion_id"));
                cs.setNombre(rs.getString("nombre"));
                cs.setDescripcion(rs.getString("descripcion"));
            }
            rs.close();

        } catch (SQLException e) {
            System.out.println("ERROR EN CLASIFICACION_SERVICIOS_DAO : " + e);
        } finally {
            cnb.cerrarConexion();
        }
        return cs;
    }

    @Override
    public ArrayList<ClasificacionesServicios> listarClasificaciones() {
        ArrayList<ClasificacionesServicios> lista = new ArrayList();

        try {
            cnb.abrirConexion();
            sql = "select * from clasificaciones_servicios";
            ejecutar = cnb.getMiConexion().prepareStatement(sql);
            rs = ejecutar.executeQuery();
            while (rs.next()) {
                cs = new ClasificacionesServicios();
                cs.setClasificacion_id(rs.getByte("clasificacion_id"));
                cs.setNombre(rs.getString("nombre"));
                cs.setDescripcion(rs.getString("descripcion"));
                lista.add(cs);
            }
            rs.close();

        } catch (SQLException e) {
            System.out.println("ERROR LISTAR_CLASIFICACION_SERVICIOS : " + e);
        } finally {
            cnb.cerrarConexion();
        }
        return lista;
    }

    @Override
    public String eliminarClasificaciones(ClasificacionesServicios clasificacionesServicios) {
        try {
            cnb.abrirConexion();
            sql = "delete from clasificaciones_servicios where clasificacion_id=?";
            ejecutar = cnb.getMiConexion().prepareStatement(sql);
            ejecutar.setByte(1, cs.getClasificacion_id());
            ejecutar.executeUpdate();
            mensaje = "Los datos se eliminaron";
        } catch (SQLException e) {
            mensaje = "Los datos no se pueden eliminar" + e;
        } finally {
            cnb.cerrarConexion();
        }
        return mensaje;
    }

    @Override
    public String agregarClasificaciones(ClasificacionesServicios clasificacionesServicios) {
        try {
            cnb.abrirConexion();
            sql = "insert into clasificaciones_servicios values(?,?,?)";
            ejecutar = cnb.getMiConexion().prepareStatement(sql);
            ejecutar.setByte(1, cs.getClasificacion_id());
            ejecutar.setString(2, cs.getNombre());
            ejecutar.setString(3, cs.getDescripcion());
            ejecutar.executeUpdate();
            mensaje = "Los Datos fueron almacenados";
        } catch (SQLException e) {
            mensaje = "Error almacenando los datos " + e;
        } finally {
            cnb.cerrarConexion();
        }
        return mensaje;
    }

    @Override
    public String modificarCalificaciones(ClasificacionesServicios clasificacionesServicios) {
        try {
            cnb.abrirConexion();
            sql = "update clasificaciones_servicios set nombre=?, descripcion=? where clasificacion_id=?";
            ejecutar = cnb.getMiConexion().prepareStatement(sql);
            ejecutar.setByte(3, cs.getClasificacion_id());
            ejecutar.setString(1, cs.getNombre());
            ejecutar.setString(2, cs.getDescripcion());
            ejecutar.executeUpdate();
            mensaje = "DATO MODIFICACOD";
        } catch (SQLException e) {
            mensaje = "ERROR EN  MODIFICAR DATO " + e;
        } finally {
            cnb.cerrarConexion();
        }
        return mensaje;
    }

}
