package hello.proxy.cglib.code;

import lombok.extern.slf4j.Slf4j;
import org.springframework.cglib.proxy.MethodInterceptor;
import org.springframework.cglib.proxy.MethodProxy;

import java.lang.reflect.Method;

@Slf4j
public class TimeMethodeInterceptor implements MethodInterceptor {

    private final Object target;

    public TimeMethodeInterceptor(Object target) {
        this.target = target;
    }

    //jdk dinamic 과 동일
    @Override
    public Object intercept(Object o, Method method, Object[] objects, MethodProxy methodProxy) throws Throwable {
        long startTime = System.currentTimeMillis();
        //jdk dinamic 과 같이 method 사용 해도 되지만 cglib 에선 methodProxy 사용
        Object result = methodProxy.invoke(target,objects);
        long endTime = System.currentTimeMillis();
        long resultTime = endTime - startTime;
        log.info("result Time = {}",resultTime);
        return result;
    }
}
