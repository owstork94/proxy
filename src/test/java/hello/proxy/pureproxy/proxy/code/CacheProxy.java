package hello.proxy.pureproxy.proxy.code;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class CacheProxy implements Subject{

//    케시 없으면 원본 실행 후 캐시에 넣어서 반환
//            캐시 존재 하면 캐시값 반환 하여
    private final Subject target;
    private String cachvalue;

    public CacheProxy(Subject target) {
        this.target = target;
    }

    @Override
    public String operation() {
        log.info("프록시 호출");
        if(cachvalue == null){
            log.info("프록시x");
            cachvalue = target.operation();
        }
        return cachvalue;
    }
}
