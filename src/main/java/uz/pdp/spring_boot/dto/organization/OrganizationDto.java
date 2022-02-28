package uz.pdp.spring_boot.dto.organization;

import lombok.Getter;
import lombok.Setter;
import uz.pdp.spring_boot.dto.GenericDto;

@Getter
@Setter
public class OrganizationDto extends GenericDto {

    private String name;
    private String logo;
    private String code;
    private String email;
    private boolean isBlocked;
    private String location;
    private Long owner;

}

