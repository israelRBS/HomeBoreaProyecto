package interfaces;

import modelo.Empleados;
import java.util.ArrayList;

public interface EmpleadosInterface {
    public Empleados buscarEmpleados(String usuario, String contraseña);
    public ArrayList<Empleados> listarEmpleados();
    public String eliminarEmpleados(Empleados empleado);
    public String insertarEmpleado(Empleados empleado);
    
    
    
    
    
    
}
