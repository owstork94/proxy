package hello.proxy.app.v2;

public class OrderRepositoryV2 {

    public void save(String itemId) throws InterruptedException {

        if (itemId.equals("ex")){
            throw new IllegalStateException("");
        }
        sleep(2000);

    }

    private void sleep(int mileS) throws InterruptedException {
        Thread.sleep(mileS);
    }
}
