package modelo;
public class ClasificacionesServicios {
    private byte clasificacion_id;
    private String nombre;
    private String descripcion;

    public ClasificacionesServicios() {
    }

    public ClasificacionesServicios(byte clasificacion_id, String nombre, String descripcion) {
        this.clasificacion_id = clasificacion_id;
        this.nombre = nombre;
        this.descripcion = descripcion;
    }
    
    public byte getClasificacion_id() {
        return clasificacion_id;
    }

    public void setClasificacion_id(byte clasificacion_id) {
        this.clasificacion_id = clasificacion_id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }
    
    
}
