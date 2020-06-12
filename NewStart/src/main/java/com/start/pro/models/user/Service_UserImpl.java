package com.start.pro.models.user;

import java.util.Date;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.start.pro.dto.DTO_User;

@Service
public class Service_UserImpl implements IService_User{

	private Logger log = LoggerFactory.getLogger(this.getClass());

	@Autowired
	private IDao_User dao;
	
	

	@Override
	public boolean updateTeacher(int user_seq) {
		log.info("SERVICE@@@@@강사 인증 시 등급 업데이트,{}",user_seq);
		return dao.updateTeacher(user_seq);
	}

	@Override
	public boolean updateHuman(int user_seq) {
		log.info("SERVICE@@@@휴면회원 업데이트,{}",user_seq);
		return dao.updateHuman(user_seq);
	}

	@Override
	public List<DTO_User> searchAll() {
		log.info("SERVICE@@@@전체 회원 조회,{}",new Date());
		return dao.searchAll();
	}

	@Override
	public DTO_User searchDetail(int user_seq) {
		log.info("SERVICE@@@@상세 회원 조회,{}",user_seq);
		return dao.searchDetail(user_seq);
	}



}
