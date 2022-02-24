package uz.pdp.spring_boot.entity.project;

import lombok.Getter;
import lombok.Setter;
import uz.pdp.spring_boot.entity.organization.Organization;

import javax.persistence.*;
import java.time.Instant;

@Getter
@Setter
@Entity
public class Project {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;


    private String name;


    private String tzPath;

    @ManyToOne(fetch = FetchType.LAZY)
    private Organization organization;

    private Boolean closed;

    @Convert(disableConversion = true)
    private Instant createdAt;

    @Column(nullable = false)
    private Long createBy;

    @Convert(disableConversion = true)
    private Instant updatedAt;

    private Long updateBy;

}