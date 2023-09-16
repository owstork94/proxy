package hello.proxy.pureproxy.proxy;

import hello.proxy.pureproxy.proxy.code.Component;
import hello.proxy.pureproxy.proxy.code.DecoratorPatternClient;
import hello.proxy.pureproxy.proxy.code.MessageDecorator;
import hello.proxy.pureproxy.proxy.code.RealComponent;
import org.junit.jupiter.api.Test;

public class DecorationPatternTest {

    @Test
public void noDecorator(){
    Component realComponent = new RealComponent();
    DecoratorPatternClient decoratorPatternClient = new DecoratorPatternClient(realComponent);
    decoratorPatternClient.excute();
}

    @Test
    public void massageDecorator(){
        Component realComponent = new RealComponent();
        MessageDecorator messageDecorator = new MessageDecorator(realComponent);
        DecoratorPatternClient decoratorPatternClient = new DecoratorPatternClient(messageDecorator);
        decoratorPatternClient.excute();
    }

}
