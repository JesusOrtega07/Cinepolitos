
package Controller;

import Model.CRUDPelicula;
import Model.InsertarCliente;
import Model.Pelicula;
import View.VPremiun;
import View.VPrincipal;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import javax.swing.SpinnerModel;
import javax.swing.SpinnerNumberModel;
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
    DefaultTableModel modeloTabla;
    //obtengo el id por medio del constructor
    
    public CPrincipal(VPrincipal vprin,String user) {
        this.vprin = vprin;
        this.vprin.jButton1.addActionListener(this);
        this.vprin.jButton2.addActionListener(this);
        this.vprin.jButton3.addActionListener(this);
        this.vprin.jButton4.addActionListener(this);
        this.user = user;
        this.crudpeli = new CRUDPelicula();
        this.peliculasSeleccionadas = new ArrayList<>();
        this.costoTotal = 0.0;
            // Inicializar el SpinnerModel con un valor inicial de 0
        SpinnerModel spinnerModel = new SpinnerNumberModel(0, 0, 0, 1);
        vprin.jSpinner1.setModel(spinnerModel);
        this.vprin.jComboBox1.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent ae) {
                String opcionSeleccionada = (String) vprin.jComboBox1.getSelectedItem();
                Pelicula pelicula = crudpeli.obtenerInformacionPelicula(opcionSeleccionada);
                if (pelicula != null) {
                // Actualizar el rango máximo del SpinnerModel con la cantidad de copias disponibles
                SpinnerNumberModel spinnerNumberModel = (SpinnerNumberModel) vprin.jSpinner1.getModel();
                spinnerNumberModel.setMaximum(pelicula.getCopias());

                // Establecer el valor del JSpinner en 0
                vprin.jSpinner1.setValue(0);
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
            modeloTabla = new DefaultTableModel();
            modeloTabla.addColumn("Título");
            modeloTabla.addColumn("Género");
            modeloTabla.addColumn("Copias");
            InsertarCliente insertc = new InsertarCliente();
            boolean tieneMembresia = insertc.verificarMembresia(user);
            if (tieneMembresia){
                opc = (String) vprin.jComboBox1.getSelectedItem();
                premium(opc);
             // Llenar el modelo con las películas seleccionadas
             // Obtener el valor actual del JSpinner
            int cantidadSeleccionada = (int) vprin.jSpinner1.getValue();
            for (String peliculaSeleccionada : peliculasSeleccionadas) {
                Pelicula pelicula = crudpeli.obtenerInformacionPelicula(peliculaSeleccionada);
                if (pelicula != null) {
                    modeloTabla.addRow(new Object[]{pelicula.getTitulo(), pelicula.getGenero(), cantidadSeleccionada});
                }
            }

            // Establecer el modelo de tabla en la interfaz de usuario
            vprin.jTable1.setModel(modeloTabla);
            }else{
                agregarPeliculaSeleccionada(opc);
                            // Llenar el modelo con las películas seleccionadas
            for (String peliculaSeleccionada : peliculasSeleccionadas) {
                Pelicula pelicula = crudpeli.obtenerInformacionPelicula(peliculaSeleccionada);
                if (pelicula != null) {
                    modeloTabla.addRow(new Object[]{pelicula.getTitulo(), pelicula.getGenero(), pelicula.getCopias()});
                }
            }

            // Establecer el modelo de tabla en la interfaz de usuario
            vprin.jTable1.setModel(modeloTabla);
            }
        }else if(this.vprin.jButton3 == ae.getSource()){
            System.out.println("yo muestro el id de las peliculas");
            // Recorrer el ArrayList de películas seleccionadas y obtener sus ID
            for (String peliculaSeleccionada : peliculasSeleccionadas) {
                int idPelicula = crudpeli.obtenerNombrePelicula(peliculaSeleccionada);
                System.out.println("ID de " + peliculaSeleccionada + ": " + idPelicula);
            }
        }else if(this.vprin.jButton4 == ae.getSource()){
            System.out.println("yo elimino la pelicula seleccionada");
            eliminarUltimoElemento(peliculasSeleccionadas);
           // Limpiar el modelo de la tabla antes de volver a llenarlo
           int cantidadSeleccionada = (int) vprin.jSpinner1.getValue();
            modeloTabla.setRowCount(0);

            for (String peliculaSeleccionada : peliculasSeleccionadas) {
                Pelicula pelicula = crudpeli.obtenerInformacionPelicula(peliculaSeleccionada);
                if (pelicula != null) {
                    // Agregar las filas actualizadas con los datos correctos
                    modeloTabla.addRow(new Object[]{pelicula.getTitulo(), pelicula.getGenero(), cantidadSeleccionada});
                }
            }

            // Establecer el modelo de tabla actualizado en la interfaz de usuario
            vprin.jTable1.setModel(modeloTabla);
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
        
        // Método para eliminar el último elemento de la lista
        public void eliminarUltimoElemento(ArrayList<String> lista) {
            if (!lista.isEmpty()) {
                lista.remove(lista.size() - 1);
            }
        }

}