package com.gfss.pms.Repository;

import com.gfss.pms.Entity.PMSProject;
import com.gfss.pms.Entity.PMSProject;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProjectRepository extends MongoRepository<PMSProject, String> {
}