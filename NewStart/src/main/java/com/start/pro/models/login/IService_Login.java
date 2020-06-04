package com.start.pro.models.login;

import java.util.Map;

import com.start.pro.dto.DTO_User;

public interface IService_Login {

	//로그인
	public DTO_User getPW(String user_email);

	public DTO_User getUser(String user_seq);
	
	public boolean loginUpdate(String user_email);
	
	public boolean changeSleep(String user_seq);
	
	public boolean plusPWFail(String user_email);
	
	public String getPWFail(String user_email);
	
	//회원정보
	public boolean MultipleChk(Map<String, String> map);
	
	public boolean signUp(DTO_User userDto);
	
	public boolean singUpLog(String user_seq);
	
	public boolean changeNomal(String user_seq);
	
	//아이디 찾기
	public String findId(String user_phone);
	
	//비밀번호 찾기
	public boolean changePW(Map<String, String> map);
	
	public boolean updatePWLog(String user_email);
	
	
	
	
	
	
}
