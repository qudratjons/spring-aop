package com.jonson.aop.aop;

import com.jonson.aop.entity.Book;
import com.jonson.aop.util.CustomResponse;
import com.jonson.aop.util.CustomStatus;
import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.stereotype.Component;

@Slf4j
@Aspect
@Component
public class MyAspect {

    @Around("PointCuts.allAddMethod()")
    public Object aroundAddingAdvice(ProceedingJoinPoint joinPoint) {

        MethodSignature signature = (MethodSignature) joinPoint.getSignature();

        if (signature.getName().equals("addBook"))
            for (Object arg : joinPoint.getArgs())
                if (arg instanceof Book)
                    log.info("trying to save book, {}", arg);

        Object result;

        try {
            result = joinPoint.proceed(joinPoint.getArgs());
            log.info("book saved successfully saved, {}", result);
        } catch (Throwable e) {
            log.error("e: {}", e.getMessage());
            log.error("er", e);
            result = new CustomResponse<>(null, CustomStatus.EXCEPTON);
        }
        return result;
    }
}
