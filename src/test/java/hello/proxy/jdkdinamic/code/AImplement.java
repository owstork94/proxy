package hello.proxy.jdkdinamic.code;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class AImplement implements Ainterface{
    @Override
    public String call() {
        log.info("Alogic start");
        return "Alogic";
    }
}
