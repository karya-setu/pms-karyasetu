package com.gfss.pms.Entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;


@Document(collection = "pms_organizations")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Organization {


    @Id
    private String id;

    private String name;
    private String email;
    private String contactNumber;
    private String address;

    private String adminUserId; // reference to Admin

    private boolean active = true;

    // getters & setters
}
