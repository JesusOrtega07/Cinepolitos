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
import java.util.Date;
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

    public void insertarC(String nomUsuario, boolean membresia ,String nom_socio,int edad, String direccion_socio, String tel, float saldo) {
        try {
            Connection conexion = establecerConexion(); 
            String sql = "INSERT INTO Cliente (nomUsuario, membresia ,nom_socio, edad, direccion_socio, telefono, saldo) VALUES (?, ?, ?, ?, ?, ?, ?)";
            PreparedStatement pst = conexion.prepareStatement(sql);

            // Establecer los parámetros en el PreparedStatement
            pst.setString(1, nomUsuario);
            pst.setBoolean(2, membresia);
            pst.setString(3, nom_socio);
            pst.setInt(4, edad);
            pst.setString(5, direccion_socio);
            pst.setString(6, tel);
            pst.setFloat(7, saldo);

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
    
    public boolean buscarUser(String id) {
        String sql = "SELECT COUNT(*) FROM Cliente WHERE nomUsuario = ?";

        try (Connection conexion = establecerConexion();
             PreparedStatement ps = conexion.prepareStatement(sql)) {
            ps.setString(1, id);

            try (ResultSet rs = ps.executeQuery()) {
                if (rs.next()) {
                    return rs.getInt(1) > 0; // Devuelve true si se encontraron resultados, false en caso contrario
                } else {
                    return false; // No se encontraron resultados
                }
            }
        } catch (SQLException e) {
            //JOptionPane.showMessageDialog(null, "Error al realizar la búsqueda: " + e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
            return false; // Si ocurre un error, retornamos false
        }
    }
    
    public Date[] insertarClienteYObtenerFechasMembresia(String idCliente) {
        Date fechaInicio = null;
        Date fechaFinal = null;

        try {
            Connection conexion = establecerConexion();

            // Inserción del cliente en la tabla Membresia
            String sqlInsert = "INSERT INTO Membresia (nomUsuario) VALUES (?)";
            PreparedStatement pstInsert = conexion.prepareStatement(sqlInsert);
            pstInsert.setString(1, idCliente);
            pstInsert.executeUpdate();
            pstInsert.close();

            // Consulta para obtener las fechas de membresía después de la inserción
            String sqlSelect = "SELECT fecha_alta, fecha_baja FROM Membresia WHERE nomUsuario = ?";
            PreparedStatement pstSelect = conexion.prepareStatement(sqlSelect);
            pstSelect.setString(1, idCliente);
            ResultSet rs = pstSelect.executeQuery();

            if (rs.next()) {
                fechaInicio = rs.getDate("fecha_alta");
                fechaFinal = rs.getDate("fecha_baja");
            }

            rs.close();
            pstSelect.close();
            // Actualización de la membresía del cliente
            String sqlUpdate = "UPDATE Cliente SET membresia = true WHERE nomUsuario = ?";
            PreparedStatement pstUpdate = conexion.prepareStatement(sqlUpdate);
            pstUpdate.setString(1, idCliente);
            pstUpdate.executeUpdate();
            pstUpdate.close();
            conexion.close();
        } catch (SQLException e) {
            e.printStackTrace();
            // Manejo de excepciones
        }
        // Devolver las fechas como un arreglo
        return new Date[]{fechaInicio, fechaFinal};
    }
    
        public boolean verificarMembresia(String idCliente) {
        try {
            Connection conexion = establecerConexion();
            // Consulta para obtener el estado de la membresía del cliente
            String sqlSelect = "SELECT membresia FROM Cliente WHERE nomUsuario = ?";
            PreparedStatement pstSelect = conexion.prepareStatement(sqlSelect);
            pstSelect.setString(1, idCliente);
            ResultSet rs = pstSelect.executeQuery();

            if (rs.next()) {
                boolean tieneMembresia = rs.getBoolean("membresia");
                return tieneMembresia;
            }

            rs.close();
            pstSelect.close();
            conexion.close();
        } catch (SQLException e) {
            e.printStackTrace();
            // Manejo de excepciones
        }
        // Si hubo un error o el cliente no tiene membresía, retornar false
        return false;
    }


   

    
//    public static void main(String[] args) {
//        InsertarCliente p = new InsertarCliente();
//        
//        System.out.println("P: "+p.insertarCliente("Pedro23", "1", "Juan Pedro", "Poray", "9439", "10"));
//    }
}
