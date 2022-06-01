package at.technikumwien.blogcloudconfigserver;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.config.server.EnableConfigServer;

@EnableConfigServer
@SpringBootApplication
public class BlogCloudConfigServerApplication {
    public static void main(String[] args) {
        SpringApplication.run(BlogCloudConfigServerApplication.class, args);
    }

}
