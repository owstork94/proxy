package hello.proxy.pureproxy.proxy.code;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class RealSubject implements Subject{
    @Override
    public String Operation() {
        //
        log.info("실제 객체 호출");
        sleep(1000);
        return "data";
    }

    private void sleep(int mills) {
        try {
            Thread.sleep(mills);
        }catch (Exception e){
            e.printStackTrace();
        }
    }
}
