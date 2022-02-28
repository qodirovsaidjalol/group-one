package uz.pdp.spring_boot.dto.organization;


import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import uz.pdp.spring_boot.dto.GenericDto;

@Getter
@Setter
@NoArgsConstructor
public class OrganizationUpdateDto extends GenericDto {
    private String name;
    private String code;
    private String email;
}
