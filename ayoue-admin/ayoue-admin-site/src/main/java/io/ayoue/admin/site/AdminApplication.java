package io.ayoue.admin.site;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.cloud.netflix.zuul.EnableZuulProxy;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import io.ayoue.admin.site.service.DemoService;

@SpringBootApplication(scanBasePackages = "io.ayoue")
@EnableZuulProxy
@EnableTransactionManagement
@EntityScan(basePackages = "io.ayoue")
@ComponentScan(basePackages = "io.ayoue")
public class AdminApplication {
	public static void main(String[] args) {
		ApplicationContext applicationContext = SpringApplication.run(AdminApplication.class, args);
		applicationContext.getBean(DemoService.class).demo();
	}
}
