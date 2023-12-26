package io.acorn.auth;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import io.acorn.model.Users;
import io.acorn.repository.UsersRepository;

/**
 * UserDetails를 서비스 해주는 객체
 */
@Service
public class PrincipalDeatailsService implements UserDetailsService {
	@Autowired
	private UsersRepository userRepository;
	
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		Users userEntity = userRepository.findByUsername(username);
		System.out.println("userEntity : " + userEntity);
		if(userEntity != null) {
			return new PrincipalDetails(userEntity);
		}
		return null;
	}
}
