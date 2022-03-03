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


public class LoginPage {
	
	public WebDriver driver;
	
	public LoginPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
		this.driver = driver;
	}
	
	@FindBy(id="username") private WebElement usernameTextField;
	
	@FindBy(name="pwd") private WebElement passwordTextField;
	
	@FindBy(id="loginButton") private WebElement loginButton;

	public WebElement getUsernameTextField() {
		return usernameTextField;
	}

	public WebElement getPasswordTextField() {
		return passwordTextField;
	}

	public WebElement getLoginButton() {
		return loginButton;
	}
	
	//Business Logic or Action methods or Behavior
	public HomePage login(String username, String password) {
		usernameTextField.sendKeys(username);
		passwordTextField.sendKeys(password);
		loginButton.click();
		
		//landing Page Object
		return new HomePage(driver);
	}
}
