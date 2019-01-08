package knowledge.accumulation.springcloud.config;

import com.zaxxer.hikari.HikariConfig;
import com.zaxxer.hikari.HikariDataSource;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.core.env.Environment;
import javax.sql.DataSource;

@Configuration
public class MyBatisDataSourceConfig {

	private static Logger logger = LoggerFactory.getLogger(MyBatisDataSourceConfig.class);

	@Value("${spring.datasource.dbType}")
	private String dbType;

	@Autowired
	private Environment env;

	@Bean(name = "dataSource")
	@Primary
	public DataSource dataSource() {
		logger.debug("Configruing DataSource");
		String basepath = "spring.datasource.";
		dbType = basepath + dbType;
		HikariConfig datasource = new HikariConfig();
		datasource.setDriverClassName(env.getProperty(dbType + ".driverClassName"));
		datasource.setJdbcUrl(env.getProperty(dbType + ".url"));
		datasource.setUsername(env.getProperty(dbType + ".username"));
		datasource.setPassword(env.getProperty(dbType + ".password"));
		datasource.setConnectionTestQuery(env.getProperty(basepath + ".validationQuery"));
		datasource.setMaxLifetime(env.getProperty(basepath + "maxLifetime",Long.class));
		datasource.setMaximumPoolSize(env.getProperty(basepath + "maximumPoolSize",Integer.class));
//		datasource.setConnectionTimeout(env.getProperty(basepath + "maximumPoolSize",Long.class));
		datasource.setIdleTimeout(env.getProperty(basepath + "idleTimeout",Long.class));
		datasource.addDataSourceProperty("cachePrepStmts", "true"); //是否自定义配置，为true时下面两个参数才生效
		datasource.addDataSourceProperty("prepStmtCacheSize", "250"); //连接池大小默认25，官方推荐250-500
		datasource.addDataSourceProperty("prepStmtCacheSqlLimit", "2048"); //单条语句最大长度默认256，官方推荐2048
		datasource.addDataSourceProperty("useServerPrepStmts", "true"); //新版本MySQL支持服务器端准备，开启能够得到显著性能提升
		datasource.addDataSourceProperty("useLocalSessionState", "true");
		datasource.addDataSourceProperty("useLocalTransactionState", "true");
		datasource.addDataSourceProperty("rewriteBatchedStatements", "true");
		datasource.addDataSourceProperty("cacheResultSetMetadata", "true");
		datasource.addDataSourceProperty("cacheServerConfiguration", "true");
		datasource.addDataSourceProperty("elideSetAutoCommits", "true");
		datasource.addDataSourceProperty("maintainTimeStats", "false");
		datasource.setAutoCommit(false);
		return new HikariDataSource(datasource);
	}

	@Bean(name = "logDataSource")
	public DataSource logDataSource() {
		logger.debug("Configruing DataSource");
		String basepath = "spring.datasource.";
		String dbType = basepath + "log";
		HikariConfig datasource = new HikariConfig();
		datasource.setDriverClassName(env.getProperty(dbType + ".driverClassName"));
		datasource.setJdbcUrl(env.getProperty(dbType + ".url"));
		datasource.setUsername(env.getProperty(dbType + ".username"));
		datasource.setPassword(env.getProperty(dbType + ".password"));
		datasource.setConnectionTestQuery(env.getProperty(basepath + ".validationQuery"));
		datasource.setMaxLifetime(env.getProperty(basepath + "maxLifetime",Long.class));
		datasource.setMaximumPoolSize(env.getProperty(basepath + "maximumPoolSize",Integer.class));
//		datasource.setConnectionTimeout(env.getProperty(basepath + "maximumPoolSize",Long.class));
		datasource.setIdleTimeout(env.getProperty(basepath + "idleTimeout",Long.class));
		datasource.addDataSourceProperty("cachePrepStmts", "true"); //是否自定义配置，为true时下面两个参数才生效
		datasource.addDataSourceProperty("prepStmtCacheSize", "250"); //连接池大小默认25，官方推荐250-500
		datasource.addDataSourceProperty("prepStmtCacheSqlLimit", "2048"); //单条语句最大长度默认256，官方推荐2048
		datasource.addDataSourceProperty("useServerPrepStmts", "true"); //新版本MySQL支持服务器端准备，开启能够得到显著性能提升
		datasource.addDataSourceProperty("useLocalSessionState", "true");
		datasource.addDataSourceProperty("useLocalTransactionState", "true");
		datasource.addDataSourceProperty("rewriteBatchedStatements", "true");
		datasource.addDataSourceProperty("cacheResultSetMetadata", "true");
		datasource.addDataSourceProperty("cacheServerConfiguration", "true");
		datasource.addDataSourceProperty("elideSetAutoCommits", "true");
		datasource.addDataSourceProperty("maintainTimeStats", "false");
		datasource.setAutoCommit(true);
		return new HikariDataSource(datasource);
	}

	public String getDbType() {
		return dbType;
	}

	public void setDbType(String dbType) {
		this.dbType = dbType;
	}
}
