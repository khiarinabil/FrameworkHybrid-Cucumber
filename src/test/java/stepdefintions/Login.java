package stepdefintions;
import org.openqa.selenium.WebDriver;
import factory.Driverfactory;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pages.HomePage;
import pages.LoginPage;
import pages.MyAccountPage;
import utils.CommonUtlis;

public class Login {
	WebDriver driver;
	private LoginPage loginpage;
	private MyAccountPage myaccountpage ;	
	private CommonUtlis commonUtlis;
	

	@Given("je navigue vers la page login")
	public void je_navigue_vers_la_page_login() {
	driver=	Driverfactory.getDriver();
	HomePage homepage = new HomePage(driver);
	homepage.clickMYAccount();
	loginpage= homepage.selectLoginOption();
	  
	  
		
	}
	@When("je saisi un valide adress mail {string} dans le champ email")
	public void je_saisi_un_valide_adress_mail_dans_le_champ_email(String emailtxt) {
		
		loginpage.saisiMail(emailtxt);
		
	    
	}
	@When("je saisi une valide mot de passe {string} dans le champs mot de passe")
	public void je_saisi_une_valide_mot_de_passe_dans_le_champs_mot_de_passe(String paswtx) {
		
		loginpage.saisiPassword(paswtx);
	}
	@When("je click sur le boutton login")
	public void je_click_sur_le_boutton_login() {
		
		myaccountpage= loginpage.clickloginbtn();
	   
	}
	@Then("un message de success affichè")
	public void un_message_de_success_affichè() {
		
		
		org.junit.Assert.assertTrue(myaccountpage.successmessage.isDisplayed());
	    
	}
	@When("je saisi une adress mail invalide  dans le champ adress mail")
	public void je_saisi_une_adress_mail_invalide_dans_le_champ_adress_mail() {
		commonUtlis = new CommonUtlis();
		loginpage.saisiMail(commonUtlis.getEmailTimesMap());
	}
	@When("je saisi une mot de passe invalide {string} dans le champ mot de passe")
	public void je_saisi_une_mot_de_passe_invalide_dans_le_champ_mot_de_passe(String invalidpasswordtxt) {
		
		loginpage.saisiPassword(invalidpasswordtxt);
	}
	@Then("Le message d erreur s affiche")
	public void le_message_d_erreur_s_affiche() {
		
		org.junit.Assert.assertTrue(myaccountpage.geterreurmessage().contains("Warning: No match for E-Mail Address and/or Password."));
	   
	}
	@When("je saisi pas l adresse mail")
	public void je_saisi_pas_l_adresse_mail() {
		
		loginpage.saisiMail("");
		
	}
	@When("je saisi pas le mot de passe")
	public void je_saisi_pas_le_mot_de_passe() {
		
		loginpage.saisiPassword("");
	}
	

}
