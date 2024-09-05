package LendingPointTestAutomation.pageFactory.applyNewUI;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import LendingPointTestAutomation.action.Action;
import LendingPointTestAutomation.baseClass.BaseClass;
import LendingPointTestAutomation.utility.DriverFactory;

public class offerConfirmPage extends BaseClass {
	
	public offerConfirmPage() {
		PageFactory.initElements(DriverFactory.getInstance().getDriver(), this);
	}
	
	@FindBy(xpath = "//*[text()=\"Offer Confirmed\"]")
	public WebElement offerConfirmedText;
	
	@FindBy(xpath = "//*[text()=\"Let’s Go\"]")
	WebElement letsGoButton;
	
	public connectDepositAccountPage clickLetsGoButton() {
		Action.moveToElement(letsGoButton);
		Action.click(letsGoButton, "Lets Go button on New Apply flow");
		return new connectDepositAccountPage();
	}

}
