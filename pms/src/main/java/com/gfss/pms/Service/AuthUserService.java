package com.gfss.pms.Service;

import com.gfss.pms.Entity.PMSUser;

public interface AuthUserService {
    public PMSUser saveUser(PMSUser user);
    public PMSUser login(String username, String password);
}