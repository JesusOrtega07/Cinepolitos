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
import java.sql.CallableStatement;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

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
     
     public int obtenerNombrePelicula(String peli){
         try(Connection conexion = establecerConexion();
                 PreparedStatement statement = conexion.prepareStatement("SELECT Id_pelicula FROM pelicula WHERE titulo = ?")){
             statement.setString(1,peli);
             ResultSet resultSet = statement.executeQuery();
             
             if(resultSet.next()){
                int id = resultSet.getInt("Id_pelicula");
                return id;
             }
             
         }catch (SQLException e){
             e.printStackTrace();
         }
         return 0;
     }
     
     public void rentaPelicula(String nomUsuario, int idPelicula){
         try (Connection conexion = establecerConexion(); CallableStatement cStatement = conexion.prepareCall("{CALL rentar_pelicula(?, ?)}")){
             cStatement.setString(1, nomUsuario);
             cStatement.setInt(2, idPelicula);
             cStatement.execute();
         } catch (SQLException ex) {
            Logger.getLogger(CRUDPelicula.class.getName()).log(Level.SEVERE, null, ex);
        }
     }

    public void depositarSaldo(String nomUsuario, int importe) { // Metodo creado para agregar salfo a la cuenta del usaurio
        try (Connection conexion = establecerConexion();
             CallableStatement statement = conexion.prepareCall("{CALL depositarSaldo(?, ?)}")) {

            statement.setString(1, nomUsuario);
            statement.setInt(2, importe);

            statement.execute();
            System.out.println("Depostio realizado");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    
    public void pagarCuenta(String nomUsuario) { // Metodo para  pagar la cuenta del usuario, liquida todas sus deudas
     ArrayList<Integer> IDs = new ArrayList<>();
     try (Connection conexion = establecerConexion();
          CallableStatement cStatement = conexion.prepareCall("{CALL transferirSaldoDesdeRenta(?)}")) {
         
         try (PreparedStatement pStatement = conexion.prepareStatement("SELECT * FROM obtenerDeudasCliente(?)")) { // Try para obtener las deudas de los clientes
             pStatement.setString(1, nomUsuario);
             ResultSet resultset = pStatement.executeQuery();

             while (resultset.next()) {
                 IDs.add(resultset.getInt("id_renta"));
             }
             System.out.println(IDs);
         }
         
         cStatement.setString(1, nomUsuario);
         cStatement.execute();
         System.out.println("Cobro exitoso");
         
         for (int id: IDs){
             liquidar(id);
         }
         
     } catch (SQLException e) {
         e.printStackTrace();
     }
 }
    
    public void liquidar(int id_renta){
    try (Connection conexion = establecerConexion(); CallableStatement cStatement = conexion.prepareCall("{CALL liquidar_renta(?)}")){
        cStatement.setInt(1, id_renta);
        cStatement.execute();
        
    } catch (SQLException ex) {
        Logger.getLogger(CRUDPelicula.class.getName()).log(Level.SEVERE, null, ex);
    }
}
    
    public int montoPagar(){
       return 0; 
    }
    public static void main(String[] args) {
        CRUDPelicula p = new CRUDPelicula();
        //ystem.out.println(p.obtenerInformacionPelicula("Luca"));
        p.rentaPelicula("xxdanxx", 5);
    }

}


