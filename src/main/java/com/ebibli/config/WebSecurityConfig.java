package com.ebibli.config;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.web.authentication.SimpleUrlAuthenticationFailureHandler;

@Configuration
@EnableWebSecurity
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {

    private static final Logger LOGGER = LoggerFactory.getLogger(WebSecurityConfig.class);


    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
    }

    /**
     * configure : configuration des droits sur les pages
     * @param http
     * @throws Exception
     */
    @Override
    protected void configure(HttpSecurity http) throws Exception {
        LOGGER.info("configure");

        http.csrf()
                .disable()
                .exceptionHandling()
                .and()
//                .authenticationProvider(getProvider())
                .formLogin()
                .loginProcessingUrl("/login")
//                .successHandler(new AuthentificationLoginSuccessHandler())
                .failureHandler(new SimpleUrlAuthenticationFailureHandler())
                .and()
                .logout()
                .logoutUrl("/logout")
                .logoutSuccessUrl("/")
//                .logoutSuccessHandler(new AuthentificationLogoutSuccessHandler())
                .invalidateHttpSession(true)
                .and()
                .authorizeRequests()
                .antMatchers("/", "/**.jpg", "/**.png", "/**.css").permitAll()
/*                .antMatchers("/login").permitAll()
                .antMatchers("/logout").permitAll()
                .antMatchers("/creationCompte").permitAll()
                .antMatchers("/user").authenticated()
                .antMatchers("/compte").authenticated()
                .antMatchers("/modifSite/**").authenticated()
                .antMatchers("/topo/**").authenticated()
                .antMatchers("/mesTopos/**").authenticated()
                .antMatchers("/*").permitAll()
                .anyRequest().authenticated()*/
                .and()
                .formLogin()
                .loginPage("/login")
                .successForwardUrl("/login")
                .failureForwardUrl("/login")
                .permitAll()
                .and()
                .logout()
                .invalidateHttpSession(true)
                .deleteCookies("JSESSIONID")
                .permitAll()
                .and().rememberMe();
    }
}
