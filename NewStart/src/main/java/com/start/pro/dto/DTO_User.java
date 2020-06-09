package com.start.pro.dto;

public class DTO_User {

	private String user_seq;
	private String user_email;
	private String user_nickname;
	private String user_name;
	private String user_grade;
	private String user_type;
	private String user_pw;
	private String user_phone;
	private String user_adchk;
	private String user_regdate;
	private String user_tchk;
	
	public DTO_User() {}

	public DTO_User(String user_email, String user_nickname, String user_name, String user_pw, String user_phone,
			String user_adchk) {
		super();
		this.user_email = user_email;
		this.user_nickname = user_nickname;
		this.user_name = user_name;
		this.user_pw = user_pw;
		this.user_phone = user_phone;
		this.user_adchk = user_adchk;
	}

	public String getUser_seq() {
		return user_seq;
	}

	public void setUser_seq(String user_seq) {
		this.user_seq = user_seq;
	}

	public String getUser_email() {
		return user_email;
	}

	public void setUser_email(String user_email) {
		this.user_email = user_email;
	}

	public String getUser_nickname() {
		return user_nickname;
	}

	public void setUser_nickname(String user_nickname) {
		this.user_nickname = user_nickname;
	}

	public String getUser_name() {
		return user_name;
	}

	public void setUser_name(String user_name) {
		this.user_name = user_name;
	}

	public String getUser_grade() {
		return user_grade;
	}

	public void setUser_grade(String user_grade) {
		this.user_grade = user_grade;
	}

	public String getUser_type() {
		return user_type;
	}

	public void setUser_type(String user_type) {
		this.user_type = user_type;
	}

	public String getUser_pw() {
		return user_pw;
	}

	public void setUser_pw(String user_pw) {
		this.user_pw = user_pw;
	}

	public String getUser_phone() {
		return user_phone;
	}

	public void setUser_phone(String user_phone) {
		this.user_phone = user_phone;
	}

	public String getUser_adchk() {
		return user_adchk;
	}

	public void setUser_adchk(String user_adchk) {
		this.user_adchk = user_adchk;
	}

	public String getUser_regdate() {
		return user_regdate;
	}

	public void setUser_regdate(String user_regdate) {
		this.user_regdate = user_regdate;
	}

	public String getUser_tchk() {
		return user_tchk;
	}

	public void setUser_tchk(String user_tchk) {
		this.user_tchk = user_tchk;
	}

	@Override
	public String toString() {
		return "DTO_User [user_seq=" + user_seq + ", user_email=" + user_email + ", user_nickname=" + user_nickname
				+ ", user_name=" + user_name + ", user_grade=" + user_grade + ", user_type=" + user_type + ", user_phone=" + user_phone + ", user_adchk=" + user_adchk + ", user_regdate="
				+ user_regdate + ", user_tchk=" + user_tchk + "]";
	}
	
	
}
