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
	public By selectPhoneType = By.xpath("//select[@id='ddPhone']");
	public By selectEmailType = By.xpath("//select[@id='ddEmail']");
	public By lastPhoneNumValue =By.xpath("//table[@id='mcPhoneNumbers']//tr[last()-1]/td[6]/input[contains(@name,'PhoneNumber')]");
	public By lastemailidValue =By.xpath("//table[@id='mcEmailAddress']//tr[last()-1]/td[6]/input[contains(@name,'ContactInfo')]");
	public By lastRelationship = By.xpath("//table[@id='Rel_Name']//tr[last()]/td[6]/select[contains(@id,'RelationshipCode')]");
	public By addBeneficiaryLink = By.xpath("//a[text()='Add Beneficial Owner']");
	//public By lastBeneficialOwnerName =By.xpath("//table[@id='Rel_Beneficial']//tr[last()-1]/td[2]//select[contains(@id,'RelatedToId')]");
	//public By lastBeneficialRelationship =By.xpath("//table[@id='Rel_Beneficial']//tr[last()-1]/td[4]//2select[contains(@id,'RelationshipCode')]");
	//public By lastBeneficialPercent =By.xpath("//table[@id='Rel_Beneficial']//tr[last()-1]/td[6]//input[contains(@id,'RelationshipPercent')]");

	String sBeneOwnerName = "(//select[contains(@id,'RelatedToId')])[%s]";
	String sBeneRelationship = "(//table[@id='Rel_Beneficial']//select[contains(@id,'RelationshipCode')])[%s]";
	String sBenePercent = "(//input[contains(@id,'RelationshipPercent')])[%s]";


	//xpaths not used
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
			String buildRelationship_2_Flag, String buildRelationship_2_SSN, String build_Relationship_2, String beneficialOwner_2_Flag, String beneficialOwnerName_2, String beneficial_Relationship_2, String beneficial_Percent_2,String sPhoneType,String sEmailType) throws Exception {
		boolean stepResult = false;
		try {
			Thread.sleep(6000);
			//driver.switchTo().frame("Main");
			enterCustomerName(name,firstName, lastName,nameFormatCode,dob,taxIDCode,taxID,withholdingCode,alt_Name,alt_FirstName,alt_LastName,alt_MiddleInitial,alt_NameFormatCode);
			enterDuplicate();
			enterContactMethod(phoneNumber, email, webAddress,sPhoneType,sEmailType);
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
				new HTMLReportHelper().HtmlReportBody("Create New Name", "Create name Successfully", "Passed", driver, "Y");
			} else {
				System.out.println("fail");
				new HTMLReportHelper().HtmlReportBody("Create New Name", "Could not create name.", "Failed", driver, "Y");
			}
		}
	}

	public void finsihName() throws Exception{
		boolean stepResult = false;
		try {
			clickOnElement("New Name Page", "Finish Button", finishButton);
			Thread.sleep(2000);
			if (isElementPresent(msg))
			{
				stepResult = true;
			}
			switchToWindowWithTitleContaining("Institution 01 - REPUBLIC BANK UAT");

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if (stepResult == true) {
				System.out.println("Pass");
				new HTMLReportHelper().HtmlReportBody("Finish Name", "Finish name Successfully", "Passed", driver, "Y");
			} else {
				System.out.println("fail");
				new HTMLReportHelper().HtmlReportBody("Finish Name", "Could not finish name", "Failed", driver, "Y");
			}
		}
	}

	public void enterCustomerName(String name, String firstName, String lastName,String nameFormatCode ,String dob,String taxIDCode, String taxID,String withholdingCode,String alt_Name,String alt_FirstName,String alt_LastName,String alt_MiddleInitial,String alt_NameFormatCode) throws Exception{
		boolean stepResult = false;
		try {
			Thread.sleep(4000);
			driver.switchTo().frame("Main");
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
				new HTMLReportHelper().HtmlReportBody("Enter Customer Name Details", "Customer Name entered Successfully", "Passed", driver, "Y");
			} else {
				System.out.println("fail");
				new HTMLReportHelper().HtmlReportBody("Enter Customer Name Details", "Could not entered customer name details", "Failed", driver, "Y");
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
				new HTMLReportHelper().HtmlReportBody("Verify Duplicate Screen", "Duplicate Screen displayed Successfully", "Passed", driver, "Y");
			} else {
				System.out.println("fail");
				new HTMLReportHelper().HtmlReportBody("Verify Duplicate Screen", "Could Not verified Duplicate page", "Failed", driver, "Y");
			}
		}
	}

	public void enterContactMethod(String phoneNumber,String email,String webAddress,String phoneType,String emailType) throws Exception{
		boolean stepResult = false;
		String sDelimiter_phone,sDelimiter_email; 
		try {
			if (isElementPresent(contactMethodsLabel)) {
				Thread.sleep(2000);
				if (phoneNumber.contains(",")){
					sDelimiter_phone =",";
				}	
				else if (phoneNumber.contains("||")){
					sDelimiter_phone ="\\|\\|";
				}
				else{
					sDelimiter_phone ="\\|\\|";
				}

				if (email.contains(",")){
					sDelimiter_email =",";
				}	
				else if (phoneNumber.contains("||")){
					sDelimiter_email ="\\|\\|";
				}
				else{
					sDelimiter_email ="\\|\\|";
				}
				String[] sPhone_split = phoneNumber.split(sDelimiter_phone);
				for(int j=0;j<=sPhone_split.length-1;j++){
					if (phoneType.contains(sDelimiter_phone))
						selectElementByVisibleText("Change Name - Contact Methods Page", "Phone Type", selectPhoneType, phoneType.split(sDelimiter_phone)[j]);
					else
						selectElementByVisibleText("Change Name - Contact Methods Page", "Phone Type", selectPhoneType, phoneType);
					clickOnElement("New Name Page", "Phone Number", phoneNumLink);
					Thread.sleep(2500);
					//WebDriverWait wait1 = new WebDriverWait(driver, 20);
					//WebElement element1 = wait1.until(ExpectedConditions.elementToBeClickable(phoneNumVal));
					//element1.click();
					clickAfterWaitForElementToBeClickable("New Name - Contact Methods", "Phone Number", lastPhoneNumValue);
					enterText("New Name Page", "Phone Number", lastPhoneNumValue, phoneNumber.split(sDelimiter_phone)[j]);
					
				}
				String[] sEmail_split = email.split(sDelimiter_email);
				for(int j=0;j<=sEmail_split.length-1;j++){
					if (emailType.contains(sDelimiter_email))
						selectElementByVisibleText("New Name - Contact Methods ", "Mail Type", selectEmailType, emailType.split(sDelimiter_email)[j]);
					else
						selectElementByVisibleText("New Name - Contact Methods ", "Mail Type", selectEmailType, emailType);
					clickOnElement("New Name Page", "Email link", emailLink);
					//WebElement element2 = wait1.until(ExpectedConditions.elementToBeClickable(emailVal));
					//element2.click();
					Thread.sleep(2500);
					clickAfterWaitForElementToBeClickable("New Name - Contact Methods", "Email Address", lastemailidValue);
					enterText("New Name Page", "Email Address", lastemailidValue, email.split(sDelimiter_email)[j]);
					
				}
				if (!webAddress.equals("")) {
					clickOnElement("New Name Page", "Add Web Page Address", webAddresslink);
					//WebElement element3 = wait1.until(ExpectedConditions.elementToBeClickable(webAddressVal));
					//element3.click();
					clickAfterWaitForElementToBeClickable("New Name - Contact Methods", "Web Address", webAddressVal);
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
				new HTMLReportHelper().HtmlReportBody("Enter Details on Contact Method Page", "Details entered on Contact Method page Successfully", "Passed", driver, "Y");
			} else {
				System.out.println("fail");
				new HTMLReportHelper().HtmlReportBody("Enter Details on Contact Method Page", "Could Not entered Details on Contact method page", "Failed", driver, "Y");
			}

		}}

	public void addPhoneNumber(String phoneType, String phoneNumber) throws Exception {
		boolean stepResult = false;
		try {
			if (isElementPresent(contactMethodsLabel)){
				if(!phoneNumber.equals("")){
					selectElementByVisibleText("New Name - Contact Methods Page", "Phone Type", selectPhoneType, phoneType);
					clickOnElement("New Name - Contact Methods Page", "Add Phone link", phoneNumLink);
					clickAfterWaitForElementToBeClickable("New Name - Contact Methods Page", "Phone Number", lastPhoneNumValue);
					enterText("New Name - Contact Methods Page", "Phone Number", lastPhoneNumValue, phoneNumber);
				}
				stepResult = true;
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if (stepResult == true) {
				System.out.println("Pass");
				new HTMLReportHelper().HtmlReportBody("Add a phone number", "Phone Number added Successfully", "Passed", driver, "Y");
			} else {
				System.out.println("fail");
				new HTMLReportHelper().HtmlReportBody("Add a phone number", "Could not add Phone Number", "Failed", driver, "Y");
			}
		}
	}

	public void addEmail(String emailType, String mailid) throws Exception {
		boolean stepResult = false;
		try {
			if (isElementPresent(contactMethodsLabel)){
				if(!mailid.equals("")){
					selectElementByVisibleText("New Name - Contact Methods Page", "Mail Type", selectEmailType, emailType);
					clickOnElement("New Name - Contact Methods Page", "Add Email link", emailLink);
					clickAfterWaitForElementToBeClickable("New Name - Contact Methods Page", "Email Address", lastemailidValue);
					enterText("New Name - Contact Methods Page", "Phone Number", lastemailidValue, mailid);
				}
				stepResult = true;
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if (stepResult == true) {
				System.out.println("Pass");
				new HTMLReportHelper().HtmlReportBody("Add a E-mail Address", "E-mail Addressr added Successfully", "Passed", driver, "Y");
			} else {
				System.out.println("fail");
				new HTMLReportHelper().HtmlReportBody("Add a E-mail Address", "Could not add E-mail Address", "Failed", driver, "Y");
			}
		}
	}
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
				new HTMLReportHelper().HtmlReportBody("Enter Details on Code label Page", "Details entered on Code label page Successfully", "Passed", driver, "Y");
			} else {
				System.out.println("fail");
				new HTMLReportHelper().HtmlReportBody("Enter Details on Code label Page", "Could Not entered details on Code lable page", "Failed", driver, "Y");
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
				new HTMLReportHelper().HtmlReportBody("Enter details and Build Relationship", "Details entered and Relationship build Successfully", "Passed", driver, "Y");
			} else {
				System.out.println("fail");
				new HTMLReportHelper().HtmlReportBody("Enter details and Build Relationship", "Could not entered Details and Relationship build", "Failed", driver, "Y");
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
				new HTMLReportHelper().HtmlReportBody("Add SSN and Build Relationship", "Add SSN and Build Relationship Successfully", "Passed", driver, "Y");
			} else {
				System.out.println("fail");
				new HTMLReportHelper().HtmlReportBody("Add SSN and Build Relationship", "Could Not Add SSN and Build Relationship", "Failed", driver, "Y");
			}
		}}

	public void buildRelationship(String buildRelationship_SSN,String build_Relationship) throws Exception {
		boolean stepResult = false;
		String sDelimiter;
		try {
			if(isElementPresent(buildRelationshipLabel)){
				Thread.sleep(1000);
				if (!buildRelationship_SSN.equals("")) {
					if (buildRelationship_SSN.contains(",")){
						sDelimiter =",";
					}	
					else if (buildRelationship_SSN.contains("||")){
						sDelimiter ="\\|\\|";
					}
					else{
						sDelimiter ="\\|\\|";
					}
					String[] sbuildRelationship_SSN_split = buildRelationship_SSN.split(sDelimiter);
					for(int j=0;j<=sbuildRelationship_SSN_split.length-1;j++){

						clickOnElement("New Name - Relationship Page", "Add Name Image",addNameImage);
						switchToWindowWithTitleContaining("Add Name");
						driver.switchTo().frame("bottom");
						if (isElementPresent(SearchTitle)) {
							enterText("New Name - Search Page", "Enter SSN Field", BuildRelationshipSSN, sbuildRelationship_SSN_split[j]);
							clickOnElement("New Name - Search Page", "Submit Button",SubmitButton_SearchScreen);
							waitForPresenceOfElement("New Name - Search Page", "Searched Name List", NameList);
							clickOnElement("New Name - Search Page", "Searched Result Link",SearchResult);
							switchToWindowWithTitleContaining("Institution 01 - REPUBLIC BANK UAT");
							driver.switchTo().frame("Main");
						}
						if (!build_Relationship.equals("")) {
							Thread.sleep(2500);
							selectElementByVisibleText("New Name - Relationship Page", "Relationship field", lastRelationship, build_Relationship.split(sDelimiter)[j]);
							
						}
					}
				}	
				stepResult = true;
			}
		}catch(Exception e){
			e.printStackTrace();
		}finally {
			if (stepResult == true) {
				System.out.println("Pass");
				new HTMLReportHelper().HtmlReportBody("Add a Relationship", "Relationship added Successfully", "Passed", driver, "Y");
			} else {
				System.out.println("fail");
				new HTMLReportHelper().HtmlReportBody("Add a Relationship", "Could not add Relationship", "Failed", driver, "Y");
			}

		}
	}

	public void addDetailsOfBeneficiary(String beneficialOwnerName,String beneficial_Relationship,String beneficial_Percent) throws Exception {
		boolean stepResult = false;
		String sDelimiter;
		try {
			if(isElementPresent(buildRelationshipLabel)){
				Thread.sleep(1000);
				if (!beneficial_Relationship.equals("")) {
					if (beneficial_Relationship.contains(",")){
						sDelimiter =",";
					}	
					else if (beneficial_Relationship.contains("||")){
						sDelimiter ="\\|\\|";
					}
					else{
						sDelimiter ="\\|\\|";
					}
					
					
					String[] beneficial_Relationship_split = beneficial_Relationship.split(sDelimiter);
					for(int j=0;j<=beneficial_Relationship_split.length-1;j++){	
						if (beneficialOwnerName.contains(sDelimiter))
							selectElementByVisibleText("New Name - Relationship Page", "Beneficial Owner Name field", getDynamicElement("Beneficial Owner Name field",sBeneOwnerName,Integer.toString(j+1)), beneficialOwnerName.split(sDelimiter)[j]);
						else
							selectElementByVisibleText("New Name - Relationship Page", "Beneficial Owner Name field", getDynamicElement("Beneficial Owner Name field",sBeneOwnerName,Integer.toString(j+1)), beneficialOwnerName);
						if (!beneficial_Relationship.equals("")) {
							selectElementByVisibleText("New Name - Relationship Page", "Beneficial Relationship field", getDynamicElement("Beneficial Relationship field",sBeneRelationship,Integer.toString(j+1)), beneficial_Relationship.split(sDelimiter)[j]);
						}
						if (!beneficial_Percent.equals("")) {
							if(!beneficial_Percent.split(sDelimiter)[j].equals(""))
							enterText("New Name - Relationship Page", "Beneficial Percent Field", getDynamicElement("Beneficial Percent Field",sBenePercent,Integer.toString(j+1)), beneficial_Percent.split(sDelimiter)[j]);
							
						}
					}			
				}	
				stepResult = true;

			}
		}catch(Exception e){
			e.printStackTrace();
		}finally {
			if (stepResult == true) {
				System.out.println("Pass");
				new HTMLReportHelper().HtmlReportBody("Add a Beneficial Ownership", "Beneficial Ownership added Successfully", "Passed", driver, "Y");
			} else {
				System.out.println("fail");
				new HTMLReportHelper().HtmlReportBody("Add a Beneficial Ownership", "Could not add Beneficial Ownership", "Failed", driver, "Y");
			}

		}
	}




}


