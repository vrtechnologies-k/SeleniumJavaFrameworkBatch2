package tests;

import org.testng.annotations.Test;
import pageObjects.HomePage;
import utilities.BaseClass;
import utilities.ExcelUtils;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.AfterClass;

public class submitformTest extends BaseClass {

	private WebDriver driver;
	
	private static Logger logger = Logger.getLogger("tests");

	@BeforeClass
	public void setup() throws Exception {
		
		PropertyConfigurator.configure("config/log4j.properties");
		
		driver = invokeBrowser();
		
		logger.info("user laumch the browser");
	}

	@Test(dataProvider = "formDetails")
	public void formSubmission(String Name, String Email, String Password, String Gender, String DOB) throws Exception {

		HomePage homePage = PageFactory.initElements(driver, HomePage.class);
		
		type(homePage.nameEditBox, Name);
		
		//homePage.nameEditBox.sendKeys("Ramya");
		
		logger.info("enter the name in the name edit box");

		homePage.emailEditBox.sendKeys(Email);

		Thread.sleep(2000);
		
		logger.info("enter the email in the Email edit box");

		String getattributevalue = homePage.emailEditBox.getAttribute("value");

		logger.info("Attiribute Value is:"+getattributevalue);
		
		homePage.passwordEditBox.sendKeys(Password);
		
		logger.info("enter the password in the password edit box");

		homePage.checkBox.click();
		
		logger.info("click on the checkbox");

		new Select(homePage.select).selectByVisibleText(Gender);
		
		logger.info("Select Male from the gender dropdown");

		homePage.radiobtn.click();
		
		logger.info("click on the radio button");

		homePage.DOB.sendKeys(DOB);
		
		logger.info("Enter the DOB in Date of Birthday Calendar");

		homePage.submitBtn.click();
		
		logger.info("Click on the submit button");

		String validationText= homePage.alertMessage.getText();
		
		logger.info("Alert Message is:"+validationText);

		//Assert.assertEquals("The Form has been submitted successfully", validationText);

		Thread.sleep(4000);
		
		driver.navigate().refresh();

	}

	@AfterClass
	public void tearDown() {

		driver.quit();
	}
	
	@DataProvider
	//@DataProvider(name = "formDetails")
	  public static Object[][] formDetails() throws Exception {

	        // The number of times data is repeated, test will be executed the same no. of times

	        // Here it will execute two times

	       // return new Object[][] {{"Ramya", "Ramya@gmail.com","Ramya@123","Female","01-01-1988" }, {"Venkat", "Venkat@gmail.com","Venkat@123","Male","01-08-1988" }};

		Object[][] testobjectarray = ExcelUtils.getTableArray("D:\\TrainingProjects\\SeleniumJavaFrameworkBatch-2\\TestData\\formSubmission.xls", "submitForm");
		
		System.out.println(testobjectarray);
		
		return testobjectarray;
		
	  }
}
