/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controller;

/**
 *
 * @author chus
 */
public class InsertarCliente {
    
    
    public String insertarCliente(String nomUsuario, String membresia, String nom_socio, String direccion_socio, String telefono, String saldo){
        String sql = "INSERT INTO Cliente (nomUsuario, membresia, nom_socio, direccion_socio, telefono, saldo) VALUES (";
        sql = sql + nomUsuario +", "+ membresia +", "+ nom_socio +", "+ direccion_socio +", "+ telefono +", "+ saldo +")";
        
        return sql;
    }
    public static void main(String[] args) {
        InsertarCliente p = new InsertarCliente();
        
        System.out.println("P: "+p.insertarCliente("Pedro23", "1", "Juan Pedro", "Poray", "9439", "10"));
    }
}
