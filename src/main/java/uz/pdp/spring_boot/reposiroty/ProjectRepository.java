package uz.pdp.spring_boot.reposiroty;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import uz.pdp.spring_boot.entity.organization.Organization;
import uz.pdp.spring_boot.entity.project.Project;

public interface ProjectRepository extends JpaRepository<Project, Long>, AbstractRepository {

    @Query(value = "from Organization o where o.id=:id")
    Organization getOrg(@Param("id") Long id);
}
