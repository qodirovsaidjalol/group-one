package uz.pdp.spring_boot.dto.organization;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.web.multipart.MultipartFile;
import uz.pdp.spring_boot.dto.Dto;
import uz.pdp.spring_boot.entity.organization.Organization;

@Getter
@Setter
@NoArgsConstructor
public class OrganizationCreateDto implements Dto {
    private String name;
    private String email;
    private String code;
    private String location;
    private MultipartFile logo;
}
