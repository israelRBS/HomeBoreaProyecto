package interfaces;

import modelo.Regiones;
import java.util.ArrayList;

public interface RegionesInterface {
    public Regiones buscarRegiones(int regiones);
    public ArrayList<Regiones> listarRegiones();
    public String eliminarRegiones(Regiones regiones);
    public String insertarRegiones(Regiones regiones);
    public String modificarRegiones(Regiones regiones);
    
}
