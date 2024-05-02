/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Model;

import java.sql.PreparedStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

/**
 *
 * @author david_alcazar
 */
public class CRUDPelicula extends ConexionBD{

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
    // Método para obtener información de una película específica desde la base de datos
     public Pelicula obtenerInformacionPelicula(String nombrePelicula) {
        Pelicula pelicula = null;

        try (Connection conexion = establecerConexion();
            PreparedStatement statement = conexion.prepareStatement("SELECT titulo, genero, copias FROM Pelicula WHERE titulo = ?")) {
            statement.setString(1, nombrePelicula);
            ResultSet resultSet = statement.executeQuery();

            if (resultSet.next()) {
                String titulo = resultSet.getString("titulo");
                String genero = resultSet.getString("genero");
                int copias = resultSet.getInt("copias");

                pelicula = new Pelicula(titulo, genero, copias);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return pelicula;
    }
     

  
}
