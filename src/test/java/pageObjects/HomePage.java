package pageObjects;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class HomePage extends BasePage{

	WebDriverWait wait;
	public HomePage(WebDriver driver)
	{
		super(driver);
		this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
	}
	
	
	
	@FindBy(xpath="//span[normalize-space()='My Account']")
	WebElement lnkMyaccount;
	
	@FindBy(xpath="//ul[@class='dropdown-menu dropdown-menu-right']//a[normalize-space()='Register']")
	WebElement linkRegister;
	
	@FindBy(linkText="Login")
	WebElement linkLogin;
	
	@FindBy(xpath="//input[@placeholder='Search']")
	WebElement txtSearchbox;
	
	@FindBy(xpath="//button[@class='btn btn-default btn-lg']")
	WebElement btnSearch;
	
	
	public void clickMyaccount()
	{
		try {
			wait.until(ExpectedConditions.elementToBeClickable(lnkMyaccount)).click();
		} catch (Exception e) {
			System.out.println("Exception occurred while clicking 'My Account': " + e.getMessage());
		}

	}
	
	/*public void clickRegister()
	{
		linkRegister.click();
	}
	*/
	// Click "Register" link
		public AccountRegisterationPage clickRegister() {
			try {
				wait.until(ExpectedConditions.elementToBeClickable(linkRegister)).click();
				return new AccountRegisterationPage(driver);
			} catch (Exception e) {
				System.out.println("Exception occurred while clicking 'Register': " + e.getMessage());
				return null;
			}
		}
	
	
	
	
	
	
	
	/*public void clickLogin()
	{
		linkLogin.click();
	}
	*/
		
	public  LoginPage clickLogin() {
		try {
			wait.until(ExpectedConditions.elementToBeClickable(linkLogin)).click();
			return new LoginPage(driver);
		} catch (Exception e) {
			System.out.println("Exception occurred while clicking 'Login': " + e.getMessage());
			return null;
		}
	}
		
		
		
		
	
	/*public void enterProductName(String pName)
	{
		txtSearchbox.sendKeys(pName);
	}
	*/
	
	public  void enterProductName(String pName) {
		try {
			wait.until(ExpectedConditions.visibilityOf(txtSearchbox)).sendKeys(pName);
			
		} catch (Exception e) {
			System.out.println("Exception occurred while entering product name: " + e.getMessage());
			
		}
	}
	
	
	/*
	public void searchbtnclick()
	{
		btnSearch.click();
	}
	*/
	
	
	public SearchResultsPage clickSearch() {
		try {
			wait.until(ExpectedConditions.elementToBeClickable(btnSearch)).click();
			return new SearchResultsPage(driver);
		} catch (Exception e) {
			System.out.println("Exception occurred while clicking search: " + e.getMessage());
			return null;
		}
	}
	
	
	
	
	
}
