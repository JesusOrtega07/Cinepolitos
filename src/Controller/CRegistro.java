package Controller;

import Model.CRUDPelicula;
import Model.Cliente;
import Model.InsertarCliente;
import View.VPremiun;
import View.VPrincipal;
import View.VRegistrarse;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
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
                //creo al oobj socio y con los parametros
    //          aqui por defecto pongo al cliente con false 
                cliente = new Cliente(User, false, Nom, Edad, Direc, Cel, 0.0);
                inser.insertarC(cliente.getNomUsuario(), cliente.isMembresia(), cliente.getNom_socio(), cliente.getEdad(), cliente.getDirec_socio(), cliente.getTelefono(), (float) cliente.getSaldo());
                CPremium cpm = new CPremium(cliente.getNomUsuario());
                VPrincipal vprin = new VPrincipal(cliente.getNomUsuario());
                vprin.setVisible(true);
                CRUDPelicula crpeli = new CRUDPelicula();
                ArrayList<String> nombresPeliculas = crpeli.obtenerNombresPeliculas();
                for (String nombrePelicula : nombresPeliculas) {
                    vprin.jComboBox1.addItem(nombrePelicula);
                }
                vprin.jLabel2.setText(User);
                vprin.jLabel4.setText("No tiene membresía");
                vprin.jLabel9.setText("precio de cada pelicula es de $25");
                vr.setVisible(false);
            }
        }
    }
    
}
