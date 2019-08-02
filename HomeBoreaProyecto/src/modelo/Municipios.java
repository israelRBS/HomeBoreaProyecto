package modelo;
public class Municipios {
    private short municipio_id;
    private String nombre;
    private byte depa_id;

    public Municipios() {
    }

    public Municipios(short municipio_id, String nombre, byte depa_id) {
        this.municipio_id = municipio_id;
        this.nombre = nombre;
        this.depa_id = depa_id;
    }
    
    public short getMunicipio_id() {
        return municipio_id;
    }

    public void setMunicipio_id(short municipio_id) {
        this.municipio_id = municipio_id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public byte getDepa_id() {
        return depa_id;
    }

    public void setDepa_id(byte depa_id) {
        this.depa_id = depa_id;
    }
    
    
    
}
