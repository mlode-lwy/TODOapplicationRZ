package pl.ml.TaskController;

import javax.persistence.*;

/**
 * @author Remigiusz Zudzin
 */

@Entity
@Table(name = "tasks")
public class Tasks {

    @Id
    @Column(name = "TASK_ID")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int task_id;

    @Column(name = "TASK_NAME")
    private String taskName;

    @Column(name = "TASK_DESC")
    private String taskDesc;

    @Column(name = "DUE_DATE")
    private String dueDate;

    @Column(name = "STATUS")
    @Enumerated(EnumType.STRING)
    private TaskStatus status;

    @Column(name = "USER_ID")
    private int userId;

    public int getTask_id() {
        return task_id;
    }

    public void setTask_id(int task_id) {
        this.task_id = task_id;
    }

    public String getTaskName() {
        return taskName;
    }

    public void setTaskName(String taskName) {
        this.taskName = taskName;
    }

    public String getTaskDesc() {
        return taskDesc;
    }

    public void setTaskDesc(String taskDesc) {
        this.taskDesc = taskDesc;
    }

    public String getDueDate() {
        return dueDate;
    }

    public void setDueDate(String dueDate) {
        this.dueDate = dueDate;
    }

    public TaskStatus getStatus() {
        return status;
    }

    public void setStatus(TaskStatus status) {
        this.status = status;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }
}
