package com.gachon.community.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

@Configuration
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http
                .csrf().disable() // CSRF 보호 기능을 비활성화
                .authorizeRequests()
                .antMatchers("/api/**").permitAll() // 인증 헤더 없이 요청 허용할 API 경로
                .anyRequest().authenticated()
                .and()
                .httpBasic(); // 기본 인증 사용 설정
    }
}
