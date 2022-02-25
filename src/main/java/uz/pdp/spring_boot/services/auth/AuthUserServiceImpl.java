package uz.pdp.spring_boot.services.auth;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;
import uz.pdp.spring_boot.config.PasswordEncoderConfigurations;
import uz.pdp.spring_boot.criteria.GenericCriteria;
import uz.pdp.spring_boot.dto.auth.AuthUserCreateDto;
import uz.pdp.spring_boot.dto.auth.AuthUserDto;
import uz.pdp.spring_boot.dto.auth.AuthUserUpdateDto;
import uz.pdp.spring_boot.entity.organization.Organization;
import uz.pdp.spring_boot.entity.user.AuthUser;
import uz.pdp.spring_boot.mapper.AuthUserMapper;
import uz.pdp.spring_boot.reposiroty.AuthUserRepository;
import uz.pdp.spring_boot.reposiroty.OrganizationRepository;
import uz.pdp.spring_boot.reposiroty.RoleRepository;
import uz.pdp.spring_boot.services.AbstractService;
import uz.pdp.spring_boot.services.organization.file.FileStorageService;
import uz.pdp.spring_boot.utils.BaseUtils;

import java.util.List;

@Service
public class AuthUserServiceImpl extends AbstractService<AuthUserRepository, AuthUserMapper> implements AuthUserService {

    private final FileStorageService fileStorageService;
    private final PasswordEncoderConfigurations encoder;
    private final OrganizationRepository organizationService;
    private final RoleRepository repositoryRole;

    @Autowired
    protected AuthUserServiceImpl(AuthUserRepository repository, @Qualifier("authUserMapperImpl") AuthUserMapper mapper, BaseUtils baseUtils, FileStorageService fileStorageService, PasswordEncoderConfigurations encoder, OrganizationRepository organizationService, RoleRepository repository1) {
        super(repository, mapper, baseUtils);
        this.fileStorageService = fileStorageService;
        this.encoder = encoder;
        this.organizationService = organizationService;
        this.repositoryRole = repository1;
    }

    @Override
    public Long create(AuthUserCreateDto createDto) {
        MultipartFile file = createDto.getImage();
        String logoPath = fileStorageService.store(file);
        AuthUser user = mapper.fromCreateDto(createDto);
        user.setPassword(encoder.passwordEncoder().encode(user.getPassword()));
        user.setImage(logoPath);
        user.setOrganization(repository.findOrg(createDto.getOrganizationId()));
        user.setRole(repositoryRole.getByCodeEquals(createDto.getRole_name()));
        return repository.save(user).getId();
    }

    public Long createAdmin(AuthUserCreateDto createDto) {
        AuthUser user = repository.findAuthUserById(create(createDto));
        Organization organization = repository.findOrg(user.getOrganization().getId());
        organization.setOwner(user.getId());
        organizationService.save(organization);
        return null;
    }

    @Override
    public Void delete(Long id) {
        repository.delete(repository.getById(id));
        return null;
    }

    @Override
    public Void update(AuthUserUpdateDto updateDto) {
        AuthUser user = mapper.fromUpdateDto(updateDto);
        user.setUsername(updateDto.getUsername());
        user.setEmail(updateDto.getEmail());
        repository.save(user);
        return null;
    }

    @Override
    public List<AuthUserDto> getAll(GenericCriteria criteria) {
        // TODO: 2/23/2022 sessionni organizatsia id sini berish kerak
//        return mapper.toDto(repository.findAllByOrganization_Id(1L));
        return mapper.toDto(repository.findAll());
    }

    @Override
    public AuthUserDto get(Long id) {
        return mapper.toDto(repository.findAuthUserById(id));
    }

    public AuthUser getUser(Long id) {
        return repository.findAuthUserById(id);
    }

    @Override
    public Long totalCount(GenericCriteria criteria) {
        return null;
    }

    public void block(Long id, boolean b) {
        AuthUser user = repository.findAuthUserById(id);
        boolean a = !b;
        user.setBlocked(a);
        repository.save(user);
    }
}
