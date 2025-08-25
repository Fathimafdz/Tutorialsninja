package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomePage {
    public WebDriver driver;

    // Correct constructor
    public HomePage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    // Correct usage of @FindBy
    @FindBy(xpath = "//span[text()='My Account']")
    WebElement myaccount_details;

    @FindBy(xpath = "//a[text()='Register']")
    WebElement registerbtn;

    @FindBy(xpath = "//a[text()='Login']") 
    WebElement loginbtn;

    public void clickMyAccount() {
        myaccount_details.click();
    }

    public void registerAccount() {
        registerbtn.click(); 
    }

    public void loginAccount() {
        loginbtn.click();
    }
}
