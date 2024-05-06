
package Controller;

import Model.CRUDPelicula;
import View.VPagar;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 *
 * @author david_alcazar
 */
public class CPagar implements ActionListener{
    
    VPagar vpagar;
    private String idUsuario;
    
    
    public CPagar(VPagar vpagar, String idUsuario) {
        this.vpagar = vpagar;
        this.idUsuario = idUsuario;
        this.vpagar.jButton1.addActionListener(this);
        this.vpagar.jButton.addActionListener(this);
    }
    
    public CPagar(String idUsuario) {
        this.idUsuario = idUsuario;
    }

    @Override
    public void actionPerformed(ActionEvent ae) {
        if(this.vpagar.jButton1 == ae.getSource()){
            System.out.println("yo mando a la vista de agregar saldo"+idUsuario);
            int saldo = Integer.parseInt(this.vpagar.jTextField1.getText());
            CRUDPelicula crudpeli = new CRUDPelicula();
            crudpeli.depositarSaldo(idUsuario, saldo);
        }else if(this.vpagar.jButton == ae.getSource()){
            System.out.println("yo regreso");
            vpagar.dispose();
        }
    }
    
}
