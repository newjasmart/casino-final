package cat.boscdelacoma.casinoreptefinal.Classes;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author TimOliver
 */
public class Casino {
    private String nom;
    private List<Joc> jocs;

    public Casino(String nom) {
        this.nom = nom;
        this.jocs = new ArrayList<>();
    }

    // Mètodes per gestionar jocs
    public void afegirJoc(Joc joc) {
        jocs.add(joc);
    }

    public void eliminarJoc(Joc joc) {
        jocs.remove(joc);
    }

    public List<Joc> getJocs() {
        return jocs;
    }

    // Getters i Setters
    public String getNom() { return nom; }
    public void setNom(String nom) { this.nom = nom; }
}