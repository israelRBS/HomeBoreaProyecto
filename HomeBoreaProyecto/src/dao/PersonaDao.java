package dao;

import modelo.Personas;
import interfaces.PersonasInterface;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class PersonaDao implements PersonasInterface {
    ConexionBorea cnb = new ConexionBorea();
    Personas p = new Personas();
    private String sql;
    PreparedStatement ejecutar;
    private String mensaje = null;
    ResultSet rs;
    

    @Override
    public Personas buscarPersonas(Personas personas) {
        try {
            cnb.abrirConexion();
            sql = "select * from personas where persona_id=? ";
            ejecutar = cnb.getMiConexion().prepareStatement(sql);
            ejecutar.setInt(1, p.getPersona_id());
            
            rs = ejecutar.executeQuery();
            
            while(rs.next()){
                
            }
            
        } catch (SQLException e) {
            System.out.println("ERROR EN BUSCAR PERSONAS_DAO "+e);
        }finally{
            cnb.cerrarConexion();
        }
        return p;
    }

    @Override
    public ArrayList<Personas> listarPersonas() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public String eliminarPersonas(Personas personas) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public String insertarPersonas(Personas personas) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public String modificarPersonas(Personas personas) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
