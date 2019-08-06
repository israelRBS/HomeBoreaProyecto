/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import modelo.Servicios;
import interfaces.ServiciosInterface;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 *
 * @author Admin
 */
public class ServiciosDao implements ServiciosInterface {

    ConexionBorea conex = new ConexionBorea();
    private PreparedStatement ejecutar;
    private ResultSet resultadoSelect;

    private String mensaje;
    private String sql;
    private int contarRegistros = 0;

    @Override
    public String insertServicios(Servicios servicios) {

        try {
            conex.abrirConexion();
            sql = "INSERT INTO servicios  values(?,?,?,?,?)";
            ejecutar = conex.getMiConexion().prepareStatement(sql);

            ejecutar.setInt(1, servicios.getServicio_id());
            ejecutar.setInt(2, servicios.getAsociado_id());
            ejecutar.setInt(3, servicios.getSubcategoria_id());
            ejecutar.setInt(4, servicios.getCosto());
            ejecutar.setInt(5, servicios.getTipocosto_id());

            contarRegistros = ejecutar.executeUpdate();

            if (contarRegistros == 0) {
                mensaje = "No se puede registrar";
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
    public String updateServicios(Servicios servicios) {
        try {
            conex.abrirConexion();
            sql = "update servicios  set asociado_id=?, subcategoria_id=?, costo=?, tipocosto_id=? where sevicio_id=?";
            ejecutar = conex.getMiConexion().prepareStatement(sql);

            ejecutar.setInt(5, servicios.getServicio_id());
            ejecutar.setInt(1, servicios.getAsociado_id());
            ejecutar.setInt(2, servicios.getSubcategoria_id());
            ejecutar.setInt(3, servicios.getCosto());
            ejecutar.setInt(4, servicios.getTipocosto_id());
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
    public String deleteServicios(Servicios servicios) {

        try {
            conex.abrirConexion();
            sql = "DELETE FROM servicios  where servicio_id=?";
            ejecutar = conex.getMiConexion().prepareStatement(sql);

            ejecutar.setInt(1, servicios.getServicio_id());

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
    public Servicios buscarServicios(int servicio_id) {
        Servicios servicios = new Servicios();
        try {
            conex.abrirConexion();
            sql = "select * from servicios where sevicio_id=?";
            ejecutar = conex.getMiConexion().prepareStatement(sql);

            resultadoSelect = ejecutar.executeQuery();

            resultadoSelect.next();

            servicios.setServicio_id(resultadoSelect.getInt("servicio_id"));
            servicios.setAsociado_id(resultadoSelect.getInt("asociado_id"));
            servicios.setSubcategoria_id(resultadoSelect.getInt("subcategoria_id"));
            servicios.setCosto((short) resultadoSelect.getInt("costo"));
            servicios.setTipocosto_id((byte) resultadoSelect.getInt("tipocosto_id"));

        } catch (SQLException e) {
            System.out.println("ERROR EN BUSQUEDA" + e);

        } finally {
            conex.cerrarConexion();
        }
        return servicios;
    }

    @Override
    public ArrayList<Servicios> listarServicios() {

        Servicios ser;
        ArrayList<Servicios> lista = new ArrayList();

        try {
            conex.abrirConexion();
            sql = "select * from servicios";

            ejecutar = conex.getMiConexion().prepareStatement(sql);

            resultadoSelect = ejecutar.executeQuery();

            while (resultadoSelect.next()) {
                ser = new Servicios();

                ser.setServicio_id(resultadoSelect.getInt("servicio_id"));
                ser.setAsociado_id(resultadoSelect.getInt("asociado_id"));
                ser.setSubcategoria_id(resultadoSelect.getInt("subcategoria_id"));
                ser.setCosto((short) resultadoSelect.getInt("costo"));
                ser.setTipocosto_id((byte) resultadoSelect.getInt("tipocosto_id"));

                lista.add(ser);
            }

            ejecutar.close();

        } catch (SQLException e) {
                System.out.println("ERROR EN LISTAR_SERVICIOS " + e);
        } finally {
            conex.cerrarConexion();
        }

        return lista;

    }

}
