package uz.pdp.spring_boot.reposiroty;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Component;
import uz.pdp.spring_boot.entity.user.AuthUser;

import java.util.List;
import java.util.Optional;

@Component
public interface AuthUserRepository extends JpaRepository<AuthUser, Long>, AbstractRepository {

    @Query(value = "from AuthUser a where a.id=:id")
    AuthUser findAuthUserById(Long id);

    Optional<List<AuthUser>> findAuthUsersByDeletedFalseAndOrganizationId(Long id);

    List<AuthUser> findAuthUsersByDeletedFalse();

    AuthUser findAuthUserByUsername(String username);

    List<AuthUser> findAllByOrganization_Id(Long id);

    List<AuthUser> findAll();
}
