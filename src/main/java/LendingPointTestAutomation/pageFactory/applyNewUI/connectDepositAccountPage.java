package LendingPointTestAutomation.pageFactory.applyNewUI;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import LendingPointTestAutomation.action.Action;
import LendingPointTestAutomation.baseClass.BaseClass;

public class connectDepositAccountPage extends BaseClass {
	
	public connectDepositAccountPage() {
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath = "//*[text()=\"Connect Deposit\"]")
	public WebElement connectDepositAccountText;
	
	@FindBy(xpath = "//*[text()=\"Connect Bank\"]")
	WebElement connectBankButton;
	
	public void clickConnectBankButton() {
		Action.click(driver, connectBankButton);
	}

}
