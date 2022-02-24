package uz.pdp.spring_boot.mapper;

import org.mapstruct.Mapper;
import org.springframework.stereotype.Component;
import uz.pdp.spring_boot.dto.proect.ProjectCreateDto;
import uz.pdp.spring_boot.dto.proect.ProjectDto;
import uz.pdp.spring_boot.dto.proect.ProjectUpdateDto;
import uz.pdp.spring_boot.entity.project.Project;

@Mapper(componentModel = "spring")
@Component
public interface ProjectMapper extends BaseMapper<Project, ProjectDto, ProjectCreateDto, ProjectUpdateDto> {
}
