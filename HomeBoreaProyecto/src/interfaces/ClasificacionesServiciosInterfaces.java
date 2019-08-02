package interfaces;

import modelo.ClasificacionesServicios;
import java.util.ArrayList;

public interface ClasificacionesServiciosInterfaces {
    public ClasificacionesServicios buscarClasificacionesServicios(ClasificacionesServicios clasificacionesServicios);
    public ArrayList<ClasificacionesServicios> listarClasificaciones();
    public String eliminarClasificaciones(ClasificacionesServicios clasificacionesServicios);
    public String agregarClasificaciones(ClasificacionesServicios clasificacionesServicios);
    
}
