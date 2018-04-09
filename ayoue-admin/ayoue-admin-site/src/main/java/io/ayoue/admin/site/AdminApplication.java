package io.ayoue.admin.site;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.ApplicationContext;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import io.ayoue.admin.site.service.DemoService;

@SpringBootApplication(scanBasePackages = "io.ayoue")
@EnableTransactionManagement
@EntityScan(basePackages = "io.ayoue")
public class AdminApplication {
	public static void main(String[] args) {
		ApplicationContext applicationContext = SpringApplication.run(AdminApplication.class, args);
		applicationContext.getBean(DemoService.class).demo();
	}
}
