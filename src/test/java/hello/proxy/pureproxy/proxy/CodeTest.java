package hello.proxy.pureproxy.proxy;

import hello.proxy.pureproxy.proxy.code.test;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

@Slf4j
public class CodeTest {
    @Test
    public void testIsStringEmpty() {
        test obj = new test(); // "YourClass"는 isStringEmpty 메서드가 정의된 클래스의 이름으로 바꿔주세요.

        // Test with a string containing only whitespace
        boolean result1 = obj.isStringEmpty("    ");
        log.info("result1 : {}",result1);
        assertTrue(result1);

        boolean result2 = obj.isStringEmpty("abc");
        log.info("result2 : {}",obj.isStringEmpty("abc"));
        // Test with a string containing some characters
        assertFalse(obj.isStringEmpty("abc"));

        // Test with a string containing characters and whitespace
        assertFalse(obj.isStringEmpty(" a "));

        // Test with an empty string
        assertTrue(obj.isStringEmpty(""));
    }
}



