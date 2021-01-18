package com.cognizant.truyum.dao;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import com.cognizant.truyum.model.Cart;
import com.cognizant.truyum.model.MenuItem;

/**
 * Implements cartDAO interface
 */
public class CartDaoCollectionImpl implements CartDao {

	/**
	 * instance variable To store the user's and the menu items in their respective
	 * cart
	 */

	private HashMap<Long, Cart> userCarts;

	@Autowired
	MenuItemDao menuItemDao;

	/**
	 * Getters and Setters
	 */
	public HashMap<Long, Cart> getUserCarts() {
		return userCarts;
	}

	public void setUserCarts(HashMap<Long, Cart> userCarts) {
		this.userCarts = userCarts;
	}

	/**
	 * To get the menuitem corresponding to the specified menuItemId To check for
	 * existence of user based on userId Add the new menuitem into the cart
	 * 
	 * @param userId
	 * @param menuItemId
	 */
	public void addCartItem(long userId, long menuItemId) {
		MenuItem item = menuItemDao.getMenuItem(menuItemId);
		if (userCarts.containsKey(userId)) {
			Cart cart3 = userCarts.get(userId);
			List<MenuItem> list = new ArrayList<>();
			float price = 0.0f;
			list = cart3.getMenuItemList();
			price = (float) cart3.getTotal();
			list.add(item);
			price = price + item.getPrice();
			Cart updatedCart1 = new Cart(list, price);
			userCarts.put(userId, updatedCart1);
		} else {
			List<MenuItem> newList = new ArrayList<>();
			newList.add(item);
			Cart cartNew = new Cart(newList, item.getPrice());
			userCarts.put(userId, cartNew);
		}
	}

	/**
	 * To get list of menu items added by a customer to cart
	 * 
	 * @param userId
	 * @return menuItemList in the cart
	 * @throws CartEmptyException
	 */
	public List<MenuItem> getAllCartItems(long userId) throws CartEmptyException {
		List<MenuItem> menuItemList = new ArrayList<>();
		Cart cart = userCarts.get(userId);
		menuItemList = cart.getMenuItemList();
		if (menuItemList == null) {
			throw new CartEmptyException("Cart is Empty!!!");
		} else {
			double total = 0;
			for (MenuItem menuItem : menuItemList) {
				total = total + menuItem.getPrice();
			}
			cart.setTotal(total);

		}
		return menuItemList;
	}

	/**
	 * To remove a menu item from the cart
	 * 
	 * @param userId
	 * @param menuItemId
	 */
	public void removeCartItem(long userId, long menuItemId) {
		Cart cart = userCarts.get(userId);
		List<MenuItem> list = cart.getMenuItemList();
		float tprice = (float) cart.getTotal();
		for (MenuItem mi : list) {
			if (mi.getId() == menuItemId) {
				tprice = tprice - mi.getPrice();
				list.remove(mi);
				break;
			}
		}
	}
}
