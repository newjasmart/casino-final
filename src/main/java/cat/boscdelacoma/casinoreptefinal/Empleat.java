/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package cat.boscdelacoma.casinoreptefinal;

/**
 *
 * @author TimOliver
 */
public class Empleat extends Persona {
    private String posicio;

    public Empleat(String nom, String dni, String posicio) {
        super(nom, dni);
        this.posicio = posicio;
    }

    // Sobrecàrrega del mètode mostrarInformacio
    @Override
    public void mostrarInformacio() {
        System.out.println("Empleat: " + getNom() + ", DNI: " + getDni() + ", Posició: " + posicio);
    }

    // Getters i Setters
    public String getPosicio() { return posicio; }
    public void setPosicio(String posicio) { this.posicio = posicio; }
}
