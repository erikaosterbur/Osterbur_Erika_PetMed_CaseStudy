package com.teksystems.Osterbur_Erika_PetMed_CaseStudy.config;

import com.teksystems.Osterbur_Erika_PetMed_CaseStudy.security.UserDetailsServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

@Configuration
@EnableWebSecurity
@EnableGlobalMethodSecurity(prePostEnabled = true)
public class SecurityConfig extends WebSecurityConfigurerAdapter {

    @Autowired
    private UserDetailsServiceImpl userDetailsService;

    @Override
    protected void configure(final HttpSecurity http) throws Exception {
        http
            .csrf().disable()
            .authorizeRequests()
            //allows a user to access each of these folders
            .antMatchers("/pub/**", "/error/**", "/login/**", "/index", "register/**").permitAll()
            //every controller should have its own URL -- like /user/ or /appointment/  //URLs are a protected resource for anyone
            .antMatchers("/admin/**", "/user/**", "/pet/**", "/vetvisit/**").authenticated()
            .and()
            .formLogin()
            .loginPage("/login/login") //this is a URL
            .loginProcessingUrl("/login/loginSubmit")
            .defaultSuccessUrl("/index")
            .and()
            .logout()
            .invalidateHttpSession(true)
            .logoutUrl("/login/logout") //Spring Boot listens for this method
            .logoutSuccessUrl("/index") //URL you go to when you logout
            .and()
            .exceptionHandling()
            .accessDeniedPage("/error/404");
    }

    @Bean
    public DaoAuthenticationProvider getAuthenticationProvider() {
        DaoAuthenticationProvider authProvider = new DaoAuthenticationProvider();
        authProvider.setUserDetailsService(userDetailsService);
        authProvider.setPasswordEncoder(getPasswordEncoder());
        return authProvider;
    }
    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.userDetailsService(userDetailsService);
        auth.authenticationProvider(getAuthenticationProvider());
    }
    @Bean(name="passwordEncoder")
    public PasswordEncoder getPasswordEncoder() {
        return new BCryptPasswordEncoder();
    }
}
