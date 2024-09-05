package LendingPointTestAutomation.pageFactory.applyNewUI;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import LendingPointTestAutomation.action.Action;
import LendingPointTestAutomation.baseClass.BaseClass;
import LendingPointTestAutomation.utility.DriverFactory;

public class selectOfferPage extends BaseClass {
	
	public selectOfferPage() {
		PageFactory.initElements(DriverFactory.getInstance().getDriver(), this);
	}
	
	@FindBy(xpath = "//*[text()=\"Congratulations!\"]")
	public WebElement congratulationsText;
	
	@FindBy(xpath = "//*[text()=\"Confirm Offer\"]")
	WebElement confirmOfferButton;
	
	public offerConfirmPage clickConfirmOfferButton() {
		Action.moveToElement(confirmOfferButton);
		Action.click(confirmOfferButton);
		return new offerConfirmPage();
	}

}
