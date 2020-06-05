package com.start.pro.models.user;


import java.util.List;

import com.start.pro.dto.DTO_User;

public interface IService_User {

	/**
	 * 회원 번호를 받으면 회원 상세조회 이고 회원 번호를 받지 않으면 전체 조회 이다.
	 * @param 회원 번호user_seq
	 * @return 회원 정보
	 */
	public List<DTO_User> searchUser(int user_seq);

	
	/**
	 *  강사인증을 신청한 멘티를 강사로 등급을 변경해준다.
	 * @param user_seq(강사인증을 신청한 멘트 번호)
	 * @return 강사 승인시 true, 미승인 시 false
	 */
	public boolean updateTeacher(int user_seq);
	
	/**
	 * 마지막 로그인이 1년이 넘은 회원의 유형을 휴면회원으로 변경
	 * @param user_seq(마지막 로그인이 1년이 넘은 회원 번호)
	 * @return 유형 변경 성공 시 true, 아닐시 false;	
	 */
	public boolean updateHuman(int user_seq);
}
