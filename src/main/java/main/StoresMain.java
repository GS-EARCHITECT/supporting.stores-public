package main;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
@EnableScheduling
@EntityScan(basePackages = {"storeRegisterManagement","common.domain","storeMovementManager"})
@EnableJpaRepositories(basePackages = {"storeRegisterManagement","common.domain","storeMovementManager"})
@ComponentScan({"storeRegisterManagement","common.domain","storeMovementManager"})
public class StoresMain extends SpringBootServletInitializer  
{

	@Override
	protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
		return application.sources(StoresMain.class);
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		SpringApplication.run(StoresMain.class, args);
	}
}