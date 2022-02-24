package uz.pdp.spring_boot.entity.organization;

import lombok.Getter;
import lombok.Setter;
import uz.pdp.spring_boot.entity.Auditable;

import javax.persistence.*;


@Getter
@Setter
@Entity
public class Organization extends Auditable {

    @Column(nullable = false, length = 100)
    private String name;
    private String logo;

    private String email;

    private boolean isBlocked = false;

    @Column(unique = true, nullable = false)
    private String code;

    private String location;

    private Long owner;
}
