package hello.proxy.app.v1;

public class OrderRepositoryV1Impl implements OrderRepositoryV1 {
    @Override
    public void save(String itemId) throws InterruptedException {
        if(itemId.equals("ex")){
            throw new IllegalStateException("꺅");
        }
        sleep(2000);
    }

    private void sleep(int milliS) throws InterruptedException {
        Thread.sleep(milliS);
    }
}
