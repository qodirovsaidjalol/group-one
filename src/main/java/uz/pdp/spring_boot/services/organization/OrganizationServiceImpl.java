package uz.pdp.spring_boot.services.organization;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;
import uz.pdp.spring_boot.criteria.GenericCriteria;
import uz.pdp.spring_boot.dto.organization.OrganizationCreateDto;
import uz.pdp.spring_boot.dto.organization.OrganizationDto;
import uz.pdp.spring_boot.dto.organization.OrganizationUpdateDto;
import uz.pdp.spring_boot.entity.organization.Organization;
import uz.pdp.spring_boot.mapper.OrganizationMapper;
import uz.pdp.spring_boot.reposiroty.OrganizationRepository;
import uz.pdp.spring_boot.services.AbstractService;
import uz.pdp.spring_boot.services.organization.file.FileStorageService;
import uz.pdp.spring_boot.utils.BaseUtils;

import java.util.List;

@Service
public class OrganizationServiceImpl extends AbstractService<OrganizationRepository, OrganizationMapper> implements OrganizationService {

    private final FileStorageService fileStorageService;

    @Autowired
    protected OrganizationServiceImpl(OrganizationRepository repository, @Qualifier("organizationMapperImpl") OrganizationMapper mapper, BaseUtils baseUtils, FileStorageService fileStorageService) {
        super(repository, mapper, baseUtils);
        this.fileStorageService = fileStorageService;
    }

    @Override
    public Long create(OrganizationCreateDto createDto) {
        MultipartFile file = createDto.getLogo();
        String logoPath = fileStorageService.store(file);
        Organization organization = mapper.fromCreateDto(createDto);
        organization.setLogo(logoPath);
        repository.save(organization);
        return organization.getId();
    }

    @Override
    public Void delete(Long id) {
        repository.deleteById(id);
        return null;
    }

    @Override
    public Void update(OrganizationUpdateDto updateDto) {
        return null;
    }
 
    @Override
    public List<OrganizationDto> getAll(GenericCriteria criteria) {
        return mapper.toDto(repository.findAll());
    }

    @Override
    public OrganizationDto get(Long id) {
        return mapper.toDto(repository.findOrganizationById(id));
    }

    public Organization getOrg(Long id) {
        return repository.findOrganizationById(id);
    }

    @Override
    public Long totalCount(GenericCriteria criteria) {
        return null;
    }

    @Override
    public void block(Long id, boolean b) {
        Organization organization = repository.findOrganizationById(id);
        organization.setBlocked(!b);
    }
}
