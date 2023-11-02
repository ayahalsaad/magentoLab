import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import org.apache.commons.lang3.RandomStringUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import java.util.Random;


public class SignUpTest {
	
	WebDriver driver = new ChromeDriver();
	Random rand = new Random();
	String URL= "https://magento.softwaretestingboard.com/customer/account/create/";
	
	//generate random inputs for WebElements
	String firstName = RandomStringUtils.randomAlphabetic(5); 
    String lastName = RandomStringUtils.randomAlphabetic(5);
    String email = "ayah" + rand.nextInt(1000);
    String Domain= "@example.com"; 
    String password = RandomStringUtils.randomAlphanumeric(10) + "@A";
	

	@BeforeTest
	public void SetupTest() {
		
		driver.get(URL);
		driver.manage().window().maximize();
		
	}
	
	@Test
	public void Test() {
		
		// finding webElments
		WebElement FirstNameField = driver.findElement(By.id("firstname"));
		WebElement LastNameField =driver.findElement(By.id("lastname"));
		WebElement EmailField =driver.findElement(By.id("email_address"));
		WebElement passwordField =driver.findElement(By.id("password"));
		WebElement PasswordCofirmation =driver.findElement(By.id("password-confirmation"));

		//Interact with webElements
		FirstNameField.sendKeys(firstName);
		LastNameField.sendKeys(lastName);
		EmailField.sendKeys(email+Domain);
		passwordField.sendKeys(password);
		PasswordCofirmation.sendKeys(password);
		driver.findElement(By.className("submit")).click();
		
		
	}
	
	@AfterTest
	public void AfterTest() {
		
		
	}
	
	

}
