package uz.pdp.spring_boot.entity.project;

import lombok.Getter;
import lombok.Setter;
import uz.pdp.spring_boot.entity.Auditable;
import uz.pdp.spring_boot.entity.organization.Organization;

import javax.persistence.*;

@Getter
@Setter
@Entity
public class Project extends Auditable {

    private String name;

    private String tzPath;

    @ManyToOne(fetch = FetchType.LAZY)
    private Organization organization;

    private Boolean closed;

    @Column(nullable = false)
    private Long createBy;

    private Long updateBy;

}