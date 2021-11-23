package testframe.application.premier.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.pagefactory.AjaxElementLocatorFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import testframe.application.common.CommonLibrary;
import testframe.common.reporting.HTMLReportHelper;

/**
 * PageNage : Premier_CustomerNewName
 * 
 * @author Ketki.Badalwar
 */


public class Premier_CustomerNewName extends CommonLibrary {

	public By nameTitle = By.xpath("//label[text()='Step 1 - Name']");
	public By nameTextbox = By.xpath("(//label[text()='Name:'])[1]/../following-sibling::td/input");
	public By lastNameTextbox = By.xpath("(//label[text()='Last Name:'])[1]/../following-sibling::td/input");
	public By firstNametextbox = By.xpath("(//label[text()='First Name:'])[1]/../following-sibling::td/input");
	public By nameFormatCodeCombobox = By.xpath("(//label[text()='Name Format Code:'])[1]/../following-sibling::td/select");
	public By dateOfBirth = By.xpath("(//label[text()='Date of Birth:'])[1]/../following-sibling::td/div/input");
	public By taxIDCodeList = By.xpath("(//label[text()='Tax ID Code:'])[1]/../following-sibling::td/select");
	public By taxIDNum = By.xpath("(//label[text()='Tax ID Number:'])[1]/../following-sibling::td/input");
	public By withholdingCodeCombobox = By.xpath("//label[text()='Withholding Code:']/../following-sibling::td/select");
	public By altNameTextbox = By.xpath("(//label[text()='Name:'])[2]/../following-sibling::td/input");
	public By altLastNameTextbox = By.xpath("(//label[text()='Last Name:'])[2]/../following-sibling::td/input");
	public By altFirstNametextbox = By.xpath("(//label[text()='First Name:'])[2]/../following-sibling::td/input");
	public By altNameFormatCodeCombobox = By.xpath("(//label[text()='Name Format Code:'])[2]/../following-sibling::td/select");
	public By nextButton = By.xpath("//button[@id='NextButton']");
	public By frame = By.xpath("//iframe[@id='Main']");
	public By finishButton = By.xpath("//button[@name='SubmitButton']");
	public By branchRegionButton = By.xpath("//button[contains(@id,'BranchNumber_b')]");
	public By branchRegionVal = By.xpath("(//label[text()='Branch Region:'])[1]/../following-sibling::td//input[contains(@class,'EllipseText')]");
	String BranchRegionCombobox =  "//select[contains(@id,'BranchNumber_d')]/option[contains(text(),'%s')]";	
	public By codeLabel = By.xpath("//label[text()='Step 4 - Codes']");
	public By duplicateLabel = By.xpath("//label[text()='Step 2 - Duplicate']");
	public By duplicateMsg = By.xpath("//label[text()='No Possible Name Duplicates']");
	public By contactMethodsLabel = By.xpath("//label[text()='Step 3 - Contact Methods']");
	public By buildRelationshipLabel = By.xpath("//label[text()='Step 5 - Build Relationships']");
	public By addNameImage = By.xpath("//img[@title='Add Name']");
	public By SearchTitle = By.xpath("//label[text()='Search']");
	public By BuildRelationshipSSN = By.xpath("//label[text()='Tax Identification:']/../following-sibling::td//input[@id='TaxID']");
	public By SubmitButton_SearchScreen = By.xpath("//button[text()='Submit']");
	public By NameList = By.xpath("//label[text()='Name List']");
	public By SearchResult = By.xpath("//a[contains(@id,'SearchType=Name')]");
	public By RelationshipName =By.xpath("(//table[@id='Rel_Name']//select[contains(@id,'RelationshipCode')])[1]");
	public By addAddressImage = By.xpath("//img[@title='Add Address']");
	public By phoneNumLink = By.xpath("//a[@id='lnkPhone']");
	public By emailLink = By.xpath("//a[@id='lnkEmail']");
	public By webAddresslink = By.xpath("//a[@id='lnkWeb']");
	public By phoneNumVal = By.xpath("(//input[contains(@name,'PhoneNumber')])[1]");
	public By emailVal = By.xpath("(//input[contains(@name,'ContactInfo')])[1]");
	public By webAddressVal = By.xpath("(//input[contains(@name,'ContactInfo')])[2]");
	public By genderCombobox = By.xpath("//label[text()='Gender:']/../following-sibling::td/select");
	public By riskRankingInput = By.xpath("//input[contains(@id,'RiskRanking_l')]");
	public By riskRankingButton = By.xpath("//button[contains(@id,'RiskRanking_b')]");
	String riskRankingCombobox =  "//select[contains(@id,'RiskRanking_d')]/option[contains(text(),'%s')]";
	public By creditScoreTextbox = By.xpath("//label[text()='Credit Score:']/../following-sibling::td/input");
	public By nAICSCodesButton = By.xpath("//button[contains(@id,'naics_b')]");
	public By nAICSCodes_EconomicSector = By.xpath("//select[@id='economicSector']");
	public By nAICSCodesSubmitButton = By.xpath("//button[text()='Submit']");
	public By customerTypeCombobox = By.xpath("//label[text()='Customer Type:']/../following-sibling::td/select");
	public By phoneDescript = By.xpath("(//input[contains(@name,'PhoneDescription')])[1]");
	public By msg = By.xpath("//*[text()='The record was updated successfully.']");
	public By BeneOwnerName = By.xpath("(//select[contains(@id,'RelatedToId')])[1]");
	public By BeneRelationship = By.xpath("(//table[@id='Rel_Beneficial']//select[contains(@id,'RelationshipCode')])[1]");
	public By BenePercent = By.xpath("(//input[contains(@id,'RelationshipPercent')])[1]");
	public By RelationshipName2 =By.xpath("(//table[@id='Rel_Name']//select[contains(@id,'RelationshipCode')])[3]");
	public By BeneOwnerName2 = By.xpath("(//select[contains(@id,'RelatedToId')])[2]");
	public By BeneRelationship2 = By.xpath("(//table[@id='Rel_Beneficial']//select[contains(@id,'RelationshipCode')])[2]");
	public By BenePercent2 = By.xpath("(//input[contains(@id,'RelationshipPercent')])[2]");
	//below xpaths are not used yet in scripts
	public By middleInitialTextBox = By.xpath("(//label[text()='Middle Initial:'])[1]/../following-sibling::td/input");
	public By generationCodeButton = By.xpath("//label[text()='Generation Code:']/../following-sibling::td//button");
	String generationCodeList = "//Select[contains(@id,'GenerationCode')]/option[contains(text(),%s')]";
	public By suspectExemptionCombo = By.xpath("(//label[text()='Suspect Exemption:'])[1]/../following-sibling::td/select");
	public By iDTypeButton = By.xpath("(//button[contains(@id,'IdentType_b')])[1]");
	String idTypeList = "//select[contains(@id,'IdentType_d')]/option[contains(text(),'%s')]";
	public By issuedByButton = By.xpath("(//button[contains(@id,'IdentIssuedBy_b')])[1]");
	String issuedByList = "//select[contains(@id,'IdentIssuedBy_d')]/option[contains(text(),'%s')]";
	public By valueTextBox = By.xpath("(//input[contains(@id,'IdentValue')])[1]");
	public By issueDateTextbox = By.xpath("(//input[contains(@id,'IdentDate')])[1]");
	public By expirationDateTextbox = By.xpath("(//input[contains(@id,'IdentExpireDate')])[1]");
	public By iRSName = By.xpath("(//label[text()='IRS Name:'])[1]/../following-sibling::td/input");
	public By iRSPayeeNameControlTextbox = By.xpath("(//label[text()='IRS Payee Name Control:'])[1]/../following-sibling::td/input");
	public By iRS_1B_NoticeTextBox = By.xpath("(//label[text()='IRS 1st B Notice:'])[1]/../following-sibling::td/div/input");
	public By iRS_2B_NoticeTextBox = By.xpath("(//label[text()='IRS 2nd B Notice:'])[1]/../following-sibling::td/div/input");
	public By exemptPayeeCodeTextbox = By.xpath("(//input[contains(@id,'ExemptPayeeCode')])[2]");
	public By exemptPayeeCodeButton = By.xpath("//button[contains(@id,'ExemptPayeeCode')]");
	String exemptPayeeCodeList = "//Select[contains(@id,'ExemptPayeeCode_d')]/option[contains(text(),'%s')]";
	public By taxIDVerificationAttempts = By.xpath("(//label[text()='Tax ID Verification Attempts:'])[1]/../following-sibling::td/input");
	public By taxIDVerificationDate = By.xpath("(//label[text()='Tax ID Verification Date:'])[1]/../following-sibling::td/div/input");
	public By taxIDMatchingCodeList = By.xpath("(//label[text()='Tax ID Matching Code:'])[1]/../following-sibling::td/select");
	public By fATCAExemptReportingCodeButton = By.xpath("//button[contains(@id,'FatcaExemptRptCode_b')]");
	String fATCAExemptReportingCodeList = "//Select[contains(@id,'FatcaExemptRptCode_d')]/option[contains(text(),'%s')]";
	public By alt_middleInitialTextBox = By.xpath("(//label[text()='Middle Initial:'])[2]/../following-sibling::td/input");
	public By languagePreferenceIndicatorSelect = By.xpath("(//label[text()='Language Preference Indicator:'])[1]/../following-sibling::td/select");
	public By disclosureOptionTextBox = By.xpath("//label[text()='Disclosure Option:']/../following-sibling::td/input");
	public By disclosureDateTextBox = By.xpath("//label[text()='Disclosure Date:']/../following-sibling::td/div/input");
	public By responsibilityCodeButton = By.xpath("//button[contains(@id,'ResponsibilityCode_b')]");
	String responsibilityCodeList = "//select[contains(@id,'ResponsibilityCode_d')]/option[contains(text(),'%s')]";
	public By referralResponsibilityCodeButton = By.xpath("//button[contains(@id,'ReferralRespCode_b')]");
	String referralResponsibilityCodeList = "//select[contains(@id,'ReferralRespCode_d')]/option[contains(text(),'%s')]";
	public By accountingBranchButton = By.xpath("//button[contains(@id,'AccountingGroup_b')]");
	String accountingBranchList = "//select[contains(@id,'AccountingGroup_d')]/option[contains(text(),'%s')]";
	public By nameRetentionCodeList = By.xpath("//label[text()='Name Retention Code:']/../following-sibling::td/select");
	public By residencyStatusButton = By.xpath("//button[contains(@id,'ResidencyStatus_b')]");
	String residencyStatusList = "//select[contains(@id,'ResidencyStatus_d')]/option[contains(text(),'%s')]";
	public By openMethodTextbox = By.xpath("//input[contains(@id,'CustomerOpenMethod_l')]");
	public By openMethodButton = By.xpath("//button[contains(@id,'CustomerOpenMethod_b')]");
	String openMethodList = "//select[contains(@id,'CustomerOpenMethod_d')]/option[contains(text(),'%s')]";
	public By creationDateTextbox = By.xpath("//label[text()='Creation Date:']/../following-sibling::td/div/input");
	public By dateDeceasedTextbox = By.xpath("//label[text()='Date Deceased:']/../following-sibling::td/div/input");
	public By foreignCodeList = By.xpath("//label[text()='Foreign Code:']/../following-sibling::td/select");
	public By w8FormTypeList = By.xpath("//label[text()='W-8 Form Type:']/../following-sibling::td/select");
	public By certificationDateTextBox = By.xpath("//label[text()='Certification Date:']/../following-sibling::td/div/input");
	public By expirationDateTextBox = By.xpath("//label[text()='Expiration Date']/../following-sibling::td/div/input");
	public By taxRateList = By.xpath("//label[text()='Tax Rate:']/../following-sibling::td/select");
	public By incomeCodeTextbox = By.xpath("//input[contains(@id,'CustomerOpenMethod_l')]");
	public By incomeCodeButton = By.xpath("//button[contains(@id,'CustomerOpenMethod_b')]");
	String incomeCodeList = "//select[contains(@id,'CustomerOpenMethod_d')]/option[contains(text(),'%s')]";
	public By chapter3StatusCodeTextbox = By.xpath("//input[contains(@id,'ForeignIncomeCode_l')]");
	public By chapter3StatusCodeButton = By.xpath("//button[contains(@id,'ForeignIncomeCode_b')]");
	String chapter3StatusCodeList = "//select[contains(@id,'ForeignIncomeCode_d')]/option[contains(text(),'%s')]";
	public By chapter4StatusCodeTextbox = By.xpath("//input[contains(@id,'ForeignChapter3Status_l')]");
	public By chapter4StatusCodeButton = By.xpath("//button[contains(@id,'ForeignChapter3Status_b')]");
	String chapter4StatusCodeList = "//select[contains(@id,'ForeignChapter3Status_d')]/option[contains(text(),'%s')]";
	public By exemptionCodeTextbox = By.xpath("//input[contains(@id,'ForeignExemptionCode_l')]");
	public By exemptionCodeButton = By.xpath("//button[contains(@id,'ForeignExemptionCode_b')]");
	String exemptionCodeList = "//select[contains(@id,'ForeignExemptionCode_d')]/option[contains(text(),'%s')]";
	public By provinceCodeButton = By.xpath("//button[contains(@id,'ForeignProvinceCode_b')]");
	String provinceCodeList = "//select[contains(@id,'ForeignProvinceCode_d')]/option[contains(text(),'%s')]";
	public By countryResidenceCodeButton = By.xpath("//button[contains(@id,'ForeignCountryRes_b')]");
	String countryResidenceCodeList = "//select[contains(@id,'ForeignCountryRes_d')]/option[contains(text(),'%s')]";
	public By countryTaxCodeButton = By.xpath("//button[contains(@id,'ForeignCountryTax_b')]");
	String countryTaxCodeList = "//select[contains(@id,'ForeignCountryTax_d')]/option[contains(text(),'%s')]";
	public By globalIntermediaryIdentificationNumber = By.xpath("//label[text()='Global Intermediary Identification Number:']/../following-sibling::td/input");
	public By postalCode = By.xpath("//label[text()='Postal Code:']/../following-sibling::td/input");
	public By foreignTaxIdentificationNumber = By.xpath("//label[text()='Foreign Tax Identification Number:']/../following-sibling::td/input");
	public By withholdingType = By.xpath("//label[text()='Withholding Type:']/../following-sibling::td/select");
	public By beneDescriptionList = By.xpath("(//select[contains(@id,'ControlDescription')])[1]");
	public By beneReciprocalRelationshipList = By.xpath("(//select[contains(@id,'BeneficiaryReciprocalRel')])[1]");
	
