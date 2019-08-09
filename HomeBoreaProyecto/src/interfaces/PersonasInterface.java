package interfaces;

import modelo.Personas;
import java.util.ArrayList;

public interface PersonasInterface {
    public Personas buscarPersonas(int personas);
    public ArrayList<Personas> listarPersonas();
    public String eliminarPersonas(int persona_id);
    public String insertarPersonas(Personas personas);
    public String modificarPersonas(Personas personas);
    
}
