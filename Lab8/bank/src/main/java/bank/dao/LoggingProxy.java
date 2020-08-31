package bank.dao;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

public class LoggingProxy implements InvocationHandler {

    private IAccountDAO iAccountDAO;

    public LoggingProxy(IAccountDAO iAccountDAO) {
        this.iAccountDAO = iAccountDAO;
    }


    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        System.out.println("Logger: Invoking from " +method.getName());

        return method.invoke(iAccountDAO, args);
    }
}
