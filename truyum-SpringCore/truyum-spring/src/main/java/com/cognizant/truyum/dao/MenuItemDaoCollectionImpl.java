package com.cognizant.truyum.dao;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import com.cognizant.truyum.model.MenuItem;

/**
 * Implements MenuItemDao Interface
 */
@Component
public class MenuItemDaoCollectionImpl implements MenuItemDao {

	/**
	 * List Of MenuItems("Sandwich,Burger...")
	 */
	@Autowired
	private List<MenuItem> menuItemList;

	/**
	 * Default Constructor
	 */
	public MenuItemDaoCollectionImpl() {
		super();
	}

	/**
	 * Getters and Setters
	 */
	public List<MenuItem> getMenuItemList() {
		return menuItemList;
	}

	public void setMenuItemList(List<MenuItem> menuItemList) {
		this.menuItemList = menuItemList;
	}

	/**
	 * This method returns the list of menu items for Admin
	 * 
	 * @return menuItemList for Admin
	 */
	public List<MenuItem> getMenuItemListAdmin() {
		return menuItemList;
	}

	/**
	 * Gets the details of modified menuItem from user Checks for id and match and
	 * then change the menu item data in the list of menu items
	 * 
	 * @param menuItem
	 */
	public void modifyMenuItem(MenuItem menuItem) {
		for (int i = 0; i < menuItemList.size(); i++) {
			if (menuItem.equals(menuItemList.get(i))) {
				menuItemList.set(i, menuItem);
			}
		}
	}

	/**
	 * Takes input of menuItemId and returns a particular menu item's detail from
	 * the menu item list
	 * 
	 * @param menuItemId
	 * @return menuItem
	 */
	public MenuItem getMenuItem(long menuItemId) {
		MenuItem menuItem = null;
		for (int i = 0; i < menuItemList.size(); i++) {
			if (menuItemId == (menuItemList.get(i).getId())) {
				menuItem = menuItemList.get(i);
			}
		}
		return menuItem;
	}

	@Override
	/**
	 * This method returns the list of menu items for Customer checks if launch date
	 * of the menu item is today or before today checks if menu item available is
	 * active
	 * 
	 * @return menuListCustomer
	 */
	public List<MenuItem> getMenuItemListCustomer() {
		ArrayList<MenuItem> menuListCustomer = new ArrayList<>();
		Date current = new Date();
		for (int i = 0; i < menuItemList.size(); i++) {
			if ((menuItemList.get(i).getDateOfLaunch().before(current)
					|| menuItemList.get(i).getDateOfLaunch().equals(current)) && menuItemList.get(i).isActive()) {
				menuListCustomer.add(menuItemList.get(i));
			}
		}
		return menuListCustomer;
	}
}
