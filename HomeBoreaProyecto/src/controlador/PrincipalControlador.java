package controlador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import vistas.JFrmPrincipal;
import vistas.VistaAsociados;
import vistas.VistaCategorias;

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
            
            vistaasociados= new VistaAsociados();
            asociadoscontrolador= new AsociadosControlador(vistaasociados);
            principal.jDesktopPane1.add(vistaasociados);
            vistaasociados.setVisible(true);
        }
    }
    
    public void destruirFormularios(){
       
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
