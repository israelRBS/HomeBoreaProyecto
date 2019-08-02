/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package interfaces;

import modelo.ImagenesServicio;
import java.util.ArrayList;

/**
 *
 * @Edwin Estuardo Lezana
 */
public interface ImageServiceInterface {

    public String saveImgService(ImagenesServicio img);

    public String updateService(ImagenesServicio img);

    public String deleteService(ImagenesServicio img);

    public ImagenesServicio buscarImgService(int img_service);

    public ArrayList<ImagenesServicio> listarImgServices();

}
