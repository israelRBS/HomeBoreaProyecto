package dao;

import modelo.Departamentos;
import modelo.NivelesAcademicos;
import interfaces.NivelesAcademicosInterface;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class NivelesAcademicosDao implements NivelesAcademicosInterface {

    ConexionRandal cnb = new ConexionRandal();
    private String sql;
    private String mensaje;
    PreparedStatement ejecutar;
    ResultSet rs;

    @Override
    public NivelesAcademicos buscarNiveles(NivelesAcademicos nivelesAcademicos) {

        NivelesAcademicos nva = new NivelesAcademicos();
        try {
            cnb.abrirConexion();
            sql = "select * from  niveles_academicos where nivelacademico=?";
            ejecutar = cnb.getMiConexion().prepareStatement(sql);

            ejecutar.setByte(1, nivelesAcademicos.getNivel_acad_id());

            rs = ejecutar.executeQuery();

            if (rs.next()) {
                nva = new NivelesAcademicos();
                nva.setNivel_acad_id(rs.getByte("nivelacademico_id"));
                nva.setNombre(rs.getString("nombre"));
            }
            rs.close();

        } catch (SQLException e) {
            System.out.println("EROROR EN BUSCAR_NIVEL_ACADEMICO :" + e);
        } finally {
            cnb.cerrarConexion();
        }
        return nva;
    }

    @Override
    public ArrayList<NivelesAcademicos> listarNiveles() {
        NivelesAcademicos nva;
        ArrayList<NivelesAcademicos> listar = new ArrayList();
        try {
            cnb.abrirConexion();
            sql = "select * from niveles_academicos";
            ejecutar = cnb.getMiConexion().prepareStatement(sql);
            rs = ejecutar.executeQuery();
            while(rs.next()) {
                nva = new NivelesAcademicos();
                nva.setNivel_acad_id(rs.getByte("nivelacademico_id"));
                nva.setNombre(rs.getString("nombre"));
                listar.add(nva);
            }
            rs.close();
        } catch (SQLException e) {
            System.out.println("ERROR EN LISTAR_NIVELES_ACADEMICOS " + e);
        } finally {
            cnb.cerrarConexion();
        }
        return listar;
    }

    @Override
    public String eliminarNiveles(NivelesAcademicos nivelesAcademicos) {
        try {
            cnb.abrirConexion();
            sql = "delete * from niveles_academicos where nivelacademico_id=? ";
            ejecutar = cnb.getMiConexion().prepareStatement(sql);
            ejecutar.setByte(1, nivelesAcademicos.getNivel_acad_id());
            ejecutar.executeUpdate();
            mensaje = "Los datos se eliminaron";
        } catch (SQLException e) {
            mensaje = "Los datos no se eliminaron " + e;
        } finally {
            cnb.cerrarConexion();
        }
        return mensaje;
    }

    @Override
    public String agregarNiveles(NivelesAcademicos nivelesAcademicos) {
        try {
            cnb.abrirConexion();
            sql = "insert into niveles_academicos values(?,?) ";
            ejecutar = cnb.getMiConexion().prepareStatement(sql);
            ejecutar.setByte(1, nivelesAcademicos.getNivel_acad_id());
            ejecutar.setString(2, nivelesAcademicos.getNombre());
            ejecutar.executeUpdate();
            mensaje = "Los datos fueron almacenados ";
        } catch (SQLException e) {
            mensaje = "Los dato no se pueden almacenar " + e;
        } finally {
            cnb.cerrarConexion();
        }
        return mensaje;
    }

    @Override
    public String modificarNiveles(NivelesAcademicos nivelesAcademicos) {
        try {
            cnb.abrirConexion();
            sql = "update niveles_academicos set nombre=? where nivelacademico_id=?";
            ejecutar = cnb.getMiConexion().prepareStatement(sql);
            ejecutar.setByte(2, nivelesAcademicos.getNivel_acad_id());
            ejecutar.setString(1, nivelesAcademicos.getNombre());
            ejecutar.executeUpdate();
            mensaje = "Los datos fueron Modificados ";
        } catch (SQLException e) {
            mensaje = "ERROR EN  MODIFICAR " + e;
        } finally {
            cnb.cerrarConexion();
        }
        return mensaje;
    }

}
