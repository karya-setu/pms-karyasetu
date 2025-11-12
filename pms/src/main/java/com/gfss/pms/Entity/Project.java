package com.gfss.pms.Entity;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import java.time.LocalDateTime;

@Document(collection = "projects")
public class Project {

	    @Id
	    private String id;

	    private String name;
	    private String description;
	    private String status;  // e.g., "Active", "Completed", "On Hold"
	    private String startDate;
	    private String endDate;

	    public Project() {}

	    public Project(String name, String description, String status, String startDate, String endDate) {
	        this.name = name;
	        this.description = description;
	        this.status = status;
	        this.startDate = startDate;
	        this.endDate = endDate;
	    }

	    // Getters & Setters
	    public String getId() { return id; }
	    public void setId(String id) { this.id = id; }

	    public String getName() { return name; }
	    public void setName(String name) { this.name = name; }

	    public String getDescription() { return description; }
	    public void setDescription(String description) { this.description = description; }

	    public String getStatus() { return status; }
	    public void setStatus(String status) { this.status = status; }

	    public String getStartDate() { return startDate; }
	    public void setStartDate(String startDate) { this.startDate = startDate; }

	    public String getEndDate() { return endDate; }
	    public void setEndDate(String endDate) { this.endDate = endDate; }
	}