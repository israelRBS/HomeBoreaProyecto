/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador;

import dao.ImgServiceDao;
import java.util.ArrayList;
import javax.swing.table.DefaultTableModel;
import modelo.ImagenesServicio;
import vistas.JFrmVisibleImgServicios;

/**
 *
 * @author edwin lezana raxon
 */
public class VistaImagenesServicios {

    /* ISNTANCIANDO LA VISTA PARA OBTENER LA TABLA */
    JFrmVisibleImgServicios vista;
    /* ISNTANCIANDO EL MODELO DE LA TABLA PARA UTILIZAR SUS ATRIBUTOS */
    ImagenesServicio imgServicios = new ImagenesServicio();
    /* ISNTANCIANDO EL DAO PARA UTILIZAR CONSULTAS PREPARDAS  */
    ImgServiceDao dao = new ImgServiceDao();

    public VistaImagenesServicios(JFrmVisibleImgServicios vista) {
        this.vista = vista;
        vistaServiciosPrestados();
    }

    /* METODO PARA LISTAR Y OBTENER DATOS DE LA TABLA  */
    public void obtenerServiciosPrestados() {
        ArrayList<ImagenesServicio> lista = dao.listarImgServices();
        DefaultTableModel modelo = (DefaultTableModel) vista.JTblListaImganes.getModel();
        Object[] filas = new Object[modelo.getColumnCount()];
        for (int i = 0; i < lista.size(); i++) {
            filas[0] = lista.get(i).getImagenservicio_id();
            filas[1] = lista.get(i).getServicio_id();
            filas[2] = lista.get(i).getImagen();
            modelo.addRow(filas);
        }
    }

    /* METODO PARA LISTAR Y OBTENER DATOS DE LA TABLA  */
    public void vistaServiciosPrestados() {
        String[] titulos = {"ID_IMAGENES_SERVICIO", "ID_SERVICIO", "IMAGEN"};
        DefaultTableModel modelo = new DefaultTableModel(titulos, 0);
        Object[] columnas = new Object[3];
        for (ImagenesServicio servicios : dao.listarImgServices()) {
            columnas[0] = servicios.getImagenservicio_id();
            columnas[1] = servicios.getServicio_id();
            columnas[2] = servicios.getImagen();
            modelo.addRow(columnas);
        }
        this.vista.JTblListaImganes.setModel(modelo);
    }

}
