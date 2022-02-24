package uz.pdp.spring_boot.dto.proect;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import uz.pdp.spring_boot.dto.GenericDto;


@Getter
@Setter
public class ProjectUpdateDto extends GenericDto {
    @Builder(builderMethodName = "childBuilder")
    public ProjectUpdateDto(Long id, String name, String tzPath, Boolean closed) {
        super(id);
        this.name = name;
        this.tzPath = tzPath;
        this.closed = closed;
    }

    public ProjectUpdateDto(String name, String tzPath, Boolean closed) {
        this.name = name;
        this.tzPath = tzPath;
        this.closed = closed;
    }

    private String name;

    private String tzPath;

    private Boolean closed;
}
