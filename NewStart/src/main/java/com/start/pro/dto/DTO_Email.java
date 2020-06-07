package com.start.pro.dto;

public class DTO_Email {

	private String category_code;
	private String user_email;
	private String email_title;
	private String email_content;
	private String filechk;
	
	public DTO_Email() {}

	public DTO_Email(String category_code, String user_email, String email_title, String email_content,
			String filechk) {
		super();
		this.category_code = category_code;
		this.user_email = user_email;
		this.email_title = email_title;
		this.email_content = email_content;
		this.filechk = filechk;
	}

	public String getCategory_code() {
		return category_code;
	}

	public void setCategory_code(String category_code) {
		this.category_code = category_code;
	}

	public String getUser_email() {
		return user_email;
	}

	public void setUser_email(String user_email) {
		this.user_email = user_email;
	}

	public String getEmail_title() {
		return email_title;
	}

	public void setEmail_title(String email_title) {
		this.email_title = email_title;
	}

	public String getEmail_content() {
		return email_content;
	}

	public void setEmail_content(String email_content) {
		this.email_content = email_content;
	}

	public String getFilechk() {
		return filechk;
	}

	public void setFilechk(String filechk) {
		this.filechk = filechk;
	}

	@Override
	public String toString() {
		return "DTO_Email [category_code=" + category_code + ", user_email=" + user_email + ", email_title="
				+ email_title + ", email_content=" + email_content + ", filechk=" + filechk + "]";
	}
	
	
	
}
