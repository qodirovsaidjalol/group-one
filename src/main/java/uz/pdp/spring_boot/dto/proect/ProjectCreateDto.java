package uz.pdp.spring_boot.dto.proect;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import uz.pdp.spring_boot.dto.Dto;
import uz.pdp.spring_boot.entity.organization.Organization;

@Getter
@Setter
@Builder
public class ProjectCreateDto implements Dto {
    String name;
    String tzPhat;
    Organization organization;
}
