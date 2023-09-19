package hello.proxy.pureproxy.proxy.code;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class TimeProxy extends ConcreteLogic{

    private final ConcreteLogic realLogic;

    public TimeProxy(ConcreteLogic concreteLogic) {
        this.realLogic = concreteLogic;
    }

    @Override
    public String Operation(){
        Long startTime = System.currentTimeMillis();
        String result = realLogic.Operation();
        Long resultTime = System.currentTimeMillis() - startTime;
        log.info("result time = {}",resultTime);
        return result;
    }

}
