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

    ConexionBorea conex = new ConexionBorea();
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
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public String eliminarTipCosto(TiposCosto tiposCosto) {
        try {
            conex.abrirConexion();
        } catch (Exception e) {
            mensaje="ERROR EN DAO_ELIMINAR_TIPO_COSTO "+e;
        }finally{
            conex.cerrarConexion();
        }
        return mensaje;
    }

    @Override
    public String insertarTipCosto(TiposCosto tiposCosto) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public String modificarTipoCosto(TiposCosto tiposCosto) {
        try {
            conex.abrirConexion();
            sql = "UPDATE tiposcosto SET descripcion=? WHERE tipocosto=?";
            ejecutar = conex.getMiConexion().prepareStatement(sql);

            ejecutar.setByte(1, tiposCosto.getTipocosto_id());
            ejecutar.setString(2, tiposCosto.getDescripcion());

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
