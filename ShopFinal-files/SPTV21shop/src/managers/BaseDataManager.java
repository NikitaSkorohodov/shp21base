/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package managers;

import enyity.Product;
import enyity.Client;
import enyity.History;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
/**
 *
 * 
 * @author user
 */
public class BaseDataManager {
    private EntityManagerFactory emf = Persistence.createEntityManagerFactory("SPTV21shopPU");
    private EntityManager em = emf.createEntityManager();
    private EntityTransaction tx = em.getTransaction();
          
    public void saveProducts(Product [] products){
        tx.begin();
        for (int i = 0; i < products.length;i++) {
            Product product = products[i];
            if(product.getId() == null){
                em.persist(product);
            }else{
                em.merge(product);
            }
        }
        tx.commit();
    }
    
    public List<Product> loadProduct() {
        try {
            return em.createQuery("SELECT b FROM Book b")
                    .getResultList();
        } catch (Exception e) {
            return new ArrayList<>();
        }
    }
    public void saveClients(List<Client> Clients){
        tx.begin();
            for (int i = 0; i < Clients.size(); i++) {
                Client reader = Clients.get(i);
                if(reader.getId() == null){
                    em.persist(reader);
                }else{
                    em.merge(reader);
                }
            }
        tx.commit();
    }

    public List<Client> loadClients() {
        try {
            return em.createQuery("SELECT r FROM Reader r")
                    .getResultList();
        } catch (Exception e) {
            return new ArrayList<>();
        }
    }
    
    public void saveHistories(List<History> histories){
        tx.begin();
            for (int i = 0; i < histories.size(); i++) {
                History history = histories.get(i);
                if(history.getId() == null){
                    em.persist(history);
                }else{
                    em.merge(history);
                }
            }
        tx.commit();
    }
    
    public List<History> loadHistories() {
        try {
            return em.createQuery("SELECT h FROM History h")
                    .getResultList();
        } catch (Exception e) {
            return new ArrayList<>();
        }
    }

    
}