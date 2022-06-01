package at.technikumwien.blog;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import io.micrometer.core.aop.TimedAspect;
import io.micrometer.core.instrument.MeterRegistry;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.scheduling.annotation.EnableScheduling;

import javax.annotation.PostConstruct;

@EnableScheduling
@SpringBootApplication
public class BackendApplication {
    @Autowired
    private ObjectMapper objectMapper;

    public static void main(String[] args) {
        System.out.println("Starting backend application");
        SpringApplication.run(BackendApplication.class, args);
    }
    @PostConstruct
    public void setUp() {
        objectMapper.registerModule(new JavaTimeModule());
}

    @Bean
    public TimedAspect timedAspect(MeterRegistry registry) {
        return new TimedAspect(registry);
    }

}
