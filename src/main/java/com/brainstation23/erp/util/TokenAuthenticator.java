package com.brainstation23.erp.util;

import com.brainstation23.erp.constant.UserRole;
import com.brainstation23.erp.exception.custom.custom.UnauthorizedUserException;
import com.brainstation23.erp.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.UUID;

@RequiredArgsConstructor
@Service
public class TokenAuthenticator {
    private final UserService userService;
    public final String UNAUTHORIZED_USER = "Unauthorized User";

    public UserRole getRole(String token) throws Exception{
        if(token == null){
            throw new UnauthorizedUserException("UNAUTHORIZED_USER");
        }
        UUID userId = userService.getUserIdFromJwtToken(token);
        var user = userService.getOne(userId);
        return user.getRole();
    }
}
