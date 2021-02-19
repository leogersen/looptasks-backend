package com.leogersen.looptasks;

import com.leogersen.looptasks.infrastructure.web.security.SecurityConstants;
import com.leogersen.looptasks.task.Task;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.rest.core.config.RepositoryRestConfiguration;
import org.springframework.data.rest.core.event.ValidatingRepositoryEventListener;
import org.springframework.data.rest.webmvc.config.RepositoryRestConfigurer;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.validation.Validator;
import org.springframework.validation.beanvalidation.LocalValidatorFactoryBean;
import org.springframework.web.servlet.config.annotation.CorsRegistry;

@SpringBootApplication
@EnableWebSecurity
public class LoopTasksBackendApplication implements RepositoryRestConfigurer {

	private static final Logger logger = LoggerFactory.getLogger(LoopTasksBackendApplication.class);

	public static void main(String[] args) {
		SpringApplication.run(LoopTasksBackendApplication.class, args);
		logger.info("LoopTasks in action!");

	}

	@Override
	public void configureRepositoryRestConfiguration(RepositoryRestConfiguration config) {
		config.exposeIdsFor(Task.class);
		config.getCorsRegistry()
				.addMapping("/**")
				.allowedOrigins("*")
				.allowedMethods("GET", "POST", "PUT", "DELETE")
				.exposedHeaders(SecurityConstants.AUTHORIZATION_HEADER);

		logger.info("Repository CORS setup... OK!");

	}

	@Bean
	public Validator validator() {
		return new LocalValidatorFactoryBean();
	}

	@Override
	public void configureValidatingRepositoryEventListener(ValidatingRepositoryEventListener vrel) {
		Validator validator = validator();
		vrel.addValidator("beforeCreate", validator);
		vrel.addValidator("beforeSave", validator);


		logger.info("Configure validator... OK!");


	}
}
