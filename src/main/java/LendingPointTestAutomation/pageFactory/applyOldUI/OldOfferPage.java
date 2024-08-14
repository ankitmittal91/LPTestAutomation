package LendingPointTestAutomation.pageFactory.applyOldUI;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import LendingPointTestAutomation.action.Action;
import LendingPointTestAutomation.baseClass.BaseClass;

public class OldOfferPage extends BaseClass{
	
	public OldOfferPage() {
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath = "//span[text()=\"SELECT OFFER\"]")
	public WebElement selectOfferTitle;
	
	@FindBy(xpath = "//h3[@class='modal-title']")
	public WebElement popUpTitle;
	
	@FindBy(xpath = "(//button[@type='button'])[4]")
	public WebElement chooseButton;
	
	@FindBy(xpath = "(//div[@class='noUi-touch-area'])")
	public WebElement newSlider;
	
	@FindBy(xpath = "//h3[@class='modal-title']")
	public WebElement phoneVerificationPopupTitle;
	
	@FindBy(xpath = "//button[@id='btnResend']")
	public WebElement resendCodeButton;
	
	@FindBy(xpath = "//button[@id='btnResend']")
	public WebElement verificationCodeTextBox;
	
	@FindBy(xpath = "//button[@class='close']")
	WebElement verificationPopupClose;
	
	@FindBy(xpath = "//div[@class='messages error-message message-validation col-xs-12 text-center']")
	public WebElement verificationPopupError;
	
	@FindBy(xpath = "//div[@class='blockscreen hide']")
	public WebElement blockscreenHide;
	
	@FindBy(xpath = "//div[@class='blockscreen']")
	public WebElement blockscreen;
	
	public OldBankInformationPage clickChooseButton() {
		//Action.moveToElement(driver, chooseButton);
		Action.click(driver, chooseButton);
		return new OldBankInformationPage();
	}
	
	public void enterVerificationCode(String verificationCode) {
		for(int i=1; i<verificationCode.length(); i++) {
			String xpath = "(//input[@name='pin'])["+i+"]";
			char c = verificationCode.charAt(i);
			String s = new StringBuilder().append(c).toString();
			driver.findElement(By.xpath(xpath)).sendKeys(s);
		}
	}
	
	public void closeVerificationPopup() {
		Action.click(driver, verificationPopupClose);
	}

}
