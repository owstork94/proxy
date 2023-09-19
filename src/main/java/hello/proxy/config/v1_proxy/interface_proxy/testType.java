package hello.proxy.config.v1_proxy.interface_proxy;

import lombok.Getter;

@Getter
public enum testType{
    STORE("C"),
    REPLACE("U");


    private final String code;

    testType(String code) {
        this.code = code;
    }


}
