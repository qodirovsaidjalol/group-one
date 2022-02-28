package uz.pdp.spring_boot.dto.auth;

import lombok.*;
import uz.pdp.spring_boot.dto.GenericDto;
import uz.pdp.spring_boot.entity.user.Language;
import uz.pdp.spring_boot.entity.user.Role;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class AuthUserDto extends GenericDto {
    private String username;
    private String password;
    private String email;
    private String image;
    private boolean isBlocked;
    private Role role;
    private Language language;
    private Long organizationId;

}
