package pageObjects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class HomePage {
	
	@FindBy(name = "name")
	public WebElement nameEditBox;
	
	@FindBy(name = "email")
	public WebElement emailEditBox;
	
	@FindBy(id = "exampleInputPassword1")
	public WebElement passwordEditBox;
	
	@FindBy(id = "exampleCheck1")
	public WebElement checkBox;
	
	@FindBy(id = "exampleFormControlSelect1")
	public WebElement select;
	
	@FindBy(id = "inlineRadio2")
	public WebElement radiobtn;
	
	@FindBy(name = "bday")
	public WebElement DOB;
	
	@FindBy(css = "[value='Submit']")
	public WebElement submitBtn;
	
	@FindBy(css = "div[class*='alert-success1']")
	public WebElement alertMessage;
	
	

}
