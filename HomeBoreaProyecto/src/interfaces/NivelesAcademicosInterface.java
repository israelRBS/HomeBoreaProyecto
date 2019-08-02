package interfaces;

import modelo.NivelesAcademicos;
import java.util.ArrayList;

public interface NivelesAcademicosInterface {

    public NivelesAcademicos buscarNiveles(NivelesAcademicos nivelesAcademicos);

    public ArrayList<NivelesAcademicos> listarNiveles();

    public String eliminarNiveles(NivelesAcademicos nivelesAcademicos);

    public String agregarNiveles(NivelesAcademicos nivelesAcademicos);

    public String modificarNiveles(NivelesAcademicos nivelesAcademicos);

}
