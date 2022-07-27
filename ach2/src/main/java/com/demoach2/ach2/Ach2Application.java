package com.demoach2.ach2;

import com.datastax.oss.driver.api.core.ConsistencyLevel;
import com.datastax.oss.driver.api.core.CqlSession;
import com.datastax.oss.driver.api.core.config.DriverConfigLoader;
import com.datastax.oss.driver.api.core.cql.ResultSet;
import com.datastax.oss.driver.api.core.cql.Row;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.cassandra.core.InsertOptions;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication(exclude = {DataSourceAutoConfiguration.class })
public class Ach2Application {

	public static void main(String[] args) {
		SpringApplication.run(Ach2Application.class, args);

		/*InsertOptions insertOptions = org.springframework.data.cassandra.core.InsertOptions.builder().
				consistencyLevel(ConsistencyLevel.LOCAL_QUORUM).
				build();*/

		/*DriverConfigLoader loader = DriverConfigLoader.fromClasspath("application.conf");
		try (CqlSession session = CqlSession.builder()
				.withConfigLoader(loader)
				.build()) {

			ResultSet rs = session.execute("select * from demoach.tabledemoach");
			Row row = rs.one();
			System.out.println(row.getString("phone"));
			System.out.println(row.getInt("id"));
		}*/
	}

}
