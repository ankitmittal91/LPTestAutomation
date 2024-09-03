package LendingPointTestAutomation.pageFactory.applyNewUI;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.*;

import LendingPointTestAutomation.action.Action;
import LendingPointTestAutomation.baseClass.BaseClass;

public class ApplyDetailsContactInfoPage extends BaseClass {
	
	public ApplyDetailsContactInfoPage() {
		PageFactory.initElements(getDriver(), this);
	}
	
	@FindBy(xpath = "//input[@data-testid='mobile-phone-input']")
	public WebElement mobilePhoneTextBox;
	
	@FindBy(xpath = "//input[@data-testid='contact-email-input']")
	WebElement emailTextBox;
	
	@FindBy(xpath = "//div[@class='css-1rynq56 r-1fgbttn r-1kfrs79']")
	WebElement continueToVerificationButton;
	
	public void enterMobilePhone(String mobilePhone) {
		Action.click(getDriver(), mobilePhoneTextBox);
		//mobilePhoneTextBox.clear();
		Action.selectBySendkeys(mobilePhone, mobilePhoneTextBox);
	}
	
	public void enterEmail(String email) {
		Action.type(emailTextBox, email);
	}
	
	public VerifyPhone clickContinueButton() {
		Action.fluentWait(getDriver(), continueToVerificationButton, 10);
		Action.click(getDriver(), continueToVerificationButton);
		return new VerifyPhone();
	}

}
