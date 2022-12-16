package hibernateprepersistbug;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import static org.junit.jupiter.api.Assertions.assertEquals;

class HibernatePrePersistTwiceBugTest {

    static EntityManagerFactory factory;

    @Test
    void testCallback() {
        EntityManager em = factory.createEntityManager();
        em.getTransaction().begin();

        ChessFigure queen = new ChessFigure("D", 1, "Queen");

        em.persist(queen);
        em.getTransaction().commit();

        em.close();

        assertEquals(2, queen.getCounter());
    }

    @BeforeAll
    static void init() {
        factory = Persistence.createEntityManagerFactory("pu");
    }

    @AfterAll
    static void stop() {
        if(factory != null) {
            factory.close();
        }
    }
}
