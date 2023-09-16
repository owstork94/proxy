package hello.proxy.pureproxy.proxy.code;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class MessageDecorator implements Component{

    private Component component;

    public MessageDecorator(Component component) {
        this.component = component;
    }

    @Override
    public String operation() {
        log.info("MessageDecorator 실행");
        String beforMsg = component.operation();
//        log.info("befor : {}",beforMsg);
        String afterMsg = "****"+beforMsg+"****";
        log.info("before : {} | after : {}",beforMsg, afterMsg);
        return afterMsg;
    }
}
