package LendingPointTestAutomation.applyOldUITests;

import java.util.Iterator;
import java.util.Set;

import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import LendingPointTestAutomation.action.Action;
import LendingPointTestAutomation.baseClass.BaseClass;
import LendingPointTestAutomation.pageFactory.applyNewUI.ApplyPage;
import LendingPointTestAutomation.pageFactory.applyOldUI.OldApplyPage;
import LendingPointTestAutomation.pageFactory.applyOldUI.OldOfferPage;
import LendingPointTestAutomation.pageFactory.applyOldUI.OldBankInformationPage;
import LendingPointTestAutomation.pageFactory.applyOldUI.OldEmploymentPage;
import LendingPointTestAutomation.utility.Log;

public class OldApplyPageTests extends BaseClass{
	
OldApplyPage oldApplyPage;
OldOfferPage oldOfferPage;
OldBankInformationPage oldBankInformationPage;
OldEmploymentPage oldEmploymentPage;

	@BeforeClass (groups = {"Sanity","Smoke","APISmokeSuite"})
	public void launchApplication() {
		launchBrowser(prop.getProperty("oldApplyUIUrl"), prop.getProperty("browserType"));
		oldApplyPage = new OldApplyPage();
		Action.fluentWait(driver, oldApplyPage.loanAmountTextBox, 30);
	}
	
	@AfterClass (groups = {"Sanity","Smoke","APISmokeSuite"})
	public void tearDown() {
		driver.quit();
	}
	
	@Test (groups = {"Smoke"})
	public void fillApplyFormSuccess() throws InterruptedException {
				Log.startTestCase("User starts entering Personal Information");
		oldApplyPage.enterLoanAmount("5000");
		oldApplyPage.selectLoanPurpose("Unexpected Urgent Expense");
		oldApplyPage.enterFirstName("John");
		oldApplyPage.enterLastName("Smith");
		oldApplyPage.enterDOB("02/28/1975");
		oldApplyPage.enterPhone("2127290858");
				Action.fluentWait(driver, oldApplyPage.checkPhoneTick, 20);
				Log.info("User has filled the form till phone number");
		oldApplyPage.enterEmail("kbisht@lendingpoint.com");
				Action.fluentWait(driver, oldApplyPage.checkEmailTick, 20);
		oldApplyPage.enterAddress1("222333 PEACHTREE PLACE");
		oldApplyPage.enterZipCode("30318");
				Action.fluentWait(driver, oldApplyPage.zipCheckImage, 2);
				Log.info("User has filled the form till Zip");
		oldApplyPage.selectIncomeSource("Employee");
		oldApplyPage.enterAnnualIncome("98000");
		oldApplyPage.enterSSN("112223333");
		oldApplyPage.enterPassword("Test@123");
		oldOfferPage = oldApplyPage.clickCheckMyOptionButton();
				Log.info("User has clicked check my options button");
				Action.fluentWait(driver, oldOfferPage.blockscreenHide, 30);
				Action.fluentWait(driver, oldOfferPage.selectOfferTitle, 30);
				Action.fluentWait(driver, oldOfferPage.phoneVerificationPopupTitle, 10);
		if(Action.isDisplayed(driver, oldOfferPage.phoneVerificationPopupTitle) == true) {
				Log.info("User is on Phone verification popup");
				Action.fluentWait(driver, oldOfferPage.resendCodeButton, 10);
			oldOfferPage.enterVerificationCode("11234");
				Log.info("User has entered verification code");
				Action.fluentWait(driver, oldOfferPage.verificationPopupError, 10);
			oldOfferPage.closeVerificationPopup();
				Log.info("User has exited Phone verification popup");
				Action.fluentWait(driver, oldOfferPage.chooseButton, 10);
		}
		if(Action.findElement(driver, oldOfferPage.newSlider) == true) {
				Action.fluentWait(driver, oldOfferPage.chooseButton, 10);
			oldBankInformationPage = oldOfferPage.clickChooseButton();
			oldBankInformationPage = oldOfferPage.clickChooseButton();
				Log.info("User has selected offer on new offer page");
		} else { 
				Action.fluentWait(driver, oldOfferPage.chooseButton, 10);
			oldBankInformationPage = oldOfferPage.clickChooseButton();
				Log.info("User has selected offer on old offer page");
		}
				Action.pageLoadTimeOut(driver, 30);
				Action.fluentWait(driver, oldBankInformationPage.blockscreenLoaderHidden, 30);
				Action.fluentWait(driver, oldBankInformationPage.blockscreenLoader, 30);
				Action.fluentWait(driver, oldBankInformationPage.bankInformationTitle, 30);
				Action.fluentWait(driver, oldBankInformationPage.connectPlaidButton, 30);
		oldBankInformationPage = oldBankInformationPage.clickConnectPlaidButton();
				Log.info("User has clicked connect with Plaid button");
				Action.fluentWait(driver, oldBankInformationPage.blockscreenLoaderHidden, 30);
				Action.fluentWaitTillExists(driver, oldBankInformationPage.plaidIframe, 20);
		driver.switchTo().frame(oldBankInformationPage.plaidIframe);
				Action.fluentWait(driver, oldBankInformationPage.plaidContinueButton, 5);
		oldBankInformationPage.clickContinuePlaidButton();
				Log.info("User has clicked continue on Plaid frame");
				Action.fluentWait(driver, oldBankInformationPage.plaidBankSearchBox, 20);
		oldBankInformationPage.searchPlaidBank("first platypus");
				Log.info("User has searched bank name on Plaid frame");
				Action.fluentWait(driver, oldBankInformationPage.plaidSearchResultTile1, 10);
		oldBankInformationPage.selectPlaidBank1();
				Action.fluentWait(driver, oldBankInformationPage.plaidInstitutionsFoundTile, 10);
		oldBankInformationPage.selectPlaidBank2();
			Log.info("User has selected bank on Plaid frame");
				Action.fluentWait(driver, oldBankInformationPage.plaidUsernameTextBox, 20);
		oldBankInformationPage.enterPlaidUsername("user_custom");
		oldBankInformationPage.enterPlaidPassword("{\"override_accounts\":[{\"starting_balance\":23630,\"type\":\"depository\",\"subtype\":\"checking\",\"identity\":{\"names\":[\"John Smith\"]}},{\"starting_balance\":25215,\"type\":\"depository\",\"subtype\":\"savings\",\"identity\":{\"names\":[\"John Smith\"]}}]}");
				Log.info("User has entered bank credentials on Plaid frame");
				Action.fluentWait(driver, oldBankInformationPage.plaidSubmitButton, 10);
		oldBankInformationPage.clickPlaidSubmitButton1();
				Action.fluentWait(driver, oldBankInformationPage.plaidSavingAccountTile, 10);
		oldBankInformationPage.clickPlaidSavingAccountTile();
				Action.fluentWait(driver, oldBankInformationPage.plaidSubmitButton, 10);
		oldBankInformationPage.clickPlaidSubmitButton1();
				Action.fluentWait(driver, oldBankInformationPage.plaidSubmitButton, 10);
		oldEmploymentPage = oldBankInformationPage.clickPlaidSubmitButton2();
				Log.info("User has completed Plaid flow");
				Action.fluentWait(driver, oldEmploymentPage.employmentPageTitle, 20);
	}

}
