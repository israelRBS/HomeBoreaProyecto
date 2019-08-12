package controlador;

import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import vistas.JFrmPrincipal;
import vistas.JFrmServicios;
import vistas.VistaAsociados;
import vistas.VistaCategorias;
import vistas.VistaEmpleados;
import vistas.VistaImagenesServicios;
import vistas.VistaSubCategorias;
import vistas.VistasNivelesAca;

/**
 *
 * @author javam2019
 */
public class PrincipalControlador implements ActionListener, MouseListener {

    boolean verificar = false;
    //VistaCategorias frmcategorias = new VistaCategorias();
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

    public PrincipalControlador(JFrmPrincipal principal) {
        this.principal = principal;
        principal.cutMenuCategorias.addActionListener(this);
        principal.cutMenuAsociados.addActionListener(this);
        principal.cutMenuEmpleados.addActionListener(this);
        principal.cutMenuSubCategorias.addActionListener(this);
        principal.cutMenuNivelesAcademicos.addActionListener(this);
        principal.cutMenuServicios.addActionListener(this);
        
    }

    @Override
    public void actionPerformed(ActionEvent e) {
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
               vistacategorias.show();
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
                subCategoriaControlador = new SubCategoriaControlador();
                principal.DesktopPane.add(vistaSubCategorias);
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
