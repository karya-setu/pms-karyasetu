package com.gfss.pms.Service;

import com.gfss.pms.DTO.DepartmentResponse;
import com.gfss.pms.Entity.PMSDepartment;
import com.gfss.pms.Repository.PMSDepartmentRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.gfss.pms.DTO.DepartmentUpdateRequest;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@Service
public class DepartmentService {

    @Autowired
    private PMSDepartmentRepo repo;

    public DepartmentService(PMSDepartmentRepo repo) {
        this.repo = repo;
    }

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

    //Update Department
    public Optional<PMSDepartment> updateDepartment(String id, PMSDepartment updatedDepartment) {
        Optional<PMSDepartment> existingDepartment = repo.findById(id);
        if (existingDepartment.isPresent()) {
            PMSDepartment department = existingDepartment.get();
            if (updatedDepartment.getDepartmentName() != null)
                department.setDepartmentName(updatedDepartment.getDepartmentName());
            if (updatedDepartment.getDescription() != null)
                department.setDescription(updatedDepartment.getDescription());
            repo.save(department);
            return Optional.of(department);
        }
        return Optional.empty();
    }

    //DELETE operation (simple success/error response)
    public boolean deleteDepartment(String id) {
        if (repo.existsById(id)) {
            repo.deleteById(id);
            return true;
        }
        return false;
    }

    //UPDATE using DTO
    public Optional<DepartmentResponse> updateDepartment(String id, DepartmentUpdateRequest request) {
        Optional<PMSDepartment> departmentOpt = repo.findById(id);
        if (departmentOpt.isPresent()) {
            PMSDepartment department = departmentOpt.get();

            if (request.getDepartmentName() != null)
                department.setDepartmentName(request.getDepartmentName());
            if (request.getDescription() != null)
                department.setDescription(request.getDescription());

            PMSDepartment saved = repo.save(department);

            DepartmentResponse response = DepartmentResponse.builder()
                    .departmentId(saved.getDepartmentId())
                    .departmentName(saved.getDepartmentName())
                    .description(saved.getDescription())
                    .hodName(saved.getHod() != null
                            ? saved.getHod().getFirstName() + " " + saved.getHod().getLastName()
                            : null)
                    .createdOn(saved.getCreatedOn())
                    .build();

            return Optional.of(response);
        }
        return Optional.empty();
    }
}
