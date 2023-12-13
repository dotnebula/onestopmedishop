package com.mariaj.onestopmedishop.models;

import java.util.Date;
import java.util.UUID;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.PrePersist;
import javax.persistence.PreUpdate;
import javax.persistence.Table;
import javax.persistence.Transient;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

import org.springframework.format.annotation.DateTimeFormat;

import lombok.Data;

@Data
@Entity
@Table(name = "admins")
public class Admin {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="admin_id")
	private int adminId;
	
	@Column(name="email")
	private String email;
	
	@Column(name="password")
	private String password;
	
	@Transient
	private String passwordConfirmation;
	
	@Column(name="first_name")
	private String firstName;
	
	@Column(name="last_name")
	@NotBlank(message="Last Name can not be blank")
	@Size(max=30, message="Last name must be up to 30 characters")
	private String lastName;
	
	@Column(name="admin_user_name")
	private String adminUserName;
	
	@Column(name="auth_token")
	private String authToken = UUID.randomUUID().toString();
	
	@Column(name="login_type")
	private int loginType;
	
	@Column(updatable=false)
	@DateTimeFormat(pattern="yyyy-MM-dd")
	private Date createdAt;
	
	@DateTimeFormat(pattern="yyyy-MM-dd")
	private Date updatedAt;
	
	@PrePersist
	protected void onCreate(){
		this.createdAt = new Date();
	}
	
	@PreUpdate
	protected void onUpdate(){
	    this.updatedAt = new Date();
	}

	public Admin() {
		
	}

	public Admin(int adminId, String email, String password, String passwordConfirmation, String firstName,
			String lastName, String adminUserName, String authToken, int loginType, Date createdAt, Date updatedAt) {
		super();
		this.adminId = adminId;
		this.email = email;
		this.password = password;
		this.passwordConfirmation = passwordConfirmation;
		this.firstName = firstName;
		this.lastName = lastName;
		this.adminUserName = adminUserName;
		this.authToken = authToken;
		this.loginType = loginType;
		this.createdAt = createdAt;
		this.updatedAt = updatedAt;
	}

	public int getAdminId() {
		return adminId;
	}

	public void setAdminId(int adminId) {
		this.adminId = adminId;
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

	public String getPasswordConfirmation() {
		return passwordConfirmation;
	}

	public void setPasswordConfirmation(String passwordConfirmation) {
		this.passwordConfirmation = passwordConfirmation;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getAdminUserName() {
		return adminUserName;
	}

	public void setAdminUserName(String adminUserName) {
		this.adminUserName = adminUserName;
	}

	public String getAuthToken() {
		return authToken;
	}

	public void setAuthToken(String authToken) {
		this.authToken = authToken;
	}

	public int getLoginType() {
		return loginType;
	}

	public void setLoginType(int loginType) {
		this.loginType = loginType;
	}

	public Date getCreatedAt() {
		return createdAt;
	}

	public void setCreatedAt(Date createdAt) {
		this.createdAt = createdAt;
	}

	public Date getUpdatedAt() {
		return updatedAt;
	}

	public void setUpdatedAt(Date updatedAt) {
		this.updatedAt = updatedAt;
	}
	
	
}
