/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Model;

/**
 *
 * @author chus
 */
public class Renta {
    private String nomCliente;
    private String idPelicula;
    private String fechaPrestamo;
    private String fechaDevolucion;
    private String diasRentados;
    private float precio;
    private int descuento;
    private float total;

    public Renta(String nomCliente, String idPelicula, String fechaPrestamo, String fechaDevolucion, String diasRentados, float precio, int descuento, float total) {
        this.nomCliente = nomCliente;
        this.idPelicula = idPelicula;
        this.fechaPrestamo = fechaPrestamo;
        this.fechaDevolucion = fechaDevolucion;
        this.diasRentados = diasRentados;
        this.precio = precio;
        this.descuento = descuento;
        this.total = total;
    }

    public String getNomCliente() {
        return nomCliente;
    }

    public void setNomCliente(String nomCliente) {
        this.nomCliente = nomCliente;
    }

    public String getIdPelicula() {
        return idPelicula;
    }

    public void setIdPelicula(String idPelicula) {
        this.idPelicula = idPelicula;
    }

    public String getFechaPrestamo() {
        return fechaPrestamo;
    }

    public void setFechaPrestamo(String fechaPrestamo) {
        this.fechaPrestamo = fechaPrestamo;
    }

    public String getFechaDevolucion() {
        return fechaDevolucion;
    }

    public void setFechaDevolucion(String fechaDevolucion) {
        this.fechaDevolucion = fechaDevolucion;
    }

    public String getDiasRentados() {
        return diasRentados;
    }

    public void setDiasRentados(String diasRentados) {
        this.diasRentados = diasRentados;
    }

    public float getPrecio() {
        return precio;
    }

    public void setPrecio(float precio) {
        this.precio = precio;
    }

    public int getDescuento() {
        return descuento;
    }

    public void setDescuento(int descuento) {
        this.descuento = descuento;
    }

    public float getTotal() {
        return total;
    }

    public void setTotal(float total) {
        this.total = total;
    }

    
    
}
