/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package interfaces;

import java.util.ArrayList;
import modelo.Generos;

/**
 *
 * @author Admin
 */
public interface GenerosInterface {
    
    public ArrayList<Generos> listarGeneros();
    
    public String guardarGenero(Generos genero);
    
    public String modificarGenero(Generos genero);
    
    public String eliminarGenero(Generos genero);
    
    public Generos buscar(Generos genero);
    
}
