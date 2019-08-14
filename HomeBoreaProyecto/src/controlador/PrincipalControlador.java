package controlador;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.beans.PropertyVetoException;
import java.util.logging.Level;
import java.util.logging.Logger;
import vistas.JFrmPrincipal;
import vistas.JFrmServicios;
import vistas.JFrmServiciosPrestados;
import vistas.JFrmTipoCostos;
import vistas.Login;
import vistas.VistaAsociados;
import vistas.VistaCategorias;
import vistas.VistaEmpleados;
import vistas.VistaImagenesServicios;
import vistas.VistaServiciosMuni;
import vistas.VistaSubCategorias;
import vistas.VistasNivelesAca;

/**
 *
 * @author javam2019
 */
public class PrincipalControlador implements ActionListener, MouseListener {

    boolean verificar = false;
    Login login;
    JFrmPrincipal principal = new JFrmPrincipal();
    VistaCategorias vistacategorias;
    CategoriasControlador categoriascontrolador;
    VistaAsociados vistaasociados;
    AsociadosControlador asociadoscontrolador;
    VistaEmpleados vistaEmpleados;
    VistaImagenesServicios vistaImagenesServicio;
    VistasNivelesAca vistaNivelesAca;
    VistaSubCategorias vistaSubCategorias;
    SubCategoriaControlador subCategoriaControlador;
    JFrmServicios jfrmServicios;
    ServiciosControlador serviciosControlador;
    JFrmServiciosPrestados jfrmserviciosprestados;
    ServiciosPrestadosControlador serviciosPrestadosControlador;
    VistaServiciosMuni vistaServiciosMunicipales;
    ServiciosMunicipioControlador serviciosMunicipioControlador;
    JFrmTipoCostos jfrmTipoCosto;
    TiposCostosControlador tipoCostosControlador;

    public PrincipalControlador(JFrmPrincipal principal) {
        this.principal = principal;
        principal.cutMenuCategorias.addActionListener(this);
        principal.cutMenuAsociados.addActionListener(this);
        principal.cutMenuEmpleados.addActionListener(this);
        principal.cutMenuSubCategorias.addActionListener(this);
        principal.cutMenuNivelesAcademicos.addActionListener(this);
        principal.cutMenuServicios.addActionListener(this);
        principal.cutMenuServiciosPrestados.addActionListener(this);
        principal.jLblTextoUsuario.setText("Bienvenido: " + ObjetosPublicos.empleado.getUsuario());
        principal.CambiarUsuario.addActionListener(this);

    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == this.principal.CambiarUsuario) {
            login = new Login();
            LoginControlador controlador = new LoginControlador(login);
            login.setLocationRelativeTo(null);
            login.setVisible(true);
            principal.dispose();

        }

        if (e.getSource() == this.principal.cutMenuCategorias) {
            if (verificar == true) {
                vistacategorias = null;  // destruir el objeto cuando ya existe
                categoriascontrolador = null;
                System.gc(); //llamar al recolector de basura de jvm
                verificar = false;
            } else {
                vistacategorias = new VistaCategorias();
                categoriascontrolador = new CategoriasControlador(vistacategorias);
                principal.DesktopPane.add(vistacategorias);
                Dimension desktopSize = principal.DesktopPane.getSize();
                Dimension FrameSize = vistacategorias.getSize();
                vistacategorias.setLocation((desktopSize.width - FrameSize.width) / 2, (desktopSize.height - FrameSize.height) / 2);
                vistacategorias.setVisible(true);

                verificar = true;
            }

        }
        if (e.getSource() == this.principal.cutMenuSubCategorias) {
            if (verificar == true) {
                vistaSubCategorias = null;
                subCategoriaControlador = null;
                System.gc();
                verificar = false;
            } else {
                vistaSubCategorias = new VistaSubCategorias();
                subCategoriaControlador = new SubCategoriaControlador(vistaSubCategorias);
                principal.DesktopPane.add(vistaSubCategorias);
                Dimension desktopSize = principal.DesktopPane.getSize();
                Dimension FrameSize = vistaSubCategorias.getSize();
                vistaSubCategorias.setLocation((desktopSize.width - FrameSize.width) / 2, (desktopSize.height - FrameSize.height) / 2);
                verificar = true;
            }
        }
        if (e.getSource() == this.principal.cutMenuAsociados) {
            if (verificar == true) {
                vistaasociados = null;
                asociadoscontrolador = null;
                System.gc();
                verificar = false;
            } else {
                vistaasociados = new VistaAsociados();
                asociadoscontrolador = new AsociadosControlador(vistaasociados);
                principal.DesktopPane.add(vistaasociados);
                Dimension desktopSize = principal.DesktopPane.getSize();
                Dimension FrameSize = vistaasociados.getSize();
                vistaasociados.setLocation((desktopSize.width - FrameSize.width) / 2, (desktopSize.height - FrameSize.height) / 2);
                verificar = true;
            }
            /*if (verificar==true) {
                vistaImagenesServicio=null;
                asociadoscontrolador=null;
                System.gc();
                verificar=false;
            }else{
            vistaImagenesServicio= new VistaImagenesServicios();
            //asociadoscontrolador= new AsociadosControlador(vistaasociados);
            principal.jDesktopPane1.add(vistaImagenesServicio);
            verificar=true;   */
        }

