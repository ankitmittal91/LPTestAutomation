package LendingPointTestAutomation.pageFactory.applyNewUI;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import LendingPointTestAutomation.action.Action;
import LendingPointTestAutomation.baseClass.BaseClass;
import LendingPointTestAutomation.utility.DriverFactory;

public class IncomeAddressFillPage extends BaseClass {
	
	public IncomeAddressFillPage() {
		PageFactory.initElements(DriverFactory.getInstance().getDriver(), this);
	}
	
	@FindBy(xpath = "//input[@data-testid='fill-address-input']")
	public WebElement addressTextBox;
	
	@FindBy(xpath = "//input[@data-testid='fill-address-city-input']")
	WebElement cityTextBox;
	
	@FindBy(xpath = "//div[@class='css-175oi2r r-13awgt0 r-1kb76zh']/select")
	WebElement stateDropDown;
	
	@FindBy(xpath = "//input[@data-testid='fill-address-zip-input']")
	WebElement zipTextBox;
	
	@FindBy(xpath="//*[text()=\"Continue to Your Income\"]")
	WebElement continueToIncomeButton;
	
	public void enterAddress(String address) {
		Action.click(addressTextBox);
		Action.type(addressTextBox, address);
	}
	
	public void enterCity(String city) {
		Action.click(cityTextBox);
		Action.type(cityTextBox, city);
	}
	
	public void selectState(String state) {
		Action.selectByValue(stateDropDown, state);
	}
	
	public void enterZip(String zip) {
		Action.click(zipTextBox);
		Action.type(zipTextBox, zip);
	}
	
	public YourIncomePage clickContinuetoIncomeButton() {
		Action.click(continueToIncomeButton);
		return new YourIncomePage();
	}

}
