package testframe.application.premier.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.pagefactory.AjaxElementLocatorFactory;

import testframe.application.common.CommonLibrary;
import testframe.common.reporting.HTMLReportHelper;

/**
 * PageNage : Premier_CustomerAddress
 * 
 * @author Ketki.Badalwar
 */


public class Premier_CustomerAddress extends CommonLibrary {

	public By addressTitle = By.xpath("//label[text()='Step 1 - Address']");
	public By address1 = By.xpath("(//label[text()='Address 1:'])[1]/../following-sibling::td/input");
	public By address2 = By.xpath("(//label[text()='Address 2:'])[1]/../following-sibling::td/input");
	public By zipCode = By.xpath("(//label[text()='City State Zip:'])[1]/../following-sibling::td//input");
	public By nextButton = By.xpath("//button[@id='NextButton']");
	public By duplicateTitle = By.xpath("//label[text()='Step 2 - Duplicate']");
	public By bulidRelationshipTitle = By.xpath("//label[text()='Step 3 - Build Relationships']");
	public By plusIcon = By.xpath("//img[@title='Add Name']");
	public By searchTitle = By.xpath("//label[text()='Search']");
	public By ssnSearch = By.xpath("//input[@name='TaxID']");
	public By submitSearch = By.xpath("//button[text()='Submit']");
	public By nameLink = By.xpath("//a[contains(@onclick,'ModalClose()')]");
	public By relationship = By.xpath("//select[contains(@id,'RelationshipCode')]");
	public By finishButton = By.xpath("//button[@name='SubmitButton']");
	public By iframeVal = By.xpath("//iframe[@id='bottom']");
	public By branchRegionButton = By.xpath("//button[contains(@id,'BranchNumber_b')]");
	public By branchRegionVal = By.xpath("(//label[text()='Branch Region:'])[1]/../following-sibling::td//input[contains(@class,'EllipseText')]");
	String BranchRegionCombobox =  "//select[contains(@id,'BranchNumber_d')]/option[contains(text(),'%s')]";
	public By msg = By.xpath("//*[text()='The record was updated successfully.']");
	//below xpath are not used yet
	public By foreignList = By.xpath("(//label[text()='Foreign:'])[1]/../following-sibling::td/select");
	public By deliveryPointTextbox = By.xpath("(//label[text()='Delivery Point:'])[1]/../following-sibling::td/input");
	public By accountingBranchButton =  By.xpath("//button[contains(@id,'AccountingGroup_b')]");
	String accountingBranchList =  "//select[contains(@id,'AccountingGroup_d')]/option[contains(text(),'%s')]";
	public By censusTractTextBox = By.xpath("(//label[text()='Census Tract:'])[1]/../following-sibling::td/input");
	public By mSACodeButton =  By.xpath("(//button[contains(@id,'MsaCode_b')])[1]");
	String mSACodeList =  "(//select[contains(@id,'MsaCode_d')]/option[contains(text(),'%s')])[1]";
	public By countryCodeButton =  By.xpath("(//button[contains(@id,'CountryCode_b')])[1]");
	String countryCodeList =  "(//select[contains(@id,'CountryCode_d')]/option[contains(text(),'%s')])[1]";
	public By handlingCodeOption = By.xpath("(//label[text()='Handling Code Option:'])[1]/../following-sibling::td/select");
	public By handlingCodeButton =  By.xpath("(//button[contains(@id,'HandlingCode_b')])[1]");
	String handlingCodeList =  "(//select[contains(@id,'HandlingCode_d')]/option[contains(text(),'%s')])[1]";
	public By responsibilityCodeButton =  By.xpath("//button[contains(@id,'ResponsibilityCode_b')]");
	String responsibilityCodeList =  "//select[contains(@id,'ResponsibilityCode_d')]/option[contains(text(),'%s')]";
	public By referralresponsibilityCodeButton =  By.xpath("//button[contains(@id,'ReferralRespCode_b')]");
	String referralresponsibilityCodeList =  "//select[contains(@id,'ReferralRespCode_d')]/option[contains(text(),'%s')]";
	public By AddressRetentionCodeList =  By.xpath("//select[contains(@id,'RetentionCode')]");
	public By seasonal_Address1 = By.xpath("(//label[text()='Address 1:'])[2]/../following-sibling::td/input");
	public By seasonal_Address2 = By.xpath("(//label[text()='Address 2:'])[2]/../following-sibling::td/input");
	public By seasonal_CityStateZip = By.xpath("(//label[text()='City State Zip:'])[2]/../following-sibling::td//input");
	public By seasonal_Foreign = By.xpath("(//label[text()='Foreign:'])[2]/../following-sibling::td/select");
	public By seasonal_FromDate = By.xpath("//input[contains(@name,'AltFromDate')]");
	public By seasonal_ThroughDate = By.xpath("//input[contains(@name,'AltThruDate')]");
	public By seasonal_DeliveryPoint = By.xpath("//input[contains(@name,'AltDeliveryPt')]");
	public By seasonal_CensusTract = By.xpath("(//label[text()='Census Tract:'])[2]/../following-sibling::td/input");
	public By seasonal_MSACodeButton =  By.xpath("(//button[contains(@id,'MsaCode_b')])[2]");
	String seasonal_MSACodeList =  "(//select[contains(@id,'MsaCode_d')]/option[contains(text(),'%s')])[2]";
	public By seasonal_CountryCodeButton =  By.xpath("(//button[contains(@id,'CountryCode_b')])[2]");
	String seasonal_CountryCodeList =  "(//select[contains(@id,'CountryCode_d')]/option[contains(text(),'%s')])[2]";
	public By seasonal_HandlingCodeOption = By.xpath("(//label[text()='Handling Code Option:'])[2]/../following-sibling::td/select");
	public By seasonal_HandlingCodeButton =  By.xpath("(//button[contains(@id,'HandlingCode_b')])[2]");
	String seasonal_HandlingCodeList =  "(//select[contains(@id,'HandlingCode_d')]/option[contains(text(),'%s')])[2]";
	public By seasonal_HomePhoneNumber = By.xpath("//input[contains(@name,'AltHomePhone')]");
	public By noDuplicateMsg = By.xpath("//label[text()='No Possible Address Duplicates']");
	
