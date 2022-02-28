package uz.pdp.spring_boot.entity.task;

import uz.pdp.spring_boot.entity.Auditable;
import uz.pdp.spring_boot.entity.project.Project;

import javax.persistence.*;

@Entity
public class TaskMember extends Auditable {

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "task_id")
    private Task task;

    @Column(name = "user_id")
    private Long userId;

    @Column(name = "is_lead")
    private Boolean isLead;
}
