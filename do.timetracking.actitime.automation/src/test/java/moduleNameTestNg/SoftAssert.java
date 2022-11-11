package moduleNameTestNg;

import org.testng.annotations.Test;


public class SoftAssert {

		@Test
		public void demo() {

			String expectedResult= "abc";
			String actualResult= "def";
		
			org.testng.asserts.SoftAssert soft= new org.testng.asserts.SoftAssert();
			soft.assertEquals(actualResult, expectedResult);
			soft.assertAll();
		
		}
	}
     

