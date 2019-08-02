package interfaces;

import modelo.Regiones;
import java.util.ArrayList;

public interface RegionesInterface {
    public Regiones buscarRegiones(Regiones regiones);
    public ArrayList<Regiones> listarRegiones();
    public String eliminarRegiones(Regiones regiones);
    public String insertarRegiones(Regiones regiones);
    
}
