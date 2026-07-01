package kr.co.sboard.security;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.method.configuration.EnableMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configurers.CsrfConfigurer;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

@EnableMethodSecurity
@Configuration
public class SecurityConfig {

    @Bean
    public SecurityFilterChain filterChain(HttpSecurity httpsecurity) throws Exception{
        //로그인 설정
        httpsecurity.formLogin(form -> form
                .loginPage("/user/login")
                .defaultSuccessUrl("/?login=success")
                .failureUrl("/user/login?login=fail")
                .usernameParameter("userid")
                .passwordParameter("pass"));
        //로그아웃 설정
        httpsecurity.logout( config -> config
                .logoutUrl("/user/logout")
                .invalidateHttpSession(true)
                .logoutSuccessUrl("/user/login?logout=success"));
        //인가 설정
        httpsecurity.authorizeHttpRequests(authorize -> authorize
                .requestMatchers("/").permitAll()
                .requestMatchers("/article/**").hasAnyRole("ADMIN", "MANAGER", "MEMBER")
                .requestMatchers("/manager/**").hasAnyRole("ADMIN","MANAGER")
                .requestMatchers("/member/**").hasAnyRole("ADMIN","MANAGER","MEMBER")
                .anyRequest().permitAll()
        );

        //기타 보안 설정
        httpsecurity.csrf(CsrfConfigurer::disable);


        return httpsecurity.build();
    }

    @Bean
    public PasswordEncoder passwordEncoder(){
    return new BCryptPasswordEncoder();
    }


}
