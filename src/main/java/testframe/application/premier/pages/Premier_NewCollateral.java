package testframe.application.premier.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.pagefactory.AjaxElementLocatorFactory;

import testframe.application.common.CommonLibrary;
import testframe.common.reporting.HTMLReportHelper;

/**
 * PageNage : Premier_NewCollateral
 * 
 * @author Onkar.Narlawar
 */

public class Premier_NewCollateral extends CommonLibrary{
	Premier_PortfolioNew premierPortfolioNew;

	public Premier_NewCollateral(WebDriver driver) {
		super(driver);
		this.driver = driver;
		PageFactory.initElements(new AjaxElementLocatorFactory(driver, 30), this);
		premierPortfolioNew = new Premier_PortfolioNew(driver);
	}
	
	public By searchTitle = By.xpath("//label[text()='Search']");
	public By searchTitle2 = By.xpath("//td[contains(text(),'Search')]");
	public By ssnSearch = By.xpath("//input[@name='TaxID']");
	public By submitSearch = By.xpath("//button[text()='Submit']");
	public By nameLink = By.xpath("(//a[contains(@id,'SearchType=Name')])[1]");
	public By addressLink = By.xpath("(//a[contains(@id,'SearchType=Address')])[1]");
	public By saveButton = By.xpath("//a[contains(@onclick,'Save')]");
	public By saveButton2 = By.xpath("//img[contains(@title,'Save')]");
	public By nextButton = By.xpath("//button[@value='Next']");
	public By finishButton = By.xpath("//button[@value='Finish']");
	public By accountSearch = By.xpath("//td[contains(text(),'Account Number:')]/following-sibling::td/input");
	public By closeScreenImg = By.xpath("//img[contains(@title,'Close')]");
	String search1 = "(//img[@title='Search'])[%s]";
	
	public By collateralDefinitionPageTitle = By.xpath("//label[text()='Step 1 - Collateral Definition']");
	public By collateralTypeList = By.xpath("//select[@id='oCollType']");
	public By branchRegionTextbox =  By.xpath("//input[@id='oCollBranch']");
	public By branchRegionButton =  By.xpath("//button[contains(@id,'oCollBranch_b')]");
	String branchRegionList =  "//select[contains(@id,'oCollBranch_d')]/option[contains(text(),'%s')]";
	public By collateralCodeList = By.xpath("//select[@id='oCollCode']");
	public By collateralNextButton = By.xpath("//button[@id='NextButton']");
	public By collateralCodePageTitle = By.xpath("//label[contains(text(),'Step 2 - Codes')]");
	public By parcelIdInput = By.xpath("//input[contains(@id,'ParcelId')]");
	public By buildingStatusList = By.xpath("//select[contains(@id,'BuildingStatus')]");
	public By primaryResidenceList = By.xpath("//select[contains(@id,'PrimaryResidenceFlag')]");
	public By collateralValueInput = By.xpath("//input[contains(@id,'CollateralValue')]");
	public By propertyTypeList = By.xpath("//select[contains(@id,'PropertyType')]");
	public By numberOfUnitsInput = By.xpath("//input[contains(@id,'NumberOfUnits')]");
	public By marketValueInput = By.xpath("//input[contains(@id,'MarketValue')]");
	public By marketValue = By.xpath("//input[contains(@id,'MarketValue')]");
	public By responsibilityCodeInput =  By.xpath("(//input[contains(@name,'ResponsibilityCode')])[2]");
	public By responsibilityCodeButton =  By.xpath("//button[contains(@name,'ResponsibilityCode_b')]");
	String responsibilityCodeList =  "//select[contains(@id,'ResponsibilityCode_d')]/option[contains(text(),'%s')]";
	public By marginPercentInput =  By.xpath("//input[contains(@id,'MarginPercent')]");
	public By marginAmountInput =  By.xpath("//input[contains(@id,'MarginAmount')]");
	public By additionalField = By.xpath("//select[@id='ddFlex0']");
	public By addFieldLink = By.xpath("//a[text()='Add Field']");
	public By parcelNumberValue = By.xpath("//label[text()='Parcel Number']/../following-sibling::td/input[contains(@id,'Value')]");
	public By parcelNumberExpDate = By.xpath("//label[text()='Parcel Number']/../following-sibling::td//input[contains(@id,'ExpirationDate')]");
	public By collateralrelationshipPageTitle = By.xpath("//label[contains(text(),'Step 4 - Relationships')]");
	public By searchNameImg =  By.xpath("//img[@title='Search Name']");
	public By searchNameAddress =  By.xpath("//img[@title='Search Address']");
	public By searchNameAccount = By.xpath("//img[@title='Account Search']");
	public By policyDescriptionInput = By.xpath("//input[contains(@id,'PolicyDescription')]");
	public By cashValueInput = By.xpath("//input[contains(@id,'CashValue')]");
	public By policyNumberInput = By.xpath("//input[contains(@id,'PolicyNumber')]");
	public By faceValueInput = By.xpath("//input[contains(@id,'FaceValue')]");
	public By policyEffectiveDateInput = By.xpath("//input[contains(@id,'PolicyEffectiveDate')]");
	public By numberofSharesInput = By.xpath("//input[contains(@id,'NumberOfShares')]");
	public By sAccountNumberInput = By.xpath("//label[text()='Account Number:']/../following-sibling::td/input[contains(@id,'AccountNumber')]");
	public By typeList = By.xpath("//select[contains(@id,'Type')]");
	public By cUSIPInput = By.xpath("//input[contains(@id,'CusipNumber')]");
	public By tickerSymbolInput = By.xpath("//input[contains(@id,'TickerSymbol')]");
	public By fundNameInput = By.xpath("//input[contains(@id,'FundName')]");
	public By descriptionInput = By.xpath("//input[contains(@id,'Description1')]");
	public By collateralIdentificationInput = By.xpath("//input[contains(@id,'CollateralIdent')]");
	public By dateLastStatusChangeInput = By.xpath("//input[contains(@id,'DateLastStatusChg')]");
	public By collateralStatusInput = By.xpath("//input[contains(@id,'CollateralStatus')]");
	public By purchasePriceInput = By.xpath("//input[contains(@id,'PurchasePrice')]");
	
