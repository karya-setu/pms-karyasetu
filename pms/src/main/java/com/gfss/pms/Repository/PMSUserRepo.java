package com.gfss.pms.Repository;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;
import com.gfss.pms.Entity.PMSUser;

import java.util.Optional;

@Repository
public interface PMSUserRepo extends MongoRepository<PMSUser,String> {
    Optional<PMSUser> findByEmail(String email);
}
