package com.gfss.pms.Repository;

import com.gfss.pms.Entity.PMSTask;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;



@Repository
public interface TaskRepository extends MongoRepository<PMSTask, String> {
}
