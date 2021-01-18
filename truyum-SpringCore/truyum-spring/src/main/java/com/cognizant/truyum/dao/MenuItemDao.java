package com.cognizant.truyum.dao;

import java.util.List;
import com.cognizant.truyum.model.MenuItem;

public interface MenuItemDao {

	/**
	 * To get the menuItemList for admin
	 * 
	 * @return menuItenList for admin
	 */
	public List<MenuItem> getMenuItemListAdmin();

	/**
	 * To get the menuItemList for customer
	 * 
	 * @return menuItenList for customer
	 */
	public List<MenuItem> getMenuItemListCustomer();

	/**
	 * To modify the menu item details
	 * 
	 * @param menuItem
	 */
	public void modifyMenuItem(MenuItem menuItem);

	/**
	 * To get the menuitem on basis of id
	 * 
	 * @param menuItemId
	 * @return menuItem
	 */
	public MenuItem getMenuItem(long menuItemId);

}
