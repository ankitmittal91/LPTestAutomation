package LendingPointTestAutomation.pageFactory.applyOldUI;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import LendingPointTestAutomation.action.Action;
import LendingPointTestAutomation.baseClass.BaseClass;
import LendingPointTestAutomation.utility.DriverFactory;

public class OldBankInformationPage extends BaseClass{
	
	public OldBankInformationPage() {
		PageFactory.initElements(DriverFactory.getInstance().getDriver(), this);
	}
	
	@FindBy(xpath = "//li[@step-name='offers'][@class='step done']")
	public WebElement offerStepDone;
	
	@FindBy(xpath = "//span[@class='color-medblue text-capitalize title-bank-info']")
	public WebElement bankInformationTitle;
	
	@FindBy(xpath = "//div[@class='bank-info-card']")
	public WebElement connectPlaidButton;
	
	@FindBy(xpath = "//iframe[@id='plaid-link-iframe-1']")
	public WebElement plaidIframe;
	
	@FindBy(xpath = "//button[@id='aut-button']")
	public WebElement plaidContinueButton;
	
	@FindBy(xpath = "//div[@class='blockscreen']")
	public WebElement blockscreenLoader;
	
	@FindBy(xpath = "//div[@class='blockscreen hide']")
	public WebElement blockscreenLoaderHidden;
	
	@FindBy(xpath = "//input[@id='search-input']")
	public WebElement plaidBankSearchBox;
	
	@FindBy(xpath = "(//h2[@class='SearchAndSelectPane-module__title'])[1]")
	public WebElement plaidSearchResultTile1;
	
	@FindBy(xpath = "(//h2[@class='SearchAndSelectPane-module__title'])[2]")
	public WebElement plaidSearchResultTile2;
	
	@FindBy(xpath = "(//h2[@class='SearchAndSelectPane-module__title'])[4]")
	public WebElement plaidInstitutionsFoundTile;
	
	@FindBy(xpath = "//input[@id='aut-input-0']")
	public WebElement plaidUsernameTextBox;
	
	@FindBy(xpath = "//input[@id='aut-input-1']")
	WebElement plaidPasswordTextBox;
	
	@FindBy(xpath = "//button[@id='aut-button'  and @aria-disabled='false']")
	public WebElement plaidSubmitButton;
	
	@FindBy(xpath = "//label[@for='aut-selection-1']")
	public WebElement plaidSavingAccountTile;
	
	public OldBankInformationPage clickConnectPlaidButton() {
		Action.click(connectPlaidButton, "Plaid Connect button on Old Apply flow");
		return new OldBankInformationPage();
	}
	
	public void clickContinuePlaidButton() {
		Action.moveToElement(plaidContinueButton);
		Action.click(plaidContinueButton, "Plaid Continue button on Old Apply flow");
	}
	
	public void searchPlaidBank(String bankName) {
		Action.type(plaidBankSearchBox, bankName, "Bank Name field on Plaid screen");
	}
	
	public void selectPlaidBank1() {
		Action.click(plaidSearchResultTile1, "Plaid bank search textbox on Old Apply flow");
	}
	
	public void selectPlaidBank2() {
		Action.click(plaidSearchResultTile2, "Plaid bank tile on Old Apply flow");
	}
	
	public void enterPlaidUsername(String plaidUsername) {
		Action.type(plaidUsernameTextBox, plaidUsername, "Plaid username field");
	}
	
	public void enterPlaidPassword(String plaidPassword) {
		Action.type(plaidPasswordTextBox, plaidPassword, "Plaid password field");
	}
	
	public void clickPlaidSubmitButton1() {
		Action.click(plaidSubmitButton, "Plaid credentials submit button on Old Apply flow");
	}
	
	public OldIncomeInformationPage clickPlaidSubmitButton2() {
		Action.click(plaidSubmitButton, "Plaid submit button on Old Apply flow");
		return new OldIncomeInformationPage();
	}
	
	public void clickPlaidSavingAccountTile() {
		Action.click(plaidSavingAccountTile, "Plaid Account tile on Old Apply flow");
	}

}
