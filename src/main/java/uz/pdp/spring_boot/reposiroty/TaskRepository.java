package uz.pdp.spring_boot.reposiroty;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Component;
import uz.pdp.spring_boot.entity.column.Colum;
import uz.pdp.spring_boot.entity.task.Task;

import javax.transaction.Transactional;
import java.util.List;
@Component
public interface TaskRepository extends JpaRepository<Task, Long>, AbstractRepository {
    @Modifying
    @Transactional
    @Query("update Task t set t.name=:name,t.description=:description,t.column=:column  where t.id = :id")
    void update(@Param("name") String name, @Param("description") String description, @Param("column") Colum column, @Param("id") Long id);

    @Query(value = "from Task t where t.column= :colum")
    List<Task> getAllByColumnId(@Param("colum") Colum colum);

    Task findTaskById(Long id);

    @Query(value = "from Task t where t.id=:id")
    Task getTask(Long id);

    @Query(value = "update Task t set t.isBlocked=:b where t.id=:id")
    void block(Long id, boolean b);
}
