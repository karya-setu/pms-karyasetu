package com.gfss.pms.Repository;

import com.gfss.pms.Entity.Organization;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface OrganizationRepository
        extends MongoRepository<Organization, String> {
}
