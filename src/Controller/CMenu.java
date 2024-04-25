
package Controller;

import View.VCartelera;
import View.VLogin;
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
        this.vm.jButton3.addActionListener(this);
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
            
            //vc.dispose();
        }
    }
    
}
