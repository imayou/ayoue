package io.ayoue.sso.passport;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.boot.web.servlet.ServletContextInitializer;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@EntityScan(basePackages = "io.ayoue")
@EnableJpaRepositories(basePackages = "io.ayoue.**.repository")
@ComponentScan(basePackages = "io.ayoue.**")
public class LoginApplication implements ServletContextInitializer {
	public static void main(String[] args) {
		SpringApplication.run(LoginApplication.class, args);
	}

	@Override
	public void onStartup(ServletContext servletContext) throws ServletException {
		servletContext.getSessionCookieConfig().setName("SESSIONID");
	}
}
