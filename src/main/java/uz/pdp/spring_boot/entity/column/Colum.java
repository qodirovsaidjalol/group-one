package uz.pdp.spring_boot.entity.column;

import lombok.Getter;
import lombok.Setter;
import uz.pdp.spring_boot.entity.BaseEntity;
import uz.pdp.spring_boot.entity.project.Project;

import javax.persistence.*;

@Getter
@Setter
@Entity
public class Colum implements BaseEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

   @Column(unique = true, nullable = false)
    private String name;
    @Column(unique = true)
    private Long order_column;

    private boolean active=true;
    @ManyToOne
    private Project project;

}
