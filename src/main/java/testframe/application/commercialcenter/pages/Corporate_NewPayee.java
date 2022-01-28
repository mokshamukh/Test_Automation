package testframe.application.commercialcenter.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

/**
 * PageNage : Corporate_NewPayee
 * 
 * @author shilpa.thangapalam
 */

import testframe.application.common.CommonLibrary;
import testframe.common.reporting.HTMLReportHelper;

public class Corporate_NewPayee extends CommonLibrary{

	public Corporate_NewPayee(WebDriver driver) {
		super(driver);
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	By createPayeeTitle = By.xpath("//h1[text()='Create Payee']");
	By payeeNameField = By.xpath("//input[@id='payeeName']");
	By payeeIdField = By.xpath("//input[@id='payeeId']");
	By address1Field = By.xpath("//input[@id='address1']");
	By address2Field = By.xpath("//input[@id='addressField2']");
	By payeeTypeField = By.xpath("//p-dropdown[@inputid='payeeType-input']");
	By addPayeeAccount = By.xpath("//button[contains(@aria-label,'click the Add Account')]");
	By addPayeeDrawer = By.xpath("//h3[contains(text(),'Add Payee Account')]");
	By accountNumberField = By.xpath("//input[@id='accountNumber']");
	By wireInformationChkBox = By.xpath("//p-checkbox[@inputid='wireInformation']");
	By nextButton = By.xpath("//button[contains(@aria-label,'To go to the next step')]");
	By beneficiaryBankHeader = By.xpath("(//h4[@id='cardTitlebeneficiaryBank']//span[contains(text(),'Beneficiary Bank')])[1]");
	By beneBankIDTypeField = By.xpath("//p-dropdown[@inputid='beneficiaryBankIdType-input']");
	By beneBankCountryField = By.xpath("//p-dropdown[@inputid='beneficiaryBankCountry-input']");
	By beneBankIDField = By.xpath("//input[@id='beneficiaryBankId']");
	By beneBankNameField = By.xpath("//input[@id='beneficiaryBankName']");
	By addressAddPayeeField1 = By.xpath("//input[@id='address']");
	By addressAddPayeeField2 = By.xpath("//input[@id='address2']");
	By beneCountryField = By.xpath("//p-dropdown[@inputid='beneficiaryCountry-input']");
	By addPayeeAccountButton = By.xpath("(//button[contains(@aria-label,'To go to the Add Payee Account screen, click the Add Payee Account.')])[2]");
	By saveButton = By.xpath("//button[text()='Save']");
	By successfulPayeesMsg = By.xpath("//div[text()='Successfully saved payee.']");
	By searchButton = By.xpath("//button[@aria-label='To go to the search section, click the Search.']");
	By searchPayeeIDField = By.xpath("//input[@id='payeeId']");
	By searchPayeeNameField = By.xpath("//input[@id='payeeName']");
	By searchIcon = By.xpath("//button[contains(@aria-label,' click the icon')]//i[text()='search']");
	By accountAddedMsg = By.xpath("//div[contains(text(),'An account has been added or modified to the payee')]");
	
	
	
	String payeeTypeList = "//p-dropdown[@inputid='payeeType-input']//li[@aria-label='%s']";
	String beneIDTypeList = "//p-dropdown[@inputid='beneficiaryBankIdType-input']//li[@aria-label='%s']";
	String beneBankCountryList = "//p-dropdown[@inputid='beneficiaryBankCountry-input']//li[@aria-label='%s']";
	String beneCountryList = "//p-dropdown[@inputid='beneficiaryCountry-input']//li[@aria-label='%s']";
	String searchData = "//td[@class='ng-star-inserted']//span[contains(text(),'%s')]";
	
	
	public void createNewPayeeAndSearch(String payeeName,String payeeID,String payeeType,String address1,
			String address2,String accountNumber,String beneBankIDType,String beneBankCountry,
			String beneBankID,String beneBankName,String beneCountry) throws Exception {
		boolean stepResult = false;
		try {
			if (isElementPresent(createPayeeTitle)) {
				if (!payeeName.equals("")) {
					clearAndType("Corporate New Payee", "Payee Name", payeeNameField, payeeName);
				}
				if(!payeeID.equals("")) {
					clearAndType("Corporate New Payee", "Payee ID", payeeIdField, payeeID);	
				}
				if(!payeeType.equals("")) {
					clickOnElement("Corporate New Payee", "Payee Type", payeeTypeField);
					getDynamicElementClick("Corporate New Payee", "Payee Type", payeeTypeList, payeeType);
					//selectElementFromListbox("Corporate New Payee", fieldName, payeeTypeField, field, text);
				}
				if(!address1.equals("")) {
					enterText("Corporate New Payee", "Address Field", address1Field, address1);
				}
				if(!address2.equals("")) {
					enterText("Corporate New Payee", "Address Field", address2Field, address2);
				}
				clickOnElement("Corporate New Payee", "Add Account", addPayeeAccount);
				waitForPresenceOfElement("Corporate New Payee", "Add Payee Drawer", addPayeeDrawer);
				
				if(!accountNumber.equals("")) {
					enterText("Corporate New Payee", "Account Number", accountNumberField, accountNumber);
				}
				if(isElementPresent(wireInformationChkBox)) {
					clickOnElement("Corporate New Payee", "Wire Information Payment", wireInformationChkBox);
				}
				clickOnElement("Corporate New Payee", "Next Button", nextButton);
				waitForPresenceOfElement("Corporate New Payee", "Beneficiary", beneficiaryBankHeader);
				
				if(!beneBankIDType.equals("")) {
					clickOnElement("Corporate New Payee", "Payee Type", beneBankIDTypeField);
					getDynamicElementClick("Corporate New Payee", "Payee Type", beneIDTypeList, beneBankIDType);
				}
				if(!beneBankCountry.equals("")) {
					clickOnElement("Corporate New Payee", "Payee Type", beneBankCountryField);
					getDynamicElementClick("Corporate New Payee", "Payee Type", beneBankCountryList, beneBankCountry);
				}
				if(!beneBankID.equals("")) {
					enterText("Corporate New Payee", "Account Number", beneBankIDField, beneBankID);
				}
				if(!beneBankName.equals("")) {
					enterText("Corporate New Payee", "Account Number", beneBankNameField, beneBankName);
				}
				if(!address1.equals("")) {
					enterText("Corporate New Payee", "Account Number", addressAddPayeeField1, address1);
				}
				if(!address2.equals("")) {
					enterText("Corporate New Payee", "Account Number", addressAddPayeeField2, address1);
				}
				if(!beneCountry.equals("")) {
					clickOnElement("Corporate New Payee", "Payee Type", beneCountryField);
					getDynamicElementClick("Corporate New Payee", "Payee Type", beneCountryList, beneCountry);
				}
				waitForPresenceOfElement("Corporate New Payee", "Add Payee Button", addPayeeAccountButton);
				clickOnElement("Corporate New Payee", "Add Payee Button", addPayeeAccountButton);
				waitForPresenceOfElement("Corporate New Payee", "Create Payee Title", createPayeeTitle);
				if(isElementPresent(accountAddedMsg)) {
					clickOnElement("Corporate New Payee", "Save Button", saveButton);
				}
				waitForPresenceOfElement("Corporate New Payee", "Successful Msg", successfulPayeesMsg);
				if(isElementPresent(searchButton)) {
					clickOnElement("Corporate New Payee", "Search Button", searchButton);
				}
				if(!payeeID.equals("")) {
					enterText("Corporate New Payee", "Search Payee", searchPayeeIDField, payeeID);
				}
				if(!payeeName.equals("")) {
					enterText("Corporate New Payee", "Search Payee", searchPayeeNameField, payeeName);
				}
                 isElementPresent(searchIcon);
                 clickOnElement("Corporate New Payee", "Search Icon", searchIcon);
                 isElementPresent(getDynamicElement("Corporate New Payee", searchData, payeeName));
			}
			
			stepResult = true;
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			if (stepResult==true){
				System.out.println("Pass - From acc");
				new HTMLReportHelper().HtmlReportBody("Corporate New Payee CC- Corporate application", "New Payee created Successfully", "Passed", driver, "Y");
			}
			else{
				System.out.println("fail");
				new HTMLReportHelper().HtmlReportBody("Corporate New Payee CC- Corporate application", "Could not create New Payee Successfully", "Failed", driver, "Y");
			}
		}
	}
	
	
}
