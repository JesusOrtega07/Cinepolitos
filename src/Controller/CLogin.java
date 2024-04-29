
package Controller;

import Model.InsertarCliente;
import View.VLogin;
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
            String Id = vlg.jTextField1.getText();
            System.out.println("busco al cliente en la base de dato con el id que igreso es: "+Id);
            String id = vlg.jTextField1.getText();
            InsertarCliente insertc = new InsertarCliente();
            boolean encontrado = insertc.buscarUser(id);//le paso el id al metodo donde se busca en la bd y se aguarda en la variable "encontrado" 
            if(encontrado){
                VPrincipal vp = new VPrincipal();
                vp.setVisible(true);
                vp.jLabel2.setText(id);
                vlg.dispose(); 
            }else{
                vlg.jLabel1.setText("USUARIO NO REGISTRADO");
            }
        }else if(this.vlg.jButton2 == ae.getSource()){
            System.out.println("mando a la vista de crear cuenta");
            VRegistrarse vr = new VRegistrarse();
            vr.setVisible(true);
        }
    }
    
}
