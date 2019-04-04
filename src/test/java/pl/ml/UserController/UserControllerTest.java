package pl.ml.UserController;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

/**
 * @author Remigiusz Zudzin
 */
class UserControllerTest {

    static Users user;

    @BeforeEach
    void setup() {
        user = new Users();
        user.setFirstName("Jan");
        user.setLastName("Kowalski");
        user.setUserName("Janusz");
        user.setPassword("dupa");
    }

    @Test
    void registerUser() {
        //TODO from java to sql
        UserController uC = new UserController();
//        assertAll("User assertion",
//                () -> assertEquals(user.equals()));

    }
}