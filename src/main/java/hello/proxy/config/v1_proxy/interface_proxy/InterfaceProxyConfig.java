package hello.proxy.config.v1_proxy.interface_proxy;


import hello.proxy.app.v1.*;
import hello.proxy.trace.logtrace.LogTrace;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class InterfaceProxyConfig {

    @Bean
    public OrderControllerV1 orderController(LogTrace logTrace){
        OrderControllerV1Impl controllerImpl = new OrderControllerV1Impl(orderService(logTrace));
       return new OrderControllerInterfaceProxy(controllerImpl,logTrace);
    }

    @Bean
    public OrderServiceV1 orderService(LogTrace logTrace) {
        OrderServiceV1Impl orderServiceimpl = new OrderServiceV1Impl(orderRepository(logTrace));
        return new OrderServiceInterfaceProxy(orderServiceimpl,logTrace);
    }

    @Bean
    public OrderRepositoryV1 orderRepository(LogTrace logTrace) {
        OrderRepositoryV1 orderRepositoryImpl = new OrderRepositoryV1Impl();
        return new OrderRepositoryInterfaceProxy(orderRepositoryImpl,logTrace);
    }
}
