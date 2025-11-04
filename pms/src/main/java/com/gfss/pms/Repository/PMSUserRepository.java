package com.gfss.pms.Repository;

import com.gfss.pms.Entity.PMSUser;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface PMSUserRepository extends MongoRepository<PMSUser, String> {
}
