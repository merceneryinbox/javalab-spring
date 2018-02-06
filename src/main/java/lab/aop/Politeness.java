package lab.aop;

import checkers.compilermsgs.quals.CompilerMessageKey;
import lab.model.Person;
import lab.model.Squishee;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.stereotype.Component;

@Component
@Aspect
public class Politeness {

    @Pointcut("execution(* sellSquishee(..))")
    public void sellSquishee() {
    }

    @Before("sellSquishee() && args(person)")
    public void sayHello(Person person) {
        System.out.printf("Hello %s. How are you doing?%n", person.getName());
    }

    @AfterReturning(pointcut = "sellSquishee()",
            returning = "retVal", argNames = "retVal")
    public void askOpinion(Squishee retVal) {
        System.out.printf("Is %s Good Enough?%n", retVal.getName());
    }

    @AfterThrowing("execution(* sellSquishee(..))")
    public void youAreNotAllowed(){
        System.out.println("You are ! Get out !");
    }

    @After("sellSquishee()")
    public void sayGoodby(){
        System.out.println("Good by");
    }

    @Around("execution(* sellSquishee(..))")
    public Object sayPolliteWordsAndSell(ProceedingJoinPoint proceedingJoinPoint) throws Throwable {
        System.out.println("Hello!");
        Object o= proceedingJoinPoint.proceed();
        System.out.println("Goodby!");
        return o;
    }
}