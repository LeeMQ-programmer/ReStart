package com.start.pro.models.user;

import java.util.List;

import org.springframework.stereotype.Service;

import com.start.pro.dto.DTO_User;

@Service
public class Service_UserImpl implements IService_User{

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
