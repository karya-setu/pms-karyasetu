package com.gfss.pms.Repository;

import com.gfss.pms.Entity.PMSDepartment;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;
@Repository

public interface PMSDepartmentRepo extends MongoRepository<PMSDepartment, String> {
    PMSDepartment findByDepartmentName(String departmentName);
}