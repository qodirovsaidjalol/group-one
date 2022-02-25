package uz.pdp.spring_boot.reposiroty;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import uz.pdp.spring_boot.entity.permission.Permission;

@Repository
public interface PermissionRepository extends JpaRepository<Permission,Long> {

}
