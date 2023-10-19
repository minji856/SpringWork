package com.maymin.member.model;
/* DTO 입력받을때 잠시 보관해둘 */
public class RegisterRequest {
	private String email;
	private String password;
	private String confirmPassword;
	private String name;
	
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
	public String getConfirmPassword() {
		return confirmPassword;
	}
	public void setConfirmPassword(String confirmPassword) {
		this.confirmPassword = confirmPassword;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	/* 패스워드가 맞는지 틀리는지 굳이 다른데에 이 기능 넣는건 지나친 분리 */
	public boolean isPasswordEqualToconfirmPassword() {
		return password.equals(confirmPassword);
	}
}
