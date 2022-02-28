package uz.pdp.spring_boot.services.colum;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import uz.pdp.spring_boot.criteria.GenericCriteria;
import uz.pdp.spring_boot.dto.colim.ColumDto;
import uz.pdp.spring_boot.dto.colim.ColumUpdateDto;
import uz.pdp.spring_boot.dto.colim.CreateColumDto;
import uz.pdp.spring_boot.entity.column.Colum;
import uz.pdp.spring_boot.entity.project.Project;
import uz.pdp.spring_boot.mapper.ColumMapper;
import uz.pdp.spring_boot.reposiroty.ColumRepository;
import uz.pdp.spring_boot.services.AbstractService;
import uz.pdp.spring_boot.utils.BaseUtils;

import java.util.List;

@Service
public class ColumServiceImpl extends AbstractService<ColumRepository, ColumMapper> implements ColumService {
    @Autowired
    protected ColumServiceImpl(ColumRepository repository, @Qualifier("columMapperImpl") ColumMapper mapper, BaseUtils baseUtils) {
        super(repository, mapper);
    }

    @Override
    public Long create(CreateColumDto createDto) {

       Colum colum= mapper.fromCreateDto(createDto);
       colum.setProject(repository.getProject(createDto.getProjectId()));
        repository.save(colum);
        return null;
    }

    @Override
    public Void delete(Long id) {
        return null;
    }

    @Override
    public Void update(ColumUpdateDto updateDto) {
        return null;
    }

    @Override
    public List<ColumDto> getAll(GenericCriteria criteria) {
       return mapper.toDto(repository.findAll());

    }

    @Override
    public ColumDto get(Long id) {
        return null;
    }

    @Override
    public Long totalCount(GenericCriteria criteria) {
        return null;
    }

    @Override
    public Object getAllByProject(Project byId) {
      return  repository.getAllByProjectEquals(byId);
    }
}
