package com.cognizant.truyum.service;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.cognizant.truyum.dao.CartDao;
import com.cognizant.truyum.dao.CartEmptyException;
import com.cognizant.truyum.model.MenuItem;

@Service
public class CartService {

	/**
	 * Create instance variable for CartDao 
	 * Autowire CartDao with CartDaoCollectionImpl using annotation
	 */
	@Autowired
	private CartDao cartDao;

	/**
	 * Getters and setters
	 */
	public CartDao getCartDao() {
		return cartDao;
	}

	public void setCartDao(CartDao cartDao) {
		this.cartDao = cartDao;
	}

	/**
	 * To get all the items in the cart
	 * 
	 * @param userId
	 * @return menuItemsList in the cart
	 * @throws CartEmptyException
	 */
	public List<MenuItem> getAllCartItems(long userId) throws CartEmptyException {
		return cartDao.getAllCartItems(userId);

	}

	/**
	 * To add a new menu item in the cart
	 * 
	 * @param userId
	 * @param menuItemId
	 */
	public void addCartItem(long userId, long menuItemId) {
		cartDao.addCartItem(userId, menuItemId);
	}

	/**
	 * To remove an existing menuitem from cart
	 * 
	 * @param userId
	 * @param menuItemId
	 */
	public void removeCartItem(long userId, long menuItemId) {
		cartDao.removeCartItem(userId, menuItemId);
	}
}
