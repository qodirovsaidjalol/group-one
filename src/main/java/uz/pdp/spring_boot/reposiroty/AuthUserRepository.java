package uz.pdp.spring_boot.reposiroty;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import uz.pdp.spring_boot.entity.organization.Organization;
import uz.pdp.spring_boot.entity.rele.Role;
import uz.pdp.spring_boot.entity.user.AuthUser;

import java.util.List;
import java.util.Optional;

public interface AuthUserRepository extends JpaRepository<AuthUser, Long>, AbstractRepository {

    AuthUser findAuthUserById(Long id);

    @Query(value = "from Organization o where o.id=:id")
    Organization findOrg(Long id);

    @Query(value = "from Role r where r.name=:name")
    Role findRoleByName(String name);

    AuthUser findAuthUserByUsername(String username);

    List<AuthUser> findAllByOrganization_Id(Long id);
    List<AuthUser> findAll();
}
