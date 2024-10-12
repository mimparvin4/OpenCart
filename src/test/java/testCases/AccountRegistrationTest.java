package testCases;

import org.apache.commons.lang3.RandomStringUtils;
import org.testng.Assert;
import org.testng.annotations.Test;

import pageObjects.HomePage;
import pageObjects.RegistrationPage;
import testBase.BaseClass;

public class AccountRegistrationTest extends BaseClass {
	
	@Test(groups= {"Sanity","Master"})
	public void validateAccountRegistration() {
		logger.info("************Starting Account Registration Test***********");
		logger.debug("#####This is a debug log message##########");
		try {
		//create an object of HomePage
		HomePage homePage = new HomePage(driver);
		logger.info("Clicking on Register link");
		homePage.clickOnMyAccount();
		homePage.clickOnRegister();
		
		//create an object of RegistrationPage
		RegistrationPage regPage = new RegistrationPage(driver);
		
		logger.info("Providing customer information");
		regPage.setFirstName(randomString().toUpperCase());
		regPage.setLastName(randomString().toUpperCase());
		regPage.setEmail(randomString()+"@mail.com");
		regPage.setTelephone(randomNumber());
		String pwd = randomAlphaNumeric();
		regPage.setPassword(pwd);
		regPage.setConfirmPassword(pwd);
		
		regPage.setPrivacyPolicy();
		regPage.clickContinue();
		logger.info("Validating expected message...");
		String confmsg = regPage.getConfirmationMsg();
		Assert.assertEquals(confmsg, "Your Account Has Been Created!!");
		logger.info("Account Registration Test Passed");
	} catch(Exception e) {
		
	} finally {
		logger.info("***************Finished Account Registration Testing*************");
	}
	
	
	}
	
	
	
	
	
	
}
