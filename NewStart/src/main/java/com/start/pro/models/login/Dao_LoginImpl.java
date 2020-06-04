package com.start.pro.models.login;

import java.util.Map;

import com.start.pro.dto.DTO_User;

public class Dao_LoginImpl implements IDao_Login {

	
	
	
	@Override
	public DTO_User getPW(String user_email) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public DTO_User getUser(String user_seq) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean loginUpdate(String user_email) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean changeSleep(String user_seq) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean plusPWFail(String user_email) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public String getPWFail(String user_email) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean MultipleChk(Map<String, String> map) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean signUp(DTO_User userDto) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean singUpLog(String user_seq) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean changeNomal(String user_seq) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public String findId(String user_phone) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean changePW(Map<String, String> map) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean updatePWLog(String user_email) {
		// TODO Auto-generated method stub
		return false;
	}

	
}
