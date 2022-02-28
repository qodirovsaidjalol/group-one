package uz.pdp.spring_boot.reposiroty;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import uz.pdp.spring_boot.entity.organization.Organization;

import java.util.List;
@Repository
public interface OrganizationRepository extends JpaRepository<Organization, Long>, AbstractRepository {

    Organization findOrganizationById(Long id);

    List<Organization> findOrganizationsByDeletedFalse();
}
