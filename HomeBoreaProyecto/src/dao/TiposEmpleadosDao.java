/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import interfaces.TiposEmpleadoInterface;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import modelo.TiposEmpleado;

/**
 *
 * @author Admin
 */
public class TiposEmpleadosDao implements TiposEmpleadoInterface {

    /*FALTA POR TERMINAR ESTA CLASE*/
    private String mensaje;
    private String mysql;
    private int registrosAfectados = 0;
    ConexionBorea conex = new ConexionBorea();
    private PreparedStatement ejecutar;
    private ResultSet seleccionar;

    @Override
    public TiposEmpleado buscarTipEmpleado(TiposEmpleado tiposEmpleado) {
        TiposEmpleado emp = new TiposEmpleado();
        try {
            conex.abrirConexion();
            mysql = "select * from  tipos_empleado where tipoempleado_id=?";
            ejecutar = conex.getMiConexion().prepareStatement(mysql);
            ejecutar.setInt(1, tiposEmpleado.getTipoempleado_id());

            seleccionar = ejecutar.executeQuery();

            while (seleccionar.next()) {
                emp.setTipoempleado_id(seleccionar.getInt("tipoempleado_id"));
                emp.setNombre(seleccionar.getString("nombre"));
            }
            seleccionar.close();

        } catch (SQLException e) {
            System.out.println("ERROR EN BUSCAR_TIPO_EMPLEADO " + e);
        } finally {
            conex.cerrarConexion();
        }
        return emp;
    }

    @Override
    public ArrayList<TiposEmpleado> listarTipEmpleado() {
        TiposEmpleado empleados;
        ArrayList<TiposEmpleado> lista = new ArrayList<>();
        try {
            conex.abrirConexion();
            mysql = "SELECT * FROM tipos_empleado";

            seleccionar = ejecutar.executeQuery();

            while (seleccionar.next()) {
                empleados = new TiposEmpleado();
                empleados.setTipoempleado_id(seleccionar.getInt("tipoempleado_id"));
                empleados.setNombre(seleccionar.getString("nombre"));

                lista.add(empleados);
            }
        } catch (SQLException e) {
            System.out.println("ERROR EN LISTAR_EMPLEADOS " + e);
        } finally {
            conex.cerrarConexion();
        }
        return lista;
    }

    @Override
    public String eliminarTipEmpleado(TiposEmpleado tiposEmpleado) {
        try {
            conex.abrirConexion();
            mysql = "delete from tipos_empleados where tipoempleado_id=?";
            ejecutar = conex.getMiConexion().prepareStatement(mysql);

            ejecutar.setInt(1, tiposEmpleado.getTipoempleado_id());

            registrosAfectados = ejecutar.executeUpdate();

            if (registrosAfectados == 0) {
                mensaje = "NO SE ENCONTRO EL REGISTRO";
            } else {
                mensaje = "REGISTRO ELIMINADO";
            }

        } catch (SQLException e) {
            mensaje = "ERROR EN ELIMINAR_TIPO_EMPLEADO " + e;
        } finally {
            conex.cerrarConexion();
        }

        return mensaje;
    }

    @Override
    public String insertarTipEmpleado(TiposEmpleado tiposEmpleado) {
        try {
            conex.abrirConexion();
            mysql = "insert into tipos_empleado values(?,?)";
            ejecutar = conex.getMiConexion().prepareStatement(mysql);

            ejecutar.setInt(1, tiposEmpleado.getTipoempleado_id());
            ejecutar.setString(2, tiposEmpleado.getNombre());

            registrosAfectados = ejecutar.executeUpdate();

            if (registrosAfectados == 0) {
                mensaje = "NO SE ENCONTRO LA BASE DE DATOS";
            } else {
                mensaje = "REGISTRO GUARDADO";
            }

        } catch (SQLException e) {
            mensaje = "ERROR EN INSERTAR_TIPO_EMPLEADO" + e;
        } finally {
            conex.cerrarConexion();
        }
        return mensaje;
    }

    @Override
    public String modificarEmpleado(TiposEmpleado tiposEmpleado) {
        try {
            conex.abrirConexion();
            mysql = "UPDATE tipos_empleado SET nombre=? where tipoempleado_id=?";
            ejecutar = conex.getMiConexion().prepareStatement(mysql);

            ejecutar.setInt(2, tiposEmpleado.getTipoempleado_id());
            ejecutar.setString(1, tiposEmpleado.getNombre());

            registrosAfectados = ejecutar.executeUpdate();

            if (registrosAfectados == 0) {
                mensaje = "NO SE ENCONTRO LA BASE DE DATOS";
            } else {
                mensaje = "REGISTRO MODIFICADO";
            }

        } catch (SQLException e) {
            mensaje = "ERROR EN MODIFICAR_TIPO_EMPLEADO" + e;
        } finally {
            conex.cerrarConexion();
        }
        return mensaje;
    }

}
