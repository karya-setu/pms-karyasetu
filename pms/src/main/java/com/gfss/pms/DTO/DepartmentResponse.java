package com.gfss.pms.DTO;

import lombok.Builder;
import lombok.Data;
import java.time.LocalDate;

@Data
@Builder
public class DepartmentResponse {
    private String departmentId;
    private String departmentName;
    private String description;
    private String hodName;
    private String projectName;
    private LocalDate createdOn;
}
