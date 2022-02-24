package uz.pdp.spring_boot.reposiroty;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import uz.pdp.spring_boot.entity.project.Project;


public interface ProjectRepository extends JpaRepository<Project, Long>, AbstractRepository{

@Query(value = "from Project  p where p.id=:projectId")
    Project findProjectById(Long projectId);
}
