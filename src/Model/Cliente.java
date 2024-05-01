
package Model;

import java.math.BigDecimal;

/**
 *
 * @author chus
 */
public class Cliente {
    
//    aqui no podemos crear el obj porque nos faltaria 
//    si es miembro osea al para ingresar al usuario si tiene membresia se debe registrar
//    pensaba hacerlo en la mismna vista pero no se puede, planeo poner esa opcion en la vista
//    donde seleccionas las peliculas
    //este es el main
//    Odio no sbaer github
    //esta es la rama prueba

    
    private String nomUsuario;
    private boolean membresia; 
    private String nom_socio;
    private int edad;
    private String direc_socio;
    private String telefono;
    private double saldo;

//    public Cliente(String nomUsuario, boolean membresia, String nom_socio, String direc_socio, String gender, String telefono) {
//        this.nomUsuario = nomUsuario;
//        this.membresia = membresia;
//        this.nom_socio = nom_socio;
//        this.direc_socio = direc_socio;
//        this.gender = gender;
//        this.telefono = telefono;
//    }

    public Cliente(String nomUsuario, boolean membresia, String nom_socio, int edad, String direc_socio, String telefono, double saldo) {
        this.nomUsuario = nomUsuario;
        this.membresia = membresia;
        this.nom_socio = nom_socio;
        this.edad = edad;
        this.direc_socio = direc_socio;
        this.telefono = telefono;
        this.saldo = saldo;
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

    public int getEdad() {
        return edad;
    }

    public void setEdad(int edad) {
        this.edad = edad;
    }

    public double getSaldo() {
        return saldo;
    }

    public void setSaldo(double saldo) {
        this.saldo = saldo;
    }
}
