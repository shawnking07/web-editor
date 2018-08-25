package com.shawnking07.webeditor.util;

import com.shawnking07.webeditor.security.JwtTokenProvider;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import java.util.Objects;

/**
 * @author shawn
 */
public class UserUtil {
    public static Long getCurrentUserId() {
        String jwt = ((ServletRequestAttributes) Objects.requireNonNull(RequestContextHolder.getRequestAttributes())).getRequest().getHeader("Authorization");
        return new JwtTokenProvider().getUserIdFromJWT(jwt);
    }
}
