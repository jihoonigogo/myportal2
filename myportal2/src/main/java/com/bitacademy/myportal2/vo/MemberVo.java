package com.bitacademy.myportal2.vo;

import java.util.Date;

import org.hibernate.validator.constraints.Email;
//import javax.validation.constraints.Email;
//import javax.validation.constraints.NotEmpty;
import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.NotEmpty;

public class MemberVo {
	// 필드
	private Long no;
	
	@NotEmpty	//	name 필드는 null이 아니어야 하고
	@Length(min=2, max=8)		//	길이가 2글자 ~ 8글자
	private String name;
	
	@NotEmpty	//	email 필드는 null이 아니어야 하고
	@Email		//	이메일 형식이어야 한다
	private String email;
	
	@NotEmpty	//	password 필드는 null이 아니어야 하고
	@Length(min=4, max=20)	//	길이가 4 ~ 20글자여야 한다
	private String password;
	
	private String gender;
	private Date joindate;
	
	//	생성자
	public MemberVo() {
		
	}

	//	Getters/Setters
	public Long getNo() {
		return no;
	}

	public void setNo(Long no) {
		this.no = no;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public Date getJoindate() {
		return joindate;
	}

	public void setJoindate(Date joindate) {
		this.joindate = joindate;
	}

	//	toString
	@Override
	public String toString() {
		return "MemberVo [no=" + no + ", name=" + name + ", email=" + email + ", password=" + password + ", gender="
				+ gender + ", joindate=" + joindate + "]";
	}
	
	
}