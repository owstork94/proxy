package hello.proxy.config.v1_proxy.concret_proxy;

import hello.proxy.app.v2.OrderControllerV2;
import hello.proxy.trace.TraceStatus;
import hello.proxy.trace.logtrace.LogTrace;

public class OrderControllerConcreteProxy extends OrderControllerV2 {

    private final OrderControllerV2 target;
    private final LogTrace trace;

    public OrderControllerConcreteProxy(OrderControllerV2 target, LogTrace trace) {
        super(null);
        this.target = target;
        this.trace = trace;
    }


    public String request(String itemId){
        TraceStatus status = null;
        try {
            status = trace.begin("OrderCont_Request_start");
           String result = target.request(itemId);
            trace.end(status);
            return result;
        }catch (InterruptedException e) {
            trace.exception(status,e);
            throw new RuntimeException(e);
        }
    }
}
