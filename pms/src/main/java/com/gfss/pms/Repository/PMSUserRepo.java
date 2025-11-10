package com.gfss.pms.Repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;
import com.gfss.pms.Entity.PMSUser;

@Repository
public interface PMSUserRepo extends MongoRepository<PMSUser, String> {

    // Optional: Add custom query method for flexibility
    PMSUser findByEmail(String email);
}
