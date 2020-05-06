package ikvych.resume.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.support.PropertySourcesPlaceholderConfigurer;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;

import java.io.IOException;

@Configuration
@ComponentScan({
        "ikvych.resume.controller",
        "ikvych.resume.component",
        "ikvych.resume.service.impl"
})
public class ServiceConfig {

    @Bean
    public static PropertySourcesPlaceholderConfigurer placeholderConfigurer() throws IOException {
        PropertySourcesPlaceholderConfigurer configurer = new PropertySourcesPlaceholderConfigurer();
        configurer.setLocations(getResources());
        return configurer;
    }

    public static Resource getResources() throws IOException {
        return new ClassPathResource("application.properties");
    }
}
