package Learning;

import static org.testng.AssertJUnit.assertEquals;
import java.time.Duration;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import graphql.Assert;

public class LoginPage {

	public static void main(String[] args) {

/*Learmning scope-
 Done-
 launch browser,
 actions class, 
 select class, 
 get text, 
 xpath, 
 implicitly wait, 
 isdisplayed,
 isenabled, 
 isselected, 
 navigation command,
 image present or not, 
 assert title page,
 assert image, 
 getWindowHandles(),
 getWindowHandle(),
 findelements,
 explicit wait, inprogress*
 handle ajax calls, inprogress*
 capturescreenshot, pending*
 
 
 Pending->>>>
 scroll to element, ***
 fluent wait, ***
 css selector, ***
 handle hidden elements, ***
 find broken links, ***
 upload a file, ***
 download file, ***
 switch between iframe,p
 use testng annotations,p
 testng assert,p
 tab window and window handles- pending,
 excel sheet reading -p ,
 parallel testing-p ,
 batch testing-p,
 cross browser testing-p,
 get an attribute value-p,
 press enter keys-p,
 deleteAllCookies();-p,
 popup alerts-p,
*/
		
		
	//config chrome browser	(check chrome browser version and driver version https://chromedriver.chromium.org/downloads)
    System.setProperty("webdriver.chrome.driver", "C:\\Users\\Vikash\\Documents\\selenium project config\\chromedriver_win32\\chromedriver.exe");		
		
	//to launch a chromebrowser
	WebDriver driver=new ChromeDriver();
	
	//navigate to google url
	driver.navigate().to("https:\\www.google.com");
	
	//maximize window
	driver.manage().window().maximize();
	
	// enter into google field	 
	driver.findElement(By.xpath("//input[@class='gLFyf gsfi']")).sendKeys("airtel" + "\n");
	
	//implicitly wait 
	driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
	 
	//click on element to open airtel link
	driver.findElement(By.xpath("//div[@class='yuRUbf']//a[@href='https://www.airtel.in/']")).click();
	 

	//to check script driver.findElement(By.xpath("//a[@href='https://www.airtel.in/prepaid-recharge/?icid=header']")).click();
	 
	// open buy xstream
	driver.findElement(By.xpath("//div[@class='quick-actions-container']//a[@href='https://www.airtel.in/xstream/box?icid=quick_action']")).click();
	
    //id="region"
	//Select select= new Select(driver.findElement(By.name("selection")));
	
	//select option from dropdown 
	Select select= new Select(driver.findElement(By.id("region")));
	select.selectByVisibleText("Delhi");
	
	//mouse hover to top menu prepaid
	Actions action= new Actions(driver);
	action.moveToElement(driver.findElement(By.xpath("//div[@class='actions-list-container']"))).build().perform();
	
	//handle mousehover- hover to top menu postpaid
	Actions action1= new Actions(driver);
	action1.moveToElement(driver.findElement(By.xpath("//div[@class='actions-list-container']//h3[text()='POSTPAID']"))).build().perform();
	
    //handle dropdown- select noida option
	Select select1=new Select(driver.findElement(By.name("selection")));
	select1.selectByVisibleText("Noida");
	
	//get text of webelement
	//String text=driver.findElement(By.xpath("//div[@class='hidden-xs hidden-sm']//h3[text()='Jo Dekho, Bada Dekho']")).getText();
	//System.out.println(text);
	
	//check if any element is displayed or not -isdisplayed
    boolean element = driver.findElement(By.xpath("//button[@id='submit']")).isDisplayed();
	System.out.println(element);
	
	// open another page
	driver.navigate().to("https://www.airtel.in/myplan-infinity/submit-form");
	
	//check if button is enabled or not like when checkbox is marked then agree button enabled , so check for buttons-> isenabled()
    boolean button=	driver.findElement(By.xpath("//div[@class='submitbtn']")).isEnabled();
	System.out.println(button);
	
	//check radio button, checkbox and dropdown selected or not -isSelected()
	boolean radio= driver.findElement(By.xpath("//div[@class='helpyou']//label[@for='NEW']")).isSelected();
	System.out.println(radio);
	
	//navigate commands
	driver.navigate().refresh();
	driver.navigate().back();
	driver.navigate().forward();
	
	//get all links	
	int link= driver.findElements(By.tagName("//a")).size();
	System.out.println(link);
	
	//get url of current window
    String url=	driver.getCurrentUrl();
    System.out.println(url);	

	//get title of page
    String title=	driver.getTitle();
	System.out.println(title);
	
	//back
	driver.navigate().back();
	
	//scroll to web element 
	//The executeScript() method from the JavascriptExecutor Interface can invoke multiple arguments in the form of arguments[0], arguments[1], etc
	WebElement terms= driver.findElement(By.xpath("//div[@class='col-sm-12']//a[text()='Terms & Conditions']"));
	JavascriptExecutor js = (JavascriptExecutor)driver;
	js.executeScript("arguments[0].scrollIntoView();",terms);
	
	//extract text and verify
	System.out.println(terms.getText());
	
	//check if an image is displayed- by help of Javascript Executor and executeScript method
	WebElement logo= driver.findElement(By.xpath("//img[@class='brand']"));
	Boolean p = (Boolean) ((JavascriptExecutor)driver).executeScript("return arguments[0].complete && typeof arguments[0].naturalWidth != \"undefined\" && arguments[0].naturalWidth > 0", logo);
		
    // Javascript executor to check image 
	//verify if status is true
	if (p) 
	{System.out.println("Logo present");}
	else 
	{System.out.println("Logo not present");}		      		      
		      
    //assert image 
	boolean imagepresent= driver.findElement(By.xpath("//img[@class='brand']")).isDisplayed();
	System.out.println(imagepresent);
	boolean expected = true;
	assertEquals(imagepresent,expected);
	System.out.println("assert for image working");	
		
	//assert title page
	String actualTitle=driver.getTitle();
	String expectedTitle="Buy Android TV Box - Smart TV Set Top Box with Price - Airtel Xstream";
	assertEquals(actualTitle,expectedTitle);
	System.out.println("assert for title working");
		      
	//new window tab
	driver.findElement(By.xpath("//a[@onclick='onclickfaq()']")).click();
			
	//switch window tab start	   
	//It will return the parent window name as a String
	String parent=driver.getWindowHandle();
	//window handle of parent window

	// store window handles in Set
	Set<String>s=driver.getWindowHandles();

	// Now iterate using Iterator
	Iterator<String> I1= s.iterator();
	while(I1.hasNext())
	{
	String child_window=I1.next();
	if(!parent.equals(child_window))
	{
	driver.switchTo().window(child_window);
	//switch to child window 
		
	//get title of child window 
	System.out.println(driver.switchTo().window(child_window).getTitle());
	}

	//switch to the parent window
	driver.switchTo().window(parent);	  
	//switch window tab done
  		
	//findelements 
	driver.get("http://demo.guru99.com/test/ajax.html");
    List<WebElement> elements = driver.findElements(By.name("name"));
    System.out.println("Number of elements:" +elements.size());
    for (int i=0; i<elements.size();i++)
    {
      System.out.println("Radio button text:" + elements.get(i).getAttribute("value"));
    }
    
	//quit browser- close all window and close is for current window
	//driver.quit();
    
    
	
	}

}
}
