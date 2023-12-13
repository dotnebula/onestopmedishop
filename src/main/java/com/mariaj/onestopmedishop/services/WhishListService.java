package com.mariaj.onestopmedishop.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mariaj.onestopmedishop.exceptions.BadRequestException;
import com.mariaj.onestopmedishop.exceptions.NotFoundException;
import com.mariaj.onestopmedishop.models.WhishList;
import com.mariaj.onestopmedishop.repositories.WhishListRepository;
import com.mariaj.onestopmedishop.utilities.StringUtil;


@Service
public class WhishListService {

	@Autowired
	WhishListRepository whishListRepository;

	public List<WhishList> getWhishLists() {
		return whishListRepository.findAll();
	}

	public Optional<WhishList> getWhishList(int whishlistId) {
		Optional<WhishList> whishlist =  whishListRepository.findById(whishlistId);
		if(whishlist.isPresent() && StringUtil.isNotNull(whishlist))
			return whishlist;
		else 
			throw new NotFoundException("The whishlist details does not exist with provided whishlistId.");
	}
	
	public WhishList addWhishList(WhishList whishlist) {
		return whishListRepository.save(whishlist);
	}
	
	public WhishList updateWhishList(WhishList whishlist) {
		if(whishlist.getWishlistId() <=0 )
			throw new BadRequestException("whishlistId id cannot be null or empty.");
		if(whishListRepository.existsById(whishlist.getWishlistId()))
			return whishListRepository.save(whishlist);
		else 
			throw new NotFoundException("The whishlist details does not exist with provided whishlistId.");
	}
	
	public void deleteWhishList(int whishlistId) {
		if(whishlistId <=0 )
			throw new BadRequestException("whishlistId id cannot be null or empty.");
		if(whishListRepository.existsById(whishlistId))
			whishListRepository.deleteById(whishlistId);
		else 
			throw new NotFoundException("The whishlist details does not exist with provided whishlistId.");
	}
}
