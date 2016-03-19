package andersTest;

import static org.junit.Assert.*;

import org.junit.*;
/**
 * @author Amruta
 * Selenium test for adding and verifying orders for demo2.shoop.io
 * 
 * This test will first add a couple items to cart and checkout those items
 * Next it will go to the admin page to verify the latest order was received and the items are correct
 * And then will create a shipment
 */

public class ordersTest {

	@Test
	public void testViewOrder() throws Exception
	{
		seleniumWrapper sel = new seleniumWrapper();
		sel.homePage();
		sel.addtoCart(".//*[@id='product-3370']/a/div[2]/div[1]");
		String textItem1 = sel.getText("html/body/main/div/div/div[1]/div[3]/div[1]/p[1]/small");
		sel.homePage();
		sel.addtoCart(".//*[@id='product-20']/a/div[2]/div[1]");
		String textItem2 = sel.getText("html/body/main/div/div/div[1]/div[3]/div[1]/p[1]/small");
		sel.homePage();
		sel.checkout();		
		
		Thread.sleep(2000);
		sel.login();
		
		sel.clickMenu(".//*[@id='main-menu']/div/ul/li[8]/a/span");
		Thread.sleep(2000);
		sel.clickXpath(".//*[@id='picotable']/div/table/tbody/tr[1]/td[2]/a");
		sel.clickXpath(".//*[@id='main-content']/div[2]/div/div[1]/div/a[3]");
	
		String textOrder1 = sel.getText(".//*[@id='order-contents-section']/div[2]/div/div[1]/table/tbody/tr[1]/td[1]");
		String textOrder2 = sel.getText(".//*[@id='order-contents-section']/div[2]/div/div[1]/table/tbody/tr[2]/td[1]");
		
		//To verify the product ids
		assertEquals(textItem1,textOrder1);
		assertEquals(textItem2,textOrder2);
		
		sel.createShipment();
		sel.close();
	}
	
	
}
