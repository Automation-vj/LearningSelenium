package Learning;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Screenshot {


	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub

		//config chrome browser	(check chrome browser version and driver version https://chromedriver.chromium.org/downloads)
	    System.setProperty("webdriver.chrome.driver", "C:\\Users\\Vikash\\Documents\\selenium project config\\chromedriver_win32\\chromedriver.exe");		
			
		//to launch a chromebrowser
		 WebDriver driver=new ChromeDriver();
		
		//open airtel login page
		driver.get("https://www.airtel.in/s/selfcare?normalLogin");
		
		
		File src= ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		
		FileUtils.copyFile(src, new File("C:\\Users\\Vikash\\eclipse-workspace\\screenshot.png"));
		
		
		
	}

}