	public void enterCollateralDefInitionPageDetail(String sCollateralType,String sBranchRegion,String sCollateralCode) throws Exception {
		if (System.getProperty("runStep")=="Y"){
		boolean stepResult = false;
		try {
			driver.switchTo().frame("Main");
			if(isElementPresent(collateralDefinitionPageTitle)) {
				if (!sCollateralType.equals("")) {
					selectElementByVisibleText("New Line Codes Page", "Maximum Credit Code", collateralTypeList, sCollateralType);
				}
				if (!sBranchRegion.equals("")) {
					clickOnElement("New Collateral Page", "Branch Region Input Field",branchRegionTextbox);
					Thread.sleep(1000);
					clickOnElement("New Collateral Page", "Branch Region Button",branchRegionButton);
					Thread.sleep(1000);
					clickOnElement("New Collateral Page", "Branch Region list",getDynamicElement("Branch Region list",branchRegionList,sBranchRegion));
				}
				if (!sCollateralCode.equals("")) {
					selectElementByVisibleText("New Line Codes Page", "Internal Payment option", collateralCodeList, sCollateralCode);
				}				
				clickOnElement("New Collateral Page", "Next Button", collateralNextButton);
				waitElement(2000);
				stepResult = true;
			}					
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			if (stepResult == true) {
				System.out.println("Pass");
				new HTMLReportHelper().HtmlReportBody("Enter details on Collateral definition Screen", "Details Entered on Collateral definition Screen Successfully", "Passed",driver, "Y");
			} else {
				System.out.println("fail");
				new HTMLReportHelper().HtmlReportBody("Enter details on Collateral definition Screen", "Could not entered details on Collateral definition Screen", "Failed",driver, "Y");
				System.setProperty("runStep","N");
			}
		}
		}
	}
   
