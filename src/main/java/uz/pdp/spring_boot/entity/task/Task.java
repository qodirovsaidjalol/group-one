package uz.pdp.spring_boot.entity.task;

import lombok.Getter;
import lombok.Setter;
import uz.pdp.spring_boot.entity.column.Colum;
import uz.pdp.spring_boot.entity.project.Project;

import javax.persistence.*;

@Getter
@Setter
@Entity
public class Task {
    @Id

    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    private Project project;

    @ManyToOne
    private Colum column;
}
