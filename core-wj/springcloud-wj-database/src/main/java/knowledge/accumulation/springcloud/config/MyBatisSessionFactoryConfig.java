package knowledge.accumulation.springcloud.config;

import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.autoconfigure.AutoConfigureAfter;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.core.env.Environment;
import org.springframework.core.io.DefaultResourceLoader;
import org.springframework.core.io.ResourceLoader;
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.transaction.annotation.TransactionManagementConfigurer;
import javax.sql.DataSource;


@Configuration
@AutoConfigureAfter({MyBatisDataSourceConfig.class})
@EnableTransactionManagement
public class MyBatisSessionFactoryConfig implements TransactionManagementConfigurer {
	private static Logger logger = LoggerFactory.getLogger(MyBatisSessionFactoryConfig.class);


	@Autowired
	@Qualifier(value = "dataSource")
	private DataSource dataSource;

	@Autowired
	@Qualifier(value = "logDataSource")
	private DataSource logDataSource;

    @Value("${spring.datasource.dbType}")
    private String dbType;

	@Autowired
    private Environment env;

	@Bean(name="sqlSessionFactory")
	@Primary
	public SqlSessionFactory sqlSessionFactory() {
		try {
			SqlSessionFactoryBean sqlSessionFactory = new SqlSessionFactoryBean();
			sqlSessionFactory.setDataSource(dataSource);
			ResourceLoader resourceLoader = new DefaultResourceLoader();
			org.springframework.core.io.Resource configLoc = resourceLoader.getResource(dbType + "/" + env.getProperty("mapping.configuration"));
			if(configLoc.isReadable())
				sqlSessionFactory.setConfigLocation(configLoc);
			else
				sqlSessionFactory.setConfigLocation(resourceLoader.getResource(env.getProperty("mapping.config")));
			sqlSessionFactory.setMapperLocations(new PathMatchingResourcePatternResolver().getResources(env.getProperty("mapping.baseXml")));
			return sqlSessionFactory.getObject();
		} catch (Exception e) {
			logger.error("Could not confiure mapper.mapper session factory",e);
			return null;
		}
	}

	@Bean(name="logSqlSessionFactory")
	public SqlSessionFactory logSqlSessionFactory() {
		try {
			SqlSessionFactoryBean sqlSessionFactory = new SqlSessionFactoryBean();
			sqlSessionFactory.setDataSource(logDataSource);
			sqlSessionFactory.setConfigLocation(new DefaultResourceLoader().getResource(env.getProperty("mapping.config")));
			sqlSessionFactory.setMapperLocations(new PathMatchingResourcePatternResolver().getResources(env.getProperty("mapping.logbaseXml")));
			return sqlSessionFactory.getObject();
		} catch (Exception e) {
			logger.error("Could not confiure mapper.mapper session factory",e);
			return null;
		}
	}

	@Bean
	public PlatformTransactionManager annotationDrivenTransactionManager() {
		logger.info("数据库事务开启");
		return new DataSourceTransactionManager(dataSource);
	}

	@Bean
	public PlatformTransactionManager bfscrmTransactionManager(@Qualifier("logDataSource")DataSource sitDataSource) {
		return new DataSourceTransactionManager(sitDataSource);
	}
}
