package uz.pdp.spring_boot.reposiroty;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;
import uz.pdp.spring_boot.entity.column.Colum;
import uz.pdp.spring_boot.entity.project.Project;
import uz.pdp.spring_boot.entity.task.Task;

import java.util.List;
@Repository
public interface ColumRepository extends JpaRepository<Colum,Long>,AbstractRepository {
     @Query(value = "from Colum  c where c.project.id=:id")
    List<Colum> getColum(Long id);
    @Query(value = "from Project p where p.id=:projectId")
    Project getProject(Long projectId);
    List<Colum> getAllByProjectEquals(Project project);

    Colum findColumnById(Long columnId);

    @Query(value = "from Colum c where c.id=:id")
    Colum getColumn(Long id);
}
