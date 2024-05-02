/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Model;

/**
 *
 * @author chus
 */
public class Pelicula {
    private String titulo;
//    private double precio;
    private String genero;
    private int copias;


//    public Pelicula(String titulo, double precio, int copias, String genero) {
//        this.titulo = titulo;
//        this.precio = precio;
//        this.copias = copias;
//        this.genero = genero;
//    }

    public Pelicula(String titulo, String genero, int copias) {
        this.titulo = titulo;
        this.genero = genero;
        this.copias = copias;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public int getCopias() {
        return copias;
    }

    public void setCopias(int copias) {
        this.copias = copias;
    }

    public String getGenero() {
        return genero;
    }

    public void setGenero(String genero) {
        this.genero = genero;
    }

}
