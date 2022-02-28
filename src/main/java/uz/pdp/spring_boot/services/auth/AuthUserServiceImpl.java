package uz.pdp.spring_boot.services.auth;

import org.springframework.stereotype.Service;
import uz.pdp.spring_boot.criteria.GenericCriteria;
import uz.pdp.spring_boot.dto.auth.AuthUserDto;
import uz.pdp.spring_boot.dto.auth.AuthUserUpdateDto;
import uz.pdp.spring_boot.dto.auth.AuthUserCreateDto;
import uz.pdp.spring_boot.entity.user.AuthUser;
import uz.pdp.spring_boot.entity.organization.Organization;
import uz.pdp.spring_boot.mapper.AuthUserMapper;
import uz.pdp.spring_boot.reposiroty.AuthUserRepository;
import uz.pdp.spring_boot.reposiroty.OrganizationRepository;
import uz.pdp.spring_boot.services.AbstractService;
import uz.pdp.spring_boot.services.organization.file.FileStorageService;
import org.springframework.web.multipart.MultipartFile;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class AuthUserServiceImpl extends AbstractService<AuthUserRepository, AuthUserMapper> implements AuthUserService {

    private final FileStorageService fileStorageService;
    private final OrganizationRepository organizationRepository;

    protected AuthUserServiceImpl(AuthUserRepository repository, AuthUserMapper mapper, FileStorageService fileStorageService, OrganizationRepository organizationRepository) {
        super(repository, mapper);
        this.fileStorageService = fileStorageService;
        this.organizationRepository = organizationRepository;
    }


    @Override
    public Long create(AuthUserCreateDto authUserCreateDto) {
        MultipartFile file = authUserCreateDto.getImage();
        String logoPath = fileStorageService.store(file);
        AuthUser user = mapper.fromCreateDto(authUserCreateDto);
        if (authUserCreateDto.getOrganizationId() == null)
            user.setOrganization(organizationRepository.getById(1L));  // TODO: 2/27/2022 Sessionni organizatsiya id si beriladi
        else {
            user.setOrganization(organizationRepository.getById(authUserCreateDto.getOrganizationId()));
        }
        user.setImage(logoPath);
        return addOwner(repository.save(user));
    }

    private Long addOwner(AuthUser save) {
        Organization organization = organizationRepository.findOrganizationById(save.getOrganization().getId());
        organization.setOwner(save.getId());
        organizationRepository.save(organization);
        return save.getId();
    }

    @Override
    public Void delete(Long id) {
        Optional<AuthUser> optional = repository.findById(id);
        if (optional.isPresent()) {
            AuthUser authUser = optional.get();
            authUser.setDeleted(true);
            repository.save(authUser);
        }
        return null;
    }

    public void deleteAll(Long id) {
        List<AuthUserDto> users = getAllFromOrganization(id);
        for (AuthUserDto user : users) {
            delete(user.getId());
        }
    }

    @Override
    public Void update(AuthUserUpdateDto authUpdateDto) {
        AuthUser user = repository.findAuthUserById(authUpdateDto.getId());
        user.setUsername(authUpdateDto.getUsername());
        user.setRole(authUpdateDto.getRole());
        user.setLanguage(authUpdateDto.getLanguage());
        user.setEmail(authUpdateDto.getEmail());
        repository.save(user);
        return null;
    }

    @Override
    public List<AuthUserDto> getAll(GenericCriteria criteria) {
        Optional<List<AuthUser>> optional = repository.findAuthUsersByDeletedFalseAndOrganizationId(1L);
        if (optional.isPresent()) return mapper.toDto(optional.get());
        return new ArrayList<>();
    }

    @Override
    public AuthUserDto get(Long id) {
        Optional<AuthUser> optional = repository.findById(id);
        if (optional.isPresent()) {
            return mapper.toDto(optional.get());
        }
        return new AuthUserDto();
    }

    @Override
    public Long totalCount(GenericCriteria criteria) {
        return null;
    }

    public void block(Long id) {
        AuthUser user = repository.findAuthUserById(id);
        user.setBlocked(!user.isBlocked());
        repository.save(user);
    }

    @Override
    public List<AuthUserDto> getAllFromOrganization() {
        List<AuthUser> optional = repository.findAuthUsersByDeletedFalse();
        return mapper.toDto(optional);
    }

    public List<AuthUserDto> getAllFromOrganization(Long id) {
        Optional<List<AuthUser>> optional = repository.findAuthUsersByDeletedFalseAndOrganizationId(id);
        return optional.map(mapper::toDto).orElse(null);
    }
}
