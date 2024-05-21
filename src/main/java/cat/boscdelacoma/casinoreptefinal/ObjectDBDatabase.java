/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package cat.boscdelacoma.casinoreptefinal;

/**
 *
 * @author TimOliver
 */
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.util.List;

public class ObjectDBDatabase {
    private EntityManagerFactory emf = Persistence.createEntityManagerFactory("$objectdb/db/casino.odb");

    public void inserirClient(Client client) {
        EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();
        em.persist(client);
        em.getTransaction().commit();
        em.close();
    }

    public List<Client> obtenirClients() {
        EntityManager em = emf.createEntityManager();
        List<Client> clients = em.createQuery("SELECT c FROM Client c", Client.class).getResultList();
        em.close();
        return clients;
    }
}