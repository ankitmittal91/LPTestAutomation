package LendingPointTestAutomation.pageFactory.applyNewUI;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.*;

import LendingPointTestAutomation.action.Action;
import LendingPointTestAutomation.baseClass.BaseClass;
import LendingPointTestAutomation.utility.DriverFactory;

public class ApplyDetailsContactInfoPage extends BaseClass {
	
	public ApplyDetailsContactInfoPage() {
		PageFactory.initElements(DriverFactory.getInstance().getDriver(), this);
	}
	
	@FindBy(xpath = "//input[@data-testid='mobile-phone-input']")
	public WebElement mobilePhoneTextBox;
	
	@FindBy(xpath = "//input[@data-testid='contact-email-input']")
	WebElement emailTextBox;
	
	@FindBy(xpath = "//div[@class='css-1rynq56 r-1fgbttn r-1kfrs79']")
	WebElement continueToVerificationButton;
	
	public void enterMobilePhone(String mobilePhone) {
		Action.click(mobilePhoneTextBox, "Mobile textbox on New Apply flow");
		//mobilePhoneTextBox.clear();
		Action.selectBySendkeys(mobilePhone, mobilePhoneTextBox);
	}
	
	public void enterEmail(String email) {
		Action.type(emailTextBox, email, "Email Address field");
	}
	
	public VerifyPhone clickContinueButton() {
		Action.fluentWait(continueToVerificationButton, 10);
		Action.click(continueToVerificationButton, "Continue to verification button on New Apply flow");
		return new VerifyPhone();
	}

}
