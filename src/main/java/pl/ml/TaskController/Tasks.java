package pl.ml.TaskController;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

/**
 * @author Remigiusz Zudzin
 */

@Data
@NoArgsConstructor
@Entity
@Table(name = "tasks")
public class TaskController {

    @Id
    @Column
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer task_id;

    @Column(name = "TASK_NAME")
    private String taskName;

    @Column(name = "TASK_DESC")
    private String taskDesc;

    @Column(name = "DUE_DATE")
    private String dueDate;

    @Column(name = "STATUS")
    private String status;

}
