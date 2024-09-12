package LendingPointTestAutomation.pageFactory.applyNewUI;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import LendingPointTestAutomation.action.Action;
import LendingPointTestAutomation.baseClass.BaseClass;
import LendingPointTestAutomation.utility.DriverFactory;

public class ApplyPage extends BaseClass {
	
	public ApplyPage() {
		PageFactory.initElements(DriverFactory.getInstance().getDriver(), this);
	}
	
	@FindBy(xpath = "//input[@data-testid='first-name-input']")
	public WebElement firstNameTextBox;
	
	@FindBy(xpath = "//input[@data-testid='last-name-input']")
	public WebElement lastNameTextBox;
	
	@FindBy(xpath = "//input[@data-testid='loan-amount-input']")
	public WebElement loanAmountTextBox;
	
	@FindBy(xpath = "//div[@class='css-175oi2r r-11c0sde']/select")
	public WebElement loanPurposeDropDown;
	
	@FindBy(xpath = "//div[@class='css-1rynq56 r-1fgbttn r-1kfrs79']")
	public WebElement continueButton;
	
	public void enterFirstName(String firstName) {
		Action.type(firstNameTextBox, firstName, "First name field");
	}
	
	public void enterLastName(String lastName) {
		Action.type(lastNameTextBox, lastName, "Last name field");
	}
	
	public void enterLoanAmount(String loanAmount) {
		Action.click(loanAmountTextBox, "Loan Amount Textbox");
		loanAmountTextBox.clear();
		Action.enterTextByCharacter(loanAmountTextBox, loanAmount, 0);
	}
	
	public void selectLoanPurpose() {
		Action.selectByValue(loanPurposeDropDown, "Unexpected urgent expense");
	}
	
	public ApplyDetailsContactInfoPage clickContinueButton() {
		Action.fluentWait(continueButton, 10);
		Action.click(continueButton, "Continue button on Apply Page");
		return new ApplyDetailsContactInfoPage();
	}
}
