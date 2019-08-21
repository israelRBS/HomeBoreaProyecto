/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador;

import dao.ServiciosMunicipiosDao;
import java.util.ArrayList;
import javax.swing.table.DefaultTableModel;
import modelo.ServiciosMunicipios;
import vistas.JFrmVisibleServiciosMunicipios;

/**
 *
 * @author edwin lezana raxon
 */
public class VistaServiciosMunicipios {
    
    /* ISNTANCIANDO LA VISTA PARA OBTENER LA TABLA */
    JFrmVisibleServiciosMunicipios vista;
    
    /* ISNTANCIANDO EL MODELO DE LA TABLA PARA UTILIZAR SUS ATRIBUTOS */
    ServiciosMunicipios servicioMuni = new ServiciosMunicipios();
    /* ISNTANCIANDO EL DAO PARA UTILIZAR CONSULTAS PREPARDAS  */
    ServiciosMunicipiosDao dao = new ServiciosMunicipiosDao();

    public VistaServiciosMunicipios(JFrmVisibleServiciosMunicipios vista) {
        this.vista = vista;
    }
    
    /* METODO PARA LISTAR Y OBTENER DATOS DE LA TABLA  */
    public void obtenerServiciosPrestados(){
        ArrayList<ServiciosMunicipios> lista = dao.listarServiciosMunicipios();
        DefaultTableModel modelo = (DefaultTableModel) vista.jTblListarServiciosMunicipios.getModel();
        Object[] filas = new Object[modelo.getColumnCount()];
        for (int i = 0; i < lista.size(); i++) {
            filas[0] = lista.get(i).getServicio_muni_id();
            filas[1] = lista.get(i).getServicio_id();
            filas[2] = lista.get(i).getMuni_id();
            modelo.addRow(filas);
        }
    }
    
    /* METODO PARA LISTAR Y OBTENER DATOS DE LA TABLA  */
    public void vistaServiciosPrestados() {
        String[] titulos = {"NO.SERVICIO_MUNICIPIO","NO.SERVICIO","ID.MUNICIPIO"};
        DefaultTableModel modelo = new DefaultTableModel(titulos, 0);
        Object[] columnas = new Object[3];
        for (ServiciosMunicipios servicios : dao.listarServiciosMunicipios()) {
            columnas[0] = servicios.getServicio_muni_id();
            columnas[1] = servicios.getServicio_id();
            columnas[2] = servicios.getMuni_id();
            modelo.addRow(columnas);
        }
            this.vista.jTblListarServiciosMunicipios.setModel(modelo);
    }   
}
