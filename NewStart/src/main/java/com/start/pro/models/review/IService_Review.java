package com.start.pro.models.review;

import java.util.List;

import com.start.pro.dto.DTO_Review;

public interface IService_Review {

	/**
	 * 후기 게시판 전체 조회
	 * @return DTO_Review
	 */
	public List<DTO_Review> searchAll();
	
	/**
	 * 후기 게시판 상세 조회
	 * @param re_seq(게시물 번호)
	 * @return 게시판 정보
	 */
	public DTO_Review searchDetail(int re_seq);
	
	/**
	 * 후기 게시판 게시물 등록
	 * @param dto(해당 강사,제목, 내용, 별점)
	 * @return 등록 성공 시 true, 실패시 false
	 */
	public boolean insertReview(DTO_Review dto);
	
	/**
	 * 후기 게시판 수정(답글 존재 시 수정 불가)
	 * @param dto
	 * @return 수정 성공 시 true, 실패시 false
	 */
	public boolean updateReview(DTO_Review dto);
	
	/**
	 * 게시물 삭제(답글 존재 시 수정 불가)
	 * @param re_seq(게시글 번호)
	 */
	public boolean delReview(int re_seq);
	
	/**
	 * 답글 입력(부모글 업데이트 후 답글 insert)
	 * @param re_seq(부모글 번호)
	 * @param dto (답글 제목, 글 ,별점)
	 * @return 등록 성공 시 true, 실패시 false
	 */
	public boolean replyInsert(int re_seq, DTO_Review dto);
	
	
}
