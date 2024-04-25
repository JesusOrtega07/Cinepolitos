/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Model;

/**
 *
 * @author chus
 */
public class PagoR {
    private String nomCliente;
    private int NoPago;
    private String beneficiario;
    private float importe;

    public PagoR(String nomCliente, int NoPago, String beneficiario, float importe) {
        this.nomCliente = nomCliente;
        this.NoPago = NoPago;
        this.beneficiario = beneficiario;
        this.importe = importe;
    }

    public String getNomCliente() {
        return nomCliente;
    }

    public void setNomCliente(String nomCliente) {
        this.nomCliente = nomCliente;
    }

    public int getNoPago() {
        return NoPago;
    }

    public void setNoPago(int NoPago) {
        this.NoPago = NoPago;
    }

    public String getBeneficiario() {
        return beneficiario;
    }

    public void setBeneficiario(String beneficiario) {
        this.beneficiario = beneficiario;
    }

    public float getImporte() {
        return importe;
    }

    public void setImporte(float importe) {
        this.importe = importe;
    }
    
    
}
