package testCase;

import org.testng.Assert;
import org.testng.annotations.Test;
import pageObjects.HomePage;
import pageObjects.LoginPage;
import pageObjects.MyAccountPage;

public class TC002_LoginTest extends BaseClass {

    @Test
    public void verifyLogin() {
        logger.info("-------- Starting TC002_LoginTest --------");

        try {
            HomePage home = new HomePage(driver);
            home.clickMyAccount();
            logger.info("Clicked on My Account");

            home.loginAccount();
            logger.info("Clicked on Login");

            LoginPage lp = new LoginPage(driver);
            lp.setEmail(p.getProperty("email"));
            lp.setPassword(p.getProperty("password"));
            logger.info("Entered login credentials");

            lp.clickLogin();
            logger.info("Clicked on Login button");

            MyAccountPage accPage = new MyAccountPage(driver);

            //  Assert My Account page is displayed
            Assert.assertTrue(accPage.isMyAccountPageExists(), 
                "❌ Login failed: My Account page not displayed");

            logger.info("Login Test Passed - My Account page found");

        } catch (Exception e) {
            logger.error("❌ Login Test Failed due to exception: " + e.getMessage());
            Assert.fail("❌ Exception occurred during login test: " + e.getMessage());
        }

        logger.info("-------- Finished TC002_LoginTest --------");
    }
}
