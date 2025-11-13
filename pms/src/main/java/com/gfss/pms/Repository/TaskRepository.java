package com.gfss.pms.Repository;

import com.gfss.pms.Entity.PMSTask;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public interface TaskRepository extends MongoRepository<PMSTask, String> {

    List<PMSTask> findByProjectId(String projectId);


    List<PMSTask> findByStatus(String status);

    List<PMSTask> findByProjectIdAndStatus(String projectId, String status);
}
