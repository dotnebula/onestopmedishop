package com.mariaj.onestopmedishop.controllers;

import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.mariaj.onestopmedishop.dto.ResponseDto;
import com.mariaj.onestopmedishop.models.WhishList;
import com.mariaj.onestopmedishop.services.WhishListService;



@RestController
public class WhishlistController {

	@Autowired 
	WhishListService whishlistService;

	@GetMapping("/whishlists")
	public List<WhishList> getWhishlists(){
		return whishlistService.getWhishLists();
	}

	@GetMapping("/whishlists/{whishlistId}")
	public ResponseDto getWhishlist(@PathVariable int whishlistId){
		Optional<WhishList> whishlist = whishlistService.getWhishList(whishlistId);
		return new ResponseDto("Whishlist user is found sucessfully with whishlistId : "+whishlistId, new Date(),HttpStatus.OK.name(),whishlist);
	}

	@PostMapping("/whishlists")
	public ResponseDto addWhishlist(@RequestBody WhishList whishlist){
		WhishList whishlistCreated = whishlistService.addWhishList(whishlist);
		return new ResponseDto("Whishlist user is created sucessfully.", new Date(),HttpStatus.OK.name(),whishlistCreated);
	}

	@PutMapping("/whishlists")
	public ResponseDto updateWhishlist(@RequestBody WhishList whishlist){
		WhishList whishlistUpdated = whishlistService.updateWhishList(whishlist);
		return new ResponseDto("Whishlist user is updated sucessfully.", new Date(),HttpStatus.OK.name(),whishlistUpdated);
	}

	@DeleteMapping("/whishlists/{whishlistId}")
	public ResponseDto updateWhishlist(@PathVariable int whishlistId){
		whishlistService.deleteWhishList(whishlistId);
		return new ResponseDto("Whishlist user is deleted sucessfully with whishlistId : "+whishlistId, new Date(),HttpStatus.OK.name(),null);
	}
}
