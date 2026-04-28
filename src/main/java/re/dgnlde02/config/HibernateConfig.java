package re.dgnlde02.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.orm.jpa.hibernate.LocalSessionFactoryBean;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import javax.sql.DataSource;
import java.util.Properties;

@Configuration
@EnableTransactionManagement
public class HibernateConfig {

    @Bean
    public LocalSessionFactoryBean sessionFactory() {
        LocalSessionFactoryBean sessionFactory = new LocalSessionFactoryBean();

        sessionFactory.setDataSource(dataSource());
        sessionFactory.setPackagesToScan("com.pharmacy.entity");

        Properties props = new Properties();

        props.put("hibernate.dialect", "org.hibernate.dialect.MySQL8Dialect");

        props.put("hibernate.hbm2ddl.auto", "update");

        props.put("hibernate.show_sql", "true");
        props.put("hibernate.format_sql", "true");

        sessionFactory.setHibernateProperties(props);

        return sessionFactory;
    }

    @Bean
    public DataSource dataSource() {
        DriverManagerDataSource ds = new DriverManagerDataSource();

        ds.setDriverClassName("com.mysql.cj.jdbc.Driver");
        ds.setUrl("jdbc:mysql://localhost:3306/pharmacy_db");
        ds.setUsername("root");
        ds.setPassword("khanhkhanh");

        return ds;
    }
}