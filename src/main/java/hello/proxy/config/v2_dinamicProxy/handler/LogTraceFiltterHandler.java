package hello.proxy.config.v2_dinamicProxy.handler;

import hello.proxy.trace.TraceStatus;
import hello.proxy.trace.logtrace.LogTrace;
import org.springframework.util.PatternMatchUtils;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

public class LogTraceFiltterHandler implements InvocationHandler {

    private final Object target;
    private final LogTrace logTrace;

    private final String[] Patterns;

    public LogTraceFiltterHandler(Object target, LogTrace logTrace, String[] patterns) {
        this.target = target;
        this.logTrace = logTrace;
        this.Patterns = patterns;
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {

        TraceStatus status = null;
        String methodName = method.getName();
        if (!PatternMatchUtils.simpleMatch(Patterns,methodName)){
            return method.invoke(target,args);
        }
        try {
            String message = method.getDeclaringClass().getSimpleName() + "."
                    + method.getName() + "()";
            status = logTrace.begin(message);
            Object result = method.invoke(target,args);
            logTrace.end(status);
            return result;
        }catch (Exception e){
            logTrace.exception(status,e);
            throw e;
        }
    }
}
