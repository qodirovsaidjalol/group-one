package uz.pdp.spring_boot.dto.auth;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import uz.pdp.spring_boot.dto.GenericDto;

@Getter
@Setter
@NoArgsConstructor
public class AuthUserUpdateDto extends GenericDto {
    private String username;
    private String password;
    private String email;
}
