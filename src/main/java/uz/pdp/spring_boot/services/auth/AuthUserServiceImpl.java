package uz.pdp.spring_boot.services.auth;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import uz.pdp.spring_boot.criteria.GenericCriteria;
import uz.pdp.spring_boot.dto.auth.AuthUserCreateDto;
import uz.pdp.spring_boot.dto.auth.AuthUserDto;
import uz.pdp.spring_boot.dto.auth.AuthUserUpdateDto;
import uz.pdp.spring_boot.entity.user.AuthUser;
import uz.pdp.spring_boot.mapper.AuthUserMapper;
import uz.pdp.spring_boot.reposiroty.AuthUserRepository;
import uz.pdp.spring_boot.reposiroty.OrganizationRepository;
import uz.pdp.spring_boot.reposiroty.RoleRepository;
import uz.pdp.spring_boot.services.AbstractService;
import uz.pdp.spring_boot.utils.BaseUtils;

import java.util.List;

@Service
public class AuthUserServiceImpl extends AbstractService<AuthUserRepository, AuthUserMapper> implements AuthUserService {

    private final OrganizationRepository organizationRepository;
    private final RoleRepository roleRepository;

    @Autowired
    protected AuthUserServiceImpl(AuthUserRepository repository, AuthUserMapper mapper, BaseUtils baseUtils, OrganizationRepository organizationRepository, RoleRepository roleRepository) {
        super(repository, mapper, baseUtils);
        this.organizationRepository = organizationRepository;
        this.roleRepository = roleRepository;
    }

    @Override
    public Long create(AuthUserCreateDto createDto) {
        AuthUser user = mapper.fromCreateDto(createDto);
        user.setOrganization(organizationRepository.findOrganizationById(createDto.getOrganizationId()));
        user.setRole(roleRepository.findRoleByName(createDto.getRole_name()));
        repository.save(user);
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
        return mapper.toDto(repository.findAllByOrganization_Id(1L));
    }

    @Override
    public AuthUserDto get(Long id) {
        return mapper.toDto(repository.findAuthUserById(id));
    }

    @Override
    public Long totalCount(GenericCriteria criteria) {
        return null;
    }
}
