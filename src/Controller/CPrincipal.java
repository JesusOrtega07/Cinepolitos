/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controller;

import View.VPrincipal;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 *
 * @author david_alcazar
 */
public class CPrincipal implements ActionListener{
    
    VPrincipal vprin;

    public CPrincipal(VPrincipal vprin) {
        this.vprin = vprin;
        this.vprin.jButton1.addActionListener(this);
    }

    @Override
    public void actionPerformed(ActionEvent ae) {
        if(this.vprin.jButton1 == ae.getSource()){
            System.out.println("yo ofrezco premium");
        }
    }
    
}
