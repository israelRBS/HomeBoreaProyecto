/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador;

import dao.ClasServiciosDao;
import java.util.ArrayList;
import javax.swing.table.DefaultTableModel;
import modelo.ClasificacionesServicios;
import vistas.JFrmVisibleClasificacionServicios;

/**
 *
 * @author edwin lezana raxon
 */
public class VistaClasificacionServicios {

    /* ISNTANCIANDO LA VISTA PARA OBTENER LA TABLA */
    JFrmVisibleClasificacionServicios vista;

    /* ISNTANCIANDO EL MODELO DE LA TABLA PARA UTILIZAR SUS ATRIBUTOS */
    ClasServiciosDao dao = new ClasServiciosDao();
    /* ISNTANCIANDO EL DAO PARA UTILIZAR CONSULTAS PREPARDAS  */
    ClasificacionesServicios service = new ClasificacionesServicios();

    public VistaClasificacionServicios(JFrmVisibleClasificacionServicios vista) {
        this.vista = vista;
        vistaServiciosPrestados();
    }

    /* METODO PARA LISTAR Y OBTENER DATOS DE LA TABLA  */
    public void obtenerServiciosPrestados() {
        ArrayList<ClasificacionesServicios> lista = dao.listarClasificaciones();
        DefaultTableModel modelo = (DefaultTableModel) vista.jTblListaClasificaciones.getModel();
        Object[] filas = new Object[modelo.getColumnCount()];
        for (int i = 0; i < lista.size(); i++) {
            filas[0] = lista.get(i).getClasificacion_id();
            filas[1] = lista.get(i).getNombre();
            filas[2] = lista.get(i).getDescripcion();
            modelo.addRow(filas);
        }
    }

    /* METODO PARA LISTAR Y OBTENER DATOS DE LA TABLA  */
    public void vistaServiciosPrestados() {
        String[] titulos = {"ID_CLASIFICACION", "NOMBRE", "DESCRIPCION"};
        DefaultTableModel modelo = new DefaultTableModel(titulos, 0);
        Object[] columnas = new Object[3];
        for (ClasificacionesServicios servicios : dao.listarClasificaciones()) {
            columnas[0] = servicios.getClasificacion_id();
            columnas[1] = servicios.getNombre();
            columnas[2] = servicios.getDescripcion();
            modelo.addRow(columnas);
        }
        this.vista.jTblListaClasificaciones.setModel(modelo);
    }
}
