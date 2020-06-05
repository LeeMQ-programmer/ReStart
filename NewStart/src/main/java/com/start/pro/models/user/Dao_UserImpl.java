package com.start.pro.models.user;

import java.util.List;
import java.util.Map;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Repository;

import com.start.pro.dto.DTO_User;
import com.start.pro.security.Sc_User;

@Repository
public class Dao_UserImpl implements IDao_User {

	@Autowired
	private PasswordEncoder passwordencoder;
	
	@Override
	public List<DTO_User> searchUser(int user_seq) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean updateTeacher(int user_seq) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean updateHuman(int user_seq) {
		// TODO Auto-generated method stub
		return false;
	}


	
}
