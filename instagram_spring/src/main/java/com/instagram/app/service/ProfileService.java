package com.instagram.app.service;

import com.instagram.app.domain.user.User;
import com.instagram.app.web.dto.account.AccountResponseDto;
import com.instagram.app.web.dto.account.AccountUpdateReqDto;
import com.instagram.app.web.dto.account.PasswordUpdateReqDto;

public interface ProfileService {

	public AccountResponseDto getAccountProfile(int usercode);
	public boolean updateAccount(AccountUpdateReqDto accountUpdateReqDto);
	public boolean updatePassword(User user, PasswordUpdateReqDto passwordUpdateReqDto);
}
