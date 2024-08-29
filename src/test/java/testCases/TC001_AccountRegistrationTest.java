package testCases;

import java.time.Duration;

import org.apache.commons.lang3.RandomStringUtils;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import pageObjects.AccountRegistrationPage;
import pageObjects.HomePage;
import testBase.BaseClass;

public class TC001_AccountRegistrationTest extends BaseClass{
	
//	public WebDriver driver;
//	
//	@BeforeClass
//	public void setup()
//	{
//		driver = new ChromeDriver();
//		driver.manage().deleteAllCookies();
//		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
//		
//		driver.get("http://localhost/opencart/upload/");
//		driver.manage().window().maximize();
//	}
//	
//	@AfterClass
//	public void tearDown()
//	{
//		driver.quit();
//	}
	
	@Test(groups={"Regression","Master"})
	public void verify_account_registration()
	{
		//
		logger.info("*** Starting TC001_AccountRegistrationTest ***");
		try
		{
		//
		
		HomePage hp = new HomePage(driver);
		hp.clickMyAccount();
		logger.info("Clicked on MyAccount Link");
		
		hp.clickRegister();
		logger.info("Clicked on Register Link");
		
		AccountRegistrationPage regpage = new AccountRegistrationPage(driver);
		
		logger.info("Providing customer details...");
		regpage.setFirstName(randomeString().toUpperCase());
		regpage.setLastName(randomeString().toUpperCase(null));
		regpage.setEmail(randomeString()+"@gmail.com"); //randomy generated the 
		regpage.setTelephone(randomeString());
		
		//String password = randomeAlphaNumeric();
		
		String password = randomeAphaNumberic();
		
		regpage.setPassword(password);
		regpage.setConfirmPassword(password);
		
		regpage.setPrivacyPolicy();
		regpage.clickContinue();
		
		logger.info("Validating expected message...");
		String confmsg = regpage.getConfirmationMsg();
		Assert.assertEquals(confmsg,"Your Account Has Been Created!");
		
		}
		catch(Exception e)
		{
			logger.info("Test failed...");
			//logger.debug("Debug logs...");
			Assert.fail();
		}
		
		logger.info("*** Finished TC001_AccountRegistrationTest ***");
	}
		//write this code after hard code syntax for randome value above the code
//		public String randomeString()
//		{
//			String generatedstring = RandomStringUtils.randomAlphabetic(5);
//			return generatedstring;
//		}
//		
//		public String randomeNumber()
//		{
//			String generatednumber = RandomStringUtils.randomNumeric(10);
//			return generatednumber;
//		}
//		
//		public String randomeAphaNumberic()
//		{
//			String generatedstring = RandomStringUtils.randomAlphabetic(5);
//			String generatednumber = RandomStringUtils.randomNumeric(10);
//			return (generatedstring + "@" + generatednumber);
//		}
		
	

}
