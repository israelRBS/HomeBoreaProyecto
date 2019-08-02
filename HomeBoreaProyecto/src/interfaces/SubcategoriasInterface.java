/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package interfaces;

import modelo.Subcategorias;
import java.util.ArrayList;

/**
 *
 * @Edwin Estuardo Lezana
 */
public interface SubcategoriasInterface {

    public String insertSubcategia(Subcategorias sub);

    public String updateSubcategoria(Subcategorias sub);

    public String deleteSubcategoria(Subcategorias sub);

    public Subcategorias buscarSubcategoria(int sub_cate);

    public ArrayList<Subcategorias> listarSubcategorias();
}
