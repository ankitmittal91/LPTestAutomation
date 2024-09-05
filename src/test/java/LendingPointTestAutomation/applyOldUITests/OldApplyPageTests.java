package LendingPointTestAutomation.applyOldUITests;

import java.util.Iterator;
import java.util.Set;

import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.aventstack.extentreports.Status;

import LendingPointTestAutomation.action.Action;
import LendingPointTestAutomation.baseClass.BaseClass;
import LendingPointTestAutomation.pageFactory.applyNewUI.*;
import LendingPointTestAutomation.pageFactory.applyOldUI.*;
import LendingPointTestAutomation.utility.DriverFactory;
import LendingPointTestAutomation.utility.ExtentFactory;
import LendingPointTestAutomation.utility.ExtentManager;
import LendingPointTestAutomation.utility.Log;

public class OldApplyPageTests extends BaseClass{

	OldApplyPage oldApplyPage;
	OldOfferPage oldOfferPage;
	OldBankInformationPage oldBankInformationPage;
	OldIncomeInformationPage oldIncomeInformationPage;
	OldIncomeInformationPage oldPaymentSetupPage;
	OldSignContractPage oldSignContractPage;

	@BeforeClass (groups = {"Sanity","Smoke","APISmokeSuite"})
	public void launchApplication() {
		launchBrowser(prop.getProperty("oldApplyUIUrl"));
		oldApplyPage = new OldApplyPage();
		Action.fluentWait(oldApplyPage.loanAmountTextBox, 30);
	}

	@AfterClass (groups = {"Sanity","Smoke","APISmokeSuite"})
	public void tearDown() {
		if(DriverFactory.getInstance().getDriver() != null) {
			DriverFactory.getInstance().closeBrowser();
		}
	}

	@Test (priority = 1, groups = {"Smoke"})
	public void fillApplyFormOldUISuccess() throws InterruptedException {
		Log.startTestCase("User starts entering Personal Information");
		oldApplyPage.enterLoanAmount("4000");
		oldApplyPage.selectLoanPurpose("Unexpected Urgent Expense");
		oldApplyPage.enterFirstName("John");
		oldApplyPage.enterLastName("Smith");
		oldApplyPage.enterDOB("02281975");
		oldApplyPage.enterPhone("2127290859");
		Log.info("User has filled the form till phone number");
		oldApplyPage.enterEmail("kbisht@lendingpoint.com");
		oldApplyPage.enterAddress1("222333 PEACHTREE PLACE");
		oldApplyPage.enterZipCode("30318");
		Log.info("User has filled the form till Zip");
		oldApplyPage.selectIncomeSource("Employee");
		oldApplyPage.enterAnnualIncome("98000");
		oldApplyPage.enterSSN("112223333");
		oldApplyPage.enterPassword("Test@123");
		oldOfferPage = oldApplyPage.clickCheckMyOptionButton();
		ExtentFactory.getInstance().getExtent().log(Status.PASS, "User has clicked check my options button");
		Log.info("User has clicked check my options button");
	}
	
	@Test (priority = 2, groups = {"Smoke"})
	public void selectOfferOldUISuccess() {
		Action.fluentWait(oldOfferPage.blockscreenHide, 30);
		Action.fluentWait(oldOfferPage.selectOfferTitle, 30);
		//Assert.assertEquals(Action.isDisplayed(oldOfferPage.selectOfferTitle, "Select Offer title"), true);
		Action.fluentWait(oldOfferPage.phoneVerificationPopupTitle, 10);
		if(Action.isDisplayed(oldOfferPage.phoneVerificationPopupTitle, "Phone Verification Popup title") == true) {
			Log.info("User is on Phone verification popup");
			Action.fluentWait(oldOfferPage.resendCodeButton, 10);
			oldOfferPage.enterVerificationCode("11234");
			Log.info("User has entered verification code");
			oldOfferPage.closeVerificationPopup();
			Log.info("User has exited Phone verification popup");
		}
		if(Action.findElement(DriverFactory.getInstance().getDriver(), oldOfferPage.newSlider) == true) {
			Action.fluentWait(oldOfferPage.chooseButton, 10);
			oldBankInformationPage = oldOfferPage.clickChooseButton();
			oldBankInformationPage = oldOfferPage.clickChooseButton();
			Log.info("User has selected offer on new offer page");
		} else { 
			Action.fluentWait(oldOfferPage.chooseButton, 10);
			oldBankInformationPage = oldOfferPage.clickChooseButton();
			oldBankInformationPage = oldOfferPage.clickChooseButton();
			Log.info("User has selected offer on old offer page");
		}
	}
	
