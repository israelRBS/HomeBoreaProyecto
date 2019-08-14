/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import java.util.ArrayList;
import modelo.Subcategorias;

/**
 *
 * @author Admin
 */
public class Pruebas {

    public static void main(String[] args) {
        SubcategoriaDao dao = new SubcategoriaDao();
        ArrayList<Subcategorias> listaCategoria = new ArrayList<Subcategorias>();
        listaCategoria = dao.listarSubcategorias();
        for (Subcategorias subcategorias : listaCategoria) {
            System.out.println(subcategorias.toString());
        }
    }
}
