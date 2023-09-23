package hello.proxy.jdkdinamic.code;

import lombok.extern.slf4j.Slf4j;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

@Slf4j
public class TimeInvocationHandler implements InvocationHandler {

    private final Object target;

    public TimeInvocationHandler(Object target) {
        this.target = target;
    }


    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        log.info("TimeProxy 실행");
        long startTime = System.currentTimeMillis();
        //이게 파라미터 순서가 args,target으로 바꾸면 컴파일 에러나더라
        Object result = method.invoke(target,args);
        long endTime = System.currentTimeMillis();
        long resultTime =endTime - startTime;
        log.info("소요시간 : {}",resultTime);
        return result;
    }
}
