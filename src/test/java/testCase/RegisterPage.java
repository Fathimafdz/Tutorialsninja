package testCase;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class RegisterPage {
	WebDriver driver;
	public RegisterPage(WebDriver driver)
	{
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
//Locators
	
	@FindBy(xpath = "//input[@id='input-firstname']") WebElement firstName;
    @FindBy(xpath="//input[@id='input-lastname']")WebElement lastName;
	@FindBy(xpath="//input[@id='input-email']")WebElement email;
	@FindBy(xpath="//input[@id='input-telephone']")WebElement telephone;
	@FindBy(xpath="//input[@id='input-password']")WebElement password;
	@FindBy(xpath="//input[@id='input-confirm']")WebElement confirm;
	@FindBy(xpath="//input[@name='newsletter']")WebElement newsletter;
	@FindBy(xpath="//input[@type='checkbox']")WebElement checkbox;
	@FindBy(xpath="//input[@type='submit']")WebElement continuebtn;
	@FindBy(xpath = "//h1[normalize-space()='Your Account Has Been Created!']")
	WebElement confirmMsg;

	public boolean isConfirmationMsgPresent() {
	    try {
	        return confirmMsg.isDisplayed();
	    } catch (Exception e) {
	        return false;
	    }
	}

//ActionMethods
	public void setFirstName(String fName) {
		firstName.sendKeys(fName);
	}
	public void setLastName(String lName) {
	   lastName.sendKeys(lName);
	}
	public void setEmail(String emailid) {
		email.sendKeys(emailid);
	}
	public void setTelephone(String teleno) {
		telephone.sendKeys(teleno);
	}
	public void setPassword(String pp) {
		password.sendKeys(pp);
	}
	public void setConfirm(String confpp) {
		confirm.sendKeys(confpp);
	}
	
	public void clickNewsbtn() {
		newsletter.click();
	}
	public void clickCheckbtn() {
		checkbox.click();
	}
	public void clickContinuebtn() {
		continuebtn.click();
	}

}
