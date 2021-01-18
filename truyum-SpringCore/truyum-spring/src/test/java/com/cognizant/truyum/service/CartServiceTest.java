package com.cognizant.truyum.service;

import static org.junit.Assert.assertTrue;
import java.util.ArrayList;
import java.util.List;
import org.junit.Before;
import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.ImportResource;
import com.cognizant.truyum.dao.CartEmptyException;
import com.cognizant.truyum.model.MenuItem;

@ImportResource({ "spring-config.xml" })
@Configuration
public class CartServiceTest {

	/**
	 * instance variable
	 */
	private CartService cartService;

	/**
	 * to initialize the service 
	 * This method gets the cartService bean from the annotations defined 
	 * and loads them into the Spring Container 
	 * creates a new instance of AnnotationConfigApplicationContext 
	 * Invokes scan() and refresh() method in context
	 */
	@Before
	public void initializeService() {
		AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext();
		context.scan("com.cognizant.truyum");
		context.refresh();
		cartService = context.getBean(CartService.class);
		context.close();
	}

	/**
	 * Test the implementation of getAllCartItems() method Validate if method throws
	 * exception when there are no items in cart
	 * 
	 * @throws CartEmptyException
	 */

	@Test
	public void testgetAllCartItems() throws CartEmptyException {
		System.out.println("testgetAllCartItems()");
		List<MenuItem> menuItemList = cartService.getAllCartItems(1);
		assertTrue(menuItemList.isEmpty());
		System.out.println("CartEmptyException thrown successfully!!!");
		System.out.println("");
	}

	/**
	 * Test the implementation of addCartItem() method Validate if method adds an
	 * item into the cart.
	 * 
	 * @throws CartEmptyException
	 */
	@Test
	public void testaddCartItem() throws CartEmptyException {
		System.out.println("testaddCartItem()");
		List<MenuItem> menuItemList;
		menuItemList = cartService.getAllCartItems(2);
		System.out.println("Before adding new menuitem");
		System.out.println(menuItemList);
		cartService.addCartItem(2, 5);
		List<MenuItem> menuItemUpdatedList;
		menuItemUpdatedList = cartService.getAllCartItems(2);
		System.out.println("After adding new menuitem");
		System.out.println(menuItemUpdatedList);
		boolean result = false;
		for (MenuItem m : menuItemUpdatedList) {
			if (m.getName().contentEquals("Chocolate Brownie")) {
				result = true;
			}
		}
		assertTrue(result);
		System.out.println("Successfully added menuitem to the cart!!!");
		System.out.println("");

	}

	/**
	 * Test the implementation of removeCartItem() method check if item added
	 * already is getting removed or not
	 * 
	 * @throws CartEmptyException
	 */
	@Test
	public void testremoveCartItem() throws CartEmptyException {
		System.out.println("testremoveCartItem()");
		List<MenuItem> menuItemList;
		cartService.addCartItem(1, 1);
		menuItemList = cartService.getAllCartItems(1);
		System.out.println("Before removing new menuitem");
		System.out.println(menuItemList);
		cartService.removeCartItem(1, 1);
		System.out.println("After removing new menuitem");
		System.out.println(menuItemList);
		List<String> menuItems = new ArrayList<String>();
		for (int i = 0; i < menuItemList.size(); i++) {
			menuItems.add(menuItemList.get(i).getName());
		}

		assertTrue(!menuItems.contains("Sandwich"));
		System.out.println("Successfully removed menuitem from the cart!!!");
		System.out.println("");
	}
}
