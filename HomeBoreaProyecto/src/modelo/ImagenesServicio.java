package modelo;
public class ImagenesServicio {
    private int imagenservicio_id;
    private int servicio_id;
    private String imagen;

    public ImagenesServicio() {
    }

    public ImagenesServicio(int imagenservicio_id, int servicio_id, String imagen) {
        this.imagenservicio_id = imagenservicio_id;
        this.servicio_id = servicio_id;
        this.imagen = imagen;
    }

    public int getImagenservicio_id() {
        return imagenservicio_id;
    }

    public void setImagenservicio_id(int imagenservicio_id) {
        this.imagenservicio_id = imagenservicio_id;
    }

    public int getServicio_id() {
        return servicio_id;
    }

    public void setServicio_id(int servicio_id) {
        this.servicio_id = servicio_id;
    }

    public String getImagen() {
        return imagen;
    }

    public void setImagen(String imagen) {
        this.imagen = imagen;
    }
    
}
