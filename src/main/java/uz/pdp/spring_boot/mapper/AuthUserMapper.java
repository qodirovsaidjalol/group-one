package uz.pdp.spring_boot.mapper;

import org.mapstruct.Mapper;
import org.springframework.stereotype.Component;
import uz.pdp.spring_boot.dto.auth.AuthUserCreateDto;
import uz.pdp.spring_boot.dto.auth.AuthUserDto;
import uz.pdp.spring_boot.dto.auth.AuthUserUpdateDto;
import uz.pdp.spring_boot.entity.user.AuthUser;

import java.util.List;

@Component
@Mapper(componentModel = "spring")
public interface AuthUserMapper extends BaseMapper<
        AuthUser,
        AuthUserDto,
        AuthUserCreateDto,
        AuthUserUpdateDto> {

    @Override
    AuthUser fromCreateDto(AuthUserCreateDto authUserCreateDto);

    @Override
    AuthUser fromUpdateDto(AuthUserUpdateDto authUserUpdateDto);

    @Override
    List<AuthUserDto> toDto(List<AuthUser> e);

    AuthUserDto toDto(AuthUser u);

    @Override
    List<AuthUser> fromDto(List<AuthUserDto> e);
}
