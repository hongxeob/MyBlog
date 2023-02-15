package com.project.myblog.config;

import com.project.myblog.config.auth.PrincipalDetailService;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

@Configuration //빈으로 등록
@EnableWebSecurity // 시큐리티 필터 추가 = Spring security 활성화. 설정을 해당 파일에서 한다
@EnableGlobalMethodSecurity(prePostEnabled = true)//스프링 시큐리티 활성화 / 해당 메서드 실행 전 체크!
@RequiredArgsConstructor
public class SecurityConfig {
    private final PrincipalDetailService principalDetailService;

    @Bean
    public AuthenticationManager authenticationManager(
            AuthenticationConfiguration authenticationConfiguration
    ) throws Exception {
        return authenticationConfiguration.getAuthenticationManager();
    }


    @Bean
    //비밀번호 해쉬화
    public BCryptPasswordEncoder encoderPW() {
        return new BCryptPasswordEncoder();
    }

    protected void configure(AuthenticationManagerBuilder builder) throws Exception {
        builder.userDetailsService(principalDetailService).passwordEncoder(encoderPW());
    }


    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
        http.csrf().disable() // CSRF 보안에 대한 설정. 아무 설정도 하지 않으면 CSRF 보안을 하도록 설정
                .authorizeHttpRequests() //요청에 대한 권한 지정. Security 처리에 HttpServletRequest를 이용한다는 것을 의미한다.
                .antMatchers("/", "/auth/**", "/js/**", "/css/**", "/image/**").permitAll()//특정 경로를 지정->어떤 사용자든 접근 가능
                .anyRequest() //설정한 경로 외에 모든 경로를 말함
                .authenticated() // 인증된 사용자만이 접근 가능
                .and().formLogin() // form 기반의 로그인을 사용
                .loginPage("/auth/loginForm") // 로그인 페이지 url 설정
                .loginProcessingUrl("/auth/loginProc") // 로그인 Form Action Url을 지정할 수 있다. 사용자 이름과 암호를 제출할 URL (기본값은 /login 이다.)
                .defaultSuccessUrl("/"); //로그인에 성공했을 때에 아무런 설정을 하지 않았을 시 넘어가는 페이지를 설정
        return http.build();
    }
}
