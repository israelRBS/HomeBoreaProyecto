package controlador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import vistas.JFrmPrincipal;
import vistas.VistaAsociados;
import vistas.VistaCategorias;
import vistas.VistaEmpleados;
import vistas.VistaImagenesServicios;
import vistas.VistasNivelesAca;

/**
 *
 * @author javam2019
 */
public class PrincipalControlador implements ActionListener, MouseListener {
    boolean verificar=false;
    //VistaCategorias frmcategorias = new VistaCategorias();
    JFrmPrincipal principal = new JFrmPrincipal();
    VistaCategorias vistacategorias;
    CategoriasControlador categoriascontrolador;
    VistaAsociados vistaasociados ;
     AsociadosControlador asociadoscontrolador;
     VistaEmpleados vistaEmpleados;
     VistaImagenesServicios vistaImagenesServicio;
     VistasNivelesAca vistaNivelesAca;
     
    public PrincipalControlador(JFrmPrincipal principal) {
        this.principal = principal;
        principal.cutMenuCategorias.addActionListener(this);
        principal.copyMenuAsociados.addActionListener(this);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == this.principal.cutMenuCategorias) {
            if (verificar==true) {
                vistacategorias=null;  // destruir el objeto cuando ya existe
                categoriascontrolador=null;
                System.gc(); //llamar al recolector de basura de jvm

                verificar = false;
            }else{
                vistacategorias = new VistaCategorias();
                categoriascontrolador = new CategoriasControlador(vistacategorias);
                principal.jDesktopPane1.add(vistacategorias);
                verificar = true;
            }
       
            

        }
        if (e.getSource() == this.principal.copyMenuAsociados) {
            if (verificar==true) {
                vistaNivelesAca=null;
                asociadoscontrolador=null;
                System.gc();
                verificar=false;
            }else{
            vistaNivelesAca= new VistasNivelesAca();
            //asociadoscontrolador= new AsociadosControlador(vistaasociados);
            principal.jDesktopPane1.add(vistaNivelesAca);
            verificar=true;
            
            
            
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
            
            
            
           /* if (verificar==true) {
                vistaEmpleados=null;
                asociadoscontrolador=null;
                System.gc();
                verificar=false;
            }else{
            vistaEmpleados= new VistaEmpleados();
            //asociadoscontrolador= new AsociadosControlador(vistaasociados);
            principal.jDesktopPane1.add(vistaEmpleados);
            verificar=true;
            }*/
            
            /*
            if (verificar==true) {
                vistaasociados=null;
                asociadoscontrolador=null;
                System.gc();
                verificar=false;
            }else{
            vistaasociados= new VistaAsociados();
            asociadoscontrolador= new AsociadosControlador(vistaasociados);
            principal.jDesktopPane1.add(vistaasociados);
            verificar=true;
            }*/
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
