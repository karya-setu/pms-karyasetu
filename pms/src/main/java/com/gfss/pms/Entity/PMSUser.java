package com.gfss.pms.Entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDate;

@Document(collection = "pms-user")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class PMSUser {
    @Id
    private String userId;
    private String firstName;
    private String lastName;
    private String email;
    private String phone;
    private String password;
    private LocalDate dateJoined;
    private String status;

//    @DBRef
//    private Role role;
//
//    @DBRef
//    private Department department;
//
//    @DBRef
//    private Project project;
}
