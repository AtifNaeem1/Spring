package com.springsecurity.demo.config;

import com.mchange.v2.c3p0.ComboPooledDataSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Configurable;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.web.servlet.ViewResolver;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.view.InternalResourceViewResolver;

import javax.sql.DataSource;
import java.beans.PropertyVetoException;
import java.util.logging.Logger;

@Configurable
@EnableWebMvc
@ComponentScan(basePackages = "com.springsecurity.demo")
@PropertySource("classpath:persistence-mysql.properties")
public class DemoAppConfig {

    //set up a variable to hold the properties
    @Autowired
    private Environment env;  //will hold the data read from properties files

    //set up a logger for diagnostics
    private Logger logger = Logger.getLogger(getClass().getName());


    //define a bean for viewResolver
    @Bean
    public ViewResolver viewResolver()
    {
        InternalResourceViewResolver viewResolver = new InternalResourceViewResolver();

        viewResolver.setPrefix("/WEB-INF/view/");
        viewResolver.setSuffix(".jsp");

        return viewResolver;
    }

    //define a bean for our security datasource - using pure java code- no xml
    @Bean
    public DataSource securityDataSource()
    {
        //create a connection pool
        ComboPooledDataSource securityDataSource =
                new ComboPooledDataSource();

        //set the jdbc driver class
        try {
            securityDataSource.setDriverClass(env.getProperty("jdbc.driver"));
        } catch (PropertyVetoException e) {
            throw new RuntimeException(e);
        }

        //log the connection props
        //just to make sure we are reading correct data
        logger.info(">>> jdbc.url= " + env.getProperty("jdbc.url"));
        logger.info(">>> jdbc.url= " + env.getProperty("jdbc.user"));

        //set database connection props
        securityDataSource.setJdbcUrl(env.getProperty("jdbc.url"));
        securityDataSource.setUser(env.getProperty("jdbc.user"));
        securityDataSource.setPassword(env.getProperty("jdbc.password"));

        //set connection pool props
        securityDataSource.setInitialPoolSize(getIntProperty("connection.pool.initialPoolSize"));
        securityDataSource.setMinPoolSize(getIntProperty("connection.pool.minPoolSize"));
        securityDataSource.setMaxPoolSize(getIntProperty("connection.pool.maxPoolSize"));
        securityDataSource.setMaxIdleTime(getIntProperty("connection.pool.maxIdleTime"));

        return securityDataSource;
    }

    //need a helper method
    //read environment property and convert it into int
    private int getIntProperty(String propName)
    {
        String propVal = env.getProperty(propName);

        //now convert it into int
        int intPropVal = Integer.parseInt(propVal);

        return intPropVal;
    }

}
