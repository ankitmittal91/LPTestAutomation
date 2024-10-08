package LendingPointTestAutomation.pageFactory.applyNewUI;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import LendingPointTestAutomation.action.Action;
import LendingPointTestAutomation.baseClass.BaseClass;
import LendingPointTestAutomation.utility.DriverFactory;

public class AboutYouDOBSSNPage extends BaseClass{
	
	public AboutYouDOBSSNPage() {
		PageFactory.initElements(DriverFactory.getInstance().getDriver(), this);
	}
	
	@FindBy(xpath = "//input[@data-testid='about-you-birthday-input']")
	public WebElement dobTextBox;
	
	@FindBy(xpath = "//input[@data-testid='about-you-ssn-input']")
	WebElement ssnTextBox;
	
	@FindBy(xpath = "//*[text()=\"See Your Options\"]")
	WebElement seeOptionsButton;
	
	public void enterDOB(String dob) {
		Action.click(dobTextBox, "DOB textbox on New Apply flow");
		Action.type(dobTextBox, dob, "Date of birth field");
	}
	
	public void enterSSN(String ssn) {
		Action.click(ssnTextBox, "SSN textbox on New Apply flow");
		Action.enterTextByCharacter(ssnTextBox, ssn, 0);
	}
	
	public selectOfferPage clickSeeOptionsButton() {
		Action.moveToElement(seeOptionsButton);
		Action.click(seeOptionsButton, "See Options button on New Apply flow");
		return new selectOfferPage();
	}

}
