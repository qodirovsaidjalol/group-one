package uz.pdp.spring_boot.services.organization;

import org.springframework.beans.factory.annotation.Autowired;
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
import uz.pdp.spring_boot.services.auth.AuthUserServiceImpl;
import uz.pdp.spring_boot.services.organization.file.FileStorageService;
import uz.pdp.spring_boot.utils.BaseUtils;

import java.util.List;
import java.util.Optional;

@Service
public class OrganizationServiceImpl extends AbstractService<OrganizationRepository, OrganizationMapper>
        implements OrganizationService {


    private final FileStorageService fileStorageService;
    private final AuthUserServiceImpl authUserService;

    @Autowired
    protected OrganizationServiceImpl(OrganizationRepository repository, OrganizationMapper mapper, BaseUtils baseUtils, FileStorageService fileStorageService, AuthUserServiceImpl authUserService) {
        super(repository, mapper);
        this.fileStorageService = fileStorageService;
        this.authUserService = authUserService;
    }


    @Override
    public Long create(OrganizationCreateDto dto) {
        MultipartFile file = dto.getLogo();
        String logoPath = fileStorageService.store(file);
        Organization organization = mapper.fromCreateDto(dto);
        organization.setLogo(logoPath);
        repository.save(organization);
        return organization.getId();
    }

    @Override
    public Void delete(Long id) {
        Optional<Organization> optional = repository.findById(id);
        if (optional.isPresent()) {
            Organization org = optional.get();
            org.setDeleted(true);
            authUserService.deleteAll(org.getId());
            repository.save(org);
        }
        return null;
    }

    @Override
    public Void update(OrganizationUpdateDto organizationUpdateDto) {
        Organization org = repository.findOrganizationById(organizationUpdateDto.getId());
        org.setName(organizationUpdateDto.getName());
        org.setCode(organizationUpdateDto.getCode());
        org.setEmail(organizationUpdateDto.getEmail());
        repository.save(org);
        return null;
    }

    @Override
    public List<OrganizationDto> getAll(GenericCriteria criteria) {
        return mapper.toDto(repository.findOrganizationsByDeletedFalse());
    }

    public void block(Long id) {
        Organization org = repository.findOrganizationById(id);
        org.setBlocked(!org.isBlocked());
        repository.save(org);
    }

    @Override
    public OrganizationDto get(Long id) {
        Optional<Organization> optional = repository.findById(id);
        return optional.map(mapper::toDto).orElse(null);
    }

    @Override
    public Long totalCount(GenericCriteria criteria) {
        return null;
    }
}
