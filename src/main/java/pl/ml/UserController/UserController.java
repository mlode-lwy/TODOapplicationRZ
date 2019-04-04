package pl.ml.UserController;

import org.apache.log4j.Level;
import org.apache.log4j.Logger;
import org.hibernate.Session;
import pl.ml.HibernateUtil;

/**
 * @author Remigiusz Zudzin
 */
public class UserController {

    static Session session;

    public final static Logger logger = Logger.getLogger(UserController.class);

    public static void registerUser() {

        session = HibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();

        Users user = new Users();
        user.setFirstName("Jan");
        user.setLastName("Kowalski");
        user.setUserName("Janusz");
        user.setPassword("dupa");

        logger.log(Level.WARN, "Dodano: "
                + " Imię: "
                + user.getFirstName()
                + ", Nazwisko: "
                + user.getLastName()
                + ", Nick: "
                + user.getUserName());

        session.save(user);
        session.getTransaction().commit();
        session.close();

    }

    public static void logIn() {
        HibernateUtil.getSessionFactory().openSession();
    }

    public static boolean checkIfLoginExists(String userName) {

        session = HibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();

        Users user = new Users();

        user = (Users) session.createQuery(
                "FROM Users "
                        + "WHERE USER_NAME = \""
                        + userName
                        + "\"")
                .getSingleResult();

        if (user != null) {
            logger.log(Level.WARN, "Sprawdzono: "
                    + " Imię: "
                    + user.getFirstName()
                    + ", Nazwisko: "
                    + user.getLastName()
                    + ", Nick: "
                    + user.getUserName()
                    + " OBIEKT ISTNIEJE");
            return true;
        }

        logger.log(Level.WARN, "Sprawdzono: "
                + " Imię: "
                + user.getFirstName()
                + ", Nazwisko: "
                + user.getLastName()
                + ", Nick: "
                + user.getUserName()
                + " OBIEKT NIEISTNIEJE");

        return false;

    }



}
