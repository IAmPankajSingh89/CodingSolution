import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class SignIN {
	
	WebDriver driver;

    @FindBy(id="okta-signin-username")
    WebElement userName;

    @FindBy(className="okta-signin-password")
    WebElement password;    

    @FindBy(xpath = ".//*[@class='okta-signin-password']/following-sibling")
    WebElement signIn;

    public SignIN(WebDriver driver) {
    	this.driver = driver;
	}

	public void login(){

        PageFactory.initElements(driver, this);

    }

    //Set user name in username textbox

    public void setUserName(String strUserName){

    	userName.sendKeys(strUserName);     
    }

    //Set password in password textbox

    public void setPassword(String strPassword){

    	password.sendKeys(strPassword);

    }

    //Click on sign in button

    public void signIn(){

    	signIn.click();

    }  

     public void loginToWebsite(String strUserName,String strPassword){

        //Fill user name

        this.setUserName(strUserName);
        
        //Fill password

        this.setPassword(strPassword);

        //Click Sign In button

        this.signIn();           

    }

}
