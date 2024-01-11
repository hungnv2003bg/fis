package edu.platform.application.configs;

import com.fasterxml.jackson.databind.ObjectMapper;
import edu.platform.security.AuthenticationFilter;
import edu.platform.security.TokenAuthenticator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

@Configuration
@EnableWebSecurity
@EnableGlobalMethodSecurity(
        prePostEnabled = true,
        securedEnabled = true,
        jsr250Enabled = true
)
public class AuthenticationSecurityConfig {

    @Autowired
    private TokenAuthenticator tokenAuthenticator;

    @Autowired
    private ObjectMapper objectMapper;

    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {

        http
                .cors()
                .and()
                .csrf()
                .disable()
                .exceptionHandling()
                .and()
                .anonymous()
                .and()
                .servletApi()
                .and()
                .authorizeHttpRequests()
                .antMatchers(HttpMethod.OPTIONS, "/**")
                .permitAll()
                .antMatchers("/actuator/**")
                .permitAll()

                .antMatchers(HttpMethod.POST, "/staffs/auth")
                .permitAll()

                .antMatchers(HttpMethod.POST, "/instructors/register")
                .permitAll()
                .antMatchers(HttpMethod.POST, "/instructors/auth")
                .permitAll()
                .antMatchers(HttpMethod.PUT, "/instructors/*/active")
                .permitAll()

                .antMatchers(HttpMethod.POST, "/learners/register")
                .permitAll()
                .antMatchers(HttpMethod.POST, "/learners/auth")
                .permitAll()
                .antMatchers(HttpMethod.PUT, "/learners/*/active")
                .permitAll()
                .antMatchers(HttpMethod.POST, "/learners/mapping")
                .permitAll()
                .antMatchers(HttpMethod.POST, "/learners/confirm-mapping")
                .permitAll()

                .antMatchers(HttpMethod.GET, "/region/**")
                .permitAll()

                .antMatchers(HttpMethod.GET, "/courses/**")
                .permitAll()

                .and()
                .headers()
                .cacheControl();

        http.authorizeHttpRequests().anyRequest().hasRole("USER");

        http.addFilterBefore(new AuthenticationFilter(tokenAuthenticator, objectMapper), UsernamePasswordAuthenticationFilter.class);

        return http.build();
    }

    @Bean
    public AuthenticationManager authenticationManager(
            AuthenticationConfiguration authConfig) throws Exception {
        return authConfig.getAuthenticationManager();
    }

}
