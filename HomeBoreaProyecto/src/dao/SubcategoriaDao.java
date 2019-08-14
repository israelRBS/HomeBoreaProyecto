/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import modelo.Subcategorias;
import interfaces.SubcategoriasInterface;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 *
 * @author Admin
 */
public class SubcategoriaDao implements SubcategoriasInterface {

    ConexionRandal conex = new ConexionRandal();
    private PreparedStatement ejecutar;
    private ResultSet resultadoSelect;

    private String mensaje;
    private String sql;
    private int contarRegistros = 0;

    @Override
    public String insertSubcategia(Subcategorias sub) {
        try {
            conex.abrirConexion();
            sql = "INSERT INTO subcategorias values(?,?,?,?)";
            ejecutar = conex.getMiConexion().prepareStatement(sql);

            ejecutar.setByte(1, sub.getSubcategoria_id());
            ejecutar.setString(2, sub.getNombre());
            ejecutar.setByte(3, sub.getCategoria_id());
            ejecutar.setInt(4, sub.getEmpleado_id());

            contarRegistros = ejecutar.executeUpdate();

            if (contarRegistros == 0) {
                mensaje = "NO SE AGREGO EL REGISTRO";
            } else {
                mensaje = "DATOS ALMACENADOS";
            }

        } catch (SQLException e) {
            mensaje = "LOS DATOS NO SE GUARDARON" + e;
        } finally {
            conex.cerrarConexion();
        }
        return mensaje;

    }

    @Override
    public String updateSubcategoria(Subcategorias sub) {

        try {
            conex.abrirConexion();
            sql = "update subcategorias set nombre=?, categoria_id=?, empleado_id=? where subcategoria_id=?";
            ejecutar = conex.getMiConexion().prepareStatement(sql);

            ejecutar.setByte(4, sub.getSubcategoria_id());
            ejecutar.setString(1, sub.getNombre());
            ejecutar.setByte(2, sub.getCategoria_id());
            ejecutar.setInt(3, sub.getEmpleado_id());

            contarRegistros = ejecutar.executeUpdate();

            if (contarRegistros == 0) {
                mensaje = "NO SE AGREGO EL REGISTRO";
            } else {
                mensaje = "DATOS MODIFICADOS";
            }

        } catch (SQLException e) {
            mensaje = "LOS DATOS NO SE MODIFICARON" + e;
        } finally {
            conex.cerrarConexion();
        }
        return mensaje;
    }

    @Override
    public String deleteSubcategoria(Subcategorias sub) {
        try {
            conex.abrirConexion();
            sql = "DELETE FROM subcategorias  where subcategoria_id=?";
            ejecutar = conex.getMiConexion().prepareStatement(sql);

            ejecutar.setByte(1, sub.getSubcategoria_id());

            contarRegistros = ejecutar.executeUpdate();

            if (contarRegistros == 0) {
                mensaje = "NO SE AGREGO EL REGISTRO";
            } else {
                mensaje = "DATOS ELIMINADOS";
            }

        } catch (Exception e) {
            mensaje = "LOS DATOS NO SE ELIMINARON" + e;
        } finally {
            conex.cerrarConexion();
        }
        return mensaje;
    }

    @Override
    public Subcategorias buscarSubcategoria(int sub_cate) {
        Subcategorias subcategoria = new Subcategorias();
        try {
            conex.abrirConexion();
            sql = "select * from subcategorias where subcategoria_id=" + sub_cate;
            ejecutar = conex.getMiConexion().prepareStatement(sql);

            resultadoSelect = ejecutar.executeQuery();

            resultadoSelect.next();

            subcategoria.setSubcategoria_id(resultadoSelect.getByte("subcategoria_id"));
            subcategoria.setNombre(resultadoSelect.getString("nombre"));
            subcategoria.setCategoria_id(resultadoSelect.getByte("categoria_id"));
            subcategoria.setEmpleado_id(resultadoSelect.getInt("empleado_id"));

        } catch (SQLException e) {
            System.out.println("ERROR EN BUSQUEDA" + e);

        } finally {
            conex.cerrarConexion();
        }
        return subcategoria;
    }

    @Override
    public ArrayList<Subcategorias> listarSubcategorias() {
        Subcategorias sub;
        ArrayList<Subcategorias> lista = new ArrayList();

        try {
            conex.abrirConexion();
            sql = "select * from subcategorias";

            ejecutar = conex.getMiConexion().prepareStatement(sql);

            resultadoSelect = ejecutar.executeQuery();

            while (resultadoSelect.next()) {
                sub = new Subcategorias();

                sub.setSubcategoria_id(resultadoSelect.getByte("subcategoria_id"));
                sub.setNombre(resultadoSelect.getString("nombre"));
                sub.setCategoria_id(resultadoSelect.getByte("categoria_id"));
                sub.setEmpleado_id(resultadoSelect.getInt("empleado_id"));

                lista.add(sub);
                
            }
            
            ejecutar.close();

        } catch (SQLException e) {
            System.out.println("ERROR EN DAO_LISTA_SUBCATEGORIAS" + e);
        } finally {
            conex.cerrarConexion();
        }

        return lista;

    }

}
