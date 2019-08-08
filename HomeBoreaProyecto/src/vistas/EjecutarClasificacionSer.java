package vistas;

import controlador.ClasificacionServiciosControlador;

public class EjecutarClasificacionSer {

    public static void main(String[] args) {
        JFrmClasificacionServicios vista = new JFrmClasificacionServicios();
        ClasificacionServiciosControlador controlador = new ClasificacionServiciosControlador(vista);
        vista.setVisible(true);

    }

}
