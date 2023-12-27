package io.acorn.auth;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.oauth2.client.userinfo.DefaultOAuth2UserService;
import org.springframework.security.oauth2.client.userinfo.OAuth2UserRequest;
import org.springframework.security.oauth2.core.OAuth2AuthenticationException;
import org.springframework.security.oauth2.core.user.OAuth2User;
import org.springframework.stereotype.Service;

import io.acorn.model.Users;
import io.acorn.repository.UsersRepository;

/**
 * 다른 서버를 통해서 전달받은 데이터를 사후처리하기 위한 class
 * 로그인이 끝난 뒤의 뒷처리 (Security Config에서 호출하고있음)
 * @return 구글 사용자 정보
 */
@Service
public class PrincipalOauth2UserService extends DefaultOAuth2UserService{
	@Autowired
	private UsersRepository userRepository;
	
	@Override
	public OAuth2User loadUser(OAuth2UserRequest userRequest) throws OAuth2AuthenticationException {
		System.out.println("getClientRegistration : " + userRequest.getClientRegistration());
		System.out.println("getAccesToken : " + userRequest.getAccessToken());
		System.out.println("getAttributes : " + super.loadUser(userRequest).getAttributes());
		
		OAuth2User oauth2User = super.loadUser(userRequest);
		// 회원 가입을 강제로 진행
		String provider = userRequest.getClientRegistration().getClientId();
		String providerId = oauth2User.getAttribute("sub");
		String email = oauth2User.getAttribute("email");
		String role = "ROLE_USER";
		String username = provider + "_" + providerId;
		
		// 같은 아이디가 있는지 조회 직접 저장할 게 아니기 떄문에 JPA에 넘겨준다
		Users userEntity = userRepository.findByUsername(username);
		if(userEntity == null) {
			userEntity = Users.builder()
							 .username(username)
							 .email(email)
							 .role(role)
							 .provider(providerId)
							 .providerId(providerId)
							 .build();
			userRepository.save(userEntity);
		}
		return super.loadUser(userRequest); // super 로 하면 에러난다
	}
}
