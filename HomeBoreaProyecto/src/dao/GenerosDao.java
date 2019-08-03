/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import interfaces.GenerosInterface;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import modelo.Generos;

/**
 *
 * @author Jose
 */
public class GenerosDao implements GenerosInterface{
    
     ConexionBorea cnb = new ConexionBorea();
    Generos ge = new Generos();
    private String mensaje = null;
    PreparedStatement ejecutar;
    ResultSet rs;
    private String sql;

    @Override
    public ArrayList<Generos> listarTipEmpleado() {
 ArrayList<Generos> lista = new ArrayList();
         try {
            cnb.abrirConexion();
            sql = "select * from estados";
            ejecutar = cnb.getMiConexion().prepareStatement(sql);
            rs = ejecutar.executeQuery();
            while (rs.next()) {
                ge = new Generos();
                ge.setGenero_id(rs.getInt("genero_id"));
                ge.setNombre(rs.getString("nombre"));
                lista.add(ge);
            }
            rs.close();
            
        } catch (Exception e) {
        } finally {
            cnb.cerrarConexion();
        }
        return lista;        
    }

    @Override
    public String guardarGenero(Generos genero) {
        try {
            cnb.abrirConexion();
            sql = "insert into generos values(?,?)";
            ejecutar = cnb.getMiConexion().prepareStatement(sql);
            ejecutar.setInt(1, ge.getGenero_id());
            ejecutar.setString(2, ge.getNombre());
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
    public String modificarGenero(Generos genero) {
        try {
            cnb.abrirConexion();
            sql = "update generos set  genero_id=?, nombre=? where genero_id=?  ";
            ejecutar = cnb.getMiConexion().prepareStatement(sql);
            ejecutar.setInt(1, ge.getGenero_id());
            ejecutar.setString(2, ge.getNombre());
            
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
    public String eliminarGenero(Generos genero) {
                try {
            cnb.abrirConexion();
            sql = "delete from generos where genero_id=?";
            ejecutar = cnb.getMiConexion().prepareStatement(sql);
            ejecutar.setInt(1, ge.getGenero_id());
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
    public Generos buscar(Generos genero) {
                try {
            cnb.abrirConexion();
            sql = "select * from  generos";
            ejecutar = cnb.getMiConexion().prepareStatement(sql);
            rs = ejecutar.executeQuery();
            if (rs.next()) {
                ge = new Generos();
                ge.setGenero_id(rs.getInt("genero_id"));
                ge.setNombre(rs.getString("nombre"));
            }
            rs.close();

        } catch (Exception e) {
        } finally {
            cnb.cerrarConexion();
        }
        return ge;

    }
    
}
 