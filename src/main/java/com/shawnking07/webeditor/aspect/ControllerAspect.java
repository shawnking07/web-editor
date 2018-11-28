package com.shawnking07.webeditor.aspect;

import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.Ordered;
import org.springframework.web.context.request.RequestAttributes;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;
import java.util.Objects;

/**
 * @author shawn
 */
@Slf4j
@Aspect
@Configuration
public class ControllerAspect implements Ordered {
    @Pointcut("@annotation(org.springframework.web.bind.annotation.RequestMapping)")
    public void controllerAspect() {
    }

    @Around("controllerAspect()")
    public Object measureMethodExecutionTime(ProceedingJoinPoint pjp) throws Throwable {
        RequestAttributes ra = RequestContextHolder.getRequestAttributes();
        ServletRequestAttributes sra = (ServletRequestAttributes) ra;
        try {
            HttpServletRequest request = Objects.requireNonNull(sra).getRequest();
            String url = request.getRequestURL().toString();
            String method = request.getMethod();
            String queryString = request.getQueryString();
            String remoteHost = request.getRemoteHost();
            log.info("Request url: {}, method: {}, urlParams: {}, host: {}", url, method, queryString, remoteHost);

            Object result = pjp.proceed();
            log.info("Response: " + result);
            return result;
        } catch (NullPointerException e) {
            log.error(e.getMessage());
            return new Object();
        }
    }

    @Override
    public int getOrder() {
        return 999;
    }
}
