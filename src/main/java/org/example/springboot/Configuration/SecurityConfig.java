package org.example.springboot.Configuration;

import org.springframework.security.authentication.AuthenticationManager;
import org.example.springboot.services.minitest.appUser.IAppUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
public class SecurityConfig {
    @Autowired
    private IAppUserService appUserService;

    @Bean
    public AuthenticationProvider authentication() {
        DaoAuthenticationProvider dao = new DaoAuthenticationProvider();


        dao.setUserDetailsService(appUserService);
        dao.setPasswordEncoder(NoOpPasswordEncoder.getInstance());
        return dao;

    }

    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
        http.formLogin(Customizer.withDefaults()).authorizeHttpRequests(
                authorizeRequests -> authorizeRequests.anyRequest().authenticated()
        );
        return http.build();
    }
}
