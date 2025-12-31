package com.gfss.pms.Controller;

import com.gfss.pms.Entity.PMSDepartment;
import com.gfss.pms.Service.DepartmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import com.gfss.pms.DTO.DepartmentResponse;
import com.gfss.pms.DTO.DepartmentUpdateRequest;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/department")
public class DepartmentController {

    @Autowired
    private DepartmentService service;

    //Create Department
    @PostMapping("/create")
    public ResponseEntity<PMSDepartment> createDepartment(@RequestBody PMSDepartment department) {
        PMSDepartment savedDepartment = service.createDepartment(department);
        return ResponseEntity.ok(savedDepartment);
    }

    //Get All Departments
    @GetMapping("/all")
    public ResponseEntity<List<PMSDepartment>> getAllDepartments() {
        return ResponseEntity.ok(service.getAllDepartments());
    }

    //Get Department By Name
    @GetMapping("/{name}")
    public ResponseEntity<PMSDepartment> getDepartmentByName(@PathVariable String name) {
        PMSDepartment department = service.getDepartmentByName(name);
        return ResponseEntity.ok(department);
    }

    //Get Department by ID
    @GetMapping("/id/{id}")
    public ResponseEntity<Optional<PMSDepartment>> getDepartmentById(@PathVariable String id) {
        return ResponseEntity.ok(service.getDepartmentById(id));
    }

    //Update Department using DTO
    @PutMapping("/update/{id}")
    public ResponseEntity<?> updateDepartment(
            @PathVariable String id,
            @RequestBody DepartmentUpdateRequest request) {

        Optional<DepartmentResponse> updated = service.updateDepartment(id, request);
        if (updated.isPresent()) {
            return ResponseEntity.ok(updated.get());
        } else {
            return ResponseEntity.status(404).body(
                    new ErrorResponse("error", "Department not found"));
        }
    }

    //Delete Department
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> deleteDepartment(@PathVariable String id) {
        boolean deleted = service.deleteDepartment(id);
        if (deleted) {
            return ResponseEntity.ok(
                    new SimpleResponse("success", "Department deleted successfully"));
        } else {
            return ResponseEntity.status(404).body(
                    new ErrorResponse("error", "Department not found"));
        }
    }

    //Inner DTOs for simple responses
    record SimpleResponse(String status, String message) {}
    record ErrorResponse(String status, String message) {}
}
