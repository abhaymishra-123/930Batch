package taskTest;

import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.testng.Assert;
import org.testng.annotations.Test;

import genericUtility.BaseClass;
import genericUtility.ExcelUtility;
import pomRepository.CustomerDetailsPage;
import pomRepository.HomePage;
import pomRepository.TaskPage;

public class CreateCustomerTest extends BaseClass {
	
	@Test
	public void createCustomerAndVerifyCustomerNameTest() throws EncryptedDocumentException, IOException {
		
		ExcelUtility eUtils = new ExcelUtility();
		String excepctedCustomerName = eUtils.fetchDataFromExcelSheet("Sheet2", 1, 0);
		String description= eUtils.fetchDataFromExcelSheet("Sheet2", 1, 0);
		
		HomePage home = new HomePage(driver);
		home.clickOnTaskButton();
		
		TaskPage task = new TaskPage(driver);
		task.createCustomerAction(excepctedCustomerName, description);
		
		CustomerDetailsPage customer = new CustomerDetailsPage(driver);
		String actualCustomerName=customer.verifyCustomerName(excepctedCustomerName);
		
		Assert.assertEquals(actualCustomerName, excepctedCustomerName);
		System.out.println("Pass: Customer Has Been Vefrified");
		
		
	}

}
