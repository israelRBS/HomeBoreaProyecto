/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador;

import dao.ClientesDao;
import java.util.ArrayList;
import javax.swing.table.DefaultTableModel;
import modelo.Clientes;
import vistas.JFrmVisibleClientes;

/**
 *
 * @author edwin lezana raxon
 */
public class VistaCliente {
    
     /* ISNTANCIANDO LA VISTA PARA OBTENER LA TABLA */
    JFrmVisibleClientes vista;
    
    /* ISNTANCIANDO EL MODELO DE LA TABLA PARA UTILIZAR SUS ATRIBUTOS */
    Clientes  prestados = new Clientes();
    /* ISNTANCIANDO EL DAO PARA UTILIZAR CONSULTAS PREPARDAS  */
    ClientesDao dao = new ClientesDao();

    public VistaCliente(JFrmVisibleClientes vista) {
        this.vista = vista;
    }
    
    /* METODO PARA LISTAR Y OBTENER DATOS DE LA TABLA  */
    public void obtenerServiciosPrestados(){
        ArrayList<Clientes> lista = dao.listarClientes();
        DefaultTableModel modelo = (DefaultTableModel) vista.jTblListaClientes.getModel();
        Object[] filas = new Object[modelo.getColumnCount()];
        for (int i = 0; i < lista.size(); i++) {
            filas[0] = lista.get(i).getCliente_id();
            filas[1] = lista.get(i).getUsuario();
            filas[2] = lista.get(i).getContrasenia();
            modelo.addRow(filas);
        }
    }
    
    /* METODO PARA LISTAR Y OBTENER DATOS DE LA TABLA  */
    public void vistaServiciosPrestados() {
        String[] titulos = {"NO.CLIENTE","USUARIO","CONTRASEÑA"};
        DefaultTableModel modelo = new DefaultTableModel(titulos, 0);
        Object[] columnas = new Object[3];
        for (Clientes servicios : dao.listarClientes()) {
            columnas[0] = servicios.getCliente_id();
            columnas[1] = servicios.getUsuario();
            columnas[2] = servicios.getContrasenia();
            modelo.addRow(columnas);
        }
            this.vista.jTblListaClientes.setModel(modelo);
    }
   
}
