package at.technikumwien.bloggatewayzuul;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.zuul.EnableZuulProxy;

@SpringBootApplication
@EnableZuulProxy
public class BlogGatewayZuulApplication {
	public static void main(String[] args) {
		SpringApplication.run(BlogGatewayZuulApplication.class, args);
	}

}
