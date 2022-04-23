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
                .authorizeRequests()
                //.antMatchers("/api/v1/avia/id").hasAnyRole("GUEST","USER","ADMIN") //посмотреть один билет

                .antMatchers("/api/v1/avia/bay/title").hasRole("USER")   //купить билет
                .antMatchers("/api/v1/avia/sale/title").hasRole("USER")  //вернуть билет

                .antMatchers("/api/v1/avia/add").hasRole("ADMIN")  //добавить концерт
                .antMatchers("/api/v1/avia/update/id").hasRole("ADMIN")  //обновить концерт
                .antMatchers("/api/v1/avia/updateTitle/title/id").hasRole("ADMIN")  //изменить наименование концерта
                .antMatchers("/api/v1/avia/delete/id").hasRole("ADMIN")  //удалить концерт

                .anyRequest().authenticated()
                .and()
                .formLogin();


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

