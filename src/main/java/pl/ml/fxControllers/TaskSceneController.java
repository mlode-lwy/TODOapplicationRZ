package pl.ml.fxControllers;

import javafx.beans.property.SimpleStringProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import lombok.Data;
import org.apache.log4j.Logger;
import org.hibernate.Session;
import pl.ml.HibernateUtil;
import pl.ml.TaskController.Tasks;
import pl.ml.UserController.UserController;
import pl.ml.UserController.Users;

import javax.persistence.TypedQuery;
import java.net.URL;
import java.util.ResourceBundle;

/**
 * @author Remigiusz Zudzin
 */
@Data
public class TaskSceneController implements Initializable {

    private static Session session;

    private final static Logger logger = Logger.getLogger(UserController.class);

    private Users user;

    @FXML
    private MenuItem newMenuItem;

    @FXML
    private MenuItem deleteMenuItem;

    @FXML
    private MenuItem closeMenuItem;

    @FXML
    private MenuItem editMenuItem;

    @FXML
    private MenuItem toDoTaskMenuItem;

    @FXML
    private MenuItem inProgressTaskMenuItem;

    @FXML
    private MenuItem doneTaskMenuItem;

    @FXML
    private Label descriptionLabel;

    @FXML
    private TableView<Tasks> taskTableView;

    @FXML
    private TableColumn<Tasks, String> taskTableColumn;

    @FXML
    private Button doneButton;

    private ObservableList<Tasks> tasksObservableList = FXCollections.observableArrayList();

    @Override
    public void initialize(URL location, ResourceBundle resources) {

    }

    public void loadTasks() {
        session = HibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();
        TypedQuery<Tasks> query = session.createQuery(
                "FROM Tasks "
                + "WHERE USER_ID ='"
                + user.getUser_id()
                + "'", Tasks.class);

        tasksObservableList = FXCollections.<Tasks> observableArrayList(query.getResultList());
        taskTableView.setItems(tasksObservableList);
        taskTableColumn.setText("Nazwa taska");
        taskTableColumn.setCellValueFactory(c -> new SimpleStringProperty(c.getValue().getTaskName()));
    }
}
