package com.mariaj.onestopmedishop.dto;

import lombok.Data;

@Data
public class AuthResponseDto {

	private String authToken;
	private String adminUserName;
	
	private int id;
	
	public AuthResponseDto() {
		
	}

	public AuthResponseDto(String authToken, String adminUserName, int id) {
		super();
		this.authToken = authToken;
		this.adminUserName = adminUserName;
		this.id = id;
	}

	public String getAuthToken() {
		return authToken;
	}

	public void setAuthToken(String authToken) {
		this.authToken = authToken;
	}

	public String getAdminUserName() {
		return adminUserName;
	}

	public void setAdminUserName(String adminUserName) {
		this.adminUserName = adminUserName;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	
	
	
}
