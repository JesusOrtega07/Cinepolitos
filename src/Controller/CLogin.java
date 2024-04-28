
package Controller;

import View.VLogin;
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
            
        }else if(this.vlg.jButton2 == ae.getSource()){
            System.out.println("mando a la vista de crear cuenta");
            VRegistrarse vr = new VRegistrarse();
            vr.setVisible(true);
        }
    }
    
}
