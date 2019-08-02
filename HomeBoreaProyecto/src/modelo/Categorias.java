package modelo;
public class Categorias {
    private byte categoria_id;
    private String nombre;
    private int empleado_id;

    public Categorias() {
    }

    public Categorias(byte categoria_id, String nombre, int empleado_id) {
        this.categoria_id = categoria_id;
        this.nombre = nombre;
        this.empleado_id = empleado_id;
    }
    
    public byte getCategoria_id() {
        return categoria_id;
    }

    public void setCategoria_id(byte categoria_id) {
        this.categoria_id = categoria_id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getEmpleado_id() {
        return empleado_id;
    }

    public void setEmpleado_id(int empleado_id) {
        this.empleado_id = empleado_id;
    }
    
    
}
