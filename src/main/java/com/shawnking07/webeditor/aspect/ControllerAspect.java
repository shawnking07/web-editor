package com.shawnking07.webeditor.aspect;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.Ordered;
import org.springframework.web.context.request.RequestAttributes;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;

/**
 * @author shawn
 */
@Aspect
@Configuration
public class ControllerAspect implements Ordered {
    private final Logger logger = LoggerFactory.getLogger(ControllerAspect.class);

    @Pointcut("@annotation(org.springframework.web.bind.annotation.RequestMapping)")
    public void controllerAspect() {
    }

    @Around("controllerAspect()")
    public Object measureMethodExecutionTime(ProceedingJoinPoint pjp) throws Throwable {
        RequestAttributes ra = RequestContextHolder.getRequestAttributes();
        ServletRequestAttributes sra = (ServletRequestAttributes) ra;
        try {
            assert sra != null;
            HttpServletRequest request = sra.getRequest();

            String url = request.getRequestURL().toString();
            String method = request.getMethod();
            String uri = request.getRequestURI();
            String queryString = request.getQueryString();
            logger.info("Request url: {}, method: {}, uri: {}, urlParams: {}", url, method, uri, queryString);

            Object result = pjp.proceed();
            logger.info("Response: " + result);
            return result;
        } catch (NullPointerException e) {
            logger.error(e.getMessage());
            return new Object();
        }
    }

    @Override
    public int getOrder() {
        return 999;
    }
}
