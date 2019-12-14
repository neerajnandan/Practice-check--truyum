package com.cognizant.menuitemservice.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cognizant.menuitemservice.model.MenuItem;
import com.cognizant.menuitemservice.repository.MenuItemRepository;

@Service
public class MenuItemService {
	

	@Autowired
	MenuItemRepository menuitemRepository;
	
	public List<MenuItem> getMenuItemListCustomer(){
		
		return menuitemRepository.getAllCustomerList();
	}


	public List<MenuItem> getMenuItemListAdmin() {
		return (List<MenuItem>) menuitemRepository.findAll();
	}


	public MenuItem getMenuItem(int id) {

		return menuitemRepository.findById(id);
	}


	public MenuItem modifyMenuItem(MenuItem menuItem) {
		// TODO Auto-generated method stub
		return menuitemRepository.save(menuItem);
	}

}
