package com.brewery.manager.security;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
    @EnableWebSecurity
    @EnableGlobalMethodSecurity(prePostEnabled = true)
    public class ManagerSercurityCinfig {
    
        
    
    
        @Bean
        public SecurityFilterChain filterChain(HttpSecurity httpSecurity) throws Exception{
            // We don't need CSRF for this example
            httpSecurity.csrf().disable()
                    // don't authenticate this particular request
                    .authorizeHttpRequests().antMatchers("/api/**").permitAll()
                    // all other requests need to be authenticated
                    .anyRequest().authenticated().and()
                    // make sure we use stateless session; session won't be used to
                    // store user's state.
                    //.exceptionHandling().authenticationEntryPoint(jwtAuthenticationEntryPoint).and()
                    .sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS);
    
            // Add a filter to validate the tokens with every request
            //httpSecurity.addFilterBefore(jwtRequestFilter, UsernamePasswordAuthenticationFilter.class);
            return httpSecurity.build();
        }
    
        @Bean
        public AuthenticationManager authenticationManager(AuthenticationConfiguration authenticationConfiguration) throws Exception {
            return authenticationConfiguration.getAuthenticationManager();
        }
    
        @Bean
        public PasswordEncoder passwordEncoder() {
            return new BCryptPasswordEncoder();
        }
    }