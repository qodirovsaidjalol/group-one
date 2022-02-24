package uz.pdp.spring_boot.dto.colim;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import uz.pdp.spring_boot.dto.Dto;

@Getter
@Setter
@Builder
public class CreateColumDto implements Dto {
    String name;

}
