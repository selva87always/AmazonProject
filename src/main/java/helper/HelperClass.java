package helper;

import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class HelperClass extends BaseClass{
	public static void addcart(){
	/*driver.findElement(By.xpath("//*[@id='result_3']/div/div[3]/div[1]")).click();
	
	String parentTab = driver.getWindowHandle();
	
	Set<String> allChildTab = driver.getWindowHandles();
	for (String currentTab : allChildTab) {
		if(!parentTab.equals(currentTab))
			driver.switchTo().window(currentTab);
	}
	driver.findElement(By.id("add-to-cart-button")).click();
	try{
		Thread.sleep(1000);
		driver.findElement(By.id("siNoCoverage-announce")).click();
	}catch(Exception e){
		System.out.println("Exception has been successfully encountered");
	}*/
		JavascriptExecutor js=(JavascriptExecutor)driver;
		WebDriverWait wait = new WebDriverWait(driver, 15);
		
		WebElement link=driver.findElement(By.xpath("//*[@id='result_3']/div/div[3]/div[1]/a/h2"));
	    WebElement visibleLink = wait.until(ExpectedConditions.visibilityOf(link));
	    visibleLink.click();
	    
	    String parentTab = driver.getWindowHandle();
		
		Set<String> allChildTab = driver.getWindowHandles();
		for (String currentTab : allChildTab) {
			if(!parentTab.equals(currentTab))
				driver.switchTo().window(currentTab);
		}
	    
	    WebElement addcart=driver.findElement(By.id("add-to-cart-button"));
    	js.executeScript("arguments[0].click();", addcart);
    	
    	WebElement skipButton = wait.until(ExpectedConditions.presenceOfElementLocated(By.id("siNoCoverage-announce")));
    	js.executeScript("arguments[0].click();", skipButton);
    	
    	driver.switchTo().window(parentTab);
}
}