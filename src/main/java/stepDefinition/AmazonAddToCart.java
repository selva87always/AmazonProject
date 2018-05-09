package stepDefinition;

import java.util.List;
import java.util.Set;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import helper.BaseClass;
import helper.HelperClass;

public class AmazonAddToCart extends BaseClass{
	
	@Given("^User is on Amazon page$")
	public void user_is_on_Amazon_page() throws Throwable {
		getDriver();
		openApplication("https://www.amazon.in/");
	}
	@When("^User searches \"([^\"]*)\",\"([^\"]*)\", \"([^\"]*)\", \"([^\"]*)\", \"([^\"]*)\" and add five items to the cart individually$")
	public void user_searches_and_add_five_items_to_the_cart_individually(String item1, String item2, String item3, String item4, String item5) throws Throwable {
		
		JavascriptExecutor js=(JavascriptExecutor)driver;
		WebDriverWait wait = new WebDriverWait(driver, 15);
		String[] item = {item1,item2,item3,item4,item5};
		for (String currentItem : item) {
			driver.findElement(By.id("nav-link-shopall")).click();
			
			WebElement laptop=driver.findElement(By.xpath("//a[@class='nav_a' and contains(text(),'Laptops')]"));
			js.executeScript("arguments[0].click()", laptop);
			
			WebElement searchBox=driver.findElement(By.id("twotabsearchtextbox"));
			searchBox.clear();
			searchBox.sendKeys(currentItem);
			
		    driver.findElement(By.xpath("//input[@class='nav-input']")).click();
		    
		    HelperClass.addcart();
	    	    	
		}
	}
	
	@Then("^User verifies whether all the selected items were in cart or not$")
	public void user_verifies_whether_all_the_selected_items_were_in_cart_or_not() throws Throwable {
		driver.findElement(By.id("nav-cart")).click();
		Thread.sleep(2000);
		List<WebElement> cartElements = driver.findElements(By.xpath("//span[@class = 'a-size-medium sc-product-title a-text-bold']"));
		String dell=cartElements.get(0).getText();
		String hp=cartElements.get(1).getText();
		String acer=cartElements.get(2).getText();
		String asus=cartElements.get(3).getText();
		String lenovo=cartElements.get(4).getText();
		Assert.assertEquals("Dell", dell.contains("Dell"));
		Assert.assertEquals("HP", hp.contains("HP"));
		Assert.assertEquals("Acer", acer.contains("Acer"));
		Assert.assertEquals("Asus", asus.contains("Asus"));
		Assert.assertEquals("Lenovo", lenovo.contains("Lenovo"));
		
	}
}
