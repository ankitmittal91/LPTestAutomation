package LendingPointTestAutomation.pageFactory.applyNewUI;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import LendingPointTestAutomation.action.Action;
import LendingPointTestAutomation.baseClass.BaseClass;

public class YourIncomePage extends BaseClass{
	
	public YourIncomePage() {
		PageFactory.initElements(driver, this);
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
		Action.moveToElement(driver, companyNameTextBox);
		Action.type(companyNameTextBox, companyName);
	}
	
	public AboutYouDOBSSNPage clickContinueToAboutYouButton() {
		Action.moveToElement(driver, continueToAboutYouButton);
		Action.click(driver, continueToAboutYouButton);
		return new AboutYouDOBSSNPage();
	}

}
