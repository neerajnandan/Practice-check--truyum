package com.cognizant.menuitemservice.repository;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import com.cognizant.menuitemservice.model.MenuItem;

public interface MenuItemRepository extends CrudRepository<MenuItem, Integer>{
	
	
MenuItem findById(int id);
	
	@Query(value="select * from menu_item where me_active=true and me_date_of_launch<=CURDATE()",nativeQuery=true)
	List<MenuItem> getAllCustomerList();




	
}
