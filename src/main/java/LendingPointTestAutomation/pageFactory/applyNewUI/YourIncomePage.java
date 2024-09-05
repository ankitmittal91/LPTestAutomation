package LendingPointTestAutomation.pageFactory.applyNewUI;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import LendingPointTestAutomation.action.Action;
import LendingPointTestAutomation.baseClass.BaseClass;
import LendingPointTestAutomation.utility.DriverFactory;

public class YourIncomePage extends BaseClass{
	
	public YourIncomePage() {
		PageFactory.initElements(DriverFactory.getInstance().getDriver(), this);
	}
	
	@FindBy(xpath="//input[@data-testid='annual-individual-income-input']")
	public WebElement annualIncomeTextBox;
	
	@FindBy(xpath="//div[@class='css-175oi2r r-11c0sde']//select")
	WebElement incomeTypeDropDown;
	
	@FindBy(xpath="//input[@data-testid='income-company-name-input']")
	public WebElement companyNameTextBox;
	
	@FindBy(xpath="//*[text()=\"Continue to About You\"]")
	WebElement continueToAboutYouButton;
	
	public void enterAnnualIncome(String annualIncome) {
		Action.type(annualIncomeTextBox, annualIncome);
	}
	
	public void selectIncomeType(String incomeType) {
		Action.selectByValue(incomeTypeDropDown, incomeType);
	}
	
	public void enterCompanyName(String companyName) {
		Action.moveToElement(companyNameTextBox);
		Action.type(companyNameTextBox, companyName);
	}
	
	public AboutYouDOBSSNPage clickContinueToAboutYouButton() {
		Action.moveToElement(continueToAboutYouButton);
		Action.click(continueToAboutYouButton);
		return new AboutYouDOBSSNPage();
	}

}
