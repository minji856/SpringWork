package io.acorn.auth;

import java.util.ArrayList;
import java.util.Collection;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import io.acorn.model.Users;
import lombok.Data;

/**
 * 내가 직접 만든 로그인 정보를 전다받는 Auth 타입 
 */
@Data
public class PrincipalDetails implements UserDetails{
	private Users user;
	
	// 데이터를 생성자 user를 통해 받을거다
	public PrincipalDetails(Users user) {
		this.user = user;
	}
	
	// 해당 사용자의 권한을 리턴
	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
		Collection<GrantedAuthority> collect = new ArrayList<>();
		collect.add(new GrantedAuthority(){
			@Override
			public String getAuthority() {
				return user.getRole();
			}
		});
		
		return collect;
	}

	@Override
	public String getPassword() {
		return user.getPassword();
	}

	@Override
	public String getUsername() {
		return user.getUsername();
	}
	
	// 비밀번호 사용 기간
	@Override
	public boolean isAccountNonExpired() {
		return false;
	}

	@Override
	public boolean isAccountNonLocked() {
		return false;
	}

	@Override
	public boolean isCredentialsNonExpired() {
		return false;
	}

	@Override
	public boolean isEnabled() {
		return false;
	}
}
