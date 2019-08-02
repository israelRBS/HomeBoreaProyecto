package dao;

import modelo.ClasificacionesServicios;
import modelo.Clientes;
import interfaces.ClasificacionesServiciosInterfaces;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

public class ClasServiciosDao implements ClasificacionesServiciosInterfaces {
    ConexionBorea cnb = new ConexionBorea();
    ClasificacionesServicios cs = new ClasificacionesServicios();
    private String mensaje = null;
    private String sql;
    private PreparedStatement ejecutar;
    ResultSet rs;

    @Override
    public ClasificacionesServicios buscarClasificacionesServicios(ClasificacionesServicios clasificacionesServicios) {
        try {
            cnb.abrirConexion();
            sql = "select * from  clasificaciones_servicios";
            ejecutar = cnb.getMiConexion().prepareStatement(sql);
            rs = ejecutar.executeQuery();
            if (rs.next()) {
                cs = new ClasificacionesServicios();
                cs.setClasificacion_id(rs.getByte("clasificacion_id"));
                cs.setNombre(rs.getString("nombre"));
                cs.setDescripcion(rs.getString("descripcion"));
            }
            rs.close();

        } catch (Exception e) {
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
            
        } catch (Exception e) {
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
        } catch (Exception e) {
            mensaje = "Los datos no se pueden eliminar" +e;
        }finally{
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
        } catch (Exception e) {
            mensaje = "Error almacenando los datos "+e ;
        }finally{
            cnb.cerrarConexion();
        }
        return mensaje;
    }

    @Override
    public String modificarCalificaciones(ClasificacionesServicios clasificacionesServicios) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
