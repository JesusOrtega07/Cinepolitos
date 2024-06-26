
package Controller;

import Model.InsertarCliente;
import View.VLogin;
import View.VPremiun;
import View.VPrincipal;
import View.VRegistrarse;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 *
 * @author david_alcazar
 */
public class CLogin implements ActionListener{
    
    VLogin vlg;

    public CLogin(VLogin vlg) {
        this.vlg = vlg;
        this.vlg.jButton1.addActionListener(this);
        this.vlg.jButton2.addActionListener(this);
    }
    

    @Override
    public void actionPerformed(ActionEvent ae) {
        if(this.vlg.jButton1 == ae.getSource()){
            //String Id = vlg.jTextField1.getText();
            //System.out.println("busco al cliente en la base de dato con el id que igreso es: "+Id);
            String id = vlg.jTextField1.getText();
            InsertarCliente insertc = new InsertarCliente();
            boolean encontrado = insertc.buscarUser(id);//le paso el id al metodo donde se busca en la bd y se aguarda en la variable "encontrado" 
            if(encontrado){
                boolean tieneMembresia = insertc.verificarMembresia(id);
                VPrincipal vp = new VPrincipal(id);
                vp.setVisible(true);
                vp.jLabel2.setText(id);
            // Actualizar el label dependiendo si tiene membresía o no
            if (tieneMembresia) {
                vp.jLabel4.setText("Tiene membresía");
                vp.jButton1.setEnabled(false);
            } else {
                vp.jLabel4.setText("No tiene membresía");
            }

            vlg.dispose();  
            }else{
                vlg.jLabel1.setText("USUARIO NO REGISTRADO");
            }
            vlg.setVisible(false);
        }else if(this.vlg.jButton2 == ae.getSource()){
            System.out.println("mando a la vista de crear cuenta");
            VRegistrarse vr = new VRegistrarse();
            vr.setVisible(true);
            vlg.setVisible(false);
        }
    }
    
}
