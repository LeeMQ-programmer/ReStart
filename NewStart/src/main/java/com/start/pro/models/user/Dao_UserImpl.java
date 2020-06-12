package com.start.pro.models.user;

import java.util.Date;
import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.start.pro.dto.DTO_User;

@Repository
public class Dao_UserImpl implements IDao_User {
	private Logger log = LoggerFactory.getLogger(this.getClass());
	private final String NS = "com.start.pro.User.";
	@Autowired
	private SqlSessionTemplate session;
	
	@Override
	public boolean updateTeacher(int user_seq) {
		log.info("DAO@@@@@강사 등급 업데이트,{}",user_seq);
		int isc = session.insert(NS+"updateTeacher",user_seq);
		return isc>0?true:false;
		
	}

	@Override
	public boolean updateHuman(int user_seq) {
		log.info("DAO@@@@@휴면 등급 업데이트,{}",user_seq);
		int isc = session.insert(NS+"updateHuman",user_seq);
		return isc>0?true:false;
	}

	@Override
	public List<DTO_User> searchAll() {
		log.info("DAO@@@@@회원 전체 조회,{}",new Date());
		return session.selectList(NS+"searchAll");
	}

	@Override
	public DTO_User searchDetail(int user_seq) {
		log.info("DAO@@@@@회원 조회,{}",user_seq);
		return session.selectOne(NS+"searchDetail",user_seq);
	}


	
}
