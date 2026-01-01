package com.gfss.pms.Entity;

import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDate;

@Document(collection = "pms-user")
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class PMSUser {

    @Id
    private String userId;

    private String firstName;
    private String lastName;
    private String email;
    private String phone;
    private String password;

    @Builder.Default
    private LocalDate dateJoined = LocalDate.now();

    @Builder.Default
    private String status = "ACTIVE";
}
