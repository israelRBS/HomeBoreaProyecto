package dao;

import modelo.ClasificacionesServicios;
import modelo.Departamentos;
import interfaces.DepartamentosInterface;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class DepartamentosDao implements DepartamentosInterface {
    ConexionBorea cnb = new ConexionBorea();
    Departamentos dp = new Departamentos();
    private String mensaje = null;
    PreparedStatement ejecutar;
    ResultSet rs;
    private String sql;
    

    @Override
    public Departamentos buscarDepartamentos(Departamentos departamentos) {
        try {
            cnb.abrirConexion();
            sql = "select * from  departamentos";
            ejecutar = cnb.getMiConexion().prepareStatement(sql);
            rs = ejecutar.executeQuery();
            if (rs.next()) {
                dp = new Departamentos();
                dp.setDepa_id(rs.getByte("departamento_id"));
                dp.setNombre(rs.getString("nombre"));
                dp.setRegion_id(rs.getByte("region_id"));
            }
            rs.close();

        } catch (SQLException e) {
            System.out.println("ERROR EN BUSCAR_DEPARTAMENTO"+e);
        } finally {
            cnb.cerrarConexion();
        }
        return dp;
    
    }

    @Override
    public ArrayList<Departamentos> listarDepartamentos() {
        ArrayList<Departamentos> lista = new ArrayList();
        
        try {
            cnb.abrirConexion();
            sql = "select * from departamentos";
            ejecutar = cnb.getMiConexion().prepareStatement(sql);
            rs = ejecutar.executeQuery();
            while (rs.next()) {
                dp = new Departamentos();
                dp.setDepa_id(rs.getByte("departamento_id"));
                dp.setNombre(rs.getString("nombre"));
                dp.setRegion_id(rs.getByte("region_id"));
                lista.add(dp);
            }
            rs.close();
            
        } catch (SQLException e) {
            System.out.println("ERROR EN LISTAR_DEPARTEMENTOS"+e);
        } finally {
            cnb.cerrarConexion();
        }
        return lista;
    }

    @Override
    public String eliminarDepartamentos(Departamentos departamentos) {
        try {
            cnb.abrirConexion();
            sql = "delete from departamentos where departamento_id=?";
            ejecutar = cnb.getMiConexion().prepareStatement(sql);
            ejecutar.setByte(1, dp.getDepa_id());
            ejecutar.executeUpdate();
            mensaje = "Los datos se eliminaron";
        } catch (SQLException e) {
            mensaje = "Los datos no se pueden eliminar" +e;
        }finally{
            cnb.cerrarConexion();
        }
        return mensaje;
    }

    @Override
    public String agregarDepartamentos(Departamentos departamentos) {
        try {
            cnb.abrirConexion();
            sql = "insert into departamentos values(?,?,?)";
            ejecutar = cnb.getMiConexion().prepareStatement(sql);
            ejecutar.setByte(1, dp.getDepa_id());
            ejecutar.setString(2, dp.getNombre());
            ejecutar.setByte(3, dp.getRegion_id());
            ejecutar.executeUpdate();
            mensaje = "Los Datos fueron almacenados";
        } catch (SQLException e) {
            mensaje = "Error almacenando los datos "+e ;
        }finally{
            cnb.cerrarConexion();
        }
        return mensaje;
    }

    @Override
    public String modificarDepartamentos(Departamentos departamentos)  {
            try {
            cnb.abrirConexion();
            sql = "update departamentos set nombre=?, region_id=? where departamento_id=?s";
            ejecutar = cnb.getMiConexion().prepareStatement(sql);
            ejecutar.setByte(3, dp.getDepa_id());
            ejecutar.setString(1, dp.getNombre());
            ejecutar.setByte(2, dp.getRegion_id());
            ejecutar.executeUpdate();
                int ContarRegistro = ejecutar.executeUpdate();
            if (ContarRegistro == 0) {
                mensaje = "Ingrese un registro valido";
            }else{
                mensaje = "Los datos se modificaron ";
            }
        } catch (SQLException e) {
            mensaje="ERROR EN MODIFICAR DEPARTAMENTO"+e;
        }finally{
            cnb.cerrarConexion();
        }
        return mensaje;
    }
    
}
