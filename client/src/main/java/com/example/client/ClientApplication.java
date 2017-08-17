package com.example.client;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@EnableEurekaClient
@SpringBootApplication
public class ClientApplication {

	public static void main(String[] args) {
		SpringApplication.run(ClientApplication.class, args);
	}


	@RestController
	class ServiceInstanceRestController {

		@Autowired
		private DiscoveryClient discoveryClient;

		@RequestMapping("/test")
		public String serviceInstancesByApplicationName() {
		    final String uri = "";
            ServiceInstance s = this.discoveryClient.getInstances("LOG").get(0);

			return s.getUri().toString();
		}

        @RequestMapping("/")
        public String greeting() {
		    System.out.println("Hi from client 1");
		    return "Hello from LogClient!";
        }
	}
}
