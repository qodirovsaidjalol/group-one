package uz.pdp.spring_boot.reposiroty;

import org.springframework.data.jpa.repository.JpaRepository;
import uz.pdp.spring_boot.entity.column.Colum;

public interface ColumRepository extends JpaRepository<Colum,Long>,AbstractRepository {

}
