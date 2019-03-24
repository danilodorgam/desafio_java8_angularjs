package br.com.danilodorgam.desafio.config.spring;

import org.hibernate.jpa.HibernatePersistenceProvider;
import org.springframework.context.annotation.*;
import org.springframework.dao.annotation.PersistenceExceptionTranslationPostProcessor;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.JpaVendorAdapter;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import javax.persistence.EntityManagerFactory;
import javax.sql.DataSource;
import java.util.Properties;
/**
 * @author Danilo Dorgam
 * @version 0.1.0
 * @email danilodorgam@gmail.com
 */
@Configuration
@ComponentScan(basePackages = "br.com.danilodorgam.desafio")
@EnableJpaRepositories(basePackages = "br.com.danilodorgam.desafio.repository")
@EnableTransactionManagement
@Profile("teste")
public class PersistenceConfigTest {
    private String user = "sa";
    private String pw = "";
    private String url = "jdbc:h2:mem:desafio;DB_CLOSE_DELAY=-1;INIT=CREATE SCHEMA IF NOT EXISTS cadastro\\;SET SCHEMA cadastro;";
    private String driver = "org.h2.Driver";
    private String dialect = "org.hibernate.dialect.H2Dialect";
    private String hbm2dll = "create";
    private Integer numeroMaximoDeConexoes = 10;
    @Bean
    public LocalContainerEntityManagerFactoryBean entityManagerFactory() {
        LocalContainerEntityManagerFactoryBean lcemfb = new LocalContainerEntityManagerFactoryBean();
        lcemfb.setPackagesToScan("br.com.danilodorgam");
        lcemfb.setPersistenceProvider(new HibernatePersistenceProvider());
        lcemfb.setPersistenceUnitName("desafio");
        JpaVendorAdapter vendorAdapter = new HibernateJpaVendorAdapter();
        lcemfb.setJpaVendorAdapter(vendorAdapter);
        lcemfb.setJpaProperties(additionalProperties());
        lcemfb.setDataSource(dataSource());
        return lcemfb;
    }
    @Bean
    public DataSource dataSource(){
        System.out.println(url);
        DriverManagerDataSource dataSource = new DriverManagerDataSource();
        dataSource.setDriverClassName(driver);
        dataSource.setUrl(url);
        dataSource.setUsername(user);
        dataSource.setPassword(pw);
        return dataSource;
    }
    @Primary
    @Bean(name = "transactionManager")
    public PlatformTransactionManager transactionManager(
            EntityManagerFactory emf){
        JpaTransactionManager transactionManager = new JpaTransactionManager();
        transactionManager.setEntityManagerFactory(emf);
        return transactionManager;
    }
    @Bean
    public PersistenceExceptionTranslationPostProcessor exceptionTranslation(){
        return new PersistenceExceptionTranslationPostProcessor();
    }
    Properties additionalProperties() {
        Properties properties = new Properties();
        properties.setProperty("hibernate.dialect", dialect);
        properties.setProperty("hibernate.hbm2ddl.auto", hbm2dll);
        properties.setProperty("hibernate.show_sql", "true");
        properties.setProperty("hibernate.temp.use_jdbc_metadata_defaults", "true");
        properties.setProperty("hibernate.default_schema", "cadastro");
        //Configuracoes Envers
        properties.setProperty("org.hibernate.envers.revision_type_field_name", "NR_REVTYPE");
        properties.setProperty("org.hibernate.envers.revision_field_name", "ID_REV");
        return properties;
    }
}