	public void enterCollateralCodePageDetail_RealEstate(String sParcelID, String sBuildingStatus, String sPrimaryResidence, String sCollateralValue, String sPropertyType, String sNumberOfUnits, String sMarketValue,
			String sResponsibilityCode, String sAdditionalInfoParcelNumberValue, String sAdditionalInfoParcelNumberExpirationDate, String sMarginPercent, String sMarginAmount) throws Exception {
		if (System.getProperty("runStep")=="Y"){
		boolean stepResult = false;
		try {
			if(isElementPresent(collateralCodePageTitle)) {
				if (!sParcelID.equals("")) {
					enterText("New Collateral Code Page", "Parcel ID",parcelIdInput, sParcelID);
				}
				if (!sBuildingStatus.equals("")) {
					selectElementByVisibleText("New Collateral Code Page", "Building Status",buildingStatusList, sBuildingStatus);
				}
				if (!sPrimaryResidence.equals("")) {
					selectElementByVisibleText("New Collateral Code Page", "Primary Residence",primaryResidenceList, sPrimaryResidence);
				}
				if (!sCollateralValue.equals("")) {
					enterText("New Collateral Code Page", "Collateral Value",collateralValueInput, sCollateralValue);
				}
				if (!sPropertyType.equals("")) {
					selectElementByVisibleText("New Collateral Code Page", "Property Type",propertyTypeList, sPropertyType);
				}
				if (!sNumberOfUnits.equals("")) {
					enterText("New Collateral Code Page", "Number Of Units",numberOfUnitsInput, sNumberOfUnits);
				}
				if (!sMarketValue.equals("")) {
					enterText("New Collateral Code Page", "Market Value",marketValueInput, sMarketValue);
				}
				if (!sResponsibilityCode.equals("")) {
					clickOnElement("New Collateral Code Page", "Responsibility Code Button",responsibilityCodeButton);
					Thread.sleep(1000);
					clickOnElement("New Collateral Code Page", "Responsibility Code list",getDynamicElement("Responsibility Code list",responsibilityCodeList,sResponsibilityCode));
				}
				if (!sAdditionalInfoParcelNumberValue.equals("")) {
					selectElementByVisibleText("New Collateral Code Page", "Additional Field ",additionalField, "Parcel Number");
					clickOnElement("New Collateral Code Page", "Add Field Link",addFieldLink);
					waitElement(3000);
					enterText("New Collateral Code Page", "Additional Info Parcel Number Value",parcelNumberValue, sAdditionalInfoParcelNumberValue);
					if (!sAdditionalInfoParcelNumberExpirationDate.equals("")) {
					enterText("New Collateral Code Page", "Additional Info Parcel Number Exp Date",parcelNumberExpDate, sAdditionalInfoParcelNumberExpirationDate);
					}
				}
				if (!sMarginPercent.equals("")) {
					enterText("New Collateral Code Page", "Margin Percent",marginPercentInput, sMarginPercent);
				}
				if (!sMarginAmount.equals("")) {
					enterText("New Collateral Code Page", "Margin Amount",marginAmountInput, sMarginAmount);
				}
				clickOnElement("New Collateral Code Page", "Next Button", collateralNextButton);
				waitElement(2000);
				stepResult = true;
			}
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			if (stepResult == true) {
				System.out.println("Pass");
				new HTMLReportHelper().HtmlReportBody("Enter details on Collateral Code Screen", "Details Entered on Collateral Code Screen Successfully", "Passed",driver, "Y");
			} else {
				System.out.println("fail");
				new HTMLReportHelper().HtmlReportBody("Enter details on Collateral Code Screen", "Could not entered details on Collateral Code Screen", "Failed",driver, "Y");
				System.setProperty("runStep","N");
			}
		}

		}
	}
	
