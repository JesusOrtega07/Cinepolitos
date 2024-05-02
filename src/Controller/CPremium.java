
package Controller;

import Model.CRUDPelicula;
import Model.InsertarCliente;
import View.VPremiun;
import View.VPrincipal;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

/**
 *
 * @author david_alcazar
 */
public class CPremium implements ActionListener{

    VPremiun vpremium;
    private String idUsuario;

    public CPremium(VPremiun vpremium, String idUsuario) {
        this.vpremium = vpremium;
        this.vpremium.jCheckBox1.addActionListener(this);
        this.vpremium.jButton1.addActionListener(this);
        this.idUsuario = idUsuario;
    }

    public CPremium(String idUsuario) {
        this.idUsuario = idUsuario;
    }
    
    

    @Override
    public void actionPerformed(ActionEvent ae) {
        if(this.vpremium.jButton1 == ae.getSource()){
            System.out.println("yo regreso");
            VPrincipal vprin = new VPrincipal(idUsuario);
            CRUDPelicula crpeli = new CRUDPelicula();
            ArrayList<String> nombresPeliculas = crpeli.obtenerNombresPeliculas();
                for (String nombrePelicula : nombresPeliculas) {
                    vprin.jComboBox1.addItem(nombrePelicula);
                }
            vprin.jLabel4.setText("ya eres premium");
            vprin.jLabel2.setText(idUsuario);
            vprin.jButton1.setEnabled(false);
            vprin.setVisible(true);
            vpremium.setVisible(false);
        }else if (vpremium.jCheckBox1.isSelected()) {
            // Si el JCheckBox está seleccionado
            System.out.println("La opción Premium está seleccionada");
            System.out.println("el id es"+idUsuario);
            this.vpremium.jCheckBox1.setEnabled(false);
            InsertarCliente insert = new InsertarCliente();
            // Llamar al método para insertar el cliente y obtener las fechas de membresía
            Date[] fechasMembresia = insert.insertarClienteYObtenerFechasMembresia(idUsuario);
        
            // Hacer algo con las fechas de membresía
            if (fechasMembresia != null && fechasMembresia.length == 2) {
            Date fechaInicio = fechasMembresia[0];
            Date fechaFinal = fechasMembresia[1];
            
            // Imprimir las fechas en la consola
            System.out.println("Fecha de inicio de membresía: " + fechaInicio);
            System.out.println("Fecha final de membresía: " + fechaFinal);
            SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy"); // Define el formato de la fecha
            String fechaInicioStr = dateFormat.format(fechaInicio); // Convierte la fecha de inicio a una cadena
            String fechaFinalStr = dateFormat.format(fechaFinal); // Convierte la fecha final a una cadena
            vpremium.jLabelInicio.setText(fechaInicioStr);
            vpremium.jLabelFinal.setText(fechaFinalStr);
            } else {
            System.out.println("Error al obtener las fechas de membresía");
            }
        }
        }
        
    }
