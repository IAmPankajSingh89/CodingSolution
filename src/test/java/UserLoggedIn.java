import static org.testng.Assert.assertEquals;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.Alert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class UserLoggedIn {

	    WebDriver driver;
	    SignIN objLogin;
	    Alert alert;
	    
	    @BeforeTest
	    public void setup(){

	        driver = new FirefoxDriver();
	        driver.get("http://www.xyz.com");
	        driver.manage().window().maximize();
	        objLogin = new SignIN(driver);

	    }

	    @Test()
	    public void successfullyLogin(){
	    
	    objLogin.loginToWebsite("uname","abc123");
	    driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
	    String msgForSuccessfulLogin = driver.switchTo().alert().getText();
	    assertEquals(msgForSuccessfulLogin,"Logged in Successfully");	    
	    }
	    
	    @AfterTest
	    public void close()
	    {
	    	driver.close();
	    }
}
