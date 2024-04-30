package org.example;


import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

@Slf4j
@Component
@org.aspectj.lang.annotation.Aspect
public class Aspect {
    private static final org.slf4j.Logger log = org.slf4j.LoggerFactory.getLogger(Aspect.class);

    //ProceedingJoinPoint — это расширение JoinPoint для работы с потоком кода
    @Around("allServiceMethods()")
    public Object getExecutionTime(ProceedingJoinPoint joinPoint) throws Throwable{
        Long begin = System.currentTimeMillis();
        Object object = joinPoint.proceed();
        Long end = System.currentTimeMillis();

        log.info("Method " + joinPoint.getSignature().toShortString()  + " completed in " + (end - begin) + " ms");
        return object;
    }
    @Pointcut("within(org.example.services.*)")
    public void allServiceMethods() {}

}
