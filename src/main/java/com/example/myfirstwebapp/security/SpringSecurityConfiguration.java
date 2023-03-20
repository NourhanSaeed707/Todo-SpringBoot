package com.example.myfirstwebapp.security;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

import java.util.function.Function;

@Configuration
public class SpringSecurityConfiguration {
    //inMemory
//    InMemoryUserDetailsManager
//    InMemoryUserDetailsManager(UserDetails... users)

    @Bean
    public  InMemoryUserDetailsManager createUserDetailsManager() {
        UserDetails userDetails1 = CreateNewUser("nour", "1234");
        UserDetails userDetails2 = CreateNewUser("nourhan", "12345");
        return new InMemoryUserDetailsManager(userDetails1, userDetails2 );

    }

    private UserDetails CreateNewUser(String username, String password) {

        Function<String, String> passwordEncoder = input -> passwordEncoder().encode(input);
        UserDetails userDetails = User.builder()
                .passwordEncoder(passwordEncoder)
                .username(username)
                .password(password)
                .roles("USER", "ADMIN")
                .build();
        return userDetails;
    }

    @Bean
    public PasswordEncoder passwordEncoder () {
        return new BCryptPasswordEncoder();
    }


    // All URLs are protected
    // A login form is shown to unauthorized requests.
    // CSRF disable
    // frames

    @Bean
    public SecurityFilterChain filterChain(HttpSecurity httpSecurity) throws Exception {
        httpSecurity.authorizeHttpRequests(
                auth -> auth.anyRequest().authenticated()
        );
        httpSecurity.formLogin(Customizer.withDefaults());
        httpSecurity.csrf().disable();
        httpSecurity.headers().frameOptions().disable();
        return httpSecurity.build();
    }

}
