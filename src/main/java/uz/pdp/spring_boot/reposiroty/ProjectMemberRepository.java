package uz.pdp.spring_boot.reposiroty;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import uz.pdp.spring_boot.entity.project.Project;
import uz.pdp.spring_boot.entity.project.ProjectMember;

import java.util.List;

@Repository
public interface ProjectMemberRepository extends JpaRepository<ProjectMember, Long>, AbstractRepository{

    @Query(value = "select pm.userId from ProjectMember pm where pm.project.id=:id")
    List<Long> findAllByProjectId(Long id);

}