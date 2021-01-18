package com.cognizant.truyum.service;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import java.util.List;
import org.junit.Before;
import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.ImportResource;
import com.cognizant.truyum.model.MenuItem;
import com.cognizant.truyum.util.DateUtil;

@ImportResource({ "spring-config.xml" })
@Configuration
public class MenuItemServiceTest {

	/**
	 * instance variable
	 */
	private MenuItemService menuItemService;

	
	/**
	 * to initialize the service 
	 * This method gets the menuItemService bean from the annotations defined 
	 * and loads them into the Spring Container 
	 * creates a new instance of AnnotationConfigApplicationContext 
	 * Invokes scan() and refresh() method in context
	 */
	@Before
	public void initializeService() {
		@SuppressWarnings("resource")
		AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext();
		context.scan("com.cognizant.truyum");
		context.refresh();
		menuItemService = context.getBean(MenuItemService.class);
		context.close();
	}

	/**
	 * Test the implementation using getMenuItemListAdmin() method validate if the
	 * number of items are correct in the method
	 */
	@Test
	public void testGetMenuItemListAdminSize() {
		System.out.println("testGetMenuItemListAdminSize()");
		List<MenuItem> menuItemList = menuItemService.getMenuItemListAdmin();
		assertEquals(5, menuItemList.size());
		System.out.println("The number of items are correct!!!");
		System.out.println("");
	}

	/**
	 * Test the implementation using getMenuItemListAdmin() method validate if the
	 * returned list contains Sandwich
	 */
	@Test
	public void testGetMenuItemListAdminContainsSandwich() {
		System.out.println("testGetMenuItemListAdminContainsSandwich()");
		List<MenuItem> menuItemList = menuItemService.getMenuItemListAdmin();
		MenuItem checkMenuItem = new MenuItem((long) 1, "Sandwich", (float) 99.0, true, DateUtil.convertToDate("15/03/2017"),
				"Main Course", true);
		System.out.println(menuItemList);
		for (MenuItem menuItem : menuItemList) {
			if (menuItem.getName().equals("Sandwich")) {
				assertEquals(checkMenuItem, menuItem);
				System.out.println("Sandwich exists in the list!!!");
				System.out.println("");
			}
		}
	}

	/**
	 * Test the implementation using getMenuItemListCustomer() method check if the
	 * number of items in the returned list are correct
	 */
	@Test
	public void testGetMenuItemListCustomerSize() {
		System.out.println("testGetMenuItemListCustomerSize()");
		List<MenuItem> menuItemList = menuItemService.getMenuItemListCustomer();
		assertEquals(4, menuItemList.size());
		System.out.println("The number of items are correct!!!");
		System.out.println("");
	}

	/**
	 * Test the implementation using getMenuItemListCustomer() method check if
	 * French Fries is not present
	 */
	@Test
	public void testGetMenuItemListCustomerNotContainsFrenchFries() {
		System.out.println("testGetMenuItemListCustomerNotContainsFrenchFries()");
		List<MenuItem> menuItemList = menuItemService.getMenuItemListCustomer();
		boolean result = false;
		for (final MenuItem m : menuItemList) {
			if (m.getName().contentEquals("French Fries"))
				result = true;
		}
		assertFalse(result);
		System.out.println("French Fries does not exist in the list!!!");
		System.out.println("");
	}

	/**
	 * Test the implementation using getMenuItem() method Validate if the method in
	 * returns the right menu item based on the id
	 */
	@Test
	public void testGetMenuItem() {
		System.out.println("testGetMenuItem()");
		MenuItem menuItem = menuItemService.getMenuItem(1);
		System.out.println(menuItem);
		assertEquals("Sandwich", menuItem.getName());
		System.out.println("Correct menu item returned!!!");
		System.out.println("");
	}

	/**
	 * Test the implementation using modifyMenuItem() method Validate if the method
	 * in updates the values of a specific menu item
	 */
	@Test
	public void testModifyMenuItem() {
		System.out.println("testModifyMenuItem()");
		MenuItem menuItem = menuItemService.getMenuItem(1);
		System.out.println("Before Modification");
		System.out.println(menuItem);
		MenuItem updatedItem = new MenuItem((long) 1, "Sandwich", (float) 120.0, true,
				DateUtil.convertToDate("15/03/2017"), "Main Course", true);
		menuItemService.modifyMenuItem(updatedItem);
		MenuItem updatedMenuItem = menuItemService.getMenuItem(1);
		System.out.println("After Modification");
		System.out.println(updatedMenuItem);
		assertEquals(updatedItem, menuItemService.getMenuItem(1));
		System.out.println("Menu Item modified successfully!!!");
		System.out.println("");
	}
}
