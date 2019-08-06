package controlador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import vistas.JFrmPrincipal;
import vistas.VistaCategorias;

/**
 *
 * @author javam2019
 */
public class PrincipalControlador implements ActionListener, MouseListener {

    VistaCategorias frmcategorias = new VistaCategorias();
    JFrmPrincipal principal = new JFrmPrincipal();

    public PrincipalControlador(JFrmPrincipal principal) {
        this.principal = principal;
        principal.cutMenuCategorias.addActionListener(this);

    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource()==this.principal.cutMenuCategorias){
            VistaCategorias vistacategorias=new VistaCategorias();
            CategoriasControlador categoriascontrolador=new CategoriasControlador(vistacategorias);
            principal.add(vistacategorias);
            vistacategorias.setVisible(true);
            
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
