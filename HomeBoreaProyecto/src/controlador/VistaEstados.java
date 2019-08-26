/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador;

import dao.EstadosDao;
import java.util.ArrayList;
import javax.swing.table.DefaultTableModel;
import modelo.Estados;
import vistas.JFrmVisibleEstados;

/**
 *
 * @author edwin lezana raxon
 */
public class VistaEstados {
    
      /* ISNTANCIANDO LA VISTA PARA OBTENER LA TABLA */
    JFrmVisibleEstados vista;
    
    /* ISNTANCIANDO EL MODELO DE LA TABLA PARA UTILIZAR SUS ATRIBUTOS */
    Estados  estado = new Estados();
    /* ISNTANCIANDO EL DAO PARA UTILIZAR CONSULTAS PREPARDAS  */
    EstadosDao dao = new EstadosDao();

    public VistaEstados(JFrmVisibleEstados vista) {
        this.vista = vista;
        vistaServiciosPrestados();
    }
    
    /* METODO PARA LISTAR Y OBTENER DATOS DE LA TABLA  */
    public void obtenerServiciosPrestados(){
        ArrayList<Estados> lista = dao.listarEstados();
        DefaultTableModel modelo = (DefaultTableModel) vista.jTblListaEstados.getModel();
        Object[] filas = new Object[modelo.getColumnCount()];
        for (int i = 0; i < lista.size(); i++) {
            filas[0] = lista.get(i).getEstado_id();
            filas[1] = lista.get(i).getNombre();
            modelo.addRow(filas);
        }
    }
    
    /* METODO PARA LISTAR Y OBTENER DATOS DE LA TABLA  */
    public void vistaServiciosPrestados() {
        String[] titulos = {"ID_ESTADO","NOMBRE"};
        DefaultTableModel modelo = new DefaultTableModel(titulos, 0);
        Object[] columnas = new Object[3];
        for (Estados estado : dao.listarEstados()) {
            columnas[0] = estado.getEstado_id();
            columnas[1] = estado.getNombre();
            modelo.addRow(columnas);
        }
            this.vista.jTblListaEstados.setModel(modelo);
    }
}
