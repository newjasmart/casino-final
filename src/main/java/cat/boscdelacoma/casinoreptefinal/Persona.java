package cat.boscdelacoma.casinoreptefinal;

/**
 *
 * @author TimOliver
 */
public abstract class Persona {
    private String nom;
    private String dni;
    
    public Persona(String nom, String dni) {
        this.nom = nom;
        this.dni = dni;
    }
    
    public String getNom() { return nom; }
    public void setNom(String nom) { this.nom = nom; }
    
    public String getDni() { return dni; }
    public void setDni(String dni) { this.dni = dni; }
    
    public abstract void mostrarInformacio();
}
