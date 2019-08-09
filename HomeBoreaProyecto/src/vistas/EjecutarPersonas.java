package vistas;

import controlador.PersonasControlador;

public class EjecutarPersonas {
    public static void main(String[] args) {
        JFrmPersonas formulario = new JFrmPersonas();
        PersonasControlador controlador = new PersonasControlador(formulario);
        formulario.setVisible(true);
        
    }
    
}
