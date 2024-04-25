package Controller;

import View.VRegistrarse;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
/**
 *
 * @author david_alcazar
 */
public class CRegistro implements ActionListener{

    VRegistrarse vr;

    public CRegistro(VRegistrarse vr) {
        this.vr = vr;
        this.vr.jBguardar.addActionListener(this);
    }

    @Override
    public void actionPerformed(ActionEvent ae) {
        if(this.vr.jBguardar == ae.getSource()){
            System.out.println("yo aguardo");
            String Nom = vr.jTextField1.getText();
            String Direc = vr.jTextField2.getText();
            String Gender = vr.jComboBox1.getSelectedItem().toString();
            String Cel = vr.jTextField3.getText();
            
            System.out.println("los datos son "+Nom+" "+Direc+" "+Gender+" "+Cel);
            //creo al oobj socio y con los parametros
        }
    }
    
}
