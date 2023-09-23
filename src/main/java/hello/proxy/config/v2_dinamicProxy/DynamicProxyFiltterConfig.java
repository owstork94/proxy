package hello.proxy.config.v2_dinamicProxy;

import hello.proxy.app.v1.*;
import hello.proxy.config.v2_dinamicProxy.handler.LogTraceBasicHandler;
import hello.proxy.config.v2_dinamicProxy.handler.LogTraceFiltterHandler;
import hello.proxy.trace.logtrace.LogTrace;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.lang.reflect.Proxy;

@Configuration
public class DynamicProxyFiltterConfig {

    //컨트롤러 선언, 프록시 리턴 : 컨트롤러 호출하면 프록시 받게 처리.

    //리스트는 리스트 형태로 하드코딩
private static final String[] PATTERNS = {"request*","order*","save*"};

    @Bean
   public OrderControllerV1 orderControllerV1(LogTrace logTrace){
        //target 생성
        OrderControllerV1 orderControllerV1 =
                new OrderControllerV1Impl(
                        orderServiceV1(logTrace));

        //proxy 생성
        OrderControllerV1 proxy = (OrderControllerV1)
                Proxy.newProxyInstance(OrderControllerV1.class.getClassLoader(),
                        new Class[]{OrderControllerV1.class},
                        //생성자 대로 ... 생성 되게 강제 하여 새로운 핸들러 생성 하니PATTERS 추가 하도록 강제됨.
                        new LogTraceFiltterHandler(orderControllerV1,logTrace,PATTERNS));

        //대신 프록시 호출
        return proxy;
    }

    @Bean
    public OrderServiceV1 orderServiceV1(LogTrace logTrace) {
        OrderServiceV1 serviceV1 =
                new OrderServiceV1Impl(orderRepository(logTrace));
        OrderServiceV1 proxy = (OrderServiceV1)
                Proxy.newProxyInstance(OrderServiceV1.class.getClassLoader(),
                        new Class[]{OrderServiceV1.class},
                        new LogTraceFiltterHandler(serviceV1,logTrace,PATTERNS));
        return proxy;
    }

    @Bean
    public OrderRepositoryV1 orderRepository(LogTrace logTrace) {
        OrderRepositoryV1 orderRepositoryV1 =
                new OrderRepositoryV1Impl();
        OrderRepositoryV1 proxy = (OrderRepositoryV1)
                Proxy.newProxyInstance(OrderRepositoryV1.class.getClassLoader(),
                        new Class[]{OrderRepositoryV1.class},
                        new LogTraceFiltterHandler(orderRepositoryV1,logTrace,PATTERNS));
        return proxy;
    }

}
