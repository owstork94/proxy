package hello.proxy;

import hello.proxy.config.v2_dinamicProxy.DynamicProxyBasicConfig;
import hello.proxy.config.v2_dinamicProxy.DynamicProxyFiltterConfig;
import hello.proxy.trace.logtrace.LogTrace;
import hello.proxy.trace.logtrace.ThreadLocalLogTrace;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Import;

//@Import({AppV1Config.class, AppV2Config.class})
//@Import(InterfaceProxyConfig.class)
//@Import(ConcreteProxyConfig.class)
//@Import(DynamicProxyBasicConfig.class)
@Import(DynamicProxyFiltterConfig.class)
@SpringBootApplication(scanBasePackages = "hello.proxy.app") //주의ss
public class ProxyApplication {


	//scan 범위 ( proxy app)
	public static void main(String[] args) {
		SpringApplication.run(ProxyApplication.class, args);
	}

	@Bean
	public LogTrace logTrace(){
		return new ThreadLocalLogTrace();
	}

}
