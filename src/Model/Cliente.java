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
<<<<<<< HEAD
    
    private int id_socio;
=======
    private String nomUsuario;
>>>>>>> 8cbd863a57116bd94bb6d73f823b0dba6783258e
    private boolean membresia;
    private String nom_socio;
    private String direc_socio;
    private String telefono;

    public Cliente(String nomUsuario, boolean membresia, String nom_socio, String direc_socio, String telefono) {
        this.nomUsuario = nomUsuario;
        this.membresia = membresia;
        this.nom_socio = nom_socio;
        this.direc_socio = direc_socio;
        this.telefono = telefono;
    }

    public String getNomUsuario() {
        return nomUsuario;
    }

    public void setNomUsuario(String nomUsuario) {
        this.nomUsuario = nomUsuario;
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
