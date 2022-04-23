package ru.homework.lesson20.boot.Security.Service;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import ru.homework.lesson20.boot.domain.User;

import javax.annotation.PostConstruct;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import static java.util.Arrays.asList;


public class UserDetailsServer implements UserDetailsService {

    private Map<String, User> repository;
    private PasswordEncoder encoder;

    @Autowired
    public UserDetailsServer(PasswordEncoder encoder) {
        this.encoder = encoder;
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        final User user = repository.get(username);
        if (user == null) throw new UsernameNotFoundException("Нет такого пользователя");
        return user;
    }
    @PostConstruct
    public void init(){
        repository = new HashMap<>();
        repository.put("guest",
                new User(
                        "guest",
                        encoder.encode("guest123"),
                        Collections.singletonList(new SimpleGrantedAuthority("ROLE_GUEST"))));


        repository.put("user",
                new User(
                        "user",
                        encoder.encode("user123"),
                        asList(new SimpleGrantedAuthority("ROLE_USER"))));

        repository.put("admin",
                new User(
                        "admin",
                        encoder.encode("admin123"),
                        asList(
                                new SimpleGrantedAuthority("ROLE_ADMIN"),
                                new SimpleGrantedAuthority("GUEST"),
                                new SimpleGrantedAuthority("ROLE_USER"))));
    }
}
