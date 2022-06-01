package at.technikumwien.bloggateway.config;

import lombok.extern.slf4j.Slf4j;
import org.springframework.cloud.gateway.route.RouteLocator;
import org.springframework.cloud.gateway.route.builder.RouteLocatorBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Slf4j
@Configuration
public class RoutesConfig {

    @Bean
    public RouteLocator customRouteLocator(RouteLocatorBuilder routeLocatorBuilder) {
        return routeLocatorBuilder.routes()
            .route("blog-service",r -> r.path("/api/v1/news*", "/api/v1/news/**", "/api/v1/authors/**", "/api/v1/authors*", "/api/v1/authors/news/**", "/api/v1/authors/news*")
                .uri("lb://blog-service"))
            .route("blog-statisticsMS",r -> r.path("/api/v1/statistics*", "/api/v1/statistics/**")
                .uri("lb://blog-statisticsMS"))
            .build();
    }
}
