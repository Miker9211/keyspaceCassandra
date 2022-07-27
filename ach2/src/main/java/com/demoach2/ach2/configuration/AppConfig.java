package com.demoach2.ach2.configuration;

import com.datastax.oss.driver.api.core.CqlSession;
import com.datastax.oss.driver.api.core.DefaultConsistencyLevel;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.data.cassandra.config.AbstractCassandraConfiguration;
import org.springframework.data.cassandra.core.CassandraAdminTemplate;
import org.springframework.data.cassandra.core.cql.CqlTemplate;
import org.springframework.data.cassandra.repository.config.EnableCassandraRepositories;
import org.springframework.data.ldap.repository.config.EnableLdapRepositories;

@Configuration
@EnableCassandraRepositories(basePackages = "com.demoach2.ach2")
public class AppConfig {

    private final static String KEYSPACE = "demoach";

    @Primary
    public @Bean CqlSession session() {
        return CqlSession.builder().withKeyspace(KEYSPACE).build();
    }

}
