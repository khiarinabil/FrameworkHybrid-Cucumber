package utils;

import java.time.Duration;

import org.openqa.selenium.Alert;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ElementsUtlis {
	  WebDriver driver;
	
	public ElementsUtlis(WebDriver driver) {
		
		this.driver=driver;
		
	}
	
	
	public void ClickOnElement(WebElement element, long DurationInSecond) {
		
		
		 WebElement webelemnt = WaitForElment(element, DurationInSecond);
		webelemnt.click();
	}
	
	public void TypetxtEnToElement(WebElement element,String txttobetyped ,long DurationOfSecond) {
		
		
		WebElement webelemnt = WaitForElment(element, DurationOfSecond);
		webelemnt.click();
		webelemnt.clear();
		webelemnt.sendKeys(txttobetyped);
	}
	
	public void SelectOptionInDropDown(WebElement element,String dropDowOption ,long  DurationOfSecond ) {
		WebElement webelement = WaitForElment(element, DurationOfSecond);
	  Select select = new Select(webelement);
	  select.selectByVisibleText(dropDowOption);
	}
	
	public WebElement WaitForElment(WebElement element ,long DurationOfSecond) {
		WebElement webelement= null;
		try {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(DurationOfSecond));
		webelement =wait.until(ExpectedConditions.elementToBeClickable(element));
		}catch(Throwable e) {e.printStackTrace();}
		return webelement;
	}
	
	public Alert waitForAlert(long DurationOdSecond) {
		Alert alert= null;
		try {
		
	WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(DurationOdSecond));
	alert = wait.until(ExpectedConditions.alertIsPresent());}
		catch(Throwable e) {e.printStackTrace();}
	return alert;
	}
	public void acceptAlert(long DurationOdSecond) {
	Alert alert = waitForAlert(DurationOdSecond);
		alert.dismiss();
	
	}
	public void dismissAlert(long DurationOdSecond) {
		Alert alert = waitForAlert(DurationOdSecond);
			alert.accept();
		
		}
	
	public void  mouseHoverAndClick(WebElement element, long DurationOfSecond) {
		
	    WebElement webelement = waitForVisibilityOfEelement(element, DurationOfSecond);
	    Actions  action = new Actions(driver);
	action.moveToElement(webelement).click().build().perform();
	}
	
	public WebElement waitForVisibilityOfEelement(WebElement element,long  DurationOfSecond) {
		WebElement webelement=null;
		try {
		WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(DurationOfSecond) );
	    webelement = wait.until(ExpectedConditions.visibilityOf(element));}catch(Throwable e)
		{e.printStackTrace();}
		return webelement;
	}
	
	public void javaSriptClick(WebElement element, long DurationOfSecond) {
		
		WebElement webelement = waitForVisibilityOfEelement(element, DurationOfSecond);
	  JavascriptExecutor jse = ((JavascriptExecutor)driver);
	  jse.executeScript("arguments[0].click();", webelement);
	}
	
public void javaSriptType(WebElement element, long DurationOfSecond, String txtTobeTyped) {
		
		WebElement webelement = waitForVisibilityOfEelement(element, DurationOfSecond);
	  JavascriptExecutor jse = ((JavascriptExecutor)driver);
	  jse.executeScript("arguments[0].value='"+txtTobeTyped+"';", webelement);
	}


}
