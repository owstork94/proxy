package hello.proxy.pureproxy.proxy.code;

public class ConcreatLogicClient {

    private final ConcreteLogic concreteLogic;

    public ConcreatLogicClient(ConcreteLogic concreteLogic) {
        this.concreteLogic = concreteLogic;
    }

    public void excute(){
        concreteLogic.Operation();
    }


}
