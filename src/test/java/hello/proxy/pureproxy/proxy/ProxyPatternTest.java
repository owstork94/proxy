package hello.proxy.pureproxy.proxy;


import hello.proxy.pureproxy.proxy.code.ProxyPatternClient;
import hello.proxy.pureproxy.proxy.code.RealSubject;
import org.junit.jupiter.api.Test;

public class ProxyPatternTest {

    //no proxy - realSubject 를 주입받음


    @Test
    public void noProxy(){
        RealSubject subject = new RealSubject();
        ProxyPatternClient proxyPatternClient = new ProxyPatternClient(subject);
        proxyPatternClient.excute();
        proxyPatternClient.excute();
        proxyPatternClient.excute();
    }



    //yes proxy
}
