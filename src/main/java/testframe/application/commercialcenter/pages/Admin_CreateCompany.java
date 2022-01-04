package testframe.application.commercialcenter.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

import testframe.application.common.CommonLibrary;
import testframe.common.reporting.HTMLReportHelper;

/**
 * PageNage : CommercialCenter_Admin_CreateCompany
 * 
 * @author Ketki.Badalwar
 */

public class Admin_CreateCompany extends CommonLibrary {

	public String adminCreateCompany;

	By createCompanyTitle = By.xpath("//h1[text()='Create Company']");
	By companyId = By.xpath("//input[@id='companyvo.code']");
	By companyName = By.xpath("//input[@id='companyvo.name']");
	By businessUnit = By.xpath("//input[@id='companyvo.businessunit']");
	By streetAddress = By.xpath("//textarea[@id='companyvo.streetaddress']");
	By cityName = By.xpath("//input[@id='companyvo.city']");
	By stateName = By.xpath("//input[@id='companyvo.state']");
	By zipcode = By.xpath("//input[@id='companyvo.zipcode']");
	By country = By.xpath("//select[@id='companyvo.country']");
	By marketSegment = By.xpath("//select[@id='companyvo.marketsegment']");
	By billingAccount = By.xpath("//input[@id='companyvo.billingaccount']");
	By timeZone = By.xpath("//select[@id='companyvo.timezone']");
	By enableDate = By.xpath("//input[@name='datepicker_companyvo.enabledate']");
	By processingCentre = By.xpath("//select[@id='companyvo.processingCenterId']");
	By isBankCheck = By.xpath("//input[@id='companyvo.isbank1']");
	By reVerificationCheck = By.xpath("//input[@id='doNotAllowLoginMethodAsSecondaryAuth']");
	By additionalID = By.xpath("//span[text()='Additional Identification']");
	By taxIdType=By.xpath("//select[@id='newItemType']");
	By taxIdValue = By.xpath("//input[@id='newItemValue']");
	By addIdentifierBtn = By.xpath("//button[@id='addIdentifierButton']");
	By LabelLink = By.xpath("//span[text()='Labels']");
	//By LabelText;
	By saveBtn = By.xpath("//button[@id='saveButton']");
	By cancelBtn = By.xpath("//button[@id='cancelButton']");
	String validateCompanyName = "//h1[contains(text(),'Company Details : %s')]";
	
	

	public Admin_CreateCompany(WebDriver driver) {
		super(driver);
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	public void createAndSaveCompany(String comId, String comName, String busUnit, String strAddress, String city,
			String State, String zipcodeVal,String countryName,String marketSegmentVal,
			String BillingAccountNo,String timeZoneOption,String expDate,String processingCenterVal,
			String bankChk,String reVerifyBox,String taxIdTyp,String taxIdVal,
			String addIdentity,String label) throws Exception {
		boolean stepResult = false;
		try {
			if(isElementPresent(createCompanyTitle)){
				enterText("Create Company", "companyIDField", companyId, comId);
				enterText("Create Company", "companyNameField", companyName, comName);
				if(!busUnit.equals(""))
					enterText("Create Company", "businessUnitField", businessUnit, busUnit);
				if(!strAddress.equals(""))
					enterText("Create Company", "streetAddressField", streetAddress, strAddress);
				if(!city.equals(""))
					enterText("Create Company", "cityField", cityName, city);
				if(!State.equals(""))
					enterText("Create Company", "stateField", stateName, State);
				if(!zipcodeVal.equals(""))
					enterText("Create Company", "zipcodeField", zipcode, zipcodeVal);
				selectElementByVisibleText("Create Company", "Country", country, countryName);
				selectElementByVisibleText("Create Company", "Market Segment", marketSegment, marketSegmentVal);
				enterText("Create Company", "Billing Account", billingAccount, BillingAccountNo);
				selectElementByVisibleText("Create Company", "Time Zone", timeZone, timeZoneOption);
				enterText("Create Company", "Date Field", enableDate, expDate);
				selectElementByVisibleText("Create Company", "Processing Center", processingCentre, processingCenterVal);
				if(bankChk.equals("Yes"))
					clickOnElement("Create Company", "IsBank Check Box", isBankCheck);
				if(reVerifyBox.equals("Yes"))
					clickOnElement("Create Company", "Re-Verification Check Box", reVerificationCheck);
				if(!taxIdTyp.equals("")){
					//validateTextEquals("Create Company", "Additional Identification", additionalID, additionalIdentity);
				    clickOnElement("Create Company", "Additional Identification", additionalID);
				    selectElementByVisibleText("Create Company", "TaxID Type", taxIdType,taxIdTyp );
					enterText("Create Company", "TaxID Type", taxIdValue,taxIdVal );
				}	
				if(addIdentity.equals("Yes")){
					//validateTextEquals("Create Company", "Add Identifier Button", addIdentifierBtn, addIdentityBttn);
				    clickOnElement("Create Company", "Add Identifier Button", addIdentifierBtn);
				}    
				if(!label.equals(""))  {
					clickOnElement("Create Company", "Labels Accordion", LabelLink);
				}	
				clickOnElement("Create Company", "Saved Company", saveBtn);
				stepResult = true;
			}
				
		} catch (Exception e) {
			e.printStackTrace();
		}
		finally {
			if (stepResult==true){
				System.out.println("Pass");
				new HTMLReportHelper().HtmlReportBody("Create Company CC- Admin application", "Company created Successfully", "Passed", driver, "Y");
			}else{
				System.out.println("fail");
				new HTMLReportHelper().HtmlReportBody("Create Company CC- Admin application", "Could not create company Successfully", "Passed", driver, "Y");
				}
				
			
		}

	}
	
	public void validateCompanyCreation(String validateValue) throws Exception{
		boolean stepResult = false;
		try {
			if(isElementPresent(getDynamicElement("Company Name",validateCompanyName,validateValue))){
				stepResult = true;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		finally {
			if (stepResult==true){
				System.out.println("Pass");
				new HTMLReportHelper().HtmlReportBody("Create Company CC- Admin application", "Company validated Successfully", "Passed", driver, "Y");
			}else{
				System.out.println("fail");
				new HTMLReportHelper().HtmlReportBody("Create Company CC- Admin application", "Could not validate company Successfully", "Passed", driver, "Y");
				}
			
		}
	}

}
