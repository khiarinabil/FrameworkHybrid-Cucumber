package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import utils.CommonUtlis;
import utils.ElementsUtlis;

public class SearchPage {
	WebDriver driver;
	private ElementsUtlis elementutlis;
	
	public SearchPage(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver, this);
		elementutlis = new ElementsUtlis(driver);
	}
	
	@FindBy(name = "search")
	WebElement searchtxt;
	
	@FindBy(xpath = "//button[@class='btn btn-default btn-lg']")
	WebElement searchbtn;
	
	@FindBy(xpath = "//input[@placeholder='Search']")
	WebElement productepreuv;
	
	@FindBy(xpath = "//input[@id='button-search']/following-sibling::p")
	WebElement erreurmessage;
	
	
	public void enterproduit(String product) {
		elementutlis.TypetxtEnToElement(searchtxt, product, CommonUtlis.EXPLICIT_WAIT_TIME);
	}
	
	public void enterinvalidproduit(String inproduct) {
		elementutlis.TypetxtEnToElement(searchtxt, inproduct, CommonUtlis.EXPLICIT_WAIT_TIME);
	}
	
	public SearchResultPage clicksearch() {
		elementutlis.ClickOnElement(searchbtn, CommonUtlis.EXPLICIT_WAIT_TIME);
		return new SearchResultPage(driver);
		
	}
	public String geterreurmessage() {
		
		return erreurmessage.getText();
	}
	 
	public void laissevide() {
		searchtxt.click();
		searchtxt.clear();
	}
	
	
	

}
