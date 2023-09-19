package hello.proxy.pureproxy.proxy;

import hello.proxy.pureproxy.proxy.code.ConcreatLogicClient;
import hello.proxy.pureproxy.proxy.code.ConcreteLogic;
import hello.proxy.pureproxy.proxy.code.TimeProxy;
import org.junit.jupiter.api.Test;

public class ConcreatProxyTest {


    @Test
    void noProxy(){
        ConcreteLogic concreteLogic = new ConcreteLogic();
        ConcreatLogicClient client = new ConcreatLogicClient(concreteLogic);
        client.excute();
    }

    @Test
    void yesProxy(){
        ConcreteLogic realLogic = new ConcreteLogic();
        TimeProxy timeProxy = new TimeProxy(realLogic);
        ConcreatLogicClient client = new ConcreatLogicClient(timeProxy);
        client.excute();
    }
}
