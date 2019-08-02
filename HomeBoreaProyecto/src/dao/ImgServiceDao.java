/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import modelo.ImagenesServicio;
import interfaces.ImageServiceInterface;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 *
 * @author Admin
 */
public class ImgServiceDao implements ImageServiceInterface {

    private String mensaje;
    private String mysql;
    private PreparedStatement ejecutar;
    private ResultSet seleccionar;
    private int registrosAfectados = 0;

    ConexionBorea conex = new ConexionBorea();

    @Override
    public String saveImgService(ImagenesServicio img) {
        try {
            conex.abrirConexion();

            mysql = "insert into imageners_servicios values(?,?,?)";

            ejecutar = conex.getMiConexion().prepareStatement(mysql);

            ejecutar.setInt(1, img.getImagenservicio_id());
            ejecutar.setInt(2, img.getServicio_id());
            ejecutar.setString(3, img.getImagen());

            registrosAfectados = ejecutar.executeUpdate();

            if (registrosAfectados == 0) {
                mensaje = "NO SE ENCONTRO BASE_DATOS ";
            } else {
                mensaje = "IMGAGEN ALMACENADA";
            }
        } catch (Exception e) {
            mensaje = "ERROR EN DAO_IMAGE_SERVICE_DAO : " + e;
        } finally {
            conex.cerrarConexion();
        }
        return mensaje;
    }

    @Override
    public String updateService(ImagenesServicio img) {
        try {
            conex.abrirConexion();

            mysql = "update imagenes_servicios set servicos_id=?, imagene=? where imagenservicio=?";

            ejecutar = conex.getMiConexion().prepareStatement(mysql);

            ejecutar.setInt(1, img.getServicio_id());
            ejecutar.setString(2, img.getImagen());
            ejecutar.setInt(3, img.getImagenservicio_id());

            registrosAfectados = ejecutar.executeUpdate();

            if (registrosAfectados == 0) {
                mensaje = "NO SE ENCONTRO EL REGISTRO ";
            } else {
                mensaje = "REGISTRO MODIFICADO ";
            }
        } catch (Exception e) {
            mensaje = "ERORR EN DAO_IMAGE_SERVICE : " + e;
        } finally {
            conex.cerrarConexion();
        }
        return mensaje;
    }

    @Override
    public String deleteService(ImagenesServicio img) {

        try {
            conex.abrirConexion();

            mysql = "delete from imagenes_servicios where imagenservicio=?";

            ejecutar = conex.getMiConexion().prepareStatement(mysql);

            ejecutar.setInt(1, img.getImagenservicio_id());

            registrosAfectados = ejecutar.executeUpdate();

            if (registrosAfectados == 0) {
                mensaje = "NO SE ENCONTRO EL REGISTRO";
            } else {
                mensaje = "REGISTRO ELIMINADO";
            }
        } catch (Exception e) {
            mensaje = "REGISTRO ELIMINADO " + e;
        } finally {
            conex.cerrarConexion();
        }
        return mensaje;
    }

    @Override
    public ImagenesServicio buscarImgService(int img_service) {

        ImagenesServicio service = new ImagenesServicio();

        try {
            conex.abrirConexion();
            mysql = "select * from imagenes_servicios where imagenservicio="+img_service;
            ejecutar = conex.getMiConexion().prepareStatement(mysql);
            
            seleccionar = ejecutar.executeQuery();
            
            while(seleccionar.next()){
                
                service.setImagenservicio_id(seleccionar.getInt("imagenservicio"));
                service.setServicio_id(seleccionar.getInt("servicos_id"));
                service.setImagen(seleccionar.getString("imagene"));
                
            }
            ejecutar.close();
            
            
        } catch (Exception e) {
            System.out.println("ERROR EN BUSQUEDA_IMG_SERVICIO");
            
        } finally {
            conex.cerrarConexion();
        }

        return service;
    }

    @Override
    public ArrayList<ImagenesServicio> listarImgServices() {
       
        ImagenesServicio ser;
        ArrayList<ImagenesServicio> lista = new ArrayList();
        
        try {
            conex.abrirConexion();
            mysql="select * from imagenes_servicios";
            
            ejecutar = conex.getMiConexion().prepareStatement(mysql);
            
            seleccionar = ejecutar.executeQuery();
            
            while(seleccionar.next()){
                ser = new ImagenesServicio();
                
                ser.setImagenservicio_id(seleccionar.getInt("imagenservicio"));
                ser.setServicio_id(seleccionar.getInt("servicos_id"));
                ser.setImagen(seleccionar.getString("imagene"));
                
               lista.add(ser);  
            }
            
            ejecutar.close();
            
        } 
        catch (SQLException e) {
            System.out.println("ERROR EN DAO_LISTA_SERVICIOS"+e);
        }
        finally{
            conex.cerrarConexion();
        }
        
        return lista;
        
    }

}
