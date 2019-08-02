package modelo;

public class Estados {
    private int estado_id;
    private String nombre;

    public Estados() {
    }

    public Estados(int estado_id, String nombre) {
        this.estado_id = estado_id;
        this.nombre = nombre;
    }

    public int getEstado_id() {
        return estado_id;
    }

    public void setEstado_id(int estado_id) {
        this.estado_id = estado_id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    
    
    
    
}
