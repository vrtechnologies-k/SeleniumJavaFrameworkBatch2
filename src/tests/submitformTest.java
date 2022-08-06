package tests;

import org.testng.annotations.Test;
import pageObjects.HomePage;
import utilities.BaseClass;
import utilities.ExcelUtils;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
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

	@Test(dataProvider = "formDetails")
	public void formSubmission(String Name, String Email, String Password, String Gender, String DOB) throws Exception {

		HomePage homePage = PageFactory.initElements(driver, HomePage.class);
		
		type(homePage.nameEditBox, Name);
		
		//homePage.nameEditBox.sendKeys("Ramya");

		homePage.emailEditBox.sendKeys(Email);

		Thread.sleep(2000);

		String getattributevalue = homePage.emailEditBox.getAttribute("value");

		homePage.passwordEditBox.sendKeys(Password);

		homePage.checkBox.click();

		new Select(homePage.select).selectByVisibleText(Gender);

		homePage.radiobtn.click();

		homePage.DOB.sendKeys(DOB);

		homePage.submitBtn.click();

		String validationText= homePage.alertMessage.getText();

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
