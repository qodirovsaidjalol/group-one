package uz.pdp.spring_boot.dto.proect;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import uz.pdp.spring_boot.dto.GenericDto;
import uz.pdp.spring_boot.entity.organization.Organization;

import javax.persistence.FetchType;
import javax.persistence.Lob;
import javax.persistence.ManyToOne;

@Getter
@Setter
@NoArgsConstructor
public class ProjectDto extends GenericDto {
    private String name;
    private String tzPath;
    private Boolean closed;

    @Builder(builderMethodName = "childBuilder")
    public ProjectDto(Long id, String name, String tzPath, Boolean closed) {
        super(id);
        this.name = name;
        this.tzPath = tzPath;
        this.closed = closed;
    }

    public ProjectDto(String name, String tzPath, Boolean closed) {
        this.name = name;
        this.tzPath = tzPath;
        this.closed = closed;
    }
}
