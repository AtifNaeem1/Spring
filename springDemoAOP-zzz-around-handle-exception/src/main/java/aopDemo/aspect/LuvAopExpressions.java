package aopDemo.aspect;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;

@Aspect
public class LuvAopExpressions {

    //pointcut for all methods of package
    @Pointcut("execution(* aopDemo.dao.*.*(..))")
    public void forDaoPackage() {}

    //pointcut for all getter methods
    @Pointcut("execution(* aopDemo.dao.*.get*(..))")
    public void getter() {}

    //pointcut for all setter methods
    @Pointcut("execution(* aopDemo.dao.*.set*(..))")
    public void setter() {}

    //pointcut for all methods of package excluding setter/getter methods
    @Pointcut("forDaoPackage() && !(getter() || setter())")
    public void forDaoPackageNoGetterSetter() {}
}
