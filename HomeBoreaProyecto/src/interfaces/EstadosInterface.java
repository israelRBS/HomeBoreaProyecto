/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package interfaces;

import java.util.ArrayList;
import modelo.Estados;

/**
 *
 * @author Admin
 */
public interface EstadosInterface {

    public String guardarEstados(Estados estado);

    public String modificarEstado(Estados estado);

    public String eliminarEstado(Estados estado);

    public Estados buscarEstado(Estados estado);

    public ArrayList<Estados> listarEstados();

}
