package com.cognizant.menuitemservice.service;

import java.util.ArrayList;
import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cognizant.menuitemservice.dto.CartDTO;
import com.cognizant.menuitemservice.exception.CartEmptyException;
import com.cognizant.menuitemservice.model.MenuItem;
import com.cognizant.menuitemservice.model.User;
import com.cognizant.menuitemservice.repository.MenuItemRepository;
import com.cognizant.menuitemservice.repository.UserRepository;

@Service
public class CartService {
	
	
	@Autowired
	UserRepository userRepository;
	
	@Autowired
	MenuItemRepository menuItemRepository;

	@Transactional
	public boolean addCartItem(String username, int id) { 
		
		User user = userRepository.findByUsername(username);
		MenuItem menuItem = menuItemRepository.findById(id);
		user.getMenuItems().add(menuItem);
		userRepository.save(user);
		return true;
		}

	@Transactional
	 public CartDTO getAllCartItems(String username) throws CartEmptyException { 
		 
		 CartDTO cartDTO;
		 List<MenuItem> menuItemList = (ArrayList<MenuItem>) userRepository.getMenuItems(username); 
		 
		 if(menuItemList==null || menuItemList.size()==0){
			 return new CartDTO(new ArrayList(),0);
//			 throw new CartEmptyException();
		 }
		 else{
			 cartDTO = new CartDTO();
			 cartDTO.setCartItems( menuItemList);
			 cartDTO.setTotal(userRepository.getCartTotal(username));
		 }
		 return cartDTO;
	}

	
	
			@Transactional
			 public void deleteCartItem(String username, int id) {
//				 	cartDTO.removeCartItem(userId, menuItemId);
				
				 User user = userRepository.findByUsername(username);
				 MenuItem menuItem = menuItemRepository.findById(id);
				 List<MenuItem> menuItemList = user.getMenuItems();
				 menuItemList.remove(menuItem);
				 user.setMenuItems(menuItemList);
				 userRepository.save(user);
			}
	
	
	/*
	@Autowired
	CartDao cartDao;
	
	public boolean addCartItem(String userId, long menuItemId) {
		return cartDao.addCartItem(userId, menuItemId);
	}

	public Cart getAllCartItems(String userId) {
		// TODO Auto-generated method stub
		try {
			if(cartDao.getAllCartItems(userId)!=null)
			return cartDao.getAllCartItems(userId);
			else
				return new Cart(new ArrayList<MenuItem>(),0);
				
		} catch (CartEmptyException e) {
			return new Cart(new ArrayList<MenuItem>(),0);
		}
	}



	public void deleteCartItem(String userId, Long menuItemId) {
		// TODO Auto-generated method stub
		cartDao.removeCartItem(userId, menuItemId);
		
	}
*/

	
	



}
