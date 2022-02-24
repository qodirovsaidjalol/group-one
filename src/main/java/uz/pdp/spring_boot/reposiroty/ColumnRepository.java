package uz.pdp.spring_boot.reposiroty;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import uz.pdp.spring_boot.entity.column.Columns;


public interface ColumnRepository extends JpaRepository<Columns, Long>, AbstractRepository{
    @Query(value = "from Columns  p where p.id=:columnId")
    Columns findColumnById(@Param("columnId") Long columnId);
}
