package dao;

import modelo.Asociados;
import interfaces.AsociadosInterface;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class AsociadosDao implements AsociadosInterface {

    ConexionBorea cnb = new ConexionBorea();
    Asociados ac = new Asociados();
    private String mensaje = null;
    private String sql;
    private PreparedStatement ejecutar;
    private int ContarRegistro = 0;
    ResultSet rs;

    @Override
    public Asociados buscarAsociados(int asociados_id) {
        try {
            cnb.abrirConexion();
            sql = "select * from  asociados where asociados_id=?";
            ejecutar = cnb.getMiConexion().prepareStatement(sql);
            ejecutar.setInt(1, ac.getAsociado_id());
            rs = ejecutar.executeQuery();
            while (rs.next()) {
                ac = new Asociados();
                ac.setAsociado_id(rs.getInt("asociado_id"));
                ac.setAnte_penal(rs.getString("antecedentes_penales"));
                ac.setAnte_poli(rs.getString("antecedentes_policiacos"));
                ac.setDpiImagen(rs.getString("dpiimagen"));
                ac.setEspecialidad(rs.getString("especialidad"));
                ac.setFoto(rs.getString("fotografia"));
                ac.setNivel_acad_id(rs.getByte("nivelacademico_id"));
                ac.setUsuario_aso(rs.getString("usuario"));
                ac.setUsuario_contra(rs.getString("password"));
            }
            rs.close();

        } catch (SQLException e) {
            System.out.println("ERROR EN BUSCAR_ASOCIADO "+e);
        } finally {
            cnb.cerrarConexion();
        }
        return ac;
    }

    @Override
    public ArrayList<Asociados> listarAsociados() {
        ArrayList<Asociados> lista = new ArrayList();

        try {
            cnb.abrirConexion();
            sql = "select * from asociados";
            ejecutar = cnb.getMiConexion().prepareStatement(sql);
            rs = ejecutar.executeQuery();
            while (rs.next()) {
                ac = new Asociados();
                ac.setAsociado_id(rs.getInt("asociado_id"));
                ac.setAnte_penal(rs.getString("antecedentes_penales"));
                ac.setAnte_poli(rs.getString("antecedentes_policiacos"));
                ac.setDpiImagen(rs.getString("dpiimagen"));
                ac.setEspecialidad(rs.getString("especialidad"));
                ac.setFoto(rs.getString("fotografia"));
                ac.setNivel_acad_id(rs.getByte("nivelacademico_id"));
                ac.setUsuario_aso(rs.getString("usuario"));
                ac.setUsuario_contra(rs.getString("password"));
                lista.add(ac);
            }
            rs.close();
            
        } catch (SQLException e) {
        } finally {
            cnb.cerrarConexion();
        }
        return lista;
    }

    @Override
    public String eliminarAsociados(Asociados asociados) {
        try {
            cnb.abrirConexion();
            sql = "delete from asociados where asociado_id=?";
            ejecutar = cnb.getMiConexion().prepareStatement(sql);
            ejecutar.setInt(1, ac.getAsociado_id());
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
    public String insertarAsociados(Asociados asociados) {
        try {
            cnb.abrirConexion();
            sql = "insert into asociados values(?,?,?,?,?,?,?,?,?)";
            ejecutar = cnb.getMiConexion().prepareStatement(sql);
            ejecutar.setInt(1, ac.getAsociado_id());
            ejecutar.setString(2, ac.getAnte_penal());
            ejecutar.setString(3, ac.getAnte_poli());
            ejecutar.setString(4, ac.getDpiImagen());
            ejecutar.setString(5, ac.getEspecialidad());
            ejecutar.setString(6, ac.getFoto());
            ejecutar.setByte(7, ac.getNivel_acad_id());
            ejecutar.setString(8, ac.getUsuario_aso());
            ejecutar.setString(9, ac.getUsuario_contra());
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
    public String modificarAsociados(Asociados asociados) {
        try {
            cnb.abrirConexion();
            sql = "update asociados set antecedentes_penales=?, antecedentes_policiacos=?, dpiimagen=?, especialidad=?, fotografia=?, nivelacademico_id=?, usuario=?, password=? where asociado_id=?  ";
            ejecutar = cnb.getMiConexion().prepareStatement(sql);
            ejecutar.setString(1, ac.getAnte_penal());
            ejecutar.setString(2, ac.getAnte_penal());
            ejecutar.setString(3, ac.getAnte_poli());
            ejecutar.setString(4, ac.getDpiImagen());
            ejecutar.setString(5, ac.getEspecialidad());
            ejecutar.setString(6, ac.getFoto());
            ejecutar.setByte(7, ac.getNivel_acad_id());
            ejecutar.setString(7, ac.getUsuario_aso());
            ejecutar.setString(8, ac.getUsuario_contra());
            ContarRegistro = ejecutar.executeUpdate();
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


}
