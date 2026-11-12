package com.ridelink.driver_vehicle_service.config;

import jakarta.annotation.PostConstruct;
import java.util.LinkedHashSet;
import java.util.Set;
import org.springdoc.core.properties.AbstractSwaggerUiConfigProperties.SwaggerUrl;
import org.springdoc.core.properties.SwaggerUiConfigProperties;
import org.springframework.context.annotation.Configuration;

@Configuration
public class OpenApiUiConfig {

    private final SwaggerUiConfigProperties swaggerUiConfigProperties;

    public OpenApiUiConfig(SwaggerUiConfigProperties swaggerUiConfigProperties) {
        this.swaggerUiConfigProperties = swaggerUiConfigProperties;
    }

    @PostConstruct
    public void init() {
        Set<SwaggerUrl> urls = new LinkedHashSet<>();

        SwaggerUrl ride = new SwaggerUrl();
        ride.setName("Ride Service");
        ride.setUrl("http://localhost:8082/v3/api-docs");

        SwaggerUrl driver = new SwaggerUrl();
        driver.setName("Driver Vehicle Service");
        driver.setUrl("http://localhost:8080/v3/api-docs");

        SwaggerUrl account = new SwaggerUrl();
        account.setName("Account Service");
        account.setUrl("http://localhost:8081/v3/api-docs");

        SwaggerUrl fare = new SwaggerUrl();
        fare.setName("Fare Payment Service");
        fare.setUrl("http://localhost:8083/v3/api-docs");

        urls.add(ride);
        urls.add(driver);
        urls.add(account);
        urls.add(fare);

        swaggerUiConfigProperties.setUrls(urls);
        swaggerUiConfigProperties.setUrlsPrimaryName("Ride Service");
    }
}
