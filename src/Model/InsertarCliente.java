/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Model;

import javax.swing.JOptionPane;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
/**
 *
 * @author chus
 */
public class InsertarCliente extends ConexionBD{

//    public String insertarCliente(String nomUsuario, String membresia, String nom_socio, String direccion_socio, String telefono, String saldo){
//        
//        String sql = "INSERT INTO Cliente (nomUsuario, membresia, nom_socio, direccion_socio, telefono, saldo) VALUES (";
//        sql = sql + nomUsuario +", "+ membresia +", "+ nom_socio +", "+ direccion_socio +", "+ telefono +", "+ saldo +")";
//        
//        return sql;
//    }

    public void insertarC(String nomUsuario, String nom_socio, String direccion_socio, String genero, String tel) {
        try {
            Connection conexion = establecerConexion();
            String sql = "INSERT INTO Cliente (nomUsuario, nom_socio, direccion_socio, Gender, telefono) VALUES (?, ?, ?, ?, ?)";
            PreparedStatement pst = conexion.prepareStatement(sql);

            // Establecer los parámetros en el PreparedStatement
            pst.setString(1, nomUsuario);
            pst.setString(2, nom_socio);
            pst.setString(3, direccion_socio);
            pst.setString(4, genero);
            pst.setString(5, tel);

            // Ejecutar la consulta preparada
            pst.executeUpdate();

            // Cerrar recursos
            pst.close();
            conexion.close();

            JOptionPane.showMessageDialog(null, "EL REGISTRO SE AGREGÓ", "MENSAJE", JOptionPane.INFORMATION_MESSAGE);
        } catch(SQLException e) {
            JOptionPane.showMessageDialog(null, "EL REGISTRO FALLO: " + e.getMessage(), "MENSAJE", JOptionPane.ERROR_MESSAGE);
        }
    }
    
    public boolean existeID(String id) {
        try {
            Connection conexion = establecerConexion();
            String sql = "SELECT COUNT(*) AS conteo FROM Cliente WHERE nomUsuario = ?";
            PreparedStatement pst = conexion.prepareStatement(sql);
            pst.setString(1, id);
            ResultSet rs = pst.executeQuery();
            if (rs.next()) {
                int conteo = rs.getInt("conteo");
                return conteo > 0; // Si el conteo es mayor que cero, significa que el ID ya está en uso
            }
            pst.close();
            conexion.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false; // En caso de error o si no se encuentra el ID
    }

   

    
//    public static void main(String[] args) {
//        InsertarCliente p = new InsertarCliente();
//        
//        System.out.println("P: "+p.insertarCliente("Pedro23", "1", "Juan Pedro", "Poray", "9439", "10"));
//    }
}
