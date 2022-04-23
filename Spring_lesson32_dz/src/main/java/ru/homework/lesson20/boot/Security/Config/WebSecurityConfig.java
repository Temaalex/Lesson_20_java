package ru.homework.lesson20.boot.Security.Config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

import ru.homework.lesson20.boot.Security.Service.UserDetailsServer;

@Configuration
@EnableGlobalMethodSecurity(
        prePostEnabled = true
)
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {
//    @Autowired
//    private JwtService jwt;

    @Override
    public void configure(HttpSecurity http) throws Exception{
        http
                .csrf().disable()
                .authorizeRequests()

                .antMatchers("/api/v1/avia/bay/title", "/api/v1/avia/sale/title").hasRole("USER")   //купить и вернуть билет

                .antMatchers("/api/v1/avia/add",//добавить концерт
                            "/api/v1/avia/update/id",//обновить концерт
                            "/api/v1/avia/updateTitle/title/id",//изменить наименование концерта
                            "/api/v1/avia/delete/id" ).hasRole("ADMIN")  //удалить концерт

                .anyRequest().authenticated()
                .and()

                .httpBasic();


//                .and()
//                .addFilterBefore(new JwtAuthorization(jwt), UsernamePasswordAuthenticationFilter.class);
    }

    @Bean
    public PasswordEncoder passwordEncoder(){
        return new BCryptPasswordEncoder();
    }
    @Bean
    public UserDetailsService userDetailsService(PasswordEncoder encoder) {
        return new UserDetailsServer(encoder);
    }
}

