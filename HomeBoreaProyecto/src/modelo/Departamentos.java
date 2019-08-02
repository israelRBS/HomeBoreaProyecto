package modelo;
public class Departamentos {
    private byte depa_id;
    private String nombre;
    private byte region_id;

    public Departamentos() {
    }

    public Departamentos(byte depa_id, String nombre, byte region_id) {
        this.depa_id = depa_id;
        this.nombre = nombre;
        this.region_id = region_id;
    }
    
    public byte getDepa_id() {
        return depa_id;
    }

    public void setDepa_id(byte depa_id) {
        this.depa_id = depa_id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public byte getRegion_id() {
        return region_id;
    }

    public void setRegion_id(byte region_id) {
        this.region_id = region_id;
    }
    
}
