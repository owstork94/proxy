package hello.proxy.pureproxy.proxy;

import hello.proxy.pureproxy.proxy.code.*;
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

    @Test
    public void timeDecorator(){
        Component realComponent = new RealComponent();
        MessageDecorator messageDecorator = new MessageDecorator(realComponent);
        TimeDecorator timeDecorator = new TimeDecorator(messageDecorator);
        DecoratorPatternClient decoratorPatternClient = new DecoratorPatternClient(timeDecorator);
        decoratorPatternClient.excute();
    }
}
