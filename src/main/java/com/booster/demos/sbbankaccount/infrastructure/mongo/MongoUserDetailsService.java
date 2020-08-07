package com.booster.demos.sbbankaccount.infrastructure.mongo;

import org.jetbrains.annotations.NotNull;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;

import static java.util.stream.Collectors.toList;

@Service
public class MongoUserDetailsService implements UserDetailsService {
    private final UsersRepository usersRepository;

    @Autowired
    public MongoUserDetailsService(UsersRepository usersRepository) {
        this.usersRepository = usersRepository;
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        final var user = usersRepository.findByUsername(username);
        if (user == null) {
            throw new UsernameNotFoundException(username);
        }
        return new User(user.username, user.password, authoritiesForUser(user));
    }

    @NotNull
    private List<SimpleGrantedAuthority> authoritiesForUser(com.booster.demos.sbbankaccount.entities.User user) {
        return user.roles.stream().map(SimpleGrantedAuthority::new).collect(toList());
    }
}
