package uz.pdp.spring_boot.reposiroty;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import uz.pdp.spring_boot.entity.organization.Organization;
import uz.pdp.spring_boot.entity.rele.Role;
import uz.pdp.spring_boot.entity.user.AuthUser;

import java.util.List;

public interface AuthUserRepository extends JpaRepository<AuthUser, Long>, AbstractRepository {

    AuthUser findAuthUserById(Long id);

    List<AuthUser> findAllByOrganization_Id(Long id);

    List<AuthUser> findAll();
}
