package intellisense.QA;


import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import io.qameta.allure.Description;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import org.testng.Assert;
import pageobjects.DashboardPage;
import pageobjects.LoginPage;
import resources.AllureListener;
import resources.BaseClass;


@Listeners({AllureListener.class})
public class IntellisenseTest extends BaseClass {

	public WebDriver driver;
	DashboardPage d;
	
	@BeforeClass
	public void setup() throws InterruptedException, IOException 
	{
		BaseClass b = new BaseClass();
		driver = b.initialize_driver();
		Properties prop = new Properties();
		FileInputStream fis=new FileInputStream(System.getProperty("user.dir")+"\\src\\main\\java\\resources\\data.properties");
		prop.load(fis);
		driver.get(prop.getProperty("url"));
		LoginPage l = new LoginPage(driver);
		l.login();
		d = new DashboardPage(driver);
		
	}
	
	@Test(priority = 1, description="Validating the success message")
	@Description("Dashboard Test Case - 1")
	@Severity(SeverityLevel.CRITICAL)
	public void firsttest()
	{
		d.firsttestcase();
		String ab = d.get_success_message();
		Assert.assertEquals(ab, "Successfully added a new data entry");
	}
	
	@Test(priority = 2, description="Validating the TimeStamp message")
	@Description("Dashboard Test Case - 2")
	@Severity(SeverityLevel.CRITICAL)
	public void secondtest()
	{
		d.secondtestcase();
		String error = d.get_warning_message();
		Assert.assertEquals(error, "The value already exists for the timestamp");
	}
		
	
	
	@Test(priority = 3, description="Validating the text of Singular")
	@Description("Dashboard Test Case - 3")
	@Severity(SeverityLevel.NORMAL)
	public void thirdtest()
	{
		String message = d.get_SingularText();
		Assert.assertEquals(message, "SINGULAR");
	}

	@Test(priority = 4, description="Validating the presence of Company Logo")
	@Description("Dashboard Test Case - 4")
	@Severity(SeverityLevel.CRITICAL)
	public void fourthtest()
	{
		boolean  a = d.get_companylogo();
		Assert.assertEquals(a, true);
	}
	
	@AfterClass
	public void teardown() 
	{
		driver.quit();
	}
}
