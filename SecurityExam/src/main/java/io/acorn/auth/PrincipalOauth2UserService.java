package io.acorn.auth;

import org.springframework.security.oauth2.client.userinfo.DefaultOAuth2UserService;
import org.springframework.security.oauth2.client.userinfo.OAuth2UserRequest;
import org.springframework.security.oauth2.core.OAuth2AuthenticationException;
import org.springframework.security.oauth2.core.user.OAuth2User;
import org.springframework.stereotype.Service;

/**
 * 다른 서버를 통해서 전달받은 데이터를 사후처리하기 위한 class
 * @return 구글 사용자 정보
 */
@Service
public class PrincipalOauth2UserService extends DefaultOAuth2UserService{
	@Override
	public OAuth2User loadUser(OAuth2UserRequest userRequest) throws OAuth2AuthenticationException {
		System.out.println("userRequest : " + userRequest.getClientRegistration());
		System.out.println("getAccesToken : " + userRequest.getAccessToken());
		System.out.println("getAttributes : " + super.loadUser(userRequest).getAttributes());
		return super.loadUser(userRequest);
	}
}
