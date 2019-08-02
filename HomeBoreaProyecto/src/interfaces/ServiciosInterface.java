/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package interfaces;

import modelo.Servicios;
import java.util.ArrayList;

/**
 *
 * @author Admin
 */
public interface ServiciosInterface {

    public String insertServicios(Servicios servicios);

    public String updateServicios(Servicios servicios);

    public String deleteServicios(Servicios servicios);

    public Servicios buscarServicios(int servicio_id);

    public ArrayList<Servicios> listarServicios();

}
