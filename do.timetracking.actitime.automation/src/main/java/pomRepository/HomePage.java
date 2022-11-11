package pomRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomePage {
	
	public HomePage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(id="container tasks")
	private WebElement taskButton;
	
	@FindBy(xpath="//a[text()='Logout']")
	private WebElement logoutLink;

	public WebElement getTaskButton() {
		return taskButton;
	}

	public WebElement getLogoutLink() {
		return logoutLink;
	}
	
	public void clickOnTaskButton() {
		taskButton.click();
	}

	public void logoutAction() {
		logoutLink.click();
	}
}
