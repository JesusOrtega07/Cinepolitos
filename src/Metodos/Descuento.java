/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Metodos;

/**
 *
 * @author chus
 */
public class Descuento {
    public float Descuento(float precio, int descuento){ // Metodo que retorna el precio descontado en base a la sucursal
        return precio - (precio*((float) descuento/100));
    }
    
    public static void main(String[] args) {
        Descuento d = new Descuento();
        System.out.println("F"+d.Descuento(1000,50));
    }
}
