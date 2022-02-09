package step_definitions;

import org.junit.Assert;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pages.DemoQADatePickerPage;
import utilities.BrowserUtils;
import utilities.Driver;

public class DemoQADatePickerSteps {
	
	DemoQADatePickerPage datePickerPage = new DemoQADatePickerPage();
	BrowserUtils utils = new BrowserUtils();
	
	@Given("I am on the date picker page {string}")
	public void i_am_on_the_date_picker_page(String url) {
		Driver.getDriver().get(url);
	    Assert.assertTrue(datePickerPage.firstDatePicker.isDisplayed());
	}
	@When("I enter {string} to date picker")
	public void i_enter_to_date_picker(String date) {
		utils.clearValueOnTheField(datePickerPage.firstDatePicker);
	    
		// first approach is to sending the date into input
//		datePickerPage.firstDatePicker.sendKeys(date);
		// second approach is to pick a date
		datePickerPage.firstDatePicker.click();
		
		// split the date into array of strings
		String[] dates = date.split("/");  // 02/01/2006
		// turn the month into int
		String monthOutofArray = dates[0];
		int month = 0;
		if(monthOutofArray.contains("0")) {
		   month = Integer.parseInt(monthOutofArray.substring(1));
		}else {
			month = Integer.parseInt(monthOutofArray);
		}
		
		// get the date out of string array
		String day = "";
		if (dates[1].contains("0")) {
			day = dates[1].substring(1);
		}else {
			day = dates[1];
		}
		String year = dates[2];
		
		datePickerPage.pickADate(year, month -1, day);
	}
		
	@Then("Date entered should be selected")
	public void date_entered_should_be_selected() {
	    System.out.println("Entered date is :" + datePickerPage.firstDatePicker.getAttribute("value"));
	    
	}

}
