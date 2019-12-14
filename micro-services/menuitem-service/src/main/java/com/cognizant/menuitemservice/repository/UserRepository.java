package com.cognizant.menuitemservice.repository;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import com.cognizant.menuitemservice.model.MenuItem;
import com.cognizant.menuitemservice.model.User;

public interface UserRepository extends CrudRepository<User, Integer>{

	@Query("Select u from User u where u.username=?1")
	User findByUsername(String username);
	
	@Query("SELECT u.menuItems from User u WHERE u.username=?1")
	List<MenuItem> getMenuItems(String username);
	
	
    @Query(value = "select sum(me_price) from menu_item where me_id in(select ct_pr_id from cart where ct_us_id=(select us_id from user where us_username= :username))", nativeQuery = true)
    public double getCartTotal(@Param(value = "username") String username);


}