	public Premier_CustomerNewName(WebDriver driver) {
		super(driver);
		this.driver = driver;
		PageFactory.initElements(new AjaxElementLocatorFactory(driver, 30), this);

	}

	public void createNewName(String name, String firstName, String lastName,String nameFormatCode, String dob,String taxIDCode, String taxID,String withholdingCode,String alt_Name,String alt_FirstName,String alt_LastName,String alt_MiddleInitial,String alt_NameFormatCode,String phoneNumber,
			String branchRegion,String email,String webAddress,String gender,String riskRanking,String creditScore,String nAICSCodes,String customerType,String buildRelationship_SSN, String buildRelationship,String beneficialOwnerName,String beneficial_Relationship,String beneficial_Percent,
			String buildRelationship_2_Flag, String buildRelationship_2_SSN, String build_Relationship_2, String beneficialOwner_2_Flag, String beneficialOwnerName_2, String beneficial_Relationship_2, String beneficial_Percent_2) throws Exception {
		boolean stepResult = false;
		try {
			Thread.sleep(6000);
				driver.switchTo().frame("Main");
				enterCustomerName(name,firstName, lastName,nameFormatCode,dob,taxIDCode,taxID,withholdingCode,alt_Name,alt_FirstName,alt_LastName,alt_MiddleInitial,alt_NameFormatCode);
				enterDuplicate();
				enterContactMethod(phoneNumber, email, webAddress);
				enterCodeLable(gender,riskRanking,creditScore,nAICSCodes,customerType,branchRegion);
				enterBuildRelationship(buildRelationship_SSN,buildRelationship,beneficialOwnerName,beneficial_Relationship,beneficial_Percent,buildRelationship_2_Flag,buildRelationship_2_SSN,build_Relationship_2,beneficialOwner_2_Flag,beneficialOwnerName_2,beneficial_Relationship_2,beneficial_Percent_2);
				clickOnElement("New Name Page", "Finish Button", finishButton);
				Thread.sleep(2000);
				isElementPresent(msg);
				switchToWindowWithTitleContaining("Institution 01 - REPUBLIC BANK UAT");
				//driver.switchTo().defaultContent();
			stepResult = true;
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if (stepResult == true) {
				System.out.println("Pass");
				new HTMLReportHelper().HtmlReportBody("New Name Page", "Create name Successfully", "Passed", driver, "Y");
			} else {
				System.out.println("fail");
				new HTMLReportHelper().HtmlReportBody("New Name Page", "Could not create name.", "Failed", driver, "Y");
			}
		}

		
	}
	
