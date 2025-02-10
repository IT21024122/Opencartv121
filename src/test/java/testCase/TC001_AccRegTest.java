package testCase;

import org.testng.Assert;
import org.testng.annotations.Test;

import pageObjects.AccountRegisterationPage;
import pageObjects.HomePage;
import testBase.BaseClass;

public class TC001_AccRegTest extends BaseClass{

	
	
	
	@Test(groups={"Regression","Master"})
	public void verify_account_registration()
	{
		logger.info("***    Starting TC001_AccRegTest ****");
		
		try
		{
		HomePage hp=new HomePage(driver);
		
		hp.clickMyaccount();
		hp.clickRegister();
		
		logger.info("Clicked on register link");
		
		AccountRegisterationPage regpage=new AccountRegisterationPage(driver);
		
		regpage.setFirstname(randomString().toUpperCase());
		regpage.setLastName(randomString().toUpperCase());
		regpage.setEmail(randomString()+"@gmail.com");
		regpage.setTelephone(randomNumber());
		
		String passwordd=randomePassword();
		
		regpage.setPassword(passwordd);
		regpage.setConfirmPassword(passwordd);
		
		regpage.setPrivacyPolicy();
		regpage.setclickContinue();
		
		String confmsg=regpage.getConfirmationMsg();
		Assert.assertEquals(confmsg, "Your Account Has Been Created!");
	}
	catch(Exception e)
	{
		logger.error("test faild..");
		logger.debug("degug logs..");
		Assert.fail();
	}
	
	}
	
	
}
