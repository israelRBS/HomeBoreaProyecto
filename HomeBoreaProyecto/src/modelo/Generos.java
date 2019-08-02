package modelo;

public class Generos {
    private int genero_id;
    private String nombre;

    public Generos() {
    }

    public Generos(int genero_id, String nombre) {
        this.genero_id = genero_id;
        this.nombre = nombre;
    }

    public int getGenero_id() {
        return genero_id;
    }

    public void setGenero_id(int genero_id) {
        this.genero_id = genero_id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    
    
}
