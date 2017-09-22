package trng.imcs.test.rest;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.support.SpringBootServletInitializer;
import org.springframework.context.ApplicationContext;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

import trng.imcs.test.repository.PassengerRepository;
import trng.imcs.test.service.PassengerService;

@SpringBootApplication
//@EnableJpaRepositories
public class PassengerRestControllerApplication extends SpringBootServletInitializer {

	@Override
	protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
		return application.sources(PassengerRestControllerApplication.class);
	}

	public static void main(String[] args) {
		ApplicationContext context = SpringApplication.run(PassengerRestControllerApplication.class, args);
		PassengerService pDao = context.getBean(PassengerService.class);

		//DepartmentService serv = (DepartmentService) context.getBean(DepartmentServiceImpl.class);
		System.out.println(pDao.getPassenger(1));

	}
}
