package br.com.danilodorgam.desafio.config.spring;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

/**
 * @author Danilo Dorgam
 * @version 0.1.0
 * @email danilodorgam@gmail.com
 */
@Configuration
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {


    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.inMemoryAuthentication()
                .withUser("admin").password(passEncoder().encode("123456")).roles("LOGIN","VISUALIZAR","LISTAR","EDITAR","SALVAR","DELETAR")
                .and()
                .withUser("comum").password(passEncoder().encode("123456")).roles("LOGIN","VISUALIZAR","LISTAR");
    }



    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http
                .csrf().disable()
                .anonymous().disable()
                .authorizeRequests()
                .antMatchers(HttpMethod.GET,"user").hasRole("LOGIN")
                .antMatchers(HttpMethod.GET,"/**/detalhar/**").hasRole("VISUALIZAR")
                .antMatchers(HttpMethod.GET,"/**").hasRole("VISUALIZAR")
                .antMatchers(HttpMethod.POST,"/**").hasRole("SALVAR")
                .antMatchers(HttpMethod.PUT,"/**/**").hasRole("EDITAR")
                .antMatchers(HttpMethod.DELETE,"/**/**").hasRole("DELETAR")
                .anyRequest()
                .authenticated().and().httpBasic();
    }

    @Bean
    public PasswordEncoder passEncoder() {
        return new BCryptPasswordEncoder();
    }
}
