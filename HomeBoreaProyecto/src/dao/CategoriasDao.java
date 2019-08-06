/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import modelo.Categorias;
import interfaces.CategoriasInterface;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 *
 * @author Admin
 */
public class CategoriasDao implements CategoriasInterface {
    
    private String mensaje;

    ConexionBorea conex = new ConexionBorea();
    private PreparedStatement ejecutar;
    private ResultSet resultadoSelect;
    private String sql;
    private int contarRegistros = 0;

    @Override
    public String guardarCategoria(Categorias cate) {
        try {
            conex.abrirConexion();
            sql = "insert into categorias values(?,?,?)";
            ejecutar = conex.getMiConexion().prepareStatement(sql);
            ejecutar.setByte(1, cate.getCategoria_id());
            ejecutar.setString(2, cate.getNombre());
            ejecutar.setInt(3, cate.getEmpleado_id());
            ejecutar.executeUpdate();
            mensaje = "Los datos se guardaron";
        } catch (SQLException e) {
            mensaje = "Error al guardar los datos"+e;
        } finally {
            conex.cerrarConexion();
        }
        return mensaje;
    }

    @Override
    public String updateCategoria(Categorias cate) {

        try {
            conex.abrirConexion();
            sql = "update categorias set nombre=?, empleado_id=? where categoria_id=?";
            ejecutar = conex.getMiConexion().prepareStatement(sql);

            ejecutar.setByte(3, cate.getCategoria_id());
            ejecutar.setString(1, cate.getNombre());
            ejecutar.setInt(2, cate.getEmpleado_id());

            contarRegistros = ejecutar.executeUpdate();

            if (contarRegistros == 0) {
                mensaje = "NO SE ENCONTRO LA BASE DE DATOS";
            } else {
                mensaje = "REGISTRO MODIFICADO";
            }

        } catch (SQLException e) {
            mensaje = "ERROR EN MODIFICAR CATEGORIA" + e;
        } finally {
            conex.cerrarConexion();
        }
        return mensaje;
    }

    @Override
    public String eliminarCategoria(Categorias cate) {

        try {
            conex.abrirConexion();
            sql = "delete from categorias where categoria_id=?";
            ejecutar = conex.getMiConexion().prepareStatement(sql);

            ejecutar.setByte(1, cate.getCategoria_id());

            contarRegistros = ejecutar.executeUpdate();

            if (contarRegistros == 0) {
                mensaje = "NO SE ENCONTRO LA BASE DE DATOS";
            } else {
                mensaje = "REGISTRO ELIMINADO";
            }

        } catch (SQLException e) {
            mensaje = "ERROR EN ELIMINAR_CATEGORIA " + e;
        } finally {
            conex.cerrarConexion();
        }
        return mensaje;
    }

    @Override
    public Categorias buscarCategorias(int categoria_id) {
        Categorias cat = new Categorias();
        try {
            conex.abrirConexion();
            sql = "select * from categorias where categoria_id=" + categoria_id;
            ejecutar = conex.getMiConexion().prepareStatement(sql);

            resultadoSelect = ejecutar.executeQuery();

            resultadoSelect.next();

            cat.setCategoria_id((byte) resultadoSelect.getInt("categoria_id"));
            cat.setNombre(resultadoSelect.getString("nombre"));
            cat.setEmpleado_id(resultadoSelect.getInt("descripcion"));

        } catch (Exception e) {

        } finally {
            conex.cerrarConexion();
        }
        return cat;
    }

    @Override
    public ArrayList<Categorias> listarCategorias() {
        Categorias cate;
        ArrayList<Categorias> lista = new ArrayList();

        try {
            conex.abrirConexion();
            sql = "select * from categorias";
            ejecutar = conex.getMiConexion().prepareStatement(sql);
            resultadoSelect = ejecutar.executeQuery();
            while (resultadoSelect.next()) {
                cate = new Categorias();

                cate.setCategoria_id((byte) resultadoSelect.getInt("categoria_id"));
                cate.setNombre(resultadoSelect.getString("nombre"));
                cate.setEmpleado_id(resultadoSelect.getInt("descripcion"));

                lista.add(cate);
            }

            ejecutar.close();

        } catch (SQLException e) {
            System.out.println("ERROR EN DAO_LISTAR-CATEGORIAS" + e);
        } finally {
            conex.cerrarConexion();
        }

        return lista;
    }

}
