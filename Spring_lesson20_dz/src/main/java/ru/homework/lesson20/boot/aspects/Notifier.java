package ru.homework.lesson20.boot.aspects;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class Notifier {
    @Pointcut("@annotation(ru.homework.lesson20.boot.annotations.Loggable)")
    private void log(){}
    @Around("log()")
    public void logAround(ProceedingJoinPoint point){
        try {
            point.proceed();
            print("Успех, " + point.getSignature().getName() + " выполнена!");
        } catch (Throwable e) {
            print("УПС, что-то пошло не так! " + point.getSignature().getName() + "()");
        }
    }
    private void print (Object o){
        System.out.println(o);
    }
}
