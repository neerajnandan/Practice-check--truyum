package com.cognizant.truyum.dao;
import org.springframework.stereotype.Repository;

@Repository
public interface CartDao {
	public boolean addCartItem(String userId, long menuItemId);

	/*// Create a class called CartEmptyException
	public Cart getAllCartItems(String userId) throws CartEmptyException;
*/
	public void removeCartItem(String userId, long menuItemId);
}

