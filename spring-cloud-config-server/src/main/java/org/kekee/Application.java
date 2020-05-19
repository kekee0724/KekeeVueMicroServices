package org.kekee;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.config.server.EnableConfigServer;
//import org.springframework.cloud.openfeign.EnableFeignClients;

/**
 * @author cocoa
 */
@SpringBootApplication(exclude= {DataSourceAutoConfiguration.class})
@EnableDiscoveryClient
@EnableConfigServer
public class Application {
	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
	}
}