        if (e.getSource() == this.principal.cutMenuEmpleados) {

            if (verificar == true) {
                vistaEmpleados = null;
                asociadoscontrolador = null;
                System.gc();
                verificar = false;
            } else {
                vistaEmpleados = new VistaEmpleados();
                //asociadoscontrolador= new AsociadosControlador(vistaasociados);
                principal.DesktopPane.add(vistaEmpleados);
                Dimension desktopSize = principal.DesktopPane.getSize();
                Dimension FrameSize = vistaEmpleados.getSize();
                vistaEmpleados.setLocation((desktopSize.width - FrameSize.width) / 2, (desktopSize.height - FrameSize.height) / 2);
                verificar = true;
            }
        }

        if (e.getSource() == this.principal.cutMenuNivelesAcademicos) {
            if (verificar == true) {
                vistaNivelesAca = null;
                asociadoscontrolador = null;
                System.gc();
                verificar = false;
            } else {
                vistaNivelesAca = new VistasNivelesAca();
                //asociadoscontrolador= new AsociadosControlador(vistaasociados);
                principal.DesktopPane.add(vistaNivelesAca);
                verificar = true;
            }

        }
        if (e.getSource() == this.principal.cutMenuServicios) {
            if (verificar == true) {
                jfrmServicios = null;
                serviciosControlador = null;
                System.gc();
                verificar = false;
            } else {
                jfrmServicios = new JFrmServicios();
                //asociadoscontrolador= new AsociadosControlador(vistaasociados);
                principal.DesktopPane.add(jfrmServicios);
                verificar = true;
            }
        }
        if (e.getSource() == this.principal.cutMenuServiciosPrestados) {
            if (verificar == true) {
                jfrmserviciosprestados = null;
                //serviciosPrestadosControlador = null;
                System.gc();
                verificar = false;
            } else {
                jfrmserviciosprestados = new JFrmServiciosPrestados();
                //serviciosPrestadosControlador= new ServiciosPrestadosControlador(jfrmserviciosprestados);
                principal.DesktopPane.add(jfrmserviciosprestados);
                verificar = true;
            }
        }
        if (e.getSource() == this.principal.cutMenuServiciosMunicipales) {
            if (verificar == true) {
                vistaServiciosMunicipales = null;
                //serviciosPrestadosControlador = null;
                System.gc();
                verificar = false;
            } else {
                vistaServiciosMunicipales = new VistaServiciosMuni();
                //serviciosPrestadosControlador= new ServiciosPrestadosControlador(jfrmserviciosprestados);
                principal.DesktopPane.add(vistaServiciosMunicipales);
                verificar = true;
            }
        }
        if (e.getSource() == this.principal.cutMenuTipoCosto) {
            if (verificar == true) {
                jfrmTipoCosto = null;
                //serviciosPrestadosControlador = null;
                System.gc();
                verificar = false;
            } else {
                jfrmTipoCosto = new JFrmTipoCostos();
                //serviciosPrestadosControlador= new ServiciosPrestadosControlador(jfrmserviciosprestados);
                principal.DesktopPane.add(jfrmTipoCosto);
                verificar = true;
            }
        }
        principal.setBackground(Color.yellow);

    }

    @Override
    public void mouseClicked(MouseEvent me) {
        System.out.println("Nose usa");
    }

    @Override
    public void mousePressed(MouseEvent me) {
        System.out.println("Nose usa");
    }

    @Override
    public void mouseReleased(MouseEvent me) {
        System.out.println("Nose usa");
    }

    @Override
    public void mouseEntered(MouseEvent me) {
        System.out.println("Nose usa");
    }

    @Override
    public void mouseExited(MouseEvent me) {
        System.out.println("Nose usa");
    }

}
