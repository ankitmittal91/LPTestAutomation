package LendingPointTestAutomation.pageFactory.applyOldUI;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import LendingPointTestAutomation.baseClass.BaseClass;

public class OldEmploymentPage extends BaseClass{
	
	public OldEmploymentPage() {
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath = "//span[@class='color-medblue']")
	public WebElement employmentPageTitle;
}
