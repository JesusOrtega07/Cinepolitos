
package Controller;

import Model.CRUDPelicula;
import Model.InsertarCliente;
import Model.Pelicula;
import View.VPagar;
import View.VPremiun;
import View.VPrincipal;
import View.VRenta;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import javax.swing.JTable;
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
    ArrayList<Integer> cantidadesSeleccionadas ;
    private double costoTotal;
    String opc;
    //DefaultTableModel modeloTabla;
    //obtengo el id por medio del constructor
    
    public CPrincipal(VPrincipal vprin,String user) {
        this.vprin = vprin;
        this.vprin.jButton1.addActionListener(this);
        this.vprin.jButton2.addActionListener(this);
        this.vprin.jButton3.addActionListener(this);
        this.vprin.jButton4.addActionListener(this);
        this.vprin.jButton5.addActionListener(this);
        this.user = user;
        this.crudpeli = new CRUDPelicula();
        this.cantidadesSeleccionadas = new ArrayList<>();
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
            InsertarCliente insertc = new InsertarCliente();
            boolean tieneMembresia = insertc.verificarMembresia(user);
            opc = (String) vprin.jComboBox1.getSelectedItem();
            int cantidadSeleccionada = (int) vprin.jSpinner1.getValue();
            if (tieneMembresia){
                System.out.println("tienes membresia");
                peliculasSeleccionadas = premium(opc);
                cantidadesSeleccionadas.add(cantidadSeleccionada);//este es el array chido
                JTable tabla = crearTabla(peliculasSeleccionadas, cantidadesSeleccionadas);
                vprin.jTable1.setModel(tabla.getModel());
            }else{
                System.out.println("no tienes membresia");
                peliculasSeleccionadas = agregarPeliculaSeleccionada(opc, cantidadSeleccionada);
                cantidadesSeleccionadas.add(cantidadSeleccionada);//este es el array chido
                JTable tabla = crearTabla(peliculasSeleccionadas, cantidadesSeleccionadas);
                vprin.jTable1.setModel(tabla.getModel());
            }

        }else if(this.vprin.jButton3 == ae.getSource()){
            System.out.println("yo muestro el id de las peliculas y pago");
            // Recorrer el ArrayList de películas seleccionadas y obtener sus ID
            VPagar vpagar = new VPagar(user);
            vpagar.setVisible(true);
            for (String peliculaSeleccionada : peliculasSeleccionadas) {
                int idPelicula = crudpeli.obtenerNombrePelicula(peliculaSeleccionada);
                System.out.println("ID de " + peliculaSeleccionada + ": " + idPelicula);
            }
        }else if(this.vprin.jButton4 == ae.getSource()){
            System.out.println("yo elimino ");
                // Eliminar el último elemento de las listas
                eliminarUltimoElemento(peliculasSeleccionadas);
                eliminarUltimoElemento(cantidadesSeleccionadas);
                // Crear una nueva tabla con las listas actualizadas
                JTable tabla = crearTabla(peliculasSeleccionadas, cantidadesSeleccionadas);
                // Asignar el nuevo modelo de tabla al componente jTable1
                vprin.jTable1.setModel(tabla.getModel());
        }else if(this.vprin.jButton5 == ae.getSource()){
            System.out.println("yo mando a la venta de renta");
            VRenta vrenta = new VRenta();
            vrenta.setVisible(true);
            
        }
    }
    ///////METODOS///////////////////7
    
    
    
    
    
    private ArrayList<String> agregarPeliculaSeleccionada(String peliculaSeleccionada, int cantidadSeleccionada) {
        if (peliculaSeleccionada != null) {
            // Multiplicar el costo por la cantidad de películas seleccionadas
            costoTotal += 5.0 * cantidadSeleccionada;
            System.out.println("Costo Total: $" + costoTotal);
            // Agregar la película seleccionada al ArrayList
            peliculasSeleccionadas.add(peliculaSeleccionada);
        }
        return peliculasSeleccionadas;
    }


    private ArrayList<String> premium(String peliculaSeleccionada) {
        if (peliculaSeleccionada != null) {
            peliculasSeleccionadas.add(peliculaSeleccionada);
            if (peliculasSeleccionadas.size() > 60) {
                System.out.println("Se ha alcanzado el límite máximo de películas permitidas.");
                costoTotal += 5.0;
                System.out.println("Costo Total: $" + costoTotal);
            }
        }
        return peliculasSeleccionadas;
    }

        
        // Método para eliminar el último elemento de la lista
        public void eliminarUltimoElemento(ArrayList<?> lista) {
            if (!lista.isEmpty()) {
                lista.remove(lista.size() - 1);
            }
        }

        
        
        public JTable crearTabla(ArrayList<String> peliculasSeleccionadas, ArrayList<Integer> cantidadesSeleccionadas) {
            DefaultTableModel modeloTabla = new DefaultTableModel();

            // Agregar las columnas fijas
            modeloTabla.addColumn("Título");
            modeloTabla.addColumn("Género");
            modeloTabla.addColumn("Precio por unidad");
            modeloTabla.addColumn("Cantidad");

            // Llenar el modelo con las películas seleccionadas y la cantidad seleccionada
                    //System.out.println("Tamaño peliculas: "+peliculasSeleccionadas.size()+"Cantidades:"+cantidadesSeleccionadas.size());
            for (int i = 0; i < peliculasSeleccionadas.size(); i++) {
                String peliculaSeleccionada = peliculasSeleccionadas.get(i);
                int cantidadSeleccionada = cantidadesSeleccionadas.get(i);
                Pelicula pelicula = crudpeli.obtenerInformacionPelicula(peliculaSeleccionada);
                if (pelicula != null) {
                    modeloTabla.addRow(new Object[]{pelicula.getTitulo(), pelicula.getGenero(), pelicula.getPrecio(),cantidadSeleccionada});
                }
            }

            // Crear la tabla con el modelo configurado
            JTable tabla = new JTable(modeloTabla);
            return tabla;
        }

}