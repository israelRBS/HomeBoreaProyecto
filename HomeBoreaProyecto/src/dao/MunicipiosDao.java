package dao;

import modelo.Departamentos;
import modelo.Municipios;
import interfaces.MunicipiosInterface;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

public class MunicipiosDao implements MunicipiosInterface {
    Municipios mn = new Municipios();
    ConexionBorea cnb = new ConexionBorea();
    private PreparedStatement ejecutar;
    private String mensaje;
    private String sql;
    ResultSet rs;

    @Override
    public Municipios buscarMunicipios(Municipios municipios) {
        try {
            cnb.abrirConexion();
            sql = "select * from  municipios";
            ejecutar = cnb.getMiConexion().prepareStatement(sql);
            rs = ejecutar.executeQuery();
            if (rs.next()) {
                mn = new Municipios();
                mn.setMunicipio_id(rs.getShort("municipio_id"));
                mn.setNombre(rs.getString("nombre"));
                mn.setDepa_id(rs.getByte("departamento_id"));
            }
            rs.close();

        } catch (Exception e) {
        } finally {
            cnb.cerrarConexion();
        }
        return mn;
    }

    @Override
    public ArrayList<Municipios> listarMunicipios() {
        ArrayList<Municipios> lista = new ArrayList();
        
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
            
        } catch (Exception e) {
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
            ejecutar.setShort(1, mn.getMunicipio_id());
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
    public String agregarMunicipios(Municipios municipios) {
        try {
            cnb.abrirConexion();
            sql = "insert into municipios values(?,?,?)";
            ejecutar = cnb.getMiConexion().prepareStatement(sql);
            ejecutar.setShort(1, mn.getMunicipio_id());
            ejecutar.setString(2, mn.getNombre());
            ejecutar.setByte(3, mn.getDepa_id());
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
    public String modificarMunicipio(Municipios municipios) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
