package hello.proxy.pureproxy.proxy.code;

public class test {

    public boolean isStringEmpty(String camId){
        int camNameLength = camId.length();
        for(int i = 0; i < camNameLength; i++){
            if(!Character.isWhitespace(camId.charAt(i))){
                return false;
            }
        }
        return true;
    }

}
