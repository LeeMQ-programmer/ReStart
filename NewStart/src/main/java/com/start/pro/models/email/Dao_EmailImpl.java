package com.start.pro.models.email;

import java.util.List;
import java.util.Map;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.start.pro.dto.DTO_Email;

@Repository
public class Dao_EmailImpl implements IDao_Email{

	@Autowired
	private SqlSessionTemplate session;
	
	private final String NS = "com.start.pro.email.";
	
	@Override
	public boolean sendLJ(Map<String, String> map) {
		return session.insert(NS+"sendLJ",map) > 0 ? true : false;
	}

	@Override
	public boolean LJKey(Map<String, String> map) {
		return Integer.parseInt(session.selectOne(NS+"LJKey",map)) > 0 ? true : false;
	}

	@Override
	public boolean DelLJ() {
		return session.delete(NS+"DelLJ") > 0 ? true : false;
	}

	@Override
	public boolean SetAutoEmail(DTO_Email dto) {
		return session.insert(NS+"SetAutoEmail", dto) > 0 ? true : false;
	}

	@Override
	public boolean UpdateAuto(DTO_Email dto) {
		return session.update(NS+"UpdateAuto",dto) > 0 ? true : false;
	}

	@Override
	public List<DTO_Email> SelAuto() {
		return session.selectList(NS+"SelAuto");
	}

	@Override
	public DTO_Email SelDetailAuto(String code) {
		return session.selectOne(NS+"SelDetailAuto",code);
	}

	@Override
	public DTO_Email getEmailInfo(String code) {
		return session.selectOne(NS+"getEmailInfo",code);
	}
	
	
	@Override
	public DTO_Email SendEmail(DTO_Email dto) {
		session.insert(NS+"SendEmail",dto);
		return dto;
	}

	@Override
	public boolean MailSuccess(Map<String, String> map) {
		return session.update(NS+"MailSuccess", map) > 0 ? true : false;
	}

	@Override
	public DTO_Email mailresend(String seq) {
		return session.selectOne(NS+"mailresend", seq);
	}

	@Override
	public boolean DelMail() {
		return session.delete(NS+"DelMail") > 0 ? true : false;
	}

	@Override
	public List<DTO_Email> SelAllMail() {
		return session.selectList(NS+"SelAllMail");
	}

	@Override
	public DTO_Email SelMailDetail(String seq) {
		return session.selectOne(NS+"SelMailDetail",seq);
	}

	@Override
	public List<DTO_Email> SelMailFilter(Map<String, String> map) {
		return session.selectList(NS+"SelMailFilter", map);
	}

	@Override
	public List<DTO_Email> SelUserFiter(Map<String, String> map) {
		return session.selectOne(NS+"SelUserFiter", map);
	}


	
}