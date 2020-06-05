package com.start.pro.models.gonggi;

import java.util.List;
import java.util.Map;

import com.start.pro.dto.DTO_Gonggi;

public interface IDao_Gonggi {

	/**
	 * 전체글 조회
	 * @param dto
	 * @return List
	 */
	public List<DTO_Gonggi> GI_AllSelect(DTO_Gonggi dto);
	
	/**
	 * 상세글 조회
	 * @param seq
	 * @return dto
	 */
	public DTO_Gonggi GI_OneSelect(String seq);
	
	/**
	 * 중요 공지글 등록
	 * @param dto
	 * @return true
	 */
	public Boolean GI_Imp_Insert(DTO_Gonggi dto);
	
	/**
	 * 일반 공지글 등록
	 * @param dto
	 * @return true
	 */
	public Boolean GI_UImp_Insert(DTO_Gonggi dto);
	
	/**
	 * 공지글 수정
	 * @param dto
	 * @return true
	 */
	public Boolean GI_Update(DTO_Gonggi dto);
	
	/**
	 * 공지글 삭제
	 * @param seq
	 * @return true
	 */
	public Boolean GI_Delete(String seq);
}
