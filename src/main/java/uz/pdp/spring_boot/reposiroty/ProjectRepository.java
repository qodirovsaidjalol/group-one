package uz.pdp.spring_boot.reposiroty;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;
import uz.pdp.spring_boot.entity.project.Project;
import org.springframework.data.repository.query.Param;
import uz.pdp.spring_boot.entity.column.Colum;
import uz.pdp.spring_boot.entity.organization.Organization;
import uz.pdp.spring_boot.entity.project.Project;

import java.util.List;

@Repository
public interface ProjectRepository extends JpaRepository<Project, Long>, AbstractRepository {
//    @Query(value = "from Project  p where p.id=:projectId")
//    Project findProjectById(Long projectId);

    @Query(value = "from Organization o where o.id=:id")
    Organization getOrg(Long id);

    List<Project> getAllByOrganizationEquals(Organization organization);


//    @Query(value = "from Colum o where o.project=:id and  o.active")
//    List<Colum> getColum(Long id);

}
