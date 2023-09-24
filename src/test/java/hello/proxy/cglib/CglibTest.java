package hello.proxy.cglib;

import hello.proxy.cglib.code.TimeMethodeInterceptor;
import hello.proxy.common.service.ConcreteService;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.cglib.proxy.Enhancer;

@Slf4j
public class CglibTest {



    @Test
void cglib(){
        ConcreteService target = new ConcreteService();

        //cglib 는 enhancer 안에 생성할 클래스와 interceptor(jdk dinamic 에서는 handler) 를 담아 proxy 에 전달한다.
        Enhancer enhancer = new Enhancer();
        enhancer.setSuperclass(ConcreteService.class);
        enhancer.setCallback(new TimeMethodeInterceptor(target));

        ConcreteService proxy = (ConcreteService) enhancer.create();
        log.info("targetClass = {}",target.getClass());
        log.info("proxyClass = {}",proxy.getClass());

        proxy.call();
}
}
