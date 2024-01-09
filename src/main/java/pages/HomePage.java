package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import utils.CommonUtlis;
import utils.ElementsUtlis;

public class HomePage {
	
	WebDriver driver;
	private ElementsUtlis elementutils;
	
	public HomePage(WebDriver driver) {
		this.driver= driver;
		PageFactory.initElements(driver, this);
		elementutils = new ElementsUtlis(driver);
	}
	
	
	@FindBy(xpath = "//a[@title='My Account']")
	WebElement myaccountbtn;
	
	 @FindBy(linkText = "Login")
	 WebElement loginlink;
	 
	 @FindBy(linkText = "Register")
	  WebElement registerlink ;
	 
	
	  
	 public void clickMYAccount() {
		 elementutils.ClickOnElement(myaccountbtn, CommonUtlis.EXPLICIT_WAIT_TIME);
		 
		
	 }
	 public LoginPage  selectLoginOption() {
		 elementutils.ClickOnElement(loginlink, CommonUtlis.EXPLICIT_WAIT_TIME);
		 return new LoginPage(driver);
	 }
	 
	 public RegisterPage clickregister() {
		 
		 elementutils.ClickOnElement(registerlink, CommonUtlis.EXPLICIT_WAIT_TIME);
		 return new RegisterPage(driver);
	 }
	 

}
