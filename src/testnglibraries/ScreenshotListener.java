package testnglibraries;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.testng.ITestResult;
import org.testng.Reporter;
import org.testng.TestListenerAdapter;

public class ScreenshotListener extends TestListenerAdapter {

	public static WebDriver driver;

	@Override
	public void onTestFailure(ITestResult result) {
		Calendar calendar = Calendar.getInstance();
		SimpleDateFormat formater = new SimpleDateFormat("dd_MM_yyyy_hh_mm_ss");
		String methodName = result.getName();
		if(!result.isSuccess()){
			File scrFile = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
			try {
				//File destFile = new File("Screenshots//"+methodName+"_"+formater.format(calendar.getTime())+".png");

				File destFile = new File("Screenshots//screenshot.png");
				
				FileUtils.copyFile(scrFile, destFile);
				//FileUtils.copyFile(scrFile, destFile);
				Reporter.log("<a target = \"_blank\" href=\"D:\\TrainingProjects\\SeleniumJavaFrameworkBatch-2\\Screenshots\\screenshot.png\">screenshot</a>");
				//Reporter.log("<a href='"+ destFile.getAbsolutePath() + "'> <img src='"+ destFile.getAbsolutePath() + "' height='100' width='100'/> </a>");
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}
}
