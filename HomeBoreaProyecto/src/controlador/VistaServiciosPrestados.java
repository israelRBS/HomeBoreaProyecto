/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador;

import dao.ServiciosPrestadosDao;
import java.awt.event.ActionListener;
import java.awt.event.MouseListener;
import java.util.ArrayList;
import javax.swing.table.DefaultTableModel;
import modelo.ServiciosPrestados;
import vistas.JFrmVisibleServiciosPrestados;

/**
 *
 * @author edwin lezana raxon
 */
public class VistaServiciosPrestados  {

    /* ISNTANCIANDO LA VISTA PARA OBTENER LA TABLA */
    JFrmVisibleServiciosPrestados vista;
    /* ISNTANCIANDO EL MODELO DE LA TABLA PARA UTILIZAR SUS ATRIBUTOS */
    ServiciosPrestados servicioPrestado = new ServiciosPrestados();
    /* ISNTANCIANDO EL DAO PARA UTILIZAR CONSULTAS PREPARDAS  */
    ServiciosPrestadosDao dao = new ServiciosPrestadosDao();

    public VistaServiciosPrestados(JFrmVisibleServiciosPrestados vista) {
        this.vista = vista;
        //this.vista.jTblListarServiciosPrestados.addAncestorListener(this);
        vistaServiciosPrestados();
    }

    /* METODO PARA LISTAR Y OBTENER DATOS DE LA TABLA  */
    public void obtenerServiciosPrestados(){
        ArrayList<ServiciosPrestados> lista = dao.listarServiciosPrestados();
        DefaultTableModel modelo = (DefaultTableModel) vista.jTblListarServiciosPrestados.getModel();
        Object[] filas = new Object[modelo.getColumnCount()];
        for (int i = 0; i < lista.size(); i++) {
            filas[0] = lista.get(i).getServicioprestado_id();
            filas[1] = lista.get(i).getCliente_id();
            filas[2] = lista.get(i).getServicio_id();
            filas[3] = lista.get(i).getCalificacion_cliente();
            filas[4] = lista.get(i).getDescripcion_cliente();
            filas[5] = lista.get(i).getCalificacion_asociado();
            filas[6] = lista.get(i).getDescripcion_asociado();
            modelo.addRow(filas);
        }
    }
    
    /* METODO PARA LISTAR Y OBTENER DATOS DE LA TABLA  */
    public void vistaServiciosPrestados() {
        String[] titulos = {"NO.SERVICIO_PRESTADO", "NO.CLIENTE", "NO.SERVICIO", "CALIFICACION_CLIENTE", "DESCRIPCION_CLIENTE", "CALIFICACION_ASOCIADO", "DESCRIPCION_ASOCIADO"};
        DefaultTableModel modelo = new DefaultTableModel(titulos, 0);
        Object[] columnas = new Object[7];
        for (ServiciosPrestados servicios : dao.listarServiciosPrestados()) {
            columnas[0] = servicios.getServicioprestado_id();
            columnas[1] = servicios.getCliente_id();
            columnas[2] = servicios.getServicio_id();
            columnas[3] = servicios.getCalificacion_cliente();
            columnas[4] = servicios.getDescripcion_cliente();
            columnas[5] = servicios.getCalificacion_asociado();
            columnas[6] = servicios.getDescripcion_asociado();
            modelo.addRow(columnas);
        }
            this.vista.jTblListarServiciosPrestados.setModel(modelo);
    }

}
