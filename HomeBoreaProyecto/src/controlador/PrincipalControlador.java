package controlador;

import java.awt.Color;
import java.awt.Desktop;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.beans.PropertyVetoException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.plaf.DesktopPaneUI;
import vistas.JFrmPrincipal;
import vistas.JFrmServicios;
import vistas.JFrmServiciosPrestados;
import vistas.JFrmTipoCostos;
import vistas.JFrmVisibleServiciosMunicipios;
import vistas.JFrmVisibleServiciosPrestados;
import vistas.Login;
import vistas.VistaAsociados;
import vistas.VistaCategorias;
import vistas.VistaDepartamento;
import vistas.VistaEmpleados;
import vistas.VistaImagenesServicios;
import vistas.VistaMunicipios;
import vistas.VistaRegiones;
import vistas.VistaServiciosMuni;
import vistas.VistaSubCategorias;
import vistas.VistasNivelesAca;

/**
 *
 * @author javam2019
 */
public class PrincipalControlador implements ActionListener, MouseListener {

    boolean verificar = false;
    boolean verificarSP = false;
    Login login;
    JFrmPrincipal principal = new JFrmPrincipal();
    VistaCategorias vistacategorias;
    CategoriasControlador categoriascontrolador;
    VistaAsociados vistaasociados;
    AsociadosControlador asociadoscontrolador;
    VistaEmpleados vistaEmpleados;
    EmpleadoControlador empleadoControlador;
    VistaImagenesServicios vistaImagenesServicio;
    VistasNivelesAca vistaNivelesAca;
    NivelAcaControlador nivelAcaControlador;
    VistaSubCategorias vistaSubCategorias;
    SubCategoriaControlador subCategoriaControlador;
    JFrmServicios jfrmServicios;
    ServiciosControlador serviciosControlador;
    JFrmVisibleServiciosPrestados jfrmvisibleserviciosprestados;
    VistaServiciosPrestados serviciosPrestadosControlador;
    JFrmVisibleServiciosMunicipios vistaServiciosMunicipales;
    VistaServiciosMunicipios vistaServiciosMunicipiosControlador;
    JFrmTipoCostos jfrmTipoCosto;
    TiposCostosControlador tipoCostosControlador;
    VistaMunicipios vistaMunicipios;
    MunicipiosControlador municipiosControlador;
    VistaDepartamento vistaDepartamento;
    DepartamentosControlador departamentosControlador;
    VistaRegiones vistaRegiones;
    RegionesControlador regionesControlador;
    

