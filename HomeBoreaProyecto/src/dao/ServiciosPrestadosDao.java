/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import interfaces.ServiciosPrestadosInterface;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import modelo.ServiciosPrestados;

/**
 *
 * @author Admin
 */
public class ServiciosPrestadosDao implements ServiciosPrestadosInterface {

    private PreparedStatement ejecutar;
    private ResultSet seleccionar;

    private String mensaje;
    private String sql;
    private int contarRegistros = 0;

    ConexionBorea conex = new ConexionBorea();

    @Override
    public String insertServiciosPrestados(ServiciosPrestados serviciosPrestados) {
        try {
            conex.abrirConexion();
            sql = "INSERT INTO servicios_prestados  values(?,?,?,?,?,?,?)";
            ejecutar = conex.getMiConexion().prepareStatement(sql);

            ejecutar.setInt(1, serviciosPrestados.getServicioprestado_id());
            ejecutar.setInt(2, serviciosPrestados.getCliente_id());
            ejecutar.setInt(3, serviciosPrestados.getServicio_id());
            ejecutar.setByte(4, serviciosPrestados.getCalificacion_cliente());
            ejecutar.setString(5, serviciosPrestados.getDescripcion_cliente());
            ejecutar.setByte(6, serviciosPrestados.getCalificacion_asociado());
            ejecutar.setString(7, serviciosPrestados.getDescripcion_asociado());

            contarRegistros = ejecutar.executeUpdate();

            if (contarRegistros == 0) {
                mensaje = "NO SE ENCONTRO LA BASE DE DATOS";
            } else {
                mensaje = "REGISTRO GUARDADO";
            }

        } catch (SQLException e) {
            mensaje = "LOS DATOS NO FUERON GUARDARON" + e;
        } finally {
            conex.cerrarConexion();
        }
        return mensaje;
    }

    @Override
    public String updateServiciosPrestados(ServiciosPrestados serviciosPrestados) {
        try {
            conex.abrirConexion();
            sql = "update servicios_prestados  set cliente_id=?, servicio_id=?, calificacion_cliente=?, descripcion_cliente=?, calificacion_asociado=?, descripcion_asociado=? where servicioprestado_id=?";
            ejecutar = conex.getMiConexion().prepareStatement(sql);

            ejecutar.setInt(7, serviciosPrestados.getServicioprestado_id());
            ejecutar.setInt(1, serviciosPrestados.getCliente_id());
            ejecutar.setInt(2, serviciosPrestados.getServicio_id());
            ejecutar.setByte(3, serviciosPrestados.getCalificacion_cliente());
            ejecutar.setString(4, serviciosPrestados.getDescripcion_cliente());
            ejecutar.setByte(5, serviciosPrestados.getCalificacion_asociado());
            ejecutar.setString(6, serviciosPrestados.getDescripcion_asociado());

            contarRegistros = ejecutar.executeUpdate();

            if (contarRegistros == 0) {
                mensaje = "NO SE ENCONTRO EL REGISTRO";
            } else {
                mensaje = "REGISTRO MODIFICADO";
            }

        } catch (SQLException e) {
            mensaje = "LOS DATOS NO FUERON MODIFICARON" + e;
        } finally {
            conex.cerrarConexion();
        }
        return mensaje;
    }

    @Override
    public String deleteServiciosPrestados(ServiciosPrestados serviciosPrestados) {
        try {
            conex.abrirConexion();
            sql = "DELETE FROM servicios_prestados  where servicioprestado_id=?";
            ejecutar = conex.getMiConexion().prepareStatement(sql);

            ejecutar.setInt(1, serviciosPrestados.getServicioprestado_id());

            contarRegistros = ejecutar.executeUpdate();

            if (contarRegistros == 0) {
                mensaje = "NO SE ENCONTRO EL REGISTRO";
            } else {
                mensaje = "DATOS ELIMINADOS";
            }

        } catch (SQLException e) {
            mensaje = "LOS DATOS NO SE ELIMINARON" + e;
        } finally {
            conex.cerrarConexion();
        }
        return mensaje;
    }

    @Override
    public ServiciosPrestados buscarServiciosPrestados(int servicioprestado_id) {
        ServiciosPrestados serm = new ServiciosPrestados();
        try {
            conex.abrirConexion();
            sql = "select * from servicios_prestados where servicioprestado_id=?";
            ejecutar = conex.getMiConexion().prepareStatement(sql);

            seleccionar = ejecutar.executeQuery();

            while(seleccionar.next()){
                serm.setServicioprestado_id(seleccionar.getInt("servicioprestado_id"));
                serm.setCliente_id(seleccionar.getInt("cliente_id"));
                serm.setServicio_id(seleccionar.getInt("servicio_id"));
                serm.setCalificacion_asociado(seleccionar.getByte("calificacion_cliente"));
                serm.setDescripcion_cliente(seleccionar.getString("descripcion_cliente"));
                serm.setCalificacion_asociado(seleccionar.getByte("calificacion_asociado"));
                serm.setDescripcion_asociado(seleccionar.getString("descripcion_asociado"));
            }

            seleccionar.close();

        } catch (SQLException e) {
            System.out.println("ERROR EN BUSQUEDA" + e);

        } finally {
            conex.cerrarConexion();
        }
        return serm;
    }

    @Override
    public ArrayList<ServiciosPrestados> listarServiciosPrestados() {
        ServiciosPrestados serm;
        ArrayList<ServiciosPrestados> lista = new ArrayList();

        try {
            conex.abrirConexion();
            sql = "select * from servicios_prestados";

            ejecutar = conex.getMiConexion().prepareStatement(sql);

            seleccionar = ejecutar.executeQuery();

            while (seleccionar.next()) {
                serm = new ServiciosPrestados();
                serm.setServicioprestado_id(seleccionar.getInt("servicioprestado_id"));
                serm.setCliente_id(seleccionar.getInt("cliente_id"));
                serm.setServicio_id(seleccionar.getInt("servicio_id"));
                serm.setCalificacion_asociado(seleccionar.getByte("calificacion_cliente"));
                serm.setDescripcion_cliente(seleccionar.getString("descripcion_cliente"));
                serm.setCalificacion_asociado(seleccionar.getByte("calificacion_asociado"));
                serm.setDescripcion_asociado(seleccionar.getString("descripcion_asociado"));

                lista.add(serm);
            }

            ejecutar.close();

        } catch (SQLException e) {
            System.out.println("ERROR EN DAO_LISTAR_SERVICIOS_PRESTADOS" + e);
        } finally {
            conex.cerrarConexion();
        }

        return lista;
    }

}
