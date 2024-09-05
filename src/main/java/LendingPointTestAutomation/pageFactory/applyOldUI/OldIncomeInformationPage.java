package LendingPointTestAutomation.pageFactory.applyOldUI;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import LendingPointTestAutomation.action.Action;
import LendingPointTestAutomation.baseClass.BaseClass;
import LendingPointTestAutomation.utility.DriverFactory;

public class OldIncomeInformationPage extends BaseClass{
	
	public OldIncomeInformationPage() {
		PageFactory.initElements(DriverFactory.getInstance().getDriver(), this);
	}
	
	@FindBy(xpath = "//div[@class='blockscreen hide']")
	public WebElement blockscreenHide;
	
	@FindBy(xpath = "//span[@class='color-medblue' and text()=\"Income Information\"]")
	public WebElement employmentPageTitle;
	
	@FindBy(xpath = "//input[@id='employerName']")
	public WebElement employerNameTextBox;
	
	@FindBy(xpath = "//input[@id='employerPhone']")
	public WebElement employerPhoneTextBox;
	
	@FindBy(xpath = "//input[@id='workEmailAddress']")
	public WebElement workEmailTextBox;
	
	@FindBy(xpath = "//input[@id='jobTitle']")
	public WebElement jobTitleTextBox;
	
	@FindBy(xpath = "//input[@id='startDate']")
	public WebElement startDateTextBox;
	
	@FindBy(xpath = "//button[@type='submit']")
	public WebElement employmentPageNextButton;
	
	@FindBy(xpath = "//div[@element-view='payment-setup/tabs']")
	public WebElement paymentSetupTab;
	
	@FindBy(xpath = "//label[@data-value='ACH']")
	public WebElement achButton;
	
	@FindBy(xpath = "//label[@data-value='Debit Card']")
	public WebElement debitCardButton;
	
	@FindBy(xpath = "//label[@data-value='Credit Card']")
	public WebElement creditCardButton;
	
	@FindBy(xpath = "//button[@type='submit']")
	WebElement paymentSetupNextButton;
	
	public OldSignContractPage clickPaymentSetupNextButton() {
		Action.moveToElement(paymentSetupNextButton);
		Action.click(paymentSetupNextButton, "Payment setup next button on Old Apply flow");
		return new OldSignContractPage();
	}
	
	public void enterEmployerName(String employerName) {
		Action.type(employerNameTextBox, employerName, "Employer name field on employment tab");
	}
	
	public void enterEmployerPhone(String employerPhone) {
		employerPhoneTextBox.sendKeys(employerPhone);
	}
	
	public void enterWorkEmail(String workEmailAddress) {
		Action.type(workEmailTextBox, workEmailAddress, "Work email field on employment tab");
	}
	
	public void enterJobTitle(String jobTitle) {
		Action.moveToElement(jobTitleTextBox);
		Action.type(jobTitleTextBox, jobTitle, "Job title field on employment tab");
	}
	
	public void enterStartDate(String startDate) {
		Action.type(startDateTextBox, startDate, "Employment start date field on employment tab");
	}
	
	public OldIncomeInformationPage clickEmploymentNextButton() {
		Action.click(employmentPageNextButton, "Employment page next button on Old Apply flow");
		return new OldIncomeInformationPage();
	}

}
