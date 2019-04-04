package pl.ml.UserController;

import org.apache.log4j.Level;
import org.apache.log4j.Logger;
import org.hibernate.Session;
import pl.ml.HibernateUtil;

import javax.persistence.NoResultException;

/**
 * @author Remigiusz Zudzin
 */
public class UserController {

    private static Session session;

    private final static Logger logger = Logger.getLogger(UserController.class);

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
        session = HibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();

    }

    /**
     * try catch subsides if statement, where user is not null this method will always return true because
     * user exists, otherwise this part of code goes straight to catch block.
     */
    public static boolean checkIfLoginExists(String userName) {
        session = HibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();

        Users user;

        try {
            user = (Users) session.createQuery(
                    "FROM Users "
                            + "WHERE USER_NAME = '"
                            + userName
                            + "'")
                    .getSingleResult();
            return true;
        } catch (NoResultException e) {
            logger.log(Level.WARN,
                    "Sprawdzono: "
                            + " OBIEKT NIE ISTNIEJE");
            return false;
        } finally {
            session.close();
        }
    }

    public static boolean checkIfLoginMatchesPassword(String userName, String password) {
        if (!checkIfLoginExists(userName)) {
            logger.log(Level.INFO, "Wrong login, or password!");
        } else {
            try {
                session = HibernateUtil.getSessionFactory().openSession();
                session.beginTransaction();
                session.createQuery(
                        "FROM Users "
                                + "WHERE USER_NAME = '"
                                + userName
                                + "'"
                                + " AND PASSWORD = '"
                                + password
                                + "'")
                        .getSingleResult();
                return true;
            } catch (NoResultException e) {
                logger.log(Level.INFO,
                        "Sprawdzono: "
                                + "HASŁO BŁĘDNE");
                return false;
            } finally {
                session.close();
            }
        }
        return false;
    }
}
