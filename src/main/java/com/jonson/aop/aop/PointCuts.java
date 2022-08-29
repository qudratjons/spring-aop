package com.jonson.aop.aop;

import org.aspectj.lang.annotation.Pointcut;

public class PointCuts {

    @Pointcut("execution(* com.jonson.aop.service.BookService.get*(..))")
    public void allGetMethods() {}

    @Pointcut("execution(* com.jonson.aop.service.BookService.add*(..))")
    public void allAddMethod() {}

}
