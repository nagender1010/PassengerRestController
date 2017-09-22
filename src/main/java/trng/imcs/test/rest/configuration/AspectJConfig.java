package trng.imcs.test.rest.configuration;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

@Configuration
@ComponentScan("trng.imcs.spring.rest.aop.aspect")
@EnableAspectJAutoProxy
public class AspectJConfig {

}
