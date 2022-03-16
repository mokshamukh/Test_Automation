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
	By achInformationChkBox = By.xpath("//p-checkbox[@inputid='achInformation']");
	By nextButton = By.xpath("//button[contains(@aria-label,'To go to the next step')]");
	By beneficiaryBankHeader = By.xpath("(//h4[@id='cardTitlebeneficiaryBank']//span[contains(text(),'Beneficiary Bank')])[1]");
	By beneBankIDTypeField = By.xpath("//p-dropdown[@inputid='beneficiaryBankIdType-input']");
	By beneBankCountryField = By.xpath("//p-dropdown[@inputid='beneficiaryBankCountry-input']");
	By beneBankIDField = By.xpath("//input[@id='beneficiaryBankId']");
	By beneBankNameField = By.xpath("//input[@id='beneficiaryBankName']");
	By addressAddPayeeField1 = By.xpath("//input[@id='address']");
	By addressAddPayeeField2 = By.xpath("//input[@id='address2']");
	By beneCountryField = By.xpath("//p-dropdown[@inputid='beneficiaryCountry-input']");
	By addWirePayeeAccountButton = By.xpath("(//button[contains(@aria-label,'To go to the Add Payee Account screen, click the Add Payee Account.')])[2]");
	By saveButton = By.xpath("//button[text()='Save']");
	By successfulPayeesMsg = By.xpath("//div[text()='Successfully saved payee.']");
	By searchButton = By.xpath("//button[@aria-label='To go to the search section, click the Search.']");
	By searchPayeeIDField = By.xpath("//input[@id='payeeId']");
	By searchPayeeNameField = By.xpath("//input[@id='payeeName']");
	By searchIcon = By.xpath("//button[contains(@aria-label,' click the icon')]//i[text()='search']");
	By accountAddedMsg = By.xpath("//div[contains(text(),'An account has been added or modified to the payee')]");
	By achInfoHeader = By.xpath("//h3[text()='ACH Information'][@class='card-title']");
    By achBankId = By.xpath("//input[@id='bankId']");
    By achBankName = By.xpath("//input[@id='bankName']");
    By debitAuthTypeField = By.xpath("//p-dropdown//input[@id='authorizationType-input']/..//..//span[contains(@class,'expand_more')]");
    By addAchPayeeAccButton = By.xpath("(//button[contains(@aria-label,'To go to the Add Payee Account screen, click the Add Payee Account.')])[1]");

	String payeeTypeList = "//p-dropdown[@inputid='payeeType-input']//li[@aria-label='%s']";
	String beneIDTypeList = "//p-dropdown[@inputid='beneficiaryBankIdType-input']//li[@aria-label='%s']";
	String beneBankCountryList = "//p-dropdown[@inputid='beneficiaryBankCountry-input']//li[@aria-label='%s']";
	String beneCountryList = "//p-dropdown[@inputid='beneficiaryCountry-input']//li[@aria-label='%s']";
	String searchData = "//td[@class='ng-star-inserted']//span[contains(text(),'%s')]";
	String list = "//li[@role='option']/span[contains(text(),'%s')]";


	public void createNewPayeeAndSearch(String payeeName,String payeeID,String payeeType,String address1,
			String address2,String accountNumber,String templateInfo,String bankId,String bankName,String debitType,   
			String beneBankIDType,String beneBankCountry,
			String beneBankID,String beneBankName,String beneCountry) throws Exception {
		if (System.getProperty("runStep")=="Y"){	
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
						waitElement(3000);
						clickOnElement("Corporate New Payee", "Payee Type", payeeTypeField);
						waitElement(3000);
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
					if(!templateInfo.equals("Wire")) {
						waitElement(3000);
						clickOnElement("Corporate New Payee", "ACH Information Payment", achInformationChkBox);
						waitElement(2000);
						clickOnElement("Corporate New Payee", "Next Button", nextButton);
						waitForPresenceOfElement("Corporate New Payee", "ACH Info header", achInfoHeader);
						enterACHtemplatesInfo(bankId, bankName, debitType);
					}
					
					else {
						waitElement(1000);
						clickOnElement("Corporate New Payee", "Wire Information Payment", wireInformationChkBox);
					
					clickOnElement("Corporate New Payee", "Next Button", nextButton);
					waitForPresenceOfElement("Corporate New Payee", "Beneficiary", beneficiaryBankHeader);
					
					if(!beneBankIDType.equals("")) {
						waitElement(3000);
						clickOnElement("Corporate New Payee", "Payee Type", beneBankIDTypeField);
						waitElement(3000);
						getDynamicElementClick("Corporate New Payee", "Payee Type", beneIDTypeList, beneBankIDType);
					}
					if(!beneBankCountry.equals("")) {
						waitElement(3000);
						clickOnElement("Corporate New Payee", "Payee Type", beneBankCountryField);
						waitElement(3000);
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
						waitElement(3000);
						clickOnElement("Corporate New Payee", "Payee Type", beneCountryField);
						waitElement(3000);
						getDynamicElementClick("Corporate New Payee", "Payee Type", beneCountryList, beneCountry);
					}
					waitForPresenceOfElement("Corporate New Payee", "Add Payee Button", addWirePayeeAccountButton);
					clickOnElement("Corporate New Payee", "Add Payee Button", addWirePayeeAccountButton);
				}
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
	                 waitElement(3000);
	                 clickOnElement("Corporate New Payee", "Search Icon", searchIcon);
	                 waitElement(3000);
	                 isElementPresent(getDynamicElement("Corporate New Payee", searchData, payeeName));
	             	stepResult = true;
				}
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} finally {
				if (stepResult==true){
					System.out.println("Pass - From acc");
					new HTMLReportHelper().HtmlReportBody("Payee created", "Payee created Successfully", "Passed", driver, "Y");
				}
				else{
					System.out.println("fail");
					new HTMLReportHelper().HtmlReportBody("Payee created", "Could not create payee Successfully", "Failed", driver, "Y");
					System.setProperty("runStep","N");
				}
			}
		}
	}
	
	public void enterACHtemplatesInfo(String bankId,String bankName,String debitType) throws Exception {
		if (System.getProperty("runStep")=="Y"){	
			boolean stepResult = false;
			try {
				if (isElementPresent(achInfoHeader)) {
					if (!bankId.equals("")) {
						clearAndType("Corporate New Payee", "Bank Id", achBankId, bankId);
					}
					if(!bankName.equals("")) {
						clearAndType("Corporate New Payee", "Bank Name", achBankName, bankName);	
					}
					if(!bankName.equals("")) {
						clearAndType("Corporate New Payee", "Bank Name", achBankName, bankName);	
					}
					if(!debitType.equals("")) {
						waitElement(3000);
						selectElementFromListbox("ACH Batch Template", "Debit Authorization Type", debitAuthTypeField, list,debitType);
					}
					waitForPresenceOfElement("Corporate New Payee", "Add Payee Button", addAchPayeeAccButton);
					clickOnElement("Corporate New Payee", "Add Payee Button", addAchPayeeAccButton);
					stepResult = true;
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			if (stepResult==true){
				System.out.println("Pass - From acc");
				new HTMLReportHelper().HtmlReportBody("Payee created", "Payee created Successfully", "Passed", driver, "Y");
			}
			else{
				System.out.println("fail");
				new HTMLReportHelper().HtmlReportBody("Payee created", "Could not create payee Successfully", "Failed", driver, "Y");
				System.setProperty("runStep","N");
			}
		}
	}
}

}
