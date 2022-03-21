package pageobjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import io.qameta.allure.Step;
import resources.BaseClass;

public class DashboardPage {
	
	public WebDriver driver;
	
	public DashboardPage(WebDriver driver) {
		this.driver = driver;
	}

	
	By addsign = By.xpath("(//*[@id='data-input-add-icon-id'])[1]");
	By data_text = By.xpath("//input[@id='value']");
	By submit = By.xpath("(//*[text()='Submit'])[3]");
	By success_message = By.xpath("//*[text()='Successfully added a new data entry']");
	
	By warning_message = By.xpath("//*[text()='The value already exists for the timestamp']");
	
	By companylogo = By.xpath("//img[@ng-click='clickLogo()']");
	
	By singulartext = By.xpath("//*[text()='Singular']");
	
	public WebDriver firsttestcase() {
		BaseClass.shortWait();
		driver.findElement(addsign).click();
		driver.findElement(data_text).sendKeys("23");
		driver.findElement(submit).click();
		return driver;
	}
	
	public WebDriver secondtestcase() {
		driver.findElement(addsign).click();
		driver.findElement(data_text).sendKeys("23");
		driver.findElement(submit).click();
		return driver;
	}
	
	@Step("Text validation Step")
	public String get_SingularText() {
		BaseClass.shortWait();
		String message = driver.findElement(singulartext).getText();
		return message;
	}
	
	@Step("Success Text validation Step")
	public String get_success_message() {
		String message = driver.findElement(success_message).getText();
		return message;
	}
	
	@Step("Warning message validation Step")
	public String get_warning_message() {
		String message = driver.findElement(warning_message).getText();
		return message;
	}
	
	@Step("Company logo validation step")
	public boolean get_companylogo() {
		BaseClass.shortWait();
		boolean result = driver.findElement(companylogo).isDisplayed();
		return result;
	}
}
