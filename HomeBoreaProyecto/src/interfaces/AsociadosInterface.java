package interfaces;

import modelo.Asociados;
import java.util.ArrayList;

public interface AsociadosInterface {
    public Asociados buscarAsociados(int asociado_id);
    public ArrayList<Asociados> listarAsociados();
    public String eliminarAsociados(Asociados asociados);
    public String insertarAsociados(Asociados asociados);
    public String modificarAsociados(Asociados asociados);
    
}
