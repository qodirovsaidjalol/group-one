package uz.pdp.spring_boot.reposiroty;

import org.aspectj.weaver.ast.Or;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;
import uz.pdp.spring_boot.dto.organization.OrganizationDto;
import uz.pdp.spring_boot.entity.organization.Organization;

import java.util.List;
@Repository
public interface OrganizationRepository extends JpaRepository<Organization, Long>, AbstractRepository {

    List<Organization> findAll();

    Organization findOrganizationById(Long id);
}
