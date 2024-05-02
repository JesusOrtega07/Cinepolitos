/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controller;

import Model.CRUDPelicula;
import Model.InsertarCliente;
import Model.Pelicula;
import View.VPremiun;
import View.VPrincipal;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author david_alcazar
 */
public class CPrincipal implements ActionListener{

    VPrincipal vprin;
    private String user;
    private CRUDPelicula crudpeli;
    private ArrayList<String> peliculasSeleccionadas;
    private double costoTotal;
    String opc;
    //obtengo el id por medio del constructor
    
    public CPrincipal(VPrincipal vprin,String user) {
        this.vprin = vprin;
        this.vprin.jButton1.addActionListener(this);
        this.vprin.jButton2.addActionListener(this);
        this.vprin.jButton3.addActionListener(this);
        this.user = user;
        this.crudpeli = new CRUDPelicula();
        this.peliculasSeleccionadas = new ArrayList<>();
        this.costoTotal = 0.0;
        this.vprin.jComboBox1.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent ae) {
                String opcionSeleccionada = (String) vprin.jComboBox1.getSelectedItem();
                Pelicula pelicula = crudpeli.obtenerInformacionPelicula(opcionSeleccionada);
                if (pelicula != null) {
                    vprin.jSpinner1.setValue(pelicula.getCopias());
                    // Imprimir los datos de la película
                    vprin.jLabel5.setText("Título: " + pelicula.getTitulo());
                    vprin.jLabel6.setText("Copias: " + pelicula.getCopias());
                    vprin.jLabel7.setText("Género: " + pelicula.getGenero());
                }
            }
        });
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
        }else if(this.vprin.jButton2== ae.getSource()){
            System.out.println("yo agurdo las peliculas en un arraylist");
            InsertarCliente insertc = new InsertarCliente();
            boolean tieneMembresia = insertc.verificarMembresia(user);
            if (tieneMembresia){
                opc = (String) vprin.jComboBox1.getSelectedItem();
                premium(opc);
            }else{
                agregarPeliculaSeleccionada(opc);
            }
        }else if(this.vprin.jButton3 == ae.getSource()){
            System.out.println("yo muestro el id de las peliculas");
            System.out.println("Yo muestro el ID de las peliculas:");
            // Recorrer el ArrayList de películas seleccionadas y obtener sus IDs
            for (String peliculaSeleccionada : peliculasSeleccionadas) {
                int idPelicula = crudpeli.obtenerNombrePelicula(peliculaSeleccionada);
                System.out.println("ID de " + peliculaSeleccionada + ": " + idPelicula);
            }
            
        }

    }
    private void agregarPeliculaSeleccionada(String peliculaSeleccionada){
        if (peliculaSeleccionada != null) {
            peliculasSeleccionadas.add(peliculaSeleccionada);
            costoTotal += 5.0;
            System.out.println("Costo Total: $" + costoTotal);
        }
            
     }
        private void premium(String peliculaSeleccionada){
        if (peliculaSeleccionada != null) {
            peliculasSeleccionadas.add(peliculaSeleccionada);
             if (peliculasSeleccionadas.size() > 60) {
            System.out.println("Se ha alcanzado el límite máximo de películas permitidas.");
            costoTotal += 5.0;
            System.out.println("Costo Total: $" + costoTotal);
            }
        }
           
        }

}