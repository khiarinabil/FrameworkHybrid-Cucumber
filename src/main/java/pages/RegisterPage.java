package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import utils.CommonUtlis;
import utils.ElementsUtlis;

public class RegisterPage {

	
	WebDriver driver;
	private ElementsUtlis elementutils;
	public RegisterPage(WebDriver driver) {
		
		this.driver=driver;
		PageFactory.initElements(driver, this);
		elementutils = new ElementsUtlis(driver);
	}
	@FindBy(id = "input-firstname")
	WebElement namtxt ;
	
	@FindBy(id = "input-lastname")
	WebElement prenomtxt;
	
	@FindBy(id = "input-email")
	WebElement emailltxt;
	
	@FindBy(id = "input-telephone")
	WebElement telephonetxt ;
	
	@FindBy(id = "input-password")
	WebElement motdepassmtxt ;
	
	@FindBy(xpath = "//input[@value='Continue']")
	WebElement registerbtn;
	
	@FindBy(id = "input-confirm")
	WebElement confirmmotdepasstxt;
	
	@FindBy(xpath ="//input[@name='agree']" )
	WebElement privicypolic;
	
	@FindBy(xpath = "//label[normalize-space()='Yes']//input[@name='newsletter']")
	WebElement newslater;
	
	@FindBy(xpath = "//div[@class='alert alert-danger alert-dismissible']")
	WebElement messagerreur;
	
	@FindBy(xpath = "//div[@class='alert alert-danger alert-dismissible']")
	WebElement messageduplication;
	
	public void saisiNom(String nomtxtt) {
		
		elementutils.TypetxtEnToElement(namtxt, nomtxtt, CommonUtlis.EXPLICIT_WAIT_TIME);
	}
	public void saisiprenom(String prenomtxtt) {
		
		elementutils.TypetxtEnToElement(prenomtxt, prenomtxtt, CommonUtlis.EXPLICIT_WAIT_TIME);
		
	}
	public void saisiEmaill(String mailtx) {
		
		elementutils.TypetxtEnToElement(emailltxt, mailtx, CommonUtlis.EXPLICIT_WAIT_TIME);
		
	}
	
	public void saisiphone(String phonetxt) {
		
		elementutils.TypetxtEnToElement(telephonetxt, phonetxt, CommonUtlis.EXPLICIT_WAIT_TIME);
		
	}
	public void saisimotpass(String motpasstxt) {
		
		elementutils.TypetxtEnToElement(motdepassmtxt, motpasstxt, CommonUtlis.EXPLICIT_WAIT_TIME);
	}
	public void clickregister() {
		
		elementutils.ClickOnElement(registerbtn,CommonUtlis.EXPLICIT_WAIT_TIME);
	}
	public void saisiconfirm(String confir) {
		elementutils.TypetxtEnToElement(confirmmotdepasstxt, confir, CommonUtlis.EXPLICIT_WAIT_TIME);
	}
	public void selectprivicypolice() {
		elementutils.ClickOnElement(privicypolic, CommonUtlis.EXPLICIT_WAIT_TIME);
	}
	public void  selectnewslater() {
		
		elementutils.ClickOnElement(newslater, CommonUtlis.EXPLICIT_WAIT_TIME);
	}
	public String getduplicationmessage() {
		
		return messageduplication.getText();
	}
public String getmessagewarning() {
		
		return messagerreur.getText();
	}
	
}




