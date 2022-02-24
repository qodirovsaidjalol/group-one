package uz.pdp.spring_boot.services.project;

import org.springframework.stereotype.Component;
import uz.pdp.spring_boot.criteria.GenericCriteria;
import uz.pdp.spring_boot.dto.proect.ProjectCreateDto;
import uz.pdp.spring_boot.dto.proect.ProjectDto;
import uz.pdp.spring_boot.dto.proect.ProjectUpdateDto;
import uz.pdp.spring_boot.entity.organization.Organization;
import uz.pdp.spring_boot.entity.project.Project;
import uz.pdp.spring_boot.services.GenericCrudService;


public interface ProjectService extends GenericCrudService<Project,
        ProjectDto,
        ProjectCreateDto,
        ProjectUpdateDto,
        GenericCriteria,
        Long> {
   public Organization getOrg(Long id);
}
