
package Controller;

import View.VCartelera;
import View.VCredito;
import View.VLogin;
import View.VMapa;
import View.VMenu;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 *
 * @author david_alcazar
 */
public class CMenu implements ActionListener{
    
    VMenu vm;

    public CMenu(VMenu vm) {
        this.vm = vm;
        this.vm.jButton1.addActionListener(this);
        this.vm.jButton2.addActionListener(this);
        this.vm.jButton3.addActionListener(this);
        this.vm.jButton4.addActionListener(this);
    }
    

    @Override
    public void actionPerformed(ActionEvent e) {
        if(this.vm.jButton1 == e.getSource()){
            System.out.println("yo mando al login");
            VLogin vlg = new VLogin();
            vlg.setVisible(true);
        }else if(this.vm.jButton3 == e.getSource()){
            System.out.println("yo abro la cartelera");
            VCartelera vc = new VCartelera();
            vc.setVisible(true);
        }else if(this.vm.jButton2 == e.getSource()){
            System.out.println("yo mando al mapa");
            VMapa vmp = new VMapa();
             vmp.setVisible(true);
        }else if(this.vm.jButton4 == e.getSource()){
            System.out.println("agradecimientos");
            VCredito vcredito = new VCredito();
            vcredito.setVisible(true);
        }
    }
    
}
