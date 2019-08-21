/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador;

import dao.GenerosDao;
import java.util.ArrayList;
import javax.swing.table.DefaultTableModel;
import modelo.Generos;
import vistas.JFrmVisibleGeneros;

/**
 *
 * @author edwin lezana raxon
 */
public class VistaGeneros {
    
      /* ISNTANCIANDO LA VISTA PARA OBTENER LA TABLA */
    JFrmVisibleGeneros vista;
    
    /* ISNTANCIANDO EL MODELO DE LA TABLA PARA UTILIZAR SUS ATRIBUTOS */
    Generos   prestados = new Generos();
    /* ISNTANCIANDO EL DAO PARA UTILIZAR CONSULTAS PREPARDAS  */
    GenerosDao dao = new GenerosDao();

    public VistaGeneros(JFrmVisibleGeneros vista) {
        this.vista = vista;
    }
    
    /* METODO PARA LISTAR Y OBTENER DATOS DE LA TABLA  */
    public void obtenerServiciosPrestados(){
        ArrayList<Generos> lista = dao.listarGeneros();
        DefaultTableModel modelo = (DefaultTableModel) vista.jTblListaGenero.getModel();
        Object[] filas = new Object[modelo.getColumnCount()];
        for (int i = 0; i < lista.size(); i++) {
            filas[0] = lista.get(i).getGenero_id();
            filas[1] = lista.get(i).getNombre();
            modelo.addRow(filas);
        }
    }
    
    /* METODO PARA LISTAR Y OBTENER DATOS DE LA TABLA  */
    public void vistaServiciosPrestados() {
        String[] titulos = {"ID_GENERO","NOMBRE"};
        DefaultTableModel modelo = new DefaultTableModel(titulos, 0);
        Object[] columnas = new Object[2];
        for (Generos generos : dao.listarGeneros()) {
            columnas[0] = generos.getGenero_id();
            columnas[1] = generos.getNombre();
            modelo.addRow(columnas);
        }
            this.vista.jTblListaGenero.setModel(modelo);
    }
}
