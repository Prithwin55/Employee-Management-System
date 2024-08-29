package emsprojectbackend.emsprojectbackend.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class DepartmentDto {
    private Long id;
    private String dname;
    private String ddesc;
}
