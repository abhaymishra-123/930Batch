package moduleNameTestNg;

import org.testng.annotations.Test;

public class BuyAProductTest {

		@Test (priority=1)
		public void loginTest() {
			System.out.println("Logged in successfully");
		}
		@Test (priority=2)
		public void searchForProductTest() {
			System.out.println("Product Found");
		}
		@Test (dependsOnMethods= "searchForProductTest")
		public void addProductToCartTest() {
			System.out.println("addProductToCartTest");
		}
		@Test (dependsOnMethods= "searchForProductTest")
		public void paymentTest() {
			System.out.println("Payment was successful");
		}
		@Test (priority=3)
		public void logout() {
			System.out.println("Logged out successfully");
		}
}
