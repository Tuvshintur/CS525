package bank.dao;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

public class TimerProxy implements InvocationHandler {

    private Object object;

    public TimerProxy(Object object) {
        this.object = object;
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        long start = System.currentTimeMillis();

        Object result = method.invoke(object, args);

        long elapsedTime = System.currentTimeMillis() - start;

        System.out.println("Elapsed time for current operation: " + elapsedTime + "milliseconds to exectute operation: " + method.getName());

        return result;
    }
}
