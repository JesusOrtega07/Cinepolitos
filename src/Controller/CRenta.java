/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controller;

import Model.CRUDPelicula;
import View.VRenta;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author david_alcazar
 */
public class CRenta implements ActionListener{

    VRenta vrenta;
    private String idUsuario;

    public CRenta(VRenta vrenta, String idUsuario) {
        this.vrenta = vrenta;
        this.idUsuario = idUsuario;
        this.vrenta.jButton1.addActionListener(this);
        this.vrenta.jButton2.addActionListener(this);
    }
    
    public CRenta(String idUsuario) {
        this.idUsuario = idUsuario;
    }
    
    @Override
    public void actionPerformed(ActionEvent ae) {
        if( this.vrenta.jButton1 == ae.getSource()){
            System.out.println("yo regreso");
            vrenta.dispose();
        }else if(this.vrenta.jButton2 == ae.getSource()){
            System.out.println("yo realizo el pago");
            CRUDPelicula crudpeli = new CRUDPelicula();
            crudpeli.pagarCuenta(idUsuario);
            DefaultTableModel tabla = crudpeli.mostrarDatos(idUsuario);
            vrenta.jTable1.setModel(tabla);
        }
    }
    
    
}
