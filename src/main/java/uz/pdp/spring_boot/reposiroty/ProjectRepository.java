package uz.pdp.spring_boot.reposiroty;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import uz.pdp.spring_boot.entity.project.Project;


public interface ProjectRepository extends JpaRepository<Project, Long>, AbstractRepository{

@Query(value = "from Project  p where p.id=:projectId")
    Project findProjectById(Long projectId);
import org.springframework.data.repository.query.Param;
import uz.pdp.spring_boot.entity.column.Colum;
import uz.pdp.spring_boot.entity.organization.Organization;
import uz.pdp.spring_boot.entity.project.Project;

import java.util.List;

public interface ProjectRepository extends JpaRepository<Project, Long>, AbstractRepository {

    @Query(value = "from Organization o where o.id=:id")
    Organization getOrg(@Param("id") Long id);

    @Query(value = "from Project p where p.id=:id and not p.closed")
    List<Project> getAllByOrg(Long id);

//    @Query(value = "from Colum o where o.project=:id and  o.active")
//    List<Colum> getColum(Long id);

}
