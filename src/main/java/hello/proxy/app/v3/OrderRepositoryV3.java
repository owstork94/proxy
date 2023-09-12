package hello.proxy.app.v3;


import org.springframework.stereotype.Repository;

@Repository
public class OrderRepositoryV3 {

    public void save(String itemId){
        if(itemId.equals("ex")){
            throw new IllegalStateException("");
        }
        sleep(2000);
    }

    private void sleep(int mills) {
        try {
            Thread.sleep(mills);
        }catch (Exception e){
            e.printStackTrace();
        }
    }
}
