package step_definitions;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import junit.framework.Assert;
import pages.AmazonSearchPage;
import utilities.Driver;
import utilities.PropertiesReader;

public class AmazonSearchSteps {
	
	
	AmazonSearchPage searchPage = new AmazonSearchPage();
	
	
	// Amazon search#Starts
	
	@Given("I am on the amazon home page")
	public void i_am_on_the_amazon_home_page() {
		Driver.getDriver().get(PropertiesReader.getProperty("amazonUrl"));	
		
	}
	@When("I search item {string}")
	public void i_search_item(String item) {
		searchPage.searchBox.sendKeys(item);
	    
	}
	@When("I click search")
	public void i_click_search() {
		searchPage.searchBtn.click();
		
	    
	}
	@Then("Searched item {string} should be displayed in the search bar")
	public void searched_item_should_be_displayed_in_the_search_bar(String item) {
		String wholeText = searchPage.searchedItemText.getText();
		String trimmedText = wholeText.substring(1,wholeText.length()-1);
		Assert.assertEquals(trimmedText, item);
		
	}




}
