/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import interfaces.TiposCostoInterface;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import modelo.TiposCosto;

/**
 *
 * @author Admin
 */
public class TipoCostoDao implements TiposCostoInterface {

    ConexionRandal conex = new ConexionRandal();
    private String sql;
    int contarRegistros = 0;
    private String mensaje;
    private PreparedStatement ejecutar;
    private ResultSet seleccionar;

    @Override
    public TiposCosto buscarTipCosto(TiposCosto tiposCosto) {
        TiposCosto costo = new TiposCosto();
        try {
            conex.abrirConexion();
            sql = "select * from tiposcosto where tipocosto_id=?";
            ejecutar = conex.getMiConexion().prepareStatement(sql);

            ejecutar.setByte(1, tiposCosto.getTipocosto_id());

            seleccionar = ejecutar.executeQuery();

            while (seleccionar.next()) {
                costo.setTipocosto_id(seleccionar.getByte("tipocosto_id"));
                costo.setDescripcion(seleccionar.getString("descripcion"));
            }
            seleccionar.close();
        } catch (SQLException e) {
            System.out.println("ERROR EN BUSCAR_TIPO_COSTO " + e);
        } finally {
            conex.cerrarConexion();
        }
        return costo;
    }

    @Override
    public ArrayList<TiposCosto> listarTipCosto() {
        TiposCosto costo;
        ArrayList<TiposCosto> listar = new ArrayList<>();
        try {
            conex.abrirConexion();
            sql = "select * from tiposcosto";
            ejecutar = conex.getMiConexion().prepareStatement(sql);

            seleccionar = ejecutar.executeQuery();

            while (seleccionar.next()) {
                costo = new TiposCosto();
                costo.setTipocosto_id(seleccionar.getByte("tipocosto_id"));
                costo.setDescripcion(seleccionar.getString("descripcion"));

                listar.add(costo);
            }
            seleccionar.close();

        } catch (SQLException e) {
            System.out.println("ERROR EN LISTAR_TIPOS_COSTOS " + e);
        } finally {
            conex.cerrarConexion();
        }

        return listar;
    }

    @Override
    public String eliminarTipCosto(TiposCosto tiposCosto) {
        try {
            conex.abrirConexion();
            sql = "delete from tiposcosto where tipocosto_id=?";
            ejecutar = conex.getMiConexion().prepareStatement(sql);

            ejecutar.setByte(1, tiposCosto.getTipocosto_id());

            contarRegistros = ejecutar.executeUpdate();

            if (contarRegistros == 0) {
                mensaje = "NO SE ENCONTRO EL REGISTRO";
            } else {
                mensaje = "REGISTRO ELIMINADO";
            }

        } catch (SQLException e) {
            mensaje = "ERROR EN DAO_ELIMINAR_TIPO_COSTO " + e;
        } finally {
            conex.cerrarConexion();
        }
        return mensaje;
    }

    @Override
    public String insertarTipCosto(TiposCosto tiposCosto) {
        try {
            conex.abrirConexion();
            sql = "insert into tiposcosto values(?,?)";
            ejecutar = conex.getMiConexion().prepareStatement(sql);

            ejecutar.setByte(1, tiposCosto.getTipocosto_id());
            ejecutar.setString(2, tiposCosto.getDescripcion());

            contarRegistros = ejecutar.executeUpdate();

            if (contarRegistros == 0) {
                mensaje = "NO SE ENCOTRO EL REGISTRO ";
            } else {
                mensaje = "TIPO_COSTO GUARDADO";
            }
        } catch (SQLException e) {
            mensaje = "ERROR EN MODIFICAR_TIPO_COSTO_DAO " + e;
        } finally {
            conex.cerrarConexion();
        }
        return mensaje;
    }

    @Override
    public String modificarTipoCosto(TiposCosto tiposCosto) {
        try {
            conex.abrirConexion();
            sql = "UPDATE tiposcosto SET descripcion=? WHERE tipocosto_id=?";
            ejecutar = conex.getMiConexion().prepareStatement(sql);

            ejecutar.setByte(2, tiposCosto.getTipocosto_id());
            ejecutar.setString(1, tiposCosto.getDescripcion());

            contarRegistros = ejecutar.executeUpdate();

            if (contarRegistros == 0) {
                mensaje = "NO SE ENCOTRO EL REGISTRO ";
            } else {
                mensaje = "TIPO_COSTO MODIFICADO";
            }
        } catch (SQLException e) {
            mensaje = "ERROR EN MODIFICAR_TIPO_COSTO_DAO " + e;
        } finally {
            conex.cerrarConexion();
        }
        return mensaje;
    }

}
