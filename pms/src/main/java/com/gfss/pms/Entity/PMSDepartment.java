package com.gfss.pms.Entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDate;

@Document(collection = "pms-department")
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class PMSDepartment {
    @Id
    private String departmentId;
    private String departmentName;
    private String description;
    @DBRef
    private PMSUser hod;
    private LocalDate createdOn;
}

