package hello.proxy.jdkdinamic;

import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

@Slf4j

public class ReflectionTest {
    @Test
    void reflection0(){
        Hello target = new Hello();

        //공통로직 1 시작.
        log.info("start");
        String result1 = target.callA();
        log.info("result -> {}",result1);

        //공통로직2 시작
        log.info("start");
        String result2 = target.callB();
        log.info("result -< {}",result2);
    }

    @Test
    void reflection1() throws ClassNotFoundException, NoSuchMethodException, InvocationTargetException, IllegalAccessException {
        Class classHello =
                Class.forName("hello.proxy.jdkdinamic.ReflectionTest$Hello");
        Hello target = new Hello();
        Method methodCallA = classHello.getMethod("callA");

        Object result1 = methodCallA.invoke(target);

        log.info("result1,{}",result1);

        Method methodCallB = classHello.getMethod("callB");
        Object result2 = methodCallB.invoke(target);

        log.info("result2,{}",result2);
    }

   static class Hello {

        public String callA(){
            log.info("callA.start");
            return "A";
        }

        public String callB(){
            log.info("callB.start");
            return "B";
        }
    }
}
