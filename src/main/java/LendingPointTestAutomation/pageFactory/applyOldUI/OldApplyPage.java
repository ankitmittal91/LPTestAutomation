package LendingPointTestAutomation.pageFactory.applyOldUI;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import LendingPointTestAutomation.action.Action;
import LendingPointTestAutomation.baseClass.BaseClass;

public class OldApplyPage extends BaseClass{
	
	public OldApplyPage() {
		PageFactory.initElements(driver, this);
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
		Action.type(loanAmountTextBox, loanAmount);
	}
	
	public void selectLoanPurpose(String loanPurpose) {
		Action.selectByValue(loanPurposeDropDown, loanPurpose);
	}
	
	public void enterFirstName(String firstName) {
		Action.type(firstNameTextBox, firstName);
	}
	
	public void enterLastName(String lastName) {
		Action.type(lastNameTextBox, lastName);
	}
	
	public void enterDOB(String dob) {
		Action.click(driver, dobTextBox);
		Action.type(dobTextBox, dob);
	}
	
	public void enterPhone(String phone) {
		Action.type(phoneTextBox, phone);
	}
	
	public void enterEmail(String email) {
		Action.type(emailTextBox, email);
		Action.click(driver, address1TextBox);
	}
	
	public void enterAddress1(String address) {
		Action.type(address1TextBox, address);
	}
	
	public void enterZipCode(String zip) {
		Action.type(zipCodeTextBox, zip);
	}
	
	public void enterAnnualIncome(String annualIncome) {
		Action.click(driver, annualIncomeTextBox);
		//annualIncomeTextBox.clear();
		annualIncomeTextBox.sendKeys(annualIncome);
	}
	
	public void selectIncomeSource(String incomeSource) {
		Action.selectByValue(incomeSourceDropDown, incomeSource);
	}
	
	public void enterSSN(String ssn) {
		Action.moveToElement(driver, ssnTextBox);
		Action.click(driver, ssnTextBox);
		Action.type(ssnTextBox, ssn);
	}
	
	public void enterPassword(String password) {
		Action.type(passwordTextBox, password);
	}
	
	public OldOfferPage clickCheckMyOptionButton() {
		Action.click(driver, checkMyOptionsButton);
		return new OldOfferPage();
	}

}