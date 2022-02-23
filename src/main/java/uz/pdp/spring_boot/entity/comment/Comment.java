package uz.pdp.spring_boot.entity.comment;

import lombok.Getter;
import lombok.Setter;
import uz.pdp.spring_boot.entity.task.Task;

import javax.persistence.*;

@Getter
@Setter
@Entity
public class Comment {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    private Task task;

    private String body;

    private String type;

}
