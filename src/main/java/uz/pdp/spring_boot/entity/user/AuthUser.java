package uz.pdp.spring_boot.entity.user;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import uz.pdp.spring_boot.entity.Auditable;
import uz.pdp.spring_boot.entity.organization.Organization;
import uz.pdp.spring_boot.entity.rele.Role;

import javax.persistence.*;

@Getter
@Setter
@Entity
@ToString
public class AuthUser extends Auditable {

    @Column(nullable = false, unique = true)
    private String username;

    @Column(nullable = false)
    private String password;

    private String email;

    private String image;

    private boolean isSuperAdmin = false;

    private String lang;

    private boolean isActive = true;

    private boolean isBlocked = false;

    @ManyToOne
    private Organization organization;

    @ManyToOne
    private Role role;
}