	public Premier_CustomerAddress(WebDriver driver) {
		super(driver);
		this.driver = driver;
		PageFactory.initElements(new AjaxElementLocatorFactory(driver, 30), this);

	}

	public void createNewAddress(String address1Val, String address2Val, String zipcodeVal, String sSSN,String realationshipVal,String branchRegion) throws Exception {
		boolean stepResult = false;
		try {
			switchToWithinFrameWithName("Main");
			enterAddress(address1Val, address2Val, zipcodeVal,branchRegion);
			Thread.sleep(2000);
			if (isElementPresent(duplicateTitle)) {
				clickOnElement("New Address Page", "next button", nextButton);
			}
			createBuildRelationship(sSSN, realationshipVal);
			Thread.sleep(2000);
			if (isElementPresent(msg)) {
				stepResult = true;
			}
			switchToDefaultContent();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if (stepResult == true) {
				System.out.println("Pass");
				new HTMLReportHelper().HtmlReportBody("Create New Address", "Create New Address page Successfully",
						"Passed", driver, "Y");
			} else {
				System.out.println("fail");
				new HTMLReportHelper().HtmlReportBody("Create New Address", "Could not Create New Address",
						"Failed", driver, "Y");
			}
		}
	}

	public void enterAddress(String address1Val, String address2Val, String zipcodeVal,String branchRegion) throws Exception {
		boolean stepResult = false;
		try {
			Thread.sleep(4000);
			if (isElementPresent(addressTitle)) {
				if (!address1Val.equals("")) {
					enterText("New Address Page", "Address 1", address1, address1Val);
				}
				if (!address2Val.equals("")) {
					enterText("New Address Page", "Address 2", address2, address2Val);
				}
				if (!zipcodeVal.equals("")) {
					enterText("New Address Page", "zip code", zipCode, zipcodeVal);
				}
				if (!branchRegion.equals("")) {
					//clickOnElement("New Name Page", "Branch Region Button",branchRegionVal);
					//enterText("New Name Page", "Branch Region Button", branchRegionVal, branchRegion);
					clickOnElement("New Name Page", "Branch Region Button",branchRegionButton);
					Thread.sleep(2000);
					clickOnElement("New Name Page", "Branch Region list",getDynamicElement("Branch Region List",BranchRegionCombobox,branchRegion));
				}

				clickOnElement("New Name Page", "Next Button", nextButton);
				clickOnElement("New Address Page", "next button", nextButton);
				stepResult = true;
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if (stepResult == true) {
				System.out.println("Pass");
				new HTMLReportHelper().HtmlReportBody("Enter Address details", "Address entered on  Address page Successfully", "Passed",
						driver, "Y");
			} else {
				System.out.println("fail");
				new HTMLReportHelper().HtmlReportBody("Enter Address details", "Could Not entered Address on Address Page", "Failed",
						driver, "Y");
			}
		}

	}

	public void createBuildRelationship(String sSN, String realationshipVal) throws Exception {
		boolean stepResult = false;
		try {
			Thread.sleep(4000);
			if (isElementPresent(bulidRelationshipTitle)) {
				clickOnElement("New Address Page", "Build relationship button", plusIcon);
				Thread.sleep(7000);
				switchToWindowWithTitleContaining("Add Name");
				driver.switchTo().frame("bottom");
				if (isElementPresent(searchTitle)) {
					clickOnElement("Add Name Page", "Tax Identification", ssnSearch);
					enterText("Add Name Page", "Tax Identification", ssnSearch, sSN);
					clickOnElement("Add Name Page", "Submit", submitSearch);
					clickOnElement("Add Name Page", "Name link", nameLink);
					switchToWindowWithTitleContaining("Institution 01 - REPUBLIC BANK UAT");
					switchToWithinFrameWithName("Main");
				}
				Thread.sleep(2000);
				selectElementByVisibleText("New Address Page", "Select Group", relationship, realationshipVal);
				clickOnElement("New Address Page", "Finish Button", finishButton);
				stepResult = true;
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if (stepResult == true) {
				System.out.println("Pass");
				new HTMLReportHelper().HtmlReportBody("create Build Relationship", "created Build Relationship on Create Address page Successfully", "Passed",
						driver, "Y");
			} else {
				System.out.println("fail");
				new HTMLReportHelper().HtmlReportBody("create Build Relationship", "Could not Create Build Relationship on Address page", "Failed",
						driver, "Y");
			}
		}

	}

}
