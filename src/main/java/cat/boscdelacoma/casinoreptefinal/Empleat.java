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
    private int posicio;
    
    public Empleat() {
        super("", ""); // Crida al constructor de la classe Persona amb valors per defecte
        this.posicio = 0; // Valor per defecte per a la posició
    }

    public Empleat(String nom, String dni, int posicio) {
        super(nom, dni);
        this.posicio = posicio;
    }

    // Sobrecàrrega del mètode mostrarInformacio
    @Override
    public void mostrarInformacio() {
        System.out.println("Empleat: " + getNom() + ", DNI: " + getDni() + ", Posició: " + posicio);
    }

    // Getters i Setters
    public int getPosicio() { return posicio; }
    public void setPosicio(int posicio) { this.posicio = posicio; }
}
