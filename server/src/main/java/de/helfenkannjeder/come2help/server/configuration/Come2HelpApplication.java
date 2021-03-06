package de.helfenkannjeder.come2help.server.configuration;

import com.fasterxml.jackson.databind.ObjectMapper;
import de.helfenkannjeder.come2help.server.rest.logging.RestLogFilter;
import org.jsondoc.spring.boot.starter.EnableJSONDoc;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.embedded.FilterRegistrationBean;
import org.springframework.boot.orm.jpa.EntityScan;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;

@EntityScan(basePackages = "de.helfenkannjeder.come2help.server.domain")
@ComponentScan(basePackages = "de.helfenkannjeder.come2help.server")
@EnableJpaRepositories("de.helfenkannjeder.come2help.server.domain.repository")
@SpringBootApplication
@EnableJSONDoc
@EnableGlobalMethodSecurity(jsr250Enabled = true)
public class Come2HelpApplication {

    public static void main(String[] args) {
        SpringApplication.run(Come2HelpApplication.class, args);
    }

    @Bean
    public ObjectMapper jacksonObjectMapper() {

        return ObjectMapperFactory.objectMapperForRestEndpoint();
    }

    @Bean
    public FilterRegistrationBean filterRegistrationBean() {
        FilterRegistrationBean filterRegistrationBean = new FilterRegistrationBean();
        filterRegistrationBean.setFilter(new RestLogFilter());
        filterRegistrationBean.setOrder(1);
        return filterRegistrationBean;
    }
}
