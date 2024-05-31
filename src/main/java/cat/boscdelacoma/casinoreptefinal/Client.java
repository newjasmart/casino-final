/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package cat.boscdelacoma.casinoreptefinal;

/**
 *
 * @author TimOliver
 */
public class Client extends Persona {
    private int puntsFidelitat;
    
    public Client() {
        super("Nom", "DNI"); // set default values for nom and dni
        this.puntsFidelitat = 0; // set default value for puntsFidelitat
    }

    public Client(String nom, String dni, int puntsFidelitat) {
        super(nom, dni);
        this.puntsFidelitat = puntsFidelitat;
    }

    // Sobrecàrrega del mètode mostrarInformacio
    @Override
    public void mostrarInformacio() {
        System.out.println("Client: " + getNom() + ", DNI: " + getDni() + ", Punts de Fidelitat: " + puntsFidelitat);
    }

    // Getters i Setters
    public int getPuntsFidelitat() { return puntsFidelitat; }
    public void setPuntsFidelitat(int puntsFidelitat) { this.puntsFidelitat = puntsFidelitat; }
}