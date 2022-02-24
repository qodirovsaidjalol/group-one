package uz.pdp.spring_boot.services.project;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import uz.pdp.spring_boot.criteria.GenericCriteria;
import uz.pdp.spring_boot.dto.proect.ProjectCreateDto;
import uz.pdp.spring_boot.dto.proect.ProjectDto;
import uz.pdp.spring_boot.dto.proect.ProjectUpdateDto;
import uz.pdp.spring_boot.entity.column.Colum;
import uz.pdp.spring_boot.entity.organization.Organization;
import uz.pdp.spring_boot.entity.project.Project;
import uz.pdp.spring_boot.mapper.ProjectMapper;
import uz.pdp.spring_boot.reposiroty.ColumRepository;
import uz.pdp.spring_boot.reposiroty.ProjectRepository;
import uz.pdp.spring_boot.services.AbstractService;
import uz.pdp.spring_boot.utils.BaseUtils;

import java.util.List;
import java.util.Optional;

@Service
public class ProjectServiceImpl extends AbstractService<ProjectRepository, ProjectMapper> implements ProjectService {

   private final ColumRepository columRepository;
    @Autowired
    protected ProjectServiceImpl(ProjectRepository repository, @Qualifier("projectMapperImpl") ProjectMapper mapper, BaseUtils baseUtils, ColumRepository columRepository) {
        super(repository, mapper, baseUtils);
        this.columRepository = columRepository;
    }

    @Override
    public Long create(ProjectCreateDto createDto) {
       Project project= mapper.fromCreateDto(createDto);
       project.setCreateBy(1L);
        return repository.save(project).getId();
    }

    @Override
    public Void delete(Long id) {
        repository.deleteById(id);
        return null;
    }

    @Override
    public Void update(ProjectUpdateDto updateDto) {
        repository.save(mapper.fromUpdateDto(updateDto));
        return null;
    }
    @Override
    public List<ProjectDto> getAllByOrg(Long id) {

        return mapper.toDto(repository.getAllByOrg(id));
    }

    @Override
    public List<ProjectDto> getAll(GenericCriteria criteria) {
        return null;
    }

    @Override
    public ProjectDto get(Long id) {
        Optional optional;
        optional = repository.findById(id);
        if (optional.isPresent()) {
            return mapper.toDto((Project) optional.get());
        }
        return new ProjectDto();

    }

    @Override
    public Long totalCount(GenericCriteria criteria) {
        return null;
    }

    @Override
    public Organization getOrg(Long id) {
        return repository.getOrg(id);
    }

    @Override
    public List<Colum> getColum(Long id) {
       return   columRepository.getColum(id);


    }
}
