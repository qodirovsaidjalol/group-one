package uz.pdp.spring_boot.entity.rele;

import lombok.Getter;
import lombok.Setter;
import uz.pdp.spring_boot.entity.Auditable;
import uz.pdp.spring_boot.entity.permission.Permission;

import javax.persistence.*;
import java.util.List;

@Getter
@Setter
@Entity
public class Role  {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String name;

    @Column(nullable = false)
    private String code;

    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(
            name = "auth_role_permission",
            joinColumns = @JoinColumn(name = "role_id"),
            inverseJoinColumns = @JoinColumn(name = "permission_id")
    )
    private List<Permission> permissions;
}
