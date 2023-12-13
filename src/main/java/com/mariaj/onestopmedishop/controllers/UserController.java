package com.mariaj.onestopmedishop.controllers;
import java.util.Date;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.mariaj.onestopmedishop.dto.ResponseDto;
import com.mariaj.onestopmedishop.models.User;
import com.mariaj.onestopmedishop.services.UserService;



@RestController
public class UserController {

	@Autowired 
	UserService userService;

	@GetMapping("/users")
	public Page<User> getUsers(@RequestParam(defaultValue = "0") int page, @RequestParam(defaultValue = "10") int size, 
			@RequestParam(defaultValue = "userId") String sort, @RequestParam(defaultValue = "ASC") String sortOrder){
		return userService.getUsers(page,size, sort, sortOrder);
	}

	@GetMapping("/users/{userId}")
	public User getUser(@PathVariable int userId){
		return userService.getUser(userId);
	}

	@PostMapping("/users")
	public User addUser(@RequestBody User user){
		return userService.addUser(user);
	}

	@PutMapping("/users")
	public User updateUser(@RequestBody User user){
		return userService.updateUser(user);
	}

	@DeleteMapping("/users/{userId}")
	public ResponseDto updateUser(@PathVariable int userId){
		userService.deleteUser(userId);
		return new ResponseDto("User with userId : " + userId + " sucessfully deleted.", new Date(),HttpStatus.OK.name(),null);
	}
}
