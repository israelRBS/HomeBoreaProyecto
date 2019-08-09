package vistas;

import controlador.RegionesControlador;

public class EjecutarRegiones {
    public static void main(String[] args) {
        VistaRegiones formulario = new VistaRegiones();
        RegionesControlador controlador = new RegionesControlador(formulario);
        formulario.setVisible(true);
    }
}
