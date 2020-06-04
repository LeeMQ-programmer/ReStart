package com.start.pro.dto;

public class DTO_Profile {
	private int user_seq;
	private String pro_school;
	private String pro_major;
	private String pro_tech;
	private String pro_info;
	private double pro_star;
	
	private String career_company;
	private String career_dept;
	private String career_job;
	private String career_term;
	
	public DTO_Profile() {
		// TODO Auto-generated constructor stub
	}

	public DTO_Profile(int user_seq, String pro_school, String pro_major, String pro_tech, String pro_info,
			double pro_star) {
		super();
		this.user_seq = user_seq;
		this.pro_school = pro_school;
		this.pro_major = pro_major;
		this.pro_tech = pro_tech;
		this.pro_info = pro_info;
		this.pro_star = pro_star;
	}
	

	public DTO_Profile(int user_seq, String career_company, String career_dept, String career_job, String career_term) {
		super();
		this.user_seq = user_seq;
		this.career_company = career_company;
		this.career_dept = career_dept;
		this.career_job = career_job;
		this.career_term = career_term;
	}

	public int getUser_seq() {
		return user_seq;
	}

	public void setUser_seq(int user_seq) {
		this.user_seq = user_seq;
	}

	public String getPro_school() {
		return pro_school;
	}

	public void setPro_school(String pro_school) {
		this.pro_school = pro_school;
	}

	public String getPro_major() {
		return pro_major;
	}

	public void setPro_major(String pro_major) {
		this.pro_major = pro_major;
	}

	public String getPro_tech() {
		return pro_tech;
	}

	public void setPro_tech(String pro_tech) {
		this.pro_tech = pro_tech;
	}

	public String getPro_info() {
		return pro_info;
	}

	public void setPro_info(String pro_info) {
		this.pro_info = pro_info;
	}

	public double getPro_star() {
		return pro_star;
	}

	public void setPro_star(double pro_star) {
		this.pro_star = pro_star;
	}

	
	
	protected String getCareer_company() {
		return career_company;
	}

	protected void setCareer_company(String career_company) {
		this.career_company = career_company;
	}

	protected String getCareer_dept() {
		return career_dept;
	}

	protected void setCareer_dept(String career_dept) {
		this.career_dept = career_dept;
	}

	protected String getCareer_job() {
		return career_job;
	}

	protected void setCareer_job(String career_job) {
		this.career_job = career_job;
	}

	protected String getCareer_term() {
		return career_term;
	}

	protected void setCareer_term(String career_term) {
		this.career_term = career_term;
	}

	@Override
	public String toString() {
		return "DTO_Profile [user_seq=" + user_seq + ", pro_school=" + pro_school + ", pro_major=" + pro_major
				+ ", pro_tech=" + pro_tech + ", pro_info=" + pro_info + ", pro_star=" + pro_star + ", career_company="
				+ career_company + ", career_dept=" + career_dept + ", career_job=" + career_job + ", career_term="
				+ career_term + "]";
	}

		

}
