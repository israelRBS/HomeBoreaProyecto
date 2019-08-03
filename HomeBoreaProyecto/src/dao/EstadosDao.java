/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import interfaces.EstadosInterface;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import modelo.Estados;

/**
 *
 * @author Jose
 */
public class EstadosDao implements EstadosInterface {
    ConexionBorea cnb = new ConexionBorea();
    Estados es = new Estados();
    private String mensaje = null;
    PreparedStatement ejecutar;
    ResultSet rs;
    private String sql;

    @Override
    public String guardarEstados(Estados estado) {
try {
            cnb.abrirConexion();
            sql = "insert into estados values(?,?)";
            ejecutar = cnb.getMiConexion().prepareStatement(sql);
            ejecutar.setInt(1, es.getEstado_id());
            ejecutar.setString(2, es.getNombre());
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
    public String modificarEstado(Estados estado) {
         try {
            cnb.abrirConexion();
            sql = "update estados set  estado_id=?, nombre=? where estado_id=?  ";
            ejecutar = cnb.getMiConexion().prepareStatement(sql);
            ejecutar.setInt(1, es.getEstado_id());
            ejecutar.setString(2, es.getNombre());
            
             int ContarRegistro = ejecutar.executeUpdate();
            if (ContarRegistro == 0) {
                mensaje = "Ingrese un registro valido";
            }else{
                mensaje = "Los datos se modificaron ";
            }
        } catch (SQLException e) {
        }finally{
            cnb.cerrarConexion();
        }
        return mensaje;
    }

    @Override
    public String eliminarEstado(Estados estado) {
        try {
            cnb.abrirConexion();
            sql = "delete from estados where estado_id=?";
            ejecutar = cnb.getMiConexion().prepareStatement(sql);
            ejecutar.setInt(1, es.getEstado_id());
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
    public Estados buscarEstado(Estados estado) {
        try {
            cnb.abrirConexion();
            sql = "select * from  estados";
            ejecutar = cnb.getMiConexion().prepareStatement(sql);
            rs = ejecutar.executeQuery();
            if (rs.next()) {
                es = new Estados();
                es.setEstado_id(rs.getInt("estado_id"));
                es.setNombre(rs.getString("nombre"));
            }
            rs.close();

        } catch (Exception e) {
        } finally {
            cnb.cerrarConexion();
        }
        return es;
    }

    @Override
    public ArrayList<Estados> listarTipEmpleado() {
        ArrayList<Estados> lista = new ArrayList();
         try {
            cnb.abrirConexion();
            sql = "select * from estados";
            ejecutar = cnb.getMiConexion().prepareStatement(sql);
            rs = ejecutar.executeQuery();
            while (rs.next()) {
                es = new Estados();
                es.setEstado_id(rs.getInt("estado_id"));
                es.setNombre(rs.getString("nombre"));
                lista.add(es);
            }
            rs.close();
            
        } catch (Exception e) {
        } finally {
            cnb.cerrarConexion();
        }
        return lista;
        
            }
    
}
