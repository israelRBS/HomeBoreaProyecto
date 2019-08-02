package interfaces;

import modelo.TiposEmpleado;
import java.util.ArrayList;

public interface TiposEmpleadoInterface {

    public TiposEmpleado buscarTipEmpleado(TiposEmpleado tiposEmpleado);

    public ArrayList<TiposEmpleado> listarTipEmpleado();

    public String eliminarTipEmpleado(TiposEmpleado tiposEmpleado);

    public String insertarTipEmpleado(TiposEmpleado tiposEmpleado);

    public String modificarEmpleado(TiposEmpleado tiposEmpleado);

}
