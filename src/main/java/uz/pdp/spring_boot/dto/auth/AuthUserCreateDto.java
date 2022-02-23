package uz.pdp.spring_boot.dto.auth;

import lombok.Getter;
import lombok.Setter;
import org.springframework.stereotype.Component;
import uz.pdp.spring_boot.dto.Dto;
import uz.pdp.spring_boot.entity.organization.Organization;
import uz.pdp.spring_boot.entity.rele.Role;

@Getter
@Setter
@Component
public class AuthUserCreateDto implements Dto {
    private String username;
    private String password;
    private String email;
    private Long organizationId;
    private String role_name;
}
