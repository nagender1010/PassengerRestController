package trng.imcs.test.rest.configuration;

import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

import trng.imcs.test.config.ApplicationConfig;


@Configuration
@EnableWebMvc
@Import(value= {ApplicationConfig.class, AspectJConfig.class})
public class AppRestConfig {
	
}