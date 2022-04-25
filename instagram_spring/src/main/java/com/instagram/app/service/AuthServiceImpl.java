package com.instagram.app.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.instagram.app.auth.PrincipalService;
import com.instagram.app.domain.user.User;
import com.instagram.app.domain.user.UserRepository;
import com.instagram.app.web.dto.auth.SignupRequestDto;

@Service
public class AuthServiceImpl implements AuthService {
	

	@Autowired
	private PrincipalService principalService;

	@Autowired
	private UserRepository userRepository;
	
	@Override
	public boolean checkUsername(String username) {
		
		return userRepository.checkUsername(username) != 0 ? true : false;
	}

	@Override
	public boolean signup(SignupRequestDto signupRequestDto) {
		int result = userRepository.signup(signupRequestDto.toEntity());
		return result != 0 ? true : false; // result != 0 과 같은것
	}

	@Override
	public User signin(String username, String password) {
		
		User user = principalService.loadUserByUsername(username); // 만약 못들고 오면 user에 null이 들어오니 그대로 null 리턴
		
		if(user != null) {
			
			if(!principalService.passwordCheck(password, user)) { // username 에 값이 들어있으면 그 값을 user에 담아서 user 리턴 ***  if(!  null이 아니다***
				return null;
			}
			
		}
				
		return user;
	}


}
