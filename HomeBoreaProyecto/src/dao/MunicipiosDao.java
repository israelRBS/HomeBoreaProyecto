package dao;

import modelo.Departamentos;
import modelo.Municipios;
import interfaces.MunicipiosInterface;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class MunicipiosDao implements MunicipiosInterface {
    
    ConexionRandal cnb = new ConexionRandal();
    private PreparedStatement ejecutar;
    private String mensaje;
    private String sql;
    ResultSet rs;

    @Override
    public Municipios buscarMunicipios(Municipios municipios) {
        Municipios mn = new Municipios();
        try {
            cnb.abrirConexion();
            sql = "select * from  municipios where municipio_id=?";
            ejecutar = cnb.getMiConexion().prepareStatement(sql);
            
            ejecutar.setShort(1, municipios.getMunicipio_id());
            
            rs = ejecutar.executeQuery();
            if (rs.next()) {
                mn = new Municipios();
                mn.setMunicipio_id(rs.getShort("municipio_id"));
                mn.setNombre(rs.getString("nombre"));
                mn.setDepa_id(rs.getByte("departamento_id"));
            }
            rs.close();

        } catch (SQLException e) {
            System.out.println("ERROR EN BUSCAR_MUNICIPIO "+e);
        } finally {
            cnb.cerrarConexion();
        }
        return mn;
    }

    @Override
    public ArrayList<Municipios> listarMunicipios() {
        ArrayList<Municipios> lista = new ArrayList();
        Municipios mn;
        try {
            cnb.abrirConexion();
            sql = "select * from municipios";
            ejecutar = cnb.getMiConexion().prepareStatement(sql);
            rs = ejecutar.executeQuery();
            while (rs.next()) {
                mn = new Municipios();
                mn.setMunicipio_id(rs.getShort("municipio_id"));
                mn.setNombre(rs.getString("nombre"));
                mn.setDepa_id(rs.getByte("departamento_id"));
                lista.add(mn);
            }
            rs.close();
            
        } catch (SQLException e) {
            System.out.println("ERROR EN LISCAR_MUNICIPIOS "+e);
        } finally {
            cnb.cerrarConexion();
        }
        return lista;
    }

    @Override
    public String eliminarMunicipios(Municipios municipios) {
        try {
            cnb.abrirConexion();
            sql = "delete from municipios where municipio_id=?";
            ejecutar = cnb.getMiConexion().prepareStatement(sql);
            ejecutar.setShort(1, municipios.getMunicipio_id());
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
    public String agregarMunicipios(Municipios municipios) {
        try {
            cnb.abrirConexion();
            sql = "insert into municipios values(?,?,?)";
            ejecutar = cnb.getMiConexion().prepareStatement(sql);
            ejecutar.setShort(1, municipios.getMunicipio_id());
            ejecutar.setString(2, municipios.getNombre());
            ejecutar.setByte(3, municipios.getDepa_id());
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
    public String modificarMunicipio(Municipios municipios) {
        try {
            cnb.abrirConexion();
            sql="UPDATE municipios set nombre=?, departamento_id=? where municipio_id=?";
            ejecutar = cnb.getMiConexion().prepareStatement(sql);
            
            ejecutar.setShort(3, municipios.getMunicipio_id());
            ejecutar.setString(1, municipios.getNombre());
            ejecutar.setByte(2, municipios.getDepa_id());
            
            ejecutar.executeUpdate();
            
            mensaje="REGISTRO MODIFICADO";
            
            
        } catch (SQLException e) {
            mensaje="ERROR EN MODIFICAR MUNICIPIO"+e;
        }finally{
            cnb.cerrarConexion();
        }
        return mensaje;
    }
    
}
