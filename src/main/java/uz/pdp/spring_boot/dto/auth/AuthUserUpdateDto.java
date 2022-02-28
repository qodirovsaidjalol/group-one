package uz.pdp.spring_boot.dto.auth;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.web.multipart.MultipartFile;
import uz.pdp.spring_boot.dto.GenericDto;
import uz.pdp.spring_boot.entity.user.Language;
import uz.pdp.spring_boot.entity.user.Role;

@Getter
@Setter
@NoArgsConstructor
public class AuthUserUpdateDto extends GenericDto {
    private String username;
    private String email;
    private Role role;
    private Language language;
    private MultipartFile image;
}
