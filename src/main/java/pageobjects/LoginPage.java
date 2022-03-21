package pageobjects;


import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import resources.BaseClass;


public class LoginPage {
	
	public WebDriver driver;
	
	By email = By.xpath("//input[@id='emailAddress']");
	By password = By.xpath("//input[@id='password']");
	By signIn = By.xpath("(//*[text()='Sign In'])[2]");
	

	
	public LoginPage(WebDriver driver) {
		this.driver = driver;
	
	}
	
	
	
	public WebDriver login(){
		BaseClass.shortWait();
		driver.findElement(email).sendKeys("menna+testproject@intellisense.io");
		driver.findElement(password).sendKeys("AutMaNewTest1#");
		driver.findElement(signIn).click();
		return driver;
		
	}

}
