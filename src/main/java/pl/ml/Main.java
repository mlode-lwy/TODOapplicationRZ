package pl.ml;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import org.apache.log4j.BasicConfigurator;
import org.apache.log4j.Level;
import org.apache.log4j.Logger;

/**
 * @author Remigiusz Zudzin
 */
public class Main extends Application {

    public final static Logger logger = Logger.getLogger(Main.class);

    public static void something() {

//        BasicConfigurator.configure();
//        logger.setLevel(Level.ALL);
//        UserController.registerUser();
//        UserController.checkIfLoginExists("dfs");
//
//        SessionFactory factory = HibernateUtil.getSessionFactory();
//        Session session = factory.openSession();
//        Transaction transaction;
//
//        try {
//            transaction = session.beginTransaction();
//            transaction.commit();
//        } catch (Exception e) {
//            e.printStackTrace();
//        } finally {
//            session.close();
//        }

    }

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) throws Exception {
        BasicConfigurator.configure();
        logger.setLevel(Level.ALL);

        FXMLLoader fxmlLoader = new FXMLLoader();
        fxmlLoader.setLocation(getClass().getResource("/logscreen.fxml"));
        fxmlLoader.load();
        Parent root = fxmlLoader.getRoot();
        primaryStage.setScene(new Scene(root));
        primaryStage.show();

    }
}
