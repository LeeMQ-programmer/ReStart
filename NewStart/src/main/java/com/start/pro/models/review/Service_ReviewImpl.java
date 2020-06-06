package com.start.pro.models.review;

import java.util.Date;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.start.pro.dto.DTO_Review;

import oracle.net.aso.d;

@Service
public class Service_ReviewImpl implements IService_Review{

	private Logger log = LoggerFactory.getLogger(this.getClass());
	
	@Autowired
	private IDao_Review dao;
	
	@Override
	public List<DTO_Review> searchAll() {
		log.info("Service@@@@@후기 게시판 전체 조회,{}",new Date());
		return dao.searchAll();
	}

	@Override
	public DTO_Review searchDetail(int re_seq) {
		log.info("Service@@@@@후기 게시판 상세 조회,{}",new Date());

		return dao.searchDetail(re_seq);
	}

	@Override
	public boolean insertReview(DTO_Review dto) {
		log.info("Service@@@@@후기 게시판 글 등록,{}",dto);
		return dao.insertReview(dto);
	}

	@Override
	public boolean updateReview(DTO_Review dto) {
		log.info("Service@@@@@후기 게시판 글 수정,{}",dto);
		return dao.updateReview(dto);
	}

	@Override
	public boolean delReview(int re_seq) {
		log.info("Service@@@@@후기 게시판 글 삭제,{}",new Date());
		return dao.delReview(re_seq);
	}

	@Override
	public boolean replyInsert(int re_seq,DTO_Review dto) {
		log.info("Service@@@@@후기 게시판 답글 등록,{},{}",re_seq,dto);
		return dao.updateParent(re_seq)&&dao.insertReply(dto);
	}



}
