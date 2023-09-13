package hello.proxy.pureproxy.proxy.code;

public class ProxyPatternClient {

    private final Subject subject;


    public ProxyPatternClient(Subject subject) {
        this.subject = subject;
    }

    public void excute(){
        subject.Operation();
    }
}
