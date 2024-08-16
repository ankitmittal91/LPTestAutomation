package LendingPointTestAutomation.pageFactory.applyOldUI;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import LendingPointTestAutomation.action.Action;
import LendingPointTestAutomation.baseClass.BaseClass;

public class OldSignContractPage extends BaseClass{
	
	public OldSignContractPage() {
		PageFactory.initElements(driver, this);
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
		Action.moveToElement(driver, checkBox1);
		Action.click(driver, checkBox1);
	}
	
	public void clickCheckBox2() {
		Action.click(driver, checkBox2);
	}
	
	public void clickSignAgreementButton() {
		Action.moveToElement(driver, signAgreementButton);
		Action.click(driver, signAgreementButton);
	}

}
