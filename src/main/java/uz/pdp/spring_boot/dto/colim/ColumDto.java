package uz.pdp.spring_boot.dto.colim;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import uz.pdp.spring_boot.dto.GenericDto;
@Getter
@Setter
public class ColumDto extends GenericDto {

    private String name;

    private Long order_column;

    private boolean active;

    private Long projectId;
  @Builder(builderMethodName = "childBuilder")
    public ColumDto(Long id, String name, Long order_column, boolean active, Long projectId) {
        super(id);
        this.name = name;
        this.order_column = order_column;
        this.active = active;
        this.projectId = projectId;
    }

}
