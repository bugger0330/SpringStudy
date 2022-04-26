package com.instagram.app.domain.profile;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class ProfileRepositoryImpl implements ProfileRepository {
	
	@Autowired //=객체 자동 주입 servlet-context.xml 의 id="sqlSessionTemplate" 객체가 주입된다
	private SqlSession session;

	private final String NAME_SPACE = "com.instagram.app.domain.profile.ProfileRepository.";

	@Override
	public Account getAccountProfileByUsercode(int usercode) {
		
		return session.selectOne(NAME_SPACE + "getAccountProfileByUsercode", usercode);
	}
	
	
	
}
