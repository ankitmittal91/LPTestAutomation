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
		Action.click(addressTextBox, "Address textbox on New Apply flow");
		Action.type(addressTextBox, address, "Address field");
	}
	
	public void enterCity(String city) {
		Action.click(cityTextBox, "City textbox on New Apply flow");
		Action.type(cityTextBox, city, "City field");
	}
	
	public void selectState(String state) {
		Action.selectByValue(stateDropDown, state);
	}
	
	public void enterZip(String zip) {
		Action.click(zipTextBox, "Zip Code textbox on New Apply flow");
		Action.type(zipTextBox, zip, "Zip Code field");
	}
	
	public YourIncomePage clickContinuetoIncomeButton() {
		Action.click(continueToIncomeButton, "Continue to Income button on New Apply flow");
		return new YourIncomePage();
	}

}
