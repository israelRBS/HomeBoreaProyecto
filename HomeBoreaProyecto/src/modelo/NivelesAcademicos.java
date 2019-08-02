package modelo;
public class NivelesAcademicos {
    private byte nivel_acad_id;
    private String nombre;

    public NivelesAcademicos() {
    }

    public NivelesAcademicos(byte nivel_acad_id, String nombre) {
        this.nivel_acad_id = nivel_acad_id;
        this.nombre = nombre;
    }
    
    public byte getNivel_acad_id() {
        return nivel_acad_id;
    }

    public void setNivel_acad_id(byte nivel_acad_id) {
        this.nivel_acad_id = nivel_acad_id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    
    
}
