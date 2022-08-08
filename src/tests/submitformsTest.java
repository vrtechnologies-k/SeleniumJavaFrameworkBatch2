package tests;

import org.testng.annotations.Test;
import pageObjects.HomePage;
import utilities.BaseClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import java.io.File;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;
import org.testng.Reporter;
import org.testng.annotations.AfterClass;

public class submitformsTest extends BaseClass {

	private WebDriver driver;

	@BeforeClass
	public void setup() throws Exception {

		driver = invokeBrowser();
	}

	@Test(dataProvider = "formDetails")
	public void formSubmission(String Name, String Email, String Password, String Gender, String DOB) throws Exception {

		HomePage homePage = PageFactory.initElements(driver, HomePage.class);

		//type(homePage.nameEditBox, Name);

		homePage.nameEditBox.sendKeys(Name);
		
		
		Reporter.log("user enter the name");

		homePage.emailEditBox.sendKeys(Email);
		
		Reporter.log("user enter the email");

		Thread.sleep(2000);

		String getattributevalue = homePage.emailEditBox.getAttribute("value");

		homePage.passwordEditBox.sendKeys(Password);
		
		Reporter.log("user enter the password");

		homePage.checkBox.click();
		
		Reporter.log("click on the checkbox");

		new Select(homePage.select).selectByVisibleText(Gender);
		
		Reporter.log("select the gender: "+Gender);

		homePage.radiobtn.click();
		
		Reporter.log("click on the radio button");

		homePage.DOB.sendKeys(DOB);
		
		Reporter.log("enter DOB");

		homePage.submitBtn.click();
		
		Reporter.log("click on submit");

		String validationText= homePage.alertMessage.getText();

		//Assert.assertEquals("The Form has been submitted successfully", validationText);

		Thread.sleep(4000);
		
		Reporter.log("Validation message is :"+validationText);
		
		File file = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		
		FileUtils.copyFile(file, new File("Screenshots//screenshot.png"));
		
		/*
		 * File scrFile = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		 * 
		 * File destFile = new File("Screenshots//screenshot.png");
		 * FileUtils.copyFile(scrFile, destFile);
		 * 
		 * Reporter.
		 * log("<a target = \"_blank\" href=\"D:\\TrainingProjects\\SeleniumJavaFrameworkBatch-2\\Screenshots\\screenshot.png\">screenshot</a>"
		 * );
		 */
		
		Reporter.log("<a target = \"_blank\" href=\"D:\\TrainingProjects\\SeleniumJavaFrameworkBatch-2\\Screenshots\\screenshot.png\">screenshot</>");
		
		driver.navigate().refresh();

	}

	@AfterClass
	public void tearDown() {

		driver.quit();
	}
	
	@DataProvider(name = "formDetails")
	public Object[][] formDetails() {
		
		return new Object[][] {{"Ramya","Ramya@gmail.com","Ramya@123","Female","01-01-1988"},{"Venkat","Venkat@gmail.com","Venkat@123","Male","01-08-1988"}};	
	}

}
