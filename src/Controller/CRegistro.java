package Controller;

import Model.Cliente;
import Model.InsertarCliente;
import View.VPaginaPrincipal;
import View.VRegistrarse;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
/**
 *
 * @author david_alcazar
 */
public class CRegistro implements ActionListener{

    VRegistrarse vr;
    Cliente cliente;

    public CRegistro(VRegistrarse vr) {
        this.vr = vr;
        this.vr.jBguardar.addActionListener(this);
    }

    @Override
    public void actionPerformed(ActionEvent ae) {
        if(this.vr.jBguardar == ae.getSource()){
            System.out.println("yo aguardo");
            String User = vr.jTextField4.getText();
            String Nom = vr.jTextField1.getText();
            String Direc = vr.jTextField2.getText();
            String Gender = vr.jComboBox1.getSelectedItem().toString();
            String Cel = vr.jTextField3.getText();
            InsertarCliente inser = new InsertarCliente();
            
            if (inser.existeID(User)) {
                vr.jLabel7.setText("¡Este Usuario ya está en uso!");
            } else {
                vr.jLabel7.setText("");
                // Aquí iría el código para guardar el registro en la base de datos
                System.out.println("los datos son "+User+" "+Nom+" "+Direc+" "+Gender+" "+Cel);
                //creo al oobj socio y con los parametros
    //          aqui me refiero no tenemos el parametro de true o false 
                cliente = new Cliente(User, Nom, Direc, Gender, Cel);
                inser.insertarC(User, Nom, Direc, Gender, Cel);
                VPaginaPrincipal vpagina = new VPaginaPrincipal();
                vpagina.setVisible(true);
                vpagina.jLabel2.setText(User);
            }
        }
    }
    
}
