package com.shawnking07.webeditor.util;

import com.shawnking07.webeditor.security.JwtTokenProvider;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.util.StringUtils;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import java.util.Objects;

/**
 * @author shawn
 */
public class UserUtil {
    private static final String PREFIX = "Bearer ";

    public static String getJwtFromRequest() {
        String authorization = ((ServletRequestAttributes) Objects.requireNonNull(RequestContextHolder.getRequestAttributes())).getRequest().getHeader("Authorization");
        if (StringUtils.hasText(authorization) && authorization.startsWith(PREFIX)) {
            return authorization.substring(PREFIX.length());
        }
        return null;
    }

    public static Long getCurrentUserIdFromRequest() {
        String jwt = getJwtFromRequest();
        return new JwtTokenProvider().getUserIdFromJWT(jwt);
    }

    public static String getCurrentUsernameFromSecurity() {
        Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        if (principal instanceof UserDetails) {
            return ((UserDetails) principal).getUsername();
        } else {
            return principal.toString();
        }
    }
}
