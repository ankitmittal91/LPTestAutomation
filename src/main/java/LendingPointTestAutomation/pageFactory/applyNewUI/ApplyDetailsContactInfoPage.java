package LendingPointTestAutomation.pageFactory.applyNewUI;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.*;

import LendingPointTestAutomation.action.Action;
import LendingPointTestAutomation.baseClass.BaseClass;

public class ApplyDetailsContactInfoPage extends BaseClass {
	
	public ApplyDetailsContactInfoPage() {
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath = "//input[@data-testid='mobile-phone-input']")
	public WebElement mobilePhoneTextBox;
	
	@FindBy(xpath = "//input[@data-testid='contact-email-input']")
	WebElement emailTextBox;
	
	@FindBy(xpath = "//div[@class='css-1rynq56 r-1fgbttn r-1kfrs79']")
	WebElement continueToVerificationButton;
	
	public void enterMobilePhone(String mobilePhone) {
		Action.click(driver, mobilePhoneTextBox);
		//mobilePhoneTextBox.clear();
		Action.selectBySendkeys(mobilePhone, mobilePhoneTextBox);
	}
	
	public void enterEmail(String email) {
		Action.type(emailTextBox, email);
	}
	
	public VerifyPhone clickContinueButton() {
		Action.fluentWait(driver, continueToVerificationButton, 10);
		Action.click(driver, continueToVerificationButton);
		return new VerifyPhone();
	}

}
