package com.start.pro.models.email;

import java.util.Map;

import com.start.pro.dto.DTO_Email;

public interface IDao_Email {

	//인증 이메일
	
	/**
	 * 인증 메일을 발송할 때 인증메일테이블에 데이터를 저장합니다.
	 * 필요한 키는 다음과 같습니다.
	 * user_email : 보내는 유저의 이메일을 넣습니다. 
	 * lj_key : 보내는 랜덤 인증번호를 넣습니다.
	 * @param Map<String,String>
	 * @return boolean(true/false)
	 */
	public boolean sendLJ(Map<String, String> map);
	
	/**
	 * 이메일 인증할 때 사용합니다. 유저가 이메일의 버튼을 클릭해 들어오면
	 * 이메일과 키값을 받아 이를 통해 일치하는게 있는지 확인합니다.
	 * 필요한 키는 다음과 같습니다.
	 * user_email : 인증할 유저의 이메일을 넣습니다.
	 * lj_key : 인증할 키값을 넣습니다.
	 * @param Map<String,String>
	 * @return boolean(true/false)
	 */
	public boolean LJKey(Map<String,String> map);
	
	/**
	 * 인증으로 보내진 이메일은 1년동안 보관하게 됩니다.
	 * 하루에 한번씩 실행되며 1년이 지난 이메일은 이 쿼리를 통해
	 * 디비에서 완전히 지워지게 됩니다.
	 * @return boolean(true/false)
	 */
	public boolean DelLJ();
	
	// 자동 이메일
	/**
	 * 자동이메일 초기 설정입니다. 처음 만들때 딱 한번 실행되며
	 * 그 이후로는 사용할 일이 없습니다.
	 * 카테고리에 따라 처음만 실행됩니다. 혹은 후에 카테고리를 추가할 때
	 * 튜닝해서 사용할지도 모릅니다.
	 * 필요한 정보는 다음과 같습니다.
	 * email_title : 제목
	 * email_content : 내용
	 * filechk : 파일 존재 여부
	 * use_chk : 사용 여부
	 * @param DTO_Email
	 * @return boolean(true/false)
	 */
	public boolean SetAutoEmail(DTO_Email dto);
	
	/**
	 * 상황별 카테고리에 대한 자동 이메일을 수정할 때 사용합니다.
	 * 필요한 정보는 다음과 같습니다.
	 * email_title : 이메일 제목
	 * email_content : 이메일 내용
	 * filechk : 파일 첨부 여부
	 * use_chk : 사용 여부
	 * category_code : 변경할 카테고리 코드
	 * @param DTO_Email
	 * @return boolean(true/false)
	 */
	public boolean UpdateAuto(DTO_Email dto);
	
	
	
}
