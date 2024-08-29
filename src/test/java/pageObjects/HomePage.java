package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class HomePage extends BasePage{
	
	
	public HomePage(WebDriver driver)
	{
		super(driver);
	}
	
@FindBy(xpath="//span[normalize-space()='My Account']")
WebElement InkMyaccount;

@FindBy(xpath="//a[normalize-space()='Register']")
WebElement InkRegister;

/////
@FindBy(linkText = "Login")	//Login link added in step
WebElement linkLogin;


public void clickMyAccount()
{
	InkMyaccount.click();
}

public void clickRegister()
{
	InkRegister.click();
}

public void clicklogin()
{
	linkLogin.click();
}

}
