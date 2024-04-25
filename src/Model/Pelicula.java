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
    private int idPeli;
    private int idLocal;
    private String titulo;
    private String genero;
    private int copias;

    public Pelicula(int idPeli, int idLocal, String titulo, String genero, int copias) {
        this.idPeli = idPeli;
        this.idLocal = idLocal;
        this.titulo = titulo;
        this.genero = genero;
        this.copias = copias;
    }

    public int getIdPeli() {
        return idPeli;
    }

    public void setIdPeli(int idPeli) {
        this.idPeli = idPeli;
    }

    public int getIdLocal() {
        return idLocal;
    }

    public void setIdLocal(int idLocal) {
        this.idLocal = idLocal;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getGenero() {
        return genero;
    }

    public void setGenero(String genero) {
        this.genero = genero;
    }

    public int getCopias() {
        return copias;
    }

    public void setCopias(int copias) {
        this.copias = copias;
    }
}
