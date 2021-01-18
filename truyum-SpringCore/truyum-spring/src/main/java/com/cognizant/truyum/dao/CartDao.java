package com.cognizant.truyum.dao;

import java.util.List;
import com.cognizant.truyum.model.MenuItem;

public interface CartDao {

	/**
	 * To add a new item into the cart
	 * 
	 * @param userId
	 * @param menuItemId
	 */
	public void addCartItem(long userId, long menuItemId);

	/**
	 * To get all the menuitems in the cart
	 * 
	 * @param userId
	 * @return menuitems list in the cart
	 * @throws CartEmptyException
	 */
	public List<MenuItem> getAllCartItems(long userId) throws CartEmptyException;

	/**
	 * To remove an item from the cart
	 * 
	 * @param userId
	 * @param menuItemId
	 */
	public void removeCartItem(long userId, long menuItemId);

}
