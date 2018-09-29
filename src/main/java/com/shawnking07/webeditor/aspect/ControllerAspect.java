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
            HttpServletRequest request = sra.getRequest();

            String url = request.getRequestURL().toString();
            String method = request.getMethod();
            String uri = request.getRequestURI();
            String queryString = request.getQueryString();
            log.info("Request url: {}, method: {}, uri: {}, urlParams: {}", url, method, uri, queryString);

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
