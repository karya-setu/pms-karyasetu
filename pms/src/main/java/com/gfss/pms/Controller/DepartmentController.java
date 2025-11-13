package com.gfss.pms.Controller;

import com.gfss.pms.Entity.PMSDepartment;
import com.gfss.pms.Service.DepartmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

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
}
