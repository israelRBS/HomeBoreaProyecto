/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package interfaces;

import modelo.ServiciosPrestados;
import java.util.ArrayList;

/**
 *
 * @author Admin
 */
public interface ServiciosPrestadosInterface {

    public String insertServiciosPrestados(ServiciosPrestados serviciosPrestados);

    public String updateServiciosPrestados(ServiciosPrestados serviciosPrestados);

    public String deleteServiciosPrestados(ServiciosPrestados serviciosPrestados);

    public ServiciosPrestados buscarServiciosPrestados(int servicioprestado_id);

    public ArrayList<ServiciosPrestados> listarServiciosPrestados();

}
