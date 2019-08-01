package pack1;

import java.util.Iterator;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.junit.Assert;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;



public class Ex1 {
	
	WebDriver driver;
	
	
		@BeforeTest
		public void setUp()
		{
	
	System.setProperty("webdriver.chrome.driver","C:\\Users\\PriyankaH\\Downloads\\chromedriver_75\\chromedriver.exe");
	ChromeOptions options = new ChromeOptions();
	options.addArguments("--disable-notifications");
	 driver =new ChromeDriver(options);
	driver.get("https://www.online.citibank.co.in/");
	driver.manage().window().maximize();
	driver.manage().deleteAllCookies();
	driver.manage().timeouts().pageLoadTimeout(10, TimeUnit.SECONDS);
	driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		
	}
	
		
		@Test
		public void testmethod() {
			
		
		String par1=driver.getWindowHandle();
		System.out.println("par 1 id:"+par1);
	driver.switchTo().frame(driver.findElement(By.id("vizury-notification-template")));
	 WebElement element = driver.findElement(By.xpath("//div[@id='div-close']"));
	element.click();	
	driver.switchTo().window(par1);
	 	
    WebDriverWait wait = new WebDriverWait(driver, 10);

	WebElement elem = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//a[@title='LOGIN NOW' and @class='hidden-phone visible-dektop loginnowlink overlay-login']")));
	elem.click();
	Set<String> handler=driver.getWindowHandles();
	Iterator<String> it=handler.iterator();
	String parentid=it.next();
	System.out.println("parent id is:"+parentid);
	
	String childid=it.next();
	driver.switchTo().window(childid);
	System.out.println("child  id is:"+childid);
	
	System.out.println("child window title"+driver.getTitle());
	for(String st1:handler)
	{
		System.out.println("all handlers"+st1);
	}
	driver.close();
	driver.switchTo().window(parentid);
	System.out.println("parent window title"+driver.getTitle());
		}
	
//==========================	
	
	////a[@title='LOGIN NOW' and @class='hidden-phone visible-dektop loginnowlink overlay-login']
	
	/*String s1=driver.getTitle();
	System.out.println(s1);
 Assert.assertEquals("Google", s1);*/
	/*Actions action=new Actions(driver);
	action.moveToElement(driver.findElement(By.partialLinkText("Account & Lists"))).build().perform();
	Thread.sleep(3000);
	driver.findElement(By.xpath("//span[contains(text(),'Your Orders')]")).click();
	
	System.out.println("completed");
	*/
	
	
	
	
	//a[contains(text(),'Orders')]
	
	
	@AfterTest
	public void teardown()
	{
		driver.quit();
	}

	


}
