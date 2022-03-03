package pomRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;


/**
 * 
 * @author Adi rama venkata manoj
 *
 */

public class HomePage {

	public HomePage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath = "//a[text()='Logout']") private WebElement logoutButton;
	
	@FindBy(id="container_users") private WebElement usersModuleLink;

	public WebElement getLogoutButton() {
		return logoutButton;
	}

	public WebElement getUsersModuleLink() {
		return usersModuleLink;
	}

	// Business Logic or Action methods or Behavior
	public void logout() {
		logoutButton.click();
	}
}
