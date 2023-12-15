package com.mariaj.onestopmedishop.controllers;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.mariaj.onestopmedishop.dto.AuthResponseDto;
import com.mariaj.onestopmedishop.dto.LoginRequestDto;
import com.mariaj.onestopmedishop.dto.ResponseDto;
import com.mariaj.onestopmedishop.dto.UserResponseDto;
import com.mariaj.onestopmedishop.models.Admin;
import com.mariaj.onestopmedishop.models.User;
import com.mariaj.onestopmedishop.services.AdminService;
import com.mariaj.onestopmedishop.services.UserService;


@RestController
public class AuthController {

	@Autowired 
	AdminService adminService;
	
	@Autowired 
	UserService userService;
	
	@PostMapping("/admins/login")
	public ResponseDto adminLogin(@RequestBody LoginRequestDto login){
		Admin admin = adminService.validateLogin(login);
		AuthResponseDto authResponseDto = new AuthResponseDto();
		authResponseDto.setId(admin.getAdminId());
		authResponseDto.setAuthToken(admin.getAuthToken());
		authResponseDto.setAdminUserName(admin.getAdminUserName());
//		authResponseDto.setFirstName(admin.getFirstName());
//		authResponseDto.setLastName(admin.getLastName());
		return new ResponseDto("Admin loggedIn sucessfully.", new Date(), HttpStatus.OK.name(), authResponseDto);
	}
	
	@PostMapping("/users/login")
	public ResponseDto useLogin(@RequestBody LoginRequestDto login){
		User user = userService.validateLogin(login);
		UserResponseDto userResponseDto = new UserResponseDto();
		userResponseDto.setId(user.getUserId());
		userResponseDto.setAuthToken(user.getAuthToken());
		userResponseDto.setUserName(user.getUserName());
//		authResponseDto.setFirstName(user.getFirstName());
//		authResponseDto.setLastName(user.getLastName());
		return new ResponseDto("User loggedIn sucessfully.", new Date(), HttpStatus.OK.name(), userResponseDto);
	}
	
}
