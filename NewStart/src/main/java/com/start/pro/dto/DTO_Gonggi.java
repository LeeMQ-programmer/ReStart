package com.start.pro.dto;

import java.util.Date;

public class DTO_Gonggi {

	private int gi_seq;
	private int board_code;
	private char gi_category;
	private String gi_title;
	private String gi_content;
	private Date gi_regdate;
	private int admin_seq;
	
	public DTO_Gonggi() {
		// TODO Auto-generated constructor stub
	}

	@Override
	public String toString() {
		return "DTO_Gonggi [gi_seq=" + gi_seq + ", board_code=" + board_code + ", gi_category=" + gi_category
				+ ", gi_title=" + gi_title + ", gi_content=" + gi_content + ", gi_regdate=" + gi_regdate
				+ ", admin_seq=" + admin_seq + "]";
	}

	public int getGi_seq() {
		return gi_seq;
	}

	public void setGi_seq(int gi_seq) {
		this.gi_seq = gi_seq;
	}

	public int getBoard_code() {
		return board_code;
	}

	public void setBoard_code(int board_code) {
		this.board_code = board_code;
	}

	public char getGi_category() {
		return gi_category;
	}

	public void setGi_category(char gi_category) {
		this.gi_category = gi_category;
	}

	public String getGi_title() {
		return gi_title;
	}

	public void setGi_title(String gi_title) {
		this.gi_title = gi_title;
	}

	public String getGi_content() {
		return gi_content;
	}

	public void setGi_content(String gi_content) {
		this.gi_content = gi_content;
	}

	public Date getGi_regdate() {
		return gi_regdate;
	}

	public void setGi_regdate(Date gi_regdate) {
		this.gi_regdate = gi_regdate;
	}

	public int getAdmin_seq() {
		return admin_seq;
	}

	public void setAdmin_seq(int admin_seq) {
		this.admin_seq = admin_seq;
	}

	public DTO_Gonggi(int gi_seq, int board_code, char gi_category, String gi_title, String gi_content,
			Date gi_regdate) {
		super();
		this.gi_seq = gi_seq;
		this.board_code = board_code;
		this.gi_category = gi_category;
		this.gi_title = gi_title;
		this.gi_content = gi_content;
		this.gi_regdate = gi_regdate;
	}

	
}
