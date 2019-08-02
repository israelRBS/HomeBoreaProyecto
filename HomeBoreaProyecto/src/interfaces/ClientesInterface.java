package interfaces;

import modelo.Clientes;
import java.util.ArrayList;

public interface ClientesInterface {
    public Clientes buscarClientes(Clientes clientes);
    public ArrayList<Clientes> listarClientes();
    public String eliminarClientes(Clientes clientes);
    public String insertarClientes(Clientes clientes); 
    
}
