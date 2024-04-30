package Controller;

import Model.Cliente;
import Model.InsertarCliente;
import View.VPrincipal;
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
            int Edad = Integer.parseInt(this.vr.jTextField5.getText());
            String Cel = vr.jTextField3.getText();
            InsertarCliente inser = new InsertarCliente();
            
            if (inser.existeID(User)) {
                vr.jLabel7.setText("¡Este Usuario ya está en uso!");
            } else {
                vr.jLabel7.setText("");
                // Aquí iría el código para guardar el registro en la base de datos
//                System.out.println("los datos son "+User+" "+Nom+" "+Direc+" "+Gender+" "+Cel);
                //creo al oobj socio y con los parametros
    //          aqui me refiero no tenemos el parametro de true o false 
                cliente = new Cliente(User, false, Nom, Edad, Direc, Cel, 0.0);
                inser.insertarC(cliente.getNomUsuario(), cliente.isMembresia(), cliente.getNom_socio(), cliente.getEdad(), cliente.getDirec_socio(), cliente.getTelefono(), (float) cliente.getSaldo());
                VPrincipal vprin = new VPrincipal();
                vprin.setVisible(true);
                vprin.jLabel2.setText(User);
            }
        }
    }
    
}
