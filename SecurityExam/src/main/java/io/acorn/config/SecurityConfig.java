package io.acorn.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

/**
 * Spring Security에 대한 기본 설정을 나한테 맞게 커스텀마이징
 */
@Configuration
@EnableWebSecurity
public class SecurityConfig {
	// 비밀번호를 암호화 해주는
	@Bean
	public BCryptPasswordEncoder encodePwd() {
		return new BCryptPasswordEncoder();
	}
	
	
	@Bean // SecurityFilterChain 은 지정된 속성
	protected SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
		http.csrf().disable(); // 곧 사라지는 코드 csrf()
		
		/**
		 * 어떤 요청이 들어와도 모두에게 허락하겠다
		 * user로 시작하는 모든 요청은 인증을 거치겠다
		 * 별도로 지정할때 access (인증이 되고 난 후 어디에 접근하게 할건지 지정하는 메서드)
		 */
		http.authorizeRequests()
			.requestMatchers("/user/**").authenticated()
			.requestMatchers("/admin/**").access("hasRole('ROLE_ADMIN')")
			.requestMatchers("/manager/**").access("hasRole('ROLE_MANAGER')")
			.anyRequest().permitAll()
			.and()
			.formLogin()
			.loginPage("/loginForm")
			.loginProcessingUrl("/login") // 로그인이 저리최고 난 후에 어디에 요청할 것인지
			.defaultSuccessUrl("/");
		
		
		return http.build();
	}
}
