package com.gfss.pms.Service.Impl;

import com.gfss.pms.Service.AuthenticationFacade;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

@Service
public class AuthenticationFacadeImpl implements AuthenticationFacade {
    @Override
    public Authentication getAuthntication() {
        return SecurityContextHolder.getContext().getAuthentication();
    }
}
