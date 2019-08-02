/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package interfaces;

import modelo.ServiciosMunicipios;
import java.util.ArrayList;

/**
 *
 * @author Admin
 */
public interface ServiciosMunicipiosInterface {
    
    
    
    public String insertServiciosMunicipios      (ServiciosMunicipios serviciosmunicipios);
    public String updateServiciosMunicipios     (ServiciosMunicipios serviciosmunicipios);
    public String deleteServiciosMunicipios     (ServiciosMunicipios serviciosmunicipios);
    
    public ServiciosMunicipios buscarServiciosMunicipios  (int servicio_muni_id);
    
    public ArrayList<ServiciosMunicipios> listarServiciosMunicipios ();
    

    
    
}
