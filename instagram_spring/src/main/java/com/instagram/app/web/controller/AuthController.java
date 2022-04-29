package com.instagram.app.web.controller;

import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.instagram.app.service.AuthService;
import com.instagram.app.web.dto.auth.SignupRequestDto;
import com.instagram.app.web.util.auth.AuthResponseScript;
import com.instagram.app.web.validation.auth.AuthValidation;

@Controller
public class AuthController {
	
	@Autowired
	private AuthService authService;
	
	@RequestMapping(value = "/auth/signin", method = RequestMethod.GET) // AuthResponseScript.java에서 회원가입 완료시 겟 요청을 날린다
	public String getSignin() {
		return "auth/signin";
	}

	
	@RequestMapping(value = "/auth/signin", method = RequestMethod.POST) 
	public String signinSubmit(String username, String password) throws UnsupportedEncodingException  {
		AuthValidation authValidation = new AuthValidation();
		
		Map<Boolean, String> usernameIsNull = authValidation.isNull("username", username);
		Map<Boolean, String> passwordIsNull = authValidation.isNull("password", password);
		
		if(usernameIsNull != null) {
			return "redirect: /app/auth/signin/error?msg=" + URLEncoder.encode(usernameIsNull.get(true), "UTF-8");
		}
		if(passwordIsNull != null) {
			return "redirect: /app/auth/signin/error?msg=" + URLEncoder.encode(passwordIsNull.get(true), "UTF-8");
		}
		
		
		
		return "index";
	}
	
	
	
	
	
	
	@RequestMapping(value = "/auth/signup", method = RequestMethod.GET)
	public String getSignup() {// dto를 만들어서 매개변수들을 get했다 4
		//dto를 이용하면 http://localhost:8000/app/auth/signup 만 쳐도 페이지가 열린다

//		System.out.println("phoneOrEmail : " + signupRequestDto.getPhoneOrEmail());
//		System.out.println("name : " + signupRequestDto.getName());
//		System.out.println("username : " + signupRequestDto.getUsername());
//		System.out.println("password : " + signupRequestDto.getPassword());

		
	//@RequestParam => HttpServletRequest객체에서 request.getParameter() 를 하는것과 동일하다 0
		
	//public String getSignup(@RequestParam("username")String str) {//username에서 건내온 걸 str에 넣는다 1
		//http://localhost:8000/app/auth/signup?username=aaaa
	
	//  ==  public String getSignup(@RequestParam String username) { 변수명이 같으면 생략 가능 2

	//  ==  public String getSignup(String username) { 파라메타 생략가능 3

	
	//만약 파람 매개변수가 엄청 많아지면 쓰기 불편해지기 때문에 dto패키지에 dto 자바파일을 만들어서 처리한다	
		
		
		return "auth/signup";
	}
	
	@ResponseBody
	@RequestMapping(value = "/auth/signup", method = RequestMethod.POST, produces = "text/html; charset=utf-8")
	public String signupSubmit(SignupRequestDto signupRequestDto) {
		boolean result = authService.signup(signupRequestDto);
		//회원가입 완료 되었습니다, 라는 메시지를 알람창으로 뜨게 스크립트를 만들어서 실행해야 한다
		AuthResponseScript script = new AuthResponseScript();
		
		return script.signupScript(result);
	}
	
	
	@ResponseBody
	@RequestMapping(value = "/auth/username/check", method = RequestMethod.GET)//js파일에서 만든 ajax
	public String usernameCheck(String username) {
		return Boolean.toString(authService.checkUsername(username));
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
