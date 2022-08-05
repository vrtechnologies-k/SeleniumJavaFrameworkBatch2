package commonLibraries;

import org.openqa.selenium.WebElement;

public class commonFunctions {
	
	
	public String type(WebElement element, String value) {
		String status = "";
		try {
			
			if (element.isDisplayed()) {
				
				element.sendKeys(value);
			}
		} catch(Exception e) {
			
			status = e.getMessage();
			
		}
		
		return status;
		
	}

}
