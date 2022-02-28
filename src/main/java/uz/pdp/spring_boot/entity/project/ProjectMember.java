package uz.pdp.spring_boot.entity.project;

import lombok.Getter;
import lombok.Setter;
import uz.pdp.spring_boot.entity.Auditable;
import uz.pdp.spring_boot.entity.user.AuthUser;

import javax.persistence.*;

@Getter
@Setter
@Entity
public class ProjectMember extends Auditable {

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "project_id")
    private Project project;

    @Column(name = "user_id")
    private Long userId;

    @Column(name = "is_lead")
    private Boolean isLead;

    public AuthUser getAuthUser() {
        return new AuthUser();
    }
}