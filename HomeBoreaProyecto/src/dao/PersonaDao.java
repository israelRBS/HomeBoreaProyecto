package dao;

import modelo.Personas;
import interfaces.PersonasInterface;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class PersonaDao implements PersonasInterface {

    private ConexionBorea cnb = new ConexionBorea();
    private Personas p = new Personas();
    private String sql;
    private PreparedStatement ejecutar;
    private String mensaje;
    private ResultSet rs;
    private int contarRegistro = 0;

    @Override
    public Personas buscarPersonas(int persona_id) {
        Personas p = new Personas();
        try {
            cnb.abrirConexion();
            sql = "select * from personas where persona_id=? ";
            ejecutar = cnb.getMiConexion().prepareStatement(sql);
            rs = ejecutar.executeQuery();

            rs.next();
            p.setPersona_id(rs.getInt("persona_id"));
            p.setNombre(rs.getString("nombre"));
            p.setApellido(rs.getString("apellido"));
            p.setCorreo(rs.getString("correo"));
            p.setDireccion(rs.getString("direccion"));
            p.setDpi(rs.getLong("dpi"));
            p.setTelefono(rs.getInt("telefono"));
            p.setEstado_id(rs.getInt("estado_id"));
            p.setGenero_id(rs.getInt("genero_id"));

        } catch (SQLException e) {
            System.out.println("ERROR EN BUSCAR PERSONAS_DAO " + e);
        } finally {
            cnb.cerrarConexion();
        }
        return p;
    }

    @Override
    public ArrayList<Personas> listarPersonas() {
        Personas p;
        ArrayList<Personas> lista = new ArrayList();

        try {
            cnb.abrirConexion();
            sql = "SELECT * FROM personas";
            ejecutar = cnb.getMiConexion().prepareStatement(sql);
            rs = ejecutar.executeQuery();

            while (rs.next()) {
                p = new Personas();
                p.setPersona_id(rs.getInt("persona_id"));
                p.setNombre(rs.getString("nombre"));
                p.setApellido(rs.getString("apellido"));
                p.setCorreo(rs.getString("correo"));
                p.setDireccion(rs.getString("direccion"));
                p.setDpi(rs.getLong("dpi"));
                p.setTelefono(rs.getInt("telefono"));
                p.setEstado_id(rs.getInt("estado_id"));
                p.setGenero_id(rs.getInt("genero_id"));
                lista.add(p);
            }
            rs.close();
        } catch (Exception e) {
            System.out.println("Erro en Lista_Personas"+e);
        } finally {
            cnb.cerrarConexion();
        }
        return lista;
    }

    @Override
    public String eliminarPersonas(int p) {
        Personas per = new Personas();
        try {
            cnb.abrirConexion();
            sql = "DELETE FROM personas WHERE persona_id=?";
            ejecutar = cnb.getMiConexion().prepareStatement(sql);
            ejecutar.setInt(1, per.getPersona_id());
            ejecutar.executeUpdate();
            mensaje = "El registro se elimino";
        } catch (Exception e) {
            mensaje = "No se pueden eliminar los registros" + e;
        } finally {
            cnb.cerrarConexion();
        }
        return mensaje;
    }

    @Override
    public String insertarPersonas(Personas p) {
        try {
            cnb.abrirConexion();
            sql = "INSERT INTO personas VALUES (?,?,?,?,?,?,?,?,?)";
            ejecutar = cnb.getMiConexion().prepareStatement(sql);
            ejecutar.setInt(1, p.getPersona_id());
            ejecutar.setString(2, p.getNombre());
            ejecutar.setString(3, p.getApellido());
            ejecutar.setString(4, p.getCorreo());
            ejecutar.setString(5, p.getDireccion());
            ejecutar.setLong(6, p.getDpi());
            ejecutar.setInt(7, p.getTelefono());
            ejecutar.setInt(8, p.getEstado_id());
            ejecutar.setInt(9, p.getGenero_id());
            contarRegistro = ejecutar.executeUpdate();
            
            if (contarRegistro == 0) {
                mensaje = "El registro es invalido, ingrese un registro valido";
            }else{
                mensaje = "Los registros se agregaron exitosamente";
            }
        } catch (Exception e) {
            System.out.println("Erro al insertar los registros "+e);
        }finally{
            cnb.cerrarConexion();
        }
        return mensaje;
    }

    @Override
    public String modificarPersonas(Personas p) {
        try {
            cnb.abrirConexion();
            sql = "UPDATE personas SET nombre=?, apellido=?, correo=?, direccion=?, dpi=?, telefono=?, estado_id=?, genero_id=? WHERE persona_id=?  ";
            ejecutar = cnb.getMiConexion().prepareStatement(sql);
            ejecutar.setString(1, p.getNombre());
            ejecutar.setString(2, p.getApellido());
            ejecutar.setString(3, p.getCorreo());
            ejecutar.setString(4, p.getDireccion());
            ejecutar.setLong(5, p.getDpi());
            ejecutar.setInt(6, p.getTelefono());
            ejecutar.setInt(7, p.getEstado_id());
            ejecutar.setInt(8, p.getGenero_id());
            ejecutar.setInt(8, p.getPersona_id());
            contarRegistro = ejecutar.executeUpdate();
            
            if (contarRegistro == 0) {
                mensaje = "Los registros no se encontraron";
            }else{
                mensaje = "Los registros se Actualizarón ";
            }
        } catch (Exception e) {
            System.out.println("Los registro no se pueden actualizar "+e);
        }finally{
            cnb.cerrarConexion();
        }
        return mensaje;
    }

}
