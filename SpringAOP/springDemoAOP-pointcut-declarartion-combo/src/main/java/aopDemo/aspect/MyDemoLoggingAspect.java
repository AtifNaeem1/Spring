package aopDemo.aspect;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class MyDemoLoggingAspect {

    //pointcut for all methods of package
    @Pointcut("execution(* aopDemo.dao.*.*(..))")
    private void forDaoPackage() {}

    //pointcut for all getter methods
    @Pointcut("execution(* aopDemo.dao.*.get*(..))")
    private void getter() {}

    //pointcut for all setter methods
    @Pointcut("execution(* aopDemo.dao.*.set*(..))")
    private void setter() {}

    //pointcut for all methods of package excluding setter/getter methods
    @Pointcut("forDaoPackage() && !(getter() || setter())")
    private void forDaoPackageNoGetterSetter() {}

    @Before("forDaoPackageNoGetterSetter()")
    public void beforeAddAccountAdvice()
    {
        System.out.println("\n====>> Executing @Before advice on addAccount()");
    }

    @Before("forDaoPackageNoGetterSetter()")
    public void performApiAnalyticsAdvice()
    {
        System.out.println("\n====>> Performing API analytics");
    }
}
