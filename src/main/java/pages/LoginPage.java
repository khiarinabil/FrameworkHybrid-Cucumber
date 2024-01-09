package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import utils.CommonUtlis;
import utils.ElementsUtlis;

public class LoginPage {
	WebDriver driver;
	
	
	private ElementsUtlis elementutils;
	public LoginPage(WebDriver driver) {
		this.driver= driver;
		PageFactory.initElements(driver, this);
		elementutils = new ElementsUtlis(driver);
			
	}

	@FindBy(id = "input-email")
	WebElement mailtxt;
	
	@FindBy(id = "input-password")
	WebElement passwordtxt;
	
	@FindBy(xpath = "//input[@value='Login']")
	WebElement loginbtn;
	
	
	
	public void saisiMail(String emailtxt) {
		elementutils.TypetxtEnToElement(mailtxt, emailtxt, CommonUtlis.EXPLICIT_WAIT_TIME);
	}
	public void saisiPassword(String paswtxt) {
		elementutils.TypetxtEnToElement(passwordtxt, paswtxt, CommonUtlis.EXPLICIT_WAIT_TIME);
	}
	public MyAccountPage clickloginbtn() {
		elementutils.ClickOnElement(loginbtn, CommonUtlis.EXPLICIT_WAIT_TIME);
		return  new MyAccountPage(driver);
	}
}


