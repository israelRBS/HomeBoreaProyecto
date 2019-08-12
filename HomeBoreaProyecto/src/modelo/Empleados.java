package modelo;
public class Empleados {
    private int empleado_id;
    private String usuario;
    private String contraseña;
    private int tipoempleado_id;

    public Empleados() {
    }

    public Empleados(int empleado_id, String usuario, String contraseña, int tipoempleado_id) {
        this.empleado_id = empleado_id;
        this.usuario = usuario;
        this.contraseña = contraseña;
        this.tipoempleado_id = tipoempleado_id;
    }
    public int getEmpleado_id() {
        return empleado_id;
    }

    public void setEmpleado_id(int empleado_id) {
        this.empleado_id = empleado_id;
    }

    public String getUsuario() {
        return usuario;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

    public String getContraseña() {
        return contraseña;
    }

    public void setContraseña(String contraseña) {
        this.contraseña = contraseña;
    }

    public int getTipoempleado_id() {
        return tipoempleado_id;
    }

    public void setTipoempleado_id(int tipoempleado_id) {
        this.tipoempleado_id = tipoempleado_id;
    }

    @Override
    public String toString() {
        return "Empleados{" + "empleado_id=" + empleado_id + ", usuario=" + usuario + ", contrase\u00f1a=" + contraseña + ", tipoempleado_id=" + tipoempleado_id + '}';
    }
    
}
