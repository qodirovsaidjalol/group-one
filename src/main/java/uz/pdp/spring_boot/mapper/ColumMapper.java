package uz.pdp.spring_boot.mapper;

import org.springframework.stereotype.Component;
import uz.pdp.spring_boot.dto.colim.ColumDto;
import uz.pdp.spring_boot.dto.colim.ColumUpdateDto;
import uz.pdp.spring_boot.dto.colim.CreateColumDto;
import uz.pdp.spring_boot.entity.column.Colum;
import org.mapstruct.Mapper;

import java.util.List;
@Component
@Mapper(componentModel = "spring")
public interface ColumMapper extends BaseMapper<Colum, ColumDto, CreateColumDto, ColumUpdateDto> {

}
