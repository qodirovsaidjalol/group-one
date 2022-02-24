package uz.pdp.spring_boot.reposiroty;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import uz.pdp.spring_boot.dto.task.TaskDto;
import uz.pdp.spring_boot.entity.column.Columns;
import uz.pdp.spring_boot.entity.task.Task;

import javax.transaction.Transactional;
import java.util.List;

public interface TaskRepository extends JpaRepository<Task, Long>, AbstractRepository {
    @Modifying
    @Transactional
    @Query("update Task t set t.name=:name,t.description=:description,t.column=:column  where t.id = :id")
    void update(@Param("name") String name, @Param("description") String description, @Param("column") Columns column, @Param("id") Long id);

    @Query(value = "from Task t where t.column= :column")
    List<Task> getAllByColumnId(@Param("column") Columns column);
}
