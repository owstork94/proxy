package hello.proxy.jdkdinamic;

import hello.proxy.jdkdinamic.code.AImplement;
import hello.proxy.jdkdinamic.code.Ainterface;
import hello.proxy.jdkdinamic.code.TimeInvocationHandler;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Proxy;

@Slf4j
public class JdkDinamicProxyTest {

    @Test
    void dinamicA(){

        //인터페이스 상속하면 여기서 구현해야되더라..
        Ainterface target = new AImplement();

        TimeInvocationHandler handler = new TimeInvocationHandler(target);
        //A interface 의 proxy 생성
//        newProxyInstance(ClassLoader loader,
//                Class<?>[] interfaces,
//                InvocationHandler h)  이런게 필요하더라 그런데 클래스로더가 뭘까? .
        Ainterface aProxy = (Ainterface) Proxy.newProxyInstance(Ainterface.class.getClassLoader(), new Class[]{Ainterface.class}, handler);
        //여기서 A 인터페이스 프록시 생성 후 실행
        aProxy.call();
        log.info("targetClass={}",target.getClass());
        log.info("proxyClass={}",aProxy.getClass());
    }
}