	public void enterCollateralCodePageDetail_LifeInsurance(String sPolicyDescription, String sCashValue, String sCollateralValue, String sPolicyNumber, String sResponsibilityCode, String sFaceValue, String sPolicyEffectiveDate,
			String sAdditionalInfoParcelNumberValue, String sAdditionalInfoParcelNumberExpirationDate, String sMarginPercent, String sMarginAmount) throws Exception {
		if (System.getProperty("runStep")=="Y"){
		boolean stepResult = false;
		try {
			if(isElementPresent(collateralCodePageTitle)) {
				if (!sPolicyDescription.equals("")) {
					enterText("New Collateral Code Page", "Policy Description",policyDescriptionInput, sPolicyDescription);
				}
				if (!sCashValue.equals("")) {
					enterText("New Collateral Code Page", "Cash Value",cashValueInput, sCashValue);
				}
				if (!sCollateralValue.equals("")) {
					enterText("New Collateral Code Page", "Collateral Value",collateralValueInput, sCollateralValue);
				}
				if (!sPolicyNumber.equals("")) {
					enterText("New Collateral Code Page", "Policy Number",policyNumberInput, sPolicyNumber);
				}
				if (!sResponsibilityCode.equals("")) {
					clickOnElement("New Collateral Code Page", "Responsibility Code Button",responsibilityCodeButton);
					Thread.sleep(1000);
					clickOnElement("New Collateral Code Page", "Responsibility Code list",getDynamicElement("Responsibility Code list",responsibilityCodeList,sResponsibilityCode));
				}
				if (!sFaceValue.equals("")) {
					enterText("New Collateral Code Page", "Face Value",faceValueInput, sFaceValue);
				}
				if (!sPolicyEffectiveDate.equals("")) {
					enterText("New Collateral Code Page", "Policy Effective Date",policyEffectiveDateInput, sPolicyEffectiveDate);
				}
				
				if (!sAdditionalInfoParcelNumberValue.equals("")) {
					selectElementByVisibleText("New Collateral Code Page", "Additional Field ",additionalField, "Parcel Number");
					clickOnElement("New Collateral Code Page", "Add Field Link",addFieldLink);
					waitElement(3000);
					enterText("New Collateral Code Page", "Additional Info Parcel Number Value",parcelNumberValue, sAdditionalInfoParcelNumberValue);
					if (!sAdditionalInfoParcelNumberExpirationDate.equals("")) {
					enterText("New Collateral Code Page", "Additional Info Parcel Number Exp Date",parcelNumberExpDate, sAdditionalInfoParcelNumberExpirationDate);
					}
				}
				if (!sMarginPercent.equals("")) {
					enterText("New Collateral Code Page", "Margin Percent",marginPercentInput, sMarginPercent);
				}
				if (!sMarginAmount.equals("")) {
					enterText("New Collateral Code Page", "Margin Amount",marginAmountInput, sMarginAmount);
				}
				clickOnElement("New Collateral Code Page", "Next Button", collateralNextButton);
				waitElement(2000);
				stepResult = true;
			}
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			if (stepResult == true) {
				System.out.println("Pass");
				new HTMLReportHelper().HtmlReportBody("Enter details on Collateral Code Screen", "Details Entered on Collateral Code Screen Successfully", "Passed",driver, "Y");
			} else {
				System.out.println("fail");
				new HTMLReportHelper().HtmlReportBody("Enter details on Collateral Code Screen", "Could not entered details on Collateral Code Screen", "Failed",driver, "Y");
				System.setProperty("runStep","N");
			}
		}
		}
	}
	
