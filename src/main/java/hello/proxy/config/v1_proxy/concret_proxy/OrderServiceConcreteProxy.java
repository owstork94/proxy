package hello.proxy.config.v1_proxy.concret_proxy;

import hello.proxy.app.v2.OrderServiceV2;
import hello.proxy.trace.TraceStatus;
import hello.proxy.trace.logtrace.LogTrace;

public class OrderServiceConcreteProxy extends OrderServiceV2 {

    private final OrderServiceV2 target;
    private final LogTrace trace;

    public OrderServiceConcreteProxy(OrderServiceV2 target, LogTrace trace) {
        super(null);
        this.target = target;
        this.trace = trace;
    }


    public void orderItem(String itemId){
        TraceStatus status = null;

        try {
            status =  trace.begin("OrderService_con_start");
            target.orderItem(itemId);
            trace.end(status);
        } catch (InterruptedException e) {
            trace.exception(status,e);
            throw new RuntimeException(e);
        }
    }
}
