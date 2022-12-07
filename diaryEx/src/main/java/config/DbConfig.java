package config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import com.zaxxer.hikari.HikariDataSource;

@Configuration
@EnableTransactionManagement
public class DbConfig {

	/*
	 * @Bean(destroyMethod = "close") public DataSource dataSource() { DataSource ds
	 * = new DataSource(); ds.setDriverClassName("com.mysql.jdbc.Driver");
	 * ds.setUrl("jdbc:mysql://localhost/spring5fs?characterEncoding=utf8");
	 * ds.setUsername("spring5"); ds.setPassword("spring5"); ds.setInitialSize(2);
	 * ds.setMaxActive(10); ds.setTestWhileIdle(true);
	 * ds.setMinEvictableIdleTimeMillis(60000 * 3);
	 * ds.setTimeBetweenEvictionRunsMillis(10 * 1000); return ds; }
	 */

	@Bean(destroyMethod = "close")
	public HikariDataSource dataSource() {
		HikariDataSource ds = new HikariDataSource();
		ds.setDriverClassName("com.mysql.cj.jdbc.Driver");
		ds.setJdbcUrl("jdbc:mysql://localhost/world?characterEncoding=utf8");
		ds.setUsername("root");
		ds.setPassword("admin");
		ds.addDataSourceProperty("cachePrepStmts", "true");
		ds.addDataSourceProperty("prepStmtCacheSize", "250");
		ds.addDataSourceProperty("prepStmtCacheSqlLimit", "2048");

		return ds;
	}

	@Bean
	public PlatformTransactionManager transactionManager() {
		DataSourceTransactionManager tm = new DataSourceTransactionManager();
		tm.setDataSource(dataSource());
		return tm;
	}
}
