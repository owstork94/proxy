package hello.proxy.config.v1_proxy.concret_proxy;

import hello.proxy.app.v2.OrderRepositoryV2;
import hello.proxy.trace.TraceStatus;
import hello.proxy.trace.logtrace.LogTrace;

public class OrderRepositoryConcreteProxy extends OrderRepositoryV2 {

    private final OrderRepositoryV2 target;
    private final LogTrace logTrace;

    public OrderRepositoryConcreteProxy(OrderRepositoryV2 target, LogTrace logTrace) {
        this.target = target;
        this.logTrace = logTrace;
    }


    @Override
    public void save(String itemId) throws InterruptedException {
        TraceStatus TraceStatus = null;
        try {
            TraceStatus = logTrace.begin("OrderRepo_c_start");
            target.save(itemId);
            logTrace.end(TraceStatus);
        }catch (Exception e){
            logTrace.exception(TraceStatus,e);
            throw e;
        }


    }
}
