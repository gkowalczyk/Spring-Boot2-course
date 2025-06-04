package com.example.spring_security_m2_1;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configurers.AbstractAuthenticationFilterConfigurer;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

@EnableWebSecurity
@Configuration
public class Config {


    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

   /* @Bean
    public UserDetailsService userDetailsService(PasswordEncoder passwordEncoder) {
        InMemoryUserDetailsManager inMemoryUserDetailsService = new InMemoryUserDetailsManager();

        inMemoryUserDetailsService.createUser(User.builder()
                .username("Jan")
                .password(passwordEncoder.encode("Jan123"))
                .roles("ADMIN")
                .build());

        inMemoryUserDetailsService.createUser(User.builder()
                .username("Karol")
                .password(passwordEncoder.encode("Karol123"))
                .roles("USER")
                .build());
        return inMemoryUserDetailsService;
    }*/


    /* @Bean
     public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
         http
                 .authorizeHttpRequests(authorize -> authorize
                         .requestMatchers("/admin/**").hasRole("ADMIN")
                         .requestMatchers("/user/**").hasAnyRole("USER", "ADMIN")
                         .anyRequest()
                         .permitAll()
                 )
                 .formLogin(AbstractAuthenticationFilterConfigurer::permitAll
                 )
                 .logout(logout -> logout
                         .logoutSuccessUrl("/forAll")
                         .permitAll()
                 );
         return http.build();*/
    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
        http
                .authorizeHttpRequests(authorize -> authorize
                        .anyRequest().authenticated())
                .oauth2Login(Customizer.withDefaults())
                .logout(logout -> logout
                        .logoutSuccessUrl("/forAll")
                        .permitAll()
                );
        return http.build();
    }
}