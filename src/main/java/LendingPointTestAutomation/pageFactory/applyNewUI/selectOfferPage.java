package LendingPointTestAutomation.pageFactory.applyNewUI;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import LendingPointTestAutomation.action.Action;
import LendingPointTestAutomation.baseClass.BaseClass;

public class selectOfferPage extends BaseClass {
	
	public selectOfferPage() {
		PageFactory.initElements(getDriver(), this);
	}
	
	@FindBy(xpath = "//*[text()=\"Congratulations!\"]")
	public WebElement congratulationsText;
	
	@FindBy(xpath = "//*[text()=\"Confirm Offer\"]")
	WebElement confirmOfferButton;
	
	public offerConfirmPage clickConfirmOfferButton() {
		Action.moveToElement(getDriver(), confirmOfferButton);
		Action.click(getDriver(), confirmOfferButton);
		return new offerConfirmPage();
	}

}
