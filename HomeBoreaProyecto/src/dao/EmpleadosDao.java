package dao;


import modelo.Empleados;
import interfaces.EmpleadosInterface;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class EmpleadosDao implements EmpleadosInterface {

    ConexionRandal conexion = new ConexionRandal();
    private String mensaje;
    Empleados empleado;
    private String sql;
    private PreparedStatement ejecutar;
    ResultSet resultadoSelect;
    

    @Override
    public Empleados buscarEmpleados(String usuario, String contraseña) {
        
        try {
            conexion.abrirConexion();
            sql="select * from empleados where usuario=? and contraseña=?";
            ejecutar=conexion.getMiConexion().prepareStatement(sql);
            resultadoSelect=ejecutar.executeQuery();
            if (resultadoSelect.next()) {
                empleado=new Empleados();
                empleado.setEmpleado_id(resultadoSelect.getInt("empleado_id"));
                empleado.setUsuario(resultadoSelect.getString("usuario"));
                empleado.setContraseña(resultadoSelect.getString("contrasenia"));
                empleado.setTipoempleado_id(resultadoSelect.getInt("tipoempleado_id"));
            }
            
            
        } catch (SQLException e) {
            System.out.println("ERROR EN BUSCAR EMPLEADO"+e);
        }
        return empleado;
    }

    @Override
    public ArrayList<Empleados> listarEmpleados() {
        ArrayList<Empleados> lista=new ArrayList();
        
        try {
            conexion.abrirConexion();
            sql="select * from empleados";
            ejecutar=conexion.getMiConexion().prepareStatement(sql);
            resultadoSelect=ejecutar.executeQuery();
            while(resultadoSelect.next()){
                empleado=new Empleados();
                empleado.setEmpleado_id(resultadoSelect.getInt("empleado_id"));
                empleado.setUsuario(resultadoSelect.getString("usuario"));
                empleado.setContraseña(resultadoSelect.getString("contrasenia"));
                empleado.setTipoempleado_id(resultadoSelect.getInt("tipoempleado_id"));
                lista.add(empleado);
            }
            resultadoSelect.close();
            
        } catch (SQLException e) {
            System.out.println("ERROR EN LISTAR EMPLEADOS"+e);
        }finally{
            conexion.cerrarConexion();
        }
        return lista;
    }

    @Override
    public String eliminarEmpleados(Empleados empleado) {
        try {
            conexion.abrirConexion();
            sql="delete from empleados where empleado_id=?";
            ejecutar=conexion.getMiConexion().prepareStatement(sql);
            ejecutar.setInt(1, empleado.getEmpleado_id());
            ejecutar.executeUpdate();
            mensaje="los datos se eliminaron correctamente";
        } catch (SQLException e) {
            mensaje="no se pudo Eliminar: "+e;
        }finally{
            conexion.cerrarConexion();
        }
        return mensaje;
    }

    @Override
    public String insertarEmpleado(Empleados empleado) {
        try {
            conexion.abrirConexion();
            sql="Insert into empleados values(?,?,?,?)";
            ejecutar=conexion.getMiConexion().prepareStatement(sql);
            ejecutar.setInt(1, empleado.getEmpleado_id());
            ejecutar.setString(2, empleado.getUsuario());
            ejecutar.setString(3,empleado.getContraseña());
            ejecutar.setInt(4,empleado.getTipoempleado_id());
            ejecutar.executeUpdate();
            mensaje="Datos Almacenados";
            
            
        } catch (SQLException e) {
            mensaje="Datos no almacenados"+e;
        }finally{
            conexion.cerrarConexion();
        }
        return mensaje;
    }

    @Override
    public String modificarEmpleado(Empleados empleado) {
        try {
            conexion.abrirConexion();
            sql="update empleados set usuario=?, contrasenia=?, tipoempleado_id=? where empleado_id=?";
            ejecutar = conexion.getMiConexion().prepareStatement(sql);
            ejecutar.setInt(4, empleado.getEmpleado_id());
            ejecutar.setString(1, empleado.getUsuario());
            ejecutar.setString(2,empleado.getContraseña());
            ejecutar.setInt(3,empleado.getTipoempleado_id());
            
            ejecutar.executeUpdate();
            
            mensaje="REGISTRO MODIFICADO";
            
        } catch (SQLException e) {
            mensaje="ERROR EN MODIFICAR EMPLEADO"+e;
        }finally{
          conexion.cerrarConexion();
        }
        return mensaje;
    }

}
