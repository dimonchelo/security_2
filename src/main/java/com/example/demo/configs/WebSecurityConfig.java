package com.example.demo.configs;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;

import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
public class WebSecurityConfig  {
//    private final SuccessUserHandler successUserHandler;
//    private final AuthProviderImpl authProvider;

//    public WebSecurityConfig(AuthProviderImpl authProvider) {
//        this.successUserHandler = successUserHandler;
//        this.authProvider = authProvider;
//    }
//    @Bean
//    protected void config (AuthenticationManagerBuilder auth) {
//        auth.authenticationProvider(authProvider);
//    }


        @Bean
        public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
            http

                    .authorizeRequests()
                    .requestMatchers("/", "/index").permitAll() // доступность всем
                    .requestMatchers("/authenticated/**").authenticated()
                    .requestMatchers("/user/**").access("hasAnyRole('ROLE_USER', 'ROLE_ADMIN')") // разрешаем входить на /user пользователям с ролью User
                    .("/admin/**").access("hasAnyRole('ROLE_ADMIN')")
                    .and()
                    .formLogin()
                    .loginPage("/login")// Spring сам подставит свою логин форму
                    .successHandler(successUserHandler) // подключаем наш SuccessHandler для перенаправления по ролям
                    .and()
                    .logout()
                    .logoutSuccessUrl("/");
            return http.build();
        }


    // аутентификация inMemory
    @Bean

    public UserDetailsService userDetailsService() {
        UserDetails user =
                User.withDefaultPasswordEncoder()
                        .username("user")
                        .password("user")
                        .roles("USER")
                        .build();

        return new InMemoryUserDetailsManager(user);
    }
}