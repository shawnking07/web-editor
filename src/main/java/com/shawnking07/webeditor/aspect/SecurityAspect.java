package com.shawnking07.webeditor.aspect;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.core.Ordered;

/**
 * @author shawn
 */
@Aspect
public class SecurityAspect implements Ordered {
    @Pointcut("@annotation(org.springframework.web.bind.annotation.RequestMapping)")
    public void securityAspect() {}

    @Around("securityAspect()")
    public Object measureMethodExecutionTime(ProceedingJoinPoint pjp) {
        return new Object();
    }

    @Override
    public int getOrder() {
        return 999;
    }
}
