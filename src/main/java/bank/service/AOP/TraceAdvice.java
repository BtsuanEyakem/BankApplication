package bank.service.AOP;

import bank.integration.logging.Logger;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.util.StopWatch;

@Aspect
@Configuration
public class TraceAdvice {

    @Autowired
    private Logger logger;

    public TraceAdvice(Logger logger){
        this.logger = logger;
    }

    @Before("execution(* bank.repository.AccountRepository.*(..))")
    public void beforeAdvice(JoinPoint joinPoint) {
        logger.log(" Before excution of method " +joinPoint.getSignature().getName());
       // System.out.println(LocalDate.now()+" Before excution of method " +joinPoint.getSignature().getName());
    }

    @Around("execution(* bank.service.AccountService.*(..))")
    public Object aroundAdvice(ProceedingJoinPoint joinPoint) throws Throwable {
        StopWatch clock = new StopWatch();
        clock.start(joinPoint.toShortString());
        Object obj = joinPoint.proceed();
        clock.stop();
        System.out.println("Total processin time------------------"+clock.prettyPrint());
        return obj;
    }

    @After("execution(* bank.integration.jms.JMSSenderImpl.sendJMSMessage(..))")
    public void afterAdvice(JoinPoint joinPoint){
        logger.log(" After excution of method " +joinPoint.getArgs()[0]);
    }
}
