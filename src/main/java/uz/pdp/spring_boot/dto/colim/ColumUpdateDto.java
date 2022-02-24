package uz.pdp.spring_boot.dto.colim;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import uz.pdp.spring_boot.dto.GenericDto;

import javax.persistence.Column;
@Getter
@Setter
@NoArgsConstructor
public class ColumUpdateDto extends GenericDto {

    private String name;
    @Column(unique = true)
    private Long order_column;

    private boolean active=true;
}
