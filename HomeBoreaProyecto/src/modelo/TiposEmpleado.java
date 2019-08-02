package modelo;
public class TiposEmpleado {
    private int tipoempleado_id;
    private String nombre;

    public TiposEmpleado() {
    }

    public TiposEmpleado(int tipoempleado_id, String nombre) {
        this.tipoempleado_id = tipoempleado_id;
        this.nombre = nombre;
    }

    public int getTipoempleado_id() {
        return tipoempleado_id;
    }

    public void setTipoempleado_id(int tipoempleado_id) {
        this.tipoempleado_id = tipoempleado_id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    
    
    
}
