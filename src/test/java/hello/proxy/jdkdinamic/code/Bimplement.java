package hello.proxy.jdkdinamic.code;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class Bimplement implements Binterface{
    @Override
    public String call() {
        log.info("B logic start");
        return "B logic";
    }
}
