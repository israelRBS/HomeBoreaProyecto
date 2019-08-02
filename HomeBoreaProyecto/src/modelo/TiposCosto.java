package modelo;
public class TiposCosto {
    private byte tipocosto_id;
    private String descripcion;

    public TiposCosto(byte tipocosto_id, String descripcion) {
        this.tipocosto_id = tipocosto_id;
        this.descripcion = descripcion;
    }

    public TiposCosto() {
    }
    
    public byte getTipocosto_id() {
        return tipocosto_id;
    }

    public void setTipocosto_id(byte tipocosto_id) {
        this.tipocosto_id = tipocosto_id;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }
    
}
