package com.gfss.pms.Service;

import com.gfss.pms.Entity.PMSDepartment;
import com.gfss.pms.Repository.PMSDepartmentRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@Service
public class DepartmentService {

    @Autowired
    private PMSDepartmentRepo repo;

    //Create Department
    public PMSDepartment createDepartment(PMSDepartment department) {
        // Automatically set createdOn date
        department.setCreatedOn(LocalDate.now());
        return repo.save(department);
    }

    //Get All Departments
    public List<PMSDepartment> getAllDepartments() {
        return repo.findAll();
    }

    //Get Department By Name
    public PMSDepartment getDepartmentByName(String departmentName) {
        return repo.findByDepartmentName(departmentName);
    }

    //Get Department by ID
    public Optional<PMSDepartment> getDepartmentById(String id) {
        return repo.findById(id);
    }
}
