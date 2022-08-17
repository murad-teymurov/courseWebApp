package com.company.SimpleWebApp.config;

import org.springframework.context.annotation.Bean;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.WebSecurityConfigurer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

@EnableWebSecurity
public class SpringSecurityConfig extends WebSecurityConfigurerAdapter {

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.inMemoryAuthentication()
                .withUser("murad")
                .password("1111")
                .roles("ADMIN")
                .and()
                .withUser("elman")
                .password("2222")
                .roles("USER");
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.authorizeRequests()
                .antMatchers("/student")
                .permitAll()
//                .antMatchers("/student/delete")
                .antMatchers("/student/new","/student/update","/student/delete")
                .hasRole("ADMIN")
//                .antMatchers("/student/update")
//                .hasRole("ADMIN")
//                .antMatchers("/student/delete")
//                .hasRole("ADMIN")
                .antMatchers("/student/list")
                .hasAnyRole("USER","ADMIN")
                .anyRequest()
                .authenticated()
                .and()
                .formLogin();
    }

    @Bean
    public PasswordEncoder getPasswordEncoder(){
        return NoOpPasswordEncoder.getInstance();
    }
}