    public PrincipalControlador(JFrmPrincipal principal) {
        this.principal = principal;
        principal.cutMenuCategorias.addActionListener(this);
        principal.cutMenuAsociados.addActionListener(this);
        principal.cutMenuEmpleados.addActionListener(this);
        principal.cutMenuSubCategorias.addActionListener(this);
        principal.cutMenuNivelesAcademicos.addActionListener(this);
        principal.cutMenuServicios.addActionListener(this);
        principal.cutMenuServiciosPrestados.addActionListener(this);
        principal.cutMenuServiciosMunicipales.addActionListener(this);
        principal.cutMenuTipoCosto.addActionListener(this);
        principal.cutMenuMunicipios.addActionListener(this);
        principal.cutMenuDepartamentos.addActionListener(this);
        principal.cutMenuRegiones.addActionListener(this);
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
                vistaSubCategorias.setVisible(true);
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
                vistaasociados.setVisible(true);
                verificar = true;
            }

        }

        if (e.getSource() == this.principal.cutMenuEmpleados) {

            if (verificar == true) {
                vistaEmpleados = null;
                asociadoscontrolador = null;
                System.gc();
                verificar = false;
            } else {
                vistaEmpleados = new VistaEmpleados();
                empleadoControlador = new EmpleadoControlador(vistaEmpleados);
                principal.DesktopPane.add(vistaEmpleados);
                Dimension desktopSize = principal.DesktopPane.getSize();
                Dimension FrameSize = vistaEmpleados.getSize();
                vistaEmpleados.setLocation((desktopSize.width - FrameSize.width) / 2, (desktopSize.height - FrameSize.height) / 2);
                vistaEmpleados.setVisible(true);
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
                nivelAcaControlador = new NivelAcaControlador(vistaNivelesAca);
                principal.DesktopPane.add(vistaNivelesAca);
                Dimension desktopSize = principal.DesktopPane.getSize();
                Dimension FrameSize = vistaNivelesAca.getSize();
                vistaNivelesAca.setLocation((desktopSize.width - FrameSize.width) / 2, (desktopSize.height - FrameSize.height) / 2);
                vistaNivelesAca.setVisible(true);
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
                serviciosControlador = new ServiciosControlador(jfrmServicios);
                principal.DesktopPane.add(jfrmServicios);
                Dimension desktopSize = principal.DesktopPane.getSize();
                Dimension FrameSize = jfrmServicios.getSize();
                jfrmServicios.setLocation((desktopSize.width - FrameSize.width) / 2, (desktopSize.height - FrameSize.height) / 2);
                jfrmServicios.setVisible(true);
                verificar = true;
            }
        }
        if (e.getSource() == this.principal.cutMenuServiciosPrestados) {
            if (verificarSP == true) {
                jfrmvisibleserviciosprestados = null;
                serviciosPrestadosControlador = null;
                System.gc();
                verificarSP = false;
            } else {
                jfrmvisibleserviciosprestados = new JFrmVisibleServiciosPrestados();
                serviciosPrestadosControlador = new VistaServiciosPrestados(jfrmvisibleserviciosprestados);
                principal.DesktopPane.add(jfrmvisibleserviciosprestados);
                Dimension desktopSize = principal.DesktopPane.getSize();
                Dimension FrameSize = jfrmvisibleserviciosprestados.getSize();
                jfrmvisibleserviciosprestados.setLocation((desktopSize.width - FrameSize.width) / 2, (desktopSize.height - FrameSize.height) / 2);
                jfrmvisibleserviciosprestados.setVisible(true);
                verificarSP = true;
            }
        }
        if (e.getSource() == this.principal.cutMenuServiciosMunicipales) {
            if (verificar == true) {
                vistaServiciosMunicipales = null;
                vistaServiciosMunicipiosControlador = null;
                System.gc();
                verificar = false;
            } else {
                vistaServiciosMunicipales = new JFrmVisibleServiciosMunicipios();
                vistaServiciosMunicipiosControlador = new VistaServiciosMunicipios(vistaServiciosMunicipales);
                principal.DesktopPane.add(vistaServiciosMunicipales);
                Dimension desktopSize = principal.DesktopPane.getSize();
                Dimension FrameSize = vistaServiciosMunicipales.getSize();
                vistaServiciosMunicipales.setLocation((desktopSize.width - FrameSize.width) / 2, (desktopSize.height - FrameSize.height) / 2);
                vistaServiciosMunicipales.setVisible(true);
                verificar = true;
            }
        }
        if (e.getSource() == this.principal.cutMenuTipoCosto) {
            if (verificar == true) {
                jfrmTipoCosto = null;
                tipoCostosControlador = null;
                System.gc();
                verificar = false;
            } else {
                jfrmTipoCosto = new JFrmTipoCostos();
                tipoCostosControlador= new TiposCostosControlador(jfrmTipoCosto);
                principal.DesktopPane.add(jfrmTipoCosto);
                Dimension desktopSize = principal.DesktopPane.getSize();
                Dimension FrameSize = jfrmTipoCosto.getSize();
                jfrmTipoCosto.setLocation((desktopSize.width - FrameSize.width) / 2, (desktopSize.height - FrameSize.height) / 2);
                jfrmTipoCosto.setVisible(true);
                verificar = true;
            }
        }
        if (e.getSource() == this.principal.cutMenuMunicipios) {
            if (verificar == true) {
                vistaMunicipios = null;
                municipiosControlador = null;
                System.gc();
                verificar = false;
            } else {
                vistaMunicipios = new VistaMunicipios();
                municipiosControlador = new MunicipiosControlador(vistaMunicipios);
                principal.DesktopPane.add(vistaMunicipios);
                Dimension desktopSize = principal.DesktopPane.getSize();
                Dimension FrameSize = vistaMunicipios.getSize();
                vistaMunicipios.setLocation((desktopSize.width - FrameSize.width) / 2, (desktopSize.height - FrameSize.height) / 2);
                vistaMunicipios.setVisible(true);
                verificar = true;
            }
        }
        if (e.getSource() == this.principal.cutMenuDepartamentos) {
            if (verificar == true) {
                vistaDepartamento = null;  // destruir el objeto cuando ya existe
                departamentosControlador = null;
                System.gc(); //llamar al recolector de basura de jvm
                verificar = false;
            } else {
                vistaDepartamento = new VistaDepartamento();
                departamentosControlador = new DepartamentosControlador(vistaDepartamento);
                principal.DesktopPane.add(vistaDepartamento);
                Dimension desktopSize = principal.DesktopPane.getSize();
                Dimension FrameSize = vistaDepartamento.getSize();
                vistaDepartamento.setLocation((desktopSize.width - FrameSize.width) / 2, (desktopSize.height - FrameSize.height) / 2);
                vistaDepartamento.setVisible(true);
                verificar = true;
            }

        }
        if (e.getSource() == this.principal.cutMenuRegiones) {
            if (verificar == true) {
                vistaRegiones = null;  // destruir el objeto cuando ya existe
                regionesControlador = null;
                System.gc(); //llamar al recolector de basura de jvm
                verificar = false;
            } else {
                vistaDepartamento = new VistaDepartamento();
                regionesControlador = new RegionesControlador(vistaRegiones);
                principal.DesktopPane.add(vistaRegiones);
                Dimension desktopSize = principal.DesktopPane.getSize();
                Dimension FrameSize = vistaRegiones.getSize();
                vistaRegiones.setLocation((desktopSize.width - FrameSize.width) / 2, (desktopSize.height - FrameSize.height) / 2);
                vistaRegiones.setVisible(true);
                verificar = true;
            }

        }

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
