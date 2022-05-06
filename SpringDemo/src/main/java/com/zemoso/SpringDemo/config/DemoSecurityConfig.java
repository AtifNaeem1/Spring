package com.zemoso.SpringDemo.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.User;

import javax.sql.DataSource;

@Configuration
@EnableWebSecurity
public class DemoSecurityConfig extends WebSecurityConfigurerAdapter {


    @Autowired
    DataSource dataSource;

    @Autowired
    public void configAuthentication(AuthenticationManagerBuilder auth) throws Exception {
        auth.jdbcAuthentication().dataSource(dataSource);
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception{
        http.authorizeRequests()
                .antMatchers("/").access("hasAnyRole('ROLE_STUDENT', 'ROLE_INCHARGE', 'INSTRUCTOR')")
                .antMatchers("/student/**").access("hasRole('ROLE_STUDENT') or hasRole('ROLE_INCHARGE')")
                .antMatchers("/course/**").access("hasRole('INSTRUCTOR') or hasRole('ROLE_INCHARGE')")
                .and()
                .formLogin()
                .loginProcessingUrl("/authenticateTheUser")
                .permitAll().and()
                .logout()
                .permitAll()
                .and()
                .exceptionHandling().accessDeniedPage("/access-denied");
    }
}
