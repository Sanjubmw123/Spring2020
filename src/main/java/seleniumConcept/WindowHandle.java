package seleniumConcept;

import java.util.concurrent.TimeUnit;

import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class WindowHandle {
	WebDriver driver;
	@Before
	public void launchbrowser() throws InterruptedException {
		System.setProperty("webdriver.chrome.driver", ".\\driver\\chromedriver.exe");
		 driver=new ChromeDriver();
		 driver.get("https://www.yahoo.com/");
		 driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
	//	 driver.switchTo().alert().accept();
	//	Thread.sleep(5000);
}
	@Test
public void CHANGE() throws Exception {	
		
		System.out.println(driver.getTitle());
		//System.out.println(driver.getWindowHandle());
		
	driver.findElement(By.xpath("//*[@id=\"header-search-input\"]")).sendKeys("xpath");
	driver.findElement(By.xpath("//button[@id='header-desktop-search-button']")).click();
	Thread.sleep(5000);
	driver.findElement(By.linkText("XPath Tutorial - W3Schools")).click();
	for(String i :driver.getWindowHandles()) {
		System.out.println(i);
		driver.switchTo().window(i);
		driver.findElement(By.linkText("css")).click();
	}
	
	
	
	
}
}