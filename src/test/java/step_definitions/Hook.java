package step_definitions;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import utilities.Driver;

public class Hook {
	
	// before hook get called before every scenario
	@Before
	public void setup() {
		Driver.getDriver()
		.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		Driver.getDriver().manage().window().maximize();
	}
	
	// after hook gets called after each scenario execution
	// if scenario fails, this method takes a screenshot
	// and attaches the screenshot into the report
	// if the scenario doesn't fails, after hook just quits the driver
	@After
	public void tearDown(Scenario scenario) {
		if (scenario.isFailed()) {
			final byte[] screenshot = ((TakesScreenshot) 
					Driver.getDriver()).getScreenshotAs(OutputType.BYTES);
			scenario.attach(screenshot, "image/png", "screenshot");
		}
		Driver.quitDriver();
		
	}

}
