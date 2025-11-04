package com.gfss.pms;
import org.springframework.boot.autoconfigure.SpringBootApplication;
 import org.springframework.boot.SpringApplication;
 import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan(basePackages="com.gfss.pms")
public class ProjectManagementSystemApplication {

	public static void main(String[] args) {

        SpringApplication.run(ProjectManagementSystemApplication.class, args);
	}
}
