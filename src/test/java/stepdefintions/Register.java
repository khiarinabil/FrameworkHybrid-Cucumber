package stepdefintions;


import java.util.Map;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;


import factory.Driverfactory;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pages.HomePage;
import pages.RegisterPage;
import utils.CommonUtlis;

public class Register {
	WebDriver driver;
	private RegisterPage registerpage;
	private CommonUtlis commonUtlis;
	

	@Given("je navigue vers la page registration")
	public void je_navigue_vers_la_page_registration() {
		driver= Driverfactory.getDriver();
		 HomePage homepage = new HomePage(driver);
		 homepage.clickMYAccount();
		 registerpage = homepage.clickregister();
	}
	@When("je saisi les coordonneè de registation")
	public void je_saisi_les_coordonneè_de_registation(DataTable dataTable) {	
	Map<String, String> datamap = dataTable.asMap(String.class,String.class);
	commonUtlis = new CommonUtlis();
	
	registerpage.saisiNom(datamap.get("firstName"));
	registerpage.saisiprenom(datamap.get("lastName"));
	registerpage.saisiEmaill(commonUtlis.getEmailTimesMap());
	registerpage.saisiphone(datamap.get("telephone"));
	registerpage.saisimotpass(datamap.get("password"));
	registerpage.saisiconfirm(datamap.get("password"));
	
	
	}
	
	@When("je saisi les coordonneè de registatuon avec dublication mail")
	public void je_saisi_les_coordonneè_de_registatuon_avec_dublication_mail(DataTable dataTable) {
	   
		Map<String, String> datamap = dataTable.asMap(String.class,String.class);
		
		registerpage.saisiNom(datamap.get("firstName"));
		registerpage.saisiprenom(datamap.get("lastName"));
		registerpage.saisiEmaill(datamap.get("email"));
		registerpage.saisiphone(datamap.get("telephone"));
		registerpage.saisimotpass(datamap.get("password"));
		registerpage.saisiconfirm(datamap.get("password"));
		
	}
	
	@When("je coche Privacy Policy")
	public void je_coche_privacy_policy() {
		
		registerpage.selectprivicypolice();
	    
	}
	
	@When("je click sur le boutton continu")
	public void je_click_sur_le_boutton_continu() {
		
		registerpage.clickregister();
		
	}
	
	@Then("le compt crer avec succes")
	public void le_compt_crer_avec_succes() {
		
	org.junit.Assert.assertTrue(driver.getCurrentUrl().contains("success"));	
	    
	}
	
	
	@When("je select yes a Newsletter")
	public void je_select_yes_a_newsletter() {
		
		registerpage.selectnewslater();
		
	   
	}
	@Then("Le message d erreur duplicationmail affiche")
	public void le_message_d_erreur_duplicationmail_affiche() {
		
	    org.junit.Assert.assertTrue(registerpage.getduplicationmessage().contains("Warning: E-Mail Address is already registered!"));
	}
	
	
	
	@When("je rempli aucun champ")
	public void je_rempli_aucun_champ() {
		
		registerpage.saisiNom("");
		registerpage.saisiprenom("");
		registerpage.saisiEmaill("");
		registerpage.saisiphone("");
		registerpage.saisimotpass("");
		registerpage.saisiconfirm("");
	    
	}
	
	
	
	@Then("Le message de erreur s affiche")
	public void le_message_de_erreur_s_affiche() {
		RegisterPage registerpage = new RegisterPage(driver);
		org.junit.Assert.assertTrue(registerpage.getmessagewarning().contains("Warning: You must agree to the Privacy Policy!"));
		org.junit.Assert.assertTrue(driver.findElement(By.xpath("//div[contains(text(),'First Name must be between 1 and 32 characters!')]")).getText().contains("First Name must be between 1 and 32 characters!"));
	   
	}
	

	
}
