package stepdefintions;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;


import factory.Driverfactory;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pages.SearchPage;
import pages.SearchResultPage;

public class Searche {
	WebDriver driver;
	private SearchResultPage searchresultpage;
	
	
	@Given("je ouvre le application")
	public void je_ouvre_le_application() {
	   driver= Driverfactory.getDriver();
	   
}
	@When("je saisi un valide produit {string} dans le champ de recherche")
	public void je_saisi_un_valide_produit_dans_le_champ_de_recherche(String validproduit) {
		SearchPage searchepage= new SearchPage(driver);
		searchepage.enterproduit(validproduit);
	}
	@When("je click sur le boutton recherche")
	public void je_click_sur_le_boutton_recherche() {
		SearchPage searchepage= new SearchPage(driver);
		searchresultpage= searchepage.clicksearch();
	}
	@Then("le produit est existe")
	public void le_produit_est_existe() {
		
		Assert.assertTrue(searchresultpage.productdisplayed());
	   
	}
	@When("je saisi un invalide produit {string} dans le champ de recherche")
	public void je_saisi_un_invalide_produit_dans_le_champ_de_recherche(String invalidproduit) {
		SearchPage searchepage= new SearchPage(driver);
		searchepage.enterinvalidproduit(invalidproduit);
	}
	@Then("le message de erreur va affiche")
	public void le_message_de_erreur_va_affiche() {
		
		org.junit.Assert.assertEquals("There is no product that matches the search criteria.", driver.findElement(By.xpath("//input[@id='button-search']/following-sibling::p")).getText());
		
	    
	}
	@When("je saisie rien dans le champ de recherche")
	public void je_saisie_rien_dans_le_champ_de_recherche() {
		SearchPage searchepage= new SearchPage(driver);
		searchepage.laissevide();
	}
}