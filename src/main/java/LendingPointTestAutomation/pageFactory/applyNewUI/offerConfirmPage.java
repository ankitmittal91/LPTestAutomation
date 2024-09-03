package LendingPointTestAutomation.pageFactory.applyNewUI;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import LendingPointTestAutomation.action.Action;
import LendingPointTestAutomation.baseClass.BaseClass;

public class offerConfirmPage extends BaseClass {
	
	public offerConfirmPage() {
		PageFactory.initElements(getDriver(), this);
	}
	
	@FindBy(xpath = "//*[text()=\"Offer Confirmed\"]")
	public WebElement offerConfirmedText;
	
	@FindBy(xpath = "//*[text()=\"Let’s Go\"]")
	WebElement letsGoButton;
	
	public connectDepositAccountPage clickLetsGoButton() {
		Action.moveToElement(getDriver(), letsGoButton);
		Action.click(getDriver(), letsGoButton);
		return new connectDepositAccountPage();
	}

}
