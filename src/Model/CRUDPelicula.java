/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Model;

import java.awt.List;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author david_alcazar
 */
public class CRUDPelicula extends ConexionBD{
//    
//        public DefaultTableModel MostrarDatos(){
//         Connection conexion = establecerConexion();
//            String sql = "SELECT * from Pelicula;";
//            DefaultTableModel tabla1 = new DefaultTableModel();
//             tabla1.addColumn("id_pelicula");
//             tabla1.addColumn("id_local");
//             tabla1.addColumn("titulo");
//             tabla1.addColumn("genero");
//             tabla1.addColumn("copias");
//             try{
//            Statement st = conexion.createStatement();
//            ResultSet rs = st.executeQuery(sql);
//            String [] dato = new String[5];
//                 while(rs.next()){
//                     dato[0] = rs.getString(1);
//                     dato[1] = rs.getString(2);
//                     dato[2] = rs.getString(3);
//                     dato[3] = rs.getString(4);
//                     dato[4] = rs.getString(5);
//                     tabla1.addRow(dato);
//                 }
//             } catch (SQLException e) {
//                 JOptionPane.showMessageDialog(null, "EL REGISTRO FALLO"+e, "MENSAJE", JOptionPane.ERROR_MESSAGE);
//             }
//        return tabla1;
//    }
        // Método para obtener los nombres de las películas desde la base de datos
    public ArrayList<String> obtenerNombresPeliculas() {
        ArrayList<String> nombresPeliculas = new ArrayList<>();

        try (Connection conexion = establecerConexion();
             Statement statement = conexion.createStatement()) {
            String sql = "SELECT titulo FROM Pelicula";
            ResultSet resultSet = statement.executeQuery(sql);

            while (resultSet.next()) {
                nombresPeliculas.add(resultSet.getString("titulo"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return nombresPeliculas;
    }
  
}
