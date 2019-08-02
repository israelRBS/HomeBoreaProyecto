package modelo;
public class ServiciosMunicipios {
    private int servicio_muni_id;
    private int servicio_id;
    private short muni_id;

    public ServiciosMunicipios() {
    }

    public ServiciosMunicipios(int servicio_muni_id, int servicio_id, short muni_id) {
        this.servicio_muni_id = servicio_muni_id;
        this.servicio_id = servicio_id;
        this.muni_id = muni_id;
    }
    
    public int getServicio_muni_id() {
        return servicio_muni_id;
    }

    public void setServicio_muni_id(int servicio_muni_id) {
        this.servicio_muni_id = servicio_muni_id;
    }

    public int getServicio_id() {
        return servicio_id;
    }

    public void setServicio_id(int servicio_id) {
        this.servicio_id = servicio_id;
    }

    public short getMuni_id() {
        return muni_id;
    }

    public void setMuni_id(short muni_id) {
        this.muni_id = muni_id;
    }
    
}
