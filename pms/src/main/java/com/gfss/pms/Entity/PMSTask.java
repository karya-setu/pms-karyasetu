package com.gfss.pms.Entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import java.time.LocalDateTime;

@Document(collection = "task")
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class PMSTask {

    @Id
    private String id;

    private String name;
    private String description;
    private String status;
    private String projectId;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;
}