	public void enterCustomerName(String name, String firstName, String lastName,String nameFormatCode ,String dob,String taxIDCode, String taxID,String withholdingCode,String alt_Name,String alt_FirstName,String alt_LastName,String alt_MiddleInitial,String alt_NameFormatCode) throws Exception{
		boolean stepResult = false;
		try {
			Thread.sleep(4000);
			if (isElementPresent(nameTitle)) {
					if (!name.equals("")) {
						enterText("New Name Page", "Name field", nameTextbox, name);
					}
					validateElementExist("New Name Page", "First Name", firstNametextbox, firstName);
					validateElementExist("New Name Page", "Last Name", lastNameTextbox, lastName);
					
					if (!nameFormatCode.equals("")) {
						selectElementByVisibleText("New Name Page", "Name Format Code field", nameFormatCodeCombobox, nameFormatCode);
					}
					if (!dob.equals("")) {
						enterText("New Name Page", "Date of Birth", dateOfBirth, dob);
					}
					if (!taxID.equals("")) {
						selectElementByVisibleText("New Name Page", "Tax Identification Code", taxIDCodeList, taxIDCode);
					}
					if (!taxID.equals("")) {
						enterText("New Name Page", "Tax Identification", taxIDNum, taxID);
					}
					if (!withholdingCode.equals("")) {
						selectElementByVisibleText("New Name Page", "Withholding Code field", withholdingCodeCombobox, withholdingCode);
					}
					if (!alt_Name.equals("")) {
						enterText("New Name Page", "Alternate Name field", altNameTextbox, alt_Name);
					}
					validateElementExist("New Name Page", "Alternate First Name", altFirstNametextbox, alt_FirstName);
					validateElementExist("New Name Page", "Alternate Last Name", altLastNameTextbox, alt_LastName);
					if (!alt_NameFormatCode.equals("")) {
						selectElementByVisibleText("New Name Page", "Alternate Name Format Code field", altNameFormatCodeCombobox, alt_NameFormatCode);
					}
					clickOnElement("New Name Page", "Next Button", nextButton);
					stepResult = true;
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if (stepResult == true) {
				System.out.println("Pass");
				new HTMLReportHelper().HtmlReportBody("New Name Page", "Create name page Successfully", "Passed", driver, "Y");
			} else {
				System.out.println("fail");
				new HTMLReportHelper().HtmlReportBody("New Name Page", "Could not Create name page Successfully", "Failed", driver, "Y");
			}
		}
	}
	
	public void enterDuplicate() throws Exception{
		boolean stepResult = false;
		try {
			if (isElementPresent(duplicateLabel)) {
				Thread.sleep(2000);
				if (isElementPresent(duplicateMsg)) {
				clickOnElement("New Name Page", "Next Button", nextButton);
				stepResult = true;
				}
			}			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if (stepResult == true) {
				System.out.println("Pass");
				new HTMLReportHelper().HtmlReportBody("New Name Page", "Create Duplicate page Successfully", "Passed", driver, "Y");
			} else {
				System.out.println("fail");
				new HTMLReportHelper().HtmlReportBody("New Name Page", "Could Not Create Duplicate page Successfully", "Failed", driver, "Y");
			}
		}
	}
	
	public void enterContactMethod(String phoneNumber,String email,String webAddress) throws Exception{
		boolean stepResult = false;
		try {
			if (isElementPresent(contactMethodsLabel)) {
				Thread.sleep(2000);
				/*clickOnElement("New Name Page", "Phone Number", phoneNumLink);
				clickOnElement("New Name Page", "Phone Number", phoneNumVal);
				enterText("New Name Page", "Phone Number", phoneNumVal, phoneNumber.substring(10));
				Thread.sleep(2000);
				clickOnElement("New Name Page", "Email link", emailLink);
				clickOnElement("New Name Page", "Email", emailVal);
				enterText("New Name Page", "Email", emailVal, email);
				Thread.sleep(2000);
				clickOnElement("New Name Page", "Next Button", nextButton);*/
				clickOnElement("New Name Page", "Phone Number", phoneNumLink);
				WebDriverWait wait1 = new WebDriverWait(driver, 20);
				WebElement element1 = wait1.until(ExpectedConditions.elementToBeClickable(phoneNumVal));
				element1.click();
				enterText("New Name Page", "Phone Number", phoneNumVal, phoneNumber);
				Thread.sleep(2000);
				clickOnElement("New Name Page", "Email link", emailLink);
				WebElement element2 = wait1.until(ExpectedConditions.elementToBeClickable(emailVal));
				element2.click();
				enterText("New Name Page", "Phone Number", emailVal, email);
				Thread.sleep(2000);
				if (!webAddress.equals("")) {
				clickOnElement("New Name Page", "Add Web Page Address", webAddresslink);
				WebElement element3 = wait1.until(ExpectedConditions.elementToBeClickable(webAddressVal));
				element3.click();
				enterText("New Name Page", "Add Web Page Address", webAddressVal, webAddress);
				Thread.sleep(2000);
				}
				clickOnElement("New Name Page", "Next Button", nextButton);
				stepResult = true;
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if (stepResult == true) {
				System.out.println("Pass");
				new HTMLReportHelper().HtmlReportBody("New Name Page", "Create Contact method page Successfully", "Passed", driver, "Y");
			} else {
				System.out.println("fail");
				new HTMLReportHelper().HtmlReportBody("New Name Page", "Could Not Create Contact method page Successfully", "Failed", driver, "Y");
			}
		
	}}

	public void enterCodeLable(String gender,String riskRanking,String creditScore,String nAICSCodes,String customerType,String branchRegion) throws Exception{
		boolean stepResult = false;
		try {
			if (isElementPresent(codeLabel)) {
				Thread.sleep(2000);
				if (!gender.equals("")) {
					selectElementByVisibleText("New Name Page", "Gender field", genderCombobox, gender);
				}
				if (!riskRanking.equals("")) {
					clickOnElement("New Name Page", "Risk Ranking Input Field",riskRankingInput);
					Thread.sleep(1000);
					clickOnElement("New Name Page", "Risk Ranking Button",riskRankingButton);
					Thread.sleep(1000);
					clickOnElement("New Name Page", "Risk Ranking list",getDynamicElement("Risk Ranking List",riskRankingCombobox,riskRanking));
				}
				if (!creditScore.equals("")) {
					enterText("New Name Page", "Credit Score Field", creditScoreTextbox, creditScore);
				}
				if (!nAICSCodes.equals("")) {
					clickOnElement("New Name Page", "NAICS Codes Button",nAICSCodesButton);
					waitForPresenceOfElement("New Name Page", "NAICSCodes_EconomicSector field", nAICSCodes_EconomicSector);
					selectElementByVisibleText("New Name Page", "NAICSCodes_EconomicSector field", nAICSCodes_EconomicSector, nAICSCodes);
					clickOnElement("New Name Page", "NAICS Codes Submit Button Field",nAICSCodesSubmitButton);
				}
				if (!customerType.equals("")) {
					selectElementByVisibleText("New Name Page", "Customer Type field", customerTypeCombobox, customerType);
				}
				if (!branchRegion.equals("")) {
				//clickOnElement("New Name Page", "Branch Region Button",branchRegionVal);
				//enterText("New Name Page", "Branch Region Button", branchRegionVal, branchRegion);
				clickOnElement("New Name Page", "Branch Region Button",branchRegionButton);
				Thread.sleep(2000);
				clickOnElement("New Name Page", "Branch Region list",getDynamicElement("Branch Region List",BranchRegionCombobox,branchRegion));	
				}
				
				clickOnElement("New Name Page", "Next Button", nextButton);
				stepResult = true;
			}
			
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if (stepResult == true) {
				System.out.println("Pass");
				new HTMLReportHelper().HtmlReportBody("New Name Page", "Create Code lable page Successfully", "Passed", driver, "Y");
			} else {
				System.out.println("fail");
				new HTMLReportHelper().HtmlReportBody("New Name Page", "Could Not Create Code lable page Successfully", "Failed", driver, "Y");
			}
		
	}}
	public void enterBuildRelationship(String buildRelationship_SSN,String build_Relationship,String beneficialOwnerName,String beneficial_Relationship,String beneficial_Percent,String buildRelationship_2_Flag,String buildRelationship_2_SSN,String build_Relationship_2,String beneficialOwner_2_Flag,String beneficialOwnerName_2,String beneficial_Relationship_2,String beneficial_Percent_2) throws Exception {
		boolean stepResult = false;
		try {
			if(isElementPresent(buildRelationshipLabel)){
				Thread.sleep(1000);
				if (!buildRelationship_SSN.equals("")) {
					buildRelationshipAddSSN(buildRelationship_SSN);
				
				if (!build_Relationship.equals("")) {
					selectElementByVisibleText("New Name Page", "Name Relationship field", RelationshipName, build_Relationship);
				}
				if (!beneficialOwnerName.equals("")) {
					selectElementByVisibleText("New Name Page", "Beneficial Owner Name field", BeneOwnerName, beneficialOwnerName);
				}
				if (!beneficial_Relationship.equals("")) {
					selectElementByVisibleText("New Name Page", "Beneficial Relationship field", BeneRelationship, beneficial_Relationship);
				}
				if (!beneficial_Percent.equals("")) {
					enterText("New Name Page", "Beneficial Percent Field", BenePercent, beneficial_Percent);
				}
				
				if (buildRelationship_2_Flag.equals("Yes")) {
					buildRelationshipAddSSN(buildRelationship_2_SSN);
					if (!build_Relationship_2.equals("")) {
						selectElementByVisibleText("New Name Page", "Name Relationship field", RelationshipName2, build_Relationship_2);
					}
				}
				if (beneficialOwner_2_Flag.equals("Yes")) {
					if (!beneficialOwnerName_2.equals("")) {
						selectElementByVisibleText("New Name Page", "Beneficial Owner Name field", BeneOwnerName2, beneficialOwnerName_2);
					}
					if (!beneficial_Relationship_2.equals("")) {
						selectElementByVisibleText("New Name Page", "Beneficial Relationship field", BeneRelationship2, beneficial_Relationship_2);
					}
					if (!beneficial_Percent_2.equals("")) {
						enterText("New Name Page", "Beneficial Percent Field", BenePercent2, beneficial_Percent_2);
					}
				}}
				stepResult = true;
			}
		}catch(Exception e){
			e.printStackTrace();
		}finally {
			if (stepResult == true) {
				System.out.println("Pass");
				new HTMLReportHelper().HtmlReportBody("New Name Page", "Create Build Relationship page Successfully", "Passed", driver, "Y");
			} else {
				System.out.println("fail");
				new HTMLReportHelper().HtmlReportBody("New Name Page", "Could not Create Build Relationship lable page Successfully", "Failed", driver, "Y");
			}
		
	}}
	
	public void buildRelationshipAddSSN(String sSN) throws Exception {
		boolean stepResult = false;
		try {
			clickOnElement("New Name Page", "Add Name Image",addNameImage);
			switchToWindowWithTitleContaining("Add Name");
			driver.switchTo().frame("bottom");
			if (isElementPresent(SearchTitle)) {
				enterText("New Name Page", "Enter SSN Field", BuildRelationshipSSN, sSN);
				clickOnElement("New Name Page", "Submit Button",SubmitButton_SearchScreen);
				waitForPresenceOfElement("New Name Page", "Searched Name List", NameList);
				clickOnElement("New Name Page", "Searched Result Link",SearchResult);

				switchToWindowWithTitleContaining("Institution 01 - REPUBLIC BANK UAT");
				driver.switchTo().frame("Main");
				stepResult = true;
			}
		
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			if (stepResult == true) {
				System.out.println("Pass");
				new HTMLReportHelper().HtmlReportBody("New Name Page", "Add SSN on Build Relationship Page Successfully", "Passed", driver, "Y");
			} else {
				System.out.println("fail");
				new HTMLReportHelper().HtmlReportBody("New Name Page", "Not able to Add SSN on Build Relationship Page Successfully", "Failed", driver, "Y");
			}
		}}
	
	
}


