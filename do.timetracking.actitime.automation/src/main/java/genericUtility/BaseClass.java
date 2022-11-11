package genericUtility;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;

import io.github.bonigarcia.wdm.WebDriverManager;
import pomRepository.HomePage;
import pomRepository.LoginPage;

public class BaseClass {
	
	public WebDriver driver;
	public FileUtility fUtils=new FileUtility();
	
	@BeforeSuite
	public void bsConfig() {
		System.out.println("Data Base Connection Has Been Estblashed");
	}
	@BeforeClass
	public void bcConfig() throws IOException {
		
		  String url = fUtils.fetchDataFromPropertyFile("url");
		WebDriverManager.chromedriver().setup();
		driver=new ChromeDriver();
		System.out.println("The Browser Has Been Launched");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		driver.get(url);
		
	}
	
	@BeforeMethod
	public void bmConfig() throws IOException {
		String username= fUtils.fetchDataFromPropertyFile("username");
		String password = fUtils.fetchDataFromPropertyFile("password");
		
		LoginPage login = new LoginPage(driver);
		login.loginAction(username, password);
		System.out.println("Login is Successful");
		
	}
	
	@AfterMethod
	public void amConfig() {
		HomePage home = new HomePage(driver);
		home.logoutAction();
	}
	
	@AfterClass
	public void acConfig() {
		driver.quit();
	}
	
	@AfterSuite
	public void asConfig() {
		System.out.println("Data Base Connection Has Been Closed");
	}
}
