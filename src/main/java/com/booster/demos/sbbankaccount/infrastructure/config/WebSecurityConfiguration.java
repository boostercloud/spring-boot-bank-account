package com.booster.demos.sbbankaccount.infrastructure.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.annotation.Order;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.oauth2.jose.jws.MacAlgorithm;
import org.springframework.security.oauth2.jwt.NimbusJwtDecoder;

import javax.crypto.spec.SecretKeySpec;

@Configuration
@Order(0)
@EnableGlobalMethodSecurity(prePostEnabled = true)
public class WebSecurityConfiguration extends WebSecurityConfigurerAdapter {
    public static final String ALGORITHM = "HS512";
    @Value("${jwt.secret}")
    private String secret;

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.oauth2ResourceServer().jwt();
    }

    @Bean
    NimbusJwtDecoder decoder() {
        return NimbusJwtDecoder.withSecretKey(new SecretKeySpec(secret.getBytes(), ALGORITHM)).macAlgorithm(MacAlgorithm.HS512).build();
    }
}
