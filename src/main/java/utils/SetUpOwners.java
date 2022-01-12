package utils;

import entities.Owner;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;

public class SetUpOwners {

    public static void main(String[] args) {
        EntityManagerFactory emf = EMF_Creator.createEntityManagerFactory();
        EntityManager em = emf.createEntityManager();

        Owner ow1 = new Owner("Bo", "Hammervej", 12345678);
        Owner ow2 = new Owner("Hans", "Birkevej", 1111111);
        Owner ow3 = new Owner("Bodil", "Sommervej", 88888888);

        em.getTransaction().begin();
        em.persist(ow1);
        em.persist(ow2);
        em.persist(ow3);
        em.getTransaction().commit();
    }
}
