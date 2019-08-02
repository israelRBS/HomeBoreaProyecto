package modelo;
public class Clientes {
    private int cliente_id;
    private String usuario;
    private String contrasenia;

    public Clientes() {
    }

    public Clientes(int cliente_id, String usuario, String contrasenia) {
        this.cliente_id = cliente_id;
        this.usuario = usuario;
        this.contrasenia = contrasenia;
    }
    public int getCliente_id() {
        return cliente_id;
    }

    public void setCliente_id(int cliente_id) {
        this.cliente_id = cliente_id;
    }

    public String getUsuario() {
        return usuario;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

    public String getContrasenia() {
        return contrasenia;
    }

    public void setContrasenia(String contrasenia) {
        this.contrasenia = contrasenia;
    }

    
    
    
}
