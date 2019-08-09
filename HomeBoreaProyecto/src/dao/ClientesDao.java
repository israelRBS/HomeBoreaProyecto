package dao;

import modelo.Clientes;
import interfaces.ClientesInterface;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class ClientesDao implements ClientesInterface {

    ConexionBorea cnb = new ConexionBorea();
    Clientes cl = new Clientes();
    private String mensaje = null;
    private String sql;
    private PreparedStatement ejecutar;
    ResultSet rs;

    @Override
    public Clientes buscarClientes(Clientes clientes) {
        try {
            cnb.abrirConexion();
            sql = "select * from  clientes where cliente_id=?";
            ejecutar = cnb.getMiConexion().prepareStatement(sql);
            ejecutar.setInt(1, clientes.getCliente_id());
            rs = ejecutar.executeQuery();
            if (rs.next()) {
                cl = new Clientes();
                cl.setCliente_id(rs.getInt("cliente_id"));
                cl.setUsuario(rs.getString("usuario"));
                cl.setContrasenia(rs.getString("contraseña"));
            }
            rs.close();

        } catch (SQLException e) {
            System.out.println("ERROR EN BUSCAR_CLIENTE_DAO "+e);
        } finally {
            cnb.cerrarConexion();
        }
        return cl;
    }

    @Override
    public ArrayList<Clientes> listarClientes() {
        ArrayList<Clientes> lista = new ArrayList();

        try {
            cnb.abrirConexion();
            sql = "select * from clientes";
            ejecutar = cnb.getMiConexion().prepareStatement(sql);
            rs = ejecutar.executeQuery();
            while (rs.next()) {
                cl = new Clientes();
                cl.setCliente_id(rs.getInt("cliente_id"));
                cl.setUsuario(rs.getString("usuario"));
                cl.setContrasenia(rs.getString("contraseña"));
                lista.add(cl);
            }
            rs.close();
            
        } catch (SQLException e) {
            System.out.println("ERROR EN LISTAR_CLIENTES "+e);
        } finally {
            cnb.cerrarConexion();
        }
        return lista;
    }

    @Override
    public String eliminarClientes(Clientes cl) {
        try {
            cnb.abrirConexion();
            sql = "delete from clientes where cliente_id=?";
            ejecutar = cnb.getMiConexion().prepareStatement(sql);
            ejecutar.setInt(1, cl.getCliente_id());
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
    public String insertarClientes(Clientes clientes) {
        try {
            cnb.abrirConexion();
            sql = "insert into clientes values(?,?,?)";
            ejecutar = cnb.getMiConexion().prepareStatement(sql);
            ejecutar.setInt(1, cl.getCliente_id());
            ejecutar.setString(2, cl.getUsuario());
            ejecutar.setString(3, cl.getContrasenia());
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
    public String modificarClientes(Clientes clientes) {
        try {
            cnb.abrirConexion();
            sql = "update clientes set usuario=?, contrasenia=? where cliente_id=?";
            ejecutar = cnb.getMiConexion().prepareStatement(sql);
            ejecutar.setInt(3, cl.getCliente_id());
            ejecutar.setString(1, cl.getUsuario());
            ejecutar.setString(2, cl.getContrasenia());
            ejecutar.executeUpdate();
            mensaje = "Los Datos fueron se Modificaron";
        } catch (SQLException e) {
            mensaje = "Error Modificar dato "+e ;
        }finally{
            cnb.cerrarConexion();
        }
        return mensaje;
    }
    
    
}
