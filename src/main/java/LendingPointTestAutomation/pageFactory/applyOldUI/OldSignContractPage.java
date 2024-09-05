package LendingPointTestAutomation.pageFactory.applyOldUI;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import LendingPointTestAutomation.action.Action;
import LendingPointTestAutomation.baseClass.BaseClass;
import LendingPointTestAutomation.utility.DriverFactory;

public class OldSignContractPage extends BaseClass{
	
	public OldSignContractPage() {
		PageFactory.initElements(DriverFactory.getInstance().getDriver(), this);
	}
	
	@FindBy(xpath = "//th[text()=\"Amount financed\"]")
	public WebElement amountFinancedTileTitle;
	
	@FindBy(xpath = "(//input[@type='checkbox'])[1]")
	WebElement checkBox1;
	
	@FindBy(xpath = "(//input[@type='checkbox'])[2]")
	WebElement checkBox2;
	
	@FindBy(xpath = "//button[@type='submit']")
	WebElement signAgreementButton;
	
	public void clickCheckBox1() {
		Action.moveToElement(checkBox1);
		Action.click(checkBox1);
	}
	
	public void clickCheckBox2() {
		Action.click(checkBox2);
	}
	
	public void clickSignAgreementButton() {
		Action.moveToElement(signAgreementButton);
		Action.click(signAgreementButton);
	}

}
