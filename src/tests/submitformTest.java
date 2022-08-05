package tests;

import org.testng.annotations.Test;
import pageObjects.HomePage;
import utilities.BaseClass;
import org.testng.annotations.BeforeClass;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.AfterClass;

public class submitformTest extends BaseClass {

	private WebDriver driver;

	@BeforeClass
	public void setup() throws Exception {
		
		driver = invokeBrowser();
	}

	@Test
	public void formSubmission() throws Exception {

		HomePage homePage = PageFactory.initElements(driver, HomePage.class);
		
		type(homePage.nameEditBox, "Ramya");
		
		//homePage.nameEditBox.sendKeys("Ramya");

		homePage.emailEditBox.sendKeys("ramya@gmail.com");

		Thread.sleep(2000);

		String getattributevalue = homePage.emailEditBox.getAttribute("value");

		System.out.println(getattributevalue);

		homePage.passwordEditBox.sendKeys("Password!1");

		homePage.checkBox.click();

		new Select(homePage.select).selectByVisibleText("Female");

		homePage.radiobtn.click();

		homePage.DOB.sendKeys("02-06-1990");

		homePage.submitBtn.click();

		String validationText= homePage.alertMessage.getText();

		System.out.println(validationText); 

		//Assert.assertEquals("The Form has been submitted successfully", validationText);

		Thread.sleep(4000);

	}

	@AfterClass
	public void tearDown() {

		driver.quit();
	}

}
