/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controller;

import View.VPremiun;
import View.VPrincipal;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 *
 * @author david_alcazar
 */
public class CPrincipal implements ActionListener{
    
    VPrincipal vprin;
    private String user;
    
    //obtengo el id por medio del constructor
    
    public CPrincipal(VPrincipal vprin,String user) {
        this.vprin = vprin;
        this.vprin.jButton1.addActionListener(this);
        this.user = user;
    }

    public CPrincipal(String user) {
        this.user = user;
    }
    

    @Override
    public void actionPerformed(ActionEvent ae) {
        if(this.vprin.jButton1 == ae.getSource()){
            System.out.println("yo ofrezco premium");
            System.out.println("el id es"+user);
            VPremiun vpm = new VPremiun(user);
            vpm.setVisible(true);
            vprin.setVisible(false);
        }
    }
    
}