	@Test (priority = 3, groups = {"smoke"})
	public void completePlaidFlowOldUISuccess() {
		Action.pageLoadTimeOut(30);
		Action.fluentWait(oldBankInformationPage.blockscreenLoaderHidden, 30);
		Action.fluentWait(oldBankInformationPage.blockscreenLoader, 30);
		Action.fluentWait(oldBankInformationPage.bankInformationTitle, 30);
		Action.fluentWait(oldBankInformationPage.connectPlaidButton, 30);
		oldBankInformationPage = oldBankInformationPage.clickConnectPlaidButton();
		Log.info("User has clicked connect with Plaid button");
		Action.fluentWait(oldBankInformationPage.blockscreenLoaderHidden, 30);
		Action.fluentWaitTillExists(oldBankInformationPage.plaidIframe, 20);
		DriverFactory.getInstance().getDriver().switchTo().frame(oldBankInformationPage.plaidIframe);
		Action.fluentWait(oldBankInformationPage.plaidContinueButton, 5);
		oldBankInformationPage.clickContinuePlaidButton();
		Log.info("User has clicked continue on Plaid frame");
		Action.fluentWait(oldBankInformationPage.plaidBankSearchBox, 20);
		oldBankInformationPage.searchPlaidBank("first platypus");
		Log.info("User has searched bank name on Plaid frame");
		Action.fluentWait(oldBankInformationPage.plaidSearchResultTile1, 10);
		oldBankInformationPage.selectPlaidBank1();
		Action.fluentWait(oldBankInformationPage.plaidInstitutionsFoundTile, 10);
		oldBankInformationPage.selectPlaidBank2();
		Log.info("User has selected bank on Plaid frame");
		Action.fluentWait(oldBankInformationPage.plaidUsernameTextBox, 20);
		oldBankInformationPage.enterPlaidUsername("user_custom");
		oldBankInformationPage.enterPlaidPassword("{\"override_accounts\":[{\"starting_balance\":23630,\"type\":\"depository\",\"subtype\":\"checking\",\"identity\":{\"names\":[\"John Smith\"]}},{\"starting_balance\":25215,\"type\":\"depository\",\"subtype\":\"savings\",\"identity\":{\"names\":[\"John Smith\"]}}]}");
		Log.info("User has entered bank credentials on Plaid frame");
		Action.fluentWait(oldBankInformationPage.plaidSubmitButton, 10);
		oldBankInformationPage.clickPlaidSubmitButton1();
		Action.fluentWait(oldBankInformationPage.plaidSavingAccountTile, 10);
		oldBankInformationPage.clickPlaidSavingAccountTile();
		Action.fluentWait(oldBankInformationPage.plaidSubmitButton, 10);
		oldBankInformationPage.clickPlaidSubmitButton1();
		Action.fluentWait(oldBankInformationPage.plaidSubmitButton, 10);
		oldPaymentSetupPage = oldBankInformationPage.clickPlaidSubmitButton2();
		Log.info("User has completed Plaid flow");
		DriverFactory.getInstance().getDriver().switchTo().parentFrame();
	}
	
	@Test (priority = 4, groups = {"smoke"})
	public void completeEmploymentRepaymentOldUISuccess() {
		Action.fluentWait(oldPaymentSetupPage.blockscreenHide, 20);
		Action.fluentWait(oldPaymentSetupPage.paymentSetupTab, 10);
		if(Action.findElement(DriverFactory.getInstance().getDriver(), oldPaymentSetupPage.paymentSetupTab) == true) {
			Action.fluentWait(oldPaymentSetupPage.achButton, 30);
			oldSignContractPage = oldPaymentSetupPage.clickPaymentSetupNextButton();
		} else {
			oldPaymentSetupPage =  new OldIncomeInformationPage();
			Action.fluentWait(oldPaymentSetupPage.employmentPageTitle, 20);
			oldPaymentSetupPage.enterEmployerName("ABC Corp");
			oldPaymentSetupPage.enterEmployerPhone("9878978665");
			oldPaymentSetupPage.enterWorkEmail("abc@lendingpoint.com");
			oldPaymentSetupPage.enterJobTitle("Dev");
			oldPaymentSetupPage.enterStartDate("02/29/2008");
			oldPaymentSetupPage = oldPaymentSetupPage.clickEmploymentNextButton();
			Action.pageLoadTimeOut(10);
			Action.fluentWait(oldPaymentSetupPage.achButton, 30);
			oldSignContractPage = oldPaymentSetupPage.clickPaymentSetupNextButton();
		}
	}
	
	@Test (priority = 5, groups = {"smoke"})
	public void signAgreementOldUISuccess() {
		Action.pageLoadTimeOut(10);
		Action.fluentWait(oldSignContractPage.amountFinancedTileTitle, 30);
		oldSignContractPage.clickCheckBox1();
		oldSignContractPage.clickCheckBox2();
		oldSignContractPage.clickSignAgreementButton();
	}

}
