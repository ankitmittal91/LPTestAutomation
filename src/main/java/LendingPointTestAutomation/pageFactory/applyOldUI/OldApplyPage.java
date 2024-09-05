package LendingPointTestAutomation.pageFactory.applyOldUI;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.aventstack.extentreports.Status;

import LendingPointTestAutomation.action.Action;
import LendingPointTestAutomation.baseClass.BaseClass;
import LendingPointTestAutomation.utility.DriverFactory;
import LendingPointTestAutomation.utility.ExtentFactory;

public class OldApplyPage extends BaseClass{
	
	public OldApplyPage() {
		PageFactory.initElements(DriverFactory.getInstance().getDriver(), this);
	}
	
	@FindBy(xpath = "//input[@id='loanAmount']")
	public WebElement loanAmountTextBox;
	
	@FindBy(xpath = "//select[@id='loanPurpose']")
	WebElement loanPurposeDropDown;
	
	@FindBy(xpath = "//input[@id='firstName']")
	WebElement firstNameTextBox;
	
	@FindBy(xpath = "//input[@id='lastName']")
	WebElement lastNameTextBox;
	
	@FindBy(xpath = "//input[@id='dob']")
	public WebElement dobTextBox;
	
	@FindBy(xpath = "//input[@id='phone']")
	public WebElement phoneTextBox;
	
	@FindBy(xpath = "//input[@id='email']")
	WebElement emailTextBox;
	
	@FindBy(xpath = "//span[@class='glyphicon checking-req checking-email-ok glyphicon-ok font-med text-success']")
	public WebElement checkEmailTick;
	
	@FindBy(xpath = "//span[@class='glyphicon checking-req-phone checking-phone-ok glyphicon-ok font-med text-success']")
	public WebElement checkPhoneTick;
	
	@FindBy(xpath = "//input[@id='google-addres']")
	WebElement address1TextBox;
	
	@FindBy(xpath = "//input[@id='postal_code']")
	WebElement zipCodeTextBox;
	
	@FindBy(xpath = "//img[@class='loading-inline requestzip hide']")
	public WebElement zipCheckImage;
	
	@FindBy(xpath = "//input[@name='annualIncome']")
	WebElement annualIncomeTextBox;
	
	@FindBy(xpath = "//select[@id='income-source']")
	WebElement incomeSourceDropDown;
	
	@FindBy(xpath = "//input[@id='ssn']")
	WebElement ssnTextBox;
	
	@FindBy(xpath = "//input[@id='password']")
	WebElement passwordTextBox;
	
	@FindBy(xpath = "//button[@type='submit']")
	WebElement checkMyOptionsButton;
	
	public void enterLoanAmount(String loanAmount) {
		Action.type(loanAmountTextBox, loanAmount, "Loan Amount field");
	}
	
	public void selectLoanPurpose(String loanPurpose) {
		Action.selectByValue(loanPurposeDropDown, loanPurpose);
	}
	
	public void enterFirstName(String firstName) {
		Action.type(firstNameTextBox, firstName, "First Name field");
	}
	
	public void enterLastName(String lastName) {
		Action.type(lastNameTextBox, lastName, "Last Name field");
	}
	
	public void enterDOB(String dob) {
		Action.click(dobTextBox, "DOB textbox on Old Apply page");
		Action.enterTextByCharacter(dobTextBox, dob, 0);
	}
	
	public void enterPhone(String phone) {
		//Action.type(phoneTextBox, phone, "Phone number field");
		phoneTextBox.sendKeys(phone);
		Action.fluentWait(checkPhoneTick, 20);
	}
	
	public void enterEmail(String email) {
		Action.type(emailTextBox, email, "Email Address field");
		Action.click(address1TextBox, "Address textbox on Old Apply page");
		Action.fluentWait(checkEmailTick, 20);
	}
	
	public void enterAddress1(String address) {
		Action.type(address1TextBox, address, "Address field");
	}
	
	public void enterZipCode(String zip) {
		Action.type(zipCodeTextBox, zip, "Zip Code Field");
		Action.fluentWait(zipCheckImage, 2);
	}
	
	public void enterAnnualIncome(String annualIncome) {
		Action.click(annualIncomeTextBox, "Annual Income textbox on Old Apply page");
		annualIncomeTextBox.sendKeys(annualIncome);
	}
	
	public void selectIncomeSource(String incomeSource) {
		Action.selectByValue(incomeSourceDropDown, incomeSource);
	}
	
	public void enterSSN(String ssn) {
		Action.moveToElement(ssnTextBox);
		Action.click(ssnTextBox, "SSN textbox on Old Apply page");
		Action.type(ssnTextBox, ssn, "SSN field");
	}
	
	public void enterPassword(String password) {
		Action.type(passwordTextBox, password, "Password field");
	}
	
	public OldOfferPage clickCheckMyOptionButton() {
		Action.click(checkMyOptionsButton, "Check my options button on Old Apply page");
		return new OldOfferPage();
	}

}