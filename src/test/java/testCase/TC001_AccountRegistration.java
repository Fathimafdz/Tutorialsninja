package testCase;

import org.apache.commons.lang3.RandomStringUtils;
import org.testng.Assert;
import org.testng.annotations.Test;

import pageObjects.HomePage;

public class TC001_AccountRegistration extends BaseClass {

    @Test(groups = "regression")
    public void verifyAccountRegistration() {
        logger.info("-------- Starting TC001_AccountRegistration --------");

        try {
            HomePage home = new HomePage(driver);
            home.clickMyAccount();
            logger.info("Clicked on My Account");

            home.registerAccount();
            logger.info("Clicked on Register");

            RegisterPage rp = new RegisterPage(driver);
            logger.info("Filling registration form...");

            rp.setFirstName("Fathima");
            rp.setLastName("Salim");
            rp.setEmail(randomName() + "@gmail.com");
            rp.setTelephone("9876543210");
            rp.setPassword("abc123");
            rp.setConfirm("abc123");
            rp.clickNewsbtn();
            rp.clickCheckbtn();
            rp.clickContinuebtn();
            logger.info("Clicked on Continue to submit registration");

            // ✅ Assert confirmation message
            boolean confirmationStatus = rp.isConfirmationMsgPresent();
            logger.info("Confirmation Message Displayed: " + confirmationStatus);
            Assert.assertTrue(confirmationStatus, "❌ Account registration failed – confirmation message not found!");

        } catch (Exception e) {
            logger.error("❌ Test failed due to exception: " + e.getMessage());
            Assert.fail("Test Failed due to Exception");
        }

        logger.info("-------- Finished TC001_AccountRegistration --------");
    }

    public String randomName() {
        return RandomStringUtils.randomAlphabetic(5);
    }
}
