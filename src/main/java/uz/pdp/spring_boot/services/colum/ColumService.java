package uz.pdp.spring_boot.services.colum;

import org.hibernate.mapping.Column;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import uz.pdp.spring_boot.criteria.GenericCriteria;
import uz.pdp.spring_boot.dto.colim.ColumDto;
import uz.pdp.spring_boot.dto.colim.ColumUpdateDto;
import uz.pdp.spring_boot.dto.colim.CreateColumDto;
import uz.pdp.spring_boot.entity.column.Colum;
import uz.pdp.spring_boot.services.GenericCrudService;

public interface ColumService extends GenericCrudService<Colum,
        ColumDto,
        CreateColumDto,
        ColumUpdateDto,
        GenericCriteria, Long> {

}
