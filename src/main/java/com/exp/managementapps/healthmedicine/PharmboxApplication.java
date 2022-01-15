package com.exp.managementapps.healthmedicine;

// import com.exp.gameapps.config.ApplicationProperties;
import com.exp.managementapps.healthmedicine.core.factory.YamlPropertySourceFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.boot.autoconfigure.jdbc.DataSourceTransactionManagerAutoConfiguration;
import org.springframework.boot.autoconfigure.orm.jpa.HibernateJpaAutoConfiguration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.context.annotation.PropertySources;

@SpringBootApplication
// @EnableConfigurationProperties({ApplicationProperties.class})
@PropertySources({
    @PropertySource(
            value = "classpath:application.yml", name = "application.yml", factory = YamlPropertySourceFactory.class)
})
@EnableAutoConfiguration(exclude = {
    DataSourceAutoConfiguration.class,
    DataSourceTransactionManagerAutoConfiguration.class,
    HibernateJpaAutoConfiguration.class})
public class PharmboxApplication {

    public static void main(String[] args) {
        SpringApplication.run(PharmboxApplication.class, args);
    }
}
