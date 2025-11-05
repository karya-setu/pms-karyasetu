package com.gfss.pms.Repo;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;
import com.gfss.pms.Entity.PMSUser;
@Repository


public interface PMSUserRepo extends MongoRepository<PMSUser,String> {
    boolean existsByEmail(String email);
}
