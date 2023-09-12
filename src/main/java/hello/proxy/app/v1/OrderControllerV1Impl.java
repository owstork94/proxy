package hello.proxy.app.v1;

public class OrderControllerV1Impl implements OrderControllerV1{
    private final OrderServiceV1 orderService;

    public OrderControllerV1Impl(OrderServiceV1 orderService) {
        this.orderService = orderService;
    }

    @Override
    public String request(String itemId) throws InterruptedException {
        orderService.orderItem(itemId);
        return "OK1";
    }

    @Override
    public String noLog() {
        return "OK";
    }
}
