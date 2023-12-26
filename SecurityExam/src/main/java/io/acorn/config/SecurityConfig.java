package io.acorn.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.method.configuration.EnableMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

import io.acorn.auth.PrincipalOauth2UserService;

/**
 * Spring Security에 대한 기본 설정을 나한테 맞게 커스텀마이징
 */
@Configuration
@EnableWebSecurity
@EnableMethodSecurity(securedEnabled = true, prePostEnabled = true)
public class SecurityConfig {
	@Autowired
	private PrincipalOauth2UserService principalOauth2UserService;
	
	// 비밀번호를 암호화 해주는
	@Bean
	public BCryptPasswordEncoder encodePwd() {
		return new BCryptPasswordEncoder();
	}
	
	@Bean // SecurityFilterChain 은 지정된 속성
	protected SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
		// 각 페이지별로 권한 설정
		http.authorizeHttpRequests(requests -> 
			requests.requestMatchers("/user/**").hasRole("USER")
			.requestMatchers("/admin/**").hasRole("ADMIN")
			.requestMatchers("/manager/**").hasAnyRole("MANAGER", "ADMIN")
			.requestMatchers("/", "/joinForm", "/loginForm", "/join", "/login").permitAll()
			.anyRequest().authenticated()
			)
		.formLogin(login -> 
			login
			.loginPage("/loginForm")
			.loginProcessingUrl("/login")
			.defaultSuccessUrl("/"))
		.oauth2Login(login -> login
			.loginPage("/loginForm") // 2가지 방법이 생김
			.userInfoEndpoint(uie -> uie.userService(principalOauth2UserService)))
		.logout(logout ->
		logout
		.logoutSuccessUrl("/loginForm")
		.invalidateHttpSession(true))
		// logout은 생략해도 무관
		.csrf(csrf -> csrf.disable())
		.cors(cors -> cors.disable()); // Test 할때 disable()
			
		return http.build();
		
		//http.csrf().disable(); // 곧 사라지는 코드 csrf()
		/**
		 * 어떤 요청이 들어와도 모두에게 허락하겠다
		 * user로 시작하는 모든 요청은 인증을 거치겠다
		 * 별도로 지정할때 access (인증이 되고 난 후 어디에 접근하게 할건지 지정하는 메서드)
		 */
//		http.authorizeRequests()
//			.requestMatchers("/user/**").authenticated()
//			.requestMatchers("/admin/**").access("hasRole('ROLE_ADMIN')")
//			.requestMatchers("/manager/**").access("hasRole('ROLE_MANAGER')")
//			.anyRequest().permitAll()
//			.and()
//			.formLogin()
//			.loginPage("/loginForm")
//			.loginProcessingUrl("/login") // 로그인이 저리최고 난 후에 어디에 요청할 것인지
//			.defaultSuccessUrl("/");
//		
//		
//		return http.build();
	}
}