	public void enterCollateralCodePageDetail_Investment(String sNumberofShares, String sAccountNumber, String sType, String sCUSIP, String sTickerSymbol, String sFundName, String sCollateralValue,
			String sResponsibilityCode, String sAdditionalInfoParcelNumberValue, String sAdditionalInfoParcelNumberExpirationDate, String sMarginPercent, String sMarginAmount) throws Exception {
		if (System.getProperty("runStep")=="Y"){
		boolean stepResult = false;
		try {
			if(isElementPresent(collateralCodePageTitle)) {
				if (!sNumberofShares.equals("")) {
					enterText("New Collateral Code Page", "Number of Shares",numberofSharesInput, sNumberofShares);
				}
				if (!sAccountNumber.equals("")) {
					enterText("New Collateral Code Page","Account Number",sAccountNumberInput, sAccountNumber);
				}
				if (!sType.equals("")) {
					selectElementByVisibleText("New Collateral Code Page", "Type",typeList, sType);
				}				
				if (!sCUSIP.equals("")) {
					enterText("New Collateral Code Page", "CUSIP",cUSIPInput, sCUSIP);
				}
				if (!sTickerSymbol.equals("")) {
					enterText("New Collateral Code Page", "Ticker Symbol",tickerSymbolInput, sTickerSymbol);
				}
				if (!sFundName.equals("")) {
					enterText("New Collateral Code Page", "Fund Name",fundNameInput, sFundName);
				}
				if (!sCollateralValue.equals("")) {
					enterText("New Collateral Code Page", "Collateral Value",collateralValueInput, sCollateralValue);
				}
				if (!sResponsibilityCode.equals("")) {
					clickOnElement("New Collateral Code Page", "Responsibility Code Button",responsibilityCodeButton);
					Thread.sleep(1000);
					clickOnElement("New Collateral Code Page", "Responsibility Code list",getDynamicElement("Responsibility Code list",responsibilityCodeList,sResponsibilityCode));
				}
				if (!sAdditionalInfoParcelNumberValue.equals("")) {
					selectElementByVisibleText("New Collateral Code Page", "Additional Field ",additionalField, "Parcel Number");
					clickOnElement("New Collateral Code Page", "Add Field Link",addFieldLink);
					waitElement(3000);
					enterText("New Collateral Code Page", "Additional Info Parcel Number Value",parcelNumberValue, sAdditionalInfoParcelNumberValue);
					if (!sAdditionalInfoParcelNumberExpirationDate.equals("")) {
					enterText("New Collateral Code Page", "Additional Info Parcel Number Exp Date",parcelNumberExpDate, sAdditionalInfoParcelNumberExpirationDate);
					}
				}
				if (!sMarginPercent.equals("")) {
					enterText("New Collateral Code Page", "Margin Percent",marginPercentInput, sMarginPercent);
				}
				if (!sMarginAmount.equals("")) {
					enterText("New Collateral Code Page", "Margin Amount",marginAmountInput, sMarginAmount);
				}
				clickOnElement("New Collateral Code Page", "Next Button", collateralNextButton);
				waitElement(2000);
				stepResult = true;
			}
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			if (stepResult == true) {
				System.out.println("Pass");
				new HTMLReportHelper().HtmlReportBody("Enter details on Collateral Code Screen", "Details Entered on Collateral Code Screen Successfully", "Passed",driver, "Y");
			} else {
				System.out.println("fail");
				new HTMLReportHelper().HtmlReportBody("Enter details on Collateral Code Screen", "Could not entered details on Collateral Code Screen", "Failed",driver, "Y");
				System.setProperty("runStep","N");
			}
		}
		}
	}
	
	public void enterCollateralCodePageDetail_Basic(String sDescription, String sCollateralIdentification, String sDateLastStatusChange, String sCollateralStatus, String sPurchasePrice, String sNumberOfUnits, String sCollateralValue,
			String sResponsibilityCode, String sAdditionalInfoParcelNumberValue, String sAdditionalInfoParcelNumberExpirationDate, String sMarginPercent, String sMarginAmount) throws Exception {
		if (System.getProperty("runStep")=="Y"){
		boolean stepResult = false;
		try {
			if(isElementPresent(collateralCodePageTitle)) {
				if (!sDescription.equals("")) {
					enterText("New Collateral Code Page", "Description Field",descriptionInput, sDescription);
				}
				if (!sCollateralIdentification.equals("")) {
					enterText("New Collateral Code Page","Collateral Identification Field",collateralIdentificationInput, sCollateralIdentification);
				}
				if (!sDateLastStatusChange.equals("")) {
					enterText("New Collateral Code Page", "Date Last Status Change Field",dateLastStatusChangeInput, sDateLastStatusChange);
				}				
				if (!sCollateralStatus.equals("")) {
					enterText("New Collateral Code Page", "Collateral Status Field",collateralStatusInput, sCollateralStatus);
				}
				if (!sPurchasePrice.equals("")) {
					enterText("New Collateral Code Page", "Purchase Price Field",purchasePriceInput, sPurchasePrice);
				}
				if (!sNumberOfUnits.equals("")) {
					enterText("New Collateral Code Page", "Number Of Units Field",numberOfUnitsInput, sNumberOfUnits);
				}
				if (!sCollateralValue.equals("")) {
					enterText("New Collateral Code Page", "Collateral Value Field",collateralValueInput, sCollateralValue);
				}
				if (!sResponsibilityCode.equals("")) {
					clickOnElement("New Collateral Code Page", "Responsibility Code Button Field",responsibilityCodeButton);
					Thread.sleep(1000);
					clickOnElement("New Collateral Code Page", "Responsibility Code list Field",getDynamicElement("Responsibility Code list",responsibilityCodeList,sResponsibilityCode));
				}
				if (!sAdditionalInfoParcelNumberValue.equals("")) {
					selectElementByVisibleText("New Collateral Code Page", "Additional Field ",additionalField, "Parcel Number");
					clickOnElement("New Collateral Code Page", "Add Field Link",addFieldLink);
					waitElement(3000);
					enterText("New Collateral Code Page", "Additional Info Parcel Number Value Field",parcelNumberValue, sAdditionalInfoParcelNumberValue);
					if (!sAdditionalInfoParcelNumberExpirationDate.equals("")) {
					enterText("New Collateral Code Page", "Additional Info Parcel Number Exp Date Field",parcelNumberExpDate, sAdditionalInfoParcelNumberExpirationDate);
					}
				}
				if (!sMarginPercent.equals("")) {
					enterText("New Collateral Code Page", "Margin Percent",marginPercentInput, sMarginPercent);
				}
				if (!sMarginAmount.equals("")) {
					enterText("New Collateral Code Page", "Margin Amount",marginAmountInput, sMarginAmount);
				}
				clickOnElement("New Collateral Code Page", "Next Button", collateralNextButton);
				waitElement(2000);
				stepResult = true;
			}
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			if (stepResult == true) {
				System.out.println("Pass");
				new HTMLReportHelper().HtmlReportBody("Enter details on Collateral Code Screen", "Details Entered on Collateral Code Screen Successfully", "Passed",driver, "Y");
			} else {
				System.out.println("fail");
				new HTMLReportHelper().HtmlReportBody("Enter details on Collateral Code Screen", "Could not entered details on Collateral Code Screen", "Failed",driver, "Y");
				System.setProperty("runStep","N");
			}
		}
		}
	}
	
