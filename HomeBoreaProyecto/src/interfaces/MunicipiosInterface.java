package interfaces;

import modelo.Municipios;
import java.util.ArrayList;

public interface MunicipiosInterface {
    public Municipios buscarMunicipios(Municipios municipios);
    public ArrayList<Municipios> listarMunicipios();
    public String eliminarMunicipios(Municipios municipios);
    public String agregarMunicipios(Municipios municipios);
    
}
