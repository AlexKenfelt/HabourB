package facades;

import dtos.BoatDTO;
import dtos.OwnerDTO;
import dtos.OwnersDTO;
import entities.Boat;
import entities.Owner;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.TypedQuery;
import java.util.List;

public class HarbourFacade {

    private static EntityManagerFactory emf;
    private static HarbourFacade instance;

    public HarbourFacade() {
    }

    public static HarbourFacade getHarbourFacade(EntityManagerFactory _emf) {
        if (instance == null) {
            emf = _emf;

            instance = new HarbourFacade();
        }
        return instance;
    }

    private EntityManager getEntityManager() {
        return emf.createEntityManager();
    }


    // vi henter en liste af owners ud og skal derfor være af den type dto vi bruger
    public OwnersDTO getAllOwners () {
        EntityManager em = emf.createEntityManager();
        try{
            em.getTransaction().begin();
            TypedQuery<Owner> query = em.createNamedQuery("Owner.getAllRows", Owner.class);
            List<Owner> result = query.getResultList();
            OwnersDTO dto = new OwnersDTO(result);
            em.getTransaction().commit();
            return dto;

        }catch (Exception e) {

        }finally {
            em.close();

        }
        return null;
    }

    public Boat createBoat (Boat boat) {
        EntityManager em = emf.createEntityManager();
        try {
            em.getTransaction().begin();

            boat.setName(boat.getName());
            boat.setBrand(boat.getBrand());
            boat.setMake(boat.getMake());
            boat.setImage(boat.getImage());

            em.persist(boat);
            em.getTransaction().commit();
        } finally {
            em.close();
        }

        return boat;
    }

}
