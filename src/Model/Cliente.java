/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Model;

/**
 *
 * @author chus
 */
public class Cliente {
    private int id_socio;
    private boolean membresia;
    private String nom_socio;
    private String direc_socio;
    private String telefono;

    public Cliente(int id_socio, boolean membresia, String nom_socio, String direc_socio, String telefono) {
        this.id_socio = id_socio;
        this.membresia = membresia;
        this.nom_socio = nom_socio;
        this.direc_socio = direc_socio;
        this.telefono = telefono;
    }

    public int getId_socio() {
        return id_socio;
    }

    public void setId_socio(int id_socio) {
        this.id_socio = id_socio;
    }

    public boolean isMembresia() {
        return membresia;
    }

    public void setMembresia(boolean membresia) {
        this.membresia = membresia;
    }

    public String getNom_socio() {
        return nom_socio;
    }

    public void setNom_socio(String nom_socio) {
        this.nom_socio = nom_socio;
    }

    public String getDirec_socio() {
        return direc_socio;
    }

    public void setDirec_socio(String direc_socio) {
        this.direc_socio = direc_socio;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    
}
