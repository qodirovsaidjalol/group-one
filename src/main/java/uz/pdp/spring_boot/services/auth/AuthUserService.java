package uz.pdp.spring_boot.services.auth;

import org.springframework.stereotype.Service;
import uz.pdp.spring_boot.criteria.GenericCriteria;
import uz.pdp.spring_boot.dto.auth.AuthUserCreateDto;
import uz.pdp.spring_boot.dto.auth.AuthUserDto;
import uz.pdp.spring_boot.dto.auth.AuthUserUpdateDto;
import uz.pdp.spring_boot.entity.user.AuthUser;
import uz.pdp.spring_boot.services.GenericCrudService;

import java.util.List;

@Service
public interface AuthUserService extends GenericCrudService<AuthUser, AuthUserDto, AuthUserCreateDto, AuthUserUpdateDto, GenericCriteria, Long> {

    void block(Long id);

    List<AuthUserDto> getAllFromOrganization();

//    Long createAdmin(AuthUserCreateDto dto);

    AuthUser getUser(Long id);
}

