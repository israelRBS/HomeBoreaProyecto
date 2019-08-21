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
            ejecutar.setInt(1, estado.getEstado_id());
            ejecutar.setString(2, estado.getNombre());
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
    public String modificarEstado(Estados estado) {
         try {
            cnb.abrirConexion();
            sql = "update estados set nombre=? where estado_id=?";
            ejecutar = cnb.getMiConexion().prepareStatement(sql);
            ejecutar.setInt(1, estado.getEstado_id());
            ejecutar.setString(2, estado.getNombre());
            
             int ContarRegistro = ejecutar.executeUpdate();
            if (ContarRegistro == 0) {
                mensaje = "Ingrese un registro valido";
            }else{
                mensaje = "Los datos se modificaron ";
            }
        } catch (SQLException e) {
            mensaje="ERROR EN MODIFICAR ESTADO";
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
            ejecutar.setInt(1, estado.getEstado_id());
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
    public Estados buscarEstado(Estados estado) {
        Estados es = new Estados();
        try {
            cnb.abrirConexion();
            sql = "select * from  estados where estado_id=?";
            ejecutar = cnb.getMiConexion().prepareStatement(sql);
            rs = ejecutar.executeQuery();
            if (rs.next()) {
                es = new Estados();
                es.setEstado_id(rs.getInt("estado_id"));
                es.setNombre(rs.getString("nombre"));
            }
            rs.close();

        } catch (SQLException e) {
            System.out.println("ERROR EN BUSCAR ESTADO"+e);
        } finally {
            cnb.cerrarConexion();
        }
        return es;
    }

    @Override
    public ArrayList<Estados> listarEstados() {
        ArrayList<Estados> lista = new ArrayList();
        Estados es;
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
            
        } catch (SQLException e) {
             System.out.println("ERROR EN LISTAR_ESTADOS"+e);
        } finally {
            cnb.cerrarConexion();
        }
        return lista;
        
            }
    
}
