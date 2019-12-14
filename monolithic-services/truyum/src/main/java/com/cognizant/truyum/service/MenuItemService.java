package com.cognizant.truyum.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cognizant.truyum.dao.MenuItemDao;
import com.cognizant.truyum.model.MenuItem;
import com.cognizant.truyum.repository.MenuItemRepository;

@Service
public class MenuItemService {
	
	@Autowired
	MenuItemDao menuItemDao;
	@Autowired
	private MenuItemRepository menuItemRepository;
	
	@Transactional
public List<MenuItem> getMenuItemListCustomer(){
		
		return menuItemRepository.getMenuItemListCustomer();
	}
	/*
	public List<MenuItem> getMenuItemListCustomer(){
		
		return menuItemDao.getMenuItemListCustomer();
	}
*/

	public List<MenuItem> getMenuItemListAdmin() {
		return menuItemRepository.findAll();
	}


	public MenuItem getMenuItem(int id) {

		return menuItemRepository.findById(id);
	}


	public MenuItem modifyMenuItem(MenuItem menuItem) {
		// TODO Auto-generated method stub
		return menuItemRepository.save(menuItem);
	}

}
