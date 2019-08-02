package interfaces;

import modelo.Categorias;
import java.util.ArrayList;

/**
 *
 * @Edwin Estuardo Lezana
 */
public interface CategoriasInterface {

    public String guardarCategoria(Categorias cate);

    public String updateCategoria(Categorias cate);

    public String eliminarCategoria(Categorias cate);

    public Categorias buscarCategorias(int categoria_id);

    public ArrayList<Categorias> listarCategorias();

}
