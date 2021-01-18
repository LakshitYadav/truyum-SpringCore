package com.cognizant.truyum.service;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.cognizant.truyum.dao.MenuItemDao;
import com.cognizant.truyum.model.MenuItem;

@Service("menuItemService")
public class MenuItemService {

	

	/**
	 * Create an instance variable for MenuItemDao
	 * Autowire MenuItemDao with MenuItemDaoCollectionImpl using annotation
	 * Uses Interface Injection technique to map instance variable
	 */
	@Autowired
	private MenuItemDao menuItemDao;

	/**
	 * Getters and setters
	 */
	public MenuItemDao getMenuItemDao() {
		return menuItemDao;
	}

	public void setMenuItemDao(MenuItemDao menuItemDao) {
		this.menuItemDao = menuItemDao;
	}

	/**
	 * To get the menuitems list for admin
	 * 
	 * @return menuItemListAdmin
	 */
	public List<MenuItem> getMenuItemListAdmin() {
		return menuItemDao.getMenuItemListAdmin();

	}

	/**
	 * To get the menuitems list for customer
	 * 
	 * @return menuItemListCustomer
	 */
	public List<MenuItem> getMenuItemListCustomer() {
		return menuItemDao.getMenuItemListCustomer();

	}

	/**
	 * To get the menuitem based on id
	 * 
	 * @param menuItemId
	 * @return menuItem
	 */
	public MenuItem getMenuItem(long menuItemId) {
		return menuItemDao.getMenuItem(menuItemId);

	}

	/**
	 * To modify the menu item details
	 * 
	 * @param menuItem
	 */
	public void modifyMenuItem(MenuItem menuItem) {
		menuItemDao.modifyMenuItem(menuItem);
	}

	public void editMenuItem(MenuItem menutItem) {

	}

}
