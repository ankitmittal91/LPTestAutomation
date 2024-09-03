package LendingPointTestAutomation.pageFactory.applyNewUI;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import LendingPointTestAutomation.action.Action;
import LendingPointTestAutomation.baseClass.BaseClass;

public class AboutYouDOBSSNPage extends BaseClass{
	
	public AboutYouDOBSSNPage() {
		PageFactory.initElements(getDriver(), this);
	}
	
	@FindBy(xpath = "//input[@data-testid='about-you-birthday-input']")
	public WebElement dobTextBox;
	
	@FindBy(xpath = "//input[@data-testid='about-you-ssn-input']")
	WebElement ssnTextBox;
	
	@FindBy(xpath = "//*[text()=\"See Your Options\"]")
	WebElement seeOptionsButton;
	
	public void enterDOB(String dob) {
		Action.click(getDriver(), dobTextBox);
		Action.type(dobTextBox, dob);
	}
	
	public void enterSSN(String ssn) {
		Action.click(getDriver(), ssnTextBox);
		Action.enterTextByCharacter(ssnTextBox, ssn, 0);
	}
	
	public selectOfferPage clickSeeOptionsButton() {
		Action.moveToElement(getDriver(), seeOptionsButton);
		Action.click(getDriver(), seeOptionsButton);
		return new selectOfferPage();
	}

}
