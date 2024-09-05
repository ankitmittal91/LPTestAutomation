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
		Action.click(paymentSetupNextButton);
		return new OldSignContractPage();
	}
	
	public void enterEmployerName(String employerName) {
		Action.type(employerNameTextBox, employerName);
	}
	
	public void enterEmployerPhone(String employerPhone) {
		Action.type(employerPhoneTextBox, employerPhone);
	}
	
	public void enterWorkEmail(String workEmailAddress) {
		Action.type(workEmailTextBox, workEmailAddress);
	}
	
	public void enterJobTitle(String jobTitle) {
		Action.moveToElement(jobTitleTextBox);
		Action.type(jobTitleTextBox, jobTitle);
	}
	
	public void enterStartDate(String startDate) {
		Action.type(startDateTextBox, startDate);
	}
	
	public OldIncomeInformationPage clickEmploymentNextButton() {
		Action.click(employmentPageNextButton);
		return new OldIncomeInformationPage();
	}

}