	public void enterCollateralRelationshipPageDetail(String sSearchSSN, String sSSNRelationship, String sSearchAddress,
			String sAddressRelationship, String sSearchAccountType, String sSearchAccountNumber, String sAccountPledgeRule) throws Exception {
		if (System.getProperty("runStep")=="Y"){
		boolean stepResult = false;
		try {
			if(isElementPresent(collateralrelationshipPageTitle)) {
				if (!sSearchSSN.equals("")) {
					clickOnElement("New Collateral Relationship Page", "Search Name", searchNameImg);
					Thread.sleep(4000);
					switchToWindowWithTitleContaining("Search Name");
					Thread.sleep(4000);
					driver.switchTo().frame("bottom");
					new Premier_CustomerContact(driver).searchSSN(sSearchSSN);
					Thread.sleep(4000);
					switchToWindowWithTitleContaining("Institution");
					driver.switchTo().frame("Main");
					if (!sSSNRelationship.equals("")) {
						//add steps for selecting relationship
					}
				}
				if (!sSearchAddress.equals("")) {
					clickOnElement("New Collateral Relationship Page", "Search Address", searchNameAddress);
					Thread.sleep(4000);
					switchToWindowWithTitleContaining("Search Address");
					Thread.sleep(4000);
					driver.switchTo().frame("bottom");
					new Premier_CustomerAddress(driver).searchAddress(sSearchAddress);
					Thread.sleep(4000);
					switchToWindowWithTitleContaining("Institution");
					driver.switchTo().frame("Main");
					if (!sAddressRelationship.equals("")) {
						//add steps for selecting relationship
					}
				}
				if (!sSearchAccountNumber.equals("")) {
					clickOnElement("New Collateral Relationship Page", "Search Account", searchNameAccount);
					Thread.sleep(4000);
				}
				//clickOnElement("New Collateral Page", "Next Button", collateralNextButton);
				waitElement(2000);
				stepResult = true;
			}					
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			if (stepResult == true) {
				System.out.println("Pass");
				new HTMLReportHelper().HtmlReportBody("Enter details on Collateral definition Screen", "Details Entered on Collateral definition Screen Successfully", "Passed",driver, "Y");
			} else {
				System.out.println("fail");
				new HTMLReportHelper().HtmlReportBody("Enter details on Collateral definition Screen", "Could not entered details on Collateral definition Screen", "Failed",driver, "Y");
				System.setProperty("runStep","N");
			}
		}

		}
	}
	
}



