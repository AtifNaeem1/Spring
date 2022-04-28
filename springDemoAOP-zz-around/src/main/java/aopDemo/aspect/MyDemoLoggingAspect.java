package aopDemo.aspect;

import aopDemo.Account;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import java.util.List;

@Aspect
@Component
@Order(2)
public class MyDemoLoggingAspect {

    @Around("execution(* aopDemo.service.*.getFortune(..))")
    public Object aroundGetFortune(
            ProceedingJoinPoint theProceedingJoinPoint) throws Throwable {

        //print out method we are advising on
        String method = theProceedingJoinPoint.getSignature().toShortString();
        System.out.println("\n=====>> Executing @Around on method: " + method);

        //get begin timestamp
        long begin = System.currentTimeMillis();

        //now, lets execute the method
        Object result = theProceedingJoinPoint.proceed();

        //get end timestamp
        long end = System.currentTimeMillis();

        //compute duration and display it
        long duration = end - begin;
        System.out.println("\n===>> Duration: " + duration/1000.0 + " seconds");

        return result;
    }

    // @After will run for success or failure (finally)
    @After("execution(* aopDemo.dao.AccountDAO.findAccounts(..))")
    public void afterFinallyFindAccountsAdvice(JoinPoint theJoinPoint)
    {
        //print out on which method we are advising on
        String method = theJoinPoint.getSignature().toShortString();
        System.out.println("\n=====>> Executing @After(finally) on method: " + method);


    }

    @AfterThrowing(
            pointcut = "execution(* aopDemo.dao.AccountDAO.findAccounts(..))",
            throwing = "theExc"
    )
    public void afterThrowingFindAccountsAdvice(
            JoinPoint theJoinPoint , Throwable theExc)
    {
        //print out on which method we are advising on
        String method = theJoinPoint.getSignature().toShortString();
        System.out.println("\n=====>> Executing @AfterThrowing on method: " + method);

        //log the exception
        System.out.println("\n===>> Logging Exception: The Exception is: " + theExc);

    }

    //add new advice for @AfterReturning on the findAccounts method
    @AfterReturning(
            pointcut = "execution(* aopDemo.dao.AccountDAO.findAccounts(..))",
            returning = "result"
    )
    public void afterReturningFindAccountsAdvice(
            JoinPoint theJoinPoint, List<Account> result)
    {
        //print out method we are advising on
        String method = theJoinPoint.getSignature().toShortString();
        System.out.println("\n====>> Executing @AfterReturning on method: "+method);

        //print out the results of the method call
        System.out.println("\n====>> result is: " +  result);

        //let's post-process data -- lets modify it

        //convert the account names to uppercase
        convertAccountNamesToUpperCase(result);
    }

    private void convertAccountNamesToUpperCase(List<Account> result) {

        //loop through accounts
        for(Account tempAccount:result)
        {
            //get Uppercase version of name
            String theUpperName = tempAccount.getName().toUpperCase();

            //update the name on the account
            tempAccount.setName(theUpperName);
        }

    }

    @Before("aopDemo.aspect.LuvAopExpressions.forDaoPackageNoGetterSetter()")
    public void beforeAddAccountAdvice(JoinPoint theJoinPoint)
    {
        System.out.println("\n====>> Executing @Before advice on addAccount()");

        //display the method signature
        MethodSignature methodSignature = (MethodSignature) theJoinPoint.getSignature();
        System.out.println("Method: " + methodSignature);

        //display method arguments
        Object[] args = theJoinPoint.getArgs();
        for (Object tempArg:args)
        {
            System.out.println(tempArg);

            if(tempArg instanceof Account)
            {
                //downcast and print account specific stuff
                Account theAccount = (Account) tempArg;

                System.out.println("account name: " + theAccount.getName());
                System.out.println("account level: "+ theAccount.getLevel());
            }
        }

    }

}
