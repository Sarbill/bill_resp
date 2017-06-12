import org.springframework.aop.framework.ProxyFactory;
import org.springframework.aop.framework.ProxyFactoryBean;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * Created by mj on 2017/5/26 0026.
 */
public class SomeHandler implements InvocationHandler {

    private Object target;

    SomeHandler(Object object) {
        this.target=object;
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        Object res=method.invoke(target, args);
        System.out.println("say reflect");
        return res;
    }


    public static void main(String[] args) throws InstantiationException, IllegalAccessException {
        InvocationHandler someHandler = new SomeHandler( getObj(FooImpl.class));
        Foo proxy= (Foo) Proxy.newProxyInstance(SomeHandler.class.getClassLoader(), new Class[]{Foo.class}, someHandler);
        proxy.sayhello();

    }

    public static Object getObj(Class clazz) throws IllegalAccessException, InstantiationException {
        return clazz.newInstance();
    }
}
