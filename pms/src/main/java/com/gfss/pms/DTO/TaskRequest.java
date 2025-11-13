package com.gfss.pms.DTO;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class TaskRequest {
    private String name;
    private String description;
    private String status;     // e.g., "Pending", "In Progress", "Completed"
    private String projectId;  // link to a project if needed
}
