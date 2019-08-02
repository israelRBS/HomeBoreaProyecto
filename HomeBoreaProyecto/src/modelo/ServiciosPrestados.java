package modelo;
public class ServiciosPrestados {
    
    private int servicioprestado_id;
    private int cliente_id;
    private int servicio_id;
    private byte calificacion_cliente;
    private String descripcion_cliente;
    private byte calificacion_asociado;
    private String descripcion_asociado;

    public ServiciosPrestados() {
    }

    public ServiciosPrestados(int servicioprestado_id, int cliente_id, int servicio_id, byte calificacion_cliente, String descripcion_cliente, byte calificacion_asociado, String descripcion_asociado) {
        this.servicioprestado_id = servicioprestado_id;
        this.cliente_id = cliente_id;
        this.servicio_id = servicio_id;
        this.calificacion_cliente = calificacion_cliente;
        this.descripcion_cliente = descripcion_cliente;
        this.calificacion_asociado = calificacion_asociado;
        this.descripcion_asociado = descripcion_asociado;
    }
    
    public int getServicioprestado_id() {
        return servicioprestado_id;
    }

    public void setServicioprestado_id(int servicioprestado_id) {
        this.servicioprestado_id = servicioprestado_id;
    }

    public int getCliente_id() {
        return cliente_id;
    }

    public void setCliente_id(int cliente_id) {
        this.cliente_id = cliente_id;
    }

    public int getServicio_id() {
        return servicio_id;
    }

    public void setServicio_id(int servicio_id) {
        this.servicio_id = servicio_id;
    }

    public byte getCalificacion_cliente() {
        return calificacion_cliente;
    }

    public void setCalificacion_cliente(byte calificacion_cliente) {
        this.calificacion_cliente = calificacion_cliente;
    }

    public String getDescripcion_cliente() {
        return descripcion_cliente;
    }

    public void setDescripcion_cliente(String descripcion_cliente) {
        this.descripcion_cliente = descripcion_cliente;
    }

    public byte getCalificacion_asociado() {
        return calificacion_asociado;
    }

    public void setCalificacion_asociado(byte calificacion_asociado) {
        this.calificacion_asociado = calificacion_asociado;
    }

    public String getDescripcion_asociado() {
        return descripcion_asociado;
    }

    public void setDescripcion_asociado(String descripcion_asociado) {
        this.descripcion_asociado = descripcion_asociado;
    }
    
    
}
