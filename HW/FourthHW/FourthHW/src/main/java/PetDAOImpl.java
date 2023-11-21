import DAO.PetDAO;
import POJO.Pet;
import org.hibernate.SessionFactory;

import java.io.Serializable;

public class PetDAOImpl implements PetDAO {
    private SessionFactory sessionFactory;

    public PetDAOImpl(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    @Override
    public void createPet(Pet pet) {
        if (pet == null) {
            System.out.println("Pet cannot be null");
            return;
        }
        var session = sessionFactory.openSession();
        session.beginTransaction();
        session.save(pet);
        session.getTransaction().commit();
        session.close();
    }

    @Override
    public void exercise6(Pet pet) {
        if (pet == null) {
            System.out.println("Pet can not be null");
            return;
        }
        var session = sessionFactory.openSession();
        session.beginTransaction();
        Serializable save = session.save(pet);
        session.getTransaction().commit();
        session.close();
        var session1 = sessionFactory.openSession();
        session1.beginTransaction();
        var userResult = session1.get(Pet.class, save);
        System.out.println("Persistent Pet ID: " + userResult.getPetID());
        session1.getTransaction().commit();
        session1.close();
    }
}
