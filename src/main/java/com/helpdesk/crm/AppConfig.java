package com.helpdesk.crm;

import lombok.extern.slf4j.Slf4j;
import org.flywaydb.core.Flyway;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.sql.DataSource;

@Configuration
@Slf4j
public class AppConfig {

    @Value("${spring.jpa.properties.hibernate.default_schema}")
    String crmSchema;

    @Bean(name = "flyway", initMethod = "migrate")
    public Flyway flywayNotADestroyer(DataSource dataSource) {
        return Flyway.configure()
                .dataSource(dataSource)
                .baselineOnMigrate(true)
                .baselineVersion("10000")
                .schemas(crmSchema)
                .outOfOrder(true)
                .load();
    }
}
