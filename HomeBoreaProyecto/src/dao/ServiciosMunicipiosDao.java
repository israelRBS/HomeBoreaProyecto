/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import modelo.ServiciosMunicipios;
import interfaces.ServiciosMunicipiosInterface;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 *
 * @author Admin
 */
public class ServiciosMunicipiosDao implements ServiciosMunicipiosInterface {

    ConexionBorea conex = new ConexionBorea();
    private PreparedStatement ejecutar;
    private ResultSet resultadoSelect;

    private String mensaje;
    private String sql;
    private int contarRegistros = 0;

    @Override
    public String insertServiciosMunicipios(ServiciosMunicipios serviciosmunicipios) {
        try {
            conex.abrirConexion();
            sql = "INSERT INTO servicios_municipios  values(?,?,?)";
            ejecutar = conex.getMiConexion().prepareStatement(sql);

            ejecutar.setInt(1, serviciosmunicipios.getServicio_muni_id());
            ejecutar.setInt(2, serviciosmunicipios.getServicio_id());
            ejecutar.setInt(3, serviciosmunicipios.getMuni_id());

            contarRegistros = ejecutar.executeUpdate();

            if (contarRegistros == 0) {
                mensaje = "No se puede registrar";
            } else {
                mensaje = "Registro realizado con exito";
            }

        } catch (Exception e) {
            mensaje = "LOS DATOS NO FUERON GUARDARON" + e;
        } finally {
            conex.cerrarConexion();
        }
        return mensaje;

    }

    @Override
    public String updateServiciosMunicipios(ServiciosMunicipios serviciosmunicipios) {
        try {
            conex.abrirConexion();
            sql = "update servicios_municipios  set servicio_id=?, muni_id=?  where serviciomunicipio_id=?";
            ejecutar = conex.getMiConexion().prepareStatement(sql);

            ejecutar.setInt(1, serviciosmunicipios.getServicio_muni_id());
            ejecutar.setInt(2, serviciosmunicipios.getServicio_id());
            ejecutar.setInt(3, serviciosmunicipios.getMuni_id());

            contarRegistros = ejecutar.executeUpdate();

            if (contarRegistros == 0) {
                mensaje = "No se puede registrar";
            } else {
                mensaje = "Registro realizado con exito";
            }

        } catch (Exception e) {
            mensaje = "LOS DATOS NO FUERON MODIFICARON" + e;
        } finally {
            conex.cerrarConexion();
        }
        return mensaje;
    }

    @Override
    public String deleteServiciosMunicipios(ServiciosMunicipios serviciosmunicipios) {
        try {
            conex.abrirConexion();
            sql = "DELETE FROM servicios_municipios  where serviciomunicipio_id=?";
            ejecutar = conex.getMiConexion().prepareStatement(sql);

            ejecutar.setInt(1, serviciosmunicipios.getServicio_muni_id());

            contarRegistros = ejecutar.executeUpdate();

            if (contarRegistros == 0) {
                mensaje = "NO SE ENCONTRO EL REGISTRO";
            } else {
                mensaje = "DATOS ELIMINADOS";
            }

        } catch (Exception e) {
            mensaje = "LOS DATOS NO SE ELIMINARON" + e;
        } finally {
            conex.cerrarConexion();
        }
        return mensaje;
    }

    @Override
    public ArrayList<ServiciosMunicipios> listarServiciosMunicipios() {
        ServiciosMunicipios serm;
        ArrayList<ServiciosMunicipios> lista = new ArrayList();

        try {
            conex.abrirConexion();
            sql = "select * from servicios_municipios";

            ejecutar = conex.getMiConexion().prepareStatement(sql);

            resultadoSelect = ejecutar.executeQuery();

            while (resultadoSelect.next()) {
                serm = new ServiciosMunicipios();

                serm.setServicio_muni_id(resultadoSelect.getInt("serviciomunicipio_id"));
                serm.setServicio_id(resultadoSelect.getInt("Servicio_id"));
                serm.setMuni_id((short) resultadoSelect.getInt("muni_id"));

                lista.add(serm);
            }

            ejecutar.close();

        } catch (SQLException e) {
            System.out.println("ERROR EN DAO_LISTA_SUBCATEGORIAS" + e);
        } finally {
            conex.cerrarConexion();
        }

        return lista;

    }

    @Override
    public ServiciosMunicipios buscarServiciosMunicipios(int servicio_muni_id) {
        ServiciosMunicipios serviciosmunicipios = new ServiciosMunicipios();
        try {
            conex.abrirConexion();
            sql = "select * from servicios_municipios where serviciomunicipio_id=?";
            ejecutar = conex.getMiConexion().prepareStatement(sql);

            resultadoSelect = ejecutar.executeQuery();

            resultadoSelect.next();

            serviciosmunicipios.setServicio_muni_id(resultadoSelect.getInt("serviciomunicipio_id"));
            serviciosmunicipios.setServicio_id(resultadoSelect.getInt("Servicio_id"));
            serviciosmunicipios.setMuni_id((short) resultadoSelect.getInt("muni_id"));

        } catch (Exception e) {
            System.out.println("ERROR EN BUSQUEDA" + e);

        } finally {
            conex.cerrarConexion();
        }
        return serviciosmunicipios;
    }

}
