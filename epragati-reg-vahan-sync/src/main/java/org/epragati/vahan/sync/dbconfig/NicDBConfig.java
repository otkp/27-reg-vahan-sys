package org.epragati.vahan.sync.dbconfig;

import javax.persistence.EntityManagerFactory;
import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.autoconfigure.jdbc.DataSourceBuilder;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.orm.jpa.EntityManagerFactoryBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@Configuration
@EnableTransactionManagement
@EnableJpaRepositories(entityManagerFactoryRef = "nicEntityManagerFactory", basePackages = {
"org.epragati.vahan.sync.nic.dao" } ,transactionManagerRef = "nicTransactionManager")
public class NicDBConfig {

	@Bean(name = "nicDataSource")
	@ConfigurationProperties(prefix = "spring.nic.datasource")
	public DataSource dataSource() {
		return DataSourceBuilder.create().build();
	}

	@Bean(name = "nicEntityManagerFactory")
	public LocalContainerEntityManagerFactoryBean entityManagerFactory(EntityManagerFactoryBuilder builder,
			@Qualifier("nicDataSource") DataSource dataSource) {
		return builder.dataSource(dataSource)
				.packages(
						"org.epragati.vahan.sync.nic.dto")
				.persistenceUnit("nic").build();
	}

	@Bean(name = "nicTransactionManager")
	public PlatformTransactionManager transactionManager(
			@Qualifier("nicEntityManagerFactory") EntityManagerFactory entityManagerFactory) {
		return new JpaTransactionManager(entityManagerFactory);
	}

}
