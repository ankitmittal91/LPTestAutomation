package LendingPointTestAutomation.pageFactory.applyNewUI;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import LendingPointTestAutomation.action.Action;
import LendingPointTestAutomation.baseClass.BaseClass;
import LendingPointTestAutomation.utility.Log;

public class VerifyPhone extends BaseClass{
	
	public VerifyPhone() {
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath = "//div[@class='css-175oi2r r-1v1z2uz']//input")
	public WebElement codeTextBox1;
	
	@FindBy(xpath = "//*[text()='Verify']")
	public WebElement verifyButton;

	public void enterVerificationCode(String code) {
		char c = code.charAt(0);
		String s = new StringBuilder().append(c).toString();
		codeTextBox1.sendKeys(s);
		for(int i=1; i<code.length(); i++) {
			String xpath = "//div[@class='css-175oi2r r-13hce6t r-1v1z2uz']["+i+"]//input";
			c = code.charAt(i);
			s = new StringBuilder().append(c).toString();
			driver.findElement(By.xpath(xpath)).sendKeys(s);
		}
	}
	
	public IncomeAddressFillPage clickVerifyButton() {
		Action.click(driver, verifyButton);
		return new IncomeAddressFillPage();
	}
}
