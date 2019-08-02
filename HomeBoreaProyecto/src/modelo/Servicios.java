package modelo;

public class Servicios {

    private int servicio_id;
    private int asociado_id;
    private int subcategoria_id;
    private short costo;
    private byte tipocosto_id;

    public Servicios(int servicio_id, int asociado_id, int subcategoria_id, short costo, byte tipocosto_id) {
        this.servicio_id = servicio_id;
        this.asociado_id = asociado_id;
        this.subcategoria_id = subcategoria_id;
        this.costo = costo;
        this.tipocosto_id = tipocosto_id;
    }

    public Servicios() {
    }

    public int getServicio_id() {
        return servicio_id;
    }

    public void setServicio_id(int servicio_id) {
        this.servicio_id = servicio_id;
    }

    public int getAsociado_id() {
        return asociado_id;
    }

    public void setAsociado_id(int asociado_id) {
        this.asociado_id = asociado_id;
    }

    public int getSubcategoria_id() {
        return subcategoria_id;
    }

    public void setSubcategoria_id(int subcategoria_id) {
        this.subcategoria_id = subcategoria_id;
    }

    public short getCosto() {
        return costo;
    }

    public void setCosto(short costo) {
        this.costo = costo;
    }

    public byte getTipocosto_id() {
        return tipocosto_id;
    }

    public void setTipocosto_id(byte tipocosto_id) {
        this.tipocosto_id = tipocosto_id;
    }

}
