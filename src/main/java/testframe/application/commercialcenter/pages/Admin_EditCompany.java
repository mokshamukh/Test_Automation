package testframe.application.commercialcenter.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

import testframe.application.common.CommonLibrary;

/**
 * PageNage : CommercialCenter_Admin_CreateCompany
 * 
 * @author Moksha.Mukh
 */

public class Admin_EditCompany extends CommonLibrary {

	public String adminCreateCompany;

	By editCompanyTitle = By.xpath("//h1[contains(text(),'Edit Company :')]");
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
	
	

	public Admin_EditCompany(WebDriver driver) {
		super(driver);
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	public void editAndSaveCompany(String comName, String busUnit, String strAddress, String city,
			String State, String zipcodeVal,String countryName,String marketSegmentVal,
			String BillingAccountNo,String timeZoneOption,String expDate,String processingCenterVal,
			String bankChk,String reVerifyBox,String taxIdTyp,String taxIdVal,
			String addIdentity,String label) {
		boolean stepResult = false;
		try {
			if(isElementPresent(editCompanyTitle)){
				clearAndType("Create Company", "companyNameField", companyName, comName);
				if(!busUnit.equals(""))
					clearAndType("Create Company", "businessUnitField", businessUnit, busUnit);
				if(!strAddress.equals(""))
					clearAndType("Create Company", "streetAddressField", streetAddress, strAddress);
				if(!city.equals(""))
					clearAndType("Create Company", "cityField", cityName, city);
				if(!State.equals(""))
					clearAndType("Create Company", "stateField", stateName, State);
				if(!zipcodeVal.equals(""))
					clearAndType("Create Company", "zipcodeField", zipcode, zipcodeVal);
				if(!countryName.equals(""))
					selectElementByVisibleText("Create Company", "Country", country, countryName);
				if(!marketSegmentVal.equals(""))
					selectElementByVisibleText("Create Company", "Market Segment", marketSegment, marketSegmentVal);
				if(!BillingAccountNo.equals(""))
					clearAndType("Create Company", "Billing Account", billingAccount, BillingAccountNo);
				if(!timeZoneOption.equals(""))
					selectElementByVisibleText("Create Company", "Time Zone", timeZone, timeZoneOption);
				if(!expDate.equals(""))
					clearAndType("Create Company", "Date Field", enableDate, expDate);
				if(!processingCenterVal.equals(""))
					selectElementByVisibleText("Create Company", "Processing Center", processingCentre, processingCenterVal);
				if(bankChk.equals("Yes"))
					clickOnElement("Create Company", "IsBank Check Box", isBankCheck);
				if(reVerifyBox.equals("Yes"))
					clickOnElement("Create Company", "Re-Verification Check Box", reVerificationCheck);
				if(!taxIdTyp.equals("")){
					//validateTextEquals("Create Company", "Additional Identification", additionalID, additionalIdentity);
				    clickOnElement("Create Company", "Additional Identification", additionalID);
				    selectElementByVisibleText("Create Company", "TaxID Type", taxIdType,taxIdTyp );
				    clearAndType("Create Company", "TaxID Type", taxIdValue,taxIdVal );
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
			if (stepResult==true)
				System.out.println("Pass");
			else
				System.out.println("fail");
		}

	}
	
	public void validateCompanyCreation(String validateValue){
		boolean stepResult = false;
		try {
			if(isElementPresent(getDynamicElement("Company Name",validateCompanyName,validateValue))){
				stepResult = true;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		finally {
			if (stepResult==true)
				System.out.println("Pass");
			else
				System.out.println("fail");
		}
	}

}
