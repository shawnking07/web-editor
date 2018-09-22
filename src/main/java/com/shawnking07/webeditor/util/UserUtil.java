package com.shawnking07.webeditor.util;

import com.shawnking07.webeditor.security.JwtTokenProvider;
import org.springframework.util.StringUtils;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import java.util.Objects;

/**
 * @author shawn
 */
public class UserUtil {
    private static String PROFFIX = "Bearer ";

    public static String getJwtFromRequest() {
        String authorization = ((ServletRequestAttributes) Objects.requireNonNull(RequestContextHolder.getRequestAttributes())).getRequest().getHeader("Authorization");
        if (StringUtils.hasText(authorization) && authorization.startsWith(PROFFIX)) {
            return authorization.substring(PROFFIX.length());
        }
        return null;
    }

    public static Long getCurrentUserId() {
        String jwt = getJwtFromRequest();
        return new JwtTokenProvider().getUserIdFromJWT(jwt);
    }
}
