package uz.pdp.spring_boot.dto.auth;

import lombok.Getter;
import lombok.Setter;
import org.springframework.stereotype.Component;
import org.springframework.web.multipart.MultipartFile;
import uz.pdp.spring_boot.dto.Dto;

@Getter
@Setter
@Component
public class AuthUserCreateDto implements Dto {
    private String username;
    private String password;
    private MultipartFile image;
    private String email;
    private Long organizationId;
    private String role_name;
}
