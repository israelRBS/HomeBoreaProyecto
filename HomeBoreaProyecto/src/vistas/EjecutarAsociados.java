package vistas;

import controlador.AsociadosControlador;


public class EjecutarAsociados {
    public static void main(String[] args) {
        VistaAsociados formulario = new VistaAsociados();
        AsociadosControlador controlador = new AsociadosControlador(formulario);
    }
    
}
